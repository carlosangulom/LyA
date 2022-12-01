
import compilerTools.Token;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chuy4
 */
public class Producciones {
    Token Token;
    Token TipoDeDato;
    Token Identificador;
    Token Identificador2;
    Token Asignacion;
    Token ValorDeDato;
    Token Delimitador;
    Token Delimitador2;
    Token MenorQue;
    Token MayorQue;
    Token Cadena;
    Token Entero1;
    Token Entero2; 
    Token Medicamento;
    Token Dias;
    Token Hora;
    Token Hora2;
    Token Hora3;
    Token Hora4;
    Token Hora5;
    Token Bool;
    Token Coma1;
    Token Coma2;
    Token Coma3;
    Token Coma4;
    Token Coma5;
    Token Parentesis1;
    Token Parentesis2;
    Token For;
    Token Llave1;
    Token Llave2;
    Token Llave3;
    Token Llave4;
    Token Valor1;
    Token Valor2;
    Token OperadorLogico;
    Token While;
    Token If;
    Token Else;
    int contador;
    //MANDAR A LLAMAR UNA ASIGNACION
    public Producciones(Token MenorQue,Token Identificador,Token MayorQue,Token Delimitador){
        this.MenorQue = MenorQue;
        this.Identificador = Identificador;
        this.MayorQue = MayorQue;
        this.Delimitador = Delimitador;
    }
    //De Asignacion ENT/BOOL/STR
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token ValorDeDato,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.ValorDeDato = ValorDeDato;
        this.Delimitador = Delimitador;
    }
    //De Asignacion a dias
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token MenorQue,Token Dias,Token MayorQue,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.MenorQue = MenorQue;
        this.Dias = Dias;
        this.MayorQue = MayorQue;
        this.Delimitador = Delimitador;
    }
    //De Asignacion Hora 5
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token MenorQue,
                        Token Hora,Token Coma1,
                        Token Hora2,Token Coma2,
                        Token Hora3,Token Coma3,
                        Token Hora4,Token Coma4,
                        Token Hora5,Token MayorQue,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.MenorQue = MenorQue;
        this.Hora = Hora;
        this.Coma1 = Coma1;
        this.Hora2 = Hora2;
        this.Coma2 = Coma2;
        this.Hora3 = Hora3;
        this.Coma3 = Coma3;
        this.Hora4 = Hora4;
        this.Coma4 = Coma4;
        this.Hora5 = Hora5;
        this.MayorQue = MayorQue;
        this.Delimitador = Delimitador;
    
    }
    
    //De Asignacion a Medicamentos
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token MenorQue,Token Cadena,Token Coma1,Token Entero1,Token Coma2,Token Entero2,Token MayorQue,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.MenorQue = MenorQue;
        this.Cadena = Cadena;
        this.Coma1 = Coma1;
        this.Entero1 = Entero1;
        this.Coma2 = Coma2;
        this.Entero2 = Entero2;
        this.MayorQue = MayorQue;
        this.Delimitador = Delimitador;
    }
    //De Asignacion a Rutina
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token Parentesis1,Token Medicamento,Token Coma1,Token Dias,Token Coma2,Token Hora,Token Coma3,Token Bool,Token Parentesis2,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.Parentesis1 = Parentesis1;
        this.Medicamento = Medicamento;
        this.Coma1 = Coma1;
        this.Dias = Dias;
        this.Coma2 = Coma2;
        this.Hora = Hora;
        this.Coma3 = Coma3;
        this.Bool = Bool;
        this.Parentesis2 = Parentesis2;
        this.Delimitador = Delimitador;
    }
    //De Ciclos for
    Producciones(Token For,Token Parentesis1,Token TipoDeDato,Token Identificador,Token Asignacion,Token ValorDeDato,Token Delimitador,Token Valor1,Token OperadorLogico,Token Valor2,Token Parentesis2,Token Llave1,Token Llave2,Token Delimitador2){
        this.For = For;
        this.Parentesis1 = Parentesis1;
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.ValorDeDato = ValorDeDato;
        this.Delimitador = Delimitador;
        this.Valor1 = Valor1;
        this.OperadorLogico = OperadorLogico;
        this.Valor2 = Valor2;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Llave2 = Llave2;
        this.Delimitador2 = Delimitador2;
    }
    //De Ciclos while
     Producciones(Token While,Token Parentesis1,Token Valor1,Token Parentesis2,Token Llave1,Token Llave2){
        this.While = While;
        this.Parentesis1 = Parentesis1;
        this.Valor1 = Valor1;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Llave2 = Llave2;
    }
    //DE CONDICIONAL IF SOLO IF/IFNOT
    Producciones(Token If,Token Parentesis1,Token Valor1,Token OperadorLogico,Token Valor2,Token Parentesis2,Token Llave1,Token Llave2,Token Delimitador){
        this.If = If;
        this.Parentesis1 = Parentesis1;
        this.Valor1 = Valor1;
        this.OperadorLogico = OperadorLogico;
        this.Valor2 = Valor2;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Llave2 = Llave2;
        this.Delimitador = Delimitador;
    }
    //DE CONDICIONAL IF/IFNOT CON ELSE
    Producciones(Token If,Token Parentesis1,Token Valor1,Token OperadorLogico,Token Valor2,Token Parentesis2,Token Llave1,Token Llave2,Token Else,Token Llave3,Token Llave4,Token Delimitador){
        this.If = If;
        this.Parentesis1 = Parentesis1;
        this.Valor1 = Valor1;
        this.OperadorLogico = OperadorLogico;
        this.Valor2 = Valor2;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Llave2 = Llave2;
        this.Else = Else;
        this.Llave3 = Llave3;
        this.Llave4 = Llave4;
        this.Delimitador = Delimitador;
    } 
}
