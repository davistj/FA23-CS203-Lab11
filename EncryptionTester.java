
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
        String encryptedFilePath = "src/encrypted.txt";
        String decryptedFilePath = "src/decrypted.txt";
        String inputFilePath = "src/encryptMe.txt";
        String outputFilePath = "src/newEncrypted.txt";
		// between 1 and 10
        int shift = 4; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

		enc.encrypt(inputFilePath, outputFilePath);
		enc.decrypt(encryptedFilePath, decryptedFilePath);

	}


}
