package a2.a.a.q0;

import android.content.DialogInterface;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class o implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public o(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.v.onPhoneCallCanceled();
    }
}
