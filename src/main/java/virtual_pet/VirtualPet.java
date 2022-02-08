package virtual_pet;

public abstract class VirtualPet {

    protected String name;
    protected String petType;
    protected boolean dead;
    protected String kindOfPet;

    protected int hungryMsg = 12;
    protected int thirstyMsg = 12;
    protected int boredMsg = 8;

    public VirtualPet(String name, String petType, boolean dead,String kindOfPet) {
        this.name = name;
        this.petType = petType;
        this.dead = dead;
        this.kindOfPet =kindOfPet;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return dead;
    }

    public String getPetType() {
        return petType;
    }

    public String getKindOfPet() {
        return kindOfPet;
    }

    @Override
    public String toString() {
        return "VirtualPet{" +
                "name='" + name + '\'' +
                ", petType='" + petType + '\'' +
                ", dead=" + dead +
                '}';
    }
}
