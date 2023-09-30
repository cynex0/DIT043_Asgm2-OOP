package assignment2;

public class Pokemon {
    // constants for ease of code modification, values according to specification
    private static final int MAX_ENERGY = 100;
    private static final int HP_HEAL_AMOUNT = 20;
    private static final int EP_HEAL_AMOUNT = 25;

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

        // convert the given string to uppercase, since enum constants are uppercase by convention.
        this.type = PokemonType.valueOf(type.toUpperCase()); //this assumes that input is correct, could lead to errors!
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getMAX_HP() {
        return this.maxHp;
    }

    public int getCurrentHP() {
        return this.currentHp;
    }

    public int getEnergy() {
        return this.energy;
    }

    public String getType() {
        return this.type.toString();
    }

    // setters
    public void setName(String name) { // no usages, but required in specification
        this.name = name;
    }

    public void receiveDamage(int dmg) {
        // reduces currentHp by dmg, cannot be < 0
        this.currentHp -= dmg;

        if (this.currentHp < 0){
            this.currentHp = 0;
        }
    }

    public void rest() {
        // restores Hp, cannot be > maxHp
        if (this.currentHp > 0) {
            this.currentHp += HP_HEAL_AMOUNT;
        }

        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
    }

    public void recoverEnergy() {
        // restores Ep, cannot be > MAX_ENERGY
        if (this.currentHp > 0) {
            this.energy += EP_HEAL_AMOUNT;
        }

        if (this.energy > MAX_ENERGY) {
            this.energy = MAX_ENERGY;
        }
    }

    public void learnSkill(String name, int ap, int ec) {
        skill = new Skill(name, ap, ec);
    }

    public void forgetSkill() {
        skill = null;
    }

    // helpers
    public boolean isFainted() {
        return (this.currentHp == 0);
    }

    public boolean knowsSkill() {
        return (skill != null); // false if skill is null, true otherwise
    }

    // behaviour
    public String attack(Pokemon other) {
        // Fail checks
        if (this.isFainted()) {
            return "Attack failed. " + this.name + " fainted.";
        }

        if (other.isFainted()) {
            return "Attack failed. " + other.getName() + " fainted.";
        }

        if (!this.knowsSkill()) {
            return "Attack failed. " + this.name + " does not know a skill.";
        }

        if (this.energy < this.skill.getEnergyCost()) {
            // Attack failed. <attacker> lacks energy: <ep>/<ec>
            return String.format("Attack failed. %s lacks energy: %d/%d",
                                 this.name, this.energy, this.skill.getEnergyCost());
        }

        // both not fainted, knows skill, has enough energy -> successfull attack
        String effectMessage = "";
        String faintMessage = "";

        double multiplier = PokemonType.getDamageMultiplier(this.getType(), other.getType());

        // add extra message in case of special attack effectiveness
        if (multiplier == 2.0) {
            effectMessage = " It is super effective!";
        } else if (multiplier == 0.5){
            effectMessage = " It is not very effective...";
        }

        int damage = (int)(this.skill.getAttackPower() * multiplier);
        other.receiveDamage(damage);

        // decrease energy by attack cost
        this.energy -= this.skill.getEnergyCost();
        if (this.energy < 0) {
            this.energy = 0;
        }

        if (other.isFainted()) {
            faintMessage = " " + other.getName() + " faints.";
        }

        // <attacker> uses <skill name> on <target>. <opt_effect>\n
        // <target> has <target_hp> HP left. <opt_faints>
        return String.format("%s uses %s on %s.%s%n%s has %d HP left.%s",
                             this.name, this.skill.getName(), other.name, effectMessage,
                             other.getName(), other.getCurrentHP(), faintMessage);
    }

    public String useItem(Item item) {
        if (this.currentHp == this.maxHp) {
            // <poke name> could not use <item name>. HP is already full.
             return this.name + " could not use " + item.getName() + ". HP is already full.";
        }

        int hpBefore = this.currentHp;
        this.currentHp += item.getHealingPower();
        if (this.currentHp > this.maxHp) {
            this.currentHp = maxHp;
        }

        // <poke name> used <item name>. It healed <amount healed> HP.
        return this.name + " used " + item.getName() + ". It healed " + (this.currentHp - hpBefore) + " HP.";
    }

    // overrides
    public String toString() {
        if (this.knowsSkill()) {
            // <poke name> (<type>). Knows <skill name> - AP: <ap> EC: <ec>
            return String.format("%s (%s). Knows %s", this.name, this.type, this.skill.toString());
        } else {
            // <poke name> (<type>)
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

        Pokemon other = (Pokemon)object;

        // Two pokemons are equal if they have the same name, type, skill, HP, MAX HP, and EP.
        return (this.name.equals(other.name)) &&
               (this.type == other.type) && // can be used instead of .equals(), avoids NullPointerException (JLS 8.9.1)
               (this.maxHp == other.maxHp) &&
               (this.currentHp == other.currentHp) &&
               (this.energy == other.energy);
    }
}

