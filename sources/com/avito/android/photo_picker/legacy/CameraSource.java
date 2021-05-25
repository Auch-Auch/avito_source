package com.avito.android.photo_picker.legacy;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraSource;", "", "Lcom/avito/android/photo_picker/legacy/CameraType;", "type", "Lio/reactivex/Single;", "Landroid/hardware/Camera;", "open", "(Lcom/avito/android/photo_picker/legacy/CameraType;)Lio/reactivex/Single;", "", "getAvailableCameras", "()Ljava/util/List;", "availableCameras", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"Deprecation"})
public interface CameraSource {
    @NotNull
    List<CameraType> getAvailableCameras();

    @NotNull
    Single<Camera> open(@NotNull CameraType cameraType);
}
