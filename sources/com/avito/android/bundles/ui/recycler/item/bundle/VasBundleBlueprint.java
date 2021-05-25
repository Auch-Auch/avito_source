package com.avito.android.bundles.ui.recycler.item.bundle;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.bundles.R;
import com.avito.android.bundles.di.BundleBenefitAdapterPresenter;
import com.avito.android.bundles.di.BundleBenefitItemBinder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemView;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "e", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/konveyor/ItemBinder;", "d", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;", "getPresenter", "()Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleBlueprint implements ItemBlueprint<VasBundleItemView, VasBundleItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<VasBundleItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.vas_bundle_item, new a(this));
    @NotNull
    public final VasBundleItemPresenter b;
    public final AttributedTextFormatter c;
    public final ItemBinder d;
    public final AdapterPresenter e;

    public static final class a extends Lambda implements Function2<ViewGroup, View, VasBundleItemViewImpl> {
        public final /* synthetic */ VasBundleBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VasBundleBlueprint vasBundleBlueprint) {
            super(2);
            this.a = vasBundleBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public VasBundleItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new VasBundleItemViewImpl(view2, this.a.c, this.a.e, this.a.d);
        }
    }

    @Inject
    public VasBundleBlueprint(@NotNull VasBundleItemPresenter vasBundleItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @BundleBenefitItemBinder @NotNull ItemBinder itemBinder, @BundleBenefitAdapterPresenter @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(vasBundleItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.b = vasBundleItemPresenter;
        this.c = attributedTextFormatter;
        this.d = itemBinder;
        this.e = adapterPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<VasBundleItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof VasBundleItem;
    }

    /* Return type fixed from 'com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<VasBundleItemView, VasBundleItem> getPresenter() {
        return this.b;
    }
}
