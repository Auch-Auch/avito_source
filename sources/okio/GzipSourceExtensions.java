package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Source;", "Lokio/GzipSource;", "gzip", "(Lokio/Source;)Lokio/GzipSource;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
public final class GzipSourceExtensions {
    public static final boolean access$getBit(int i, int i2) {
        return ((i >> i2) & 1) == 1;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "$this$gzip");
        return new GzipSource(source);
    }
}
