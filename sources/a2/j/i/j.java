package a2.j.i;

import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
public final class j extends ByteString {
    public static final int[] h;
    private static final long serialVersionUID = 1;
    public final int c;
    public final ByteString d;
    public final ByteString e;
    public final int f;
    public final int g;

    public static class b {
        public final Stack<ByteString> a = new Stack<>();

        public b(a aVar) {
        }

        public final void a(ByteString byteString) {
            if (byteString.isBalanced()) {
                int size = byteString.size();
                int[] iArr = j.h;
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
                    pop = new j(this.a.pop(), pop);
                }
                j jVar = new j(pop, byteString);
                while (!this.a.isEmpty()) {
                    int i3 = jVar.c;
                    int[] iArr2 = j.h;
                    int binarySearch2 = Arrays.binarySearch(iArr2, i3);
                    if (binarySearch2 < 0) {
                        binarySearch2 = (-(binarySearch2 + 1)) - 1;
                    }
                    if (this.a.peek().size() >= iArr2[binarySearch2 + 1]) {
                        break;
                    }
                    jVar = new j(this.a.pop(), jVar);
                }
                this.a.push(jVar);
            } else if (byteString instanceof j) {
                j jVar2 = (j) byteString;
                a(jVar2.d);
                a(jVar2.e);
            } else {
                StringBuilder L = a2.b.a.a.a.L("Has a new type of ByteString been created? Found ");
                L.append(byteString.getClass());
                throw new IllegalArgumentException(L.toString());
            }
        }
    }

    public static class c implements Iterator<ByteString.e> {
        public final Stack<j> a = new Stack<>();
        public ByteString.e b;

        public c(ByteString byteString, a aVar) {
            while (byteString instanceof j) {
                j jVar = (j) byteString;
                this.a.push(jVar);
                byteString = jVar.d;
            }
            this.b = (ByteString.e) byteString;
        }

        /* renamed from: a */
        public ByteString.e next() {
            ByteString.e eVar;
            ByteString.e eVar2 = this.b;
            if (eVar2 != null) {
                while (true) {
                    if (!this.a.isEmpty()) {
                        ByteString byteString = this.a.pop().e;
                        while (byteString instanceof j) {
                            j jVar = (j) byteString;
                            this.a.push(jVar);
                            byteString = jVar.d;
                        }
                        eVar = (ByteString.e) byteString;
                        if (!eVar.isEmpty()) {
                            break;
                        }
                    } else {
                        eVar = null;
                        break;
                    }
                }
                this.b = eVar;
                return eVar2;
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
        h = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = h;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    public j(ByteString byteString, ByteString byteString2) {
        this.d = byteString;
        this.e = byteString2;
        int size = byteString.size();
        this.f = size;
        this.c = byteString2.size() + size;
        this.g = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public static ByteString e(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new ByteString.f(bArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ByteString.e eVar;
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        ByteString byteString = this;
        while (byteString instanceof j) {
            j jVar = (j) byteString;
            stack.push(jVar);
            byteString = jVar.d;
        }
        ByteString.e eVar2 = (ByteString.e) byteString;
        while (true) {
            if (!(eVar2 != null)) {
                return arrayList;
            }
            if (eVar2 != null) {
                while (true) {
                    if (!stack.isEmpty()) {
                        ByteString byteString2 = ((j) stack.pop()).e;
                        while (byteString2 instanceof j) {
                            j jVar2 = (j) byteString2;
                            stack.push(jVar2);
                            byteString2 = jVar2.d;
                        }
                        eVar = (ByteString.e) byteString2;
                        if (!eVar.isEmpty()) {
                            break;
                        }
                    } else {
                        eVar = null;
                        break;
                    }
                }
                arrayList.add(eVar2.asReadOnlyByteBuffer());
                eVar2 = eVar;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        ByteString.b(i, this.c);
        int i2 = this.f;
        if (i < i2) {
            return this.d.byteAt(i);
        }
        return this.e.byteAt(i - i2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.d.copyTo(byteBuffer);
        this.e.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f;
        if (i4 <= i5) {
            this.d.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.e.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.d.copyToInternal(bArr, i, i2, i6);
            this.e.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.protobuf.ByteString
    public void d(ByteOutput byteOutput) throws IOException {
        this.d.d(byteOutput);
        this.e.d(byteOutput);
    }

    @Override // com.google.protobuf.ByteString, java.lang.Object
    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.c != byteString.size()) {
            return false;
        }
        if (this.c == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode != 0 && peekCachedHashCode2 != 0 && peekCachedHashCode != peekCachedHashCode2) {
            return false;
        }
        c cVar = new c(this, null);
        ByteString.e eVar = (ByteString.e) cVar.next();
        c cVar2 = new c(byteString, null);
        ByteString.e eVar2 = (ByteString.e) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = eVar.size() - i;
            int size2 = eVar2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = eVar.e(eVar2, i2, min);
            } else {
                z = eVar2.e(eVar, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.c;
            if (i3 < i4) {
                if (min == size) {
                    eVar = (ByteString.e) cVar.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    eVar2 = (ByteString.e) cVar2.next();
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

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.g;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        return this.c >= h[this.g];
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.d.partialIsValidUtf8(0, 0, this.f);
        ByteString byteString = this.e;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new d());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new d();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f;
        if (i4 <= i5) {
            return this.d.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.e.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.e.partialHash(this.d.partialHash(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f;
        if (i4 <= i5) {
            return this.d.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.e.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.e.partialIsValidUtf8(this.d.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        int c2 = ByteString.c(i, i2, this.c);
        if (c2 == 0) {
            return ByteString.EMPTY;
        }
        if (c2 == this.c) {
            return this;
        }
        int i3 = this.f;
        if (i2 <= i3) {
            return this.d.substring(i, i2);
        }
        if (i >= i3) {
            return this.e.substring(i - i3, i2 - i3);
        }
        return new j(this.d.substring(i), this.e.substring(0, i2 - this.f));
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return new ByteString.f(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.d.writeTo(outputStream);
        this.e.writeTo(outputStream);
    }

    public class d extends InputStream {
        public c a;
        public ByteString.e b;
        public int c;
        public int d;
        public int e;
        public int f;

        public d() {
            b();
        }

        public final void a() {
            int i;
            if (this.b != null && this.d == (i = this.c)) {
                this.e += i;
                this.d = 0;
                if (this.a.hasNext()) {
                    ByteString.e a3 = this.a.next();
                    this.b = a3;
                    this.c = a3.size();
                    return;
                }
                this.b = null;
                this.c = 0;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return j.this.c - (this.e + this.d);
        }

        public final void b() {
            c cVar = new c(j.this, null);
            this.a = cVar;
            ByteString.e a3 = cVar.next();
            this.b = a3;
            this.c = a3.size();
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
            ByteString.e eVar = this.b;
            if (eVar == null) {
                return -1;
            }
            int i = this.d;
            this.d = i + 1;
            return eVar.byteAt(i) & 255;
        }
    }
}
