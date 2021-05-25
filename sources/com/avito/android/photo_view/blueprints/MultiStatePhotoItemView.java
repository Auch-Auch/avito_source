package com.avito.android.photo_view.blueprints;

import com.avito.android.photo_view.ImageListPresenter;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/photo_view/ImageListPresenter;", "presenter", "attachPresenter", "(Lcom/avito/android/photo_view/ImageListPresenter;)V", "message", "setErrorState", "setWarningState", "setNormalState", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStatePhotoItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiStatePhotoItemView multiStatePhotoItemView) {
            ItemView.DefaultImpls.onUnbind(multiStatePhotoItemView);
        }
    }

    void attachPresenter(@NotNull ImageListPresenter imageListPresenter);

    void setErrorState(@NotNull CharSequence charSequence);

    void setNormalState(@Nullable CharSequence charSequence);

    void setTitle(@Nullable CharSequence charSequence);

    void setWarningState(@NotNull CharSequence charSequence);
}
