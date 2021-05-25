package a2.a.a.o1.f;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
public final class a implements Function {
    public final /* synthetic */ Function1 a;

    public a(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(@NonNull Object obj) {
        return this.a.invoke(obj);
    }
}
