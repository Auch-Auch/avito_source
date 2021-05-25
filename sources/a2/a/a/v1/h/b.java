package a2.a.a.v1.h;

import android.content.DialogInterface;
import com.avito.android.lastclick.LastClick;
import com.avito.android.phone_confirmation.view.PhoneConfirmationView;
import kotlin.Unit;
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ PhoneConfirmationView.g a;

    public b(PhoneConfirmationView.g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LastClick.Updater.update();
        this.a.a.h.accept(Unit.INSTANCE);
    }
}
