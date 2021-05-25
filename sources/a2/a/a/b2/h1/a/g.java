package a2.a.a.b2.h1.a;

import android.content.DialogInterface;
import com.avito.android.profile.sessions.list.SessionsMenuViewImpl;
public final class g implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SessionsMenuViewImpl a;

    public g(SessionsMenuViewImpl sessionsMenuViewImpl) {
        this.a = sessionsMenuViewImpl;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.b = null;
        this.a.c = null;
        SessionsMenuViewImpl.access$clearViews(this.a);
        this.a.k.clear();
    }
}
