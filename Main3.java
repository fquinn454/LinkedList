import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main3 {

    public static ArrayList linkedListAsList(LinkedList myList) {
        ArrayList list = new ArrayList();
        list.add(myList.getElement());
        if (myList.getNext() instanceof ListNode){
            list.add(linkedListAsList(myList.getNext()));
        }
        return list;
    }

    public static void prettyPrint(ArrayList list){
        for(Object item:list){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static Stream<Object> flattenToStream(List<?> list) {
        return list.stream().flatMap(item -> item instanceof List<?> ?
                flattenToStream((List<?>)item) : Stream.of(item));
    }

    public static List<Object> flatten(List<?> list) {
        return flattenToStream(list).collect(Collectors.toList());
    }

    public static boolean search(List<?> list, int x){
        return flatten(list).contains(x);
    }

    public static int max(List<?> list){
        ArrayList<Integer> a = (ArrayList) flatten(list);
        int max = Collections.max(a);
        return max;
    }

    public static int min(List<?> list){
        ArrayList<Integer> a = (ArrayList) flatten(list);
        int min = Collections.min(a);
        return min;
    }


    public static void main(String[] args) {
        TerminalNode node8 = new TerminalNode(25);
        ListNode node7 = new ListNode(13, node8);
        ListNode node6 = new ListNode(8, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);


        prettyPrint((ArrayList)flatten(linkedListAsList(node1)));
        System.out.println(search(linkedListAsList(node1), 7));
        System.out.println(search(linkedListAsList(node1), 8));
        System.out.println(Main2.minMax(linkedListAsList(node1)));

    }

}
