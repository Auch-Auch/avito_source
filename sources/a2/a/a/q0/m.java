package a2.a.a.q0;

import android.content.DialogInterface;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExtendedProfileViewImpl a;
    public final /* synthetic */ PhoneLink.Call b;

    public m(ExtendedProfileViewImpl extendedProfileViewImpl, PhoneLink.Call call) {
        this.a = extendedProfileViewImpl;
        this.b = call;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.v.onPhoneCallConfirmed(this.b);
    }
}
