package x6.e.b.e;

import java.util.Vector;
public class e {
    public short a;
    public byte[] b;
    public Vector c;

    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public e(short s, int i) {
        Vector vector = new Vector();
        this.c = vector;
        this.a = s;
        this.b = new byte[i];
        vector.addElement(new a(0, i));
    }

    public void a(short s, int i, byte[] bArr, int i2, int i3, int i4) {
        a aVar;
        int i5;
        int i6 = i3 + i4;
        if (this.a == s && this.b.length == i && i6 <= i) {
            int i7 = 0;
            if (i4 != 0) {
                while (i7 < this.c.size() && (i5 = (aVar = (a) this.c.elementAt(i7)).a) < i6) {
                    if (aVar.b > i3) {
                        int max = Math.max(i5, i3);
                        int min = Math.min(aVar.b, i6);
                        System.arraycopy(bArr, (i2 + max) - i3, this.b, max, min - max);
                        if (max != aVar.a) {
                            int i8 = aVar.b;
                            if (min != i8) {
                                i7++;
                                this.c.insertElementAt(new a(min, i8), i7);
                            }
                            aVar.b = max;
                        } else if (min == aVar.b) {
                            this.c.removeElementAt(i7);
                            i7--;
                        } else {
                            aVar.a = min;
                        }
                    }
                    i7++;
                }
            } else if (i3 == 0 && !this.c.isEmpty() && ((a) this.c.firstElement()).b == 0) {
                this.c.removeElementAt(0);
            }
        }
    }
}
