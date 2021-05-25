package com.avito.android.beduin;

import com.avito.android.beduin.model.BeduinActionsResponse;
import com.avito.android.beduin.model.BeduinComponentsResponse;
import com.avito.android.remote.model.TypedResult;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\bJ=\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH'¢\u0006\u0004\b\u0010\u0010\u000fJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/beduin/BeduinApi;", "", "", "nextPage", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/beduin/model/BeduinComponentsResponse;", "getBeduinScreenContent", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/beduin/model/BeduinActionsResponse;", "executeGetRequest", "", SDKConstants.PARAM_A2U_BODY, "executePostRequest", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Single;", "executePutRequest", "executeDeleteRequest", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface BeduinApi {
    @DELETE
    @NotNull
    Single<TypedResult<BeduinActionsResponse>> executeDeleteRequest(@Url @NotNull String str);

    @GET
    @NotNull
    Single<TypedResult<BeduinActionsResponse>> executeGetRequest(@Url @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST
    Single<TypedResult<BeduinActionsResponse>> executePostRequest(@Url @NotNull String str, @FieldMap @Nullable Map<String, String> map);

    @PUT
    @NotNull
    @FormUrlEncoded
    Single<TypedResult<BeduinActionsResponse>> executePutRequest(@Url @NotNull String str, @FieldMap @Nullable Map<String, String> map);

    @GET
    @NotNull
    Single<TypedResult<BeduinComponentsResponse>> getBeduinScreenContent(@Url @NotNull String str);
}
