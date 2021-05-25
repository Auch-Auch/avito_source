package a2.a.a.a.b.a;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class a implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public a(Function1 function1) {
        this.a = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(view), "invoke(...)");
    }
}
