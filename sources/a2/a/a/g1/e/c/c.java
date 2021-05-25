package a2.a.a.g1.e.c;

import android.content.DialogInterface;
import android.view.View;
import kotlin.jvm.functions.Function0;
public final class c implements DialogInterface.OnCancelListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;

    public c(View view, Function0 function0) {
        this.a = view;
        this.b = function0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.b.invoke();
    }
}
