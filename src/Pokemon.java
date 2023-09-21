/*
Each pokemon has a name, a maximum health points (MAX HP), energy points (EP), a single skill (Task 2), and a type.
A pokemon can be one of four types: Fire, Water, Grass and Normal. When created, the EP always starts at 100, and the
pokemon does not know any skill. On the other hand, the name, MAX HP and type must be specified.

Pokemon also have current health points (HP), which can change, but not their maximum health points (MAX HP). In fact,
a pokemon’s current HP cannot be less than zero, or greater than its MAX HP. Similarly, EP can never be less than zero
or greater than 100. When creating a Pokemon, its current HP and current EP are the same value as their corresponding
maximum HP and EP. From now, we use HP to refer to the current HP and MAX HP to refer to the maximum health points.

After creation, we can change the name of a pokemon but not its type or MAX HP. Also, we cannot set its HP and EP to a
specific value. HP and EP can only be changed as a consequence of battling (details in Tasks below).

Two pokemons are equal if they have the same name, type, skill, HP, MAX HP, and EP. When printed, the pokemon should
return one of two options below
*/

public class Pokemon {
    public enum Type {
        fire, water, grass, normal
    }

    String name;
    private final int MAX_HP;
    private int hp; // 0..maxHP
    private int ep; // 0..100
    // TODO: Task 2
    // Skill skill;
    final Type type;

    Pokemon(String name, int maxHP, Type type) {
        this.name = name;
        this.MAX_HP = maxHP;
        this.type = type;

        this.ep = 100;
        this.hp = this.MAX_HP;
    }

    public String toString(){
        // if no skill
        return String.format("%s (%s)", this.name, this.type);
    }

    public boolean equals(Object o) {
        Pokemon other = (Pokemon) o;
        return (this.name.equals(other.name)) &&
                (this.type.equals(other.type)) &&
                (this.MAX_HP == other.MAX_HP) &&
                (this.hp == other.hp) &&
                (this.ep == other.ep);
    }

    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Name", 12, Type.water);
        Pokemon pokemon2 = new Pokemon("Name", 12, Type.water);
        System.out.println(pokemon.equals(pokemon2));
    }
}

