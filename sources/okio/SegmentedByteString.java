package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.vk.sdk.api.VKApiConst;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010T\u001a\b\u0012\u0004\u0012\u00020&0O\u0012\u0006\u0010N\u001a\u00020I¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0019H\u0010¢\u0006\u0004\b \u0010!J\u000f\u0010%\u001a\u00020\u0019H\u0010¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b/\u00100J'\u0010/\u001a\u00020.2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0010¢\u0006\u0004\b5\u00106J/\u0010:\u001a\u0002092\u0006\u00103\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0016¢\u0006\u0004\b:\u0010;J/\u0010:\u001a\u0002092\u0006\u00103\u001a\u00020\u00192\u0006\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0016¢\u0006\u0004\b:\u0010<J\u001f\u0010>\u001a\u00020\u00192\u0006\u00107\u001a\u00020&2\u0006\u0010=\u001a\u00020\u0019H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u00192\u0006\u00107\u001a\u00020&2\u0006\u0010=\u001a\u00020\u0019H\u0016¢\u0006\u0004\b@\u0010?J\u000f\u0010B\u001a\u00020&H\u0010¢\u0006\u0004\bA\u0010(J\u001a\u0010D\u001a\u0002092\b\u00107\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bF\u0010$J\u000f\u0010G\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010\u000bJ\u000f\u0010H\u001a\u00020\u0001H\u0002¢\u0006\u0004\bH\u0010\u000eR\u001c\u0010N\u001a\u00020I8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010T\u001a\b\u0012\u0004\u0012\u00020&0O8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", Types.STRING, "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "()Lokio/ByteString;", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", VKApiConst.OUT, "", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", DecodeProducer.EXTRA_BITMAP_BYTES, "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", AuthSource.SEND_ABUSE, "", "e", "[I", "getDirectory$okio", "()[I", "directory", "", "d", "[[B", "getSegments$okio", "()[[B", "segments", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class SegmentedByteString extends ByteString {
    @NotNull
    public final transient byte[][] d;
    @NotNull
    public final transient int[] e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] bArr, @NotNull int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(bArr, "segments");
        Intrinsics.checkNotNullParameter(iArr, "directory");
        this.d = bArr;
        this.e = iArr;
    }

    private final Object writeReplace() {
        return a();
    }

    public final ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            instance.update(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.e;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.d;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString, java.lang.Object
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            byte[] bArr = getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        setHashCode$okio(i2);
        return i2;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory$okio()[length + i];
                int i4 = getDirectory$okio()[i];
                instance.update(getSegments$okio()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return a().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i) {
        int i2;
        Util.checkOffsetAndCount((long) getDirectory$okio()[getSegments$okio().length - 1], (long) i, 1);
        int segment = SegmentedByteStringKt.segment(this, i);
        if (segment == 0) {
            i2 = 0;
        } else {
            i2 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i - i2) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return a().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, @NotNull ByteString byteString, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i5, (getDirectory$okio()[segment] - i4) + i4) - i;
            if (!byteString.rangeEquals(i2, getSegments$okio()[segment], (i - i4) + i6, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return a().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int i, int i2) {
        int i3 = 0;
        if (i >= 0) {
            if (i2 <= size()) {
                int i4 = i2 - i;
                if (!(i4 >= 0)) {
                    throw new IllegalArgumentException(a.R2("endIndex=", i2, " < beginIndex=", i).toString());
                } else if (i == 0 && i2 == size()) {
                    return this;
                } else {
                    if (i == i2) {
                        return ByteString.EMPTY;
                    }
                    int segment = SegmentedByteStringKt.segment(this, i);
                    int segment2 = SegmentedByteStringKt.segment(this, i2 - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.copyOfRange(getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i5 = 0;
                        int i6 = segment;
                        while (true) {
                            iArr[i5] = Math.min(getDirectory$okio()[i6] - i, i4);
                            int i7 = i5 + 1;
                            iArr[i5 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i6];
                            if (i6 == segment2) {
                                break;
                            }
                            i6++;
                            i5 = i7;
                        }
                    }
                    if (segment != 0) {
                        i3 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = (i - i3) + iArr[length];
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                StringBuilder M = a.M("endIndex=", i2, " > length(");
                M.append(size());
                M.append(')');
                throw new IllegalArgumentException(M.toString().toString());
            }
        } else {
            throw new IllegalArgumentException(a.Q2("beginIndex=", i, " < 0").toString());
        }
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt___ArraysJvmKt.copyInto(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString, java.lang.Object
    @NotNull
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            outputStream.write(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i4 = i2 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i4) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = getDirectory$okio()[segment - 1];
            }
            int i5 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i4, (getDirectory$okio()[segment] - i3) + i3) - i;
            int i6 = (i - i3) + i5;
            Segment segment2 = new Segment(getSegments$okio()[segment], i6, i6 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) size()));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, @NotNull byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(bArr, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = SegmentedByteStringKt.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i5, (getDirectory$okio()[segment] - i4) + i4) - i;
            if (!Util.arrayRangeEquals(getSegments$okio()[segment], (i - i4) + i6, bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
