package me.dmitvitalii.blueprint.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static me.dmitvitalii.blueprint.lang.psi.BlueprintType.*;

%%

%{
  public BlueprintLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class BlueprintLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
LINE_COMMENT="//".*
MULTILINE_COMMENT="/"\*([^*]|\*+[^*/])*(\*+"/")?
STRING=\"[^\"]*\"
NUMBER=-?(0|[1-9][0-9]*)(\.[0-9]+)?([eE][+-]?[0-9]*)?
WS=[ \t\n\f\r]+

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "{"                      { return LEFT_BRACE; }
  "}"                      { return RIGHT_BRACE; }
  "["                      { return LEFT_BRACKET; }
  "]"                      { return RIGHT_BRACKET; }
  ","                      { return COMMA; }
  "="                      { return ASSIGN; }
  ":"                      { return COLON; }
  "+="                     { return PLUS_ASSIGN; }
  "+"                      { return PLUS; }
  "-"                      { return MINUS; }

  {IDENTIFIER}             { return IDENTIFIER; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {MULTILINE_COMMENT}      { return MULTILINE_COMMENT; }
  {STRING}                 { return STRING; }
  {NUMBER}                 { return NUMBER; }
  {WS}                     { return WS; }

}

[^] { return BAD_CHARACTER; }
