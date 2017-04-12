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
 * An enumeration of the different types of pokemon
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
        HBox view = new HBox();
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(5));

        Label type = new Label(this.toString());
        type.setFont(Font.font("Monospace", FontWeight.BLACK, 12));
        view.getChildren().add(type);
        view.setBackground(new Background(new BackgroundFill(color,
            new CornerRadii(0.5), null)));

        return view;
    }
}
