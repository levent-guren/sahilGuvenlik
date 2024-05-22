package util;

import java.util.Base64;

import org.jasypt.exceptions.AlreadyInitializedException;
import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {
	private static AES256TextEncryptor textEncrypter = new AES256TextEncryptor();
	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	static {
		try {
			textEncrypter.setPassword(getBase64Decoded("U2FoaWxHdXZlbmxpaw=="));
		} catch (AlreadyInitializedException ex) {
		}

	}

	private Security() {
	}

	public static String encryptPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public static boolean isPasswordValid(String password, String dbPassword) {
		return passwordEncoder.matches(password, dbPassword);
	}

	public static String getBase64Decoded(String text) {
		return new String(Base64.getDecoder().decode(text));
	}

	public static String encryp(String data) {
		return PropertyValueEncryptionUtils.encrypt(data, textEncrypter);
	}

	public static String decryp(String data) {
		if (data == null || "".equals(data)) {
			return "";
		}
		return PropertyValueEncryptionUtils.decrypt(data, textEncrypter);
	}

	public static void main(String[] args) {
		String tc = encryptPassword("12345678901");
		System.out.println(tc);

	}
}
