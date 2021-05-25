package s6.a.f;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.functions.Function2;
public final class b implements BiFunction {
    public final /* synthetic */ Function2 a;

    public b(Function2 function2) {
        this.a = function2;
    }

    /* JADX WARN: Failed to parse method signature: (TT1TT2)TR */
    @Override // io.reactivex.functions.BiFunction
    @NonNull
    public final /* synthetic */ Object apply(@NonNull Object obj, @NonNull Object obj2) {
        return this.a.invoke(obj, obj2);
    }
}
