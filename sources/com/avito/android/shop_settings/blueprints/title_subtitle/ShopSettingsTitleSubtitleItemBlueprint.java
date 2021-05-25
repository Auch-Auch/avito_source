package com.avito.android.shop_settings.blueprints.title_subtitle;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemView;", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemPresenter;", "c", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemPresenter;", "getPresenter", "()Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemPresenter;", "presenter", "", AuthSource.SEND_ABUSE, "I", "layoutId", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/shop_settings/blueprints/title_subtitle/ShopSettingsTitleSubtitleItemPresenter;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsTitleSubtitleItemBlueprint implements ItemBlueprint<ShopSettingsTitleSubtitleItemView, ShopSettingsTitleSubtitleItem> {
    public final int a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ShopSettingsTitleSubtitleItemViewImpl> b;
    @NotNull
    public final ShopSettingsTitleSubtitleItemPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ShopSettingsTitleSubtitleItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ShopSettingsTitleSubtitleItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ShopSettingsTitleSubtitleItemViewImpl(view2);
        }
    }

    @Inject
    public ShopSettingsTitleSubtitleItemBlueprint(@NotNull ShopSettingsTitleSubtitleItemPresenter shopSettingsTitleSubtitleItemPresenter) {
        Intrinsics.checkNotNullParameter(shopSettingsTitleSubtitleItemPresenter, "presenter");
        this.c = shopSettingsTitleSubtitleItemPresenter;
        int i = R.layout.shop_settings_title_subtitle;
        this.a = i;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(i, a.a);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ShopSettingsTitleSubtitleItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShopSettingsTitleSubtitleItem;
    }

    /* Return type fixed from 'com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ShopSettingsTitleSubtitleItemView, ShopSettingsTitleSubtitleItem> getPresenter() {
        return this.c;
    }
}
