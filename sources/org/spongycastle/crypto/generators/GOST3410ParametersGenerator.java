package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410ValidationParameters;
public class GOST3410ParametersGenerator {
    public static final BigInteger d = BigInteger.valueOf(1);
    public static final BigInteger e = BigInteger.valueOf(2);
    public int a;
    public int b;
    public SecureRandom c;

    public final int a(int i, int i2, BigInteger[] bigIntegerArr, int i3) {
        BigInteger[] bigIntegerArr2;
        int i4 = i;
        while (true) {
            if (i4 >= 0 && i4 <= 65536) {
                break;
            }
            i4 = this.c.nextInt() / 32768;
        }
        int i5 = i2;
        while (true) {
            if (i5 >= 0 && i5 <= 65536 && i5 / 2 != 0) {
                break;
            }
            i5 = (this.c.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger = new BigInteger(Integer.toString(i5));
        BigInteger bigInteger2 = new BigInteger("19381");
        BigInteger bigInteger3 = new BigInteger(Integer.toString(i4));
        int i6 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger3};
        int[] iArr = {i3};
        int i7 = 0;
        int i8 = 0;
        while (iArr[i7] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i8 = i7 + 1;
            iArr[i8] = iArr[i7] / 2;
            i7 = i8;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i8 + 1)];
        int i9 = 16;
        bigIntegerArr4[i8] = new BigInteger("8003", 16);
        int i10 = i8 - 1;
        int i11 = 0;
        while (i11 < i8) {
            int i12 = iArr[i10] / i9;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i6, bigIntegerArr5, i6, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i12 + 1)];
                System.arraycopy(bigIntegerArr5, i6, bigIntegerArr2, i6, length2);
                int i13 = 0;
                while (i13 < i12) {
                    int i14 = i13 + 1;
                    bigIntegerArr2[i14] = bigIntegerArr2[i13].multiply(bigInteger2).add(bigInteger).mod(e.pow(i9));
                    i13 = i14;
                }
                BigInteger bigInteger4 = new BigInteger("0");
                for (int i15 = 0; i15 < i12; i15++) {
                    bigInteger4 = bigInteger4.add(bigIntegerArr2[i15].multiply(e.pow(i15 * 16)));
                }
                bigIntegerArr2[i6] = bigIntegerArr2[i12];
                BigInteger bigInteger5 = e;
                int i16 = i10 + 1;
                BigInteger add = bigInteger5.pow(iArr[i10] - 1).divide(bigIntegerArr4[i16]).add(bigInteger5.pow(iArr[i10] - 1).multiply(bigInteger4).divide(bigIntegerArr4[i16].multiply(bigInteger5.pow(i12 * 16))));
                BigInteger mod = add.mod(bigInteger5);
                BigInteger bigInteger6 = d;
                if (mod.compareTo(bigInteger6) == 0) {
                    add = add.add(bigInteger6);
                }
                int i17 = 0;
                while (true) {
                    long j = (long) i17;
                    BigInteger multiply = bigIntegerArr4[i16].multiply(add.add(BigInteger.valueOf(j)));
                    BigInteger bigInteger7 = d;
                    bigIntegerArr4[i10] = multiply.add(bigInteger7);
                    BigInteger bigInteger8 = bigIntegerArr4[i10];
                    BigInteger bigInteger9 = e;
                    if (bigInteger8.compareTo(bigInteger9.pow(iArr[i10])) == 1) {
                        break;
                    }
                    if (bigInteger9.modPow(bigIntegerArr4[i16].multiply(add.add(BigInteger.valueOf(j))), bigIntegerArr4[i10]).compareTo(bigInteger7) == 0 && bigInteger9.modPow(add.add(BigInteger.valueOf(j)), bigIntegerArr4[i10]).compareTo(bigInteger7) != 0) {
                        break;
                    }
                    i17 += 2;
                    i8 = i8;
                    bigInteger2 = bigInteger2;
                    bigInteger = bigInteger;
                    i12 = i12;
                }
                i8 = i8;
                bigInteger2 = bigInteger2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger = bigInteger;
                i12 = i12;
                i6 = 0;
                i9 = 16;
            }
            i10--;
            if (i10 >= 0) {
                i11++;
                i8 = i8;
                bigInteger2 = bigInteger2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger = bigInteger;
                i6 = 0;
                i9 = 16;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].intValue();
            }
        }
        return bigIntegerArr3[0].intValue();
    }

    public final long b(long j, long j2, BigInteger[] bigIntegerArr, int i) {
        BigInteger[] bigIntegerArr2;
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.c.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.c.nextInt() * 2) + 1);
        }
        BigInteger bigInteger = new BigInteger(Long.toString(j4));
        BigInteger bigInteger2 = new BigInteger("97781173");
        BigInteger bigInteger3 = new BigInteger(Long.toString(j3));
        int i2 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger3};
        int[] iArr = {i};
        int i3 = 0;
        int i4 = 0;
        while (iArr[i3] >= 33) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i4 = i3 + 1;
            iArr[i4] = iArr[i3] / 2;
            i3 = i4;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i4 + 1)];
        bigIntegerArr4[i4] = new BigInteger("8000000B", 16);
        int i5 = i4 - 1;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = 32;
            int i8 = iArr[i5] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i2, bigIntegerArr5, i2, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i8 + 1)];
                System.arraycopy(bigIntegerArr5, i2, bigIntegerArr2, i2, length2);
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    bigIntegerArr2[i10] = bigIntegerArr2[i9].multiply(bigInteger2).add(bigInteger).mod(e.pow(i7));
                    i9 = i10;
                }
                BigInteger bigInteger4 = new BigInteger("0");
                for (int i11 = 0; i11 < i8; i11++) {
                    bigInteger4 = bigInteger4.add(bigIntegerArr2[i11].multiply(e.pow(i11 * 32)));
                }
                bigIntegerArr2[i2] = bigIntegerArr2[i8];
                BigInteger bigInteger5 = e;
                int i12 = i5 + 1;
                BigInteger add = bigInteger5.pow(iArr[i5] - 1).divide(bigIntegerArr4[i12]).add(bigInteger5.pow(iArr[i5] - 1).multiply(bigInteger4).divide(bigIntegerArr4[i12].multiply(bigInteger5.pow(i8 * 32))));
                BigInteger mod = add.mod(bigInteger5);
                BigInteger bigInteger6 = d;
                if (mod.compareTo(bigInteger6) == 0) {
                    add = add.add(bigInteger6);
                }
                int i13 = 0;
                while (true) {
                    long j5 = (long) i13;
                    BigInteger multiply = bigIntegerArr4[i12].multiply(add.add(BigInteger.valueOf(j5)));
                    BigInteger bigInteger7 = d;
                    bigIntegerArr4[i5] = multiply.add(bigInteger7);
                    BigInteger bigInteger8 = bigIntegerArr4[i5];
                    BigInteger bigInteger9 = e;
                    if (bigInteger8.compareTo(bigInteger9.pow(iArr[i5])) == 1) {
                        break;
                    }
                    if (bigInteger9.modPow(bigIntegerArr4[i12].multiply(add.add(BigInteger.valueOf(j5))), bigIntegerArr4[i5]).compareTo(bigInteger7) == 0 && bigInteger9.modPow(add.add(BigInteger.valueOf(j5)), bigIntegerArr4[i5]).compareTo(bigInteger7) != 0) {
                        break;
                    }
                    i13 += 2;
                    bigInteger = bigInteger;
                    i4 = i4;
                    bigInteger2 = bigInteger2;
                }
                bigInteger = bigInteger;
                i4 = i4;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger2 = bigInteger2;
                i2 = 0;
                i7 = 32;
            }
            i5--;
            if (i5 >= 0) {
                i6++;
                bigInteger = bigInteger;
                i4 = i4;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger2 = bigInteger2;
                i2 = 0;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].longValue();
            }
        }
        return bigIntegerArr3[0].longValue();
    }

    public final BigInteger c(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger subtract = bigInteger.subtract(d);
        BigInteger divide = subtract.divide(bigInteger2);
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigInteger3 = new BigInteger(bitLength, this.c);
            BigInteger bigInteger4 = d;
            if (bigInteger3.compareTo(bigInteger4) > 0 && bigInteger3.compareTo(subtract) < 0) {
                BigInteger modPow = bigInteger3.modPow(divide, bigInteger);
                if (modPow.compareTo(bigInteger4) != 0) {
                    return modPow;
                }
            }
        }
    }

    public GOST3410Parameters generateParameters() {
        long j;
        BigInteger add;
        BigInteger add2;
        BigInteger[] bigIntegerArr = new BigInteger[2];
        String str = "0";
        char c2 = 0;
        if (this.b == 1) {
            int nextInt = this.c.nextInt();
            int nextInt2 = this.c.nextInt();
            int i = this.a;
            if (i == 512) {
                a(nextInt, nextInt2, bigIntegerArr, 512);
            } else if (i == 1024) {
                int i2 = nextInt;
                while (true) {
                    if (i2 >= 0 && i2 <= 65536) {
                        break;
                    }
                    i2 = this.c.nextInt() / 32768;
                    c2 = 0;
                }
                int i3 = nextInt2;
                while (true) {
                    if (i3 >= 0 && i3 <= 65536 && i3 / 2 != 0) {
                        break;
                    }
                    i3 = (this.c.nextInt() / 32768) + 1;
                    c2 = 0;
                }
                BigInteger[] bigIntegerArr2 = new BigInteger[2];
                BigInteger bigInteger = new BigInteger(Integer.toString(i3));
                BigInteger bigInteger2 = new BigInteger("19381");
                int a3 = a(i2, i3, bigIntegerArr2, 256);
                BigInteger bigInteger3 = bigIntegerArr2[c2];
                int a4 = a(a3, i3, bigIntegerArr2, 512);
                BigInteger bigInteger4 = bigIntegerArr2[c2];
                BigInteger[] bigIntegerArr3 = new BigInteger[65];
                bigIntegerArr3[c2] = new BigInteger(Integer.toString(a4));
                loop2:
                while (true) {
                    int i4 = 0;
                    while (i4 < 64) {
                        int i5 = i4 + 1;
                        bigIntegerArr3[i5] = bigIntegerArr3[i4].multiply(bigInteger2).add(bigInteger).mod(e.pow(16));
                        i4 = i5;
                    }
                    BigInteger bigInteger5 = new BigInteger(str);
                    for (int i6 = 0; i6 < 64; i6++) {
                        bigInteger5 = bigInteger5.add(bigIntegerArr3[i6].multiply(e.pow(i6 * 16)));
                    }
                    bigIntegerArr3[0] = bigIntegerArr3[64];
                    BigInteger bigInteger6 = e;
                    BigInteger add3 = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
                    BigInteger mod = add3.mod(bigInteger6);
                    BigInteger bigInteger7 = d;
                    if (mod.compareTo(bigInteger7) == 0) {
                        add3 = add3.add(bigInteger7);
                    }
                    int i7 = 0;
                    while (true) {
                        long j2 = (long) i7;
                        BigInteger multiply = bigInteger3.multiply(bigInteger4).multiply(add3.add(BigInteger.valueOf(j2)));
                        BigInteger bigInteger8 = d;
                        add2 = multiply.add(bigInteger8);
                        BigInteger bigInteger9 = e;
                        if (add2.compareTo(bigInteger9.pow(1024)) == 1) {
                            break;
                        }
                        if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(add3.add(BigInteger.valueOf(j2))), add2).compareTo(bigInteger8) == 0 && bigInteger9.modPow(bigInteger3.multiply(add3.add(BigInteger.valueOf(j2))), add2).compareTo(bigInteger8) != 0) {
                            break loop2;
                        }
                        i7 += 2;
                        bigIntegerArr3 = bigIntegerArr3;
                        bigInteger2 = bigInteger2;
                        bigInteger = bigInteger;
                    }
                    bigIntegerArr3 = bigIntegerArr3;
                    bigInteger2 = bigInteger2;
                    bigInteger = bigInteger;
                }
                bigIntegerArr[0] = add2;
                bigIntegerArr[1] = bigInteger3;
            } else {
                throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger10 = bigIntegerArr[0];
            BigInteger bigInteger11 = bigIntegerArr[1];
            return new GOST3410Parameters(bigInteger10, bigInteger11, c(bigInteger10, bigInteger11), new GOST3410ValidationParameters(nextInt, nextInt2));
        }
        long nextLong = this.c.nextLong();
        long nextLong2 = this.c.nextLong();
        int i8 = this.a;
        if (i8 == 512) {
            j = nextLong2;
            b(nextLong, j, bigIntegerArr, 512);
        } else if (i8 == 1024) {
            long j3 = nextLong;
            while (true) {
                if (j3 >= 0 && j3 <= 4294967296L) {
                    break;
                }
                j3 = (long) (this.c.nextInt() * 2);
                str = str;
                nextLong2 = nextLong2;
            }
            long j4 = nextLong2;
            while (true) {
                if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                    break;
                }
                nextLong2 = nextLong2;
                str = str;
                j4 = (long) ((this.c.nextInt() * 2) + 1);
            }
            BigInteger[] bigIntegerArr4 = new BigInteger[2];
            BigInteger bigInteger12 = new BigInteger(Long.toString(j4));
            j = nextLong2;
            BigInteger bigInteger13 = new BigInteger("97781173");
            long b2 = b(j3, j4, bigIntegerArr4, 256);
            BigInteger bigInteger14 = bigIntegerArr4[0];
            long b3 = b(b2, j4, bigIntegerArr4, 512);
            BigInteger bigInteger15 = bigIntegerArr4[0];
            BigInteger[] bigIntegerArr5 = new BigInteger[33];
            bigIntegerArr5[0] = new BigInteger(Long.toString(b3));
            loop8:
            while (true) {
                int i9 = 0;
                while (i9 < 32) {
                    int i10 = i9 + 1;
                    bigIntegerArr5[i10] = bigIntegerArr5[i9].multiply(bigInteger13).add(bigInteger12).mod(e.pow(32));
                    i9 = i10;
                }
                BigInteger bigInteger16 = new BigInteger(str);
                for (int i11 = 0; i11 < 32; i11++) {
                    bigInteger16 = bigInteger16.add(bigIntegerArr5[i11].multiply(e.pow(i11 * 32)));
                }
                bigIntegerArr5[0] = bigIntegerArr5[32];
                BigInteger bigInteger17 = e;
                BigInteger add4 = bigInteger17.pow(1023).divide(bigInteger14.multiply(bigInteger15)).add(bigInteger17.pow(1023).multiply(bigInteger16).divide(bigInteger14.multiply(bigInteger15).multiply(bigInteger17.pow(1024))));
                BigInteger mod2 = add4.mod(bigInteger17);
                BigInteger bigInteger18 = d;
                if (mod2.compareTo(bigInteger18) == 0) {
                    add4 = add4.add(bigInteger18);
                }
                int i12 = 0;
                while (true) {
                    long j5 = (long) i12;
                    BigInteger multiply2 = bigInteger14.multiply(bigInteger15).multiply(add4.add(BigInteger.valueOf(j5)));
                    BigInteger bigInteger19 = d;
                    add = multiply2.add(bigInteger19);
                    BigInteger bigInteger20 = e;
                    if (add.compareTo(bigInteger20.pow(1024)) == 1) {
                        break;
                    }
                    if (bigInteger20.modPow(bigInteger14.multiply(bigInteger15).multiply(add4.add(BigInteger.valueOf(j5))), add).compareTo(bigInteger19) == 0 && bigInteger20.modPow(bigInteger14.multiply(add4.add(BigInteger.valueOf(j5))), add).compareTo(bigInteger19) != 0) {
                        break loop8;
                    }
                    i12 += 2;
                    bigInteger13 = bigInteger13;
                    bigIntegerArr5 = bigIntegerArr5;
                    str = str;
                }
                bigInteger14 = bigInteger14;
                bigInteger13 = bigInteger13;
                bigIntegerArr5 = bigIntegerArr5;
                str = str;
            }
            bigIntegerArr[0] = add;
            bigIntegerArr[1] = bigInteger14;
        } else {
            throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
        }
        BigInteger bigInteger21 = bigIntegerArr[0];
        BigInteger bigInteger22 = bigIntegerArr[1];
        return new GOST3410Parameters(bigInteger21, bigInteger22, c(bigInteger21, bigInteger22), new GOST3410ValidationParameters(nextLong, j));
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        this.c = secureRandom;
    }
}
