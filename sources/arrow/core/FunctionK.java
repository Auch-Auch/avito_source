package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\tJ6\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0002\u0010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Larrow/core/FunctionK;", "F", "G", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "fa", "invoke", "(Larrow/Kind;)Larrow/Kind;", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public interface FunctionK<F, G> {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0002\u0010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Larrow/core/FunctionK$Companion;", "", "F", "Larrow/core/FunctionK;", "id", "()Larrow/core/FunctionK;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <F> FunctionK<F, F> id() {
            return new FunctionK$Companion$id$1();
        }
    }

    @NotNull
    <A> Kind<G, A> invoke(@NotNull Kind<? extends F, ? extends A> kind);
}
