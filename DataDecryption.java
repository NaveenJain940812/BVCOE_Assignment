package Posist;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

public class DataDecryption 
{
	public static void decrypt(Serializable object, String path) throws IOException, NoSuchAlgorithmException,
    NoSuchPaddingException, InvalidKeyException {

SecretKeySpec sks = new SecretKeySpec("data".getBytes(),
        "AES");

Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, sks);

CipherInputStream cipherInputStream = new CipherInputStream( new BufferedInputStream( new FileInputStream(path) ), cipher );
ObjectInputStream inputStream = new ObjectInputStream( cipherInputStream );
SealedObject sealedObject = null;
inputStream.close();
try {
    sealedObject = (SealedObject) inputStream.readObject();
    sealedObject.getObject( cipher );

}
  catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (IllegalBlockSizeException e) {
    e.printStackTrace();
} catch (BadPaddingException e) {
    e.printStackTrace();
}

}
}
