// Example by Crain the goat
public class Solution {
    static final byte S = 's';
    static final byte P = 'p';
    static final byte R = 'r';
    static final byte K = 'k';
    static final byte L = 'l';
    static final byte SxorL = 0b0001_1111; // Magic
    static final byte RxorK = 0b0001_1001;
    static final byte PxorL = 0b0001_1100;
    static final byte KxorP = 0b0001_1011;
    static final byte RxorS = 0b0000_0001;

    public static void main(String[] args) {
        // Link it up as you'd please.

    }

    public enum Result {
        A_WIN,
        B_WIN,
        TIE
    }

    public static Result calculate(byte a, byte b) {
        a = (byte) (a & SxorL);
        b = (byte) (b & SxorL);
        return a == b ? Result.TIE : wins(a, b) ? Result.A_WIN : wins(b, a) ? Result.B_WIN : Result.TIE;
    }

    public static boolean wins(byte a, byte b) {
        return switch (a) {
            case S -> {
                a = (byte) (P ^ b);
                yield (a == 0 || a == PxorL);
            }
            case P -> {
                a = (byte) (R ^ b);
                yield (a == 0 || a == RxorK);
            }
            case R -> {
                a = (byte) (S ^ b);
                yield (a == 0 || a == SxorL);
            }
            case K -> {
                a = (byte) (R ^ b);
                yield (a == 0 || a == RxorS);
            }
            case L -> {
                a = (byte) (K ^ b);
                yield (a == 0 || a == KxorP);
            }
            default -> false;
        };
    }
}
