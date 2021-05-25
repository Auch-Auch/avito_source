package t6.w.f.a.m.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
public class b extends ByteString {
    public static final int[] g;
    public final int a;
    public final ByteString b;
    public final ByteString c;
    public final int d;
    public final int e;
    public int f = 0;

    /* renamed from: t6.w.f.a.m.e.b$b  reason: collision with other inner class name */
    public static class C0683b {
        public final Stack<ByteString> a = new Stack<>();

        public C0683b(a aVar) {
        }

        public final void a(ByteString byteString) {
            if (byteString.isBalanced()) {
                int size = byteString.size();
                int[] iArr = b.g;
                int binarySearch = Arrays.binarySearch(iArr, size);
                if (binarySearch < 0) {
                    binarySearch = (-(binarySearch + 1)) - 1;
                }
                int i = iArr[binarySearch + 1];
                if (this.a.isEmpty() || this.a.peek().size() >= i) {
                    this.a.push(byteString);
                    return;
                }
                int i2 = iArr[binarySearch];
                ByteString pop = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().size() < i2) {
                    pop = new b(this.a.pop(), pop);
                }
                b bVar = new b(pop, byteString);
                while (!this.a.isEmpty()) {
                    int i3 = bVar.a;
                    int[] iArr2 = b.g;
                    int binarySearch2 = Arrays.binarySearch(iArr2, i3);
                    if (binarySearch2 < 0) {
                        binarySearch2 = (-(binarySearch2 + 1)) - 1;
                    }
                    if (this.a.peek().size() >= iArr2[binarySearch2 + 1]) {
                        break;
                    }
                    bVar = new b(this.a.pop(), bVar);
                }
                this.a.push(bVar);
            } else if (byteString instanceof b) {
                b bVar2 = (b) byteString;
                a(bVar2.b);
                a(bVar2.c);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                throw new IllegalArgumentException(a2.b.a.a.a.t(new StringBuilder(valueOf.length() + 49), "Has a new type of ByteString been created? Found ", valueOf));
            }
        }
    }

    public static class c implements Iterator<a> {
        public final Stack<b> a = new Stack<>();
        public a b;

        public c(ByteString byteString, a aVar) {
            while (byteString instanceof b) {
                b bVar = (b) byteString;
                this.a.push(bVar);
                byteString = bVar.b;
            }
            this.b = (a) byteString;
        }

        /* renamed from: a */
        public a next() {
            a aVar;
            a aVar2 = this.b;
            if (aVar2 != null) {
                while (true) {
                    if (!this.a.isEmpty()) {
                        ByteString byteString = this.a.pop().c;
                        while (byteString instanceof b) {
                            b bVar = (b) byteString;
                            this.a.push(bVar);
                            byteString = bVar.b;
                        }
                        aVar = (a) byteString;
                        if (!aVar.isEmpty()) {
                            break;
                        }
                    } else {
                        aVar = null;
                        break;
                    }
                }
                this.b = aVar;
                return aVar2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class d implements ByteString.ByteIterator {
        public final c a;
        public ByteString.ByteIterator b;
        public int c;

        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(t6.w.f.a.m.e.b r2, t6.w.f.a.m.e.b.a r3) {
            /*
                r1 = this;
                r1.<init>()
                t6.w.f.a.m.e.b$c r3 = new t6.w.f.a.m.e.b$c
                r0 = 0
                r3.<init>(r2, r0)
                r1.a = r3
                t6.w.f.a.m.e.a r3 = r3.next()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator r3 = r3.mo987iterator()
                r1.b = r3
                int r2 = r2.a
                r1.c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t6.w.f.a.m.e.b.d.<init>(t6.w.f.a.m.e.b, t6.w.f.a.m.e.b$a):void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c > 0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte nextByte() {
            /*
                r1 = this;
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator r0 = r1.b
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L_0x0014
                t6.w.f.a.m.e.b$c r0 = r1.a
                t6.w.f.a.m.e.a r0 = r0.next()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator r0 = r0.mo987iterator()
                r1.b = r0
            L_0x0014:
                int r0 = r1.c
                int r0 = r0 + -1
                r1.c = r0
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator r0 = r1.b
                byte r0 = r0.nextByte()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: t6.w.f.a.m.e.b.d.nextByte():byte");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        g = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = g;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    public b(ByteString byteString, ByteString byteString2) {
        this.b = byteString;
        this.c = byteString2;
        int size = byteString.size();
        this.d = size;
        this.a = byteString2.size() + size;
        this.e = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public static a c(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new a(bArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void b(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.d;
        if (i3 <= i4) {
            this.b.b(outputStream, i, i2);
        } else if (i >= i4) {
            this.c.b(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.b.b(outputStream, i, i5);
            this.c.b(outputStream, 0, i2 - i5);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            this.b.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.c.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.b.copyToInternal(bArr, i, i2, i6);
            this.c.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        int peekCachedHashCode;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.a != byteString.size()) {
            return false;
        }
        if (this.a == 0) {
            return true;
        }
        if (this.f != 0 && (peekCachedHashCode = byteString.peekCachedHashCode()) != 0 && this.f != peekCachedHashCode) {
            return false;
        }
        c cVar = new c(this, null);
        a aVar = (a) cVar.next();
        c cVar2 = new c(byteString, null);
        a aVar2 = (a) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int length = aVar.a.length - i;
            int length2 = aVar2.a.length - i2;
            int min = Math.min(length, length2);
            if (!(i == 0 ? aVar.c(aVar2, i2, min) : aVar2.c(aVar, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.a;
            if (i3 < i4) {
                if (min == length) {
                    aVar = (a) cVar.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == length2) {
                    aVar2 = (a) cVar2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.f;
        if (i == 0) {
            int i2 = this.a;
            i = partialHash(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        return this.a >= g[this.e];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.b.partialIsValidUtf8(0, 0, this.d);
        ByteString byteString = this.c;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> mo987iterator() {
        return new d(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.partialHash(this.b.partialHash(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.partialIsValidUtf8(this.b.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator<Byte> mo987iterator() {
        return new d(this, null);
    }

    public class e extends InputStream {
        public c a;
        public a b;
        public int c;
        public int d;
        public int e;
        public int f;

        public e() {
            b();
        }

        public final void a() {
            int i;
            if (this.b != null && this.d == (i = this.c)) {
                this.e += i;
                this.d = 0;
                if (this.a.hasNext()) {
                    a a3 = this.a.next();
                    this.b = a3;
                    this.c = a3.a.length;
                    return;
                }
                this.b = null;
                this.c = 0;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return b.this.a - (this.e + this.d);
        }

        public final void b() {
            c cVar = new c(b.this, null);
            this.a = cVar;
            a a3 = cVar.next();
            this.b = a3;
            this.c = a3.a.length;
            this.d = 0;
            this.e = 0;
        }

        public final int c(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                a();
                if (this.b != null) {
                    int min = Math.min(this.c - this.d, i3);
                    if (bArr != null) {
                        this.b.copyTo(bArr, this.d, i, min);
                        i += min;
                    }
                    this.d += min;
                    i3 -= min;
                } else if (i3 == i2) {
                    return -1;
                }
            }
            return i2 - i3;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f = this.e + this.d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            Objects.requireNonNull(bArr);
            if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return c(bArr, i, i2);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            b();
            c(null, 0, this.f);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return (long) c(null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            a aVar = this.b;
            if (aVar == null) {
                return -1;
            }
            int i = this.d;
            this.d = i + 1;
            return aVar.a[i] & 255;
        }
    }
}
