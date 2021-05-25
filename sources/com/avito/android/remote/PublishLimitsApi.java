package com.avito.android.remote;

import com.avito.android.remote.model.AdvertsHistory;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\bJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\bJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\bJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/PublishLimitsApi;", "", "", "draftId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/LimitsInfo;", "getLimitsForDraft", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "itemId", "getLimitsForItem", "context", "getLimitsForUnpaidItem", "Lcom/avito/android/remote/model/AdvertsHistory;", "getLimitsHistoryForDraft", "getLimitsHistoryForItem", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public interface PublishLimitsApi {
    @GET("1/item/limits/getLimits")
    @NotNull
    Single<TypedResult<LimitsInfo>> getLimitsForDraft(@NotNull @Query("draftId") String str);

    @GET("1/item/limits/getLimits")
    @NotNull
    Single<TypedResult<LimitsInfo>> getLimitsForItem(@NotNull @Query("itemId") String str);

    @GET("1/item/limits/getLimits")
    @NotNull
    Single<TypedResult<LimitsInfo>> getLimitsForUnpaidItem(@NotNull @Query("paymentContext") String str);

    @GET("1/item/limits/history")
    @NotNull
    Single<TypedResult<AdvertsHistory>> getLimitsHistoryForDraft(@NotNull @Query("draftId") String str);

    @GET("1/item/limits/history")
    @NotNull
    Single<TypedResult<AdvertsHistory>> getLimitsHistoryForItem(@NotNull @Query("itemId") String str);
}
