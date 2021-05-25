package com.avito.android.remote;

import com.avito.android.remote.model.ExtendedProfileSettingsResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UploadResult;
import com.avito.android.remote.model.modification.ModificationBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00030\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/ExtendedProfileSettingsApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ExtendedProfileSettingsResult;", "getSettings", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/modification/ModificationBody;", SDKConstants.PARAM_A2U_BODY, "", "modifyFields", "(Lcom/avito/android/remote/model/modification/ModificationBody;)Lio/reactivex/rxjava3/core/Observable;", "", "isEnabled", "enableExtendedProfile", "(Z)Lio/reactivex/rxjava3/core/Observable;", "Lokhttp3/MultipartBody$Part;", "file", "Lcom/avito/android/remote/model/UploadResult;", "uploadImage", "(Lokhttp3/MultipartBody$Part;)Lio/reactivex/rxjava3/core/Observable;", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileSettingsApi {
    @NotNull
    @FormUrlEncoded
    @POST("1/extended-profile/toggle")
    Observable<TypedResult<Unit>> enableExtendedProfile(@Field("isEnabled") boolean z);

    @GET("1/extended-profile")
    @NotNull
    Observable<TypedResult<ExtendedProfileSettingsResult>> getSettings();

    @POST("1/extended-profile/modify-fields")
    @NotNull
    Observable<TypedResult<Unit>> modifyFields(@Body @NotNull ModificationBody modificationBody);

    @NotNull
    @POST("1/extended-profile/image-upload")
    @Multipart
    Observable<TypedResult<UploadResult>> uploadImage(@NotNull @Part MultipartBody.Part part);
}
