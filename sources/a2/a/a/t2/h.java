package a2.a.a.t2;

import androidx.lifecycle.Observer;
import com.avito.android.shop_settings.ShopSettingsFragment;
public final class h<T> implements Observer<Integer> {
    public final /* synthetic */ ShopSettingsFragment a;

    public h(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        if (num2 != null) {
            num2.intValue();
            ShopSettingsFragment.access$getRecyclerView$p(this.a).smoothScrollToPosition(num2.intValue());
        }
    }
}
