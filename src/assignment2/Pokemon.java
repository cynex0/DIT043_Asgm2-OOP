package assignment2;

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
    private static final int MAX_ENERGY = 100;

    private String name; // can be changed
    private final int maxHp; // assigned once and can't be changed
    private int currentHp; // 0..maxHP, can be changed only as a result of an attack
    private int energy; // 0..100, can be changed only as a result of an attack
    // TODO: Task 2
    // Skill skill;
    private final PokemonType type;

    public Pokemon(String name, int maxHP, String type) {
        this.name = name;
        this.maxHp = maxHP;
//        this.type = PokemonType.valueOf(type.toUpperCase());

        this.energy = MAX_ENERGY;
        this.currentHp = this.maxHp;

        switch(type) {
            case "Fire" -> this.type = PokemonType.FIRE;
            case "Water" -> this.type = PokemonType.WATER;
            case "Grass" -> this.type = PokemonType.GRASS;
            case "Normal" -> this.type = PokemonType.NORMAL;
            default -> this.type = null; // for invalid inputs
        }
    }

    public int getEnergy() {
        return this.energy;
    }
    public int getCurrentHP() {
        return this.currentHp;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        if (this.type == null) {
            return "undefined";
        }
        return this.type.toString();
    }
    public int getMAX_HP() {
        return this.maxHp;
    }

    public void learnSkill(String name, int ap, int ec) {

    }

    public String attack(Pokemon other) {
        return "PLACEHOLDER";
    }

    public void rest() {
        if (this.currentHp > 0) {
            this.currentHp += 20;
        }

        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
    }

    public void recoverEnergy() {
        if (this.currentHp > 0) {
            this.energy += 25;
        }

        if (this.energy > MAX_ENERGY) {
            this.energy = MAX_ENERGY;
        }
    }

    public String useItem(Item item){
        if (this.currentHp == this.maxHp) {
             return this.name + "could not use" + item.getName() + ". HP is already full.";
        }
        int hpBefore = this.currentHp;
        this.currentHp += item.getHealingPower();
        if (this.currentHp > this.maxHp) {
            this.currentHp = maxHp;
        }
        return this.name + " used " + item.getName() + ". It healed " + (this.currentHp - hpBefore) + " HP.";

    }

    public String toString(){
        // if no skill
        return String.format("%s (%s)", this.name, this.type);
    }

    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (!(object instanceof Pokemon))
            return false;

        // at this point, object is guaranteed to be of type Pokemon.
        Pokemon other = (Pokemon)object;
        return (this.name.equals(other.name)) &&
               (this.type == other.type) && // can be used instead of .equals(), avoids NullPointerException (JLS 8.9.1)
               (this.maxHp == other.maxHp) &&
               (this.currentHp == other.currentHp) &&
               (this.energy == other.energy);
    }
}

