package com.avito.android.photo_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.photo_view.ImageListView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_view/LegacyImageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/photo_view/LegacyImageViewHolder;", "", "Lcom/avito/android/photo_view/ImageData;", "newItems", "", "setItems", "(Ljava/util/List;)V", "holder", "", VKApiConst.POSITION, "onBindViewHolder", "(Lcom/avito/android/photo_view/LegacyImageViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/photo_view/LegacyImageViewHolder;", "getItemCount", "()I", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "d", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "c", "Ljava/util/List;", "items", "<init>", "(Ljava/util/List;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyImageListAdapter extends RecyclerView.Adapter<LegacyImageViewHolder> {
    public List<? extends ImageData> c;
    public final ImageListView.Presenter d;

    public LegacyImageListAdapter(@NotNull List<? extends ImageData> list, @NotNull ImageListView.Presenter presenter) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.c = list;
        this.d = presenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void setItems(@NotNull List<? extends ImageData> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this, list) { // from class: com.avito.android.photo_view.LegacyImageListAdapter$setItems$diff$1
            public final /* synthetic */ LegacyImageListAdapter a;
            public final /* synthetic */ List b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return Intrinsics.areEqual((ImageData) this.a.c.get(i), (ImageData) this.b.get(i2));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                return Intrinsics.areEqual(((ImageData) this.a.c.get(i)).getId(), ((ImageData) this.b.get(i2)).getId());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return this.b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return this.a.c.size();
            }
        }, true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(o…osition]\n        }, true)");
        this.c = list;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(@NotNull LegacyImageViewHolder legacyImageViewHolder, int i) {
        Intrinsics.checkNotNullParameter(legacyImageViewHolder, "holder");
        legacyImageViewHolder.bind((ImageData) this.c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public LegacyImageViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.legacy_item_photo_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "viewContainer");
        return new LegacyImageViewHolder(inflate, this.d, false, 4, null);
    }
}
