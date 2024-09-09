/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Balto
 */
class ArbolAVL {

    NodoAVL raiz;

    // Obtener la altura de un nodo
    int altura(NodoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    // Rotación simple a la derecha
    NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        // Realizar la rotación
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar las alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        // Retornar la nueva raíz
        return x;
    }
    
    // Rotación simple a la izquierda
    NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        // Realizar la rotación
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        // Retornar la nueva raíz
        return y;
    }

    // Método modular para manejar los casos de desbalance
    NodoAVL balancear(NodoAVL nodo, int valor) {
        int balance = obtenerBalance(nodo);

        // Caso 1: Izquierda-Izquierda (LL)
        if (balance > 1 && valor < nodo.izquierdo.valor) {
            return rotacionDerecha(nodo);
        }

        // Caso 2: Derecha-Derecha (RR)
        if (balance < -1 && valor > nodo.derecho.valor) {
            return rotacionIzquierda(nodo);
        }

        // Caso 3: Izquierda-Derecha (LR)
        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        // Caso 4: Derecha-Izquierda (RL)
        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo; // Si no está desbalanceado, devolver el nodo tal como está
    }


    int obtenerBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierdo) - altura(N.derecho);
    }

    NodoAVL insertar(NodoAVL nodo, int valor) {

        // Insertar de manera normal (como en un árbol binario de búsqueda)
        if (nodo == null)
            return (new NodoAVL(valor));
        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else 
            return nodo;

        //altura del nodo
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Obtener el balance 
        int balance = obtenerBalance(nodo);

        // Rotación derecha (caso izquierda-izquierda)
        if (balance > 1 && valor < nodo.izquierdo.valor)
            return rotacionDerecha(nodo);

        return nodo;
    }

    //imprimir los nodos en orden (izquierdo-raíz-derecho)
    void recorrerEnOrden(NodoAVL nodo) {
        if (nodo != null) {
            recorrerEnOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorrerEnOrden(nodo.derecho);
        }
    }

    // iniciar la inserción
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // iniciar el recorrido en orden
    public void recorrerEnOrden() {
        recorrerEnOrden(raiz);
    }

   
}

