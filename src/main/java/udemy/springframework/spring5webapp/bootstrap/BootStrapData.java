package udemy.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.springframework.spring5webapp.domain.Author;
import udemy.springframework.spring5webapp.domain.Book;
import udemy.springframework.spring5webapp.domain.Publisher;
import udemy.springframework.spring5webapp.repositories.AuthorRepository;
import udemy.springframework.spring5webapp.repositories.BookRepository;
import udemy.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric=new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design","123123");
        Publisher pub1=new Publisher("pub1");
        publisherRepository.save(pub1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);
        pub1.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub1);

        Author rod=new Author("Rod","Johnson");
        Book noEJB= new Book("J2EE Development without EJB","423423423");
        Publisher pub2=new Publisher("pub2");
        publisherRepository.save(pub2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub1);
        pub1.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub2);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books" + pub1.getBooks().size());


    }
}
