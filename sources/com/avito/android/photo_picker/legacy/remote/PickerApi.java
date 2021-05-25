package com.avito.android.photo_picker.legacy.remote;

import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.ParamSuggestionsByPhotoResponse;
import com.avito.android.remote.model.PublishSuggestsUploadPhotoResponse;
import com.avito.android.remote.model.RatingsImageUploadResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0001\u0010\f\u001a\u00020\u0004H'¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "", "Lokhttp3/MultipartBody$Part;", "file", "", "exif", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/ImageUploadResult;", "uploadPhoto", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "images", "publishSessionId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ParamSuggestionsByPhotoResponse;", "getPublishSuggestsByPhotoV3", "(Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PublishSuggestsUploadPhotoResponse;", "uploadPublishSuggestsPhoto", "(Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/RatingsImageUploadResult;", "uploadRatingsFile", "(Lokhttp3/MultipartBody$Part;)Lio/reactivex/rxjava3/core/Single;", "uploadRatingImage", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PickerApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single uploadPhoto$default(PickerApi pickerApi, MultipartBody.Part part, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return pickerApi.uploadPhoto(part, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadPhoto");
        }
    }

    @NotNull
    @FormUrlEncoded
    @POST("3/publish/categories/suggest/by_photo")
    Observable<TypedResult<ParamSuggestionsByPhotoResponse>> getPublishSuggestsByPhotoV3(@FieldMap @NotNull Map<String, String> map, @Field("publishSessionId") @NotNull String str);

    @NotNull
    @POST("2/images/upload")
    @Multipart
    Single<ImageUploadResult> uploadPhoto(@NotNull @Part MultipartBody.Part part, @Nullable @Query("exif") String str);

    @NotNull
    @POST("1/publish/categories/suggest/upload_photo")
    @Multipart
    Observable<TypedResult<PublishSuggestsUploadPhotoResponse>> uploadPublishSuggestsPhoto(@NotNull @Part MultipartBody.Part part, @NotNull @Part MultipartBody.Part part2);

    @NotNull
    @POST("1/rating/image")
    @Multipart
    Single<TypedResult<RatingsImageUploadResult>> uploadRatingImage(@NotNull @Part MultipartBody.Part part);

    @NotNull
    @POST("1/rating/file")
    @Multipart
    Single<TypedResult<RatingsImageUploadResult>> uploadRatingsFile(@NotNull @Part MultipartBody.Part part);
}
