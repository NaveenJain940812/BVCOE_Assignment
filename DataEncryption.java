package Posist;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

public class DataEncryption 
{
	public static void encrypt(Serializable object, String path) throws IOException, NoSuchAlgorithmException,
    NoSuchPaddingException, InvalidKeyException {

  try {

    // Length is 16 byte
    SecretKeySpec sks = new SecretKeySpec("data".getBytes(),
            "AES/ECB/PKCS5Padding");


    // Create cipher
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, sks);
    SealedObject sealedObject = new SealedObject(object, cipher);
    // Wrap the output stream
    CipherOutputStream cos = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(path)), cipher);
    ObjectOutputStream outputStream = new ObjectOutputStream(cos);
    outputStream.writeObject(sealedObject);
    outputStream.close();
}
catch(IllegalBlockSizeException e){

    e.printStackTrace();

}
}
}
