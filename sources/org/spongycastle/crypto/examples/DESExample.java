package org.spongycastle.crypto.examples;

import a2.b.a.a.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.encoders.Hex;
public class DESExample {
    public boolean a;
    public PaddedBufferedBlockCipher b;
    public BufferedInputStream c;
    public BufferedOutputStream d;
    public byte[] e;

    public DESExample() {
        this.a = true;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public static void main(String[] strArr) {
        String str;
        boolean z;
        if (strArr.length < 2) {
            new DESExample();
            PrintStream printStream = System.err;
            StringBuilder L = a.L("Usage: java ");
            L.append(DESExample.class.getName());
            L.append(" infile outfile [keyfile]");
            printStream.println(L.toString());
            System.exit(1);
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        if (strArr.length > 2) {
            str = strArr[2];
            z = false;
        } else {
            str = "deskey.dat";
            z = true;
        }
        DESExample dESExample = new DESExample(str2, str3, str, z);
        PaddedBufferedBlockCipher paddedBufferedBlockCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()));
        dESExample.b = paddedBufferedBlockCipher;
        if (dESExample.a) {
            paddedBufferedBlockCipher.init(true, new KeyParameter(dESExample.e));
            byte[] bArr = new byte[47];
            byte[] bArr2 = new byte[dESExample.b.getOutputSize(47)];
            while (true) {
                try {
                    int read = dESExample.c.read(bArr, 0, 47);
                    if (read > 0) {
                        int processBytes = dESExample.b.processBytes(bArr, 0, read, bArr2, 0);
                        if (processBytes > 0) {
                            byte[] encode = Hex.encode(bArr2, 0, processBytes);
                            dESExample.d.write(encode, 0, encode.length);
                            dESExample.d.write(10);
                        }
                    } else {
                        try {
                            break;
                        } catch (CryptoException unused) {
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            int doFinal = dESExample.b.doFinal(bArr2, 0);
            if (doFinal > 0) {
                byte[] encode2 = Hex.encode(bArr2, 0, doFinal);
                dESExample.d.write(encode2, 0, encode2.length);
                dESExample.d.write(10);
            }
        } else {
            paddedBufferedBlockCipher.init(false, new KeyParameter(dESExample.e));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dESExample.c));
            byte[] bArr3 = null;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    byte[] decode = Hex.decode(readLine);
                    bArr3 = new byte[dESExample.b.getOutputSize(decode.length)];
                    int processBytes2 = dESExample.b.processBytes(decode, 0, decode.length, bArr3, 0);
                    if (processBytes2 > 0) {
                        dESExample.d.write(bArr3, 0, processBytes2);
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            int doFinal2 = dESExample.b.doFinal(bArr3, 0);
            if (doFinal2 > 0) {
                dESExample.d.write(bArr3, 0, doFinal2);
            }
        }
        try {
            dESExample.c.close();
            dESExample.d.flush();
            dESExample.d.close();
        } catch (IOException e4) {
            PrintStream printStream2 = System.err;
            StringBuilder L2 = a.L("exception closing resources: ");
            L2.append(e4.getMessage());
            printStream2.println(L2.toString());
        }
    }

    public DESExample(String str, String str2, String str3, boolean z) {
        SecureRandom secureRandom;
        this.a = true;
        SecureRandom secureRandom2 = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = z;
        try {
            this.c = new BufferedInputStream(new FileInputStream(str));
        } catch (FileNotFoundException unused) {
            PrintStream printStream = System.err;
            printStream.println("Input file not found [" + str + "]");
            System.exit(1);
        }
        try {
            this.d = new BufferedOutputStream(new FileOutputStream(str2));
        } catch (IOException unused2) {
            PrintStream printStream2 = System.err;
            printStream2.println("Output file not created [" + str2 + "]");
            System.exit(1);
        }
        if (z) {
            try {
                secureRandom = new SecureRandom();
                try {
                    secureRandom.setSeed("www.bouncycastle.org".getBytes());
                } catch (Exception unused3) {
                    secureRandom2 = secureRandom;
                }
            } catch (Exception unused4) {
                try {
                    System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");
                    System.exit(1);
                    secureRandom = secureRandom2;
                    KeyGenerationParameters keyGenerationParameters = new KeyGenerationParameters(secureRandom, 192);
                    DESedeKeyGenerator dESedeKeyGenerator = new DESedeKeyGenerator();
                    dESedeKeyGenerator.init(keyGenerationParameters);
                    this.e = dESedeKeyGenerator.generateKey();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                    byte[] encode = Hex.encode(this.e);
                    bufferedOutputStream.write(encode, 0, encode.length);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return;
                } catch (IOException unused5) {
                    PrintStream printStream3 = System.err;
                    printStream3.println("Could not decryption create key file [" + str3 + "]");
                    System.exit(1);
                    return;
                }
            }
            KeyGenerationParameters keyGenerationParameters = new KeyGenerationParameters(secureRandom, 192);
            DESedeKeyGenerator dESedeKeyGenerator = new DESedeKeyGenerator();
            dESedeKeyGenerator.init(keyGenerationParameters);
            this.e = dESedeKeyGenerator.generateKey();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
            byte[] encode = Hex.encode(this.e);
            bufferedOutputStream.write(encode, 0, encode.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str3));
            int available = bufferedInputStream.available();
            byte[] bArr = new byte[available];
            bufferedInputStream.read(bArr, 0, available);
            this.e = Hex.decode(bArr);
        } catch (IOException unused6) {
            PrintStream printStream4 = System.err;
            printStream4.println("Decryption key file not found, or not valid [" + str3 + "]");
            System.exit(1);
        }
    }
}
