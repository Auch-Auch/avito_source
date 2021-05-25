package com.avito.android.remote;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VasUnionResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/VasUnionApi;", "", "", "checkoutContext", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/VasUnionResult;", "getUnionVas", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface VasUnionApi {
    @GET("1/vas/union")
    @NotNull
    Observable<TypedResult<VasUnionResult>> getUnionVas(@NotNull @Query("checkoutContext") String str);
}
