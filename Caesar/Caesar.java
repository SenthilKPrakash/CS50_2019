package Caesar;

public class Caesar {
    public static void main(String[] args) {
        /* 1.Get key()
           2.Get plainText()
           3.Do encipher() to the plainText
           4.Print cipherText()
         */

        Cipher cipher = new Cipher();

        cipher.getKey();
        cipher.getPlainText();
        cipher.encipher();
        cipher.printCipherText();

    }
}
