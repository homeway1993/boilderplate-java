package boilerplate.springboot.datawithoracle.repository;

import boilerplate.springboot.datawithoracle.entity.IvInvnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IvInvntRepository extends JpaRepository<IvInvnt, String> {
}
