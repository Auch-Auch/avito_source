package com.avito.android.photo_picker.legacy;

import android.net.Uri;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.model.CloseableDataSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ-\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\f\u0010\u000fJG\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/photo_picker/PhotoUpload;", "selectAll", "()Lio/reactivex/Observable;", "", "typeId", "selectUploadsOfType", "(Ljava/lang/String;)Lio/reactivex/Observable;", "operationId", "select", "", "photoId", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "uploadId", "", VKApiConst.POSITION, "Landroid/net/Uri;", "contentUri", "sourceUri", ProductAction.ACTION_ADD, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/net/Uri;Landroid/net/Uri;)J", "photo", "", "update", "(Ljava/lang/String;Lcom/avito/android/photo_picker/PhotoUpload;)Z", "updatePosition", "(Landroid/net/Uri;I)Z", "fromPosition", "toPosition", "move", "(II)Z", PhoneActionStrings.REMOVE, "(Ljava/lang/String;)Z", "", "deleteAll", "(Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ long add$default(PhotoInteractor photoInteractor, String str, String str2, String str3, int i, Uri uri, Uri uri2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 32) != 0) {
                    uri2 = null;
                }
                return photoInteractor.add(str, str2, str3, i, uri, uri2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
        }
    }

    long add(@NotNull String str, @NotNull String str2, @Nullable String str3, int i, @Nullable Uri uri, @Nullable Uri uri2);

    boolean delete(@NotNull String str);

    void deleteAll(@NotNull String str);

    boolean move(int i, int i2);

    @NotNull
    Observable<CloseableDataSource<? extends PhotoUpload>> select(@NotNull String str);

    @NotNull
    Observable<CloseableDataSource<? extends PhotoUpload>> select(@NotNull String str, long j);

    @NotNull
    Observable<CloseableDataSource<? extends PhotoUpload>> selectAll();

    @NotNull
    Observable<CloseableDataSource<? extends PhotoUpload>> selectUploadsOfType(@NotNull String str);

    boolean update(@NotNull String str, @NotNull PhotoUpload photoUpload);

    boolean updatePosition(@NotNull Uri uri, int i);
}
