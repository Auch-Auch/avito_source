package a2.a.a.n3.w;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;
public final class a implements Function {
    public final /* synthetic */ Function1 a;

    public a(Function1 function1) {
        this.a = function1;
    }

    @Override // androidx.arch.core.util.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.a.invoke(obj);
    }
}
