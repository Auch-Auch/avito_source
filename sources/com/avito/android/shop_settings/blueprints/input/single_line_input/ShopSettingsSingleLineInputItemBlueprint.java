package com.avito.android.shop_settings.blueprints.input.single_line_input;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenter;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/single_line_input/ShopSettingsSingleLineInputItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemView;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "", AuthSource.SEND_ABUSE, "I", "layoutId", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/shop_settings/blueprints/input/single_line_input/ShopSettingsSingleLineInputItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenter;", "c", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenter;", "getPresenter", "()Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenter;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSingleLineInputItemBlueprint implements ItemBlueprint<ShopSettingsInputItemView, ShopSettingsInputItem> {
    public final int a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ShopSettingsSingleLineInputItemViewImpl> b;
    @NotNull
    public final ShopSettingsInputItemPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ShopSettingsSingleLineInputItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ShopSettingsSingleLineInputItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ShopSettingsSingleLineInputItemViewImpl(view2);
        }
    }

    @Inject
    public ShopSettingsSingleLineInputItemBlueprint(@NotNull ShopSettingsInputItemPresenter shopSettingsInputItemPresenter) {
        Intrinsics.checkNotNullParameter(shopSettingsInputItemPresenter, "presenter");
        this.c = shopSettingsInputItemPresenter;
        int i = R.layout.shop_settings_single_line_input;
        this.a = i;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(i, a.a);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ShopSettingsSingleLineInputItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShopSettingsSingleLineInputItem;
    }

    /* Return type fixed from 'com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ShopSettingsInputItemView, ShopSettingsInputItem> getPresenter() {
        return this.c;
    }
}
