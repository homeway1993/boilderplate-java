package boilerplate.springboot.multiplemongodb.repository.primary;

import boilerplate.springboot.multiplemongodb.entity.primary.Person;

public interface PersonRepositoryCustom {

    Person findFirst();
}
