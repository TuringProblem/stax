public class BitwiseHello {
  public static void main(String[] args) {
    String m = "";
    m += (char) (((72 & 31 | 64) % 95) + 32);
    m += (char) (((101 & 31 | 64) % 95) + 32);
    m += (char) (((108 & 31 | 64) % 95) + 32);
    m += (char) (((108 & 31 | 64) % 95) + 32);
    m += (char) (((47 & 31 | 64) % 95) + 32);
    m += (char) (((31 & 31 | 64) % 95) + 32);
    m += (char) (((55 & 31 | 64) % 95) + 32);
    m += (char) (((47 & 31 | 64) % 95) + 32);
    m += (char) (((50 & 31 | 64) % 95) + 32);
    m += (char) (((44 & 31 | 64) % 95) + 32);
    m += (char) (((484 & 31 | 64) % 95) + 32);
    System.out.println(m);
  }
}
