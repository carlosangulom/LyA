
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
    Token Asignacion;
    Token ValorDeDato;
    Token Delimitador;
    
    public Producciones(Token TipoDeDato,Token Identificador,Token Asignacion,Token ValorDeDato,Token Delimitador){
        this.TipoDeDato = TipoDeDato;
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
        this.ValorDeDato = ValorDeDato;
        this.Delimitador = Delimitador;
    }
}
