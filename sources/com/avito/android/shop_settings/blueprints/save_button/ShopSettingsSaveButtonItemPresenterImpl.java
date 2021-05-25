package com.avito.android.shop_settings.blueprints.save_button;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.di.SaveButtonClick;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItemPresenterImpl;", "Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItemPresenter;", "Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItemView;", "view", "Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItemView;Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "saveButtonClickListener", "<init>", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSaveButtonItemPresenterImpl implements ShopSettingsSaveButtonItemPresenter {
    public final PublishRelay<Unit> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopSettingsSaveButtonItemPresenterImpl a;
        public final /* synthetic */ ShopSettingsSaveButtonItem b;
        public final /* synthetic */ ShopSettingsSaveButtonItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsSaveButtonItemPresenterImpl shopSettingsSaveButtonItemPresenterImpl, ShopSettingsSaveButtonItem shopSettingsSaveButtonItem, ShopSettingsSaveButtonItemView shopSettingsSaveButtonItemView) {
            super(0);
            this.a = shopSettingsSaveButtonItemPresenterImpl;
            this.b = shopSettingsSaveButtonItem;
            this.c = shopSettingsSaveButtonItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.setLoading(true);
            this.c.setLoading(true);
            PublishRelay publishRelay = this.a.a;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    @Inject
    public ShopSettingsSaveButtonItemPresenterImpl(@SaveButtonClick @NotNull PublishRelay<Unit> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "saveButtonClickListener");
        this.a = publishRelay;
    }

    public void bindView(@NotNull ShopSettingsSaveButtonItemView shopSettingsSaveButtonItemView, @NotNull ShopSettingsSaveButtonItem shopSettingsSaveButtonItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsSaveButtonItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsSaveButtonItem, "item");
        shopSettingsSaveButtonItemView.setTitle(shopSettingsSaveButtonItem.getTitle());
        shopSettingsSaveButtonItemView.setLoading(shopSettingsSaveButtonItem.isLoading());
        shopSettingsSaveButtonItemView.setEnabled(shopSettingsSaveButtonItem.isEnabled());
        shopSettingsSaveButtonItemView.setOnClickListener(new a(this, shopSettingsSaveButtonItem, shopSettingsSaveButtonItemView));
    }
}
