package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
public final class UnknownFieldSetLite {
    public static final UnknownFieldSetLite f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    public static UnknownFieldSetLite c(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.a + unknownFieldSetLite2.a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.b, i);
        System.arraycopy(unknownFieldSetLite2.b, 0, copyOf, unknownFieldSetLite.a, unknownFieldSetLite2.a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.c, i);
        System.arraycopy(unknownFieldSetLite2.c, 0, copyOf2, unknownFieldSetLite.a, unknownFieldSetLite2.a);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return f;
    }

    public void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean b(int i, CodedInputStream codedInputStream) throws IOException {
        int readTag;
        a();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            d(i, Long.valueOf(codedInputStream.readInt64()));
            return true;
        } else if (tagWireType == 1) {
            d(i, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        } else if (tagWireType == 2) {
            d(i, codedInputStream.readBytes());
            return true;
        } else if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
            do {
                readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                }
            } while (unknownFieldSetLite.b(readTag, codedInputStream));
            codedInputStream.checkLastTagWas((tagFieldNumber << 3) | 4);
            d(i, unknownFieldSetLite);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                d(i, Integer.valueOf(codedInputStream.readFixed32()));
                return true;
            }
            throw InvalidProtocolBufferException.a();
        }
    }

    public final void d(int i, Object obj) {
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.b = Arrays.copyOf(iArr, i3);
            this.c = Arrays.copyOf(this.c, i3);
        }
        int[] iArr2 = this.b;
        int i4 = this.a;
        iArr2[i4] = i;
        this.c[i4] = obj;
        this.a = i4 + 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        return this.a == unknownFieldSetLite.a && Arrays.equals(this.b, unknownFieldSetLite.b) && Arrays.deepEquals(this.c, unknownFieldSetLite.c);
    }

    public int getSerializedSize() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.a; i4++) {
            int i5 = this.b[i4];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                i = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.c[i4]).longValue());
            } else if (tagWireType == 1) {
                i = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.c[i4]).longValue());
            } else if (tagWireType == 2) {
                i = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.c[i4]);
            } else if (tagWireType == 3) {
                i3 = ((UnknownFieldSetLite) this.c[i4]).getSerializedSize() + (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + i3;
            } else if (tagWireType == 5) {
                i = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.c[i4]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.a());
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.b);
        return Arrays.deepHashCode(this.c) + ((hashCode + ((527 + this.a) * 31)) * 31);
    }

    public void makeImmutable() {
        this.e = false;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.a; i++) {
            int i2 = this.b[i];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.c[i]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.c[i]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.c[i]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.c[i]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.c[i]).intValue());
            } else {
                throw InvalidProtocolBufferException.a();
            }
        }
    }

    public UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
