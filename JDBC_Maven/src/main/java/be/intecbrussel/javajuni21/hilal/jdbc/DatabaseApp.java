package be.intecbrussel.javajuni21.hilal.jdbc;

import be.intecbrussel.javajuni21.hilal.jdbc.repositories.CategoryRepository;

public class DatabaseApp {

    public static void main(String[] args) {

        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.read();


    }

}
