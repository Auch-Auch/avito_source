package a2.a.a.c2.c;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.add_phone.AddPhoneFragmentKt;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragmentKt;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<LandlinePhoneVerificationViewModel.RoutingAction> {
    public final /* synthetic */ LandlinePhoneVerificationFragment a;

    public a(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        this.a = landlinePhoneVerificationFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LandlinePhoneVerificationViewModel.RoutingAction routingAction) {
        String str;
        LandlinePhoneVerificationViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof LandlinePhoneVerificationViewModel.RoutingAction.GoToPhonesList) {
            LandlinePhoneVerificationViewModel.RoutingAction.GoToPhonesList goToPhonesList = (LandlinePhoneVerificationViewModel.RoutingAction.GoToPhonesList) routingAction2;
            int ordinal = goToPhonesList.getStatus().ordinal();
            if (ordinal == 0) {
                str = this.a.getString(R.string.f6onfirm_phone_success, goToPhonesList.getPhone());
            } else if (ordinal == 1) {
                str = this.a.getString(R.string.f4onfirm_phone_cancel, goToPhonesList.getPhone());
            } else if (ordinal == 2) {
                str = this.a.getString(R.string.f5onfirm_phone_manual, goToPhonesList.getPhone());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(str, "when (it.status) {\n     …ne)\n                    }");
            LandlinePhoneVerificationFragment landlinePhoneVerificationFragment = this.a;
            Intent intent = new Intent();
            intent.putExtra(AddPhoneFragmentKt.EXTRA_PHONE, goToPhonesList.getPhone());
            intent.putExtra(LandlinePhoneVerificationFragmentKt.EXTRA_RESULT_STATUS, goToPhonesList.getStatus());
            intent.putExtra("result_message", str);
            landlinePhoneVerificationFragment.setResult(-1, intent);
            this.a.finish();
        } else if (routingAction2 instanceof LandlinePhoneVerificationViewModel.RoutingAction.GoBack) {
            TabBaseFragment.setResult$default(this.a, 0, null, 2, null);
            this.a.finish();
        } else if (routingAction2 instanceof LandlinePhoneVerificationViewModel.RoutingAction.GoToHelpCenter) {
            LandlinePhoneVerificationFragment landlinePhoneVerificationFragment2 = this.a;
            landlinePhoneVerificationFragment2.startActivity(landlinePhoneVerificationFragment2.getActivityIntentFactory().helpCenterIntent(((LandlinePhoneVerificationViewModel.RoutingAction.GoToHelpCenter) routingAction2).getPath()));
        }
    }
}
