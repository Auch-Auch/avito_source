package a2.a.a.t2;

import androidx.lifecycle.Observer;
import com.avito.android.AuthIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.ShopSettingsFragment;
import kotlin.Unit;
public final class m<T> implements Observer<Unit> {
    public final /* synthetic */ ShopSettingsFragment a;

    public m(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        this.a.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(this.a.getActivityIntentFactory(), null, AuthSource.TEST_3, null, 5, null), 4815);
    }
}
