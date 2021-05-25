package com.avito.android.photo_view;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_view.ImageData;
import com.avito.android.remote.model.ErrorType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"photo-view_release"}, k = 2, mv = {1, 4, 2})
public final class ImageListInteractorKt {
    public static final ImageData access$toImageData(PhotoUpload photoUpload) {
        ImageData.State state;
        String uploadId = photoUpload.getUploadId();
        if (!(uploadId == null || uploadId.length() == 0)) {
            state = ImageData.State.Completed.INSTANCE;
        } else {
            ErrorType error = photoUpload.getError();
            if (Intrinsics.areEqual(error, ErrorType.NoError.INSTANCE)) {
                state = ImageData.State.Loading.INSTANCE;
            } else if (Intrinsics.areEqual(error, ErrorType.RestorableError.INSTANCE)) {
                state = new ImageData.State.Error(true);
            } else if (Intrinsics.areEqual(error, ErrorType.NonRestorableError.INSTANCE)) {
                state = new ImageData.State.Error(false);
            } else {
                state = new ImageData.State.Error(false);
            }
        }
        return new PhotoImageData(String.valueOf(photoUpload.getId()), photoUpload.getContentUri(), state);
    }
}
