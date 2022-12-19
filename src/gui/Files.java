package gui;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Files {

    File file = new File("src/gui/Usernames.txt");
 static  File ta = new File("src/gui/TaskName.txt");
    static HashMap<String, String> user = new HashMap<>();



    public void Userfiless() {

        try {
            Scanner reader = new Scanner(file);


            if (file.exists()) {
                while (reader.hasNext()) {
                    String a[] = reader.nextLine().split("_");
                    user.put("username", a[0]);
                    user.put("password", a[1]);

                    Paa.usernames.add(user);
                    user = new HashMap<>();
                }
                System.out.println(Paa.usernames);
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Bad" + e.getMessage());
            e.printStackTrace();
        }
    }



    public void Taskfiles(){

        try {

            Scanner Taskreader = new Scanner(ta);
            if (file.exists()) {
                while (Taskreader.hasNext()) {
                    String b[] = Taskreader.nextLine().split("@");
                        String a[] = b[1].split("_");
                        System.out.println(a[0] + "\n");
                        System.out.println(a[1] + "\n");
                        System.out.println(b[0] + "\n");

                        AddingTask.taskName.put("task", a[0]);
                        AddingTask.taskName.put("description", a[1]);
                        AddingTask.taskName.put("username", b[0]);


                        AddingTask.tasks.add(AddingTask.taskName);
                        AddingTask.taskName = new HashMap<>();
                    }
                }
                System.out.println(AddingTask.tasks);
                Taskreader.close();

            if (!file.exists()) {
                System.out.println("BHAE");

            }
        }
        catch(IOException e){
                System.out.println("Bad" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
