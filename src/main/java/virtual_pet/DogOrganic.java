package virtual_pet;

public class DogOrganic extends OrganicPet implements Cleaning, petWalking{

    private boolean cageIsClean;

    public DogOrganic(String name, String petType, boolean dead, String kindOfPet, int hungry, int thirsty, int bored, int health, boolean cageIsClean) {
        super(name, petType, dead, kindOfPet, hungry, thirsty, bored, health);
        this.cageIsClean = cageIsClean;
    }

    public boolean isCageIsClean() {
        return cageIsClean;
    }

    @Override
    public void clean(String typeOrgPet) {
        if (typeOrgPet.equalsIgnoreCase("dog")) {
            System.out.println(typeOrgPet + " cage is clean.");
            cageIsClean = true;
        }
    }

    @Override
    public void walking() {

        if (dead == false) {
            thirsty = thirsty + 3;
            hungry = hungry + 3;
            if (thirsty > thirstyMsg || hungry > hungryMsg) {
                health = 0;
                dead = true;
            }
            bored = bored - 1;
            if (bored <=0 ) {
                bored = 0;
            }
        }

        cageIsClean = true;
    }

    @Override
    public void petPlaying() {
        super.petPlaying();
        cageIsClean = true;
    }

    @Override
    public void makeDirty() {
        //System.out.println("Dog cage is dirty.");
        cageIsClean = false;
    }
}
