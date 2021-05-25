package com.avito.android.brandspace.items.adverts;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.AdvertItemLayout;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.avito.android.serp.adapter.RdsAdvertItemViewImpl;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/items/adverts/AdvertItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/RdsAdvertItemView;", "Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/RdsAdvertItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "c", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "viewConfig", "Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", "getPresenter", "()Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", "presenter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemBlueprint implements ItemBlueprint<RdsAdvertItemView, BrandspaceAdvertItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> a;
    @NotNull
    public final AdvertItemPresenter b;
    public final SerpItemAbViewConfig c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RdsAdvertItemViewImpl> {
        public final /* synthetic */ AdvertItemBlueprint a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ Locale c;
        public final /* synthetic */ ConnectivityProvider d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertItemBlueprint advertItemBlueprint, TimeSource timeSource, Locale locale, ConnectivityProvider connectivityProvider) {
            super(2);
            this.a = advertItemBlueprint;
            this.b = timeSource;
            this.c = locale;
            this.d = connectivityProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public RdsAdvertItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            RdsAdvertItemViewImpl rdsAdvertItemViewImpl = new RdsAdvertItemViewImpl(view2, this.b, this.c, this.d);
            if (this.a.c.isPriceOnTop()) {
                View findViewById = view2.findViewById(R.id.item_root);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.serp.AdvertItemLayout");
                ((AdvertItemLayout) findViewById).swapPriceAndTitle();
            }
            return rdsAdvertItemViewImpl;
        }
    }

    @Inject
    public AdvertItemBlueprint(@NotNull AdvertItemPresenter advertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(advertItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.b = advertItemPresenter;
        this.c = serpItemAbViewConfig;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.rds_advert_item_grid, new a(this, timeSource, locale, connectivityProvider));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof BrandspaceAdvertItem;
    }

    /* Return type fixed from 'com.avito.android.brandspace.items.adverts.AdvertItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RdsAdvertItemView, BrandspaceAdvertItem> getPresenter() {
        return this.b;
    }
}
