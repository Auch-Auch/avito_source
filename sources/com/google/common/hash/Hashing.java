package com.google.common.hash;

import a2.j.d.g.i;
import a2.j.d.g.j;
import a2.j.d.g.k;
import a2.j.d.g.l;
import a2.j.d.g.q;
import a2.j.d.g.r;
import a2.j.d.g.s;
import a2.j.d.g.t;
import a2.j.d.g.u;
import com.adjust.sdk.Constants;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
@Beta
public final class Hashing {
    public static final int a = ((int) System.currentTimeMillis());

    @Immutable
    public enum b implements l<Checksum> {
        CRC_32("Hashing.crc32()") {
            @Override // com.google.common.base.Supplier
            public Object get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") {
            @Override // com.google.common.base.Supplier
            public Object get() {
                return new Adler32();
            }
        };
        
        public final HashFunction a;

        /* access modifiers changed from: public */
        b(String str, a aVar) {
            this.a = new i(this, 32, str);
        }
    }

    public static final class c extends a2.j.d.g.c {
        public c(HashFunction[] hashFunctionArr, a aVar) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int i = 0;
            for (HashFunction hashFunction : this.a) {
                i += hashFunction.bits();
            }
            return i;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(this.a, ((c) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.a);
        }
    }

    public static class d {
        public static final HashFunction a = new r(Constants.MD5, "Hashing.md5()");
    }

    public static class e {
        public static final HashFunction a = new r("SHA-1", "Hashing.sha1()");
    }

    public static class f {
        public static final HashFunction a = new r("SHA-256", "Hashing.sha256()");
    }

    public static class g {
        public static final HashFunction a = new r(McElieceCCA2KeyGenParameterSpec.SHA384, "Hashing.sha384()");
    }

    public static class h {
        public static final HashFunction a = new r(McElieceCCA2KeyGenParameterSpec.SHA512, "Hashing.sha512()");
    }

    public static String a(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    public static HashFunction adler32() {
        return b.ADLER_32.a;
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode hashCode : iterable) {
            byte[] asBytes = hashCode.asBytes();
            Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) ((bArr[i] * 37) ^ asBytes[i]);
            }
        }
        return new HashCode.a(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode hashCode : iterable) {
            byte[] asBytes = hashCode.asBytes();
            Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) (bArr[i] + asBytes[i]);
            }
        }
        return new HashCode.a(bArr);
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        arrayList.addAll(Arrays.asList(hashFunctionArr));
        return new c((HashFunction[]) arrayList.toArray(new HashFunction[0]), null);
    }

    public static int consistentHash(HashCode hashCode, int i) {
        return consistentHash(hashCode.padToLong(), i);
    }

    public static HashFunction crc32() {
        return b.CRC_32.a;
    }

    public static HashFunction crc32c() {
        return j.a;
    }

    public static HashFunction farmHashFingerprint64() {
        return k.a;
    }

    public static HashFunction goodFastHash(int i) {
        Preconditions.checkArgument(i > 0, "Number of bits must be positive");
        int i2 = (i + 31) & -32;
        if (i2 == 32) {
            return t.c;
        }
        if (i2 <= 128) {
            return s.c;
        }
        int i3 = (i2 + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i3];
        hashFunctionArr[0] = s.c;
        int i4 = a;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 += 1500450271;
            hashFunctionArr[i5] = murmur3_128(i4);
        }
        return new c(hashFunctionArr, null);
    }

    public static HashFunction hmacMd5(Key key) {
        return new q("HmacMD5", key, a("hmacMd5", key));
    }

    public static HashFunction hmacSha1(Key key) {
        return new q("HmacSHA1", key, a("hmacSha1", key));
    }

    public static HashFunction hmacSha256(Key key) {
        return new q("HmacSHA256", key, a("hmacSha256", key));
    }

    public static HashFunction hmacSha512(Key key) {
        return new q("HmacSHA512", key, a("hmacSha512", key));
    }

    @Deprecated
    public static HashFunction md5() {
        return d.a;
    }

    public static HashFunction murmur3_128(int i) {
        return new s(i);
    }

    public static HashFunction murmur3_32(int i) {
        return new t(i);
    }

    @Deprecated
    public static HashFunction sha1() {
        return e.a;
    }

    public static HashFunction sha256() {
        return f.a;
    }

    public static HashFunction sha384() {
        return g.a;
    }

    public static HashFunction sha512() {
        return h.a;
    }

    public static HashFunction sipHash24() {
        return u.e;
    }

    public static int consistentHash(long j, int i) {
        int i2 = 0;
        Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        while (true) {
            j = (j * 2862933555777941757L) + 1;
            int i3 = (int) (((double) (i2 + 1)) / (((double) (((int) (j >>> 33)) + 1)) / 2.147483648E9d));
            if (i3 < 0 || i3 >= i) {
                break;
            }
            i2 = i3;
        }
        return i2;
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    public static HashFunction murmur3_128() {
        return s.b;
    }

    public static HashFunction murmur3_32() {
        return t.b;
    }

    public static HashFunction sipHash24(long j, long j2) {
        return new u(2, 4, j, j2);
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        for (HashFunction hashFunction : iterable) {
            arrayList.add(hashFunction);
        }
        Preconditions.checkArgument(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new c((HashFunction[]) arrayList.toArray(new HashFunction[0]), null);
    }
}
