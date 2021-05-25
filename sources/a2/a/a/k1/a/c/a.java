package a2.a.a.k1.a.c;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class a implements DialogInterface.OnCancelListener {
    public final /* synthetic */ Function1 a;

    public a(Function1 function1) {
        this.a = function1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(dialogInterface), "invoke(...)");
    }
}
