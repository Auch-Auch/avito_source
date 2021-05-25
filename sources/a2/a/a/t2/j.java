package a2.a.a.t2;

import android.view.ViewGroup;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.util.Views;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class j<T> implements Consumer<Unit> {
    public final /* synthetic */ l a;
    public final /* synthetic */ ViewGroup.LayoutParams b;

    public j(l lVar, ViewGroup.LayoutParams layoutParams) {
        this.a = lVar;
        this.b = layoutParams;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        Views.changePadding$default(ShopSettingsFragment.access$getRecyclerView$p(this.a.a), 0, 0, 0, ShopSettingsFragment.access$getSaveButton$p(this.a.a).getHeight() + ((ViewGroup.MarginLayoutParams) this.b).bottomMargin, 7, null);
    }
}
