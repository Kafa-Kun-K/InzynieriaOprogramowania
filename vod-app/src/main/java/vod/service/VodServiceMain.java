package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Library;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find libraries!");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        LibraryService service = context.getBean(LibraryService.class);
        LibraryService service2 = context.getBean(LibraryService.class);

        List<Library> libraries = service.getAllLibraries();
        System.out.println(libraries.size() + " libraries found:");
        libraries.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
