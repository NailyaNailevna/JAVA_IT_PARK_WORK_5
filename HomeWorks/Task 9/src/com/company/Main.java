package com.company;

import com.company.models.User;
import com.company.repository.UsersRepository;
import com.company.repository.UsersRepositoryFileWriterImpl;
import com.company.util.IdGeneratorFileBasedImpl;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UsersRepository usersRepository =
                new UsersRepositoryFileWriterImpl("users.txt", IdGeneratorFileBasedImpl.generator());
/*
        User marsel = new User(usersRepository.getNewUserId(),"Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        User marsel1 = new User(usersRepository.getNewUserId(),"Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        User marsel2 = new User(usersRepository.getNewUserId(),"Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        usersRepository.save(marsel);
        usersRepository.save(marsel1);
        usersRepository.save(marsel2);
*/
        // find - ищем юзера по айди
        System.out.println("Ищем юзера с айди 5");
        User findUser = usersRepository.find(5);
        System.out.println("Найденный юзер:");
        System.out.println(/*findUser.getId() + " " + */findUser.getFirstName() + " " + findUser.getLastName() + " " + findUser.getBirthDate());

        // удаляем юзера по id
        //usersRepository.delete(6);

        // update - меняем юзера
        usersRepository.update(
                new User( 3,
                          "Сергей", "Руденко",
                          LocalDate.of(1994, 02, 02)
                        )
        );
    }
}