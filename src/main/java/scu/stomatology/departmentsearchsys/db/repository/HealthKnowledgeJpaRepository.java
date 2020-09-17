package scu.stomatology.departmentsearchsys.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import scu.stomatology.departmentsearchsys.db.entity.HealthKnowledge;

@Component
public interface HealthKnowledgeJpaRepository extends JpaRepository<HealthKnowledge, Long> {


}
