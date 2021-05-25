package com.avito.android.shop_settings_select.blueprints.shop_settings_selection;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItemPresenterImpl;", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItemPresenter;", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItemView;", "view", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItemView;Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getClicksObservable", "()Lio/reactivex/Observable;", "clicksObservable", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectionItemPresenterImpl implements ShopSettingsSelectionItemPresenter {
    public final PublishRelay<ShopSettingsSelectionItem> a;
    @NotNull
    public final Observable<ShopSettingsSelectionItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopSettingsSelectionItemPresenterImpl a;
        public final /* synthetic */ ShopSettingsSelectionItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsSelectionItemPresenterImpl shopSettingsSelectionItemPresenterImpl, ShopSettingsSelectionItem shopSettingsSelectionItem) {
            super(0);
            this.a = shopSettingsSelectionItemPresenterImpl;
            this.b = shopSettingsSelectionItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopSettingsSelectionItemPresenterImpl() {
        PublishRelay<ShopSettingsSelectionItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemPresenter
    @NotNull
    public Observable<ShopSettingsSelectionItem> getClicksObservable() {
        return this.b;
    }

    public void bindView(@NotNull ShopSettingsSelectionItemView shopSettingsSelectionItemView, @NotNull ShopSettingsSelectionItem shopSettingsSelectionItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectionItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsSelectionItem, "item");
        shopSettingsSelectionItemView.setTitle(shopSettingsSelectionItem.getTitle());
        shopSettingsSelectionItemView.setChecked(shopSettingsSelectionItem.isChecked());
        shopSettingsSelectionItemView.setOnClickListener(new a(this, shopSettingsSelectionItem));
    }
}
