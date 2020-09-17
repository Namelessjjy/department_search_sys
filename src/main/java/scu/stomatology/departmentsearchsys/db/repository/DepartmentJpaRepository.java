package scu.stomatology.departmentsearchsys.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import scu.stomatology.departmentsearchsys.db.entity.Department;
import scu.stomatology.departmentsearchsys.db.entity.Image;

import java.util.List;

@Component
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {



}
