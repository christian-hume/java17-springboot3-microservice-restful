package com.java17.springboot3.microservice.restful.repositories;

import com.java17.springboot3.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public Long createUser(UserModel userCreate) {
        List<UserModel> userList = this.FindHardCodedData();
        userList.add(userCreate);
        return (long) userList.size();
    }

    public List<UserModel> findUserAll() {
        List<UserModel> userList = this.FindHardCodedData();
        return userList;
    }

    public Optional<UserModel> findUserById(Long idUser) {
        List<UserModel> userList = this.FindHardCodedData();
        return userList.stream()
                .filter(user -> user.getId().equals(idUser))
                .findFirst();
    }

    public void updateUser(Long idUser, UserModel userUpdate) {
        List<UserModel> userList = this.FindHardCodedData();
        Optional<UserModel> userOptional = userList.stream()
                .filter(userStream -> userStream.getId().equals(idUser))
                .findFirst();
        if (userOptional.isPresent()) {
            UserModel userCurrent = userOptional.get();
            userCurrent.setFirstName(userUpdate.getFirstName());
            userCurrent.setLastName(userUpdate.getLastName());
            userCurrent.setNationality(userUpdate.getNationality());
            userCurrent.setOccupation(userUpdate.getOccupation());
            userCurrent.setEmail(userUpdate.getEmail());
            userCurrent.setPhone(userUpdate.getPhone());
        }

    }

    public void deleteUser(Long idUser) {
        List<UserModel> userList = FindHardCodedData();
        boolean isRemove = userList.removeIf(user -> user.getId().equals(idUser));
    }

    private List<UserModel> FindHardCodedData() {
        List<UserModel> userModelList = new ArrayList<>();

        userModelList.add(UserModel.builder()
                .id(Long.valueOf(1))
                .firstName("James")
                .lastName("Gosling")
                .nationality("Canadian")
                .occupation("Computer Scientist")
                .email("james.gosling@email.com")
                .phone("2-663-123-4447")
                .build());

        userModelList.add(UserModel.builder()
                .id(Long.valueOf(2))
                .firstName("Anders")
                .lastName("Hejlsberg")
                .nationality("Danish")
                .occupation("Lead Systems Architect")
                .email("anders.hejlsberg@email.com")
                .phone("4-024-976-6794")
                .build());

        userModelList.add(UserModel.builder()
                .id(Long.valueOf(3))
                .firstName("Yukihiro")
                .lastName("Matsumoto")
                .nationality("Japanese")
                .occupation("Computer Scientist")
                .email("yukihiro.matsumoto@email.com")
                .phone("5-024-976-6794")
                .build());

        userModelList.add(UserModel.builder()
                .id(Long.valueOf(4))
                .firstName("Guido")
                .lastName("Van Rossum")
                .nationality("Netherlands")
                .occupation("Benevolent Dictator for Life")
                .email("guido.van.rossum@email.com")
                .phone("3-770-736-8031")
                .build());

        userModelList.add(UserModel.builder()
                .id(Long.valueOf(5))
                .firstName("Bjarne")
                .lastName("Stroustrup")
                .nationality("Danish")
                .occupation("Computer Scientist")
                .email("bjarne.stroustrup@email.com")
                .phone("1-493-170-9623")
                .build());

        return userModelList;
    }

}
