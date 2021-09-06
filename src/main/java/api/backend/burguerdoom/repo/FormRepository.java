package api.backend.burguerdoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.backend.burguerdoom.repo.model.FormDao;

public interface FormRepository extends JpaRepository<FormDao, Integer>{

}
