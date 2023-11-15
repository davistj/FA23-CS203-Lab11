import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     *
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath     the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
        try (PrintWriter output = new PrintWriter(encryptedFilePath)){
            try (Scanner fileScanner = new Scanner(Paths.get(inputFilePath))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    char[] encrypt_me = line.toCharArray();
                    for (int i=0; i < encrypt_me.length; i++){
                        {
                            System.out.println(encrypt_me[i]);
                      if ((encrypt_me[i]<97+ shift && encrypt_me[i]>97)|| encrypt_me[i]>122) {
                              int newdeci = 122 - ((shift - (encrypt_me[i] - 97)) - 1);
                              int newshift = newdeci - encrypt_me[i];
                              encrypt_me[i]+=newshift;

                          }
                            else if (encrypt_me[i]=='a'|| encrypt_me[i]=='A') {
                            encrypt_me[i]+=22;
                         }
                            else if (encrypt_me[i]>=97 + shift && encrypt_me[i]<=122) {
                            encrypt_me[i] -= shift;
                          }
                          else if ((encrypt_me[i])<65+shift && encrypt_me[i]>65|| (encrypt_me[i]>90 && encrypt_me[i]<97)) {
                          int N =90-(shift- encrypt_me[i]-65)-1;
                          int newshift1=N-encrypt_me[i];
                          encrypt_me[i]+=newshift1;
                       }
                       else if (encrypt_me[i]>=65+shift && encrypt_me[i]<=90) {
                           encrypt_me[i]-=shift;
                      }
                      }

                    }
                    String encrypted = new String(encrypt_me);
                    output.println(encrypted);
                }

                fileScanner.close();


        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("ERROR" + e.toString());
        }

        // Read the file and write the contents to the new file encryptedFilePath




    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath   the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
        shift =+ shift;
      encrypt(messageFilePath, decryptedFilePath);

    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        //TODO: Read file from filePath
        return message;
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) throws FileNotFoundException {
        //TODO: Write to filePath
        try (PrintWriter output = new PrintWriter(filePath)) {
            output.println(data);


        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

        /**
         * Returns a string representation of the encrypted text.
         *
         * @return the encrypted text
         */
        @Override
        public String toString() {
            return encrypted;
        }
}
