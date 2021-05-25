package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
public class NaccacheSternEngine implements AsymmetricBlockCipher {
    public static BigInteger e = BigInteger.valueOf(0);
    public static BigInteger f = BigInteger.valueOf(1);
    public boolean a;
    public NaccacheSternKeyParameters b;
    public Vector[] c = null;
    public boolean d = false;

    public byte[] addCryptedBlocks(byte[] bArr, byte[] bArr2) throws InvalidCipherTextException {
        if (this.a) {
            if (bArr.length > getOutputBlockSize() || bArr2.length > getOutputBlockSize()) {
                throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
            }
        } else if (bArr.length > getInputBlockSize() || bArr2.length > getInputBlockSize()) {
            throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger mod = bigInteger.multiply(bigInteger2).mod(this.b.getModulus());
        if (this.d) {
            PrintStream printStream = System.out;
            printStream.println("c(m1) as BigInteger:....... " + bigInteger);
            PrintStream printStream2 = System.out;
            printStream2.println("c(m2) as BigInteger:....... " + bigInteger2);
            PrintStream printStream3 = System.out;
            printStream3.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + mod);
        }
        byte[] byteArray = this.b.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        System.arraycopy(mod.toByteArray(), 0, byteArray, byteArray.length - mod.toByteArray().length, mod.toByteArray().length);
        return byteArray;
    }

