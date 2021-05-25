package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForId;", "Larrow/core/IdOf;", "value", "(Larrow/Kind;)Ljava/lang/Object;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class IdKt {
    public static final <A> A value(@NotNull Kind<ForId, ? extends A> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return (A) ((Id) kind).getValue();
    }
}
