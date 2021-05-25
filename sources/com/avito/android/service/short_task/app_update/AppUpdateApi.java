package com.avito.android.service.short_task.app_update;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.GeoContract;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/app_update/AppUpdateApi;", "", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "sendMetaDataLegacy", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", GeoContract.PROVIDER, "", "isSandbox", "sendMetaData", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface AppUpdateApi {
    @POST("2/app/metadata")
    @NotNull
    Observable<SuccessResult> sendMetaData(@Nullable @Query("token") String str, @Nullable @Query("provider") String str2, @Query("isSandbox") boolean z);

    @POST("2/app/metadata")
    @NotNull
    Observable<SuccessResult> sendMetaDataLegacy(@Nullable @Query("token") String str);
}
