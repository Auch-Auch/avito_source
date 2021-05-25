package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007*@\u0010\t\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\"\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b2\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0002*(\u0010\n\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u000b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/Kind;", "Larrow/core/ForEither;", "Larrow/core/EitherOf;", "Larrow/core/Either;", "fix", "(Larrow/Kind;)Larrow/core/Either;", "Larrow/Kind2;", "EitherOf", "EitherPartialOf", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class Higherkind_arrow_core_EitherKt {
    @NotNull
    public static final <A, B> Either<A, B> fix(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return (Either) kind;
    }
}
