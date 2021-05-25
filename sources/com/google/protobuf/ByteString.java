package com.google.protobuf;

import a2.j.i.j;
import a2.j.i.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new f(Internal.EMPTY_BYTE_ARRAY);
    public static final d b;
    public int a = 0;

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public class a implements ByteIterator {
        public int a = 0;
        public final int b;

        public a() {
            this.b = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Byte next() {
            try {
                ByteString byteString = ByteString.this;
                int i = this.a;
                this.a = i + 1;
                return Byte.valueOf(byteString.byteAt(i));
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                ByteString byteString = ByteString.this;
                int i = this.a;
                this.a = i + 1;
                return byteString.byteAt(i);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b implements d {
        public b(a aVar) {
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class c extends f {
        private static final long serialVersionUID = 1;
        public final int d;
        public final int e;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            ByteString.c(i, i + i2, bArr.length);
            this.d = i;
            this.e = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.f, com.google.protobuf.ByteString
        public byte byteAt(int i) {
            ByteString.b(i, this.e);
            return this.c[this.d + i];
        }

        @Override // com.google.protobuf.ByteString.f, com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.c, this.d + i, bArr, i2, i3);
        }

        @Override // com.google.protobuf.ByteString.f
        public int f() {
            return this.d;
        }

        @Override // com.google.protobuf.ByteString.f, com.google.protobuf.ByteString
        public int size() {
            return this.e;
        }

        public Object writeReplace() {
            return new f(toByteArray());
        }
    }

    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static abstract class e extends ByteString {
        public abstract boolean e(ByteString byteString, int i, int i2);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return ByteString.super.iterator();
        }
    }

    public static class f extends e {
        private static final long serialVersionUID = 1;
        public final byte[] c;

        public f(byte[] bArr) {
            this.c = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.c, f(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i) {
            return this.c[i];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.c, f(), size());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.c, i, bArr, i2, i3);
        }

        @Override // com.google.protobuf.ByteString
        public final void d(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.c, f(), size());
        }

        @Override // com.google.protobuf.ByteString.e
        public final boolean e(ByteString byteString, int i, int i2) {
            if (i2 <= byteString.size()) {
                int i3 = i + i2;
                if (i3 > byteString.size()) {
                    StringBuilder N = a2.b.a.a.a.N("Ran off end of other: ", i, ", ", i2, ", ");
                    N.append(byteString.size());
                    throw new IllegalArgumentException(N.toString());
                } else if (!(byteString instanceof f)) {
                    return byteString.substring(i, i3).equals(substring(0, i2));
                } else {
                    f fVar = (f) byteString;
                    byte[] bArr = this.c;
                    byte[] bArr2 = fVar.c;
                    int f = f() + i2;
                    int f2 = f();
                    int f3 = fVar.f() + i;
                    while (f2 < f) {
                        if (bArr[f2] != bArr2[f3]) {
                            return false;
                        }
                        f2++;
                        f3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
        }

        @Override // com.google.protobuf.ByteString, java.lang.Object
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof f)) {
                return obj.equals(this);
            }
            f fVar = (f) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = fVar.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return e(fVar, 0, size());
            }
            return false;
        }

        public int f() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int f = f();
            if (n.a.e(0, this.c, f, size() + f) == 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            byte[] bArr = this.c;
            int f = f();
            int size = size();
            CodedInputStream codedInputStream = new CodedInputStream(bArr, f, size, true);
            try {
                codedInputStream.pushLimit(size);
                return codedInputStream;
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.c, f(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int i, int i2, int i3) {
            return Internal.a(i, this.c, f() + i2, i3);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int i, int i2, int i3) {
            int f = f() + i2;
            return n.a.e(i, this.c, f, i3 + f);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.c.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i, int i2) {
            int c2 = ByteString.c(i, i2, size());
            if (c2 == 0) {
                return ByteString.EMPTY;
            }
            return new c(this.c, f() + i, c2);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.c, f(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }
    }

    public static final class g implements d {
        public g(a aVar) {
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        b = z ? new g(null) : new b(null);
    }

    public static ByteString a(Iterator<ByteString> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return a(it, i2).concat(a(it, i - i2));
    }

    public static void b(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a2.b.a.a.a.M2("Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(a2.b.a.a.a.R2("Index > length: ", i, ", ", i2));
    }

    public static int c(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.Q2("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.R2("Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.R2("End index: ", i2, " >= ", i3));
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        return new f(b.a(bArr, i, i2));
    }

    public static ByteString copyFromUtf8(String str) {
        return new f(str.getBytes(Internal.a));
    }

    public static Output newOutput(int i) {
        return new Output(i);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i);

    public final ByteString concat(ByteString byteString) {
        j jVar;
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            int[] iArr = j.h;
            if (byteString.size() == 0) {
                return this;
            }
            if (size() == 0) {
                return byteString;
            }
            int size = byteString.size() + size();
            if (size < 128) {
                return j.e(this, byteString);
            }
            if (this instanceof j) {
                j jVar2 = (j) this;
                if (byteString.size() + jVar2.e.size() < 128) {
                    jVar = new j(jVar2.d, j.e(jVar2.e, byteString));
                    return jVar;
                } else if (jVar2.d.getTreeDepth() > jVar2.e.getTreeDepth() && jVar2.g > byteString.getTreeDepth()) {
                    return new j(jVar2.d, new j(jVar2.e, byteString));
                }
            }
            if (size >= j.h[Math.max(getTreeDepth(), byteString.getTreeDepth()) + 1]) {
                jVar = new j(this, byteString);
                return jVar;
            }
            j.b bVar = new j.b(null);
            bVar.a(this);
            bVar.a(byteString);
            ByteString pop = bVar.a.pop();
            while (!bVar.a.isEmpty()) {
                pop = new j(bVar.a.pop(), pop);
            }
            return pop;
        }
        StringBuilder L = a2.b.a.a.a.L("ByteString would be too long: ");
        L.append(size());
        L.append("+");
        L.append(byteString.size());
        throw new IllegalArgumentException(L.toString());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i) {
        copyTo(bArr, 0, i, size());
    }

    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public abstract void d(ByteOutput byteOutput) throws IOException;

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.a;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.a = i;
        }
        return i;
    }

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i, int i2, int i3);

    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    public final int peekCachedHashCode() {
        return this.a;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i) {
        return substring(i, size());
    }

    public abstract ByteString substring(int i, int i2);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e2);
            throw unsupportedEncodingException;
        }
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.a);
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i) throws IOException {
        return readFrom(inputStream, i, i);
    }

    public final void copyTo(byte[] bArr, int i, int i2, int i3) {
        c(i, i + i3, size());
        c(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            copyToInternal(bArr, i, i2, i3);
        }
    }

    /* Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // java.lang.Iterable
    public final Iterator<Byte> iterator() {
        return new a();
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new f(bArr);
    }

    public static ByteString readFrom(InputStream inputStream, int i, int i2) throws IOException {
        ByteString byteString;
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] bArr = new byte[i];
            int i3 = 0;
            while (i3 < i) {
                int read = inputStream.read(bArr, i3, i - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            if (i3 == 0) {
                byteString = null;
            } else {
                byteString = copyFrom(bArr, 0, i3);
            }
            if (byteString == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(byteString);
            i = Math.min(i * 2, i2);
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
            this.b.add(new f(this.d));
            int length = this.c + this.d.length;
            this.c = length;
            this.d = new byte[Math.max(this.a, Math.max(i, length >>> 1))];
            this.e = 0;
        }

        public final void b() {
            int i = this.e;
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.b.add(new f(this.d));
                this.d = f;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.b.add(new f(bArr2));
            }
            this.c += this.e;
            this.e = 0;
        }

        public synchronized void reset() {
            this.b.clear();
            this.c = 0;
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

        public void writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.b;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.d;
                i = this.e;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            outputStream.write(bArr2);
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

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new f(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new f(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        if (i == 0) {
            return EMPTY;
        }
        return a(iterable.iterator(), i);
    }
}
