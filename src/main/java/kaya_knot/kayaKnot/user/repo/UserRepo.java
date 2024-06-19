package kaya_knot.kayaKnot.user.repo;

import kaya_knot.kayaKnot.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {
    @Query(value = "SELECT * FROM users  WHERE email=:email and is_deleted=0 and is_active=1;",nativeQuery = true)
    public Users findUserByEmail(String email);

    @Query(value = "SELECT * FROM users  WHERE id=:id and is_deleted=0 and is_active=1;",nativeQuery = true)
    public Users findUserById(String id);


}
