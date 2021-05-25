package a2.a.a.r3.a.k;

import android.content.Intent;
import com.avito.android.deep_linking.links.VerificationRemoveLink;
import com.avito.android.verification.VerificationActivityKt;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity;
import com.avito.android.verification.verification_status.actions.VerificationActionActivityKt;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ VerificationActionActivity.a a;
    public final /* synthetic */ VerificationActionViewModel.RouterAction b;

    public a(VerificationActionActivity.a aVar, VerificationActionViewModel.RouterAction routerAction) {
        this.a = aVar;
        this.b = routerAction;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VerificationActionActivity verificationActionActivity = this.a.a;
        Intent intent = new Intent();
        intent.setAction(VerificationActionActivityKt.INTENT_FILTER_ACTION_VERIFICATION_ACTION);
        intent.putExtra("result.status", ((VerificationActionViewModel.RouterAction.Close) this.b).getStatus());
        intent.putExtra("result.message", ((VerificationActionViewModel.RouterAction.Close) this.b).getMessage());
        String stringExtra = this.a.a.getIntent().getStringExtra(VerificationActivityKt.KEY_VERIFICATION_TYPE);
        Intrinsics.checkNotNull(stringExtra);
        intent.putExtra("result.action", new VerificationRemoveLink(stringExtra));
        Unit unit = Unit.INSTANCE;
        verificationActionActivity.sendBroadcast(intent);
    }
}
