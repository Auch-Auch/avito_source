package a2.a.a.r3.a;

import androidx.lifecycle.Observer;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
public final class b<T> implements Observer<VerificationStatusViewModel.State> {
    public final /* synthetic */ VerificationStatusFragment a;

    public b(VerificationStatusFragment verificationStatusFragment) {
        this.a = verificationStatusFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VerificationStatusViewModel.State state) {
        VerificationStatusViewModel.State state2 = state;
        if (state2 instanceof VerificationStatusViewModel.State.Loaded) {
            VerificationStatusFragment.access$getVerificationView$p(this.a).setContent(((VerificationStatusViewModel.State.Loaded) state2).getScreenData());
            VerificationStatusFragment.access$getVerificationView$p(this.a).showContent();
        } else if (state2 instanceof VerificationStatusViewModel.State.Loading) {
            VerificationStatusFragment.access$getVerificationView$p(this.a).showLoading();
        } else if (state2 instanceof VerificationStatusViewModel.State.Error) {
            VerificationStatusFragment.access$getVerificationView$p(this.a).showError(((VerificationStatusViewModel.State.Error) state2).getMessage());
        }
    }
}
