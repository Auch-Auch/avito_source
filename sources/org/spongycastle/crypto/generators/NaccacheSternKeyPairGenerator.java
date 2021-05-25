package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static int[] b = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    public static final BigInteger c = BigInteger.valueOf(1);
    public NaccacheSternKeyGenerationParameters a;

    public static BigInteger a(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger a3;
        BigInteger add;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger a4;
        BigInteger bigInteger3;
        BigInteger add2;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        boolean z;
        int i;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        long j;
        BigInteger bigInteger9;
        int i2;
        int nextInt;
        int i3;
        int strength = this.a.getStrength();
        SecureRandom random = this.a.getRandom();
        int certainty = this.a.getCertainty();
        boolean isDebug = this.a.isDebug();
        if (isDebug) {
            PrintStream printStream = System.out;
            StringBuilder L = a.L("Fetching first ");
            L.append(this.a.getCntSmallPrimes());
            L.append(" primes.");
            printStream.println(L.toString());
        }
        int cntSmallPrimes = this.a.getCntSmallPrimes();
        Vector vector = new Vector(cntSmallPrimes);
        for (int i4 = 0; i4 != cntSmallPrimes; i4++) {
            vector.addElement(BigInteger.valueOf((long) b[i4]));
        }
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i5 = 0; i5 < vector.size(); i5++) {
            vector3.addElement(vector.elementAt(i5));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != 0) {
            Object elementAt = vector3.elementAt(0);
            int size = vector2.size() + 1;
            if (((-size) & size) == size) {
                i2 = (int) ((((long) size) * ((long) (Integer.MAX_VALUE & random.nextInt()))) >> 31);
            } else {
                do {
                    nextInt = random.nextInt() & Integer.MAX_VALUE;
                    i3 = nextInt % size;
                } while ((size - 1) + (nextInt - i3) < 0);
                i2 = i3;
            }
            vector2.insertElementAt(elementAt, i2);
            vector3.removeElementAt(0);
        }
        BigInteger bigInteger10 = c;
        BigInteger bigInteger11 = bigInteger10;
        for (int i6 = 0; i6 < vector2.size() / 2; i6++) {
            bigInteger11 = bigInteger11.multiply((BigInteger) vector2.elementAt(i6));
        }
        for (int size2 = vector2.size() / 2; size2 < vector2.size(); size2++) {
            bigInteger10 = bigInteger10.multiply((BigInteger) vector2.elementAt(size2));
        }
        BigInteger multiply = bigInteger11.multiply(bigInteger10);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger a5 = a(bitLength, certainty, random);
        BigInteger a6 = a(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = a5.multiply(bigInteger11).shiftLeft(1);
        BigInteger shiftLeft2 = a6.multiply(bigInteger10).shiftLeft(1);
        long j2 = 0;
        while (true) {
            j2++;
            a3 = a(24, certainty, random);
            add = a3.multiply(shiftLeft).add(c);
            if (!add.isProbablePrime(certainty)) {
                bigInteger2 = shiftLeft2;
                bigInteger = shiftLeft;
            } else {
                while (true) {
                    do {
                        a4 = a(24, certainty, random);
                    } while (a3.equals(a4));
                    BigInteger multiply2 = a4.multiply(shiftLeft2);
                    bigInteger2 = shiftLeft2;
                    bigInteger3 = c;
                    add2 = multiply2.add(bigInteger3);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    shiftLeft2 = bigInteger2;
                    certainty = certainty;
                }
                bigInteger = shiftLeft;
                if (!multiply.gcd(a3.multiply(a4)).equals(bigInteger3)) {
                    continue;
                } else if (add.multiply(add2).bitLength() >= strength) {
                    break;
                } else if (isDebug) {
                    PrintStream printStream2 = System.out;
                    StringBuilder M = a.M("key size too small. Should be ", strength, " but is actually ");
                    M.append(add.multiply(add2).bitLength());
                    printStream2.println(M.toString());
                }
            }
            shiftLeft2 = bigInteger2;
            shiftLeft = bigInteger;
        }
        if (isDebug) {
            bigInteger5 = a6;
            PrintStream printStream3 = System.out;
            bigInteger4 = a5;
            printStream3.println("needed " + j2 + " tries to generate p and q.");
        } else {
            bigInteger5 = a6;
            bigInteger4 = a5;
        }
        BigInteger multiply3 = add.multiply(add2);
        BigInteger multiply4 = add.subtract(bigInteger3).multiply(add2.subtract(bigInteger3));
        if (isDebug) {
            System.out.println("generating g");
        }
        long j3 = 0;
        while (true) {
            Vector vector4 = new Vector();
            int i7 = 0;
            while (i7 != vector2.size()) {
                BigInteger divide = multiply4.divide((BigInteger) vector2.elementAt(i7));
                while (true) {
                    j = j3 + 1;
                    bigInteger9 = new BigInteger(strength, certainty, random);
                    if (!bigInteger9.modPow(divide, multiply3).equals(c)) {
                        break;
                    }
                    j3 = j;
                    strength = strength;
                }
                vector4.addElement(bigInteger9);
                i7++;
                j3 = j;
                strength = strength;
            }
            bigInteger6 = c;
            int i8 = 0;
            while (i8 < vector2.size()) {
                bigInteger6 = bigInteger6.multiply(((BigInteger) vector4.elementAt(i8)).modPow(multiply.divide((BigInteger) vector2.elementAt(i8)), multiply3)).mod(multiply3);
                i8++;
                random = random;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= vector2.size()) {
                    z = false;
                    break;
                } else if (bigInteger6.modPow(multiply4.divide((BigInteger) vector2.elementAt(i9)), multiply3).equals(c)) {
                    if (isDebug) {
                        PrintStream printStream4 = System.out;
                        StringBuilder L2 = a.L("g has order phi(n)/");
                        L2.append(vector2.elementAt(i9));
                        L2.append("\n g: ");
                        L2.append(bigInteger6);
                        printStream4.println(L2.toString());
                    }
                    z = true;
                } else {
                    i9++;
                }
            }
            if (!z) {
                BigInteger modPow = bigInteger6.modPow(multiply4.divide(BigInteger.valueOf(4)), multiply3);
                BigInteger bigInteger12 = c;
                if (modPow.equals(bigInteger12)) {
                    if (isDebug) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("g has order phi(n)/4\n g:" + bigInteger6);
                    }
                } else if (bigInteger6.modPow(multiply4.divide(a3), multiply3).equals(bigInteger12)) {
                    if (isDebug) {
                        PrintStream printStream6 = System.out;
                        printStream6.println("g has order phi(n)/p'\n g: " + bigInteger6);
                    }
                } else if (!bigInteger6.modPow(multiply4.divide(a4), multiply3).equals(bigInteger12)) {
                    bigInteger8 = bigInteger4;
                    if (!bigInteger6.modPow(multiply4.divide(bigInteger8), multiply3).equals(bigInteger12)) {
                        bigInteger7 = bigInteger5;
                        if (!bigInteger6.modPow(multiply4.divide(bigInteger7), multiply3).equals(bigInteger12)) {
                            break;
                        } else if (isDebug) {
                            PrintStream printStream7 = System.out;
                            StringBuilder sb = new StringBuilder();
                            i = certainty;
                            sb.append("g has order phi(n)/b\n g: ");
                            sb.append(bigInteger6);
                            printStream7.println(sb.toString());
                            bigInteger4 = bigInteger8;
                            certainty = i;
                            add2 = add2;
                            strength = strength;
                            random = random;
                            bigInteger5 = bigInteger7;
                            add = add;
                        }
                    } else {
                        if (isDebug) {
                            PrintStream printStream8 = System.out;
                            printStream8.println("g has order phi(n)/a\n g: " + bigInteger6);
                        }
                        bigInteger7 = bigInteger5;
                    }
                    i = certainty;
                    bigInteger4 = bigInteger8;
                    certainty = i;
                    add2 = add2;
                    strength = strength;
                    random = random;
                    bigInteger5 = bigInteger7;
                    add = add;
                } else if (isDebug) {
                    PrintStream printStream9 = System.out;
                    printStream9.println("g has order phi(n)/q'\n g: " + bigInteger6);
                }
            }
            bigInteger7 = bigInteger5;
            bigInteger8 = bigInteger4;
            i = certainty;
            bigInteger4 = bigInteger8;
            certainty = i;
            add2 = add2;
            strength = strength;
            random = random;
            bigInteger5 = bigInteger7;
            add = add;
        }
        if (isDebug) {
            PrintStream printStream10 = System.out;
            printStream10.println("needed " + j3 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            PrintStream printStream11 = System.out;
            printStream11.println("smallPrimes: " + vector2);
            PrintStream printStream12 = System.out;
            printStream12.println("sigma:...... " + multiply + " (" + multiply.bitLength() + " bits)");
            PrintStream printStream13 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("a:.......... ");
            sb2.append(bigInteger8);
            printStream13.println(sb2.toString());
            PrintStream printStream14 = System.out;
            printStream14.println("b:.......... " + bigInteger7);
            PrintStream printStream15 = System.out;
            printStream15.println("p':......... " + a3);
            PrintStream printStream16 = System.out;
            printStream16.println("q':......... " + a4);
            PrintStream printStream17 = System.out;
            printStream17.println("p:.......... " + add);
            PrintStream printStream18 = System.out;
            printStream18.println("q:.......... " + add2);
            PrintStream printStream19 = System.out;
            printStream19.println("n:.......... " + multiply3);
            PrintStream printStream20 = System.out;
            printStream20.println("phi(n):..... " + multiply4);
            PrintStream printStream21 = System.out;
            printStream21.println("g:.......... " + bigInteger6);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigInteger6, multiply3, multiply.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigInteger6, multiply3, multiply.bitLength(), vector2, multiply4));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
