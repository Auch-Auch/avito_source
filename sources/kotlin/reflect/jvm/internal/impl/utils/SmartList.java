package kotlin.reflect.jvm.internal.impl.utils;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    public int a;
    public Object b;

    public static class b<T> implements Iterator<T> {
        public static final b a = new b();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class c extends d<E> {
        public final int b;

        public c() {
            super(null);
            this.b = ((AbstractList) SmartList.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.d
        public void a() {
            if (((AbstractList) SmartList.this).modCount != this.b) {
                StringBuilder L = a2.b.a.a.a.L("ModCount: ");
                L.append(((AbstractList) SmartList.this).modCount);
                L.append("; expected: ");
                L.append(this.b);
                throw new ConcurrentModificationException(L.toString());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            SmartList.this.clear();
        }
    }

    public static abstract class d<T> implements Iterator<T> {
        public boolean a;

        public d(a aVar) {
        }

        public abstract void a();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.a) {
                this.a = true;
                a();
                return (T) SmartList.this.b;
            }
            throw new NoSuchElementException();
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = AuthSource.SEND_ABUSE;
                break;
            default:
                objArr[0] = MessengerShareContentUtility.ELEMENTS;
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        int i = this.a;
        if (i == 0) {
            this.b = e;
        } else if (i == 1) {
            this.b = new Object[]{this.b, e};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i >= length) {
                int y2 = a2.b.a.a.a.y2(length, 3, 2, 1);
                int i2 = i + 1;
                if (y2 < i2) {
                    y2 = i2;
                }
                Object[] objArr2 = new Object[y2];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.a] = e;
        }
        this.a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.b = null;
        this.a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.a)) {
            return i2 == 1 ? (E) this.b : (E) ((Object[]) this.b)[i];
        }
        StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
        M.append(this.a);
        throw new IndexOutOfBoundsException(M.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        int i = this.a;
        if (i == 0) {
            return b.a;
        }
        if (i == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it != null) {
            return it;
        }
        a(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.a)) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
            M.append(this.a);
            throw new IndexOutOfBoundsException(M.toString());
        }
        if (i2 == 1) {
            e = (E) this.b;
            this.b = null;
        } else {
            Object[] objArr = (Object[]) this.b;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.a - 1] = null;
            }
            e = (E) obj;
        }
        this.a--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
            M.append(this.a);
            throw new IndexOutOfBoundsException(M.toString());
        } else if (i2 == 1) {
            E e2 = (E) this.b;
            this.b = e;
            return e2;
        } else {
            Object[] objArr = (Object[]) this.b;
            E e3 = (E) objArr[i];
            objArr[i] = e;
            return e3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr != 0) {
            int length = tArr.length;
            int i = this.a;
            if (i == 1) {
                if (length != 0) {
                    tArr[0] = this.b;
                } else {
                    T[] tArr2 = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, 1));
                    tArr2[0] = this.b;
                    return tArr2;
                }
            } else if (length < i) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.b, i, tArr.getClass());
                if (tArr3 != null) {
                    return tArr3;
                }
                a(6);
                throw null;
            } else if (i != 0) {
                System.arraycopy(this.b, 0, tArr, 0, i);
            }
            int i2 = this.a;
            if (length > i2) {
                tArr[i2] = 0;
            }
            return tArr;
        }
        a(4);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        int i2;
        if (i < 0 || i > (i2 = this.a)) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
            M.append(this.a);
            throw new IndexOutOfBoundsException(M.toString());
        }
        if (i2 == 0) {
            this.b = e;
        } else if (i2 == 1 && i == 0) {
            this.b = new Object[]{e, this.b};
        } else {
            Object[] objArr = new Object[(i2 + 1)];
            if (i2 == 1) {
                objArr[0] = this.b;
            } else {
                Object[] objArr2 = (Object[]) this.b;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.a - i);
            }
            objArr[i] = e;
            this.b = objArr;
        }
        this.a++;
        ((AbstractList) this).modCount++;
    }
}
