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
Times = ["*"]
DosPuntos = [:]

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Números */
Entero = ({Digito})*
Decimal = {Digito}({Digito})*{Punto}{Digito}({Digito})* 

/* Cadena */
ContenidoCadena = ( [^*] | \*+ [^/*] )*

%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

//Identificador
    \?{Identificador} {return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);}

//Tipos de datos
ent {return token(yytext(), "TIPO_ENTERO", yyline, yycolumn);} 
dec {return token(yytext(), "TIPO_DECIMAL", yyline, yycolumn);}
med {return token(yytext(), "TIPO_MEDICAMENTO", yyline, yycolumn);}
str {return token(yytext(), "TIPO_CADENA", yyline, yycolumn);}

// Números
{Entero} {return token(yytext(), "NUMERO_ENTERO", yyline, yycolumn);}
{Decimal} {return token(yytext(), "NUMERO_DECIMAL", yyline, yycolumn);}

// Cadena
{Comilla}{ContenidoCadena}{Comilla} {return token(yytext(), "CADENA", yyline, yycolumn);}

// Operadores de agrupación
"(" {return token(yytext(), "PARENTESIS_A", yyline, yycolumn);}
")" {return token(yytext(), "PARENTESIS_C", yyline, yycolumn);}
"{" {return token(yytext(), "LLAVES_A", yyline, yycolumn);}
"}" {return token(yytext(), "LLAVES_C", yyline, yycolumn);}
"<" {return token(yytext(), "MENOR_QUE", yyline, yycolumn);}
">" {return token(yytext(), "MAYOR_QUE", yyline, yycolumn);}
"[" {return token(yytext(), "SQUARE_A", yyline, yycolumn);}
"]" {return token(yytext(), "SQUARE_C", yyline, yycolumn);}

// Signos puntuación
{Coma} {return token(yytext(), "COMA", yyline, yycolumn);}
{Delimitador} {return token(yytext(), "DELIMITADOR", yyline, yycolumn);}
{DosPuntos} {return token(yytext(), "DOS_PUNTOS", yyline, yycolumn);}

// Asignación
{Asignacion} {return token(yytext(), "ASIGNACION", yyline, yycolumn);}

// Ciclos
while {return token(yytext(), "CICLO_WHILE", yyline, yycolumn);}
for {return token(yytext(), "CICLO_FOR", yyline, yycolumn);}

// Condicionales
if | else | ifnot {return token(yytext(), "CONDICIONAL", yyline, yycolumn);}

// Operadores lógicos
"&&" | "|" | "!" | "!=" | "==" {return token(yytext(), "OP_LOGICO", yyline, yycolumn);}

// Operadores aritméticos
{Plus} | {Minus} | {Times} {return token(yytext(), "OP_ARITMETICO", yyline, yycolumn);}

// Funciones
fun {return token(yytext(), "FUNCION", yyline, yycolumn);}

// errores
{Identificador} {return token(yytext(), "ERROR_1", yyline, yycolumn);} //Identificador erróneo

. { return token(yytext(), "ERROR_0", yyline, yycolumn); }