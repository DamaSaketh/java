public class Username {

    public static String generateUsername(String fullName) {

        String lower = fullName.toLowerCase();
        String noSpaces = lower.replaceAll("\\s+", "");
        String username = noSpaces.replaceAll("[aeiou]", "");

        return username;
    }

    public static void main(String[] args) {

        String companyName = "Kern Software Solutions";
        String username = generateUsername(companyName);

        System.out.println("Original Name: " + companyName);
        System.out.println("Generated Username: " + username);
    }
}
