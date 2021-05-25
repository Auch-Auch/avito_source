package com.avito.android.photo_picker.gallery.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/gallery/di/GalleryPickerDependencies;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface GalleryPickerDependencies {
    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies, com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    @NotNull
    Features features();

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    @NotNull
    SchedulersFactory schedulersFactory();
}
