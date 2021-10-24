package be.intecbrussel.javajuni21.hilal.app;

import be.intecbrussel.javajuni21.hilal.models.Post;
import be.intecbrussel.javajuni21.hilal.models.Topic;
import be.intecbrussel.javajuni21.hilal.models.User;
import be.intecbrussel.javajuni21.hilal.repositories.PostRepository;
import be.intecbrussel.javajuni21.hilal.repositories.TopicRepository;
import be.intecbrussel.javajuni21.hilal.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class SelectApp {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();


        try {
            List<User> users = userRepository.read();
            for (User u : users) {
                System.out.println(u);
            }

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
            ;
        }
        System.out.println("**************************");

        PostRepository postRepository = new PostRepository();

        try {
            List<Post> posts = postRepository.read();
            for (Post p : posts) {
                System.out.println(p);
            }

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
            ;
        }

        TopicRepository topicRepository = new TopicRepository();
        try {
            List<Topic> topics = topicRepository.read();
            for (Topic t : topics) {
                System.out.println(t);
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
            ;
        }

    }


}
