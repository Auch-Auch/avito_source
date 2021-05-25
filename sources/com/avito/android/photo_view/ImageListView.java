package com.avito.android.photo_view;

import com.avito.android.photo_picker.legacy.PhotoMover;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_view/ImageListView;", "", "", "Lcom/avito/android/photo_view/ImageData;", "images", "", "show", "(Ljava/util/List;)V", "Presenter", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public interface ImageListView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_view/ImageListView$Presenter;", "Lcom/avito/android/photo_picker/legacy/PhotoMover;", "", "onRootViewClicked", "()V", "", "id", "onRemoveClicked", "(Ljava/lang/String;)V", "onRetryClicked", "showPhotoPicker", "showVideoPicker", "photo-view_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter extends PhotoMover {
        void onRemoveClicked(@NotNull String str);

        void onRetryClicked(@NotNull String str);

        void onRootViewClicked();

        void showPhotoPicker(@NotNull String str);

        void showVideoPicker();
    }

    void show(@NotNull List<? extends ImageData> list);
}
