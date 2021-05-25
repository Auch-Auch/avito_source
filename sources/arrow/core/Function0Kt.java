package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a0\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Function0;", "Larrow/core/Function0;", "k", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Function0;", "Larrow/Kind;", "Larrow/core/ForFunction0;", "Larrow/core/Function0Of;", "invoke", "(Larrow/Kind;)Ljava/lang/Object;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class Function0Kt {
    public static final <A> A invoke(@NotNull Kind<ForFunction0, ? extends A> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return ((Function0) kind).getF$arrow_core().invoke();
    }

    @NotNull
    public static final <A> Function0<A> k(@NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        return new Function0<>(function0);
    }
}
