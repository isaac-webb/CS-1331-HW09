import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
  * Class representing a Pokemon that is recorded in the Pokedex
  *
  * @author iwebb6 and CS 1331 Homework Team
  * @version 1.0
  */
public class Pokemon {
    private String name;
    private HBox type = new HBox(5);
    private Image pic;
    private String description;
    private int generation;
    private int number;

    /**
      * Creates a Pokemon instance
      *
      * @param name The name of the Pokemon
      * @param pic The path to the image file
      * @param types The types of the Pokemon
      */
    public Pokemon(String name, String pic, Type ... types) {
        this.name = name;
        for (Type t : types) {
            type.getChildren().add(t.getTypeView());
        }
        type.setMaxHeight(Control.USE_PREF_SIZE);
        type.setMaxWidth(Control.USE_PREF_SIZE);
        this.pic = new Image(pic);
    }

    /**
      * Creates the VBox that contains the visuals that should be shown in the
      * detail view for this Pokemon when it is selected.
      *
      * @return An VBox containing all of the Pokemon's information
      */
    public VBox createDetailView() {
        // Create the ImageView
        ImageView imageView = new ImageView();
        imageView.setImage(pic);

        // Animate!
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kv = new KeyValue(imageView.rotateProperty(), 20);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();

        // Create all of the Labels necessary for the pokemon
        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label numberLabel = new Label(String.format("#%d", number));
        Label generationLabel = new Label(
            String.format("Generation: %d", generation));
        Text descriptionText = new Text(description);
        descriptionText.setWrappingWidth(400);

        // Create and add the content to the VBox
        VBox vbox = new VBox(16);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(imageView, nameLabel, type, numberLabel,
                                  generationLabel, descriptionText);

        return vbox;
    }

    /**
      * Creates the HBox that contains the visuals that should be shown in a
      * Cell of the ListView for this Pokemon.
      *
      * @return An HBox containing the Pokemon's image and name
      */
    public HBox createSideView() {
        // Create the ImageView
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kv = new KeyValue(imageView.rotateProperty(), 20);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();

        // Create the HBox
        HBox sideView = new HBox(16);
        sideView.getChildren().addAll(imageView, new Label(name));
        sideView.setAlignment(Pos.CENTER);

        return sideView;
    }

    /**
      * Sets the Pokemon's description
      *
      * @param d The description
      */
    public void setDescription(String d) {
        description = d;
    }

    /**
      * Sets the Pokemon's generation
      *
      * @param generation The generation
      */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
      * Sets the Pokemon's number
      *
      * @param number The number
      */
    public void setNumber(int number) {
        this.number = number;
    }
}
