package com.avito.android.photo_picker.legacy.service;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.photo.BitmapConversionResult;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.photo_picker.ExifExtraData;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifUtilsKt;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadConverter;", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "Landroid/net/Uri;", "contentUri", "Lio/reactivex/Observable;", "Ljava/io/File;", "convertUriToFile", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "Lcom/avito/android/photo/ImageConvertOptions;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo/ImageConvertOptions;", "uploadImageConvertParams", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "c", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/photo/BitmapFileProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo/BitmapFileProvider;", "bitmapProvider", "<init>", "(Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/photo/ImageConvertOptions;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadConverter implements UploadConverter {
    public final BitmapFileProvider a;
    public final ImageConvertOptions b;
    public final ExifExtraDataSerializer c;

    public static final class a<T, R> implements Function<BitmapConversionResult, File> {
        public final /* synthetic */ ImageUploadConverter a;

        public a(ImageUploadConverter imageUploadConverter) {
            this.a = imageUploadConverter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public File apply(BitmapConversionResult bitmapConversionResult) {
            BitmapConversionResult bitmapConversionResult2 = bitmapConversionResult;
            Intrinsics.checkNotNullParameter(bitmapConversionResult2, "it");
            ImageUploadConverter.access$setExtraDataIfNeeded(this.a, bitmapConversionResult2.getOriginalExifData());
            ExifUtilsKt.setAttributesAndSave(new ExifInterface(bitmapConversionResult2.getFile()), bitmapConversionResult2.getOriginalExifData());
            return bitmapConversionResult2.getFile();
        }
    }

    public ImageUploadConverter(@NotNull BitmapFileProvider bitmapFileProvider, @NotNull ImageConvertOptions imageConvertOptions, @NotNull ExifExtraDataSerializer exifExtraDataSerializer) {
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "bitmapProvider");
        Intrinsics.checkNotNullParameter(imageConvertOptions, "uploadImageConvertParams");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        this.a = bitmapFileProvider;
        this.b = imageConvertOptions;
        this.c = exifExtraDataSerializer;
    }

    public static final void access$setExtraDataIfNeeded(ImageUploadConverter imageUploadConverter, Map map) {
        Objects.requireNonNull(imageUploadConverter);
        String extraData = ExifUtilsKt.getExtraData(map);
        if (extraData == null || extraData.length() == 0) {
            ExifUtilsKt.setExtraData(map, imageUploadConverter.c.serialize(new ExifExtraData((String) map.get(ExifInterface.TAG_IMAGE_WIDTH), (String) map.get(ExifInterface.TAG_IMAGE_LENGTH))));
        }
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadConverter
    @NotNull
    public Observable<File> convertUriToFile(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Observable<R> map = this.a.getConvertedFileForUri(uri, this.b).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "bitmapProvider\n         …   it.file \n            }");
        return map;
    }
}
