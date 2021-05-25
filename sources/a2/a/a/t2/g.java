package a2.a.a.t2;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.model.ShopSettingsConfirmation;
import com.avito.android.shop_settings.ShopSettingsFragment;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Observer<ShopSettingsConfirmation> {
    public final /* synthetic */ ShopSettingsFragment a;

    public g(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ShopSettingsConfirmation shopSettingsConfirmation) {
        FragmentActivity activity;
        ShopSettingsConfirmation shopSettingsConfirmation2 = shopSettingsConfirmation;
        if (shopSettingsConfirmation2 != null && (activity = this.a.getActivity()) != null) {
            Dialog.Companion companion = Dialog.Companion;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Dialog.Companion.create$default(companion, activity, 0, 0, new f(shopSettingsConfirmation2), 6, null).show();
        }
    }
}
