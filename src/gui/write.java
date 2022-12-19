package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class write{

    String user;
    String pass;
    ArrayList<HashMap<String,String>> u = new ArrayList<>();

    public write(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }



    public void handle() {
        try {
            FileWriter fw = new FileWriter("src/gui/Usernames.txt",true);
            Files.user.put("username",user);
            Files.user.put("password",pass);


            u.add(Files.user);
            System.out.println(u);
            Files.user = new HashMap<>();

            for(HashMap<String,String> l : u)
            {
                fw.write("\n" +l.get("username")+"_"+l.get("password")+ "\n");
                System.out.println("HOGAYAAAA");
            }
            fw.close();
            System.out.println(u);
        }
        catch (IOException e)
        {

        }
    }
}

