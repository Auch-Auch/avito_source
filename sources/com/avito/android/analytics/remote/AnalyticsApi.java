package com.avito.android.analytics.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JC\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\rJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/remote/AnalyticsApi;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "context", "source", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "advertCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "advertCallConfirmed", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "userKey", "shopContactsShowed", "shopCall", "analytics_release"}, k = 1, mv = {1, 4, 2})
public interface AnalyticsApi {
    @NotNull
    @NetworkRequestEventId(eventId = 3672)
    @POST("2/items/{advertId}/call")
    Observable<SuccessResult> advertCall(@Path("advertId") @NotNull String str, @Nullable @Query("context") String str2, @Nullable @Query("vsrc") String str3, @Nullable @Query("from_block") Integer num);

    @NotNull
    @NetworkRequestEventId(eventId = 3377)
    @POST("2/items/{advertId}/call/confirm")
    Observable<SuccessResult> advertCallConfirmed(@Path("advertId") @NotNull String str, @Nullable @Query("context") String str2);

    @POST("1/pro-profile/clickstream/call-phone")
    @NotNull
    Observable<SuccessResult> shopCall(@NotNull @Query("id") String str, @NotNull @Query("s") String str2);

    @POST("1/pro-profile/clickstream/view-phone")
    @NotNull
    Observable<SuccessResult> shopContactsShowed(@NotNull @Query("id") String str, @NotNull @Query("s") String str2);
}
