package okio;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lokio/-DeprecatedUtf8;", AuthSource.BOOKING_ORDER, "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "Utf8", "Lokio/-DeprecatedOkio;", AuthSource.SEND_ABUSE, "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Okio", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-DeprecatedUpgrade")
/* renamed from: okio.-DeprecatedUpgrade  reason: invalid class name */
public final class DeprecatedUpgrade {
    @NotNull
    public static final DeprecatedOkio a = DeprecatedOkio.INSTANCE;
    @NotNull
    public static final DeprecatedUtf8 b = DeprecatedUtf8.INSTANCE;

    @NotNull
    public static final DeprecatedOkio getOkio() {
        return a;
    }

    @NotNull
    public static final DeprecatedUtf8 getUtf8() {
        return b;
    }
}
