package com.avito.android.photo_picker.legacy.service;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.photo_picker.ExifUtilsKt;
import com.avito.android.photo_picker.legacy.api.UploadInteractor;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.util.rx3.InteropKt;
import com.avito.http.FileUtils;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/PublishImageUploadInteractor;", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractor;", "Ljava/io/File;", "file", "Lio/reactivex/Single;", "", "uploadFile", "(Ljava/io/File;)Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "api", "<init>", "(Lcom/avito/android/photo_picker/legacy/remote/PickerApi;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PublishImageUploadInteractor implements UploadInteractor {
    public final PickerApi a;

    public static final class a<T, R> implements Function<File, SingleSource<? extends ImageUploadResult>> {
        public final /* synthetic */ PublishImageUploadInteractor a;

        public a(PublishImageUploadInteractor publishImageUploadInteractor) {
            this.a = publishImageUploadInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ImageUploadResult> apply(File file) {
            File file2 = file;
            Intrinsics.checkNotNullParameter(file2, "it");
            return InteropKt.toV2(this.a.a.uploadPhoto(FileUtils.convertToImageMultipart$default(file2, null, null, 3, null), ExifUtilsKt.getExtraData(ExifUtilsKt.getAttributes(new ExifInterface(file2)))));
        }
    }

    public static final class b<T, R> implements Function<ImageUploadResult, String> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(ImageUploadResult imageUploadResult) {
            ImageUploadResult imageUploadResult2 = imageUploadResult;
            Intrinsics.checkNotNullParameter(imageUploadResult2, "it");
            return imageUploadResult2.getUploadId();
        }
    }

    public PublishImageUploadInteractor(@NotNull PickerApi pickerApi) {
        Intrinsics.checkNotNullParameter(pickerApi, "api");
        this.a = pickerApi;
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadInteractor
    @NotNull
    public Single<String> uploadFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Single<String> map = Single.just(file).flatMap(new a(this)).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "Single\n            .just…     .map { it.uploadId }");
        return map;
    }
}
