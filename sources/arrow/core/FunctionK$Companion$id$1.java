package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ6\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"arrow/core/FunctionK$Companion$id$1", "Larrow/core/FunctionK;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "fa", "invoke", "(Larrow/Kind;)Larrow/Kind;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class FunctionK$Companion$id$1 implements FunctionK<F, F> {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.Kind<? extends F, ? extends A> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // arrow.core.FunctionK
    @NotNull
    public <A> Kind<F, A> invoke(@NotNull Kind<? extends F, ? extends A> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "fa");
        return kind;
    }
}
