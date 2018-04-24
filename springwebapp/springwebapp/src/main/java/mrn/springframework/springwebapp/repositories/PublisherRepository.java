package mrn.springframework.springwebapp.repositories;

import mrn.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
