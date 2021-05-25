package com.avito.android.photo_picker.legacy.api;

import com.avito.android.Features;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.photo_picker.legacy.service.ImageUploadConverter;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_picker/legacy/api/UploadConverterProviderImpl;", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "", "typeId", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "getUploadConverter", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/photo/BitmapFileProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo/BitmapFileProvider;", "bitmapFileProvider", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "<init>", "(Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/Features;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class UploadConverterProviderImpl implements UploadConverterProvider {
    public final BitmapFileProvider a;
    public final ExifExtraDataSerializer b;
    public final Features c;

    @Inject
    public UploadConverterProviderImpl(@NotNull BitmapFileProvider bitmapFileProvider, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "bitmapFileProvider");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = bitmapFileProvider;
        this.b = exifExtraDataSerializer;
        this.c = features;
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadConverterProvider
    @NotNull
    public UploadConverter getUploadConverter(@NotNull String str) {
        ImageConvertOptions imageConvertOptions;
        Intrinsics.checkNotNullParameter(str, "typeId");
        BitmapFileProvider bitmapFileProvider = this.a;
        if (!this.c.getEnlargePhotosOnPublish().invoke().booleanValue() || !Intrinsics.areEqual(str, PhotoUploadKt.UPLOAD_TYPE_PUBLISH)) {
            imageConvertOptions = new ImageConvertOptions(960, 1280, 90, 4194304);
        } else {
            imageConvertOptions = new ImageConvertOptions(1440, 1920, 60, 4194304);
        }
        return new ImageUploadConverter(bitmapFileProvider, imageConvertOptions, this.b);
    }
}
