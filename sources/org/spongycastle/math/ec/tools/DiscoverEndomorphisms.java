package org.spongycastle.math.ec.tools;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.BigIntegers;
public class DiscoverEndomorphisms {
    public static BigInteger[] a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        BigInteger divide = bigInteger.subtract(bigInteger2).divide(bigInteger3);
        BigInteger divide2 = bigInteger.add(bigInteger2).divide(bigInteger3);
        return divide.compareTo(divide2) <= 0 ? new BigInteger[]{divide, divide2} : new BigInteger[]{divide2, divide};
    }

    public static boolean b(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int bitLength = abs2.bitLength();
        int bitLength2 = abs.bitLength() * 2;
        return bitLength2 + -1 <= bitLength && (bitLength2 < bitLength || abs.multiply(abs).compareTo(abs2) < 0);
    }

    public static boolean c(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        BigInteger abs = bigIntegerArr[0].abs();
        BigInteger abs2 = bigIntegerArr[1].abs();
        BigInteger abs3 = bigIntegerArr2[0].abs();
        BigInteger abs4 = bigIntegerArr2[1].abs();
        boolean z = abs.compareTo(abs3) < 0;
        if (z == (abs2.compareTo(abs4) < 0)) {
            return z;
        }
        if (abs.multiply(abs).add(abs2.multiply(abs2)).compareTo(abs3.multiply(abs3).add(abs4.multiply(abs4))) < 0) {
            return true;
        }
        return false;
    }

    public static void d(X9ECParameters x9ECParameters) {
        BigInteger modPow;
        BigInteger n = x9ECParameters.getN();
        BigInteger bigInteger = ECConstants.ONE;
        BigInteger bigInteger2 = new ECFieldElement.Fp(n, bigInteger.multiply(bigInteger).subtract(bigInteger.shiftLeft(2)).mod(n)).sqrt().toBigInteger();
        BigInteger subtract = n.subtract(bigInteger2);
        if (bigInteger2.testBit(0)) {
            subtract = subtract.add(n);
        } else {
            bigInteger2 = bigInteger2.add(n);
        }
        BigInteger[] bigIntegerArr = {bigInteger2.shiftRight(1), subtract.shiftRight(1)};
        ECCurve curve = x9ECParameters.getCurve();
        BigInteger characteristic = curve.getField().getCharacteristic();
        BigInteger divide = characteristic.divide(ECConstants.THREE);
        SecureRandom secureRandom = new SecureRandom();
        do {
            BigInteger bigInteger3 = ECConstants.TWO;
            modPow = BigIntegers.createRandomInRange(bigInteger3, characteristic.subtract(bigInteger3), secureRandom).modPow(divide, characteristic);
        } while (modPow.equals(ECConstants.ONE));
        ECFieldElement fromBigInteger = curve.fromBigInteger(modPow);
        ECFieldElement[] eCFieldElementArr = {fromBigInteger, fromBigInteger.square()};
        e(x9ECParameters, bigIntegerArr[0], eCFieldElementArr);
        System.out.println("OR");
        e(x9ECParameters, bigIntegerArr[1], eCFieldElementArr);
    }

    public static void discoverEndomorphisms(X9ECParameters x9ECParameters) {
        Objects.requireNonNull(x9ECParameters, "x9");
        ECCurve curve = x9ECParameters.getCurve();
        if (ECAlgorithms.isFpCurve(curve)) {
            BigInteger characteristic = curve.getField().getCharacteristic();
            if (curve.getA().isZero() && characteristic.mod(ECConstants.THREE).equals(ECConstants.ONE)) {
                System.out.println("Curve has a 'GLV Type B' endomorphism with these parameters:");
                d(x9ECParameters);
            }
        }
    }

    public static void e(X9ECParameters x9ECParameters, BigInteger bigInteger, ECFieldElement[] eCFieldElementArr) {
        BigInteger bigInteger2;
        BigInteger subtract;
        BigInteger bigInteger3;
        BigInteger[] bigIntegerArr;
        char c;
        char c2;
        char c3;
        BigInteger shiftRight;
        BigInteger[] bigIntegerArr2;
        int i;
        ECPoint normalize = x9ECParameters.getG().normalize();
        ECPoint normalize2 = normalize.multiply(bigInteger).normalize();
        if (normalize.getYCoord().equals(normalize2.getYCoord())) {
            char c4 = 0;
            ECFieldElement eCFieldElement = eCFieldElementArr[0];
            if (!normalize.getXCoord().multiply(eCFieldElement).equals(normalize2.getXCoord())) {
                eCFieldElement = eCFieldElementArr[1];
                if (!normalize.getXCoord().multiply(eCFieldElement).equals(normalize2.getXCoord())) {
                    throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
                }
            }
            BigInteger n = x9ECParameters.getN();
            BigInteger bigInteger4 = bigInteger;
            BigInteger bigInteger5 = n;
            BigInteger bigInteger6 = ECConstants.ZERO;
            BigInteger bigInteger7 = ECConstants.ONE;
            while (true) {
                BigInteger[] divideAndRemainder = bigInteger5.divideAndRemainder(bigInteger4);
                BigInteger bigInteger8 = divideAndRemainder[0];
                bigInteger2 = divideAndRemainder[1];
                subtract = bigInteger6.subtract(bigInteger8.multiply(bigInteger7));
                if (b(bigInteger4, n)) {
                    break;
                }
                bigInteger6 = bigInteger7;
                bigInteger5 = bigInteger4;
                bigInteger4 = bigInteger2;
                bigInteger7 = subtract;
            }
            BigInteger[] bigIntegerArr3 = {bigInteger5, bigInteger6, bigInteger4, bigInteger7, bigInteger2, subtract};
            BigInteger[] bigIntegerArr4 = {bigIntegerArr3[2], bigIntegerArr3[3].negate()};
            BigInteger[] bigIntegerArr5 = {bigIntegerArr3[0], bigIntegerArr3[1].negate()};
            BigInteger[] bigIntegerArr6 = {bigIntegerArr3[4], bigIntegerArr3[5].negate()};
            if (!c(bigIntegerArr5, bigIntegerArr6)) {
                bigIntegerArr5 = bigIntegerArr6;
            }
            if (!b(bigIntegerArr5[0].abs().max(bigIntegerArr5[1].abs()), n)) {
                BigInteger gcd = bigIntegerArr4[0].gcd(bigIntegerArr4[1]);
                BigInteger bigInteger9 = ECConstants.ONE;
                if (gcd.equals(bigInteger9)) {
                    BigInteger bigInteger10 = bigIntegerArr4[0];
                    BigInteger bigInteger11 = bigIntegerArr4[1];
                    BigInteger divide = bigInteger10.add(bigInteger11.multiply(bigInteger)).divide(n);
                    BigInteger[] bigIntegerArr7 = {divide.abs(), bigInteger11.abs()};
                    boolean z = bigIntegerArr7[0].compareTo(bigIntegerArr7[1]) < 0;
                    if (z) {
                        BigInteger bigInteger12 = bigIntegerArr7[0];
                        bigIntegerArr7[0] = bigIntegerArr7[1];
                        bigIntegerArr7[1] = bigInteger12;
                    }
                    BigInteger bigInteger13 = bigIntegerArr7[0];
                    BigInteger bigInteger14 = bigIntegerArr7[1];
                    BigInteger bigInteger15 = bigInteger13;
                    BigInteger bigInteger16 = ECConstants.ZERO;
                    BigInteger bigInteger17 = bigInteger9;
                    BigInteger bigInteger18 = bigInteger14;
                    BigInteger bigInteger19 = bigInteger17;
                    BigInteger bigInteger20 = bigInteger16;
                    while (true) {
                        bigInteger3 = ECConstants.ONE;
                        if (bigInteger18.compareTo(bigInteger3) <= 0) {
                            break;
                        }
                        BigInteger[] divideAndRemainder2 = bigInteger15.divideAndRemainder(bigInteger18);
                        BigInteger bigInteger21 = divideAndRemainder2[c4];
                        BigInteger bigInteger22 = divideAndRemainder2[1];
                        BigInteger subtract2 = bigInteger19.subtract(bigInteger21.multiply(bigInteger20));
                        BigInteger subtract3 = bigInteger16.subtract(bigInteger21.multiply(bigInteger17));
                        bigInteger19 = bigInteger20;
                        bigInteger16 = bigInteger17;
                        bigInteger20 = subtract2;
                        bigInteger17 = subtract3;
                        c4 = 0;
                        bigInteger18 = bigInteger22;
                        bigInteger15 = bigInteger18;
                    }
                    if (bigInteger18.signum() <= 0) {
                        bigIntegerArr = null;
                        c2 = 0;
                        c = 1;
                    } else {
                        c2 = 0;
                        c = 1;
                        bigIntegerArr = new BigInteger[]{bigInteger20, bigInteger17};
                        if (z) {
                            BigInteger bigInteger23 = bigIntegerArr[0];
                            bigIntegerArr[0] = bigIntegerArr[1];
                            bigIntegerArr[1] = bigInteger23;
                        }
                    }
                    if (bigIntegerArr != null) {
                        BigInteger bigInteger24 = bigIntegerArr[c2];
                        BigInteger bigInteger25 = bigIntegerArr[c];
                        if (divide.signum() < 0) {
                            bigInteger24 = bigInteger24.negate();
                        }
                        if (bigInteger11.signum() > 0) {
                            bigInteger25 = bigInteger25.negate();
                        }
                        if (divide.multiply(bigInteger24).subtract(bigInteger11.multiply(bigInteger25)).equals(bigInteger3)) {
                            BigInteger subtract4 = bigInteger25.multiply(n).subtract(bigInteger24.multiply(bigInteger));
                            BigInteger negate = bigInteger24.negate();
                            BigInteger negate2 = subtract4.negate();
                            BigInteger subtract5 = n.subtract(bigInteger3);
                            BigInteger shiftRight2 = subtract5.shiftRight(subtract5.bitLength() / 2);
                            while (true) {
                                shiftRight = shiftRight2.add(subtract5.divide(shiftRight2)).shiftRight(1);
                                if (shiftRight.equals(shiftRight2)) {
                                    break;
                                }
                                shiftRight2 = shiftRight;
                            }
                            BigInteger add = shiftRight.add(ECConstants.ONE);
                            BigInteger[] a = a(negate, add, bigInteger11);
                            BigInteger[] a3 = a(negate2, add, bigInteger10);
                            char c5 = 0;
                            BigInteger max = a[0].max(a3[0]);
                            BigInteger min = a[1].min(a3[1]);
                            if (max.compareTo(min) > 0) {
                                bigIntegerArr2 = null;
                                i = 2;
                            } else {
                                i = 2;
                                bigIntegerArr2 = new BigInteger[]{max, min};
                            }
                            if (bigIntegerArr2 != null) {
                                BigInteger bigInteger26 = bigIntegerArr2[0];
                                for (c3 = 1; bigInteger26.compareTo(bigIntegerArr2[c3]) <= 0; c3 = 1) {
                                    BigInteger[] bigIntegerArr8 = new BigInteger[i];
                                    bigIntegerArr8[c5] = subtract4.add(bigInteger26.multiply(bigInteger10));
                                    bigIntegerArr8[c3] = bigInteger24.add(bigInteger26.multiply(bigInteger11));
                                    if (c(bigIntegerArr8, bigIntegerArr5)) {
                                        bigIntegerArr5 = bigIntegerArr8;
                                    }
                                    bigInteger26 = bigInteger26.add(ECConstants.ONE);
                                    c5 = 0;
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                }
            }
            BigInteger subtract6 = bigIntegerArr4[0].multiply(bigIntegerArr5[1]).subtract(bigIntegerArr4[1].multiply(bigIntegerArr5[0]));
            int bitLength = (n.bitLength() + 16) - (n.bitLength() & 7);
            BigInteger g = g(bigIntegerArr5[1].shiftLeft(bitLength), subtract6);
            BigInteger negate3 = g(bigIntegerArr4[1].shiftLeft(bitLength), subtract6).negate();
            f("Beta", eCFieldElement.toBigInteger().toString(16));
            f("Lambda", bigInteger.toString(16));
            f("v1", "{ " + bigIntegerArr4[0].toString(16) + ", " + bigIntegerArr4[1].toString(16) + " }");
            f("v2", "{ " + bigIntegerArr5[0].toString(16) + ", " + bigIntegerArr5[1].toString(16) + " }");
            f("d", subtract6.toString(16));
            f("(OPT) g1", g.toString(16));
            f("(OPT) g2", negate3.toString(16));
            f("(OPT) bits", Integer.toString(bitLength));
            return;
        }
        throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
    }

    public static void f(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer("  ");
        stringBuffer.append(str);
        while (stringBuffer.length() < 20) {
            stringBuffer.append(' ');
        }
        stringBuffer.append("= ");
        stringBuffer.append(obj.toString());
        System.out.println(stringBuffer.toString());
    }

    public static BigInteger g(BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() != bigInteger2.signum();
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        BigInteger divide = abs.add(abs2.shiftRight(1)).divide(abs2);
        return z ? divide.negate() : divide;
    }

    public static void main(String[] strArr) {
        if (strArr.length < 1) {
            System.err.println("Expected a list of curve names as arguments");
            return;
        }
        for (String str : strArr) {
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName == null) {
                System.err.println("Unknown curve: " + str);
            } else {
                ECCurve curve = byName.getCurve();
                if (ECAlgorithms.isFpCurve(curve)) {
                    BigInteger characteristic = curve.getField().getCharacteristic();
                    if (curve.getA().isZero() && characteristic.mod(ECConstants.THREE).equals(ECConstants.ONE)) {
                        System.out.println("Curve '" + str + "' has a 'GLV Type B' endomorphism with these parameters:");
                        d(byName);
                    }
                }
            }
        }
    }
}
