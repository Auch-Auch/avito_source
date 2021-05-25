package com.avito.android.extended_profile.adapter.category.category_advert.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemView;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", "getPresenter", "()Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", "presenter", "c", "Z", "isTablet", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "<init>", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertListItemBlueprint implements ItemBlueprint<CategoryAdvertListItemView, CategoryAdvertItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CategoryAdvertListItemViewImpl> a;
    @NotNull
    public final CategoryAdvertListItemPresenter b;
    public final boolean c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CategoryAdvertListItemViewImpl> {
        public final /* synthetic */ RecyclerView.RecycledViewPool a;
        public final /* synthetic */ GalleryRatio b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RecyclerView.RecycledViewPool recycledViewPool, GalleryRatio galleryRatio) {
            super(2);
            this.a = recycledViewPool;
            this.b = galleryRatio;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CategoryAdvertListItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            RecyclerView.RecycledViewPool recycledViewPool = this.a;
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            return new CategoryAdvertListItemViewImpl(view2, this.b, recycledViewPool, create);
        }
    }

    @Inject
    public CategoryAdvertListItemBlueprint(@NotNull CategoryAdvertListItemPresenter categoryAdvertListItemPresenter, @NotNull GalleryRatio galleryRatio, @NotNull RecyclerView.RecycledViewPool recycledViewPool, boolean z) {
        Intrinsics.checkNotNullParameter(categoryAdvertListItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(galleryRatio, "galleryRatio");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        this.b = categoryAdvertListItemPresenter;
        this.c = z;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_item_rich, new a(recycledViewPool, galleryRatio));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CategoryAdvertListItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof CategoryAdvertItem) && !this.c;
    }

    /* Return type fixed from 'com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CategoryAdvertListItemView, CategoryAdvertItem> getPresenter() {
        return this.b;
    }
}
