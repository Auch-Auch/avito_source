package io.reactivex.internal.util;
public final class OpenHashSet<T> {
    public final float a;
    public int b;
    public int c;
    public int d;
    public T[] e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public static int a(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a3 = a(t.hashCode()) & i;
        T t3 = tArr[a3];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a3 = (a3 + 1) & i;
                t2 = tArr[a3];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a3] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            T[] tArr2 = this.e;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = (T[]) new Object[i3];
            while (true) {
                int i5 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int a4 = a(tArr2[length].hashCode()) & i4;
                if (tArr3[a4] != null) {
                    do {
                        a4 = (a4 + 1) & i4;
                    } while (tArr3[a4] != null);
                }
                tArr3[a4] = tArr2[length];
                i2 = i5;
            }
            this.b = i4;
            this.d = (int) (((float) i3) * this.a);
            this.e = tArr3;
        }
        return true;
    }

    public boolean b(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a3 = a(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= a3 || a3 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= a3 && a3 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public Object[] keys() {
        return this.e;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a3 = a(t.hashCode()) & i;
        T t3 = tArr[a3];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            b(a3, tArr, i);
            return true;
        }
        do {
            a3 = (a3 + 1) & i;
            t2 = tArr[a3];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        b(a3, tArr, i);
        return true;
    }

    public int size() {
        return this.c;
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.a = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.b = roundToPowerOfTwo - 1;
        this.d = (int) (f * ((float) roundToPowerOfTwo));
        this.e = (T[]) new Object[roundToPowerOfTwo];
    }
}
