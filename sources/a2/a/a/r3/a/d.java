package a2.a.a.r3.a;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import com.avito.android.verification.verification_status.VerificationStatusView;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
public final class d<T> implements Observer<VerificationStatusViewModel.Message> {
    public final /* synthetic */ VerificationStatusFragment a;

    public d(VerificationStatusFragment verificationStatusFragment) {
        this.a = verificationStatusFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VerificationStatusViewModel.Message message) {
        VerificationStatusViewModel.Message message2 = message;
        if (message2.isError()) {
            VerificationStatusView access$getVerificationView$p = VerificationStatusFragment.access$getVerificationView$p(this.a);
            String message3 = message2.getMessage();
            DeepLink action = message2.getAction();
            access$getVerificationView$p.showErrorAlert(message3, action != null ? VerificationStatusFragment.access$createRetryCallback(this.a, action) : null);
            return;
        }
        VerificationStatusFragment.access$getVerificationView$p(this.a).showAlert(message2.getMessage());
    }
}
