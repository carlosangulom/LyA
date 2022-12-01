import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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

/* Número */
Entero = 0 | [1-9][0-9]*

/* Cadena */
ContenidoCadena = ({Espacio}|{Simbolo}|{Letra}|{Digito})*

//Horas
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
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

//Errores
Error1 { /*ignorar*/ }
Error2 { /*ignorar*/ }
Error3 { /*ignorar*/ }
Error4 { /*ignorar*/ }
Error5 { /*ignorar*/ }
Error6 { /*ignorar*/ }
Error7 { /*ignorar*/ }
Error8 { /*ignorar*/ }

// Valores
{Entero} | {Hora} | {Dias} | true | false { return textColor(yychar, yylength(), new Color(245, 169, 127)); }

//Tipos de datos
ent | med | str | hora | dias | rutina | bool { return textColor(yychar, yylength(), new Color(138, 173, 244)); }

// Control
while | for | if | else | ifnot { return textColor(yychar, yylength(), new Color(166, 218, 149)); }

//Identificador
\?{Identificador} { return textColor(yychar, yylength(), new Color(237, 135, 150)); }

// Operadores lógicos
"&&" | "|" | "!" | "!=" | "==" { return textColor(yychar, yylength(), new Color(238, 212, 159)); }

//Cadena
{Comilla}{ContenidoCadena}{Comilla} { return textColor(yychar, yylength(), new Color(137, 220, 235)); }

. { /*ignorar*/ }