package com.company.repository;

import com.company.models.User;
import com.company.util.IdGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class UsersRepositoryFileWriterImpl implements UsersRepository {

    private FileWriter writer;
    private String fileName;
    private IdGenerator idGenerator;
    private Scanner scanner;

    private FileWriter writer2;
    private Scanner scanner2;

    public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    @Override
    public int getNewUserId(){
        return idGenerator.getNewId();
    }

    @Override
    public void save(User user) {
        try {
            writer = new FileWriter(fileName, true);
            writer.write(idGenerator.getNewId() + " "
                    + user.getBirthDate().toString()
                    + " " + user.getFirstName()
                    + " " + user.getLastName() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public User find(int id){
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()){
                String tempStr = scanner.nextLine();
                if (Integer.parseInt(tempStr.split(" ")[0]) == id){
                    return new User(
                            Integer.parseInt(tempStr.split(" ")[0]),
                            tempStr.split(" ")[2],
                            tempStr.split(" ")[3],
                            LocalDate.of(Integer.parseInt(tempStr.split(" ")[1].split("-")[0]),
                                    Integer.parseInt(tempStr.split(" ")[1].split("-")[1]),
                                    Integer.parseInt(tempStr.split(" ")[1].split("-")[2]))
                    );
                }
            }
            scanner.close();
            return null;
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(int id){
        File sourceFile = new File(fileName);
        File outputFile = new File("temp.txt");
        try {
            scanner = new Scanner(sourceFile);
            writer = new FileWriter(outputFile,true);
            while (scanner.hasNext()){
                String tmpstr = scanner.nextLine();
                if (Integer.parseInt(tmpstr.split(" ")[0]) != id){
                    writer.write(tmpstr + "\n");
                }
            }
            scanner.close();
            writer.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(User user){
        File sourceFile = new File(fileName);
        File outputFile = new File("temp.txt");
        try {
            scanner = new Scanner(sourceFile);
            writer = new FileWriter(outputFile,true);
            while (scanner.hasNext()){
                String tmpstr = scanner.nextLine();
                if (Integer.parseInt(tmpstr.split(" ")[0]) == user.getId()){
                    writer.write(user.getId() + " "
                            + user.getBirthDate().toString()
                            + " " + user.getFirstName()
                            + " " + user.getLastName() + "\n");
                }else{
                    writer.write(tmpstr + "\n");
                }
            }
            scanner.close();
            writer.close();
            //sourceFile.delete();
            //outputFile.renameTo(sourceFile);

            writer2 = new FileWriter(sourceFile,false);
            writer2.flush();
            scanner2 = new Scanner(outputFile);
            while (scanner2.hasNext()) {
                writer2.write(scanner2.nextLine());
            }
            scanner.close();
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}