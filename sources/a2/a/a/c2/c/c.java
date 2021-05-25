package a2.a.a.c2.c;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
import t6.y.m;
public final class c<T> implements Observer<LandlinePhoneVerificationViewModel.Event> {
    public final /* synthetic */ LandlinePhoneVerificationFragment a;

    public c(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        this.a = landlinePhoneVerificationFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LandlinePhoneVerificationViewModel.Event event) {
        String str;
        LandlinePhoneVerificationViewModel.Event event2 = event;
        LandlinePhoneVerificationFragment.access$setLoadingState(this.a, false);
        if (event2.getMessage() == null) {
            Views.show(LandlinePhoneVerificationFragment.access$getCallOrderError$p(this.a));
            return;
        }
        if (m.isBlank(event2.getMessage())) {
            str = this.a.getString(R.string.phone_action_error);
        } else {
            str = event2.getMessage();
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (it.message.isBlank()…message\n                }");
        Context requireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        new Snackbar(requireContext, str).setType(SnackbarType.ERROR).show();
    }
}
