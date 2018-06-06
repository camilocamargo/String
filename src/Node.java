/**
 *
 * @author Camilo Camargo
 */
public class Node {

    // Attributes:
    char character;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node() {}

    //nodo:
    public Node(char character) {
        this.character = character;
    }

    // metodo to string
    public String toString() {
        return character+" ";
    }

    public Node clone() {
        Node clone = new Node(this.character);
        return clone;
    }
    
}
