package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Bytes {
    public static List<Byte> asList(byte... bArr) {
        if (bArr.length == 0) {
            return Collections.emptyList();
        }
        return new a(bArr);
    }

    public static byte[] concat(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean contains(byte[] bArr, byte b) {
        for (byte b2 : bArr) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    public static byte[] ensureCapacity(byte[] bArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return bArr.length < i ? Arrays.copyOf(bArr, i + i2) : bArr;
    }

    public static int hashCode(byte b) {
        return b;
    }

    public static int indexOf(byte[] bArr, byte b) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] == b) {
                return length;
            }
        }
        return -1;
    }

    public static void reverse(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        reverse(bArr, 0, bArr.length);
    }

    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            a aVar = (a) collection;
            return Arrays.copyOfRange(aVar.a, aVar.b, aVar.c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = ((Number) Preconditions.checkNotNull(array[i])).byteValue();
        }
        return bArr;
    }

    public static int indexOf(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr, "array");
        Preconditions.checkNotNull(bArr2, "target");
        if (bArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (bArr.length - bArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i + i2] != bArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            byte b = bArr[i];
            bArr[i] = bArr[i3];
            bArr[i3] = b;
            i++;
        }
    }

    @GwtCompatible
    public static class a extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] a;
        public final int b;
        public final int c;

        public a(byte[] bArr) {
            int length = bArr.length;
            this.a = bArr;
            this.b = 0;
            this.c = length;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Byte) {
                byte[] bArr = this.a;
                byte byteValue = ((Byte) obj).byteValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (bArr[i] == byteValue) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.b + i] != aVar.a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Byte.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 1;
            for (int i2 = this.b; i2 < this.c; i2++) {
                i = (i * 31) + Bytes.hashCode(this.a[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Byte) {
                byte[] bArr = this.a;
                byte byteValue = ((Byte) obj).byteValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (bArr[i] == byteValue) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    return i - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                byte[] bArr = this.a;
                byte byteValue = ((Byte) obj).byteValue();
                int i = this.b;
                int i2 = this.c - 1;
                while (true) {
                    if (i2 < i) {
                        i2 = -1;
                        break;
                    } else if (bArr[i2] == byteValue) {
                        break;
                    } else {
                        i2--;
                    }
                }
                if (i2 >= 0) {
                    return i2 - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            Preconditions.checkElementIndex(i, size());
            byte[] bArr = this.a;
            int i2 = this.b + i;
            byte b2 = bArr[i2];
            bArr[i2] = ((Byte) Preconditions.checkNotNull((Byte) obj)).byteValue();
            return Byte.valueOf(b2);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            byte[] bArr = this.a;
            int i3 = this.b;
            return new a(bArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.a[this.b]);
            int i = this.b;
            while (true) {
                i++;
                if (i < this.c) {
                    sb.append(", ");
                    sb.append((int) this.a[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public a(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }
    }
}
