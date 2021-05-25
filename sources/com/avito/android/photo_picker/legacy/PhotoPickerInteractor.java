package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.SelectedPhoto;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\n\u0010\bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "selectedPhotos", "Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "createPhotos", "(Ljava/util/List;)Lio/reactivex/Single;", "photos", "getThumbnails", "", "Lio/reactivex/Observable;", "addPhotos", "(Ljava/lang/Iterable;)Lio/reactivex/Observable;", "", "position1", "position2", "", "swapPhotos", "(II)V", "", "id", "removePhoto", "(Ljava/lang/String;)V", "select", "()Lio/reactivex/Single;", "Lio/reactivex/Completable;", "commit", "()Lio/reactivex/Completable;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "getState", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerInteractor {
    @NotNull
    Observable<PickerPhoto> addPhotos(@NotNull Iterable<PickerPhoto> iterable);

    @NotNull
    Completable commit();

    @NotNull
    Single<List<PickerPhoto>> createPhotos(@NotNull List<SelectedPhoto> list);

    @NotNull
    PhotoPickerInteractorState getState();

    @NotNull
    Single<List<PickerPhoto>> getThumbnails(@NotNull List<PickerPhoto> list);

    void removePhoto(@NotNull String str);

    @NotNull
    Single<List<PickerPhoto>> select();

    void swapPhotos(int i, int i2);
}
