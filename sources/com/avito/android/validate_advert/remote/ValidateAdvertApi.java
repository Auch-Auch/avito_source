package com.avito.android.validate_advert.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.PretendResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jc\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0003H'¢\u0006\u0004\b\u000b\u0010\fJc\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0003H'¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "", "", "", "navigation", "phone", "manager", "paramsAndSlots", "publishSessionId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateNewAdvertParamsWithNavigationV10", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "validateNewAdvertParamsWithNavigation", "validate-advert_release"}, k = 1, mv = {1, 4, 2})
public interface ValidateAdvertApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable validateNewAdvertParamsWithNavigation$default(ValidateAdvertApi validateAdvertApi, Map map, String str, String str2, Map map2, String str3, int i, Object obj) {
            if (obj == null) {
                return validateAdvertApi.validateNewAdvertParamsWithNavigation(map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, map2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateNewAdvertParamsWithNavigation");
        }

        public static /* synthetic */ Observable validateNewAdvertParamsWithNavigationV10$default(ValidateAdvertApi validateAdvertApi, Map map, String str, String str2, Map map2, String str3, int i, Object obj) {
            if (obj == null) {
                return validateAdvertApi.validateNewAdvertParamsWithNavigationV10(map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, map2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateNewAdvertParamsWithNavigationV10");
        }
    }

    @NotNull
    @NetworkRequestEventId(eventId = 3658)
    @FormUrlEncoded
    @POST("11/items/add/pretend")
    Observable<PretendResult> validateNewAdvertParamsWithNavigation(@FieldMap @NotNull Map<String, String> map, @Field("phone") @Nullable String str, @Field("manager") @Nullable String str2, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str3);

    @NotNull
    @NetworkRequestEventId(eventId = 3658)
    @FormUrlEncoded
    @POST("10/items/add/pretend")
    Observable<PretendResult> validateNewAdvertParamsWithNavigationV10(@FieldMap @NotNull Map<String, String> map, @Field("phone") @Nullable String str, @Field("manager") @Nullable String str2, @FieldMap @NotNull Map<String, String> map2, @Field("publishSessionId") @NotNull String str3);
}
