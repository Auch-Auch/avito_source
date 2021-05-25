package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import t6.w.f.a.m.e.a;
import t6.w.f.a.m.e.b;
public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString EMPTY = new a(new byte[0]);

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static ByteString a(Iterator<ByteString> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return a(it, i2).concat(a(it, i - i2));
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public abstract void b(OutputStream outputStream, int i, int i2) throws IOException;

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            int[] iArr = b.g;
            b bVar = this instanceof b ? (b) this : null;
            if (byteString.size() == 0) {
                return this;
            }
            if (size() == 0) {
                return byteString;
            }
            int size3 = byteString.size() + size();
            if (size3 < 128) {
                return b.c(this, byteString);
            }
            if (bVar != null) {
                if (byteString.size() + bVar.c.size() < 128) {
                    return new b(bVar.b, b.c(bVar.c, byteString));
                }
            }
            if (bVar == null || bVar.b.getTreeDepth() <= bVar.c.getTreeDepth() || bVar.e <= byteString.getTreeDepth()) {
                if (size3 >= b.g[Math.max(getTreeDepth(), byteString.getTreeDepth()) + 1]) {
                    return new b(this, byteString);
                }
                b.C0683b bVar2 = new b.C0683b(null);
                bVar2.a(this);
                bVar2.a(byteString);
                ByteString pop = bVar2.a.pop();
                while (!bVar2.a.isEmpty()) {
                    pop = new b(bVar2.a.pop(), pop);
                }
                return pop;
            }
            return new b(bVar.b, new b(bVar.c, byteString));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.p2(53, "ByteString would be too long: ", size, "+", size2));
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.m2(30, "Source offset < 0: ", i));
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.m2(30, "Target offset < 0: ", i2));
        } else if (i3 >= 0) {
            int i4 = i + i3;
            if (i4 <= size()) {
                int i5 = i2 + i3;
                if (i5 > bArr.length) {
                    throw new IndexOutOfBoundsException(a2.b.a.a.a.m2(34, "Target end offset < 0: ", i5));
                } else if (i3 > 0) {
                    copyToInternal(bArr, i, i2, i3);
                }
            } else {
                throw new IndexOutOfBoundsException(a2.b.a.a.a.m2(34, "Source end offset < 0: ", i4));
            }
        } else {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.m2(23, "Length < 0: ", i3));
        }
    }

    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public abstract int getTreeDepth();

    public abstract boolean isBalanced();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator' to match base method */
    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public abstract Iterator<Byte> mo987iterator();

    public abstract CodedInputStream newCodedInput();

    public abstract int partialHash(int i, int i2, int i3);

    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static final class Output extends OutputStream {
        public static final byte[] f = new byte[0];
        public final int a;
        public final ArrayList<ByteString> b;
        public int c;
        public byte[] d;
        public int e;

        public Output(int i) {
            if (i >= 0) {
                this.a = i;
                this.b = new ArrayList<>();
                this.d = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final void a(int i) {
            this.b.add(new a(this.d));
            int length = this.c + this.d.length;
            this.c = length;
            this.d = new byte[Math.max(this.a, Math.max(i, length >>> 1))];
            this.e = 0;
        }

        public final void b() {
            int i = this.e;
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.b.add(new a(this.d));
                this.d = f;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.b.add(new a(bArr2));
            }
            this.c += this.e;
            this.e = 0;
        }

        public synchronized int size() {
            return this.c + this.e;
        }

        public synchronized ByteString toByteString() {
            b();
            return ByteString.copyFrom(this.b);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.e == this.d.length) {
                a(1);
            }
            byte[] bArr = this.d;
            int i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i3 = this.e;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.e += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                a(i4);
                System.arraycopy(bArr, i + length2, this.d, 0, i4);
                this.e = i4;
            }
        }
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0020 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.reflect.jvm.internal.impl.protobuf.ByteString copyFrom(java.lang.Iterable<kotlin.reflect.jvm.internal.impl.protobuf.ByteString> r2) {
        /*
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 != 0) goto L_0x001d
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x000d:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r2.next()
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r1 = (kotlin.reflect.jvm.internal.impl.protobuf.ByteString) r1
            r0.add(r1)
            goto L_0x000d
        L_0x001d:
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
        L_0x0020:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0029
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r2 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.EMPTY
            goto L_0x0035
        L_0x0029:
            java.util.Iterator r2 = r0.iterator()
            int r0 = r0.size()
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r2 = a(r2, r0)
        L_0x0035:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.copyFrom(java.lang.Iterable):kotlin.reflect.jvm.internal.impl.protobuf.ByteString");
    }
}
