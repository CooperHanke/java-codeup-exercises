package movies;

import util.Input;

import java.util.*;

public class MovieApplication {
    public static boolean stopped = false;
    private static Movie[] movies = MoviesArray.findAll();

    public static void main(String[] args) {
        do {
            generateChoices();
            getChoice();
        } while (!stopped);

    }
    private static void generateChoices() {
        System.out.println();
        System.out.println("What would you like to do? >");
        System.out.println("0 - exit");
        System.out.println("1 - view all movies");
        System.out.println("2 - view movies in the animated category");
        System.out.println("3 - view movies in the drama category");
        System.out.println("4 - view movies in the horror category");
        System.out.println("5 - view movies in the scifi category");
        System.out.println("6 - add movie to the collection");
        System.out.println();
    }
    private static void getChoice() {
        System.out.println("Enter your choice ==> ");
        Input input = new Input();
        int choice = input.getInt();
        System.out.println();
        switch (choice) {
            case 0:
                stopped = true;
                break;
            case 1:
                viewAllMovies();
                break;
            case 2:
                viewAnimated();
                break;
            case 3:
                viewDrama();
                break;
            case 4:
                viewHorror();
                break;
            case 5:
                viewScifi();
                break;
            case 6:
                addMovie();
                break;
            default: System.out.println("Invalid choice, please try again.");
                    getChoice();
        }
    }
    private static void viewAllMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getName() + " -- " + movie.getCategory());
        }
    }
    private static void viewAnimated() {
        for (Movie movie : movies) {
            if (movie.getCategory().equals("animated")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
    }
    private static void viewDrama() { ;
        for (Movie movie : movies) {
            if (movie.getCategory().equals("drama")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
    }
    private static void viewHorror() {
        for (Movie movie : movies) {
            if (movie.getCategory().equals("horror")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
    }
    private static void viewScifi() {
        for (Movie movie : movies) {
            if (movie.getCategory().equals("scifi")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
        generateChoices();
    }
    private static void addMovie() {
        Input input = new Input();
        Input choice = new Input();
        Movie[] newList = Arrays.copyOf(movies, movies.length + 1);
        System.out.println("Title of the new movie: ");
        String title = input.getString();
        System.out.println("1 for animated");
        System.out.println("2 for drama");
        System.out.println("3 for horror");
        System.out.println("4 for scifi");
        System.out.println("Select a category: ==> ");
        int category = choice.getInt();
        switch (category) {
            case 1:
                newList[newList.length - 1] = new Movie(title, "animated");
                movies = newList;
                break;
            case 2:
                newList[newList.length - 1] = new Movie(title, "drama");
                movies = newList;
                break;
            case 3:
                newList[newList.length - 1] = new Movie(title, "horror");
                movies = newList;
                break;
            case 4:
                newList[newList.length - 1] = new Movie(title, "scifi");
                movies = newList;
                break;
            default:
                addMovie();
        }
    }
}
