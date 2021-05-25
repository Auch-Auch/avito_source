package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.UploadingState;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/UploadingState;", "getUploadProgressObservable", "()Lio/reactivex/Observable;", "", "", "getUploadIds", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface UploadingProgressInteractor {
    @NotNull
    Observable<List<String>> getUploadIds();

    @NotNull
    Observable<UploadingState> getUploadProgressObservable();
}
