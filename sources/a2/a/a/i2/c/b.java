package a2.a.a.i2.c;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
import java.util.Objects;
public final class b<T> implements Observer<String> {
    public final /* synthetic */ ProfileDeliverySettingsFragment a;

    public b(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        this.a = profileDeliverySettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        View findViewById = ProfileDeliverySettingsFragment.access$getToolbar$p(this.a).findViewById(R.id.toolbar_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(str);
    }
}
