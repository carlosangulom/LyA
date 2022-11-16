
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
    Token Incremento;
    Token Llave1;
    Token Llave2;
    Token Valor1;
    Token Valor2;
    Token OperadorLogico;
    Token While;
    Producciones Produccion1;
    Producciones Produccion2;
    Producciones Produccion3;
    Producciones Produccion4;
    Producciones Produccion5;
    //De Asignacion
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
        this.Hora2 = Hora5;
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
    //De Asignacion a Rutina 1
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
    //De Asignacion a Rutina 2
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token Parentesis1,Token MenorQue,Token Cadena,Token Coma1,Token Entero1,Token Coma2,Token Entero2,Token MayorQue,Token Coma3,Token Dias,Token Coma4,Token Hora,Token Coma5,Token Bool,Token Parentesis2,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.Parentesis1 = Parentesis1;
        this.MenorQue = MenorQue;
        this.Cadena = Cadena;
        this.Coma1 = Coma1;
        this.Entero1 = Entero1;
        this.Coma2 = Coma2;
        this.Entero2 = Entero2;
        this.MayorQue = MayorQue;
        this.Coma3 = Coma3;
        this.Dias = Dias;
        this.Coma4 = Coma4;
        this.Hora = Hora;
        this.Coma5 = Coma5;
        this.Bool = Bool;
        this.Parentesis2 = Parentesis2;
        this.Delimitador = Delimitador;
    }
    //De Ciclos for
    Producciones(Token For,Token Parentesis1,Token TipoDeDato,Token Identificador,Token Asignacion,Token ValorDeDato,Token Delimitador,Token Valor1,Token OperadorLogico,Token Valor2,Token Delimitador2,Token Identificador2,Token Incremento,Token Parentesis2,Token Llave1,Producciones Produccion1,Producciones Produccion2,Producciones Produccion3,Producciones Produccion4,Producciones Produccion5,Token Llave2){
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
        this.Delimitador2 = Delimitador2;
        this.Identificador2 = Identificador2;
        this.Incremento = Incremento;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Produccion1 = Produccion1;
        this.Produccion2 = Produccion2;
        this.Produccion3 = Produccion3;
        this.Produccion4 = Produccion4;
        this.Produccion5 = Produccion5;
        this.Llave2 = Llave2;
    }
    //De Ciclos while
     Producciones(Token While,Token Parentesis1,Token Valor1,Token OperadorLogico,Token Valor2,Token Parentesis2,Token Llave1,Producciones Produccion1,Producciones Produccion2,Producciones Produccion3,Producciones Produccion4,Producciones Produccion5,Token Identificador,Token Incremento,Token Delimitador,Token Llave2){
        this.While = While;
        this.Parentesis1 = Parentesis1;
        this.Valor1 = Valor1;
        this.OperadorLogico = OperadorLogico;
        this.Valor2 = Valor2;
        this.Parentesis2 = Parentesis2;
        this.Llave1 = Llave1;
        this.Produccion1 = Produccion1;
        this.Produccion2 = Produccion2;
        this.Produccion3 = Produccion3;
        this.Produccion4 = Produccion4;
        this.Produccion5 = Produccion5;
        this.Identificador = Identificador;
        this.Incremento = Incremento;
        this.Delimitador= Delimitador;
        this.Llave2 = Llave2;
    }
}
