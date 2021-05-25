package androidx.databinding;

import java.util.ArrayList;
import java.util.List;
public class CallbackRegistry<C, T, A> implements Cloneable {
    public List<C> a = new ArrayList();
    public long b = 0;
    public long[] c;
    public int d;
    public final NotifierCallback<C, T, A> e;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c, T t, int i, A a);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.e = notifierCallback;
    }

    public final boolean a(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.b) != 0;
        }
        long[] jArr = this.c;
        if (jArr == null || (i2 = (i / 64) - 1) >= jArr.length) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i2]) != 0) {
            return true;
        }
        return false;
    }

    public synchronized void add(C c2) {
        if (c2 != null) {
            int lastIndexOf = this.a.lastIndexOf(c2);
            if (lastIndexOf < 0 || a(lastIndexOf)) {
                this.a.add(c2);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public final void b(T t, int i, A a3, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.e.onNotifyCallback(this.a.get(i2), t, i, a3);
            }
            j2 <<= 1;
            i2++;
        }
    }

    public final void c(T t, int i, A a3, int i2) {
        if (i2 < 0) {
            b(t, i, a3, 0, Math.min(64, this.a.size()), this.b);
            return;
        }
        long j = this.c[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.a.size(), i3 + 64);
        c(t, i, a3, i2 - 1);
        b(t, i, a3, i3, min, j);
    }

    public synchronized void clear() {
        if (this.d == 0) {
            this.a.clear();
        } else if (!this.a.isEmpty()) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                e(size);
            }
        }
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.a.size());
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!a(i)) {
                arrayList.add(this.a.get(i));
            }
        }
        return arrayList;
    }

    public final void d(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.a.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    public final void e(int i) {
        if (i < 64) {
            this.b = (1 << i) | this.b;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.c;
        if (jArr == null) {
            this.c = new long[(this.a.size() / 64)];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[(this.a.size() / 64)];
            long[] jArr3 = this.c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.c = jArr2;
        }
        long j = 1 << (i % 64);
        long[] jArr4 = this.c;
        jArr4[i2] = j | jArr4[i2];
    }

    public synchronized boolean isEmpty() {
        if (this.a.isEmpty()) {
            return true;
        }
        if (this.d == 0) {
            return false;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!a(i)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void notifyCallbacks(T t, int i, A a3) {
        this.d++;
        int size = this.a.size();
        long[] jArr = this.c;
        int i2 = -1;
        if (jArr != null) {
            i2 = -1 + jArr.length;
        }
        c(t, i, a3, i2);
        b(t, i, a3, (i2 + 2) * 64, size, 0);
        int i3 = this.d - 1;
        this.d = i3;
        if (i3 == 0) {
            long[] jArr2 = this.c;
            if (jArr2 != null) {
                for (int length = jArr2.length - 1; length >= 0; length--) {
                    long j = this.c[length];
                    if (j != 0) {
                        d((length + 1) * 64, j);
                        this.c[length] = 0;
                    }
                }
            }
            long j2 = this.b;
            if (j2 != 0) {
                d(0, j2);
                this.b = 0;
            }
        }
    }

    public synchronized void remove(C c2) {
        if (this.d == 0) {
            this.a.remove(c2);
        } else {
            int lastIndexOf = this.a.lastIndexOf(c2);
            if (lastIndexOf >= 0) {
                e(lastIndexOf);
            }
        }
    }

    @Override // java.lang.Object
    public synchronized CallbackRegistry<C, T, A> clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e2;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.b = 0;
                callbackRegistry.c = null;
                callbackRegistry.d = 0;
                callbackRegistry.a = new ArrayList();
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (!a(i)) {
                        callbackRegistry.a.add(this.a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
                return callbackRegistry;
            }
        } catch (CloneNotSupportedException e4) {
            callbackRegistry = null;
            e2 = e4;
            e2.printStackTrace();
            return callbackRegistry;
        }
        return callbackRegistry;
    }

    public synchronized void copyCallbacks(List<C> list) {
        list.clear();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!a(i)) {
                list.add(this.a.get(i));
            }
        }
    }
}
