package com.company.repository;

import com.company.models.User;
import com.company.util.IdGenerator;
import com.sun.corba.se.impl.orbutil.RepositoryIdStrings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class UsersRepositoryFileWriterImpl implements UsersRepository {

    private FileWriter writer;
    private String fileName;
    private IdGenerator idGenerator;
    private Scanner scanner;
/*
    private FileWriter writer2;
    private Scanner scanner2;
*/
    public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }
/*
    @Override
    public int getNewUserId(){
        return idGenerator.getNewId();
    }
*/
    @Override
    public void save(User user) {
        try {
            writer = new FileWriter(fileName, true);
            int id = idGenerator.getNewId();
            writer.write(id + " "
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
                String tempstr = scanner.nextLine();
                if (Integer.parseInt(tempstr.split(" ")[0]) != id){
                    writer.write(tempstr + "\n");
                }
            }
//            scanner.remove();
            scanner.close();
            writer.close();

/*            sourceFile.canRead();
            sourceFile.canWrite();
            sourceFile.canExecute();

            if(sourceFile.delete()) {
                System.out.println("Файл удален");
            } else {
                System.out.println("Файл удалить не получилось");
            }
*/
//                sourceFile.delete();
            writer = new FileWriter(sourceFile);
            writer.close();
            writer = new FileWriter(sourceFile,true);

            scanner = new Scanner(outputFile);
            while (scanner.hasNext()){
                String tempstr = scanner.nextLine();
                writer.write(tempstr + "\n");
            }
            System.out.println("Запись удалена");
//        outputFile.renameTo(sourceFile);
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

            writer = new FileWriter(sourceFile);
//            writer2.flush();
            scanner = new Scanner(outputFile);
            while (scanner.hasNext()) {
                writer.write(scanner.nextLine());
            }
            scanner.close();
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}