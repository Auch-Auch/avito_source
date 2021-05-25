package com.avito.android.serp.adapter.rich_snippets.job;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.ui_components.R;
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
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", "presenter", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "c", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "<init>", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlRichJobItemBlueprint implements ItemBlueprint<AdvertRichJobItemView, AdvertXlItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertRichJobItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_item_rich_job, new a(this));
    @NotNull
    public final AdvertXlRichJobItemPresenter b;
    public final RecyclerView.RecycledViewPool c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertRichJobItemViewImpl> {
        public final /* synthetic */ AdvertXlRichJobItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertXlRichJobItemBlueprint advertXlRichJobItemBlueprint) {
            super(2);
            this.a = advertXlRichJobItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdvertRichJobItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            Resources resources = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            return new AdvertRichJobItemViewImpl(view2, new GalleryRatio(resources.getConfiguration().orientation != 2 ? 0.75f : 0.32f, 1.3333334f, 0.0f, 0.0f, 12, null), this.a.c, true);
        }
    }

    @Inject
    public AdvertXlRichJobItemBlueprint(@NotNull AdvertXlRichJobItemPresenter advertXlRichJobItemPresenter, @NotNull RecyclerView.RecycledViewPool recycledViewPool) {
        Intrinsics.checkNotNullParameter(advertXlRichJobItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        this.b = advertXlRichJobItemPresenter;
        this.c = recycledViewPool;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdvertRichJobItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof AdvertXlItem) && ((AdvertXlItem) item).getDisplayType().isVacancy();
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertRichJobItemView, AdvertXlItem> getPresenter() {
        return this.b;
    }
}
