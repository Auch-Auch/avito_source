package s6.a.f;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function3;
public final class c implements Function3 {
    public final /* synthetic */ kotlin.jvm.functions.Function3 a;

    public c(kotlin.jvm.functions.Function3 function3) {
        this.a = function3;
    }

    /* JADX WARN: Failed to parse method signature: (TT1TT2TT3)TR */
    @Override // io.reactivex.functions.Function3
    @NonNull
    public final /* synthetic */ Object apply(@NonNull Object obj, @NonNull Object obj2, @NonNull Object obj3) {
        return this.a.invoke(obj, obj2, obj3);
    }
}
