package org.spongycastle.crypto.digests;

import com.google.common.primitives.Longs;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
public class SkeinEngine implements Memoable {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    public static final Hashtable j = new Hashtable();
    public final ThreefishEngine a;
    public final int b;
    public long[] c;
    public long[] d;
    public byte[] e;
    public Parameter[] f;
    public Parameter[] g;
    public final b h;
    public final byte[] i;

    public static class Parameter {
        public int a;
        public byte[] b;

        public Parameter(int i, byte[] bArr) {
            this.a = i;
            this.b = bArr;
        }

        public int getType() {
            return this.a;
        }

        public byte[] getValue() {
            return this.b;
        }
    }

    public static class a {
        public byte[] a;

        public a(long j) {
            byte[] bArr = new byte[32];
            this.a = bArr;
            bArr[0] = 83;
            bArr[1] = 72;
            bArr[2] = 65;
            bArr[3] = 51;
            bArr[4] = 1;
            bArr[5] = 0;
            ThreefishEngine.wordToBytes(j, bArr, 8);
        }
    }

    public class b {
        public final c a = new c();
        public byte[] b;
        public int c;
        public long[] d;

        public b(int i) {
            this.b = new byte[i];
            this.d = new long[(i / 8)];
        }

        public void a(long[] jArr) {
            int i = this.c;
            while (true) {
                byte[] bArr = this.b;
                if (i < bArr.length) {
                    bArr[i] = 0;
                    i++;
                } else {
                    long[] jArr2 = this.a.a;
                    jArr2[1] = jArr2[1] | Long.MIN_VALUE;
                    b(jArr);
                    return;
                }
            }
        }

        public final void b(long[] jArr) {
            long[] jArr2;
            SkeinEngine skeinEngine = SkeinEngine.this;
            skeinEngine.a.init(true, skeinEngine.c, this.a.a);
            int i = 0;
            while (true) {
                jArr2 = this.d;
                if (i >= jArr2.length) {
                    break;
                }
                jArr2[i] = ThreefishEngine.bytesToWord(this.b, i * 8);
                i++;
            }
            SkeinEngine.this.a.processBlock(jArr2, jArr);
            for (int i2 = 0; i2 < jArr.length; i2++) {
                jArr[i2] = jArr[i2] ^ this.d[i2];
            }
        }

        public void c(byte[] bArr, int i, int i2, long[] jArr) {
            int i3 = 0;
            while (i2 > i3) {
                if (this.c == this.b.length) {
                    b(jArr);
                    this.a.a(false);
                    this.c = 0;
                }
                int min = Math.min(i2 - i3, this.b.length - this.c);
                System.arraycopy(bArr, i + i3, this.b, this.c, min);
                i3 += min;
                this.c += min;
                c cVar = this.a;
                if (cVar.b) {
                    long[] jArr2 = cVar.a;
                    long[] jArr3 = {jArr2[0] & BodyPartID.bodyIdMax, (jArr2[0] >>> 32) & BodyPartID.bodyIdMax, jArr2[1] & BodyPartID.bodyIdMax};
                    long j = (long) min;
                    for (int i4 = 0; i4 < 3; i4++) {
                        long j2 = j + jArr3[i4];
                        jArr3[i4] = j2;
                        j = j2 >>> 32;
                    }
                    long[] jArr4 = cVar.a;
                    jArr4[0] = ((jArr3[1] & BodyPartID.bodyIdMax) << 32) | (jArr3[0] & BodyPartID.bodyIdMax);
                    jArr4[1] = (jArr4[1] & -4294967296L) | (jArr3[2] & BodyPartID.bodyIdMax);
                } else {
                    long[] jArr5 = cVar.a;
                    long j3 = jArr5[0] + ((long) min);
                    jArr5[0] = j3;
                    if (j3 > 9223372034707292160L) {
                        cVar.b = true;
                    }
                }
            }
        }
    }

    public static class c {
        public long[] a;
        public boolean b = false;

        public c() {
            long[] jArr = new long[2];
            this.a = jArr;
            jArr[0] = 0;
            jArr[1] = 0;
            a(true);
        }

