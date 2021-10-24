package be.intecbrussel.javajuni21.hilal.exceptions;

import be.intecbrussel.javajuni21.hilal.models.Post;
import java.util.Arrays;

public class PostException extends RuntimeException {

    public PostException(String message) {
        super(message);
    }

    public PostException notFound() {
        return new PostException("Post not found");
    }

    public PostException alreadyExists() {
        return new PostException("Post already exists");
    }

    public PostException requiredFields(String... fields) {
        return new PostException("Required fields: " + Arrays.toString(fields));
    }

    public PostException nullPostException() {
        return new PostException("Post cannot be null");
    }

}
