package a2.a.a.c2.c;

import android.content.Context;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<LandlinePhoneVerificationViewModel.ScreenState> {
    public final /* synthetic */ LandlinePhoneVerificationFragment a;

    public b(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        this.a = landlinePhoneVerificationFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LandlinePhoneVerificationViewModel.ScreenState screenState) {
        LandlinePhoneVerificationViewModel.ScreenState screenState2 = screenState;
        if (Intrinsics.areEqual(screenState2, LandlinePhoneVerificationViewModel.ScreenState.Loading.INSTANCE)) {
            LandlinePhoneVerificationFragment.access$setLoadingState(this.a, true);
        } else if (screenState2 instanceof LandlinePhoneVerificationViewModel.ScreenState.Ok) {
            LandlinePhoneVerificationFragment.access$setLoadingState(this.a, false);
            LandlinePhoneVerificationViewModel.ScreenState.Ok ok = (LandlinePhoneVerificationViewModel.ScreenState.Ok) screenState2;
            LandlinePhoneVerificationFragment.access$getAppBarLayout$p(this.a).setTitle(ok.getTitle());
            LandlinePhoneVerificationFragment.access$getAppBarLayout$p(this.a).setShortTitle(ok.getTitle());
            LandlinePhoneVerificationFragment.access$getSubtitle$p(this.a).setText(ok.getSubtitle());
            TextView access$getDescription$p = LandlinePhoneVerificationFragment.access$getDescription$p(this.a);
            AttributedTextFormatter attributedTextFormatter = this.a.getAttributedTextFormatter();
            Context requireContext = this.a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            access$getDescription$p.setText(attributedTextFormatter.format(requireContext, ok.getDescription()));
            LandlinePhoneVerificationFragment.access$getActionContainer$p(this.a).setDisplayedChild(ok.getAction().getIndex());
        }
    }
}
