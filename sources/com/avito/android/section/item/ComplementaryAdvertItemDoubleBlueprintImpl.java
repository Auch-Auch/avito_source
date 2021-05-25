package com.avito.android.section.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.module.ComplementarySectionAdvertItemPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010$\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprintImpl;", "Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "f", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Ljava/lang/Class;", "Lcom/avito/android/serp/adapter/AdvertItem;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "relevantClass", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/RdsAdvertItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/section/item/SectionItemWidthProvider;", "d", "Lcom/avito/android/section/item/SectionItemWidthProvider;", "itemWidthProvider", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "e", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "viewConfig", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "c", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "presenter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/section/item/SectionItemWidthProvider;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ComplementaryAdvertItemDoubleBlueprintImpl implements ComplementaryAdvertItemDoubleBlueprint {
    public final Class<AdvertItem> a = AdvertItem.class;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> b;
    @NotNull
    public final RdsAdvertItemPresenter c;
    public final SectionItemWidthProvider d;
    public final SerpItemAbViewConfig e;
    public final ConnectivityProvider f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RdsAdvertItemViewImpl> {
        public final /* synthetic */ ComplementaryAdvertItemDoubleBlueprintImpl a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ Locale c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ComplementaryAdvertItemDoubleBlueprintImpl complementaryAdvertItemDoubleBlueprintImpl, TimeSource timeSource, Locale locale) {
            super(2);
            this.a = complementaryAdvertItemDoubleBlueprintImpl;
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
            ComplementaryAdvertItemDoubleBlueprintImpl.access$setWidth(this.a, view2);
            View findViewById = view2.findViewById(R.id.date);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (this.a.e.isPriceOnTop()) {
                View findViewById2 = view2.findViewById(R.id.item_root);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.serp.AdvertItemLayout");
                ((AdvertItemLayout) findViewById2).swapPriceAndTitle();
            }
            return new RdsAdvertItemViewImpl(view2, this.b, this.c, this.a.f);
        }
    }

    @Inject
    public ComplementaryAdvertItemDoubleBlueprintImpl(@ComplementarySectionAdvertItemPresenter @NotNull RdsAdvertItemPresenter rdsAdvertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SectionItemWidthProvider sectionItemWidthProvider, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(rdsAdvertItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(sectionItemWidthProvider, "itemWidthProvider");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.c = rdsAdvertItemPresenter;
        this.d = sectionItemWidthProvider;
        this.e = serpItemAbViewConfig;
        this.f = connectivityProvider;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.rds_vip_advert_item, new a(this, timeSource, locale));
    }

    public static final void access$setWidth(ComplementaryAdvertItemDoubleBlueprintImpl complementaryAdvertItemDoubleBlueprintImpl, View view) {
        Objects.requireNonNull(complementaryAdvertItemDoubleBlueprintImpl);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = complementaryAdvertItemDoubleBlueprintImpl.d.getWidthByViewType(SerpViewType.BIG);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<RdsAdvertItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Intrinsics.areEqual(item.getClass(), this.a) && ((AdvertItem) item).getViewType() == SerpViewType.BIG;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.RdsAdvertItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RdsAdvertItemView, AdvertItem> getPresenter() {
        return this.c;
    }
}
