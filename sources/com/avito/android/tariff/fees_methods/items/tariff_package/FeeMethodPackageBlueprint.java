package com.avito.android.tariff.fees_methods.items.tariff_package;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.edit_info.di.MicroCategoryAdapterPresenter;
import com.avito.android.tariff.edit_info.di.MicroCategoryItemBinder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItemView;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/ItemBinder;", "d", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;", "getPresenter", "()Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodPackageBlueprint implements ItemBlueprint<FeeMethodPackageItemView, FeeMethodPackageItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<FeeMethodPackageItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.fee_package_item, new a(this));
    @NotNull
    public final FeeMethodPackagePresenter b;
    public final AdapterPresenter c;
    public final ItemBinder d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, FeeMethodPackageItemViewImpl> {
        public final /* synthetic */ FeeMethodPackageBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FeeMethodPackageBlueprint feeMethodPackageBlueprint) {
            super(2);
            this.a = feeMethodPackageBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public FeeMethodPackageItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new FeeMethodPackageItemViewImpl(view2, this.a.d, this.a.c);
        }
    }

    @Inject
    public FeeMethodPackageBlueprint(@NotNull FeeMethodPackagePresenter feeMethodPackagePresenter, @MicroCategoryAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @MicroCategoryItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(feeMethodPackagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.b = feeMethodPackagePresenter;
        this.c = adapterPresenter;
        this.d = itemBinder;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<FeeMethodPackageItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof FeeMethodPackageItem;
    }

    /* Return type fixed from 'com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackagePresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<FeeMethodPackageItemView, FeeMethodPackageItem> getPresenter() {
        return this.b;
    }
}
