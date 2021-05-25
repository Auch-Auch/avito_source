package com.avito.android.extended_profile.adapter.gallery;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.extended_profile.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemView;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenter;", "getPresenter", "()Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemPresenter;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItemBlueprint implements ItemBlueprint<GalleryItemView, GalleryItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<GalleryItemViewImpl> a;
    @NotNull
    public final GalleryItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, GalleryItemViewImpl> {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ Features c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, Activity activity, Features features) {
            super(2);
            this.a = consumer;
            this.b = activity;
            this.c = features;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public GalleryItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new GalleryItemViewImpl(view2, this.a, this.b, this.c);
        }
    }

    @Inject
    public GalleryItemBlueprint(@NotNull GalleryItemPresenter galleryItemPresenter, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(galleryItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = galleryItemPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.extended_profile_gallery_item, new a(consumer, activity, features));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<GalleryItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GalleryItem;
    }

    /* Return type fixed from 'com.avito.android.extended_profile.adapter.gallery.GalleryItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<GalleryItemView, GalleryItem> getPresenter() {
        return this.b;
    }
}
