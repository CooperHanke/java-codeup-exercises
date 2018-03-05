public class ServerNameGenerator {
    public static int randomizer (int arrayLength) {
        return (int)(Math.random() * arrayLength + 1);

    }
    public static void main(String[] args) {
        String[] arrayOfWords = {
                "cool",
                "stellar",
                "hot",
                "vivid",
                "enhanced",
                "innovative",
                "elite",
                "modern",
                "refined",
                "upgraded"
        };

        String[] anotherArrayOfWords = {
                "cat",
                "dog",
                "mouse",
                "Transformer",
                "Snorlax",
                "hombre",
                "Dragonball",
                "ducky",
                "lion",
                "tiger"
        };
        System.out.println("The generated server name is: " + arrayOfWords[randomizer(arrayOfWords.length - 1)] + "-" +
                anotherArrayOfWords[randomizer(anotherArrayOfWords.length - 1)]);
    }

}
