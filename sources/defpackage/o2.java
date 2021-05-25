package defpackage;

import android.view.View;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.util.Views;
/* compiled from: java-style lambda group */
/* renamed from: o2  reason: default package */
public final class o2 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public o2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            LandlinePhoneVerificationFragment.access$getViewModel$p((LandlinePhoneVerificationFragment) this.b).onManualCheckCancelClicked();
        } else if (i == 1) {
            LandlinePhoneVerificationFragment.access$getViewModel$p((LandlinePhoneVerificationFragment) this.b).onManualCheckAcceptClicked();
        } else if (i == 2) {
            LandlinePhoneVerificationFragment.access$getViewModel$p((LandlinePhoneVerificationFragment) this.b).onOkClicked();
        } else if (i == 3) {
            Views.hide(LandlinePhoneVerificationFragment.access$getCallOrderError$p((LandlinePhoneVerificationFragment) this.b));
            LandlinePhoneVerificationFragment.access$getViewModel$p((LandlinePhoneVerificationFragment) this.b).onCallOrderClicked();
        } else {
            throw null;
        }
    }
}
