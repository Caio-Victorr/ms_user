//
package com.example.rest.api.crud.user.repositories;

import com.example.rest.api.crud.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

//Os emails são salvos por essa interface armazenando os usuarios e os IDs dos emails
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
