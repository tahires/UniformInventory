///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package assign.groupPrj;
//
//import javafx.scene.Node;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.layout.GridPane;
//
//public class LoginPage extends GridPane {
//
//    protected Button btnLogin;
//    protected Button btnRegister;
//
//    public LoginPage() {
//        this.setHgap(10.0);
//        this.setVgap(10.0);
//        this.setAlignment(Pos.CENTER);
//        final ImageView logo = new ImageView("fashion.jpg");
//        final Label lblUser = new Label("Username: ");
//        final Label lblPasswd = new Label("Password: ");
//        final TextField txtUser = new TextField();
//        final PasswordField txtPasswd = new PasswordField();
//        this.btnLogin = new Button("Login");
//        this.btnRegister = new Button("Register");
//        this.add((Node) logo, 0, 0, 3, 1);
//        this.add((Node) lblUser, 0, 1);
//        this.add((Node) txtUser, 1, 1, 2, 1);
//        this.add((Node) lblPasswd, 0, 2);
//        this.add((Node) txtPasswd, 1, 2, 2, 1);
//        this.add((Node) this.btnLogin, 1, 3);
//        this.add((Node)(this.btnRegister, 2, 3);
//        this.btnLogin.setPrefWidth(70.0);
//        this.btnRegister.setPrefWidth(70.0);
//        logo.setFitHeight(100.0);
//        logo.setFitWidth(270.0);
//    }
//}
