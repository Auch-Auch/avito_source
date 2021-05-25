package com.avito.android.photo_view;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.photo_picker.legacy.PhotoDragAndDropImpl;
import com.avito.android.photo_view.ImageListView;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_view/LegacyImageListViewImpl;", "Lcom/avito/android/photo_view/ImageListView;", "", "Lcom/avito/android/photo_view/ImageData;", "images", "", "show", "(Ljava/util/List;)V", "Lcom/avito/android/photo_view/ImageListView$Presenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "Lcom/avito/android/photo_view/LegacyImageListAdapter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_view/LegacyImageListAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "photosRecyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyImageListViewImpl implements ImageListView {
    public final LegacyImageListAdapter a;
    public final ImageListView.Presenter b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LegacyImageListViewImpl a;

        public a(LegacyImageListViewImpl legacyImageListViewImpl) {
            this.a = legacyImageListViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.b.onRootViewClicked();
        }
    }

    public LegacyImageListViewImpl(@NotNull RecyclerView recyclerView, @NotNull ImageListView.Presenter presenter) {
        Intrinsics.checkNotNullParameter(recyclerView, "photosRecyclerView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.b = presenter;
        LegacyImageListAdapter legacyImageListAdapter = new LegacyImageListAdapter(CollectionsKt__CollectionsKt.emptyList(), presenter);
        this.a = legacyImageListAdapter;
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3, 1, false));
        recyclerView.setAdapter(legacyImageListAdapter);
        new PhotoDragAndDropImpl().attachTo(recyclerView, presenter);
        recyclerView.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.photo_view.ImageListView
    public void show(@NotNull List<? extends ImageData> list) {
        Intrinsics.checkNotNullParameter(list, "images");
        this.a.setItems(list);
    }
}
