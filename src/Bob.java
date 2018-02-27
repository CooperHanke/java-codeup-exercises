import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        System.out.println("What up, cuz? I'm Bob. Wut it dew?");
        Scanner scan = new Scanner(System.in);
        String response = scan.nextLine();

        if (response.contains("?")) {
            System.out.println("Sure");
        } else if (response.equals(response.toUpperCase()) && !response.isEmpty()) {
            System.out.println("Whoa, chill out!");
        } else if (response.isEmpty()) {
            System.out.println("Fine, be that way!");
        } else System.out.println("Whatever");
    }
}
