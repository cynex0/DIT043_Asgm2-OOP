package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {

    private static final String EOL = System.lineSeparator();

    @Test
    public void shouldCheckDragonSuperEffective(){
        Pokemon dragonite = new Pokemon("Dragonite", 250, "Dragon");
        dragonite.learnSkill("Dragon dance", 40, 25);

        Pokemon giratina = new Pokemon("Giratina", 300, "Dragon");
        giratina.learnSkill("Dragon rush", 80, 30);

        String resultGiratinaAtt = "Giratina uses Dragon rush on Dragonite. It is super effective!" + EOL +
                "Dragonite has 90 HP left.";

        String resultDragoniteAtt = "Dragonite uses Dragon dance on Giratina. It is super effective!" + EOL +
                "Giratina has 220 HP left.";

        assertEquals(resultGiratinaAtt, giratina.attack(dragonite));
        assertEquals(resultDragoniteAtt, dragonite.attack(giratina));

        String resultDragoniteFaints = "Giratina uses Dragon rush on Dragonite. It is super effective!" + EOL +
                "Dragonite has 0 HP left. Dragonite faints.";

        assertEquals(resultDragoniteFaints, giratina.attack(dragonite));
    }

    @Test
    public void shouldCheckDragonNotEffective(){
        Pokemon dragonite = new Pokemon("Dragonite", 250, "Dragon");
        dragonite.learnSkill("Dragon dance", 40, 25);

        Pokemon charizard = new Pokemon("Charizard", 210, "Fire");
        charizard.learnSkill("Fire blast", 100, 90);

        Pokemon blastoise = new Pokemon("Blastoise", 210, "Water");
        blastoise.learnSkill("Hydro pump", 110, 95);

        Pokemon electrode = new Pokemon("Electrode", 110, "Electric");
        electrode.learnSkill("Thunder", 90, 70);

        Pokemon tangela = new Pokemon("Tangela", 110, "Grass");
        tangela.learnSkill("Solar beam", 95, 80);

        String tangelaAtt = "Tangela uses Solar beam on Dragonite. It is not very effective..." + EOL +
                "Dragonite has 203 HP left.";

        String blastoiseAtt = "Blastoise uses Hydro pump on Dragonite. It is not very effective..." + EOL +
                "Dragonite has 148 HP left.";

        String electrodeAtt = "Electrode uses Thunder on Dragonite. It is not very effective..." + EOL +
                "Dragonite has 103 HP left.";

        assertEquals(tangelaAtt, tangela.attack(dragonite));
        assertEquals(blastoiseAtt, blastoise.attack(dragonite));
        assertEquals(electrodeAtt, electrode.attack(dragonite));

    }

    @Test
    public void shouldCheckIceSuperEffective(){
        Pokemon jynx = new Pokemon("Jynx", 130, "Ice");
        jynx.learnSkill("Ice beam", 60, 30);

        Pokemon dragonair = new Pokemon("Dragonair", 180, "Dragon");
        Pokemon exeggutor = new Pokemon("Exeggutor", 200, "Grass");

        String damageDragonair = "Jynx uses Ice beam on Dragonair. It is super effective!" + EOL +
                "Dragonair has 60 HP left.";

        String damageExeggu = "Jynx uses Ice beam on Exeggutor. It is super effective!" + EOL +
                "Exeggutor has 80 HP left.";

        assertEquals(damageDragonair, jynx.attack(dragonair));
        assertEquals(damageExeggu, jynx.attack(exeggutor));

        String exegguFaints = "Jynx uses Ice beam on Exeggutor. It is super effective!" + EOL +
                "Exeggutor has 0 HP left. Exeggutor faints.";
        assertEquals(exegguFaints, jynx.attack(exeggutor));
    }

    @Test
    public void shouldCheckIceNotEffective(){
        Pokemon jynx = new Pokemon("Jynx", 130, "Ice");
        jynx.learnSkill("Ice punch", 75, 25);

        Pokemon articuno = new Pokemon("Articuno", 350, "Ice");
        Pokemon starmie = new Pokemon("Starmie", 120, "Water");
        Pokemon arcanine = new Pokemon("Arcanine", 150, "Fire");

        String damageArticuno = "Jynx uses Ice punch on Articuno. It is not very effective..." + EOL +
                "Articuno has 313 HP left.";

        String damageStarmie = "Jynx uses Ice punch on Starmie. It is not very effective..." + EOL +
                "Starmie has 83 HP left.";

        String damageArcan = "Jynx uses Ice punch on Arcanine. It is not very effective..." + EOL +
                "Arcanine has 113 HP left.";

        assertEquals(damageArticuno, jynx.attack(articuno));
        assertEquals(damageStarmie, jynx.attack(starmie));
        assertEquals(damageArcan, jynx.attack(arcanine));
    }

    @Test
    public void shouldCheckBugSuperEffective(){
        Pokemon butterfree = new Pokemon("Butterfree", 100, "Bug");
        butterfree.learnSkill("Bug bite", 55, 28);

        Pokemon gloom = new Pokemon("Gloom", 120, "Grass");

        String damageGloom = "Butterfree uses Bug bite on Gloom. It is super effective!" + EOL +
                "Gloom has 10 HP left.";

        assertEquals(damageGloom, butterfree.attack(gloom));

        String faintGloom = "Butterfree uses Bug bite on Gloom. It is super effective!" + EOL +
                "Gloom has 0 HP left. Gloom faints.";

        assertEquals(faintGloom, butterfree.attack(gloom));
    }

    @Test
    public void shouldCheckBugNotEffective(){
        Pokemon butterfree = new Pokemon("Butterfree", 100, "Bug");
        butterfree.learnSkill("Bug bite", 55, 28);

        Pokemon ponyta = new Pokemon("Ponyta", 100, "Fire");

        String damagePonyta = "Butterfree uses Bug bite on Ponyta. It is not very effective..." + EOL +
                "Ponyta has 73 HP left.";
        assertEquals(damagePonyta, butterfree.attack(ponyta));
    }

    @Test
    public void shoudlCheckElectricSuperEffective(){
        Pokemon raichu = new Pokemon("Raichu", 125, "Electric");
        raichu.learnSkill("Thunderbolt", 60, 30);

        Pokemon vaporeon = new Pokemon("Vaporeon", 130, "Water");

        String damageVaporeon = "Raichu uses Thunderbolt on Vaporeon. It is super effective!" + EOL +
                "Vaporeon has 10 HP left.";
        assertEquals(damageVaporeon, raichu.attack(vaporeon));

        String vaporeonFaints = "Raichu uses Thunderbolt on Vaporeon. It is super effective!" + EOL +
                "Vaporeon has 0 HP left. Vaporeon faints.";
        assertEquals(vaporeonFaints, raichu.attack(vaporeon));
    }

    @Test
    public void shoudlCheckElectricNotEffective(){
        Pokemon raichu = new Pokemon("Raichu", 125, "Electric");
        raichu.learnSkill("Thunderbolt", 60, 30);

        Pokemon meganium = new Pokemon("Meganium", 150, "Grass");
        Pokemon giratina = new Pokemon("Giratina", 200, "Dragon");
        Pokemon electabuzz = new Pokemon("Electabuzz", 180, "Electric");

        String damageMegan = "Raichu uses Thunderbolt on Meganium. It is not very effective..." + EOL +
                "Meganium has 120 HP left.";
        assertEquals(damageMegan, raichu.attack(meganium));

        String damageGira = "Raichu uses Thunderbolt on Giratina. It is not very effective..." + EOL +
                "Giratina has 170 HP left.";
        assertEquals(damageGira, raichu.attack(giratina));

        String damageElect = "Raichu uses Thunderbolt on Electabuzz. It is not very effective..." + EOL +
                "Electabuzz has 150 HP left.";
        assertEquals(damageElect, raichu.attack(electabuzz));
    }

    @Test
    public void shoudlCheckWaterNotEffective(){
        Pokemon cloyster = new Pokemon("Cloyster", 270, "Water");
        cloyster.learnSkill("Aqua ring", 50, 20);

        Pokemon meganium = new Pokemon("Meganium", 150, "Grass");
        Pokemon seaking = new Pokemon("Seaking", 120, "Water");
        Pokemon latias = new Pokemon("Latias", 135, "Dragon");

        String damageMegan = "Cloyster uses Aqua ring on Meganium. It is not very effective..." + EOL +
                "Meganium has 125 HP left.";
        assertEquals(damageMegan, cloyster.attack(meganium));

        String damageGira = "Cloyster uses Aqua ring on Seaking. It is not very effective..." + EOL +
                "Seaking has 95 HP left.";
        assertEquals(damageGira, cloyster.attack(seaking));

        String damageElect = "Cloyster uses Aqua ring on Latias. It is not very effective..." + EOL +
                "Latias has 110 HP left.";
        assertEquals(damageElect, cloyster.attack(latias));
    }

    @Test
    public void shoudlCheckFireSuperEffective(){
        Pokemon moltres = new Pokemon("Moltres", 290, "Fire");
        moltres.learnSkill("Flamethrower", 50, 30);

        Pokemon meganium = new Pokemon("Meganium", 150, "Grass");
        Pokemon beedrill = new Pokemon("Beedrill", 105, "Bug");
        Pokemon froslass = new Pokemon("Froslass", 120, "Ice");

        String damageMegan = "Moltres uses Flamethrower on Meganium. It is super effective!" + EOL +
                "Meganium has 50 HP left.";
        assertEquals(damageMegan, moltres.attack(meganium));

        String damageBee = "Moltres uses Flamethrower on Beedrill. It is super effective!" + EOL +
                "Beedrill has 5 HP left.";
        assertEquals(damageBee, moltres.attack(beedrill));

        String damageFros = "Moltres uses Flamethrower on Froslass. It is super effective!" + EOL +
                "Froslass has 20 HP left.";
        assertEquals(damageFros, moltres.attack(froslass));
        moltres.recoverEnergy();

        String faintBee = "Moltres uses Flamethrower on Beedrill. It is super effective!" + EOL +
                "Beedrill has 0 HP left. Beedrill faints.";
        assertEquals(faintBee, moltres.attack(beedrill));
    }

    @Test
    public void shoudlCheckFireNotEffective() {
        Pokemon moltres = new Pokemon("Moltres", 290, "Fire");
        moltres.learnSkill("Flamethrower", 50, 30);

        Pokemon flareon = new Pokemon("Flareon", 130, "Fire");
        Pokemon kingdra = new Pokemon("Kingdra", 140, "Dragon");
        Pokemon gyarados = new Pokemon("Gyarados", 150, "Water");

        String damageFlar = "Moltres uses Flamethrower on Flareon. It is not very effective..." + EOL +
                "Flareon has 105 HP left.";
        assertEquals(damageFlar, moltres.attack(flareon));

        String damageKing = "Moltres uses Flamethrower on Kingdra. It is not very effective..." + EOL +
                "Kingdra has 115 HP left.";
        assertEquals(damageKing, moltres.attack(kingdra));

        String damageGya = "Moltres uses Flamethrower on Gyarados. It is not very effective..." + EOL +
                "Gyarados has 125 HP left.";
        assertEquals(damageGya, moltres.attack(gyarados));
    }

    @Test
    public void shoudlCheckGrassNotEffective() {
        Pokemon eldegloss = new Pokemon("Eldegloss", 130, "Grass");
        eldegloss.learnSkill("Vine whip", 40, 20);

        Pokemon flareon = new Pokemon("Flareon", 130, "Fire");
        Pokemon parasect = new Pokemon("Parasect", 150, "Bug");
        Pokemon dragapult = new Pokemon("Dragapult", 100, "Dragon");
        Pokemon jumpluff = new Pokemon("Jumpluff", 90, "Grass");

        String damageFlar = "Eldegloss uses Vine whip on Flareon. It is not very effective..." + EOL +
                "Flareon has 110 HP left.";
        assertEquals(damageFlar, eldegloss.attack(flareon));

        String damagePara = "Eldegloss uses Vine whip on Parasect. It is not very effective..." + EOL +
                "Parasect has 130 HP left.";
        assertEquals(damagePara, eldegloss.attack(parasect));

        String damageDrag = "Eldegloss uses Vine whip on Dragapult. It is not very effective..." + EOL +
                "Dragapult has 80 HP left.";
        assertEquals(damageDrag, eldegloss.attack(dragapult));

        String damageJump = "Eldegloss uses Vine whip on Jumpluff. It is not very effective..." + EOL +
                "Jumpluff has 70 HP left.";
        assertEquals(damageJump, eldegloss.attack(jumpluff));
    }
}
