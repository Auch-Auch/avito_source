package a2.a.a.t2;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.shop_settings.ShopSettingsSaveButtonData;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Observer<ShopSettingsSaveButtonData> {
    public final /* synthetic */ ShopSettingsFragment a;

    public l(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ShopSettingsSaveButtonData shopSettingsSaveButtonData) {
        ShopSettingsSaveButtonData shopSettingsSaveButtonData2 = shopSettingsSaveButtonData;
        if (shopSettingsSaveButtonData2 != null) {
            ViewGroup.LayoutParams layoutParams = ShopSettingsFragment.access$getSaveButton$p(this.a).getLayoutParams();
            if (!shopSettingsSaveButtonData2.isVisible() || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ShopSettingsFragment.access$hideSaveButton(this.a);
                Views.changePadding$default(ShopSettingsFragment.access$getRecyclerView$p(this.a), 0, 0, 0, 0, 7, null);
                return;
            }
            ShopSettingsFragment.access$showSaveButton(this.a);
            ShopSettingsFragment.access$getSaveButton$p(this.a).setText(shopSettingsSaveButtonData2.getTitle());
            ShopSettingsFragment.access$getSaveButton$p(this.a).setLoading(shopSettingsSaveButtonData2.isLoading());
            CompositeDisposable compositeDisposable = this.a.i;
            Disposable subscribe = RxView.layoutChangeEvents(ShopSettingsFragment.access$getSaveButton$p(this.a)).take(1).map(i.a).startWith((Observable<R>) ((R) Unit.INSTANCE)).subscribe(new j(this, layoutParams), k.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "saveButton\n             …) }\n                    )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }
}
