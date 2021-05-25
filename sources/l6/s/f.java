package l6.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
public final class f<T> extends AbstractList<T> {
    public static final List i = new ArrayList();
    public int a;
    public final ArrayList<List<T>> b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public interface a {
    }

    public f() {
        this.a = 0;
        this.b = new ArrayList<>();
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 1;
        this.g = 0;
        this.h = 0;
    }

    public final void a(int i2, int i3) {
        int i4;
        int i5 = this.a / this.f;
        if (i2 < i5) {
            int i6 = 0;
            while (true) {
                i4 = i5 - i2;
                if (i6 >= i4) {
                    break;
                }
                this.b.add(0, null);
                i6++;
            }
            int i7 = i4 * this.f;
            this.e += i7;
            this.a -= i7;
        } else {
            i2 = i5;
        }
        if (i3 >= this.b.size() + i2) {
            int min = Math.min(this.c, ((i3 + 1) - (this.b.size() + i2)) * this.f);
            for (int size = this.b.size(); size <= i3 - i2; size++) {
                ArrayList<List<T>> arrayList = this.b;
                arrayList.add(arrayList.size(), null);
            }
            this.e += min;
            this.c -= min;
        }
    }

    public int b() {
        int i2 = this.a;
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<T> list = this.b.get(i3);
            if (!(list == null || list == i)) {
                break;
            }
            i2 += this.f;
        }
        return i2;
    }

    public int c() {
        int i2 = this.c;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            List<T> list = this.b.get(size);
            if (!(list == null || list == i)) {
                break;
            }
            i2 += this.f;
        }
        return i2;
    }

    public T d() {
        ArrayList<List<T>> arrayList = this.b;
        List<T> list = arrayList.get(arrayList.size() - 1);
        return list.get(list.size() - 1);
    }

    public int e() {
        return this.b.size();
    }

    public boolean f(int i2, int i3) {
        List<T> list;
        int i4 = this.a / i2;
        if (i3 < i4 || i3 >= this.b.size() + i4 || (list = this.b.get(i3 - i4)) == null || list == i) {
            return false;
        }
        return true;
    }

    public final void g(int i2, List<T> list, int i3, int i4) {
        this.a = i2;
        this.b.clear();
        this.b.add(list);
        this.c = i3;
        this.d = i4;
        this.e = list.size();
        this.f = list.size();
        this.g = 0;
        this.h = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i2, ", Size: ");
            M.append(size());
            throw new IndexOutOfBoundsException(M.toString());
        }
        int i3 = i2 - this.a;
        if (i3 >= 0 && i3 < this.e) {
            int i4 = this.f;
            int i5 = 0;
            if (i4 > 0) {
                i5 = i3 / i4;
                i3 %= i4;
            } else {
                int size = this.b.size();
                while (i5 < size) {
                    int size2 = this.b.get(i5).size();
                    if (size2 > i3) {
                        break;
                    }
                    i3 -= size2;
                    i5++;
                }
            }
            List<T> list = this.b.get(i5);
            if (!(list == null || list.size() == 0)) {
                return list.get(i3);
            }
        }
        return null;
    }

    public void h(int i2, @NonNull List<T> list, @Nullable a aVar) {
        int size = list.size();
        if (size != this.f) {
            int size2 = size();
            int i3 = this.f;
            boolean z = false;
            boolean z2 = i2 == size2 - (size2 % i3) && size < i3;
            if (this.c == 0 && this.b.size() == 1 && size > this.f) {
                z = true;
            }
            if (!z && !z2) {
                throw new IllegalArgumentException("page introduces incorrect tiling");
            } else if (z) {
                this.f = size;
            }
        }
        int i4 = i2 / this.f;
        a(i4, i4);
        int i5 = i4 - (this.a / this.f);
        List<T> list2 = this.b.get(i5);
        if (list2 == null || list2 == i) {
            this.b.set(i5, list);
            if (aVar != null) {
                ((j) aVar).f(i2, list.size());
                return;
            }
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Invalid position ", i2, ": data already loaded"));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a + this.e + this.c;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("leading ");
        L.append(this.a);
        L.append(", storage ");
        L.append(this.e);
        L.append(", trailing ");
        L.append(this.c);
        StringBuilder sb = new StringBuilder(L.toString());
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            sb.append(" ");
            sb.append(this.b.get(i2));
        }
        return sb.toString();
    }

    public f(f<T> fVar) {
        this.a = fVar.a;
        this.b = new ArrayList<>(fVar.b);
        this.c = fVar.c;
        this.d = fVar.d;
        this.e = fVar.e;
        this.f = fVar.f;
        this.g = fVar.g;
        this.h = fVar.h;
    }
}
