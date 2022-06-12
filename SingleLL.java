package SDA;

class Linked{
    int nilai;
    Linked next;

    public Linked (int n, Linked nex){
        nilai=n;
        next=nex;

    }

}
public class SingleLL {
    private static Linked head;
    private static int list;

    public SingleLL(){
        head=null;
    }
    static boolean isempty(){
        return head==null;
    }
    static void insert(int n){
        Linked temp;
        temp=new Linked(n, head);
        head=temp;
        System.out.println("nilai "+n+" masuk linked list");
        list++;
    }
    static void insertafter (int n, int indeks){
        if (isempty())
            System.out.println("linked list kosong");
        else {
            if (indeks>list)
                System.out.println("Maaf indeks melebihi panjang list");
            else {
                Linked temp=head;
                Linked fixed;
                for (int i=1;i<indeks;i++){
                    temp=temp.next;
                }
                fixed=new Linked(n, temp.next);
                temp.next=fixed;
                System.out.println("nilai "+n+" masuk linked list");
            }
        }
    }
    static void insertbefore(int n, int indeks){
        if (isempty())
            System.out.println("linked list kosong");
        else{
            if (indeks>list)
                System.out.println("maaf, indeks melebihi panjang linked list");
            else {
                Linked temp=head;
                Linked fixed;
                for (int i=0;i<indeks;i++){
                    temp=temp.next;
                }
                if ((head.nilai==temp.nilai)&&(indeks==1)){
                    temp=new Linked(n, head);
                    head=temp;
                    System.out.println("nilai "+n+" masuk linked list");
                }
                else {
                    fixed=new Linked(n, temp.next);
                    temp.next=fixed;
                    System.out.println("nilai "+n+" masuk linked list "+" sebelum indeks "+indeks);
                    list++;
                }
            }
        }
    }
    static void delete(){
        if (isempty())
            System.out.println("linked list kosong");
        else {
            System.out.println("nilai "+head.nilai+" terhapus");
            head=head.next;
            list--;
        }
    }
    static void dellinked(int indeks){
        if (isempty())
            System.out.println("linked list kosong");
        else {
            if (indeks>list)
                System.out.println("maaf indeks melebihi panjang list");
            else{
                Linked temp=head;
                for (int i=1;i<indeks;i++){
                    temp=temp.next;
                }
                if ((head.nilai==temp.nilai)&&(indeks==1)){
                    System.out.println("nilai "+head.nilai+" pada indeks "+indeks+" dihapus");
                    temp.next=temp.next.next;
                    list--;
                }
            }

        }

    }
    static void findlist(int i){
        Linked temp=head;
        int x=0;
        boolean hasil=false;
        while (temp!=null){
            x++;
            if (temp.nilai==1){
                hasil=true;
                break;
            }
            temp=temp.next;

        }
        if (hasil)
            System.out.println("nilai ditemukan pada list ke"+x);
        else
            System.out.println("maaf data tidak ditemukan");
    }
    static void display() {
        Linked temp = head;
        System.out.println(" Jumlah data dalam linked list " + list);
        while (temp != null) {
            System.out.println("isi linked list: " + temp.nilai);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleLL a=new SingleLL();
        a.delete();
        a.insert(12);
        a.insert(2);
        a.insert(1);
        a.insert(34);
        a.delete();
        a.insertafter(13, 1);
        a.insertbefore(15,1);
        a.dellinked(2);
        a.findlist(15);
        a.display();
    }
}

