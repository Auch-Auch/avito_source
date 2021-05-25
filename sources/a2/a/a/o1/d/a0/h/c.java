package a2.a.a.o1.d.a0.h;

import android.content.DialogInterface;
import kotlin.Unit;
public final class c implements DialogInterface.OnCancelListener {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a.getDismissStream().accept(Unit.INSTANCE);
    }
}
