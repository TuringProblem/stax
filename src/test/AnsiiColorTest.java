
public class AnsiiColorTest {

    public static void main(String[] args) {
        if (args[0].equalsIgnoreCase("colortest")) {
            System.out.println("\033[30mBlack Text\033[0m");
            System.out.println("\033[31mRed Text\033[0m");
            System.out.println("\033[32mGreen Text\033[0m");
            System.out.println("\033[33mYellow Text\033[0m");
            System.out.println("\033[34mBlue Text\033[0m");
            System.out.println("\033[35mMagenta Text\033[0m");
            System.out.println("\033[36mCyan Text\033[0m");
            System.out.println("\033[37mWhite Text\033[0m");
            System.out.println("\033[90mBright Black? lmfao tf? Text\033[0m");
            System.out.println("\033[91mBright Red Text\033[0m");
            System.out.println("\033[92mBright Green Text\033[0m");
            System.out.println("\033[93mBright Yellow Text\033[0m");
            System.out.println("\033[94mBright Blue Text\033[0m");
            System.out.println("\033[95mBright Magenta Text\033[0m");
            System.out.println("\033[96mBright Cyan Text\033[0m");
            System.out.println("\033[97mBright White Text\033[0m");
        }
        /*
         * if (args[0].equalsIgnoreCase("colordesign")) {
         * for (CardRarity rarity : CardRarity.values()) {
         * System.out.printf("%sforeground color:)\n",
         * CardRarity.ROOKIE.getForegroundColor());
         * System.out.println(rarity);
         * }
         * }
         */
    }

    public static <T extends Enum<T>> void printEnum(T[] values) {
        System.out.println(java.util.Arrays.asList(values));
    }

}
