package com.social.app;
import com.social.models.*;
import com.social.services.*;
import java.util.*;

public class SocialMediaApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        FriendService friendService = new FriendService();
        PostService postService = new PostService();

        User currentUser = null;   

        while(true){

            System.out.println("\n1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("DOB: ");
                String dob = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Location: ");
                String location = sc.nextLine();

                System.out.print("Occupation: ");
                String occupation = sc.nextLine();

                currentUser = userService.signup(name, dob, age, location, occupation);

                System.out.println("Signup successful!");

            }

            else if(choice == 2){

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                currentUser = userService.findUserByName(name);

                if(currentUser == null){
                    System.out.println("User not found");
                    continue;
                }

                System.out.println("Login successful!");

                userMenu(sc, currentUser, postService, friendService, userService);
            }

            else{
                break;
            }
        }
    }

    public static void userMenu(Scanner sc,
                                User currentUser,
                                PostService postService,
                                FriendService friendService,
                                UserService userService){

        while(true){

            System.out.println("\n1. Create Post");
            System.out.println("2. View Feed");
            System.out.println("3. View Friends");
            System.out.println("4. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                System.out.println("Enter Post Content:");
                String content = sc.nextLine();

                postService.createPost(currentUser, content);
            }

            else if(choice == 2){
                postService.viewFeed(currentUser);
            }

            else if(choice == 3){
                userService.viewFriends(currentUser);
            }

            else{
                break;
            }
        }
    }
}
