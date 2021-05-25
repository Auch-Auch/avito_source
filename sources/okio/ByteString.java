package okio;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0016\u0018\u0000 u2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001uB\u0011\b\u0000\u0012\u0006\u0010m\u001a\u000209¢\u0006\u0004\bs\u0010tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fH\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0000H\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0000H\u0016¢\u0006\u0004\b(\u0010\u0015J#\u0010,\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020)H\u0010¢\u0006\u0004\b0\u00101J\u0018\u00105\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0002¢\u0006\u0004\b4\u00101J\u000f\u00108\u001a\u00020)H\u0010¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u000209H\u0010¢\u0006\u0004\b<\u0010;J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010B\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0010¢\u0006\u0004\bH\u0010IJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010NJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010OJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bQ\u0010RJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u000209¢\u0006\u0004\bQ\u0010SJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0000¢\u0006\u0004\bU\u0010RJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u000209¢\u0006\u0004\bU\u0010SJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bW\u0010XJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bW\u0010YJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bZ\u0010XJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bZ\u0010YJ\u001a\u0010\\\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020)H\u0016¢\u0006\u0004\b^\u00107J\u0018\u0010_\u001a\u00020)2\u0006\u0010J\u001a\u00020\u0000H\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0016¢\u0006\u0004\ba\u0010\u000eJ\u0017\u00104\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0007¢\u0006\u0004\bb\u00101J\u000f\u0010d\u001a\u00020)H\u0007¢\u0006\u0004\bc\u00107R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010\u000e\"\u0004\bh\u0010iR\u0013\u0010d\u001a\u00020)8G@\u0006¢\u0006\u0006\u001a\u0004\bd\u00107R\u001c\u0010m\u001a\u0002098\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010;R\"\u0010^\u001a\u00020)8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u00107\"\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", VKApiConst.OUT, "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", Types.STRING, "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", FirebaseAnalytics.Param.INDEX, "getByte", "get", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", DecodeProducer.EXTRA_BITMAP_BYTES, "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "c", "[B", "getData$okio", "data", AuthSource.SEND_ABUSE, "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "<init>", "([B)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    public transient int a;
    @Nullable
    public transient String b;
    @NotNull
    private final byte[] c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0005*\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u0005*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0011J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u001b\u0010\u001c\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b \u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\rH\u0007¢\u0006\u0004\b#\u0010\u000eJ'\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u000bJ\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010'\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lokio/ByteString$Companion;", "", "", "", "data", "Lokio/ByteString;", "of", "([B)Lokio/ByteString;", "", "offset", DecodeProducer.EXTRA_BITMAP_BYTES, "([BII)Lokio/ByteString;", "toByteString", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", "encodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "encodeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "encode", "decodeBase64", "decodeHex", "Ljava/io/InputStream;", "read", "(Ljava/io/InputStream;I)Lokio/ByteString;", "readByteString", Types.STRING, "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return companion.of(bArr, i, i2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* renamed from: -deprecated_decodeBase64 */
        public final ByteString m682deprecated_decodeBase64(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            return decodeBase64(str);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* renamed from: -deprecated_decodeHex */
        public final ByteString m683deprecated_decodeHex(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            return decodeHex(str);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* renamed from: -deprecated_encodeString */
        public final ByteString m684deprecated_encodeString(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(str, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* renamed from: -deprecated_encodeUtf8 */
        public final ByteString m685deprecated_encodeUtf8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            return encodeUtf8(str);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of */
        public final ByteString m686deprecated_of(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
            return of(byteBuffer);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* renamed from: -deprecated_read */
        public final ByteString m688deprecated_read(@NotNull InputStream inputStream, int i) {
            Intrinsics.checkNotNullParameter(inputStream, "inputstream");
            return read(inputStream, i);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (ByteStringKt.access$decodeHexDigit(str.charAt(i2 + 1)) + (ByteStringKt.access$decodeHexDigit(str.charAt(i2)) << 4));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(a.c3("Unexpected hex string: ", str).toString());
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(str, "$this$encode");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "$this$toByteString");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "read")
        @NotNull
        public final ByteString read(@NotNull InputStream inputStream, int i) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "$this$readByteString");
            int i2 = 0;
            if (i >= 0) {
                byte[] bArr = new byte[i];
                while (i2 < i) {
                    int read = inputStream.read(bArr, i2, i - i2);
                    if (read != -1) {
                        i2 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(a.M2("byteCount < 0: ", i).toString());
        }

        public Companion(j jVar) {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of */
        public final ByteString m687deprecated_of(@NotNull byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return of(bArr, i, i2);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "$this$toByteString");
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i, i2 + i));
        }
    }

    public ByteString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.c = bArr;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i, int i2) {
        return Companion.of(bArr, i, i2);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i) throws IOException {
        return Companion.read(inputStream, i);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("c");
        Intrinsics.checkNotNullExpressionValue(declaredField, AnalyticFieldsName.field);
        declaredField.setAccessible(true);
        declaredField.set(this, read.c);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = byteString.size();
            }
            return byteString.substring(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte */
    public final byte m680deprecated_getByte(int i) {
        return getByte(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size */
    public final int m681deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.c).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.c);
        Intrinsics.checkNotNullExpressionValue(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int i) {
        return internalGet$okio(i);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.c;
    }

    public final int getHashCode$okio() {
        return this.a;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[(getData$okio().length * 2)];
        byte[] data$okio = getData$okio();
        int i = 0;
        for (byte b2 : data$okio) {
            int i2 = i + 1;
            cArr[i] = ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = instance.doFinal(this.c);
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return indexOf(byteString.internalArray$okio(), i);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i) {
        return getData$okio()[i];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return lastIndexOf(byteString.internalArray$okio(), i);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio(Constants.MD5);
    }

    public boolean rangeEquals(int i, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return byteString.rangeEquals(i2, getData$okio(), i, i3);
    }

    public final void setHashCode$okio(int i) {
        this.a = i;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.b = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio(McElieceCCA2KeyGenParameterSpec.SHA512);
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.c, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int i, int i2) {
        boolean z = true;
        if (i >= 0) {
            if (i2 <= getData$okio().length) {
                if (i2 - i < 0) {
                    z = false;
                }
                if (z) {
                    return (i == 0 && i2 == getData$okio().length) ? this : new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData$okio(), i, i2));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(a.i(a.L("endIndex > length("), getData$okio().length, ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b2;
        for (int i = 0; i < getData$okio().length; i++) {
            byte b3 = getData$okio()[i];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b3 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b5 = copyOf[i2];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i2] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b2;
        for (int i = 0; i < getData$okio().length; i++) {
            byte b3 = getData$okio()[i];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b3 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b5 = copyOf[i2];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i2] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        ByteString byteString;
        boolean z = true;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = utf8();
            Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = m.replace$default(m.replace$default(m.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex >= utf8.length()) {
                return a.d3("[text=", replace$default, ']');
            }
            StringBuilder L = a.L("[size=");
            L.append(getData$okio().length);
            L.append(" text=");
            L.append(replace$default);
            L.append("…]");
            return L.toString();
        } else if (getData$okio().length <= 64) {
            StringBuilder L2 = a.L("[hex=");
            L2.append(hex());
            L2.append(']');
            return L2.toString();
        } else {
            StringBuilder L3 = a.L("[size=");
            L3.append(getData$okio().length);
            L3.append(" hex=");
            if (64 > getData$okio().length) {
                z = false;
            }
            if (z) {
                if (64 == getData$okio().length) {
                    byteString = this;
                } else {
                    byteString = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData$okio(), 0, 64));
                }
                L3.append(byteString.hex());
                L3.append("…]");
                return L3.toString();
            }
            throw new IllegalArgumentException(a.i(a.L("endIndex > length("), getData$okio().length, ')').toString());
        }
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        outputStream.write(this.c);
    }

    public void write$okio(@NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = -1
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (int min = Math.min(i, getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i >= 0 && i <= getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(getData$okio(), i, bArr, i2, i3);
    }

    public final boolean startsWith(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return rangeEquals(0, bArr, 0, bArr.length);
    }
}
