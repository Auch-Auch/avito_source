package com.avito.android.tns_gallery;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tns_core.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tns_gallery/TnsGalleryItemView;", "Lcom/avito/android/tns_gallery/TnsGalleryItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "getPresenter", "()Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "presenter", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;Lcom/avito/android/Features;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemBlueprint implements ItemBlueprint<TnsGalleryItemView, TnsGalleryItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.tns_gallery_item_image, new a(this));
    @NotNull
    public final TnsGalleryItemPresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, TnsGalleryItemViewImpl> {
        public final /* synthetic */ TnsGalleryItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TnsGalleryItemBlueprint tnsGalleryItemBlueprint) {
            super(2);
            this.a = tnsGalleryItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public TnsGalleryItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new TnsGalleryItemViewImpl(view2, this.a.c);
        }
    }

    public TnsGalleryItemBlueprint(@NotNull TnsGalleryItemPresenter tnsGalleryItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(tnsGalleryItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = tnsGalleryItemPresenter;
        this.c = features;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof TnsGalleryItem;
    }

    /* Return type fixed from 'com.avito.android.tns_gallery.TnsGalleryItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<TnsGalleryItemView, TnsGalleryItem> getPresenter() {
        return this.b;
    }
}
