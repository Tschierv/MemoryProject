package com.github.tschierv.memorygame.presentation;

import com.github.tschierv.memorygame.Main;
import com.github.tschierv.memorygame.domain.game.GameController;
import com.github.tschierv.memorygame.presentation.game.GameCompletedController;
import com.github.tschierv.memorygame.presentation.game.LevelController10x10;
import com.github.tschierv.memorygame.presentation.game.LevelController4x4;
import com.github.tschierv.memorygame.presentation.game.LevelController6x6;
import com.github.tschierv.memorygame.presentation.menu.*;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneController {
    private Scene scene;

    public SceneController(Scene scene) {
        this.scene = scene;
    }

    public SceneController() {
        this.scene = null;
    }

    public Scene getScene(String fxmlFile) {
        FXMLLoader fxmlLoader = getfxmlLoader(fxmlFile);
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (scene == null){
            scene = new Scene(parent);
        } else {
            scene.setRoot(parent);
        }
        return scene;
    }

    private FXMLLoader getfxmlLoader(String fxmlFile) {
        return new FXMLLoader(Main.class.getClassLoader().getResource(fxmlFile));
    }

    private Scene getScene(FXMLLoader fxmlLoader, Object controllerCls) {
        try {
            fxmlLoader.setController(controllerCls);
            Parent MainViewParent = fxmlLoader.load();
            scene = new Scene(MainViewParent);
            scene.getStylesheets().add(Main.class.getClassLoader().getResource("com/github/tschierv/memorygame/application/application.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    }

    public void displayMainScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/MainView.fxml");
        MainController mainController = new MainController(gameController);
        Scene mainScene = this.getScene(fxmlLoader, mainController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    public void displayOverviewScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/OverviewView.fxml");
        OverviewController overviewController = new OverviewController(gameController);
        Scene levelScene = this.getScene(fxmlLoader, overviewController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }
    public void displayLevelScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/LevelView.fxml");
        LevelController levelController = new LevelController(gameController);
        Scene levelScene = this.getScene(fxmlLoader, levelController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }
    public void displayRegScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/RegView.fxml");
        RegController regController = new RegController(gameController);
        Scene levelScene = this.getScene(fxmlLoader, regController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }

    public void displayDeleteConfScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/DeleteConfView.fxml");
        DeleteConfController deleteConfController = new DeleteConfController(gameController);
        Scene levelScene = this.getScene(fxmlLoader,deleteConfController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }

    public void displayNoUserScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/NoUserView.fxml");
        NoUserController noUserController = new NoUserController(gameController);
        Scene levelScene = this.getScene(fxmlLoader, noUserController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }

    public void displayGameCompletedScene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/GameCompletedView.fxml");
        GameCompletedController gameCompletedController = new GameCompletedController(gameController);
        Scene levelScene = this.getScene(fxmlLoader, gameCompletedController);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelScene);
        window.show();
    }

    public void displayLevel4x4Scene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/LevelView4x4.fxml");
        LevelController4x4 levelController4x4 = new LevelController4x4(gameController);
        Scene leveleasyScene = this.getScene(fxmlLoader, levelController4x4);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(leveleasyScene);
        window.show();
    }

    public void displayLevel6x6Scene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/LevelView6x6.fxml");
        LevelController6x6 levelController6x6 = new LevelController6x6(gameController);
        Scene leveleasyScene = this.getScene(fxmlLoader, levelController6x6);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(leveleasyScene);
        window.show();
    }

    public void displayLevel10x10Scene(GameController gameController, Event event) {
        FXMLLoader fxmlLoader = this.getfxmlLoader("com/github/tschierv/memorygame/presentation/LevelView10x10.fxml");
        LevelController10x10 levelController10x10 = new LevelController10x10(gameController);
        Scene levelhardScene = this.getScene(fxmlLoader, levelController10x10);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(levelhardScene);
        window.show();
    }

}