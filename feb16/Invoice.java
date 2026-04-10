public class Invoice {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice\n");
        sb.append("Item: Pen - ₹10\n");
        sb.append("Item: Notebook - ₹50\n");
        sb.append("Total: ₹60\n");
        System.out.println(sb.toString());
    }
}