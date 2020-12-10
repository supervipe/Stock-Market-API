package unifor.com.B3TCH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifor.com.B3TCH.Model.Scrip;

@Repository
public interface ScripRepository extends JpaRepository<Scrip, Integer> {
}
