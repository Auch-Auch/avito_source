package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.component.ads.yandex.AdYandexAppInstallViewHolder;
import com.avito.android.component.ads.yandex.AdYandexAppInstallViewHolderImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.ui_components.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolder;", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallBannerItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", "getPresenter", "()Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolderImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAppInstallSingleItemBlueprint implements ItemBlueprint<AdYandexAppInstallViewHolder, YandexAppInstallBannerItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdYandexAppInstallViewHolderImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.yandex_ad_app_install_single, a.a);
    @NotNull
    public final YandexAppInstallItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdYandexAppInstallViewHolderImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdYandexAppInstallViewHolderImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new AdYandexAppInstallViewHolderImpl(view2);
        }
    }

    @Inject
    public YandexAppInstallSingleItemBlueprint(@NotNull YandexAppInstallItemPresenter yandexAppInstallItemPresenter) {
        Intrinsics.checkNotNullParameter(yandexAppInstallItemPresenter, "presenter");
        this.b = yandexAppInstallItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdYandexAppInstallViewHolderImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof YandexAppInstallBannerItem) {
            YandexAppInstallBannerItem yandexAppInstallBannerItem = (YandexAppInstallBannerItem) item;
            if (yandexAppInstallBannerItem.getViewType() != SerpViewType.BIG && yandexAppInstallBannerItem.getDisplayType().isGrid()) {
                return true;
            }
        }
        return false;
    }

    /* Return type fixed from 'com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdYandexAppInstallViewHolder, YandexAppInstallBannerItem> getPresenter() {
        return this.b;
    }
}
