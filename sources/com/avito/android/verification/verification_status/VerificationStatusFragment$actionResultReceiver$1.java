package com.avito.android.verification.verification_status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/avito/android/verification/verification_status/VerificationStatusFragment$actionResultReceiver$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusFragment$actionResultReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ VerificationStatusFragment a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public VerificationStatusFragment$actionResultReceiver$1(VerificationStatusFragment verificationStatusFragment) {
        this.a = verificationStatusFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        VerificationActionActivity.Result resultFrom = VerificationActionActivity.Companion.getResultFrom(intent);
        boolean component1 = resultFrom.component1();
        String component2 = resultFrom.component2();
        DeepLink component3 = resultFrom.component3();
        if (component2 == null) {
            return;
        }
        if (component1) {
            this.a.getViewModel$verification_release().loadVerificationStatus(this.a.a(), new VerificationStatusViewModel.Message(false, component2, null, 4, null));
        } else {
            this.a.getViewModel$verification_release().showMessage(new VerificationStatusViewModel.Message(true, component2, component3));
        }
    }
}
