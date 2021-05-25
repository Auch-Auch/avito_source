package com.google.protobuf;

import a2.b.a.a.a;
import a2.j.i.n;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public final class CodedInputStream {
    public final byte[] a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public final InputStream f;
    public int g;
    public boolean h = false;
    public int i;
    public int j = Integer.MAX_VALUE;
    public int k;
    public int l = 100;
    public int m = 67108864;

    public CodedInputStream(byte[] bArr, int i2, int i3, boolean z) {
        this.a = bArr;
        this.c = i3 + i2;
        this.e = i2;
        this.i = -i2;
        this.f = null;
        this.b = z;
    }

    public static int decodeZigZag32(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long decodeZigZag64(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream, 4096);
    }

    public final byte[] a(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.i;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            if (i5 <= this.m) {
                int i6 = this.j;
                if (i5 <= i6) {
                    InputStream inputStream = this.f;
                    if (inputStream != null) {
                        int i7 = this.c;
                        int i8 = i7 - i4;
                        this.i = i3 + i7;
                        this.e = 0;
                        this.c = 0;
                        int i9 = i2 - i8;
                        if (i9 < 4096 || i9 <= inputStream.available()) {
                            byte[] bArr = new byte[i2];
                            System.arraycopy(this.a, i4, bArr, 0, i8);
                            while (i8 < i2) {
                                int read = this.f.read(bArr, i8, i2 - i8);
                                if (read != -1) {
                                    this.i += read;
                                    i8 += read;
                                } else {
                                    throw InvalidProtocolBufferException.e();
                                }
                            }
                            return bArr;
                        }
                        ArrayList arrayList = new ArrayList();
                        while (i9 > 0) {
                            int min = Math.min(i9, 4096);
                            byte[] bArr2 = new byte[min];
                            int i10 = 0;
                            while (i10 < min) {
                                int read2 = this.f.read(bArr2, i10, min - i10);
                                if (read2 != -1) {
                                    this.i += read2;
                                    i10 += read2;
                                } else {
                                    throw InvalidProtocolBufferException.e();
                                }
                            }
                            i9 -= min;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(this.a, i4, bArr3, 0, i8);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            byte[] bArr4 = (byte[]) it.next();
                            System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                            i8 += bArr4.length;
                        }
                        return bArr3;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.e();
            }
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        } else if (i2 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.c();
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
        throw InvalidProtocolBufferException.b();
    }

    public final void c() {
        int i2 = this.c + this.d;
        this.c = i2;
        int i3 = this.i + i2;
        int i4 = this.j;
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
            throw InvalidProtocolBufferException.e();
        }
    }

    public final boolean e(int i2) throws IOException {
        int i3 = this.e;
        int i4 = i3 + i2;
        int i5 = this.c;
        if (i4 > i5) {
            if (this.i + i3 + i2 <= this.j && this.f != null) {
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.i += i3;
                    this.c -= i3;
                    this.e = 0;
                }
                InputStream inputStream = this.f;
                byte[] bArr2 = this.a;
                int i6 = this.c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    throw new IllegalStateException(a.Q2("InputStream#read(byte[]) returned invalid result: ", read, "\nThe InputStream implementation is buggy."));
                } else if (read > 0) {
                    this.c += read;
                    if ((this.i + i2) - this.m <= 0) {
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
        throw new IllegalStateException(a.Q2("refillBuffer() called when ", i2, " bytes were already available in buffer"));
    }

    public void enableAliasing(boolean z) {
        this.h = z;
    }

    public int getBytesUntilLimit() {
        int i2 = this.j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.i + this.e);
    }

    public int getLastTag() {
        return this.g;
    }

    public int getTotalBytesRead() {
        return this.i + this.e;
    }

    public boolean isAtEnd() throws IOException {
        return this.e == this.c && !e(1);
    }

    public void popLimit(int i2) {
        this.j = i2;
        c();
    }

    public int pushLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = this.i + this.e + i2;
            int i4 = this.j;
            if (i3 <= i4) {
                this.j = i3;
                c();
                return i4;
            }
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.c();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public byte[] readByteArray() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i2 = this.c;
        int i3 = this.e;
        if (readRawVarint32 > i2 - i3 || readRawVarint32 <= 0) {
            return a(readRawVarint32);
        }
        byte[] copyOfRange = Arrays.copyOfRange(this.a, i3, i3 + readRawVarint32);
        this.e += readRawVarint32;
        return copyOfRange;
    }

    public ByteBuffer readByteBuffer() throws IOException {
        ByteBuffer byteBuffer;
        int readRawVarint32 = readRawVarint32();
        int i2 = this.c;
        int i3 = this.e;
        if (readRawVarint32 <= i2 - i3 && readRawVarint32 > 0) {
            if (this.f != null || this.b || !this.h) {
                byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.a, i3, i3 + readRawVarint32));
            } else {
                byteBuffer = ByteBuffer.wrap(this.a, i3, readRawVarint32).slice();
            }
            this.e += readRawVarint32;
            return byteBuffer;
        } else if (readRawVarint32 == 0) {
            return Internal.EMPTY_BYTE_BUFFER;
        } else {
            return ByteBuffer.wrap(a(readRawVarint32));
        }
    }

    public ByteString readBytes() throws IOException {
        ByteString byteString;
        int readRawVarint32 = readRawVarint32();
        int i2 = this.c;
        int i3 = this.e;
        if (readRawVarint32 <= i2 - i3 && readRawVarint32 > 0) {
            if (!this.b || !this.h) {
                byteString = ByteString.copyFrom(this.a, i3, readRawVarint32);
            } else {
                byte[] bArr = this.a;
                ByteString byteString2 = ByteString.EMPTY;
                byteString = new ByteString.c(bArr, i3, readRawVarint32);
            }
            this.e += readRawVarint32;
            return byteString;
        } else if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        } else {
            byte[] a3 = a(readRawVarint32);
            ByteString byteString3 = ByteString.EMPTY;
            return new ByteString.f(a3);
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
        int i3 = this.k;
        if (i3 < this.l) {
            this.k = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas((i2 << 3) | 4);
            this.k--;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.k < this.l) {
            int pushLimit = pushLimit(readRawVarint32);
            this.k++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.k--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.d();
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

    public byte[] readRawBytes(int i2) throws IOException {
        int i3 = this.e;
        if (i2 > this.c - i3 || i2 <= 0) {
            return a(i2);
        }
        int i4 = i2 + i3;
        this.e = i4;
        return Arrays.copyOfRange(this.a, i3, i4);
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2[r3] < 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readRawVarint32() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.e
            int r1 = r5.c
            if (r1 != r0) goto L_0x0007
            goto L_0x006a
        L_0x0007:
            byte[] r2 = r5.a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.e = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0018
            goto L_0x006a
        L_0x0018:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0070
        L_0x0024:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r1 = r3
            goto L_0x0070
        L_0x0031:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0070
        L_0x003f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0070
        L_0x006a:
            long r0 = r5.b()
            int r1 = (int) r0
            return r1
        L_0x0070:
            r5.e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.readRawVarint32():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readRawVarint64() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.readRawVarint64():long");
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
        int i2 = this.c;
        if (readRawVarint32 <= i2 - this.e && readRawVarint32 > 0) {
            String str = new String(this.a, this.e, readRawVarint32, Internal.a);
            this.e += readRawVarint32;
            return str;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            if (readRawVarint32 > i2) {
                return new String(a(readRawVarint32), Internal.a);
            }
            d(readRawVarint32);
            String str2 = new String(this.a, this.e, readRawVarint32, Internal.a);
            this.e += readRawVarint32;
            return str2;
        }
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArr;
        byte[] bArr2;
        int readRawVarint32 = readRawVarint32();
        int i2 = this.e;
        int i3 = this.c;
        boolean z = false;
        if (readRawVarint32 <= i3 - i2 && readRawVarint32 > 0) {
            bArr = this.a;
            this.e = i2 + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            if (readRawVarint32 <= i3) {
                d(readRawVarint32);
                bArr2 = this.a;
                this.e = readRawVarint32 + 0;
            } else {
                bArr2 = a(readRawVarint32);
            }
            bArr = bArr2;
            i2 = 0;
        }
        if (n.a.e(0, bArr, i2, i2 + readRawVarint32) == 0) {
            z = true;
        }
        if (z) {
            return new String(bArr, i2, readRawVarint32, Internal.a);
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

    @Deprecated
    public void readUnknownGroup(int i2, MessageLite.Builder builder) throws IOException {
        readGroup(i2, builder, (ExtensionRegistryLite) null);
    }

    public void resetSizeCounter() {
        this.i = -this.e;
    }

    public int setRecursionLimit(int i2) {
        if (i2 >= 0) {
            int i3 = this.l;
            this.l = i2;
            return i3;
        }
        throw new IllegalArgumentException(a.M2("Recursion limit cannot be negative: ", i2));
    }

    public int setSizeLimit(int i2) {
        if (i2 >= 0) {
            int i3 = this.m;
            this.m = i2;
            return i3;
        }
        throw new IllegalArgumentException(a.M2("Size limit cannot be negative: ", i2));
    }

    public boolean skipField(int i2) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            int i3 = this.c;
            int i4 = this.e;
            if (i3 - i4 >= 10) {
                byte[] bArr = this.a;
                int i5 = 0;
                while (true) {
                    if (i5 >= 10) {
                        break;
                    }
                    int i6 = i4 + 1;
                    if (bArr[i4] >= 0) {
                        this.e = i6;
                        break;
                    }
                    i5++;
                    i4 = i6;
                }
                return true;
            }
            for (int i7 = 0; i7 < 10; i7++) {
                if (readRawByte() >= 0) {
                    return true;
                }
            }
            throw InvalidProtocolBufferException.b();
        } else if (tagWireType == 1) {
            skipRawBytes(8);
            return true;
        } else if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        } else if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas((WireFormat.getTagFieldNumber(i2) << 3) | 4);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.a();
        }
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public void skipRawBytes(int i2) throws IOException {
        int i3 = this.c;
        int i4 = this.e;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.e = i4 + i2;
        } else if (i2 >= 0) {
            int i5 = this.i;
            int i6 = i5 + i4 + i2;
            int i7 = this.j;
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
                throw InvalidProtocolBufferException.e();
            }
        } else {
            throw InvalidProtocolBufferException.c();
        }
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i2, int i3) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i2, i3, false);
        try {
            codedInputStream.pushLimit(i3);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
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

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return newInstance(bArr);
    }

    public <T extends MessageLite> T readGroup(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i3 = this.k;
        if (i3 < this.l) {
            this.k = i3 + 1;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas((i2 << 3) | 4);
            this.k--;
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.d();
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.k < this.l) {
            int pushLimit = pushLimit(readRawVarint32);
            this.k++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.k--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.d();
    }

    public CodedInputStream(InputStream inputStream, int i2) {
        this.a = new byte[i2];
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
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
                throw InvalidProtocolBufferException.e();
            }
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.e();
            } else if ((read2 & 128) == 0) {
                return i3;
            } else {
                i4 += 7;
            }
        }
        throw InvalidProtocolBufferException.b();
    }

    public boolean skipField(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (tagWireType == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (tagWireType == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i2);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i2);
            skipMessage(codedOutputStream);
            int tagFieldNumber = (WireFormat.getTagFieldNumber(i2) << 3) | 4;
            checkLastTagWas(tagFieldNumber);
            codedOutputStream.writeRawVarint32(tagFieldNumber);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i2);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.a();
        }
    }
}
