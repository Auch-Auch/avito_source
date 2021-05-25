package kotlin.text;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\b\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\n\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0013\u0010\r\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lkotlin/text/Charsets;", "", "Ljava/nio/charset/Charset;", AuthSource.BOOKING_ORDER, "Ljava/nio/charset/Charset;", "utf_32le", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF32_LE", "UTF_32LE", "UTF_16LE", "UTF32_BE", "UTF_32BE", "US_ASCII", AuthSource.SEND_ABUSE, "utf_32", "ISO_8859_1", "UTF_16BE", "c", "utf_32be", "UTF_8", "UTF_16", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class Charsets {
    @NotNull
    public static final Charsets INSTANCE = new Charsets();
    @JvmField
    @NotNull
    public static final Charset ISO_8859_1;
    @JvmField
    @NotNull
    public static final Charset US_ASCII;
    @JvmField
    @NotNull
    public static final Charset UTF_16;
    @JvmField
    @NotNull
    public static final Charset UTF_16BE;
    @JvmField
    @NotNull
    public static final Charset UTF_16LE;
    @JvmField
    @NotNull
    public static final Charset UTF_8;
    public static Charset a;
    public static Charset b;
    public static Charset c;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-8\")");
        UTF_8 = forName;
        Charset forName2 = Charset.forName(C.UTF16_NAME);
        Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(\"UTF-16\")");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(forName3, "Charset.forName(\"UTF-16BE\")");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName(C.UTF16LE_NAME);
        Intrinsics.checkNotNullExpressionValue(forName4, "Charset.forName(\"UTF-16LE\")");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName(C.ASCII_NAME);
        Intrinsics.checkNotNullExpressionValue(forName5, "Charset.forName(\"US-ASCII\")");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName6, "Charset.forName(\"ISO-8859-1\")");
        ISO_8859_1 = forName6;
    }

    @JvmName(name = "UTF32")
    @NotNull
    public final Charset UTF32() {
        Charset charset = a;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32\")");
        a = forName;
        return forName;
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    public final Charset UTF32_BE() {
        Charset charset = c;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32BE\")");
        c = forName;
        return forName;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    public final Charset UTF32_LE() {
        Charset charset = b;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-32LE\")");
        b = forName;
        return forName;
    }
}
