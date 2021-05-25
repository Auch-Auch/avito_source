package kotlin.reflect.jvm.internal.impl.protobuf;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
public final class CodedInputStream {
    public final byte[] a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public final InputStream f;
    public int g;
    public int h;
    public int i;
    public int j;

    public CodedInputStream(InputStream inputStream) {
        this.i = Integer.MAX_VALUE;
        this.a = new byte[4096];
        this.c = 0;
        this.e = 0;
        this.h = 0;
        this.f = inputStream;
        this.b = false;
    }

    public static int decodeZigZag32(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long decodeZigZag64(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    public final byte[] a(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.h;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            int i6 = this.i;
            if (i5 > i6) {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.c();
            } else if (i2 < 4096) {
                byte[] bArr = new byte[i2];
                int i7 = this.c - i4;
                System.arraycopy(this.a, i4, bArr, 0, i7);
                int i8 = this.c;
                this.e = i8;
                int i9 = i2 - i7;
                if (i8 - i8 >= i9 || e(i9)) {
                    System.arraycopy(this.a, 0, bArr, i7, i9);
                    this.e = i9;
                    return bArr;
                }
                throw InvalidProtocolBufferException.c();
            } else {
                int i10 = this.c;
                this.h = i3 + i10;
                this.e = 0;
                this.c = 0;
                int i11 = i10 - i4;
                int i12 = i2 - i11;
                ArrayList arrayList = new ArrayList();
                while (i12 > 0) {
                    int min = Math.min(i12, 4096);
                    byte[] bArr2 = new byte[min];
                    int i13 = 0;
                    while (i13 < min) {
                        InputStream inputStream = this.f;
                        int read = inputStream == null ? -1 : inputStream.read(bArr2, i13, min - i13);
                        if (read != -1) {
                            this.h += read;
                            i13 += read;
                        } else {
                            throw InvalidProtocolBufferException.c();
                        }
                    }
                    i12 -= min;
                    arrayList.add(bArr2);
                }
                byte[] bArr3 = new byte[i2];
                System.arraycopy(this.a, i4, bArr3, 0, i11);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    byte[] bArr4 = (byte[]) it.next();
                    System.arraycopy(bArr4, 0, bArr3, i11, bArr4.length);
                    i11 += bArr4.length;
                }
                return bArr3;
            }
        } else if (i2 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.a();
        }
    }

