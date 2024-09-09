/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Balto
 */
public class Mainnodo {
  public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

       arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(10);
        arbol.insertar(5);  // Provocará un desbalance 
        arbol.insertar(3);  // Provocará otra rotación

        // Recorrido en orden
        System.out.println("Recorrido en orden del árbol AVL:");
        arbol.recorrerEnOrden();
    }
}
