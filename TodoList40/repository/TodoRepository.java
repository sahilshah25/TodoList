package SpringBoot1.TodoList40.repository;

import SpringBoot1.TodoList40.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
