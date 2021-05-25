package a2.a.a.o1.d.a0.m;

import android.content.DialogInterface;
import kotlin.Unit;
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h a;

    public f(h hVar) {
        this.a = hVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.a.getAttachmentDialogDismissedStream().accept(Unit.INSTANCE);
    }
}
