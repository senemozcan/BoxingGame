public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (checkWeight()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=======New Round=======");
                if (first() == 1){
                    this.f2.health = this.f1.hit(f2);
                    System.out.println(this.f2.name + " health " + this.f2.health);
                    if (isWin()) {
                        break;
                    }

                    this.f1.health = this.f2.hit(f1);
                    System.out.println(this.f1.name + " health " + this.f1.health);
                    if (isWin()) {
                        break;
                    }
                }else {
                    this.f1.health = this.f2.hit(f1);
                    System.out.println(this.f1.name + " health " + this.f1.health);
                    if (isWin()) {
                        break;
                    }

                    this.f2.health = this.f1.hit(f2);
                    System.out.println(this.f2.name + " health " + this.f2.health);
                    if (isWin()) {
                        break;
                    }
                }
            }

        } else {
            System.out.println("weights of the athletes do not match");
        }

    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Winner : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Winner : " + f2.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " remaining life \t:" + f1.health);
        System.out.println(f2.name + " remaining life \t:" + f2.health);
    }

    int first() {
        double firstOne = Math.random() * 100;
        if (firstOne < 50) {
            return 1;
        } else {
            return 0;
        }
    }
}
