public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    double dodge;       //    Dodge, hasarı savuşturma yüzdesidir.
    int critChance;     //    Critical Chance, kritik hasar vurma yüzdesidir.
    int critDamage;     //    Critical Damage, hasarın artış yüzdesidir.


    public Fighter(String name, int damage, int health, int weight, double dodge, int critChance, int critDamage) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if (dodge <= 100 && dodge >= 0) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
        if (critChance <= 100 && critChance >= 0) {
            this.critChance = critChance;
        } else {
            this.critChance = 0;
        }
        this.critDamage = critDamage;
    }

    public int hit(Fighter foe) {
        System.out.println("------------");
        int tempDamage = this.damage;
        if (isCrit()) {
            tempDamage = tempDamage + tempDamage * this.critDamage / 100;
            System.out.println("__ulti__");
        }
        System.out.println(this.name + " => " + foe.name + " " + tempDamage + " has damaged.");
        if (foe.isDodge()) {
            System.out.println(foe.name + " dodges incoming damage.");
            return foe.health;
        }
        if ((foe.health - tempDamage) <= 0) {
            return 0;
        }
        return foe.health - tempDamage;
    }

    public boolean isDodge() {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }

    boolean isCrit() {
        double critChange = Math.random() * 100;
        return this.critChance >= critChange;
    }

}
