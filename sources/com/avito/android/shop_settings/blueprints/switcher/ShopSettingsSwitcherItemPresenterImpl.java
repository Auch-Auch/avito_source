package com.avito.android.shop_settings.blueprints.switcher;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemPresenterImpl;", "Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemPresenter;", "Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemView;", "view", "Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemView;Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItem;I)V", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSwitcherItemPresenterImpl implements ShopSettingsSwitcherItemPresenter {

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ ShopSettingsSwitcherItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsSwitcherItem shopSettingsSwitcherItem) {
            super(1);
            this.a = shopSettingsSwitcherItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.setEnabled(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public void bindView(@NotNull ShopSettingsSwitcherItemView shopSettingsSwitcherItemView, @NotNull ShopSettingsSwitcherItem shopSettingsSwitcherItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsSwitcherItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsSwitcherItem, "item");
        shopSettingsSwitcherItemView.setValueChangeListener(null);
        shopSettingsSwitcherItemView.setTitle(shopSettingsSwitcherItem.getTitle());
        shopSettingsSwitcherItemView.setMessage(shopSettingsSwitcherItem.getSubtitle());
        shopSettingsSwitcherItemView.setEnabled(shopSettingsSwitcherItem.isModifiable());
        shopSettingsSwitcherItemView.setValue(shopSettingsSwitcherItem.isEnabled());
        shopSettingsSwitcherItemView.setValueChangeListener(new a(shopSettingsSwitcherItem));
    }
}
