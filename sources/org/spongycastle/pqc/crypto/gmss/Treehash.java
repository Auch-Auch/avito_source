package org.spongycastle.pqc.crypto.gmss;

import a2.b.a.a.a;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.Integers;
import org.spongycastle.util.encoders.Hex;
public class Treehash {
    public int a;
    public Vector b;
    public Vector c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Digest l;

    public Treehash(Digest digest, byte[][] bArr, int[] iArr) {
        this.l = digest;
        this.a = iArr[0];
        this.g = iArr[1];
        this.h = iArr[2];
        if (iArr[3] == 1) {
            this.j = true;
        } else {
            this.j = false;
        }
        if (iArr[4] == 1) {
            this.i = true;
        } else {
            this.i = false;
        }
        if (iArr[5] == 1) {
            this.k = true;
        } else {
            this.k = false;
        }
        this.c = new Vector();
        for (int i2 = 0; i2 < this.g; i2++) {
            this.c.addElement(Integers.valueOf(iArr[i2 + 6]));
        }
        this.d = bArr[0];
        this.e = bArr[1];
        this.f = bArr[2];
        this.b = new Vector();
        for (int i3 = 0; i3 < this.g; i3++) {
            this.b.addElement(bArr[i3 + 3]);
        }
    }

    public void destroy() {
        this.i = false;
        this.j = false;
        this.d = null;
        this.g = 0;
        this.h = -1;
    }

    public byte[] getFirstNode() {
        return this.d;
    }

    public int getFirstNodeHeight() {
        if (this.d == null) {
            return this.a;
        }
        return this.h;
    }

    public int getLowestNodeHeight() {
        if (this.d == null) {
            return this.a;
        }
        if (this.g == 0) {
            return this.h;
        }
        return Math.min(this.h, ((Integer) this.c.lastElement()).intValue());
    }

    public byte[] getSeedActive() {
        return this.e;
    }

    public byte[][] getStatByte() {
        int[] iArr = new int[2];
        iArr[1] = this.l.getDigestSize();
        iArr[0] = this.g + 3;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        bArr[0] = this.d;
        bArr[1] = this.e;
        bArr[2] = this.f;
        for (int i2 = 0; i2 < this.g; i2++) {
            bArr[i2 + 3] = (byte[]) this.b.elementAt(i2);
        }
        return bArr;
    }

    public int[] getStatInt() {
        int i2 = this.g;
        int[] iArr = new int[(i2 + 6)];
        iArr[0] = this.a;
        iArr[1] = i2;
        iArr[2] = this.h;
        if (this.j) {
            iArr[3] = 1;
        } else {
            iArr[3] = 0;
        }
        if (this.i) {
            iArr[4] = 1;
        } else {
            iArr[4] = 0;
        }
        if (this.k) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        for (int i3 = 0; i3 < this.g; i3++) {
            iArr[i3 + 6] = ((Integer) this.c.elementAt(i3)).intValue();
        }
        return iArr;
    }

    public Vector getTailStack() {
        return this.b;
    }

    public void initialize() {
        if (!this.k) {
            PrintStream printStream = System.err;
            StringBuilder L = a.L("Seed ");
            L.append(this.a);
            L.append(" not initialized");
            printStream.println(L.toString());
            return;
        }
        this.c = new Vector();
        this.g = 0;
        this.d = null;
        this.h = -1;
        this.i = true;
        System.arraycopy(this.f, 0, this.e, 0, this.l.getDigestSize());
    }

    public void initializeSeed(byte[] bArr) {
        System.arraycopy(bArr, 0, this.f, 0, this.l.getDigestSize());
        this.k = true;
    }

    public void setFirstNode(byte[] bArr) {
        if (!this.i) {
            initialize();
        }
        this.d = bArr;
        this.h = this.a;
        this.j = true;
    }

    public String toString() {
        String str = "Treehash    : ";
        for (int i2 = 0; i2 < this.g + 6; i2++) {
            str = a.j(a.L(str), getStatInt()[i2], " ");
        }
        for (int i3 = 0; i3 < this.g + 3; i3++) {
            if (getStatByte()[i3] != null) {
                str = a.t(a.L(str), new String(Hex.encode(getStatByte()[i3])), " ");
            } else {
                str = a.c3(str, "null ");
            }
        }
        StringBuilder Q = a.Q(str, "  ");
        Q.append(this.l.getDigestSize());
        return Q.toString();
    }

    public void update(GMSSRandom gMSSRandom, byte[] bArr) {
        if (this.j) {
            System.err.println("No more update possible for treehash instance!");
        } else if (!this.i) {
            System.err.println("Treehash instance not initialized before update");
        } else {
            byte[] bArr2 = new byte[this.l.getDigestSize()];
            gMSSRandom.nextSeed(this.e);
            if (this.d == null) {
                this.d = bArr;
                this.h = 0;
            } else {
                int i2 = 0;
                while (this.g > 0 && i2 == ((Integer) this.c.lastElement()).intValue()) {
                    int digestSize = this.l.getDigestSize() << 1;
                    byte[] bArr3 = new byte[digestSize];
                    System.arraycopy(this.b.lastElement(), 0, bArr3, 0, this.l.getDigestSize());
                    Vector vector = this.b;
                    vector.removeElementAt(vector.size() - 1);
                    Vector vector2 = this.c;
                    vector2.removeElementAt(vector2.size() - 1);
                    System.arraycopy(bArr, 0, bArr3, this.l.getDigestSize(), this.l.getDigestSize());
                    this.l.update(bArr3, 0, digestSize);
                    bArr = new byte[this.l.getDigestSize()];
                    this.l.doFinal(bArr, 0);
                    i2++;
                    this.g--;
                }
                this.b.addElement(bArr);
                this.c.addElement(Integers.valueOf(i2));
                this.g++;
                if (((Integer) this.c.lastElement()).intValue() == this.h) {
                    int digestSize2 = this.l.getDigestSize() << 1;
                    byte[] bArr4 = new byte[digestSize2];
                    System.arraycopy(this.d, 0, bArr4, 0, this.l.getDigestSize());
                    System.arraycopy(this.b.lastElement(), 0, bArr4, this.l.getDigestSize(), this.l.getDigestSize());
                    Vector vector3 = this.b;
                    vector3.removeElementAt(vector3.size() - 1);
                    Vector vector4 = this.c;
                    vector4.removeElementAt(vector4.size() - 1);
                    this.l.update(bArr4, 0, digestSize2);
                    byte[] bArr5 = new byte[this.l.getDigestSize()];
                    this.d = bArr5;
                    this.l.doFinal(bArr5, 0);
                    this.h++;
                    this.g = 0;
                }
            }
            if (this.h == this.a) {
                this.j = true;
            }
        }
    }

    public void updateNextSeed(GMSSRandom gMSSRandom) {
        gMSSRandom.nextSeed(this.f);
    }

    public boolean wasFinished() {
        return this.j;
    }

    public boolean wasInitialized() {
        return this.i;
    }

    public Treehash(Vector vector, int i2, Digest digest) {
        this.b = vector;
        this.a = i2;
        this.d = null;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = digest;
        this.f = new byte[digest.getDigestSize()];
        this.e = new byte[this.l.getDigestSize()];
    }
}
