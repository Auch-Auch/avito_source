package com.avito.android.photo_wizard;

import android.content.ContentResolver;
import android.content.Context;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_wizard.di.qualifier.AdvertId;
import com.avito.android.photo_wizard.remote.PhotoWizardApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ContentResolverUtilsKt;
import com.avito.android.util.PrivatePhotosStorage;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/photo_wizard/UploadPicturesInteractorImpl;", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "", "Lcom/avito/android/photo_wizard/TakenPicture;", "pictures", "Lio/reactivex/rxjava3/core/Observable;", "", "uploadPictures", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;", "api", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Lcom/avito/android/util/PrivatePhotosStorage;", "c", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;Landroid/content/Context;Lcom/avito/android/util/PrivatePhotosStorage;Ljava/lang/String;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class UploadPicturesInteractorImpl implements UploadPicturesInteractor {
    public final PhotoWizardApi a;
    public final Context b;
    public final PrivatePhotosStorage c;
    public final String d;

    public static final class a<T, R> implements Function<Response<Boolean>, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Response<Boolean> response) {
            Response<Boolean> response2 = response;
            Intrinsics.checkNotNullExpressionValue(response2, "it");
            return Boolean.valueOf(response2.isSuccessful());
        }
    }

    @Inject
    public UploadPicturesInteractorImpl(@NotNull PhotoWizardApi photoWizardApi, @NotNull Context context, @NotNull PrivatePhotosStorage privatePhotosStorage, @AdvertId @NotNull String str) {
        Intrinsics.checkNotNullParameter(photoWizardApi, "api");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a = photoWizardApi;
        this.b = context;
        this.c = privatePhotosStorage;
        this.d = str;
    }

    @Override // com.avito.android.photo_wizard.UploadPicturesInteractor
    @NotNull
    public Observable<Boolean> uploadPictures(@NotNull Iterable<TakenPicture> iterable) {
        MultipartBody.Part part;
        Intrinsics.checkNotNullParameter(iterable, "pictures");
        ArrayList arrayList = new ArrayList();
        for (TakenPicture takenPicture : iterable) {
            File createTempFile = this.c.createTempFile();
            ContentResolver contentResolver = this.b.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            if (!ContentResolverUtilsKt.safeWriteUriContentToFile(contentResolver, takenPicture.getUri(), createTempFile)) {
                part = null;
            } else {
                part = MultipartBody.Part.Companion.createFormData(takenPicture.getId(), createTempFile.getName(), RequestBody.Companion.create(createTempFile, MediaType.Companion.parse("image/*")));
            }
            if (part != null) {
                arrayList.add(part);
            } else {
                Observable<Boolean> just = Observable.just(Boolean.FALSE);
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(false)");
                return just;
            }
        }
        Observable<R> map = this.a.uploadPhotos(RequestBody.Companion.create(this.d, MediaType.Companion.parse("text/*")), arrayList).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.uploadPhotos(advertI… .map { it.isSuccessful }");
        return map;
    }
}
