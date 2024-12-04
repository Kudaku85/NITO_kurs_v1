package interfaces;

interface WeaponInterface{
    String fireWeapon();
    String reloadWeapon();

}

public class NerfPistol implements WeaponInterface {
    String name;
    int capacity;
    int currentLoad;

    public String fireWeapon(){
        String output = "You pull the trigger.";
        output += "The weapon goes Blemfh!";
        output += "You hit Nezar in the face";
        return output;
    }
    public String reloadWeapon(){
        String output = "You pull back the lever.";
        output += "You insert a fresh dart";
        output = "You're once again armed but not very dangerous";
        return output;
    }
}

class NerfShotgun implements WeaponInterface {
    String name;
    int capacity;
    int currentLoad;

    public String fireWeapon(){
        String output = "You rack the shotgun.";
        output += "You pull the trigger.";
        output += "The shotgun goes Blemfh!";
        output += "You hit Nezar in the face";
        return output;
    }

    public String reloadWeapon() {
        String output = "You turn the shotgun over";
        output += "You insert darts into the feeding mechanism";
        output += "You turn the shotgun back over, you're ready to shoot!";
        return output;
    }
}
