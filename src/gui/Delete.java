package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static gui.Paa.usernames;

public class Delete implements EventHandler {

    Text statement = new Text("Trash");
   static ArrayList<HashMap<String, Object>> del = new ArrayList<>();
    static HashMap<String, Object> hashdel = new HashMap<>();

    String a;
    String b;
    String c;

    public Delete(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public void handle(Event event) {
        try {
            FileWriter fw = new FileWriter("src/gui/Delete.txt");


            hashdel.put("task", a);
            hashdel.put("description", b);
            hashdel.put("username", login.a);
            hashdel.put("date", c);

            del.add(hashdel);
            System.out.println(usernames);
            hashdel = new HashMap<>();


            for (HashMap<String, Object> l : AddingTask.tasks) {
                if (l.get("description").equals(b)) {

                    AddingTask.tasks.remove(l);
                }
            }

                    for(HashMap<String,Object> k : del) {
                        fw.write(k.get("username") + "@" + k.get("task") + "_" + k.get("description") + "]" + k.get("date") + "\n");
                    }




        } catch (IOException e) {

        }
    }
}