    public long b() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte readRawByte = readRawByte();
            j2 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i2;
            if ((readRawByte & 128) == 0) {
                return j2;
            }
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    public final void c() {
        int i2 = this.c + this.d;
        this.c = i2;
        int i3 = this.h + i2;
        int i4 = this.i;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.d = i5;
            this.c = i2 - i5;
            return;
        }
        this.d = 0;
    }

    public void checkLastTagWas(int i2) throws InvalidProtocolBufferException {
        if (this.g != i2) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void d(int i2) throws IOException {
        if (!e(i2)) {
            throw InvalidProtocolBufferException.c();
        }
    }

    public final boolean e(int i2) throws IOException {
        int i3 = this.e;
        int i4 = i3 + i2;
        int i5 = this.c;
        if (i4 > i5) {
            if (this.h + i3 + i2 <= this.i && this.f != null) {
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.h += i3;
                    this.c -= i3;
                    this.e = 0;
                }
                InputStream inputStream = this.f;
                byte[] bArr2 = this.a;
                int i6 = this.c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    throw new IllegalStateException(a.o2(102, "InputStream#read(byte[]) returned invalid result: ", read, "\nThe InputStream implementation is buggy."));
                } else if (read > 0) {
                    this.c += read;
                    if ((this.h + i2) - 67108864 <= 0) {
                        c();
                        if (this.c >= i2) {
                            return true;
                        }
                        return e(i2);
                    }
                    throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
            }
            return false;
        }
        throw new IllegalStateException(a.o2(77, "refillBuffer() called when ", i2, " bytes were already available in buffer"));
    }

    public int getBytesUntilLimit() {
        int i2 = this.i;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.h + this.e);
    }

    public boolean isAtEnd() throws IOException {
        return this.e == this.c && !e(1);
    }

    public void popLimit(int i2) {
        this.i = i2;
        c();
    }

    public int pushLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = this.h + this.e + i2;
            int i4 = this.i;
            if (i3 <= i4) {
                this.i = i3;
                c();
                return i4;
            }
            throw InvalidProtocolBufferException.c();
        }
        throw InvalidProtocolBufferException.a();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public ByteString readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i2 = this.c;
        int i3 = this.e;
        if (readRawVarint32 <= i2 - i3 && readRawVarint32 > 0) {
            boolean z = this.b;
            ByteString copyFrom = ByteString.copyFrom(this.a, i3, readRawVarint32);
            this.e += readRawVarint32;
            return copyFrom;
        } else if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        } else {
            return new t6.w.f.a.m.e.a(a(readRawVarint32));
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i3 = this.j;
        if (i3 < 64) {
            this.j = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas((i2 << 3) | 4);
            this.j--;
            return;
        }
        throw InvalidProtocolBufferException.b();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.j < 64) {
            int pushLimit = pushLimit(readRawVarint32);
            this.j++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.j--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.b();
    }

    public byte readRawByte() throws IOException {
        if (this.e == this.c) {
            d(1);
        }
        byte[] bArr = this.a;
        int i2 = this.e;
        this.e = i2 + 1;
        return bArr[i2];
    }

    public int readRawLittleEndian32() throws IOException {
        int i2 = this.e;
        if (this.c - i2 < 4) {
            d(4);
            i2 = this.e;
        }
        byte[] bArr = this.a;
        this.e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i2 = this.e;
        if (this.c - i2 < 8) {
            d(8);
            i2 = this.e;
        }
        byte[] bArr = this.a;
        this.e = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r2[r3] < 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readRawVarint32() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.e
            int r1 = r9.c
            if (r1 != r0) goto L_0x0008
            goto L_0x007c
        L_0x0008:
            byte[] r2 = r9.a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0013
            r9.e = r3
            return r0
        L_0x0013:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0019
            goto L_0x007c
        L_0x0019:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x002d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L_0x0029:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L_0x0082
        L_0x002d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x003f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L_0x003d:
            r1 = r3
            goto L_0x0082
        L_0x003f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x004f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L_0x0029
        L_0x004f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0082
        L_0x007c:
            long r0 = r9.b()
            int r1 = (int) r0
            return r1
        L_0x0082:
            r9.e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint32():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readRawVarint64() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint64():long");
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 <= this.c - this.e && readRawVarint32 > 0) {
            String str = new String(this.a, this.e, readRawVarint32, "UTF-8");
            this.e += readRawVarint32;
            return str;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            return new String(a(readRawVarint32), "UTF-8");
        }
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArr;
        int readRawVarint32 = readRawVarint32();
        int i2 = this.e;
        if (readRawVarint32 <= this.c - i2 && readRawVarint32 > 0) {
            bArr = this.a;
            this.e = i2 + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            bArr = a(readRawVarint32);
            i2 = 0;
        }
        if (AppCompatDelegateImpl.i.Z0(bArr, i2, i2 + readRawVarint32)) {
            return new String(bArr, i2, readRawVarint32, "UTF-8");
        }
        throw new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.g = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.g = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.g;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int i3 = i2 & 7;
        if (i3 == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (i3 == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (i3 == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (i3 == 3) {
            codedOutputStream.writeRawVarint32(i2);
            skipMessage(codedOutputStream);
            int tagFieldNumber = (WireFormat.getTagFieldNumber(i2) << 3) | 4;
            checkLastTagWas(tagFieldNumber);
            codedOutputStream.writeRawVarint32(tagFieldNumber);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i2);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
        }
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    public void skipRawBytes(int i2) throws IOException {
        int i3 = this.c;
        int i4 = this.e;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.e = i4 + i2;
        } else if (i2 >= 0) {
            int i5 = this.h;
            int i6 = i5 + i4 + i2;
            int i7 = this.i;
            if (i6 <= i7) {
                int i8 = i3 - i4;
                this.e = i3;
                d(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.e = i10;
                        d(1);
                    } else {
                        this.e = i9;
                        return;
                    }
                }
            } else {
                skipRawBytes((i7 - i5) - i4);
                throw InvalidProtocolBufferException.c();
            }
        } else {
            throw InvalidProtocolBufferException.a();
        }
    }

    public CodedInputStream(t6.w.f.a.m.e.a aVar) {
        this.i = Integer.MAX_VALUE;
        byte[] bArr = aVar.a;
        this.a = bArr;
        this.e = 0;
        this.c = bArr.length + 0;
        this.h = -0;
        this.f = null;
        this.b = true;
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.j < 64) {
            int pushLimit = pushLimit(readRawVarint32);
            this.j++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.j--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.b();
    }

    public static int readRawVarint32(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i3 |= (read & 127) << i4;
                if ((read & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            } else {
                throw InvalidProtocolBufferException.c();
            }
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.c();
            } else if ((read2 & 128) == 0) {
                return i3;
            } else {
                i4 += 7;
            }
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }
}
