package opgave01;

import opgave01.models.Vault;

public class Opgave01 {
    public static void main(String[] args) {
        Vault<Integer> integerVault = new Vault(42, "My password");
        System.out.println(integerVault.getSecret("My password"));
    }
}
