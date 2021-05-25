package com.avito.android.tariff.tariff_package_info.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.tariff_package_info.di.TariffPackageMicrocategoryAdapterPresenter;
import com.avito.android.tariff.tariff_package_info.di.TariffPackageMicrocategoryItemBinder;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItemView;", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;", "getPresenter", "()Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;", "presenter", "Lcom/avito/konveyor/ItemBinder;", "c", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageBlueprint implements ItemBlueprint<TariffPackageItemView, TariffPackageItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.tariff_package_info_item, new a(this));
    @NotNull
    public final TariffPackagePresenter b;
    public final ItemBinder c;
    public final AdapterPresenter d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, TariffPackageItemViewImpl> {
        public final /* synthetic */ TariffPackageBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TariffPackageBlueprint tariffPackageBlueprint) {
            super(2);
            this.a = tariffPackageBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public TariffPackageItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new TariffPackageItemViewImpl(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public TariffPackageBlueprint(@NotNull TariffPackagePresenter tariffPackagePresenter, @TariffPackageMicrocategoryItemBinder @NotNull ItemBinder itemBinder, @TariffPackageMicrocategoryAdapterPresenter @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(tariffPackagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.b = tariffPackagePresenter;
        this.c = itemBinder;
        this.d = adapterPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof TariffPackageItem;
    }

    /* Return type fixed from 'com.avito.android.tariff.tariff_package_info.recycler.TariffPackagePresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<TariffPackageItemView, TariffPackageItem> getPresenter() {
        return this.b;
    }
}
