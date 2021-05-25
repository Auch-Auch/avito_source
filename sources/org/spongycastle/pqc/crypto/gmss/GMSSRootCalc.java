package org.spongycastle.pqc.crypto.gmss;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.encoders.Hex;
public class GMSSRootCalc {
    public int a;
    public int b;
    public Treehash[] c;
    public Vector[] d;
    public byte[] e;
    public byte[][] f;
    public int g;
    public Vector h;
    public Vector i;
    public Digest j;
    public GMSSDigestProvider k;
    public int[] l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    public GMSSRootCalc(Digest digest, byte[][] bArr, int[] iArr, Treehash[] treehashArr, Vector[] vectorArr) {
        Treehash[] treehashArr2;
        this.j = this.k.get();
        this.k = this.k;
        int i2 = iArr[0];
        this.a = i2;
        this.b = iArr[1];
        this.g = iArr[2];
        this.o = iArr[3];
        this.p = iArr[4];
        if (iArr[5] == 1) {
            this.n = true;
        } else {
            this.n = false;
        }
        if (iArr[6] == 1) {
            this.m = true;
        } else {
            this.m = false;
        }
        int i3 = iArr[7];
        this.l = new int[i2];
        for (int i4 = 0; i4 < this.a; i4++) {
            this.l[i4] = iArr[i4 + 8];
        }
        this.i = new Vector();
        for (int i5 = 0; i5 < i3; i5++) {
            this.i.addElement(Integers.valueOf(iArr[this.a + 8 + i5]));
        }
        this.e = bArr[0];
        int i6 = this.a;
        int[] iArr2 = new int[2];
        iArr2[1] = this.b;
        iArr2[0] = i6;
        this.f = (byte[][]) Array.newInstance(byte.class, iArr2);
        int i7 = 0;
        while (i7 < this.a) {
            int i8 = i7 + 1;
            this.f[i7] = bArr[i8];
            i7 = i8;
        }
        this.h = new Vector();
        for (int i9 = 0; i9 < i3; i9++) {
            this.h.addElement(bArr[this.a + 1 + i9]);
        }
        if (treehashArr == null) {
            treehashArr2 = null;
        } else {
            Treehash[] treehashArr3 = new Treehash[treehashArr.length];
            System.arraycopy(treehashArr, 0, treehashArr3, 0, treehashArr.length);
            treehashArr2 = treehashArr3;
        }
        this.c = treehashArr2;
        this.d = AppCompatDelegateImpl.i.G(vectorArr);
    }

    public byte[][] getAuthPath() {
        byte[][] bArr = this.f;
        if (bArr == null) {
            return null;
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr2[i2] = Arrays.clone(bArr[i2]);
        }
        return bArr2;
    }

