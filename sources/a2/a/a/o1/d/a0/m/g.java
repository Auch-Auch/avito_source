package a2.a.a.o1.d.a0.m;

import android.content.DialogInterface;
import kotlin.Unit;
public final class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a.getAttachmentDialogDismissedStream().accept(Unit.INSTANCE);
    }
}
