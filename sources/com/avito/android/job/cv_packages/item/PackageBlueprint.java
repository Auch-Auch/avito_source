package com.avito.android.job.cv_packages.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.job.cv_packages.Action;
import com.avito.android.job.cv_packages.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/job/cv_packages/item/PackageBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/job/cv_packages/item/PackageItemView;", "Lcom/avito/android/job/cv_packages/item/PackageItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/job/cv_packages/item/PackagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/cv_packages/item/PackagePresenter;", "getPresenter", "()Lcom/avito/android/job/cv_packages/item/PackagePresenter;", "presenter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/cv_packages/Action;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "<init>", "(Lcom/avito/android/job/cv_packages/item/PackagePresenter;Lio/reactivex/rxjava3/functions/Consumer;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class PackageBlueprint implements ItemBlueprint<PackageItemView, PackageItem> {
    @NotNull
    public final PackagePresenter a;
    public final Consumer<Action> b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, PackageItemViewImpl> {
        public final /* synthetic */ PackageBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PackageBlueprint packageBlueprint) {
            super(2);
            this.a = packageBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public PackageItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new PackageItemViewImpl(view2, this.a.b);
        }
    }

    public PackageBlueprint(@NotNull PackagePresenter packagePresenter, @NotNull Consumer<Action> consumer) {
        Intrinsics.checkNotNullParameter(packagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.a = packagePresenter;
        this.b = consumer;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.package_item, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof PackageItem;
    }

    /* Return type fixed from 'com.avito.android.job.cv_packages.item.PackagePresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<PackageItemView, PackageItem> getPresenter() {
        return this.a;
    }
}
