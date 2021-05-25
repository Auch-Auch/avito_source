package com.avito.android.shop_settings.blueprints.form_title;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service_subscription.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemView;", "Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "", AuthSource.SEND_ABUSE, "I", "layoutId", "Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemPresenter;", "c", "Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemPresenter;", "getPresenter", "()Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/shop_settings/blueprints/form_title/ShopSettingsFormTitleItemPresenter;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsFormTitleItemBlueprint implements ItemBlueprint<ShopSettingsFormTitleItemView, ShopSettingsFormTitleItem> {
    public final int a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ShopSettingsFormTitleItemViewImpl> b;
    @NotNull
    public final ShopSettingsFormTitleItemPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ShopSettingsFormTitleItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ShopSettingsFormTitleItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ShopSettingsFormTitleItemViewImpl(view2);
        }
    }

    @Inject
    public ShopSettingsFormTitleItemBlueprint(@NotNull ShopSettingsFormTitleItemPresenter shopSettingsFormTitleItemPresenter) {
        Intrinsics.checkNotNullParameter(shopSettingsFormTitleItemPresenter, "presenter");
        this.c = shopSettingsFormTitleItemPresenter;
        int i = R.layout.shop_settings_form_title;
        this.a = i;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(i, a.a);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ShopSettingsFormTitleItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShopSettingsFormTitleItem;
    }

    /* Return type fixed from 'com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ShopSettingsFormTitleItemView, ShopSettingsFormTitleItem> getPresenter() {
        return this.c;
    }
}
