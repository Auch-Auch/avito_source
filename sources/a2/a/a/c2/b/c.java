package a2.a.a.c2.b;

import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Observer<ConfirmPhoneViewModel.CodeRequestState> {
    public final /* synthetic */ ConfirmPhoneFragment a;

    public c(ConfirmPhoneFragment confirmPhoneFragment) {
        this.a = confirmPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ConfirmPhoneViewModel.CodeRequestState codeRequestState) {
        ConfirmPhoneViewModel.CodeRequestState codeRequestState2 = codeRequestState;
        if (Intrinsics.areEqual(codeRequestState2, ConfirmPhoneViewModel.CodeRequestState.CodeRequestInProgress.INSTANCE)) {
            ConfirmPhoneFragment.access$getTickerButton$p(this.a).setLoading(true);
        } else if (Intrinsics.areEqual(codeRequestState2, ConfirmPhoneViewModel.CodeRequestState.CodeRequestEnabled.INSTANCE)) {
            ConfirmPhoneFragment.access$getTickerButton$p(this.a).setLoading(false);
        } else if (codeRequestState2 instanceof ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone) {
            ConfirmPhoneFragment.access$getTickerButton$p(this.a).setLoading(false);
            ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone codeRequestDone = (ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone) codeRequestState2;
            ConfirmPhoneFragment.access$getTickerButton$p(this.a).startTicking(codeRequestDone.getTimeoutSeconds());
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setMaxLength(codeRequestDone.getCodeLength());
        }
    }
}
