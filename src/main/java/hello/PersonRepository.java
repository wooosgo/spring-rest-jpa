package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people") // customizing rest path
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByLastName(@Param("lastName") String lastName);
    List<Person> findByFirstName(@Param("firstName") String firstName);
    List<Person> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}