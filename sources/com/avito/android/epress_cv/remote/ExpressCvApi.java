package com.avito.android.epress_cv.remote;

import com.avito.android.epress_cv.remote.model.CreateExpressCvResult;
import com.avito.android.epress_cv.remote.model.CvResult;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH'¢\u0006\u0004\b\u000f\u0010\rJ1\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH'¢\u0006\u0004\b\u0011\u0010\rJ1\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH'¢\u0006\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/epress_cv/remote/ExpressCvApi;", "", "", "context", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", "getExpressCvInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "params", "Lcom/avito/android/epress_cv/remote/model/CvResult;", "activateCv", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateParams", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult;", "createCv", "disableExpressCv", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExpressCvApi {
    @NotNull
    @NetworkRequestEventId(eventId = 3622)
    @FormUrlEncoded
    @POST("2/cv/simple/activate")
    Observable<TypedResult<CvResult>> activateCv(@FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3623)
    @FormUrlEncoded
    @POST("2/cv/simple/create")
    Observable<TypedResult<CreateExpressCvResult>> createCv(@FieldMap @NotNull Map<String, String> map);

    @NotNull
    @NetworkRequestEventId(eventId = 3625)
    @FormUrlEncoded
    @POST("2/cv/simple/disable")
    Observable<TypedResult<CvResult>> disableExpressCv(@FieldMap @NotNull Map<String, String> map);

    @GET("2/cv/simple/info")
    @NotNull
    @NetworkRequestEventId(eventId = 3624)
    Observable<TypedResult<ExpressCvInfo>> getExpressCvInfo(@NotNull @Query("context") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3626)
    @FormUrlEncoded
    @POST("2/cv/simple/pretend")
    Observable<TypedResult<PretendResult>> validateParams(@FieldMap @NotNull Map<String, String> map);
}
