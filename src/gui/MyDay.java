package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class MyDay implements EventHandler {
    int count=0;
    @Override
    public void handle(Event event) {
        Text statement = new Text("My Day");
        HBox hb1 = new HBox();
        //login.vb2.getChildren().add(statement);
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dtf.format(date));

        for (HashMap<String, Object> k : AddingTask.tasks) {


            String a = (String)k.get("date");
            String b[] = a.split("-");
            String c = new String(b[0]+b[1]+b[2]);
            String d[] = dtf.format(date).split("-") ;
            String e = new String(d[0]+d[1]+d[2]);
            System.out.println(e);
            System.out.println(c);
            System.out.println(a);
            String f = (String)k.get("task");
            CheckBox check = new CheckBox();
            check.setText(f);

            if (c.equals(e)) {

            if (check.isSelected()) {
                System.out.println("checked");
                Text done = new Text("Hurray!!You have done your task!");
                hb1.getChildren().add(done);
                hb1.getChildren().remove(check);
                done.setFont(Font.font("Gill Sans", FontWeight.BOLD, 15));
                hb1.setAlignment(Pos.CENTER);
                login.vb3.getChildren().add(hb1);
                hb1.setLayoutX(1);
                hb1.setLayoutY(30);

            }
            else {

                check.setTextFill(Color.BLACK);
                check.setFont(Font.font("Gill Sans", FontWeight.SEMI_BOLD, 13));
                statement.setFont(Font.font("Gill Sans", FontWeight.BOLD, 30));

                login.vb2.setStyle("-fx-background-color:#93C684");
                login.hb.setLayoutX(1);
                login.hb.setLayoutY(97);
                login.hb.getChildren().add(statement);
                hb1.getChildren().add(check);
                hb1.setLayoutX(1);
                hb1.setLayoutY(25);
                login.vb2.getChildren().add(login.hb);
                login.vb3.getChildren().add(hb1);
            }

        }

            a=null;
            b=null;
            c=null;
            d=null;
            e=null;
        }
    }
}
