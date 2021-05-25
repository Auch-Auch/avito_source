package com.avito.android.serp.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.SerpItemViewConfig;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/AdvertGridItemView;", "Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/AdvertGridItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lru/avito/component/serp/SerpItemViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemDoubleBlueprint implements ItemBlueprint<AdvertGridItemView, AdvertItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertGridItemViewImpl> a;
    @NotNull
    public final ItemPresenter<AdvertGridItemView, AdvertItem> b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertGridItemViewImpl> {
        public final /* synthetic */ SerpItemViewConfig a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ Locale c;
        public final /* synthetic */ ConnectivityProvider d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SerpItemViewConfig serpItemViewConfig, TimeSource timeSource, Locale locale, ConnectivityProvider connectivityProvider) {
            super(2);
            this.a = serpItemViewConfig;
            this.b = timeSource;
            this.c = locale;
            this.d = connectivityProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdvertGridItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            AdvertGridItemViewImpl advertGridItemViewImpl = new AdvertGridItemViewImpl(view2, this.a, this.b, this.c, this.d);
            advertGridItemViewImpl.setIsDoubleItem(true);
            return advertGridItemViewImpl;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.serp.adapter.AdvertGridItemView, ? super com.avito.android.serp.adapter.AdvertItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public AdvertItemDoubleBlueprint(@NotNull ItemPresenter<? super AdvertGridItemView, ? super AdvertItem> itemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemViewConfig serpItemViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.b = itemPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_item_grid, new a(serpItemViewConfig, timeSource, locale, connectivityProvider));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertGridItemView, AdvertItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdvertGridItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof AdvertItem) {
            AdvertItem advertItem = (AdvertItem) item;
            if (advertItem.getViewType() == SerpViewType.BIG && (advertItem.getDisplayType().isGrid() || advertItem.getDisplayType().isList())) {
                return true;
            }
        }
        return false;
    }
}
