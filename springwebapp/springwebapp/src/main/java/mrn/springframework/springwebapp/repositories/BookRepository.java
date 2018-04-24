package mrn.springframework.springwebapp.repositories;

import mrn.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
