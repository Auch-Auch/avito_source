package a2.a.a.i2.c;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.ToastsKt;
public final class a<T> implements Observer<DeepLink> {
    public final /* synthetic */ ProfileDeliverySettingsFragment a;

    public a(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        this.a = profileDeliverySettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 != null) {
            Intent intent = this.a.getDeepLinkIntentFactory().getIntent(deepLink2);
            if (intent == null) {
                ProfileDeliverySettingsFragment profileDeliverySettingsFragment = this.a;
                int i = R.string.no_application_installed_to_perform_this_action;
                Context context = profileDeliverySettingsFragment.getContext();
                if (context != null) {
                    ToastsKt.showToast(context, i, 0);
                }
            }
            this.a.startActivity(intent);
        }
    }
}
