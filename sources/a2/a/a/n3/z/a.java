package a2.a.a.n3.z;

import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Action {
    public final /* synthetic */ Function0 a;

    public a(Function0 function0) {
        this.a = function0;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
