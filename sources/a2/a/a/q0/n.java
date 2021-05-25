package a2.a.a.q0;

import android.content.DialogInterface;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class n implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public n(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.v.onPhoneCallCanceled();
    }
}
