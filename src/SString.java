
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * Class String (list of char).
 */

/**
 *
 * @author Camilo Camargo
 */
public class SString {
    Node head = null; //empty list
    
    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }
    
    public int size() {
        int size = 0;
        Node temp = head;
        if (isEmpty()) {
            return size = 0;
        }
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }

        return ++size;
    }
    
    public void insertAtEnd(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }
    
    public void insertAtIndex(Node newNode, int Index) {
        Node temp;
        Node pre = head;
        for (int i = 0; i < Index - 1; i++) {
            pre.next = pre;
        }
        temp = pre.next;
        newNode.next = temp;
        pre.next = newNode;
    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void deleteAtBegin() {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void deleteAtEnd() {
        Node temp;
        Node pre = head;
        while (pre.next.next != null) {
            pre = pre.next;
        }
        temp = pre.next;
        pre.next = null;
        temp = null;
        System.gc();
    }
    
    public void printCharList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (temp != null) {
            bw.write(temp.toString());
            temp = temp.next;
        }
        bw.flush();
    }
    
    public void concat(SString charlist){
        Node temp = head;
        while(temp.next != null)//find the end of the list
            temp = temp.next;
        temp.next = charlist.head;
    }
    
    public SString subString(int lower, int higher){
        SString tempCharList = new SString();
        Node temp = head;
        for (int i = 0; i < lower; i++) {//find the lower index
            temp = temp.next;
        }
        for(int i = lower; i <= higher; i++){
            tempCharList.insertAtEnd(temp.clone());
            temp = temp.next;
        }
        return tempCharList;
    }
    
    public boolean contains(char c){
        boolean contains = false;
        Node temp = head;
        while(temp.next != null){
            if(temp.character == c){
                return contains = true;
            }
            temp = temp.next;
        }
        
        return contains;
    }
    
    public boolean contains(String chain){
        boolean contains = false;
        Node temp = head;
        int i = 0;
        while (temp.next != null){
            if (temp.character == chain.charAt(0)){
                contains = true;
                i = 0;
                while(i < chain.length() && temp.next != null){
                    if (temp.character != chain.charAt(i)){
                        contains = false;
                    }
                    i++;
                    temp = temp.next;
                }
            }
            if(temp.next != null)
                temp = temp.next;
        }
        
        return contains;
    }
    
    public String[] split (char regex){
        Node temp = head;
        int divisions = 0, i = 0;
        while(temp.next != null){
            if(temp.character == regex){
                divisions++;
            }
            temp = temp.next;            
        }
        String[] splited = new String[++divisions];
        
        temp = head;
        while(temp.next != null){
            String aux ="";
            while(temp.character != regex && temp.next!= null){
                aux += temp.character;
                if(temp.next != null)
                    temp = temp.next;
                if(temp.next == null){
                    aux += temp.character;
                }
            }
            splited[i++] = aux;
            if(temp.next != null)
                temp = temp.next;
        }
        return splited;
    }
    
    public static void main(String[] args) throws IOException {
        SString string = new SString();
        string.insertAtBegin(new Node('c'));
        string.insertAtEnd(new Node('a'));
        string.insertAtEnd(new Node('m'));
        string.insertAtEnd(new Node('i'));
        string.insertAtEnd(new Node('l'));
        string.insertAtEnd(new Node('o'));
        string.insertAtEnd(new Node('Z'));
        
        SString string2 = new SString();
        
        string2.insertAtBegin(new Node('a'));
        string2.insertAtEnd(new Node('n'));
        string2.insertAtEnd(new Node('d'));
        string2.insertAtEnd(new Node('r'));
        string2.insertAtEnd(new Node('e'));
        string2.insertAtEnd(new Node('s'));
        
        SString temp = new SString();
        
        string.concat(string2);
        
        string.printCharList();
        System.out.println("");
        string2.printCharList();
        
        System.out.println("");
        temp = string.subString(2, 5);
        temp.printCharList();
        System.out.println("\n"+string.contains("res"));
        
        String[] splited = string.split('Z');
        System.out.println(splited[0] + " " + splited[1]);
    }
}
