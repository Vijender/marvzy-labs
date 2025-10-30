public class  Main {

    static void main() {

        System.out.println("Hello World");
        Main obj = new Main();


        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);

        ListNode result = obj.addTwoNumbers(head, head2);
        System.out.println(result.val + ":" + result.next.val + ":" + result.next.next.val + ":" + result.next.next.next.val);

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int c , d ;
        int q = 0, sr;
        ListNode result = null, sresult, lastResult = null;

        while( l1 != null || l2 != null) {

            if (l1 != null) {
                c = l1.val;
                l1 = l1.next;
            }  else c = 0;
            if (l2 != null) {
                d = l2.val;
                l2 = l2.next;
            } else d = 0;


            sr = (c + d + q) % 10;
            q = (c + d + q ) / 10;

            sresult = new ListNode(sr);

            if (result == null) {
                result = sresult;
                lastResult = sresult;
            } else {
                lastResult.next = sresult;
                lastResult = lastResult.next;
            }
        }
        if (q > 0) {
            sresult = new ListNode(q);
            lastResult.next = sresult;
        }
        return result;
    }
}


