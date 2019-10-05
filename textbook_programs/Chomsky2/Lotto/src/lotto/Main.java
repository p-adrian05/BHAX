package lotto;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LottoNezet.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Lottó");
        stage.show();
        stage.setResizable(false);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case F:
                        stage.setFullScreenExitHint("Nyomd meg az ESC gombot a teljes képernyős módból való kilépéshez!");
                        stage.setFullScreen(true);
                }
            }
        });

    }



    public static void main(String[] args) {
        launch(args);
    }

}
