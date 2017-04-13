// I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.collections.FXCollections;

/**
  * This class defines the Pokedex, which is a GUI that shows information on a
  * collection of Pokemon.
  *
  * @author iwebb6
  * @version 1.0
  */
public class Pokedex extends Application {
    private Stage stage;

    /**
      * The method that is run when the JavaFX Application launches
      *
      * @param Stage primaryStage The Application's primary Stage (window)
      */
    @Override
    public void start(Stage primaryStage) {
        // Save the stage for later use
        stage = primaryStage;

        // Present the splashscreen
        presentSplashScreen();
    }

    // Presents the Pokedex splashscreen
    private void presentSplashScreen() {
        // Create the button and the title
        Text title = new Text("CS 1331 Pokedex");
        Button button = new Button("Go!");
        button.setOnAction(e -> {
                switchToPokedexScene();
            });

        // Create the VBox to contain the title and button
        VBox vbox = new VBox(16);
        vbox.setMaxHeight(Control.USE_PREF_SIZE);
        vbox.setMaxWidth(Control.USE_PREF_SIZE);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title, button);

        // Create the StackPane to put everything into
        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        // Add in the background image
        pane.setStyle("-fx-background-image: url(\"./splashscreen.jpeg\");"
                      + "-fx-background-size: cover;");

        // Present the Scene
        Scene scene = new Scene(pane, 1000, 700);
        stage.setTitle("Pokedex");
        stage.setScene(scene);
        stage.show();
    }

    private class PokemonListCell extends ListCell<Pokemon> {
        @Override
        public void updateItem(Pokemon pokemon, boolean empty) {
            super.updateItem(pokemon, empty);
            if (pokemon != null) {
                setGraphic(pokemon.createSideView());
            }
        }
    }

    private void switchToPokedexScene() {
        // Create the left list view and implement custom cells
        ListView<Pokemon> listView = new ListView<>(
            FXCollections.observableArrayList(PokemonFactory.createPokemon()));
        listView.setCellFactory(list -> {
                return new PokemonListCell();
            });

        BorderPane pane = new BorderPane();
        pane.setLeft(listView);

        // Add the selection listener
        listView.getSelectionModel().selectedItemProperty().addListener(
            (ov, oldVal, newVal) -> {
                ScrollPane detail = new ScrollPane();
                detail.setContent(newVal.createDetailView());
                detail.setFitToWidth(true);
                pane.setCenter(detail);
            });
        listView.getSelectionModel().selectFirst();

        // Create and present the scene
        Scene scene = new Scene(pane, 1000, 700);
        stage.setScene(scene);
    }
}
