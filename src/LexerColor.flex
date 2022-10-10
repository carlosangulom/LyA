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

/* Número */
Entero = 0 | [1-9][0-9]*
Decimal = {Digito}({Digito})*{Punto}{Digito}({Digito})* 

/* Cadena */
ContenidoCadena = ( [^*] | \*+ [^/*] )*

%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

//Identificador
\?{Identificador} { return textColor(yychar, yylength(), new Color(237, 135, 150)); }

//Tipos de datos
ent | dec | med | str { return textColor(yychar, yylength(), new Color(138, 173, 244)); }

// Números
{Entero} | {Decimal} { return textColor(yychar, yylength(), new Color(245, 169, 127)); }

// Control
while | for | if | else | ifnot { return textColor(yychar, yylength(), new Color(166, 218, 149)); }

// Función
fun { return textColor(yychar, yylength(), new Color(203, 166, 247)); }

// Operadores lógicos
"&&" | "|" | "!" | "!=" | "==" { return textColor(yychar, yylength(), new Color(238, 212, 159)); }

// Operadores aritméticos
{Plus} | {Minus} | {Times} | {Asignacion} { return textColor(yychar, yylength(), new Color(245, 194, 231)); }

//Cadena
{Comilla}{ContenidoCadena}{Comilla} { return textColor(yychar, yylength(), new Color(137, 220, 235)); }

. { /*ignorar*/ }