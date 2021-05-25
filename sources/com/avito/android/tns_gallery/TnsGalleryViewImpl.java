package com.avito.android.tns_gallery;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.tns_gallery.di.DaggerTnsGalleryComponent;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010.\u001a\u00020+¢\u0006\u0004\b4\u00105J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryViewImpl;", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "items", "", "showGallery", "(Ljava/util/List;)V", "hideGallery", "()V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getImageGalleryAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setImageGalleryAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "imageGalleryAdapter", "Lcom/avito/android/tns_gallery/TnsGallerySettings;", "c", "Lcom/avito/android/tns_gallery/TnsGallerySettings;", "settings", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;Lcom/avito/android/tns_gallery/TnsGallerySettings;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryViewImpl implements TnsGalleryView {
    @NotNull
    public SimpleRecyclerAdapter a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public final RecyclerView b;
    public final TnsGallerySettings c;
    @Inject
    public Features features;
    @Inject
    public ItemBinder itemBinder;

    public TnsGalleryViewImpl(@NotNull RecyclerView recyclerView, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features2, @NotNull TnsGallerySettings tnsGallerySettings) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features2, "features");
        Intrinsics.checkNotNullParameter(tnsGallerySettings, "settings");
        this.b = recyclerView;
        this.c = tnsGallerySettings;
        DaggerTnsGalleryComponent.factory().create(consumer, activity, tnsGallerySettings, features2).inject(this);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        this.a = new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.a);
        recyclerView.addItemDecoration(new TnsGalleryItemDecoration(activity, tnsGallerySettings));
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getImageGalleryAdapter() {
        return this.a;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryView
    public void hideGallery() {
        Views.hide(this.b);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        adapterPresenter2.onDataSourceChanged(new ListDataSource(CollectionsKt__CollectionsKt.emptyList()));
        this.a.notifyDataSetChanged();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImageGalleryAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.a = simpleRecyclerAdapter;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryView
    public void showGallery(@NotNull List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        Views.show(this.b);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new TnsGalleryItem((long) i, list));
            i = i2;
        }
        adapterPresenter2.onDataSourceChanged(new ListDataSource(arrayList));
        this.a.notifyDataSetChanged();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TnsGalleryViewImpl(RecyclerView recyclerView, Consumer consumer, Activity activity, Features features2, TnsGallerySettings tnsGallerySettings, int i, j jVar) {
        this(recyclerView, consumer, activity, features2, (i & 16) != 0 ? new TnsGallerySettings(0, 0, 0, 0, 15, null) : tnsGallerySettings);
    }
}
