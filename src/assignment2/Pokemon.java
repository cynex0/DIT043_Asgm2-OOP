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
    private Skill skill;
    private final PokemonType type;

    public Pokemon(String name, int maxHP, String type) {
        this.name = name;
        this.maxHp = maxHP;

        this.energy = MAX_ENERGY;
        this.currentHp = this.maxHp;

        this.skill = null;

        this.type = PokemonType.valueOf(type.toUpperCase());
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

    public boolean isFainted() {
        return (this.currentHp == 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        if (this.type == null) { // to avoid a NullPointerException if wrong type is specified
            return "undefined";
        }
        return this.type.toString();
    }

    public int getMAX_HP() {
        return this.maxHp;
    }

    public String attack(Pokemon other) {
        String message = "";

        // Fail checks
        if (this.isFainted()) {
            message = "Attack failed. " + this.name + " fainted.";
        }
        else if (other.isFainted()) {
            message = "Attack failed. " + other.getName() + " fainted.";
        }

        else if (!this.knowsSkill()) {
            message = "Attack failed. " + this.name + " does not know a skill.";
        }
        else if (this.energy < this.skill.getEnergyCost()) {
            message = String.format("Attack failed. %s lacks energy: %d/%d",
                                 this.name, this.energy, this.skill.getEnergyCost());
        }
        else { // both not fainted, knows skill, has enough energy -> successfull attack
            String effectMessage = "";
            String faintMessage = "";

            double multiplier = PokemonType.getDamageMultiplier(this.getType(), other.getType());

            if (multiplier == 2.0) {
                effectMessage = " It is super effective!";
            } else if (multiplier == 0.5){
                effectMessage = " It is not very effective...";
            }

            other.receiveDamage((int)(this.skill.getAttackPower() * multiplier));
            this.energy -= this.skill.getEnergyCost();
            if (this.energy < 0) {
                this.energy = 0;
            }

            if (other.isFainted()) {
                faintMessage = " " + other.getName() + " faints.";
            }


            // <attacker> uses <skill name> on <target>. <opt_effect>\n
            // <target> has <target_hp> HP left. <opt_faints>
            message = String.format("%s uses %s on %s.%s%n%s has %d HP left.%s",
                                    this.name, this.skill.getName(), other.name, effectMessage,
                                    other.getName(), other.getCurrentHP(), faintMessage);
        }

        return message;
    }

    public void receiveDamage(int dmg) {
        this.currentHp -= dmg;

        if (this.currentHp < 0){
            this.currentHp = 0;
        }
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

    public boolean knowsSkill() {
        return (skill != null); // false if skill is null, true otherwise
    }

    public void learnSkill(String name, int ap, int ec) {
        skill = new Skill(name, ap, ec);
    }

    public void forgetSkill() {
        skill = null;
    }

    public String useItem(Item item){
        if (this.currentHp == this.maxHp) {
             return this.name + " could not use " + item.getName() + ". HP is already full.";
        }

        int hpBefore = this.currentHp;
        this.currentHp += item.getHealingPower();
        if (this.currentHp > this.maxHp) {
            this.currentHp = maxHp;
        }

        return this.name + " used " + item.getName() + ". It healed " + (this.currentHp - hpBefore) + " HP.";
    }

    public String toString() {
        if (this.knowsSkill()) {
            return String.format("%s (%s). Knows %s", this.name, this.type, this.skill.toString());
        } else {
            return String.format("%s (%s)", this.name, this.type);
        }
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

