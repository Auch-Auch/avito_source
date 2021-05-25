package com.avito.android.photo_view;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_view/ImageListRouter;", "", "", "selectedPhotoId", "", "currentPhotoCount", "", "openPhotoPicker", "(Ljava/lang/String;I)V", "openVideoPicker", "()V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public interface ImageListRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void openPhotoPicker$default(ImageListRouter imageListRouter, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                imageListRouter.openPhotoPicker(str, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPhotoPicker");
        }
    }

    void openPhotoPicker(@Nullable String str, int i);

    void openVideoPicker();
}
