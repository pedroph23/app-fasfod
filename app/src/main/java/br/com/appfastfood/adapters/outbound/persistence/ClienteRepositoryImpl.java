import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryImpl extends JpaRepository<Cliente, Long>, ClienteRepository {

    // Métodos adicionais específicos do ClienteRepository podem ser adicionados aqui

}