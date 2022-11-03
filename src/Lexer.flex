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
Espacio = [ \t\f]
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
Entero = {Digito}({Digito})*
Decimal = {Digito}({Digito})*{Punto}{Digito}({Digito})* 

/* Cadena */
ContenidoCadena = ({Espacio}|{Simbolo}|{Letra}|{Digito})*

// Horas
Hora = ([0-1]?[0-9]|2[0-3]):[0-5][0-9]
Hora2 = (2[4]):[0][0]


//Días
Dias = (L|M|W|J|V|S|D)(\s*,\s*(L|M|W|J|V|S|D))*
Dias2 = (L|M|W|J|V|S|D)

//Errores
Error1 = {Letra}({Gato}|{Ampersand})({Letra}|{Digito}|{Gato}|{Ampersand})*
Error2 = {Comilla}
Error3 = {Comilla}{ContenidoCadena}
Error4 = ({Gato}|{Ampersand}|{Punto})({Gato}|{Ampersand}|{Punto})*
Error5 = {Digito}({Letra}|{Gato}|{Ampersand})({Letra}|{Gato}|{Ampersand}|{Digito})*
Error6 = {Digito}({Letra}|{Gato}|{Ampersand})({Letra}|{Gato}|{Ampersand}|{Digito})*{Punto}{Digito}({Digito})*|
         {Digito}({Letra}|{Gato}|{Ampersand})({Letra}|{Gato}|{Ampersand}|{Digito})*{Punto}|
         {Digito}({Digito})*{Punto}|
         {Digito}({Digito})*{Punto}({Letra}|{Gato}|{Ampersand}|{Digito})({Letra}|{Gato}|{Ampersand}|{Digito})*|
         {Digito}({Letra}|{Gato}|{Ampersand})({Letra}|{Gato}|{Ampersand}{Digito})*{Punto}({Letra}|{Gato}|{Ampersand}|{Digito})({Letra}|{Gato}|{Ampersand}|{Digito})*
Error7 = {Dias2}{Coma}({Dias2}{Coma})*

%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

//Tipos de datos
ent {return token(yytext(), "TIPO_ENTERO", yyline, yycolumn);} 
dec {return token(yytext(), "TIPO_DECIMAL", yyline, yycolumn);}
med {return token(yytext(), "TIPO_MEDICAMENTO", yyline, yycolumn);}
str {return token(yytext(), "TIPO_CADENA", yyline, yycolumn);}
bool {return token(yytext(), "TIPO_BOOL", yyline, yycolumn);}
hora {return token(yytext(), "TIPO_HORA", yyline, yycolumn);}
dias {return token(yytext(), "TIPO_DIAS", yyline, yycolumn);}
rutina {return token(yytext(), "TIPO_RUTINA", yyline, yycolumn);}

// Ciclos
while {return token(yytext(), "CICLO_WHILE", yyline, yycolumn);}
for {return token(yytext(), "CICLO_FOR", yyline, yycolumn);}

// Condicionales
if | else | ifnot {return token(yytext(), "CONDICIONAL", yyline, yycolumn);}

//Bool
true | false {return token(yytext(), "BOOL", yyline, yycolumn);}

//Horas
{Hora} | {Hora2} {return token(yytext(), "HORA", yyline, yycolumn);}

//Días
{Dias} {return token(yytext(), "DIAS", yyline, yycolumn);}

//Identificador
{Identificador} {return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);}

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

// Operadores lógicos
"&&" | "|" | "!" | "!=" | "==" {return token(yytext(), "OP_LOGICO", yyline, yycolumn);}

// Operadores aritméticos
{Plus} | {Minus} | {Times} {return token(yytext(), "OP_ARITMETICO", yyline, yycolumn);}

// errores
{Error1} {return token(yytext(), "ERROR_1", yyline, yycolumn);}
{Error2} {return token(yytext(), "ERROR_2", yyline, yycolumn);}
{Error3} {return token(yytext(), "ERROR_3", yyline, yycolumn);}
{Error4} {return token(yytext(), "ERROR_4", yyline, yycolumn);}
{Error5} {return token(yytext(), "ERROR_5", yyline, yycolumn);}
{Error6} {return token(yytext(), "ERROR_6", yyline, yycolumn);}
{Error7} {return token(yytext(), "ERROR_7", yyline, yycolumn);}

. { return token(yytext(), "ERROR_X", yyline, yycolumn); }