package core;

import java.util.Scanner;

import translators.Decrypter;
import translators.Encrypter;

public class Trifid_Cipher {

	private static final Scanner scan = new Scanner(System.in);
	public static String MESSAGE;
	
	public static void main(String[] args) {
		try {
			while(true) {
				System.out.print("Encrypt or Decrypt(e/d): ");
				String encrypt_decrypt = scan.nextLine();
				if (encrypt_decrypt.equalsIgnoreCase("encrypt") || encrypt_decrypt.equalsIgnoreCase("e")) {
					encrypt();
					break;
				} else if (encrypt_decrypt.equalsIgnoreCase("decrypt") || encrypt_decrypt.equalsIgnoreCase("d")) {
					decrypt();
					break;
				} else {
					System.err.println("Incorrect Answer Given");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
	
	private static final void encrypt() {
		System.out.print("Enter message to be encrypted: ");
		String encrypted_message = scan.nextLine();
		if (Encrypter.encrypt(encrypted_message)) {
			System.out.println(MESSAGE);
		}
		
	}
	
	private static final void decrypt() {
		System.out.print("Enter encrypted message: ");
		String decrypted_message = scan.nextLine();
		if (Decrypter.decrypt(decrypted_message)) {
			System.out.println(MESSAGE);
		}
		
	}

}
