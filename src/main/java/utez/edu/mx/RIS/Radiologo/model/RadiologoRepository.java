package utez.edu.mx.RIS.Radiologo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RadiologoRepository extends JpaRepository<Radiologo, Long> {
    List<Radiologo> findAllByStatus(boolean status);

}
