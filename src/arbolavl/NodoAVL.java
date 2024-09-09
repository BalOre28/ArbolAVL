/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Balto
 */
class NodoAVL {
    int valor;
    int altura;
    NodoAVL izquierdo, derecho;

    NodoAVL(int d) {
        valor = d;
        altura = 1; // Al crear un nodo, su altura es 1
    }
}
