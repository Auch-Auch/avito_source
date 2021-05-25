package a2.a.a.r3.a;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PassportVerificationLink;
import com.avito.android.deep_linking.links.ProfileLink;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Observer<VerificationStatusViewModel.RouterAction> {
    public final /* synthetic */ VerificationStatusFragment a;

    public c(VerificationStatusFragment verificationStatusFragment) {
        this.a = verificationStatusFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VerificationStatusViewModel.RouterAction routerAction) {
        VerificationStatusViewModel.RouterAction routerAction2 = routerAction;
        if (routerAction2 instanceof VerificationStatusViewModel.RouterAction.DeepLinkAction) {
            VerificationStatusViewModel.RouterAction.DeepLinkAction deepLinkAction = (VerificationStatusViewModel.RouterAction.DeepLinkAction) routerAction2;
            DeepLink deepLink = deepLinkAction.getDeepLink();
            if (deepLink instanceof ProfileLink) {
                FragmentActivity requireActivity = this.a.requireActivity();
                if (!(requireActivity instanceof VerificationStatusFragment.VerificationsStatusRouter)) {
                    requireActivity = null;
                }
                VerificationStatusFragment.VerificationsStatusRouter verificationsStatusRouter = (VerificationStatusFragment.VerificationsStatusRouter) requireActivity;
                if (verificationsStatusRouter != null) {
                    verificationsStatusRouter.closeActivity();
                }
            } else if (deepLink instanceof PassportVerificationLink) {
                VerificationStatusFragment verificationStatusFragment = this.a;
                verificationStatusFragment.startActivityForResult(verificationStatusFragment.getDeepLinkIntentFactory$verification_release().getIntent(deepLinkAction.getDeepLink()), 1);
            } else {
                Intent intent = this.a.getDeepLinkIntentFactory$verification_release().getIntent(deepLinkAction.getDeepLink());
                if (intent != null) {
                    this.a.startActivity(intent);
                }
            }
        } else if (routerAction2 instanceof VerificationStatusViewModel.RouterAction.UrlLinkAction) {
            VerificationStatusFragment verificationStatusFragment2 = this.a;
            ImplicitIntentFactory implicitIntentFactory = verificationStatusFragment2.getImplicitIntentFactory();
            Uri parse = Uri.parse(((VerificationStatusViewModel.RouterAction.UrlLinkAction) routerAction2).getUrl());
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it.url)");
            verificationStatusFragment2.startActivity(implicitIntentFactory.uriIntent(parse));
        }
    }
}
