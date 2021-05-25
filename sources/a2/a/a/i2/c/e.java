package a2.a.a.i2.c;

import androidx.lifecycle.Observer;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
public final class e<T> implements Observer<Integer> {
    public final /* synthetic */ ProfileDeliverySettingsFragment a;

    public e(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        this.a = profileDeliverySettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        if (num2 != null) {
            num2.intValue();
            this.a.requireActivity().setResult(num2.intValue());
        }
    }
}
