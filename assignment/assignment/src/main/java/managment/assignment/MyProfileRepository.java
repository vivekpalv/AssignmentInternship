package managment.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProfileRepository extends JpaRepository<MyProfile,Integer> {
}
