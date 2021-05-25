package a2.a.a.b2.h1.a;

import android.content.DialogInterface;
import com.avito.android.profile.sessions.list.SessionLogoutConfirmationViewImpl;
import kotlin.Unit;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SessionLogoutConfirmationViewImpl a;

    public a(SessionLogoutConfirmationViewImpl sessionLogoutConfirmationViewImpl) {
        this.a = sessionLogoutConfirmationViewImpl;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.a = null;
        SessionLogoutConfirmationViewImpl.access$clearViews(this.a);
        this.a.e.accept(Unit.INSTANCE);
    }
}
