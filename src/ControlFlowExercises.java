public class ControlFlowExercises {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000000; i = (int) Math.pow(i, 2)) {
            System.out.println(i);
        }
    }
}
