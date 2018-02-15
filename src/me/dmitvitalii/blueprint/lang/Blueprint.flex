package me.dmitvitalii.blueprint.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import me.dmitvitalii.blueprint.lang.psi.BlueprintType;
%%

%{
    public BlueprintLexer() {
        this((java.io.Reader) null); // FIXME: workaround to avoid build issues, unused anyway
    }
%}

%class BlueprintLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT = ("//") [^\r\n]*
MULTILINE_COMMENT = "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                         { yybegin(YYINITIAL);     return BlueprintType.COMMENT; }
<YYINITIAL> {KEY_CHARACTER}+                              { yybegin(YYINITIAL);     return BlueprintType.KEY; }
<YYINITIAL> {SEPARATOR}                                   { yybegin(WAITING_VALUE); return BlueprintType.SEPARATOR; }
<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+             { yybegin(YYINITIAL);     return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                            { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}* { yybegin(YYINITIAL);     return BlueprintType.VALUE; }
({CRLF}|{WHITE_SPACE})+                                   { yybegin(YYINITIAL);     return TokenType.WHITE_SPACE; }
.                                                         {                         return TokenType.BAD_CHARACTER; }

