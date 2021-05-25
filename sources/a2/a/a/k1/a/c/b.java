package a2.a.a.k1.a.c;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Function1 a;

    public b(Function1 function1) {
        this.a = function1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(dialogInterface), "invoke(...)");
    }
}
