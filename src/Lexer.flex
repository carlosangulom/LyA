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
Coma = [,]
Simbolo = [ .,=()<>#{}+-;:&]
Asignacion = [=]
Delimitador = [;]
DosPuntos = [:]

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Números */
Entero = {Digito}({Digito})*

/* Cadena */
ContenidoCadena = ({Espacio}|{Simbolo}|{Letra}|{Digito})*

// Horas
Hora = ([0-1]?[0-9]|2[0-3]):[0-5][0-9]
Hora2 = (2[4]):[0][0]
Hora3 = (2[4]):[0-9][1-9]
Hora4 = (2[4]):
Hora5 = ([0-1]?[0-9]|2[0-3]):[6-9][0-9]
Hora6 = ([0-1]?[0-9]|2[0-3]):
Hora7 = ([2][5-9]|[3-9][0-9]):[0-9][0-9]

//Días
Dias = (L|M|W|J|V|S|D)(\s*,\s*(L|M|W|J|V|S|D))*
Dias2 = (L|M|W|J|V|S|D)

//Errores
Error1 = {Letra}({Gato}|{Ampersand})({Letra}|{Digito}|{Gato}|{Ampersand})*
Error2 = {Comilla}
Error3 = {Comilla}{ContenidoCadena}
Error4 = ({Gato}|{Ampersand})({Gato}*|{Ampersand}{Ampersand}*)({Gato}*|{Ampersand}{Ampersand}*)*
Error5 = {Digito}({Letra}|{Gato}|{Ampersand})({Letra}|{Gato}|{Ampersand}|{Digito})*
Error6 = {Dias2}{Coma}({Dias2}{Coma})*
Error7 = {Hora3}|{Hora4}|{Hora5}|{Hora6}
Error8 = {Hora7}

%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

//Tipos de datos
ent {return token(yytext(), "TIPO_ENTERO", yyline, yycolumn);} 
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

// errores
{Error1} {return token(yytext(), "ERROR_1", yyline, yycolumn);}
{Error2} {return token(yytext(), "ERROR_2", yyline, yycolumn);}
{Error3} {return token(yytext(), "ERROR_3", yyline, yycolumn);}
{Error4} {return token(yytext(), "ERROR_4", yyline, yycolumn);}
{Error5} {return token(yytext(), "ERROR_5", yyline, yycolumn);}
{Error6} {return token(yytext(), "ERROR_6", yyline, yycolumn);}
{Error7} {return token(yytext(), "ERROR_7", yyline, yycolumn);}
{Error8} {return token(yytext(), "ERROR_8", yyline, yycolumn);}

. { return token(yytext(), "ERROR_X", yyline, yycolumn); }