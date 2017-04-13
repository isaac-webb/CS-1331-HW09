// I worked on the homework assignment alone, using only course materials.

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
  * An enumeration for the different types of Pokemon
  *
  * @author iwebb6 and CS 1331 Homework Team
  * @version 1.0
  */
public enum Type {
    FIRE, DRAGON, FIGHTING, FAIRY, WATER, DARK, BUG, GRASS, POISON,
    ELECTRIC, PSYCHIC, GHOST;

    /**
      * Creates a view fo the Type as a colored and labeled box
      *
      * @return an HBox view of the Type
      */
    public HBox getTypeView() {
        // Set the background color based on the Type
        Color color = null;
        switch (this) {
        case FIRE:
            color = Color.RED;
            break;
        case WATER:
            color = Color.AQUA;
            break;
        case GRASS:
            color = Color.GREENYELLOW;
            break;
        case POISON:
            color = Color.MEDIUMPURPLE;
            break;
        case ELECTRIC:
            color = Color.YELLOW;
            break;
        case PSYCHIC:
            color = Color.PINK;
            break;
        case DARK:
            color = Color.DARKGRAY;
            break;
        case GHOST:
            color = Color.PURPLE;
            break;
        default:
            color = Color.MAGENTA;
            break;
        }
        // Create an HBox to hold the label
        HBox view = new HBox();
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(5));

        // Create the label, add it to the HBox, and set the background color
        Label type = new Label(this.toString());
        type.setFont(Font.font("Monospace", FontWeight.BLACK, 12));
        view.getChildren().add(type);
        view.setBackground(
            new Background(new BackgroundFill(color, new CornerRadii(0.5),
                                              null)));

        return view;
    }
}
