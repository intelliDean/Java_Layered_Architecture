package dean.blog.project;

import dean.blog.project.controllers.PostController;
import dean.blog.project.dtos.requests.CreatePostRequests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.Scanner;
@SpringBootApplication
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static PostController postController = new PostController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        //displayMainMenu();
    }

    private static void displayMainMenu() {
        String mainMenu = """
                1.  creat post
                2.  view post
                3.  exit app
                """;
        String userInput = input(mainMenu);
        switch (Integer.parseInt(String.valueOf(userInput.charAt(0)))) {
            case 1 -> createPost();
            case 2 -> viewPost();
            case 3 -> exitApp();
        }
    }
    public static void createPost() {
        String title = input("enter post tiltle");
        String body = input("enter body");
        CreatePostRequests postRequests = new CreatePostRequests();
        postRequests.setTitle(title);
        postRequests.setBody(body);
        print(postController.createPost(postRequests));
        displayMainMenu();
    }

    public static void viewPost() {
        String userInput = input("enter post id");
        print(postController.viewPost(Integer.parseInt(userInput)).toString());
        displayMainMenu();
    }
    public static void exitApp() {
        print("Thank you for using our app");
        System.exit(0);
    }
    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
    public static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }
}
