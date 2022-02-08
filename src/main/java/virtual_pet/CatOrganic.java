package virtual_pet;

public class CatOrganic extends OrganicPet implements Cleaning{

    private  boolean litterBoxIsClean;

    public CatOrganic(String name, String petType, boolean dead, String kindOfPet, int hungry, int thirsty, int bored, int health, boolean litterBoxIsClean) {
        super(name, petType, dead, kindOfPet, hungry, thirsty, bored, health);
        this.litterBoxIsClean = litterBoxIsClean;
    }

    public boolean isLitterBoxIsClean() {
        return litterBoxIsClean;
    }

    @Override
    public void clean(String typeOrgPet) {
        if (typeOrgPet.equalsIgnoreCase("cat")) {
            System.out.println(typeOrgPet + " litter box is clean.");
        }
    }

    @Override
    public void petPlaying() {
        super.petPlaying();
        litterBoxIsClean = true;
    }

    @Override
    public void makeDirty() {
        //System.out.println("Cat litter box is dirty.");
        litterBoxIsClean = false;
    }

}
