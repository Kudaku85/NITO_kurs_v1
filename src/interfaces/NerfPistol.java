package interfaces;

//Interfacet lager "en mal", en slags kontrakt som sier at alle klasser som bruker (implements) et interface må inneholde alt
// som ligger i interfacet.
interface WeaponInterface{
    String fireWeapon();
    String reloadWeapon();
}

//NerfPistol implements WeaponInterface, så da må det også ha metodene fireWeapon() og reloadWeapon()
public class NerfPistol implements WeaponInterface {
    String name;
    int capacity;
    int currentLoad;


    //Metoden er public (tilgjengelig for alt i prosjektet), String (returnerer en String) og heter fireWeapon. Parantesen er tom, så metoden tar ingenting inn

    public String fireWeapon(){
        //Vi bruker += for å knytte sammen disse Strengene til en lang streng, som vi så returnerer.
        String output = "You pull the trigger.";
        output += "The weapon goes Blemfh!";
        output += "You hit Nezar in the face";
        currentLoad--; //Vi har avfyrt et skudd, så "currentLoad" må reduseres med 1.
        return output;
    }

    //Metoden er public (tilgjengelig for alt i prosjektet), String (returnerer en String) og heter reloadWeapon. Parantesen er tom, så metoden tar ingenting inn
    public String reloadWeapon(){
        String output = "You pull back the lever.";
        output += "You insert a fresh dart";
        output += "You're once again armed but not very dangerous";
        currentLoad = capacity; //Siden vi har ladet våpenet vårt, øker vi currentLoad til å matche verdien til capacity
        return output;
    }
}

//NerfShotgun implements WeaponInterface, så da må det også ha metodene fireWeapon() og reloadWeapon()
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

    //Til slutt har vi en main-metode som tester klassene våre.
    public static void main(String[] args) {
        NerfPistol myPistol = new NerfPistol(); //Vi oppretter et objekt av klasse NerfPistol
        myPistol.capacity = 1; //Og gir det noen verdier
        myPistol.currentLoad = 1;
        System.out.println(myPistol.fireWeapon()); //Vi avfyrer det
        System.out.println(myPistol.reloadWeapon()); //Og lader det igjen
        NerfShotgun myShotgun = new NerfShotgun();
        myShotgun.capacity = 2;
        myShotgun.currentLoad = 2;
        System.out.println(myShotgun.fireWeapon());
        System.out.println(myShotgun.reloadWeapon());
    }
}
