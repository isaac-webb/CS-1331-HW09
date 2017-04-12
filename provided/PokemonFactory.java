import java.util.ArrayList;


/**
 * A factory that creates a list of Pokemon for the Pokedex
 */
public final class PokemonFactory {
    private static ArrayList<Pokemon> pokemon;

    /**
     * Creates the list of Pokemon in the Pokedex
     *
     * @return pokemon an arraylist of Pokemon
     */
    public static ArrayList<Pokemon> createPokemon() {
        pokemon = new ArrayList<>();

        Pokemon bulbasaur = new Pokemon("Bulbasaur", "001.png", Type.GRASS,
            Type.POISON);
        bulbasaur.setDescription("A strange seed was planted on its back at "
            + "birth. The plant sprouts and grows with this Pokemon.");
        bulbasaur.setGeneration(1);
        bulbasaur.setNumber(1);
        bulbasaur.createDetailView();

        Pokemon charmander = new Pokemon("Charmander", "004.png", Type.FIRE);
        charmander.setDescription("Obviously prefers hot places. When it "
            + "rains, steam is said to spout from the tip of its tail.");
        charmander.setGeneration(1);
        charmander.setNumber(4);
        charmander.createDetailView();

        Pokemon squirtle = new Pokemon("Squirtle", "007.png", Type.WATER);
        squirtle.setDescription("After birth, its back swells and hardens"
            + " into a shell. Powerfully sprays foam from its mouth.");
        squirtle.setGeneration(1);
        squirtle.setNumber(7);
        squirtle.createDetailView();

        Pokemon pikachu = new Pokemon("Pikachu", "025.png", Type.ELECTRIC);
        pikachu.setDescription("Whenever Pikachu comes across something new, "
            + "it blasts it with a jolt of electricity. If you come across "
            + "a blackened berry, it's evidence that this Pokémon mistook the"
            + " intensity of its charge. ");
        pikachu.setNumber(25);
        pikachu.createDetailView();

        Pokemon abra = new Pokemon("Abra", "063.png", Type.PSYCHIC);
        abra.setNumber(63);
        abra.setDescription("Abra sleeps for eighteen hours a day. However,"
            + " it can sense the presence of foes even while it is sleeping. "
            + "In such a situation, this Pokémon immediately teleports "
            + "to safety. ");
        abra.createDetailView();

        pokemon.add(bulbasaur);
        pokemon.add(charmander);
        pokemon.add(squirtle);
        pokemon.add(pikachu);
        pokemon.add(abra);


        return pokemon;
    }
}
