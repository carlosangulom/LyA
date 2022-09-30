import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"
Comilla = [']
Gato = [#]
Ampersand = [&]
Punto = [.]
Coma = [,]
Simbolo = [ .,=()<>#{}+-;:&]
Asignacion = [=]
Delimitador = [;]
Plus = [+]
Minus = [-]
DosPuntos = [:]

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Números */
Entero = 0 | [1-9][0-9]*
Decimal = {Digito}({Digito})*{Punto}{Digito}({Digito})* 
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

//Identificador
\?{Identificador} {return token(yytext(), "Identificador", yyline, yycolumn);}

//Tipos de datos
ent {return token(yytext(), "Tipo_Entero", yyline, yycolumn);} 
flot {return token(yytext(), "Tipo_Flotante", yyline, yycolumn);}
med {return token(yytext(), "Tipo_Medicamento", yyline, yycolumn);}

// Números
{Entero} {return token(yytext(), "Entero", yyline, yycolumn);}
{Decimal} {return token(yytext(), "Decimal", yyline, yycolumn);}

// Operadores de agrupación
"(" {return token(yytext(), "Paréntesis_A", yyline, yycolumn);}
")" {return token(yytext(), "Paréntesis_C", yyline, yycolumn);}
"{" {return token(yytext(), "Llaves_A", yyline, yycolumn);}
"}" {return token(yytext(), "Llaves_C", yyline, yycolumn);}
"<" {return token(yytext(), "Menor_que", yyline, yycolumn);}
">" {return token(yytext(), "Mayor_que", yyline, yycolumn);}
"[" {return token(yytext(), "Square_A", yyline, yycolumn);}
"]" {return token(yytext(), "Square_C", yyline, yycolumn);}

// Signos puntuación
{Coma} {return token(yytext(), "Coma", yyline, yycolumn);}
{Delimitador} {return token(yytext(), "Delimitador", yyline, yycolumn);}
{DosPuntos} {return token(yytext(), "Dos_Puntos", yyline, yycolumn);}

// Asignación
{Asignacion} {return token(yytext(), "Dos_Puntos", yyline, yycolumn);}

// Ciclos
while {return token(yytext(), "While", yyline, yycolumn);}
for {return token(yytext(), "For", yyline, yycolumn);}

// Condicionales
if | else | ifnot {return token(yytext(), "Condicional", yyline, yycolumn);}

// Operadores lógicos
"&&" | "|" | "!" | "!=" | "==" {return token(yytext(), "OP_Lógico", yyline, yycolumn);}

. { return token(yytext(), "ERROR", yyline, yycolumn); }