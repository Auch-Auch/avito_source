package com.avito.android.similar_adverts.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.AdvertItemLayout;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.avito.android.serp.adapter.RdsAdvertItemViewImpl;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprintImpl;", "Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "c", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/RdsAdvertItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "e", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Ljava/lang/Class;", "Lcom/avito/android/serp/adapter/AdvertItem;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "relevantClass", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "d", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "viewConfig", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertBlueprintImpl implements SimilarAdvertBlueprint {
    public final Class<AdvertItem> a = AdvertItem.class;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> b;
    @NotNull
    public final RdsAdvertItemPresenter c;
    public final SerpItemAbViewConfig d;
    public final ConnectivityProvider e;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RdsAdvertItemViewImpl> {
        public final /* synthetic */ SimilarAdvertBlueprintImpl a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ Locale c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SimilarAdvertBlueprintImpl similarAdvertBlueprintImpl, TimeSource timeSource, Locale locale) {
            super(2);
            this.a = similarAdvertBlueprintImpl;
            this.b = timeSource;
            this.c = locale;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public RdsAdvertItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            RdsAdvertItemViewImpl rdsAdvertItemViewImpl = new RdsAdvertItemViewImpl(view2, this.b, this.c, this.a.e);
            View findViewById = view2.findViewById(R.id.date);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (this.a.d.isPriceOnTop()) {
                View findViewById2 = view2.findViewById(R.id.item_root);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.serp.AdvertItemLayout");
                ((AdvertItemLayout) findViewById2).swapPriceAndTitle();
            }
            return rdsAdvertItemViewImpl;
        }
    }

    @Inject
    public SimilarAdvertBlueprintImpl(@NotNull RdsAdvertItemPresenter rdsAdvertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(rdsAdvertItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.c = rdsAdvertItemPresenter;
        this.d = serpItemAbViewConfig;
        this.e = connectivityProvider;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.rds_advert_item_grid, new a(this, timeSource, locale));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Intrinsics.areEqual(item.getClass(), this.a) && ((AdvertItem) item).getViewType() == SerpViewType.GRID;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.RdsAdvertItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RdsAdvertItemView, AdvertItem> getPresenter() {
        return this.c;
    }
}
