package mrn.springframework.springwebapp.repositories;

import mrn.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
