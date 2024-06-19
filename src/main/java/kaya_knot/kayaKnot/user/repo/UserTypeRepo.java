package kaya_knot.kayaKnot.user.repo;

import kaya_knot.kayaKnot.user.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository<UserType, Long> {
    @Query(value = "SELECT * FROM user_type where id=:id",nativeQuery = true)
    UserType fetchUserType(@Param("id") String id);

}
