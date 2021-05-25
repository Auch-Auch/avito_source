package com.avito.android.photo_picker.edit.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.google.gson.Gson;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/edit/di/EditPhotoDependencies;", "", "Landroid/content/Context;", "context", "()Landroid/content/Context;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/google/gson/Gson;", "gson", "()Lcom/google/gson/Gson;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotoStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotoStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "photoPickerEventTracker", "()Lcom/avito/android/analytics/PhotoPickerEventTracker;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface EditPhotoDependencies {
    @NotNull
    Context context();

    @NotNull
    Features features();

    @NotNull
    Gson gson();

    @NotNull
    PhotoPickerEventTracker photoPickerEventTracker();

    @NotNull
    PrivatePhotosStorage privatePhotoStorage();

    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @NotNull
    SharedPhotosStorage sharedPhotoStorage();
}
