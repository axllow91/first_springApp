package mrn.springframework.springwebapp.bootstrap;

import mrn.springframework.springwebapp.model.Author;
import mrn.springframework.springwebapp.model.Book;
import mrn.springframework.springwebapp.model.Publisher;
import mrn.springframework.springwebapp.repositories.AuthorRepository;
import mrn.springframework.springwebapp.repositories.BookRepository;
import mrn.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher1 = new Publisher();
        publisher1.setName("foo");
        publisher1.setAddress("Costesti, Str. Rozmarin Nr. 17D");

        publisherRepository.save(publisher1);

        // Eric
        Author eric = new Author("Eric", "Ericsson");
        Book book1 = new Book("Domain Driven Design", "11334", publisher1);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        //----------------------------------

        Publisher publisher2 = new Publisher();
        publisher2.setName("Doo");
        publisher2.setAddress("Amurica, Str. 123 Durica");

        publisherRepository.save(publisher2);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "23344", publisher2);
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);

    }


}
