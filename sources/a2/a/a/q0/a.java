package a2.a.a.q0;

import android.app.Dialog;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class a implements Runnable {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public a(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Dialog dialog = this.a.n;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.a.n = null;
    }
}
