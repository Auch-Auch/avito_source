package a2.j.d.g;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@Immutable
public final class t extends d implements Serializable {
    public static final HashFunction b = new t(0);
    public static final HashFunction c = new t(Hashing.a);
    private static final long serialVersionUID = 0;
    public final int a;

    @CanIgnoreReturnValue
    public static final class a extends e {
        public int a;
        public long b;
        public int c;
        public int d = 0;
        public boolean e = false;

        public a(int i) {
            this.a = i;
        }

        public final void a(int i, long j) {
            long j2 = this.b;
            long j3 = j & BodyPartID.bodyIdMax;
            int i2 = this.c;
            long j4 = (j3 << i2) | j2;
            this.b = j4;
            int i3 = (i * 8) + i2;
            this.c = i3;
            this.d += i;
            if (i3 >= 32) {
                this.a = t.d(this.a, t.e((int) j4));
                this.b >>>= 32;
                this.c -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.e);
            this.e = true;
            int e2 = this.a ^ t.e((int) this.b);
            this.a = e2;
            return t.c(e2, this.d);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putByte */
        public Hasher mo61putByte(byte b2) {
            a(1, (long) (b2 & 255));
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putChar */
        public Hasher mo62putChar(char c2) {
            a(2, (long) c2);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putInt */
        public Hasher mo63putInt(int i) {
            a(4, (long) i);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putByte  reason: collision with other method in class */
        public PrimitiveSink mo61putByte(byte b2) {
            a(1, (long) (b2 & 255));
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putChar  reason: collision with other method in class */
        public PrimitiveSink mo62putChar(char c2) {
            a(2, (long) c2);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putInt  reason: collision with other method in class */
        public PrimitiveSink mo63putInt(int i) {
            a(4, (long) i);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putLong */
        public Hasher mo59putLong(long j) {
            a(4, (long) ((int) j));
            a(4, j >>> 32);
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return mo45putBytes(charSequence.toString().getBytes(charset));
            }
            int length = charSequence.length();
            int i = 0;
            while (true) {
                int i2 = i + 4;
                if (i2 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i);
                char charAt2 = charSequence.charAt(i + 1);
                char charAt3 = charSequence.charAt(i + 2);
                char charAt4 = charSequence.charAt(i + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                a(4, (long) ((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i = i2;
            }
            while (i < length) {
                char charAt5 = charSequence.charAt(i);
                if (charAt5 < 128) {
                    a(1, (long) charAt5);
                } else if (charAt5 < 2048) {
                    a(2, (long) ((((charAt5 & '?') | 128) << 8) | (((charAt5 >>> 6) | 960) & 255)));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    a(3, t.a(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i);
                    if (codePointAt == charAt5) {
                        mo45putBytes(charSequence.subSequence(i, length).toString().getBytes(charset));
                        return this;
                    }
                    i++;
                    a(4, t.b(codePointAt));
                }
                i++;
            }
            return this;
        }

        @Override // a2.j.d.g.e, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes */
        public Hasher mo55putBytes(byte[] bArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > i2) {
                    break;
                }
                int i5 = i3 + i;
                a(4, (long) Ints.fromBytes(bArr[i5 + 3], bArr[i5 + 2], bArr[i5 + 1], bArr[i5]));
                i3 = i4;
            }
            while (i3 < i2) {
                mo61putByte(bArr[i + i3]);
                i3++;
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        /* renamed from: putBytes */
        public Hasher mo54putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                mo63putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                mo61putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    public t(int i) {
        this.a = i;
    }

    public static long a(char c2) {
        return (long) ((((c2 & '?') | 128) << 16) | (((c2 >>> '\f') | 480) & 255) | ((((c2 >>> 6) & 63) | 128) << 8));
    }

    public static long b(int i) {
        return ((((long) (i >>> 18)) | 240) & 255) | ((((long) ((i >>> 12) & 63)) | 128) << 8) | ((((long) ((i >>> 6) & 63)) | 128) << 16) | ((((long) (i & 63)) | 128) << 24);
    }

    public static HashCode c(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    public static int d(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    public static int e(int i) {
        return Integer.rotateLeft(i * -862048943, 15) * 461845907;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof t) || this.a != ((t) obj).a) {
            return false;
        }
        return true;
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i3 = this.a;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            int i7 = i5 + i;
            i3 = d(i3, e(Ints.fromBytes(bArr[i7 + 3], bArr[i7 + 2], bArr[i7 + 1], bArr[i7])));
            i5 = i6;
        }
        int i8 = i5;
        int i9 = 0;
        while (i8 < i2) {
            i4 ^= UnsignedBytes.toInt(bArr[i + i8]) << i9;
            i8++;
            i9 += 8;
        }
        return c(e(i4) ^ i3, i2);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return t.class.hashCode() ^ this.a;
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return c(d(this.a, e(i)), 4);
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return c(d(d(this.a, e((int) j)), e(i)), 8);
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 4;
            if (i5 > length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            char charAt2 = charSequence.charAt(i3 + 1);
            char charAt3 = charSequence.charAt(i3 + 2);
            char charAt4 = charSequence.charAt(i3 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i = d(i, e((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i4 += 4;
            i3 = i5;
        }
        long j = 0;
        while (i3 < length) {
            char charAt5 = charSequence.charAt(i3);
            if (charAt5 < 128) {
                j |= ((long) charAt5) << i2;
                i2 += 8;
                i4++;
            } else if (charAt5 < 2048) {
                j |= ((long) ((((charAt5 & '?') | 128) << 8) | (((charAt5 >>> 6) | 960) & 255))) << i2;
                i2 += 16;
                i4 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j |= a(charAt5) << i2;
                i2 += 24;
                i4 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i3);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i3++;
                j |= b(codePointAt) << i2;
                i4 += 4;
            }
            if (i2 >= 32) {
                i = d(i, e((int) j));
                j >>>= 32;
                i2 -= 32;
            }
            i3++;
        }
        return c(e((int) j) ^ i, i4);
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.a;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = d(i, e(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= e(charSequence.charAt(charSequence.length() - 1));
        }
        return c(i, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.a);
    }

    @Override // java.lang.Object
    public String toString() {
        return a2.b.a.a.a.j(a2.b.a.a.a.L("Hashing.murmur3_32("), this.a, ")");
    }
}