        public void a(boolean z) {
            if (z) {
                long[] jArr = this.a;
                jArr[1] = jArr[1] | Longs.MAX_POWER_OF_TWO;
                return;
            }
            long[] jArr2 = this.a;
            jArr2[1] = jArr2[1] & -4611686018427387905L;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            sb.append((int) ((this.a[1] >>> 56) & 63));
            sb.append(" first: ");
            sb.append((this.a[1] & Longs.MAX_POWER_OF_TWO) != 0);
            sb.append(", final: ");
            if ((Long.MIN_VALUE & this.a[1]) == 0) {
                z = false;
            }
            sb.append(z);
            return sb.toString();
        }
    }

    static {
        c(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        c(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        c(256, 224, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        c(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        c(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        c(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        c(512, 224, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        c(512, 384, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        c(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    public SkeinEngine(int i2, int i3) {
        this.i = new byte[1];
        if (i3 % 8 == 0) {
            this.b = i3 / 8;
            ThreefishEngine threefishEngine = new ThreefishEngine(i2);
            this.a = threefishEngine;
            this.h = new b(threefishEngine.getBlockSize());
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Output size must be a multiple of 8 bits. :", i3));
    }

    public static Parameter[] a(Parameter[] parameterArr, Parameter[] parameterArr2) {
        if (parameterArr == null) {
            return null;
        }
        if (parameterArr2 == null || parameterArr2.length != parameterArr.length) {
            parameterArr2 = new Parameter[parameterArr.length];
        }
        System.arraycopy(parameterArr, 0, parameterArr2, 0, parameterArr2.length);
        return parameterArr2;
    }

    public static void c(int i2, int i3, long[] jArr) {
        j.put(new Integer((i2 / 8) | ((i3 / 8) << 16)), jArr);
    }

    public static void d(Parameter[] parameterArr) {
        if (parameterArr != null) {
            for (int i2 = 1; i2 < parameterArr.length; i2++) {
                Parameter parameter = parameterArr[i2];
                int i3 = i2;
                while (i3 > 0) {
                    int i4 = i3 - 1;
                    if (parameter.getType() >= parameterArr[i4].getType()) {
                        break;
                    }
                    parameterArr[i3] = parameterArr[i4];
                    i3 = i4;
                }
                parameterArr[i3] = parameter;
            }
        }
    }

    public final void b(SkeinEngine skeinEngine) {
        b bVar = this.h;
        b bVar2 = skeinEngine.h;
        Objects.requireNonNull(bVar);
        bVar.b = Arrays.clone(bVar2.b, bVar.b);
        bVar.c = bVar2.c;
        bVar.d = Arrays.clone(bVar2.d, bVar.d);
        c cVar = bVar.a;
        c cVar2 = bVar2.a;
        Objects.requireNonNull(cVar);
        cVar.a = Arrays.clone(cVar2.a, cVar.a);
        cVar.b = cVar2.b;
        this.c = Arrays.clone(skeinEngine.c, this.c);
        this.d = Arrays.clone(skeinEngine.d, this.d);
        this.e = Arrays.clone(skeinEngine.e, this.e);
        this.f = a(skeinEngine.f, this.f);
        this.g = a(skeinEngine.g, this.g);
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SkeinEngine(this);
    }

    public int doFinal(byte[] bArr, int i2) {
        int i3;
        b bVar = this.h;
        if (bVar == null) {
            throw new IllegalArgumentException("Skein engine is not initialised.");
        } else if (bArr.length >= i2 + this.b) {
            bVar.a(this.c);
            if (this.g != null) {
                int i4 = 0;
                while (true) {
                    Parameter[] parameterArr = this.g;
                    if (i4 >= parameterArr.length) {
                        break;
                    }
                    Parameter parameter = parameterArr[i4];
                    e(parameter.getType(), parameter.getValue());
                    i4++;
                }
            }
            int blockSize = getBlockSize();
            int i5 = ((this.b + blockSize) - 1) / blockSize;
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * blockSize;
                int min = Math.min(blockSize, this.b - i7);
                int i8 = i2 + i7;
                int i9 = 8;
                byte[] bArr2 = new byte[8];
                ThreefishEngine.wordToBytes((long) i6, bArr2, 0);
                long[] jArr = new long[this.c.length];
                f(63);
                this.h.c(bArr2, 0, 8, jArr);
                this.h.a(jArr);
                int i10 = ((min + 8) - 1) / 8;
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = i11 * 8;
                    int min2 = Math.min(i9, min - i12);
                    if (min2 == i9) {
                        ThreefishEngine.wordToBytes(jArr[i11], bArr, i12 + i8);
                        i3 = i10;
                    } else {
                        i3 = i10;
                        ThreefishEngine.wordToBytes(jArr[i11], bArr2, 0);
                        System.arraycopy(bArr2, 0, bArr, i12 + i8, min2);
                    }
                    i11++;
                    i10 = i3;
                    i9 = 8;
                }
            }
            reset();
            return this.b;
        } else {
            throw new OutputLengthException("Output buffer is too short to hold output");
        }
    }

    public final void e(int i2, byte[] bArr) {
        f(i2);
        this.h.c(bArr, 0, bArr.length, this.c);
        this.h.a(this.c);
    }

    public final void f(int i2) {
        b bVar = this.h;
        c cVar = bVar.a;
        long[] jArr = cVar.a;
        jArr[0] = 0;
        jArr[1] = 0;
        cVar.b = false;
        cVar.a(true);
        long[] jArr2 = bVar.a.a;
        jArr2[1] = (jArr2[1] & -274877906944L) | ((((long) i2) & 63) << 56);
        bVar.c = 0;
    }

    public int getBlockSize() {
        return this.a.getBlockSize();
    }

    public int getOutputSize() {
        return this.b;
    }

    public void init(SkeinParameters skeinParameters) {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        if (skeinParameters != null) {
            if (skeinParameters.getKey().length >= 16) {
                Hashtable parameters = skeinParameters.getParameters();
                Enumeration keys = parameters.keys();
                Vector vector = new Vector();
                Vector vector2 = new Vector();
                while (keys.hasMoreElements()) {
                    Integer num = (Integer) keys.nextElement();
                    byte[] bArr = (byte[]) parameters.get(num);
                    if (num.intValue() == 0) {
                        this.e = bArr;
                    } else if (num.intValue() < 48) {
                        vector.addElement(new Parameter(num.intValue(), bArr));
                    } else {
                        vector2.addElement(new Parameter(num.intValue(), bArr));
                    }
                }
                Parameter[] parameterArr = new Parameter[vector.size()];
                this.f = parameterArr;
                vector.copyInto(parameterArr);
                d(this.f);
                Parameter[] parameterArr2 = new Parameter[vector2.size()];
                this.g = parameterArr2;
                vector2.copyInto(parameterArr2);
                d(this.g);
            } else {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
        }
        long[] jArr = (long[]) j.get(new Integer((getOutputSize() << 16) | getBlockSize()));
        int i2 = 0;
        if (this.e != null || jArr == null) {
            this.c = new long[(getBlockSize() / 8)];
            byte[] bArr2 = this.e;
            if (bArr2 != null) {
                e(0, bArr2);
            }
            e(4, new a((long) (this.b * 8)).a);
        } else {
            this.c = Arrays.clone(jArr);
        }
        if (this.f != null) {
            while (true) {
                Parameter[] parameterArr3 = this.f;
                if (i2 >= parameterArr3.length) {
                    break;
                }
                Parameter parameter = parameterArr3[i2];
                e(parameter.getType(), parameter.getValue());
                i2++;
            }
        }
        this.d = Arrays.clone(this.c);
        f(48);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SkeinEngine skeinEngine = (SkeinEngine) memoable;
        if (getBlockSize() == skeinEngine.getBlockSize() && this.b == skeinEngine.b) {
            b(skeinEngine);
            return;
        }
        throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
    }

    public void update(byte[] bArr, int i2, int i3) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.c(bArr, i2, i3, this.c);
            return;
        }
        throw new IllegalArgumentException("Skein engine is not initialised.");
    }

    public void update(byte b2) {
        byte[] bArr = this.i;
        bArr[0] = b2;
        update(bArr, 0, 1);
    }

    public void reset() {
        long[] jArr = this.d;
        long[] jArr2 = this.c;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        f(48);
    }

    public SkeinEngine(SkeinEngine skeinEngine) {
        this(skeinEngine.getBlockSize() * 8, skeinEngine.getOutputSize() * 8);
        b(skeinEngine);
    }
}
