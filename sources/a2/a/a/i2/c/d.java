package a2.a.a.i2.c;

import androidx.lifecycle.Observer;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
public final class d<T> implements Observer<String> {
    public final /* synthetic */ ProfileDeliverySettingsFragment a;

    public d(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        this.a = profileDeliverySettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 == null) {
            ProfileDeliverySettingsFragment.access$getProgressOverlay$p(this.a).showContent();
            return;
        }
        ProfileDeliverySettingsFragment.access$getProgressOverlay$p(this.a).showLoadingProblem(str2);
        ProfileDeliverySettingsFragment.access$getProgressOverlay$p(this.a).setOnRefreshListener(new c(this));
    }
}