    public byte[] encrypt(BigInteger bigInteger) {
        byte[] byteArray = this.b.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        byte[] byteArray2 = this.b.getG().modPow(bigInteger, this.b.getModulus()).toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, byteArray.length - byteArray2.length, byteArray2.length);
        if (this.d) {
            PrintStream printStream = System.out;
            StringBuilder L = a.L("Encrypted value is:  ");
            L.append(new BigInteger(byteArray));
            printStream.println(L.toString());
        }
        return byteArray;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        if (this.a) {
            return ((this.b.getLowerSigmaBound() + 7) / 8) - 1;
        }
        return this.b.getModulus().toByteArray().length;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        if (this.a) {
            return this.b.getModulus().toByteArray().length;
        }
        return ((this.b.getLowerSigmaBound() + 7) / 8) - 1;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.a = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.b = (NaccacheSternKeyParameters) cipherParameters;
        if (!this.a) {
            if (this.d) {
                System.out.println("Constructing lookup Array");
            }
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.b;
            Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
            this.c = new Vector[smallPrimes.size()];
            for (int i = 0; i < smallPrimes.size(); i++) {
                BigInteger bigInteger = (BigInteger) smallPrimes.elementAt(i);
                int intValue = bigInteger.intValue();
                this.c[i] = new Vector();
                this.c[i].addElement(f);
                if (this.d) {
                    PrintStream printStream = System.out;
                    printStream.println("Constructing lookup ArrayList for " + intValue);
                }
                BigInteger bigInteger2 = e;
                for (int i2 = 1; i2 < intValue; i2++) {
                    bigInteger2 = bigInteger2.add(naccacheSternPrivateKeyParameters.getPhi_n());
                    this.c[i].addElement(naccacheSternPrivateKeyParameters.getG().modPow(bigInteger2.divide(bigInteger), naccacheSternPrivateKeyParameters.getModulus()));
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.b == null) {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        } else if (i2 > getInputBlockSize() + 1) {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        } else if (this.a || i2 >= getInputBlockSize()) {
            int i3 = 0;
            if (!(i == 0 && i2 == bArr.length)) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                bArr = bArr2;
            }
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (this.d) {
                PrintStream printStream = System.out;
                printStream.println("input as BigInteger: " + bigInteger);
            }
            if (this.a) {
                return encrypt(bigInteger);
            }
            Vector vector = new Vector();
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.b;
            Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
            for (int i4 = 0; i4 < smallPrimes.size(); i4++) {
                BigInteger modPow = bigInteger.modPow(naccacheSternPrivateKeyParameters.getPhi_n().divide((BigInteger) smallPrimes.elementAt(i4)), naccacheSternPrivateKeyParameters.getModulus());
                Vector[] vectorArr = this.c;
                Vector vector2 = vectorArr[i4];
                if (vectorArr[i4].size() != ((BigInteger) smallPrimes.elementAt(i4)).intValue()) {
                    if (this.d) {
                        PrintStream printStream2 = System.out;
                        StringBuilder L = a.L("Prime is ");
                        L.append(smallPrimes.elementAt(i4));
                        L.append(", lookup table has size ");
                        L.append(vector2.size());
                        printStream2.println(L.toString());
                    }
                    StringBuilder L2 = a.L("Error in lookup Array for ");
                    L2.append(((BigInteger) smallPrimes.elementAt(i4)).intValue());
                    L2.append(": Size mismatch. Expected ArrayList with length ");
                    L2.append(((BigInteger) smallPrimes.elementAt(i4)).intValue());
                    L2.append(" but found ArrayList of length ");
                    L2.append(this.c[i4].size());
                    throw new InvalidCipherTextException(L2.toString());
                }
                int indexOf = vector2.indexOf(modPow);
                if (indexOf == -1) {
                    if (this.d) {
                        PrintStream printStream3 = System.out;
                        StringBuilder L3 = a.L("Actual prime is ");
                        L3.append(smallPrimes.elementAt(i4));
                        printStream3.println(L3.toString());
                        PrintStream printStream4 = System.out;
                        printStream4.println("Decrypted value is " + modPow);
                        PrintStream printStream5 = System.out;
                        StringBuilder L4 = a.L("LookupList for ");
                        L4.append(smallPrimes.elementAt(i4));
                        L4.append(" with size ");
                        L4.append(this.c[i4].size());
                        L4.append(" is: ");
                        printStream5.println(L4.toString());
                        while (i3 < this.c[i4].size()) {
                            System.out.println(this.c[i4].elementAt(i3));
                            i3++;
                        }
                    }
                    throw new InvalidCipherTextException("Lookup failed");
                }
                vector.addElement(BigInteger.valueOf((long) indexOf));
            }
            BigInteger bigInteger2 = e;
            BigInteger bigInteger3 = f;
            for (int i5 = 0; i5 < smallPrimes.size(); i5++) {
                bigInteger3 = bigInteger3.multiply((BigInteger) smallPrimes.elementAt(i5));
            }
            while (i3 < smallPrimes.size()) {
                BigInteger bigInteger4 = (BigInteger) smallPrimes.elementAt(i3);
                BigInteger divide = bigInteger3.divide(bigInteger4);
                bigInteger2 = bigInteger2.add(divide.multiply(divide.modInverse(bigInteger4)).multiply((BigInteger) vector.elementAt(i3)));
                i3++;
            }
            return bigInteger2.mod(bigInteger3).toByteArray();
        } else {
            throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
    }

    public byte[] processData(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.d) {
            System.out.println();
        }
        if (bArr.length > getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize();
            int outputBlockSize = getOutputBlockSize();
            if (this.d) {
                PrintStream printStream = System.out;
                printStream.println("Input blocksize is:  " + inputBlockSize + " bytes");
                PrintStream printStream2 = System.out;
                printStream2.println("Output blocksize is: " + outputBlockSize + " bytes");
                PrintStream printStream3 = System.out;
                StringBuilder L = a.L("Data has length:.... ");
                L.append(bArr.length);
                L.append(" bytes");
                printStream3.println(L.toString());
            }
            byte[] bArr3 = new byte[(((bArr.length / inputBlockSize) + 1) * outputBlockSize)];
            int i = 0;
            int i2 = 0;
            while (i < bArr.length) {
                int i3 = i + inputBlockSize;
                if (i3 < bArr.length) {
                    bArr2 = processBlock(bArr, i, inputBlockSize);
                    i = i3;
                } else {
                    bArr2 = processBlock(bArr, i, bArr.length - i);
                    i = (bArr.length - i) + i;
                }
                if (this.d) {
                    PrintStream printStream4 = System.out;
                    printStream4.println("new datapos is " + i);
                }
                if (bArr2 != null) {
                    System.arraycopy(bArr2, 0, bArr3, i2, bArr2.length);
                    i2 += bArr2.length;
                } else {
                    if (this.d) {
                        System.out.println("cipher returned null");
                    }
                    throw new InvalidCipherTextException("cipher returned null");
                }
            }
            byte[] bArr4 = new byte[i2];
            System.arraycopy(bArr3, 0, bArr4, 0, i2);
            if (this.d) {
                PrintStream printStream5 = System.out;
                printStream5.println("returning " + i2 + " bytes");
            }
            return bArr4;
        }
        if (this.d) {
            System.out.println("data size is less then input block size, processing directly");
        }
        return processBlock(bArr, 0, bArr.length);
    }

    public void setDebug(boolean z) {
        this.d = z;
    }
}
