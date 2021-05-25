package androidx.recyclerview.widget;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;
    public T[] a;
    public T[] b;
    public int c;
    public int d;
    public int e;
    public Callback f;
    public BatchedCallback g;
    public int h;
    public final Class<T> i;

    public static class BatchedCallback<T2> extends Callback<T2> {
        public final Callback<T2> a;
        public final BatchingListUpdateCallback b;

        public BatchedCallback(Callback<T2> callback) {
            this.a = callback;
            this.b = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.a.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.a.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.b.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.a.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.b.onChanged(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.b.onInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.b.onMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.b.onRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.b.onChanged(i, i2, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    public final int a(T t, boolean z) {
        int c2 = c(t, this.a, 0, this.h, 1);
        if (c2 == -1) {
            c2 = 0;
        } else if (c2 < this.h) {
            T t2 = this.a[c2];
            if (this.f.areItemsTheSame(t2, t)) {
                if (this.f.areContentsTheSame(t2, t)) {
                    this.a[c2] = t;
                    return c2;
                }
                this.a[c2] = t;
                Callback callback = this.f;
                callback.onChanged(c2, 1, callback.getChangePayload(t2, t));
                return c2;
            }
        }
        int i2 = this.h;
        if (c2 <= i2) {
            T[] tArr = this.a;
            if (i2 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, tArr.length + 10));
                System.arraycopy(this.a, 0, tArr2, 0, c2);
                tArr2[c2] = t;
                System.arraycopy(this.a, c2, tArr2, c2 + 1, this.h - c2);
                this.a = tArr2;
            } else {
                System.arraycopy(tArr, c2, tArr, c2 + 1, i2 - c2);
                this.a[c2] = t;
            }
            this.h++;
            if (z) {
                this.f.onInserted(c2, 1);
            }
            return c2;
        }
        StringBuilder M = a.M("cannot add item to ", c2, " because size is ");
        M.append(this.h);
        throw new IndexOutOfBoundsException(M.toString());
    }

    public int add(T t) {
        i();
        return a(t, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull T[] tArr, boolean z) {
        i();
        if (tArr.length != 0) {
            if (z) {
                b(tArr);
                return;
            }
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.i, tArr.length);
            System.arraycopy(tArr, 0, objArr, 0, tArr.length);
            b(objArr);
        }
    }

    public final void b(T[] tArr) {
        if (tArr.length >= 1) {
            int h2 = h(tArr);
            int i2 = 0;
            if (this.h == 0) {
                this.a = tArr;
                this.h = h2;
                this.f.onInserted(0, h2);
                return;
            }
            boolean z = !(this.f instanceof BatchedCallback);
            if (z) {
                beginBatchedUpdates();
            }
            this.b = this.a;
            this.c = 0;
            int i3 = this.h;
            this.d = i3;
            this.a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, i3 + h2 + 10));
            this.e = 0;
            while (true) {
                int i4 = this.c;
                int i5 = this.d;
                if (i4 >= i5 && i2 >= h2) {
                    break;
                } else if (i4 == i5) {
                    int i6 = h2 - i2;
                    System.arraycopy(tArr, i2, this.a, this.e, i6);
                    int i7 = this.e + i6;
                    this.e = i7;
                    this.h += i6;
                    this.f.onInserted(i7 - i6, i6);
                    break;
                } else if (i2 == h2) {
                    int i8 = i5 - i4;
                    System.arraycopy(this.b, i4, this.a, this.e, i8);
                    this.e += i8;
                    break;
                } else {
                    T t = this.b[i4];
                    T t2 = tArr[i2];
                    int compare = this.f.compare(t, t2);
                    if (compare > 0) {
                        T[] tArr2 = this.a;
                        int i9 = this.e;
                        int i10 = i9 + 1;
                        this.e = i10;
                        tArr2[i9] = t2;
                        this.h++;
                        i2++;
                        this.f.onInserted(i10 - 1, 1);
                    } else if (compare != 0 || !this.f.areItemsTheSame(t, t2)) {
                        T[] tArr3 = this.a;
                        int i11 = this.e;
                        this.e = i11 + 1;
                        tArr3[i11] = t;
                        this.c++;
                    } else {
                        T[] tArr4 = this.a;
                        int i12 = this.e;
                        this.e = i12 + 1;
                        tArr4[i12] = t2;
                        i2++;
                        this.c++;
                        if (!this.f.areContentsTheSame(t, t2)) {
                            Callback callback = this.f;
                            callback.onChanged(this.e - 1, 1, callback.getChangePayload(t, t2));
                        }
                    }
                }
            }
            this.b = null;
            if (z) {
                endBatchedUpdates();
            }
        }
    }

    public void beginBatchedUpdates() {
        i();
        Callback callback = this.f;
        if (!(callback instanceof BatchedCallback)) {
            if (this.g == null) {
                this.g = new BatchedCallback(callback);
            }
            this.f = this.g;
        }
    }

    public final int c(T t, T[] tArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int i5 = (i2 + i3) / 2;
            T t2 = tArr[i5];
            int compare = this.f.compare(t2, t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else if (compare != 0) {
                i3 = i5;
            } else if (this.f.areItemsTheSame(t2, t)) {
                return i5;
            } else {
                int i6 = i5 - 1;
                while (true) {
                    if (i6 < i2) {
                        break;
                    }
                    T t3 = this.a[i6];
                    if (this.f.compare(t3, t) != 0) {
                        break;
                    } else if (this.f.areItemsTheSame(t3, t)) {
                        break;
                    } else {
                        i6--;
                    }
                }
                i6 = i5;
                while (true) {
                    i6++;
                    if (i6 >= i3) {
                        break;
                    }
                    T t4 = this.a[i6];
                    if (this.f.compare(t4, t) == 0) {
                        if (this.f.areItemsTheSame(t4, t)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6 = -1;
                if (i4 == 1) {
                    return i6 == -1 ? i5 : i6;
                }
                return i6;
            }
        }
        if (i4 == 1) {
            return i2;
        }
        return -1;
    }

    public void clear() {
        i();
        int i2 = this.h;
        if (i2 != 0) {
            Arrays.fill(this.a, 0, i2, (Object) null);
            this.h = 0;
            this.f.onRemoved(0, i2);
        }
    }

    public final void d(int i2, boolean z) {
        T[] tArr = this.a;
        System.arraycopy(tArr, i2 + 1, tArr, i2, (this.h - i2) - 1);
        int i3 = this.h - 1;
        this.h = i3;
        this.a[i3] = null;
        if (z) {
            this.f.onRemoved(i2, 1);
        }
    }

    public final void e(T t) {
        T[] tArr = this.a;
        int i2 = this.e;
        tArr[i2] = t;
        int i3 = i2 + 1;
        this.e = i3;
        this.h++;
        this.f.onInserted(i3 - 1, 1);
    }

    public void endBatchedUpdates() {
        i();
        Callback callback = this.f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.f;
        BatchedCallback batchedCallback = this.g;
        if (callback2 == batchedCallback) {
            this.f = batchedCallback.a;
        }
    }

    public final void f(@NonNull T[] tArr) {
        boolean z = !(this.f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.c = 0;
        this.d = this.h;
        this.b = this.a;
        this.e = 0;
        int h2 = h(tArr);
        this.a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, h2));
        while (true) {
            int i2 = this.e;
            if (i2 >= h2 && this.c >= this.d) {
                break;
            }
            int i3 = this.c;
            int i4 = this.d;
            if (i3 >= i4) {
                int i5 = h2 - i2;
                System.arraycopy(tArr, i2, this.a, i2, i5);
                this.e += i5;
                this.h += i5;
                this.f.onInserted(i2, i5);
                break;
            } else if (i2 >= h2) {
                int i6 = i4 - i3;
                this.h -= i6;
                this.f.onRemoved(i2, i6);
                break;
            } else {
                T t = this.b[i3];
                T t2 = tArr[i2];
                int compare = this.f.compare(t, t2);
                if (compare < 0) {
                    g();
                } else if (compare > 0) {
                    e(t2);
                } else if (!this.f.areItemsTheSame(t, t2)) {
                    g();
                    e(t2);
                } else {
                    T[] tArr2 = this.a;
                    int i7 = this.e;
                    tArr2[i7] = t2;
                    this.c++;
                    this.e = i7 + 1;
                    if (!this.f.areContentsTheSame(t, t2)) {
                        Callback callback = this.f;
                        callback.onChanged(this.e - 1, 1, callback.getChangePayload(t, t2));
                    }
                }
            }
        }
        this.b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    public final void g() {
        this.h--;
        this.c++;
        this.f.onRemoved(this.e, 1);
    }

    public T get(int i2) throws IndexOutOfBoundsException {
        int i3;
        if (i2 >= this.h || i2 < 0) {
            StringBuilder M = a.M("Asked to get item at ", i2, " but size is ");
            M.append(this.h);
            throw new IndexOutOfBoundsException(M.toString());
        }
        T[] tArr = this.b;
        if (tArr == null || i2 < (i3 = this.e)) {
            return this.a[i2];
        }
        return tArr[(i2 - i3) + this.c];
    }

    public final int h(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f);
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T t = tArr[i4];
            if (this.f.compare(tArr[i3], t) == 0) {
                int i5 = i3;
                while (true) {
                    if (i5 >= i2) {
                        i5 = -1;
                        break;
                    } else if (this.f.areItemsTheSame(tArr[i5], t)) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 != -1) {
                    tArr[i5] = t;
                } else {
                    if (i2 != i4) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i4) {
                    tArr[i2] = t;
                }
                i3 = i2;
                i2++;
            }
        }
        return i2;
    }

    public final void i() {
        if (this.b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int indexOf(T t) {
        if (this.b == null) {
            return c(t, this.a, 0, this.h, 4);
        }
        int c2 = c(t, this.a, 0, this.e, 4);
        if (c2 != -1) {
            return c2;
        }
        int c3 = c(t, this.b, this.c, this.d, 4);
        if (c3 != -1) {
            return (c3 - this.c) + this.e;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i2) {
        i();
        T t = get(i2);
        d(i2, false);
        int a3 = a(t, false);
        if (i2 != a3) {
            this.f.onMoved(i2, a3);
        }
    }

    public boolean remove(T t) {
        i();
        int c2 = c(t, this.a, 0, this.h, 2);
        if (c2 == -1) {
            return false;
        }
        d(c2, true);
        return true;
    }

    public T removeItemAt(int i2) {
        i();
        T t = get(i2);
        d(i2, true);
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull T[] tArr, boolean z) {
        i();
        if (z) {
            f(tArr);
            return;
        }
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.i, tArr.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        f(objArr);
    }

    public int size() {
        return this.h;
    }

    public void updateItemAt(int i2, T t) {
        i();
        T t2 = get(i2);
        boolean z = t2 == t || !this.f.areContentsTheSame(t2, t);
        if (t2 == t || this.f.compare(t2, t) != 0) {
            if (z) {
                Callback callback = this.f;
                callback.onChanged(i2, 1, callback.getChangePayload(t2, t));
            }
            d(i2, false);
            int a3 = a(t, false);
            if (i2 != a3) {
                this.f.onMoved(i2, a3);
                return;
            }
            return;
        }
        this.a[i2] = t;
        if (z) {
            Callback callback2 = this.f;
            callback2.onChanged(i2, 1, callback2.getChangePayload(t2, t));
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i2) {
        this.i = cls;
        this.a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
        this.f = callback;
        this.h = 0;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }
}
