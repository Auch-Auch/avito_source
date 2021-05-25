package com.google.firebase.iid;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class EncryptionKeyUtil {
    public static KeyPairGenerator a() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
            try {
                instance.initialize(new ECGenParameterSpec("prime256v1"));
                return instance;
            } catch (InvalidAlgorithmParameterException unused) {
                try {
                    instance.initialize(new ECGenParameterSpec("secp256r1"));
                    return instance;
                } catch (InvalidAlgorithmParameterException unused2) {
                    throw new RuntimeException("Unable to find the NIST P-256 curve");
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static KeyPair generateEcP256KeyPair() {
        return a().generateKeyPair();
    }

    public static KeyPair generateRSA2048KeyPair() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean isEcP256Supported() {
        try {
            a();
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static SecretKey parseAESKey(byte[] bArr) {
        return new SecretKeySpec(bArr, "AES");
    }
}
