package com.avito.android.photo_picker.legacy;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "", "Lcom/avito/android/photo_picker/legacy/CameraType;", "type", "Lio/reactivex/Single;", "Lorg/funktionale/option/Option;", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "openCamera", "(Lcom/avito/android/photo_picker/legacy/CameraType;)Lio/reactivex/Single;", "", "getAvailableCameras", "()Ljava/util/List;", "availableCameras", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraOpenInteractor {
    @NotNull
    List<CameraType> getAvailableCameras();

    @NotNull
    Single<Option<CameraInteractor>> openCamera(@NotNull CameraType cameraType);
}
