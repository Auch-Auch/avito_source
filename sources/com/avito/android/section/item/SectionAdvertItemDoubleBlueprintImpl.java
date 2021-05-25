package com.avito.android.section.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp_core.R;
import com.avito.android.server_time.TimeSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprintImpl;", "Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/section/item/SectionAdvertItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/section/item/SectionAdvertItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/item/SectionAdvertItemPresenter;", "getPresenter", "()Lcom/avito/android/section/item/SectionAdvertItemPresenter;", "presenter", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "c", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/section/item/SectionAdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionAdvertItemDoubleBlueprintImpl implements SectionAdvertItemDoubleBlueprint {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SectionAdvertItemViewImpl> a;
    @NotNull
    public final SectionAdvertItemPresenter b;
    public final ConnectivityProvider c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SectionAdvertItemViewImpl> {
        public final /* synthetic */ SectionAdvertItemDoubleBlueprintImpl a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ Locale c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SectionAdvertItemDoubleBlueprintImpl sectionAdvertItemDoubleBlueprintImpl, TimeSource timeSource, Locale locale) {
            super(2);
            this.a = sectionAdvertItemDoubleBlueprintImpl;
            this.b = timeSource;
            this.c = locale;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SectionAdvertItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SectionAdvertItemViewImpl(view2, this.b, this.c, this.a.c);
        }
    }

    @Inject
    public SectionAdvertItemDoubleBlueprintImpl(@NotNull SectionAdvertItemPresenter sectionAdvertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(sectionAdvertItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.b = sectionAdvertItemPresenter;
        this.c = connectivityProvider;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.section_advert_item, new a(this, timeSource, locale));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SectionAdvertItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof AdvertItem) && ((AdvertItem) item).getViewType() == SerpViewType.BIG;
    }

    /* Return type fixed from 'com.avito.android.section.item.SectionAdvertItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SectionAdvertItemView, AdvertItem> getPresenter() {
        return this.b;
    }
}
