package SDA;
import org.w3c.dom.Node;

class NodeLink
{
    int nilai;
    NodeLink next;

    public NodeLink(int n,NodeLink nex)
    {
        nilai=n;
        next=nex;
    }
}
public class SingleLLWithTail {
    private static NodeLink head;
    private static NodeLink tail;
    private static int list;

    public SingleLLWithTail() {
        head = null;
        tail = null;
    }

    static boolean isempty()
    {
        return head == null && tail == null;
    }

    static void insert(int i)
    {
        if (isempty()) {
            NodeLink link = new NodeLink(i, null);
            head = link;
            tail = link;
            System.out.println("nilai " + i + " masuk Linked List");
            list++;
        } else {
            NodeLink temp = new NodeLink(i, head);
            head = temp;
            System.out.println("nilai " + i + " Masuk Linked List");
        }
    }

    static void delete() {
        if (isempty()) {
            System.out.println("Linked List Kosong");
        } else {
            System.out.println("Nilai " + head.nilai + " terhapus");
            head = head.next;
            list--;
        }
    }

    static void insertafter(int k, int indeks) {
        if (isempty())
            System.out.println("maaf Linked List Kosong");
        else {
            if (indeks > list)
                System.out.println("maaf, indeks melebihi panjang Linked List");
            else {
                NodeLink temp = head;
                NodeLink fixed;

                for (int i = 1; i < indeks; i++) {
                    temp = temp.next;
                }
                fixed = new NodeLink(k, temp.next);
                temp.next = fixed;
                System.out.println("nilai " + k + " Masuk Linked List");
                list++;
            }
        }
    }

    static void insertlast(int i)
    {
        if (isempty())
            System.out.println("maaf, Linked List kosong");
        else {
            tail.next = new NodeLink(i, null);
            tail = tail.next;
            System.out.println("niali " + i + " masuk dibagiiian tail dari Linked List");
            list++;
        }
    }

    static void deletelast() {
        if (isempty())
            System.out.println("maaf, Linked List kosong");
        else
        {
            NodeLink temp=head;
            System.out.println("nilai "+tail.nilai+" terhapus");
            for (int i = 1; i < list - 1; i++)
            {
                temp = temp.next;
            }
            temp.next=temp.next.next;
            tail=temp;
            list--;
        }
    }

    static void display()
    {
        NodeLink temp=head;
        System.out.println("Jumlah data dalam Linked List "+list);
        System.out.println("isi Linked List : ");
        while(temp!=null)
        {
            System.out.print(temp.nilai);
            temp=temp.next;
            if(temp!=null) System.out.print(" -> ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        SingleLLWithTail a=new SingleLLWithTail();
        a.insert(13);
        a.insert(3);
        a.insert(1);
        a.insert(2);
        a.display();
        a.insertlast(9);
        a.display();
        a.deletelast();
        a.deletelast();
        a.display();
    }
}