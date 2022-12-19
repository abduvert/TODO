package gui;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;

public class signupChecker implements EventHandler {

    TextField username;
    PasswordField pass;
    PasswordField confirm;
    TextField email;
    Stage create;
    Scene scene;

    public signupChecker(TextField username, PasswordField pass, PasswordField confirm, TextField email, Stage stage, Scene scene) {
        this.username = username;
        this.pass = pass;
        this.confirm = confirm;
        this.email = email;
        this.create = stage;
        this.scene = scene;
    }


    @Override
    public void handle(Event event) {
            for (HashMap<String, String> l : Paa.usernames) {
        if(username.getText()==null || pass.getText()==null || confirm.getText()==null || email.getText()==null)
        {
            if(username.getText()==null)
            {
            username.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

            }
            if(email.getText()==null)
            {
            email.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

            }
            if(confirm.getText()==null)
            {
            confirm.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

            }
            if(pass.getText()==null)
            {

            pass.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");
            }

        }
        else {


                if (!l.get("username").equals(username.getText())) {
                    username.setStyle("-fx-background-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                    if (!pass.getText().equals(confirm.getText())) {
                        confirm.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                    }
                    if (pass.getText().equals(confirm.getText())) {
                        confirm.setStyle("-fx-background-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                        if (!email.getText().contains("@")) {
                            email.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                        }
                        else{
                        create creates = new create(username, pass, confirm, email, create, scene);
                        creates.handle();
                        break;
                    }
                }
                }
                if (l.get("username").equals(username.getText())) {
                    username.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                    if (pass.getText().equals(confirm.getText())) {
                        confirm.setStyle("-fx-background-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                    }
                    if (!pass.getText().equals(confirm.getText())) {
                        confirm.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                    }
                }
            }


        }


    }
}
