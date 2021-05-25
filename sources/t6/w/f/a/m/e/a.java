package t6.w.f.a.m.e;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
public class a extends ByteString {
    public final byte[] a;
    public int b = 0;

    public class b implements ByteString.ByteIterator {
        public int a = 0;
        public final int b;

        public b(C0682a aVar) {
            this.b = a.this.a.length;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = a.this.a;
                int i = this.a;
                this.a = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public a(byte[] bArr) {
        this.a = bArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void b(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.a, d() + i, i2);
    }

    public boolean c(a aVar, int i, int i2) {
        if (i2 > aVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i + i2 <= aVar.size()) {
            byte[] bArr = this.a;
            byte[] bArr2 = aVar.a;
            int d = d() + i2;
            int d2 = d();
            int d3 = aVar.d() + i;
            while (d2 < d) {
                if (bArr[d2] != bArr2[d3]) {
                    return false;
                }
                d2++;
                d3++;
            }
            return true;
        } else {
            int size2 = aVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    public int d() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof a) {
            return c((a) obj, 0, size());
        }
        if (obj instanceof b) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(a2.b.a.a.a.t(new StringBuilder(valueOf.length() + 49), "Has a new type of ByteString been created? Found ", valueOf));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.b;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.b = i;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int d = d();
        return AppCompatDelegateImpl.i.Z0(this.a, d, size() + d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        CodedInputStream codedInputStream = new CodedInputStream(this);
        try {
            codedInputStream.pushLimit(size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        byte[] bArr = this.a;
        int d = d() + i2;
        for (int i4 = d; i4 < d + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r9[r0] > -65) goto L_0x0024;
     */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int partialIsValidUtf8(int r8, int r9, int r10) {
        /*
            r7 = this;
            int r0 = r7.d()
            int r0 = r0 + r9
            byte[] r9 = r7.a
            int r10 = r10 + r0
            if (r8 == 0) goto L_0x008d
            if (r0 < r10) goto L_0x000e
            goto L_0x0091
        L_0x000e:
            byte r1 = (byte) r8
            r2 = -32
            r3 = -1
            r4 = -65
            if (r1 >= r2) goto L_0x0027
            r8 = -62
            if (r1 < r8) goto L_0x0024
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x0021:
            r0 = r8
            goto L_0x008d
        L_0x0024:
            r8 = -1
            goto L_0x0091
        L_0x0027:
            r5 = -16
            if (r1 >= r5) goto L_0x0054
            int r8 = r8 >> 8
            int r8 = ~r8
            byte r8 = (byte) r8
            if (r8 != 0) goto L_0x003f
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r8 < r10) goto L_0x003c
            int r8 = androidx.appcompat.app.AppCompatDelegateImpl.i.P0(r1, r0)
            goto L_0x0091
        L_0x003c:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x003f:
            if (r8 > r4) goto L_0x0024
            r5 = -96
            if (r1 != r2) goto L_0x0047
            if (r8 < r5) goto L_0x0024
        L_0x0047:
            r2 = -19
            if (r1 != r2) goto L_0x004d
            if (r8 >= r5) goto L_0x0024
        L_0x004d:
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x0054:
            int r2 = r8 >> 8
            int r2 = ~r2
            byte r2 = (byte) r2
            r5 = 0
            if (r2 != 0) goto L_0x0068
            int r8 = r0 + 1
            byte r2 = r9[r0]
            if (r8 < r10) goto L_0x0066
            int r8 = androidx.appcompat.app.AppCompatDelegateImpl.i.P0(r1, r2)
            goto L_0x0091
        L_0x0066:
            r0 = r8
            goto L_0x006b
        L_0x0068:
            int r8 = r8 >> 16
            byte r5 = (byte) r8
        L_0x006b:
            if (r5 != 0) goto L_0x0079
            int r8 = r0 + 1
            byte r5 = r9[r0]
            if (r8 < r10) goto L_0x0078
            int r8 = androidx.appcompat.app.AppCompatDelegateImpl.i.Q0(r1, r2, r5)
            goto L_0x0091
        L_0x0078:
            r0 = r8
        L_0x0079:
            if (r2 > r4) goto L_0x0024
            int r8 = r1 << 28
            int r2 = r2 + 112
            int r2 = r2 + r8
            int r8 = r2 >> 30
            if (r8 != 0) goto L_0x0024
            if (r5 > r4) goto L_0x0024
            int r8 = r0 + 1
            byte r0 = r9[r0]
            if (r0 <= r4) goto L_0x0021
            goto L_0x0024
        L_0x008d:
            int r8 = androidx.appcompat.app.AppCompatDelegateImpl.i.w1(r9, r0, r10)
        L_0x0091:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.w.f.a.m.e.a.partialIsValidUtf8(int, int, int):int");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.a.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        byte[] bArr = this.a;
        return new String(bArr, 0, bArr.length, str);
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> mo987iterator() {
        return new b(null);
    }
}