    public Vector[] getRetain() {
        return AppCompatDelegateImpl.i.G(this.d);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.e);
    }

    public Vector getStack() {
        Vector vector = new Vector();
        Enumeration elements = this.h.elements();
        while (elements.hasMoreElements()) {
            vector.addElement(elements.nextElement());
        }
        return vector;
    }

    public byte[][] getStatByte() {
        int i2;
        Vector vector = this.h;
        if (vector == null) {
            i2 = 0;
        } else {
            i2 = vector.size();
        }
        int[] iArr = new int[2];
        iArr[1] = 64;
        iArr[0] = this.a + 1 + i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        bArr[0] = this.e;
        int i3 = 0;
        while (i3 < this.a) {
            int i4 = i3 + 1;
            bArr[i4] = this.f[i3];
            i3 = i4;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            bArr[this.a + 1 + i5] = (byte[]) this.h.elementAt(i5);
        }
        return bArr;
    }

    public int[] getStatInt() {
        int i2;
        Vector vector = this.h;
        if (vector == null) {
            i2 = 0;
        } else {
            i2 = vector.size();
        }
        int i3 = this.a;
        int[] iArr = new int[(i3 + 8 + i2)];
        iArr[0] = i3;
        iArr[1] = this.b;
        iArr[2] = this.g;
        iArr[3] = this.o;
        iArr[4] = this.p;
        if (this.n) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.m) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = i2;
        for (int i4 = 0; i4 < this.a; i4++) {
            iArr[i4 + 8] = this.l[i4];
        }
        for (int i5 = 0; i5 < i2; i5++) {
            iArr[this.a + 8 + i5] = ((Integer) this.i.elementAt(i5)).intValue();
        }
        return iArr;
    }

    public Treehash[] getTreehash() {
        Treehash[] treehashArr = this.c;
        if (treehashArr == null) {
            return null;
        }
        Treehash[] treehashArr2 = new Treehash[treehashArr.length];
        System.arraycopy(treehashArr, 0, treehashArr2, 0, treehashArr.length);
        return treehashArr2;
    }

    public void initialize(Vector vector) {
        int i2;
        this.c = new Treehash[(this.a - this.g)];
        int i3 = 0;
        while (true) {
            i2 = this.a;
            if (i3 >= i2 - this.g) {
                break;
            }
            this.c[i3] = new Treehash(vector, i3, this.k.get());
            i3++;
        }
        this.l = new int[i2];
        int[] iArr = new int[2];
        iArr[1] = this.b;
        iArr[0] = i2;
        this.f = (byte[][]) Array.newInstance(byte.class, iArr);
        this.e = new byte[this.b];
        this.h = new Vector();
        this.i = new Vector();
        this.m = true;
        this.n = false;
        for (int i4 = 0; i4 < this.a; i4++) {
            this.l[i4] = -1;
        }
        this.d = new Vector[(this.g - 1)];
        for (int i5 = 0; i5 < this.g - 1; i5++) {
            this.d[i5] = new Vector();
        }
        this.o = 3;
        this.p = 0;
    }

    public void initializeTreehashSeed(byte[] bArr, int i2) {
        this.c[i2].initializeSeed(bArr);
    }

    public String toString() {
        int i2;
        Vector vector = this.h;
        if (vector == null) {
            i2 = 0;
        } else {
            i2 = vector.size();
        }
        String str = "";
        for (int i3 = 0; i3 < this.a + 8 + i2; i3++) {
            str = a.j(a.L(str), getStatInt()[i3], " ");
        }
        for (int i4 = 0; i4 < this.a + 1 + i2; i4++) {
            str = a.t(a.L(str), new String(Hex.encode(getStatByte()[i4])), " ");
        }
        StringBuilder Q = a.Q(str, "  ");
        Q.append(this.k.get().getDigestSize());
        return Q.toString();
    }

    public void update(byte[] bArr, byte[] bArr2) {
        int i2 = this.p;
        if (i2 < this.a - this.g && this.o - 2 == this.l[0]) {
            initializeTreehashSeed(bArr, i2);
            this.p++;
            this.o *= 2;
        }
        update(bArr2);
    }

    public boolean wasFinished() {
        return this.n;
    }

    public boolean wasInitialized() {
        return this.m;
    }

    public void update(byte[] bArr) {
        if (this.n) {
            System.out.print("Too much updates for Tree!!");
        } else if (!this.m) {
            System.err.println("GMSSRootCalc not initialized!");
        } else {
            int[] iArr = this.l;
            iArr[0] = iArr[0] + 1;
            if (iArr[0] == 1) {
                System.arraycopy(bArr, 0, this.f[0], 0, this.b);
            } else if (iArr[0] == 3 && this.a > this.g) {
                this.c[0].setFirstNode(bArr);
            }
            int[] iArr2 = this.l;
            if ((iArr2[0] - 3) % 2 == 0 && iArr2[0] >= 3 && this.a == this.g) {
                this.d[0].insertElementAt(bArr, 0);
            }
            if (this.l[0] == 0) {
                this.h.addElement(bArr);
                this.i.addElement(Integers.valueOf(0));
                return;
            }
            int i2 = this.b;
            byte[] bArr2 = new byte[i2];
            int i3 = i2 << 1;
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            int i4 = 0;
            while (this.h.size() > 0 && i4 == ((Integer) this.i.lastElement()).intValue()) {
                System.arraycopy(this.h.lastElement(), 0, bArr3, 0, this.b);
                Vector vector = this.h;
                vector.removeElementAt(vector.size() - 1);
                Vector vector2 = this.i;
                vector2.removeElementAt(vector2.size() - 1);
                int i5 = this.b;
                System.arraycopy(bArr2, 0, bArr3, i5, i5);
                this.j.update(bArr3, 0, i3);
                bArr2 = new byte[this.j.getDigestSize()];
                this.j.doFinal(bArr2, 0);
                i4++;
                if (i4 < this.a) {
                    int[] iArr3 = this.l;
                    iArr3[i4] = iArr3[i4] + 1;
                    if (iArr3[i4] == 1) {
                        System.arraycopy(bArr2, 0, this.f[i4], 0, this.b);
                    }
                    if (i4 >= this.a - this.g) {
                        if (i4 == 0) {
                            System.out.println("M���P");
                        }
                        int[] iArr4 = this.l;
                        if ((iArr4[i4] - 3) % 2 == 0 && iArr4[i4] >= 3) {
                            this.d[i4 - (this.a - this.g)].insertElementAt(bArr2, 0);
                        }
                    } else if (this.l[i4] == 3) {
                        this.c[i4].setFirstNode(bArr2);
                    }
                }
            }
            this.h.addElement(bArr2);
            this.i.addElement(Integers.valueOf(i4));
            if (i4 == this.a) {
                this.n = true;
                this.m = false;
                this.e = (byte[]) this.h.lastElement();
            }
        }
    }

    public GMSSRootCalc(int i2, int i3, GMSSDigestProvider gMSSDigestProvider) {
        this.a = i2;
        this.k = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.j = digest;
        int digestSize = digest.getDigestSize();
        this.b = digestSize;
        this.g = i3;
        this.l = new int[i2];
        int[] iArr = new int[2];
        iArr[1] = digestSize;
        iArr[0] = i2;
        this.f = (byte[][]) Array.newInstance(byte.class, iArr);
        this.e = new byte[this.b];
        this.d = new Vector[(this.g - 1)];
        for (int i4 = 0; i4 < i3 - 1; i4++) {
            this.d[i4] = new Vector();
        }
    }
}
