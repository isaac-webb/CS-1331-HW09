import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;

/**
 * Class representing a Pokemon that is recorded in the Pokedex
 */
public class Pokemon {
    private String name;
    private HBox type = new HBox();
    private Image pic;
    private String description;
    private int generation;
    private int number;

    /**
     * Creates a Pokemon instance
     *
     * @param name of the Pokemon
     * @param pic the path to the image file
     * @param types the types of the Pokemon
     */
    public Pokemon(String name, String pic, Type ... types) {
        this.name = name;
        for (Type t : types) {
            type.getChildren().add(t.getTypeView());
        }
        type.setSpacing(5);
        this.pic = new Image(pic);

        createSideView();
        createDetailView();
    }

    /**
     * Creates the detail view of the Pokemon to be displayed in
     * the main section of the Pokedex.
     */
    public void createDetailView() {
        //Create the bigger detail view for the main pane here
        //Remember to actually save this view or change this method
        //header to return the view.
        //This method is called inside of PokemonFactory
    }

    /**
     * Creates the list view of the Pokemon to be displayed in
     * the list view panel
     */
    public void createSideView() {
        //create the view that will be displayed for each entry in the list
        //in the side panel.
        //Remember to actually save this view or change this method header
        //to return the view. So that you can actually use it.
        //This method is called inside of PokemonFactory.
    }

    /**
     * Sets the description
     * @param d the description
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Sets the generation
     * @param generation
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * Sets the number of the Pokemon
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
