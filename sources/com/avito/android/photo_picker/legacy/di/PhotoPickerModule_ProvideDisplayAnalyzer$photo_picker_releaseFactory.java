package com.avito.android.photo_picker.legacy.di;

import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory implements Factory<DisplayAnalyzer> {
    public final PhotoPickerModule a;
    public final Provider<DeviceMetrics> b;

    public PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory(PhotoPickerModule photoPickerModule, Provider<DeviceMetrics> provider) {
        this.a = photoPickerModule;
        this.b = provider;
    }

    public static PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory create(PhotoPickerModule photoPickerModule, Provider<DeviceMetrics> provider) {
        return new PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory(photoPickerModule, provider);
    }

    public static DisplayAnalyzer provideDisplayAnalyzer$photo_picker_release(PhotoPickerModule photoPickerModule, DeviceMetrics deviceMetrics) {
        return (DisplayAnalyzer) Preconditions.checkNotNullFromProvides(photoPickerModule.provideDisplayAnalyzer$photo_picker_release(deviceMetrics));
    }

    @Override // javax.inject.Provider
    public DisplayAnalyzer get() {
        return provideDisplayAnalyzer$photo_picker_release(this.a, this.b.get());
    }
}
