package unifor.com.B3TCH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifor.com.B3TCH.Model.Yield;

@Repository
public interface YieldRepository extends JpaRepository<Yield, Integer> {
}