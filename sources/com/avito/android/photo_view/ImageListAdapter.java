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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/photo_view/ImageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/photo_view/ViewHolder;", "", "Lcom/avito/android/photo_view/ImageData;", "newItems", "", "setItems", "(Ljava/util/List;)V", "holder", "", VKApiConst.POSITION, "onBindViewHolder", "(Lcom/avito/android/photo_view/ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/photo_view/ViewHolder;", "getItemViewType", "(I)I", "getItemCount", "()I", "c", "Ljava/util/List;", "items", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "d", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "<init>", "(Ljava/util/List;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class ImageListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<? extends ImageData> c;
    public final ImageListView.Presenter d;

    public ImageListAdapter(@NotNull List<? extends ImageData> list, @NotNull ImageListView.Presenter presenter) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.c = list;
        this.d = presenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        String id = ((ImageData) this.c.get(i)).getId();
        switch (id.hashCode()) {
            case -1773151199:
                if (id.equals(ImageListPresenterKt.PHOTO_CAMERA_ITEM_ID)) {
                    return 0;
                }
                break;
            case -1773151198:
                if (id.equals(ImageListPresenterKt.VIDEO_CAMERA_ITEM_ID)) {
                    return 2;
                }
                break;
        }
        return 1;
    }

    public final void setItems(@NotNull List<? extends ImageData> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this, list) { // from class: com.avito.android.photo_view.ImageListAdapter$setItems$diff$1
            public final /* synthetic */ ImageListAdapter a;
            public final /* synthetic */ List b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return Intrinsics.areEqual((ImageData) ImageListAdapter.access$getItems$p(this.a).get(i), (ImageData) this.b.get(i2));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                return Intrinsics.areEqual(((ImageData) ImageListAdapter.access$getItems$p(this.a).get(i)).getId(), ((ImageData) this.b.get(i2)).getId());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return this.b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return ImageListAdapter.access$getItems$p(this.a).size();
            }
        }, true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(o…osition]\n        }, true)");
        this.c = list;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.bind((ImageData) this.c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            View inflate = from.inflate(R.layout.item_appending_view, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "viewContainer");
            return new PhotoAppendingViewHolder(inflate, this.d);
        } else if (i != 2) {
            View inflate2 = from.inflate(R.layout.item_photo_view, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "viewContainer");
            return new ImageViewHolder(inflate2, this.d);
        } else {
            View inflate3 = from.inflate(R.layout.item_appending_view, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "viewContainer");
            return new VideoAppendingViewHolder(inflate3, this.d);
        }
    }
}
