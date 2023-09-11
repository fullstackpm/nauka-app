package ai.nauka.nauka.repository;

import org.springframework.data.repository.CrudRepository;

import ai.nauka.nauka.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    
}
