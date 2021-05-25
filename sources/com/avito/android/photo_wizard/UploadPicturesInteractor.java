package com.avito.android.photo_wizard;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "", "", "Lcom/avito/android/photo_wizard/TakenPicture;", "pictures", "Lio/reactivex/rxjava3/core/Observable;", "", "uploadPictures", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Observable;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface UploadPicturesInteractor {
    @NotNull
    Observable<Boolean> uploadPictures(@NotNull Iterable<TakenPicture> iterable);
}
