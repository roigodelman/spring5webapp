package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG pub");
        publisher.setCity("Tel Aviv");
        publisher.setState("Israel");

        publisherRepository.save(publisher);



        Author eric = new Author("Eric", "Eve");
        Book ddd = new Book("ddd", "2132");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "John");
        Book jee = new Book("J2EE", "1231546");
        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        jee.setPublisher(publisher);
        publisher.getBooks().add(jee);

        authorRepository.save(rod);
        bookRepository.save(jee);
        publisherRepository.save(publisher);



        System.out.println("Started Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Pub" + bookRepository.count());

    }
}
