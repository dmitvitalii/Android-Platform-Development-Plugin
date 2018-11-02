package me.dmitvitalii.makefile.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static me.dmitvitalii.makefile.lang.psi.MakefileType.*;

%%

%{
  public _MakefileLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class MakefileLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
LINE_COMMENT="//".*
MULTILINE_COMMENT="/"\*([^*]|\*+[^*/])*(\*+"/")?
ONE_QUOTE_STRING='[^']*'
TWO_QUOTES_STRING=\"[^\"]*\"
NUMBER=-?(0|[1-9][0-9]*)(\.[0-9]+)?([eE][+-]?[0-9]*)?
WS=[ \t\n\f\r]+

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "("                      { return PARENTHESIS_START; }
  ")"                      { return PARENTHESIS_END; }
  ","                      { return COMMA; }
  ":"                      { return COLON; }
  "="                      { return ASSIGN; }
  "+="                     { return PLUS_ASSIGN; }
  ":="                     { return COLON_ASSIGN; }
  "+"                      { return PLUS; }
  "-"                      { return MINUS; }
  "/"                      { return SLASH; }
  "\\"                     { return BACKSLASH; }
  ";"                      { return SEMICOLON; }
  "$("                     { return CALLEE_START; }
  ")"                      { return CALLEE_END; }
  "include"                { return KEYWORD_INCLUDE; }
  "-include"               { return KEYWORD_MINCLUDE; }
  "sinclude"               { return KEYWORD_CINCLUDE; }
  "define"                 { return KEYWORD_DEFINE; }
  "ifdef"                  { return KEYWORD_IFDEF; }
  "ifndef"                 { return KEYWORD_IFNDEF; }
  "ifeq"                   { return KEYWORD_IFEQ; }
  "ifneq"                  { return KEYWORD_IFNEQ; }
  "else"                   { return KEYWORD_ELSE; }
  "endif"                  { return KEYWORD_ENDIF; }
  "endef"                  { return KEYWORD_ENDEF; }
  "override"               { return KEYWORD_OVERRIDE; }
  "export"                 { return KEYWORD_EXPORT; }
  "unexport"               { return KEYWORD_UNEXPORT; }
  "STRING"                 { return STRING; }

  {IDENTIFIER}             { return IDENTIFIER; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {MULTILINE_COMMENT}      { return MULTILINE_COMMENT; }
  {ONE_QUOTE_STRING}       { return ONE_QUOTE_STRING; }
  {TWO_QUOTES_STRING}      { return TWO_QUOTES_STRING; }
  {NUMBER}                 { return NUMBER; }
  {WS}                     { return WS; }

}

[^] { return BAD_CHARACTER; }
