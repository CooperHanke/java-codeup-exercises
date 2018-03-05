package movies;

import util.Input;

public class MovieApplication {
    public static void main(String[] args) {
        generateChoices();
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
        getChoice();
    }
    private static void getChoice() {
        System.out.println("Enter your choice ==> ");
        Input input = new Input();
        int choice = input.getInt();
        System.out.println();
        if (choice == 1) {
            viewAllMovies();
        } else if (choice == 2) {
            viewAnimated();
        } else if (choice == 3) {
            viewDrama();
        } else if (choice == 4) {
            viewHorror();
        } else if (choice == 5) {
            viewScifi();
        } else if (choice == 0) {
        } else {
            System.out.println("Invalid choice, please try again.");
            getChoice();
        }
    }
    private static void viewAllMovies() {
        Movie[] movies = MoviesArray.findAll();
        for (Movie movie : movies) {
            System.out.println(movie.getName() + " -- " + movie.getCategory());
        }
        generateChoices();
    }
    private static void viewAnimated() {
        Movie[] movies = MoviesArray.findAll();
        for (Movie movie : movies) {
            if (movie.getCategory().equals("animated")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
        generateChoices();
    }
    private static void viewDrama() {
        Movie[] movies = MoviesArray.findAll();
        for (Movie movie : movies) {
            if (movie.getCategory().equals("drama")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
        generateChoices();
    }
    private static void viewHorror() {
        Movie[] movies = MoviesArray.findAll();
        for (Movie movie : movies) {
            if (movie.getCategory().equals("horror")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
        generateChoices();
    }
    private static void viewScifi() {
        Movie[] movies = MoviesArray.findAll();
        for (Movie movie : movies) {
            if (movie.getCategory().equals("scifi")) {
                System.out.println(movie.getName() + " -- " + movie.getCategory());;
            }
        }
        generateChoices();
    }
}
