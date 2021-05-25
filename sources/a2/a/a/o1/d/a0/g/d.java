package a2.a.a.o1.d.a0.g;

import android.content.DialogInterface;
public final class d implements DialogInterface.OnCancelListener {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.b.getCloseListener().invoke();
    }
}
