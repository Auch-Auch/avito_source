package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.Longs;
import java.math.BigInteger;
import java.security.SecureRandom;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okhttp3.internal.ws.WebSocketProtocol;
import org.spongycastle.asn1.cmc.BodyPartID;
public class GF2nONBElement extends GF2nElement {
    public static final long[] d = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, PlaybackStateCompat.ACTION_PLAY_FROM_URI, 16384, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, LockFreeTaskQueueCore.FROZEN_MASK, LockFreeTaskQueueCore.CLOSED_MASK, Longs.MAX_POWER_OF_TWO, Long.MIN_VALUE};
    public static final long[] e = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, WebSocketProtocol.PAYLOAD_SHORT_MAX, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, LockFreeTaskQueueCore.HEAD_MASK, 2147483647L, BodyPartID.bodyIdMax, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1};
    public static final int[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    public int a;
    public int b;
    public long[] c;

    public GF2nONBElement(GF2nONBField gF2nONBField, SecureRandom secureRandom) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        int i = gF2nONBField.a;
        this.a = i;
        this.b = gF2nONBField.b;
        long[] jArr = new long[i];
        this.c = jArr;
        if (i > 1) {
            for (int i2 = 0; i2 < this.a - 1; i2++) {
                this.c[i2] = secureRandom.nextLong();
            }
            this.c[this.a - 1] = secureRandom.nextLong() >>> (64 - this.b);
            return;
        }
        jArr[0] = secureRandom.nextLong();
        long[] jArr2 = this.c;
        jArr2[0] = jArr2[0] >>> (64 - this.b);
    }

    public static GF2nONBElement ONE(GF2nONBField gF2nONBField) {
        int i = gF2nONBField.a;
        long[] jArr = new long[i];
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i2 < i3) {
                jArr[i2] = -1;
                i2++;
            } else {
                jArr[i3] = e[gF2nONBField.b - 1];
                return new GF2nONBElement(gF2nONBField, jArr);
            }
        }
    }

    public static GF2nONBElement ZERO(GF2nONBField gF2nONBField) {
        return new GF2nONBElement(gF2nONBField, new long[gF2nONBField.a]);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void a() {
        this.c = new long[this.a];
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.addToThis(gFElement);
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (this.mField.equals(gF2nONBElement.mField)) {
                for (int i = 0; i < this.a; i++) {
                    long[] jArr = this.c;
                    jArr[i] = jArr[i] ^ gF2nONBElement.c[i];
                }
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean b(int i) {
        if (i < 0 || i > this.mDegree || (this.c[i >>> 6] & d[i & 63]) == 0) {
            return false;
        }
        return true;
    }

    public final void c(byte[] bArr) {
        this.c = new long[this.a];
        for (int i = 0; i < bArr.length; i++) {
            long[] jArr = this.c;
            int i2 = i >>> 3;
            jArr[i2] = jArr[i2] | ((((long) bArr[(bArr.length - 1) - i]) & 255) << ((i & 7) << 3));
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement, org.spongycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nONBElement(this);
    }

    public final long[] d() {
        long[] jArr = this.c;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    public void e() {
        long[] jArr = new long[this.c.length];
        int i = 0;
        while (true) {
            int i2 = this.mDegree;
            if (i < i2) {
                if (b((i2 - i) - 1)) {
                    int i3 = i >>> 6;
                    jArr[i3] = jArr[i3] | d[i & 63];
                }
                i++;
            } else {
                this.c = jArr;
                return;
            }
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        for (int i = 0; i < this.a; i++) {
            if (this.c[i] != gF2nONBElement.c[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.increaseThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws ArithmeticException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.invertThis();
        return gF2nONBElement;
    }

    public void invertThis() throws ArithmeticException {
        if (!isZero()) {
            int i = 31;
            boolean z = false;
            while (!z && i >= 0) {
                if ((((long) (this.mDegree - 1)) & d[i]) != 0) {
                    z = true;
                }
                i--;
            }
            ZERO((GF2nONBField) this.mField);
            GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
            int i2 = 1;
            for (int i3 = (i + 1) - 1; i3 >= 0; i3--) {
                GF2nElement gF2nElement = (GF2nElement) gF2nONBElement.clone();
                for (int i4 = 1; i4 <= i2; i4++) {
                    gF2nElement.squareThis();
                }
                gF2nONBElement.multiplyThisBy(gF2nElement);
                i2 <<= 1;
                if ((((long) (this.mDegree - 1)) & d[i3]) != 0) {
                    gF2nONBElement.squareThis();
                    gF2nONBElement.multiplyThisBy(this);
                    i2++;
                }
            }
            gF2nONBElement.squareThis();
            return;
        }
        throw new ArithmeticException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        int i;
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            i = this.a;
            if (i2 >= i - 1 || !z2) {
                break;
            }
            z2 = z2 && (this.c[i2] & -1) == -1;
            i2++;
        }
        if (!z2) {
            return z2;
        }
        if (z2) {
            long j = this.c[i - 1];
            long[] jArr = e;
            int i3 = this.b;
            if ((j & jArr[i3 - 1]) == jArr[i3 - 1]) {
                z = true;
            }
        }
        return z;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        boolean z = true;
        for (int i = 0; i < this.a && z; i++) {
            z = z && (this.c[i] & -1) == 0;
        }
        return z;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.multiplyThisBy(gFElement);
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void multiplyThisBy(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (!this.mField.equals(gF2nONBElement.mField)) {
                throw new RuntimeException();
            } else if (equals(gFElement)) {
                squareThis();
            } else {
                long[] jArr = this.c;
                long[] jArr2 = gF2nONBElement.c;
                int i = this.a;
                long[] jArr3 = new long[i];
                int[][] iArr = ((GF2nONBField) this.mField).d;
                int i2 = i - 1;
                long[] jArr4 = d;
                long j = jArr4[63];
                long j2 = jArr4[this.b - 1];
                char c2 = 0;
                int i3 = 0;
                while (i3 < this.mDegree) {
                    int i4 = 0;
                    boolean z = false;
                    while (i4 < this.mDegree) {
                        int[] iArr2 = f;
                        int i5 = iArr2[i4];
                        int i6 = iArr2[iArr[i4][c2]];
                        int i7 = iArr[i4][c2] & 63;
                        long j3 = jArr[i5];
                        long[] jArr5 = d;
                        if ((j3 & jArr5[i4 & 63]) != 0) {
                            if ((jArr2[i6] & jArr5[i7]) != 0) {
                                z = !z;
                            }
                            if (iArr[i4][1] != -1) {
                                if ((jArr2[iArr2[iArr[i4][1]]] & jArr5[iArr[i4][1] & 63]) != 0) {
                                    z = !z;
                                }
                                i4++;
                                c2 = 0;
                            }
                        }
                        i4++;
                        c2 = 0;
                    }
                    int i8 = f[i3];
                    int i9 = i3 & 63;
                    if (z) {
                        jArr3[i8] = jArr3[i8] ^ d[i9];
                    }
                    if (this.a > 1) {
                        boolean z2 = (jArr[i2] & 1) == 1;
                        int i10 = i2 - 1;
                        int i11 = i10;
                        while (i11 >= 0) {
                            boolean z3 = (jArr[i11] & 1) != 0;
                            jArr[i11] = jArr[i11] >>> 1;
                            if (z2) {
                                jArr[i11] = jArr[i11] ^ j;
                            }
                            i11--;
                            z2 = z3;
                        }
                        jArr[i2] = jArr[i2] >>> 1;
                        if (z2) {
                            jArr[i2] = jArr[i2] ^ j2;
                        }
                        boolean z4 = (jArr2[i2] & 1) == 1;
                        while (i10 >= 0) {
                            boolean z5 = (jArr2[i10] & 1) != 0;
                            jArr2[i10] = jArr2[i10] >>> 1;
                            if (z4) {
                                jArr2[i10] = jArr2[i10] ^ j;
                            }
                            i10--;
                            z4 = z5;
                        }
                        jArr2[i2] = jArr2[i2] >>> 1;
                        if (z4) {
                            jArr2[i2] = jArr2[i2] ^ j2;
                        }
                    } else {
                        boolean z7 = (jArr[0] & 1) == 1;
                        jArr[0] = jArr[0] >>> 1;
                        if (z7) {
                            jArr[0] = jArr[0] ^ j2;
                        }
                        boolean z8 = (jArr2[0] & 1) == 1;
                        jArr2[0] = jArr2[0] >>> 1;
                        if (z8) {
                            jArr2[0] = jArr2[0] ^ j2;
                        }
                    }
                    i3++;
                    c2 = 0;
                }
                System.arraycopy(jArr3, 0, this.c, 0, this.a);
            }
        } else {
            throw new RuntimeException("The elements have different representation: not yet implemented");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        int i;
        if (trace() != 1) {
            long j = d[63];
            long[] jArr = new long[this.a];
            int i2 = 0;
            long j2 = 0;
            while (true) {
                i = this.a;
                if (i2 >= i - 1) {
                    break;
                }
                for (int i3 = 1; i3 < 64; i3++) {
                    long[] jArr2 = d;
                    long j3 = jArr2[i3];
                    long[] jArr3 = this.c;
                    if (((j3 & jArr3[i2]) == 0 || (jArr2[i3 - 1] & j2) == 0) && !((jArr3[i2] & jArr2[i3]) == 0 && (jArr2[i3 - 1] & j2) == 0)) {
                        j2 ^= jArr2[i3];
                    }
                }
                jArr[i2] = j2;
                int i4 = ((j2 & j) > 0 ? 1 : ((j2 & j) == 0 ? 0 : -1));
                j2 = ((i4 == 0 || (1 & this.c[i2 + 1]) != 1) && !(i4 == 0 && (this.c[i2 + 1] & 1) == 0)) ? 1 : 0;
                i2++;
            }
            int i5 = this.mDegree & 63;
            long j4 = this.c[i - 1];
            for (int i6 = 1; i6 < i5; i6++) {
                long[] jArr4 = d;
                if (((jArr4[i6] & j4) == 0 || (jArr4[i6 - 1] & j2) == 0) && !((jArr4[i6] & j4) == 0 && (jArr4[i6 - 1] & j2) == 0)) {
                    j2 ^= jArr4[i6];
                }
            }
            jArr[this.a - 1] = j2;
            return new GF2nONBElement((GF2nONBField) this.mField, jArr);
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareRootThis();
        return gF2nONBElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        long[] d2 = d();
        int i = this.a - 1;
        int i2 = this.b - 1;
        long j = d[63];
        boolean z = (d2[0] & 1) != 0;
        int i3 = i;
        while (i3 >= 0) {
            boolean z2 = (d2[i3] & 1) != 0;
            d2[i3] = d2[i3] >>> 1;
            if (z) {
                if (i3 == i) {
                    d2[i3] = d2[i3] ^ d[i2];
                } else {
                    d2[i3] = d2[i3] ^ j;
                }
            }
            i3--;
            z = z2;
        }
        System.arraycopy(d2, 0, this.c, 0, this.a);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        long[] d2 = d();
        int i = this.a - 1;
        int i2 = this.b - 1;
        long[] jArr = d;
        long j = jArr[63];
        boolean z = (d2[i] & jArr[i2]) != 0;
        int i3 = 0;
        while (i3 < i) {
            boolean z2 = (d2[i3] & j) != 0;
            d2[i3] = d2[i3] << 1;
            if (z) {
                d2[i3] = 1 ^ d2[i3];
            }
            i3++;
            z = z2;
        }
        long j2 = d2[i];
        long[] jArr2 = d;
        boolean z3 = (j2 & jArr2[i2]) != 0;
        d2[i] = d2[i] << 1;
        if (z) {
            d2[i] = d2[i] ^ 1;
        }
        if (z3) {
            d2[i] = jArr2[i2 + 1] ^ d2[i];
        }
        System.arraycopy(d2, 0, this.c, 0, this.a);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        return (this.c[this.a - 1] & d[this.b - 1]) != 0;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        int i = ((this.mDegree - 1) >> 3) + 1;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (i2 & 7) << 3;
            bArr[(i - i2) - 1] = (byte) ((int) ((this.c[i2 >>> 3] & (255 << i3)) >>> i3));
        }
        return bArr;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return toString(16);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        int i = this.a - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((this.c[i3] & d[i4]) != 0) {
                    i2 ^= 1;
                }
            }
        }
        int i5 = this.b;
        for (int i6 = 0; i6 < i5; i6++) {
            if ((this.c[i] & d[i6]) != 0) {
                i2 ^= 1;
            }
        }
        return i2;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString(int i) {
        String str;
        long[] d2 = d();
        int i2 = this.b;
        String str2 = "";
        if (i == 2) {
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                if ((d2[d2.length - 1] & (1 << i2)) == 0) {
                    str = a.c3(str2, "0");
                } else {
                    str = a.c3(str2, "1");
                }
                str2 = str;
            }
            for (int length = d2.length - 2; length >= 0; length--) {
                for (int i3 = 63; i3 >= 0; i3--) {
                    if ((d2[length] & d[i3]) == 0) {
                        str2 = a.c3(str2, "0");
                    } else {
                        str2 = a.c3(str2, "1");
                    }
                }
            }
        } else if (i == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            int length2 = d2.length;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                StringBuilder L = a.L(str2);
                L.append(cArr[((int) (d2[length2] >>> 60)) & 15]);
                StringBuilder L2 = a.L(L.toString());
                L2.append(cArr[((int) (d2[length2] >>> 56)) & 15]);
                StringBuilder L3 = a.L(L2.toString());
                L3.append(cArr[((int) (d2[length2] >>> 52)) & 15]);
                StringBuilder L4 = a.L(L3.toString());
                L4.append(cArr[((int) (d2[length2] >>> 48)) & 15]);
                StringBuilder L5 = a.L(L4.toString());
                L5.append(cArr[((int) (d2[length2] >>> 44)) & 15]);
                StringBuilder L6 = a.L(L5.toString());
                L6.append(cArr[((int) (d2[length2] >>> 40)) & 15]);
                StringBuilder L7 = a.L(L6.toString());
                L7.append(cArr[((int) (d2[length2] >>> 36)) & 15]);
                StringBuilder L8 = a.L(L7.toString());
                L8.append(cArr[((int) (d2[length2] >>> 32)) & 15]);
                StringBuilder L9 = a.L(L8.toString());
                L9.append(cArr[((int) (d2[length2] >>> 28)) & 15]);
                StringBuilder L10 = a.L(L9.toString());
                L10.append(cArr[((int) (d2[length2] >>> 24)) & 15]);
                StringBuilder L11 = a.L(L10.toString());
                L11.append(cArr[((int) (d2[length2] >>> 20)) & 15]);
                StringBuilder L12 = a.L(L11.toString());
                L12.append(cArr[((int) (d2[length2] >>> 16)) & 15]);
                StringBuilder L13 = a.L(L12.toString());
                L13.append(cArr[((int) (d2[length2] >>> 12)) & 15]);
                StringBuilder L14 = a.L(L13.toString());
                L14.append(cArr[((int) (d2[length2] >>> 8)) & 15]);
                StringBuilder L15 = a.L(L14.toString());
                L15.append(cArr[((int) (d2[length2] >>> 4)) & 15]);
                StringBuilder L16 = a.L(L15.toString());
                L16.append(cArr[((int) d2[length2]) & 15]);
                str2 = a.c3(L16.toString(), " ");
            }
        }
        return str2;
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, byte[] bArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        int i = gF2nONBField.a;
        this.a = i;
        this.b = gF2nONBField.b;
        this.c = new long[i];
        c(bArr);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, BigInteger bigInteger) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        int i = gF2nONBField.a;
        this.a = i;
        this.b = gF2nONBField.b;
        this.c = new long[i];
        c(bigInteger.toByteArray());
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, long[] jArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.a = gF2nONBField.a;
        this.b = gF2nONBField.b;
        this.c = jArr;
    }

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.mField;
        this.mField = gF2nField;
        this.mDegree = gF2nField.getDegree();
        GF2nField gF2nField2 = this.mField;
        int i = ((GF2nONBField) gF2nField2).a;
        this.a = i;
        this.b = ((GF2nONBField) gF2nField2).b;
        this.c = new long[i];
        System.arraycopy(gF2nONBElement.d(), 0, this.c, 0, this.a);
    }
}
