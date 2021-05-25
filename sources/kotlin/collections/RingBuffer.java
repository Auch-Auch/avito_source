package kotlin.collections;

import a2.b.a.a.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    public final int a;
    public int b;
    public int c;
    public final Object[] d;

    public RingBuffer(@NotNull Object[] objArr, int i) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.d = objArr;
        boolean z = true;
        if (i >= 0) {
            if (i > objArr.length ? false : z) {
                this.a = objArr.length;
                this.c = i;
                return;
            }
            StringBuilder M = a.M("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            M.append(objArr.length);
            throw new IllegalArgumentException(M.toString().toString());
        }
        throw new IllegalArgumentException(a.M2("ring buffer filled size should not be negative but it is ", i).toString());
    }

    public final void a(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > size()) {
                z = false;
            }
            if (!z) {
                StringBuilder M = a.M("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
                M.append(size());
                throw new IllegalArgumentException(M.toString().toString());
            } else if (i > 0) {
                int i2 = this.b;
                int i3 = this.a;
                int i4 = (i2 + i) % i3;
                if (i2 > i4) {
                    ArraysKt___ArraysJvmKt.fill(this.d, (Object) null, i2, i3);
                    ArraysKt___ArraysJvmKt.fill(this.d, (Object) null, 0, i4);
                } else {
                    ArraysKt___ArraysJvmKt.fill(this.d, (Object) null, i2, i4);
                }
                this.b = i4;
                this.c = size() - i;
            }
        } else {
            throw new IllegalArgumentException(a.M2("n shouldn't be negative but it is ", i).toString());
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.d[(this.b + i) % this.a];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.c;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            public int c;
            public int d;
            public final /* synthetic */ RingBuffer e;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.e = r2;
                this.c = r2.size();
                this.d = r2.b;
            }

            @Override // kotlin.collections.AbstractIterator
            public void computeNext() {
                if (this.c == 0) {
                    done();
                    return;
                }
                setNext(this.e.d[this.d]);
                this.d = (this.d + 1) % this.e.a;
                this.c--;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = this.b;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size && i < this.a) {
            tArr[i3] = this.d[i];
            i3++;
            i++;
        }
        while (i3 < size) {
            tArr[i3] = this.d[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.RingBuffer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
