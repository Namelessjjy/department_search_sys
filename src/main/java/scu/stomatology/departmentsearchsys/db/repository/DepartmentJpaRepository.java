package scu.stomatology.departmentsearchsys.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import scu.stomatology.departmentsearchsys.db.entity.Department;

import java.util.List;

@Component
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {

    @Query(value = "select * from department where symptom like ?1",nativeQuery = true)
    List<Department> search(String keywords);
}
