package okio;

import com.adjust.sdk.Constants;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B!\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u001bJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u00020\b8G@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", DecodeProducer.EXTRA_BITMAP_BYTES, "read", "(Lokio/Buffer;J)J", "Lokio/ByteString;", "-deprecated_hash", "()Lokio/ByteString;", "hash", "Ljava/security/MessageDigest;", AuthSource.SEND_ABUSE, "Ljava/security/MessageDigest;", "messageDigest", "Ljavax/crypto/Mac;", AuthSource.BOOKING_ORDER, "Ljavax/crypto/Mac;", "mac", "Lokio/Source;", "source", "", "algorithm", "<init>", "(Lokio/Source;Ljava/lang/String;)V", "key", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    public final MessageDigest a;
    public final Mac b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lokio/HashingSource$Companion;", "", "Lokio/Source;", "source", "Lokio/HashingSource;", "md5", "(Lokio/Source;)Lokio/HashingSource;", "sha1", "sha256", "sha512", "Lokio/ByteString;", "key", "hmacSha1", "(Lokio/Source;Lokio/ByteString;)Lokio/HashingSource;", "hmacSha256", "hmacSha512", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSource md5(@NotNull Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, Constants.MD5);
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha1(@NotNull Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha256(@NotNull Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha512(@NotNull Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, McElieceCCA2KeyGenParameterSpec.SHA512);
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull String str) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(str, "algorithm");
        this.a = MessageDigest.getInstance(str);
        this.b = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource md5(@NotNull Source source) {
        return Companion.md5(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha1(@NotNull Source source) {
        return Companion.sha1(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha256(@NotNull Source source) {
        return Companion.sha256(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha512(@NotNull Source source) {
        return Companion.sha512(source);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    @NotNull
    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m693deprecated_hash() {
        return hash();
    }

    @JvmName(name = "hash")
    @NotNull
    public final ByteString hash() {
        byte[] bArr;
        MessageDigest messageDigest = this.a;
        if (messageDigest != null) {
            bArr = messageDigest.digest();
        } else {
            Mac mac = this.b;
            Intrinsics.checkNotNull(mac);
            bArr = mac.doFinal();
        }
        Intrinsics.checkNotNullExpressionValue(bArr, "result");
        return new ByteString(bArr);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long read = super.read(buffer, j);
        if (read != -1) {
            long size = buffer.size() - read;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            while (size2 > size) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            while (size2 < buffer.size()) {
                int i = (int) ((((long) segment.pos) + size) - size2);
                MessageDigest messageDigest = this.a;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    Mac mac = this.b;
                    Intrinsics.checkNotNull(mac);
                    mac.update(segment.data, i, segment.limit - i);
                }
                size2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull ByteString byteString, @NotNull String str) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(byteString, "key");
        Intrinsics.checkNotNullParameter(str, "algorithm");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Unit unit = Unit.INSTANCE;
            this.b = instance;
            this.a = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
