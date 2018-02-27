public class ControlFlowExercises {
    public static void main(String[] args) {
        int i = 2;
        System.out.println(i);
        do {
            i = (int) Math.pow(i, 2);
            System.out.println(i);
        } while (i < 65000);
    }
}
