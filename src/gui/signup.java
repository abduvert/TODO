package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signup implements EventHandler {


    Stage create;
    Scene scene;
    Scene thi;
    Rectangle rect;
    Image img = new Image(getClass().getResourceAsStream("bck.jpg"));
    ImageView imageView = new ImageView(img);


    public signup(Stage stage, Scene scene, Rectangle rect) {
        this.create = stage;
        this.scene = scene;
        this.rect = rect;
    }

    @Override
    public void handle(Event event) {
        Label sign = new Label("SIGN UP");
        AnchorPane anchorPane = new AnchorPane();
        Button yes = new Button("Create Account");
        Button no = new Button("Cancel");
        TextField username = new TextField();
        TextField email = new TextField();
        PasswordField pass = new PasswordField();
        PasswordField confirm = new PasswordField();


        username.setPromptText("Enter your Username");
        pass.setPromptText("Enter your password");
        confirm.setPromptText("Confirm your password");
        email.setPromptText("E-mail");

        anchorPane.getChildren().add(imageView);

        anchorPane.getChildren().add(rect);
        rect.setX(6);
        rect.setY(0.5);


        anchorPane.getChildren().add(sign);
        sign.setLayoutX(90);
        sign.setLayoutY(30);
        sign.setFont(Font.font("Gill Sans", FontWeight.BOLD,25));
        sign.setTextFill(Color.WHITE);

        anchorPane.getChildren().add(username);
        username.setLayoutX(90);
        username.setLayoutY(65);
        username.setPrefWidth(222);
        username.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");

        anchorPane.getChildren().add(pass);
        pass.setPrefWidth(222);
        pass.setLayoutX(90);
        pass.setLayoutY(100);
        pass.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");



        anchorPane.getChildren().add(confirm);
        confirm.setPrefWidth(222);
        confirm.setLayoutX(90);
        confirm.setLayoutY(135);
        confirm.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");


        anchorPane.getChildren().add(email);
        email.setPrefWidth(222);
        email.setLayoutX(90);
        email.setLayoutY(170);
        email.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");

        anchorPane.getChildren().add(yes);
        yes.setLayoutX(90);
        yes.setLayoutY(205);
        yes.setStyle("-fx-background-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");
        yes.setFont(Font.font("Gill Sans",FontWeight.SEMI_BOLD,12));
        yes.setMinHeight(10);
        yes.setMinWidth(225);
        yes.setTextFill(Color.WHITE);



        yes.setOnAction(new signupChecker(username,pass,confirm,email,create,scene));
        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                create.setScene(scene);
            }
        });

        anchorPane.getChildren().add(no);
        no.setLayoutX(90);
        no.setLayoutY(245);
        no.setStyle("-fx-background-color:gray;-fx-background-radius: 20px;-fx-border-radius: 18px;");
        no.setFont(Font.font("Gill Sans",FontWeight.SEMI_BOLD,12));
        no.setMinHeight(10);
        no.setMinWidth(225);
        no.setTextFill(Color.WHITE);


        anchorPane.setPadding(new Insets(10,10,10,10));


        //this = ;
        //yes.setOnAction(new create(create));
        create.setScene(new Scene(anchorPane, Paa.width, Paa.height));
        create.show();







                                }
}
//    public void start(Stage stage){
//        GridPane g = new GridPane();
//        Image im = new Image(getClass().getResourceAsStream("icon.jpg"));
//        ImageView imageVw = new ImageView(im);
//        g.add(imageVw,0,0);
//        g.setAlignment(Pos.CENTER);
//        stage.setScene(new Scene(g,400,400));
//        stage.show();
//
//    }
