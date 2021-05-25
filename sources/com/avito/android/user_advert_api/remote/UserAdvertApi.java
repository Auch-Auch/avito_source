package com.avito.android.user_advert_api.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.CloseReasonsResponse;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.adverts.RestoreAdvertResult;
import com.avito.android.remote.model.profile.ItemActivateResponse;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0007J)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0011J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002H'¢\u0006\u0004\b\u0018\u0010\u0007J%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u0007J3\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u001b\u001a\u00020\u001a2\b\b\u0003\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u001b\u001a\u00020\u001a2\b\b\u0003\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001f\u0010\u001eJ/\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000e0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u0002H'¢\u0006\u0004\b\"\u0010\fJ/\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000e0\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\u001aH'¢\u0006\u0004\b$\u0010%J%\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000e0\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b'\u0010\u0011¨\u0006("}, d2 = {"Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SuccessResult;", "activateAdvertLegacy", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/profile/ItemActivateResponse;", "activateAdvert", "reason", "deactivateAdvert", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/adverts/RestoreAdvertResult;", "restoreAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "deleteAdvert", "itemId", "Lcom/avito/android/remote/model/CloseReasonsResponse;", "getCloseReasons", "draftId", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "getMyDraftAdvertDetails", "deleteDraft", "", "includeRefs", "action", "getMyAdvertDetailsV15", "(Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "getMyAdvertDetailsV16", "newPrice", "Lcom/avito/android/remote/model/SimpleMessageResult;", "setAdvertPrice", "enabled", "setAutoPublishEnabled", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "", "notifyBannerClosed", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single getMyAdvertDetailsV15$default(UserAdvertApi userAdvertApi, String str, boolean z, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    str2 = "view";
                }
                return userAdvertApi.getMyAdvertDetailsV15(str, z, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyAdvertDetailsV15");
        }

        public static /* synthetic */ Single getMyAdvertDetailsV16$default(UserAdvertApi userAdvertApi, String str, boolean z, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    str2 = "view";
                }
                return userAdvertApi.getMyAdvertDetailsV16(str, z, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyAdvertDetailsV16");
        }
    }

    @POST("3/profile/item/{id}/activate")
    @NotNull
    Single<ItemActivateResponse> activateAdvert(@Path("id") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3746)
    @POST("2/profile/item/{id}/activate")
    Single<SuccessResult> activateAdvertLegacy(@Path("id") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3754)
    @FormUrlEncoded
    @POST("2/profile/item/{id}/stop")
    Single<SuccessResult> deactivateAdvert(@Path("id") @NotNull String str, @Field("reason") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3749)
    @POST("2/profile/item/{id}/delete")
    Observable<SuccessResult> deleteAdvert(@Path("id") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/item/draft/delete")
    Single<TypedResult<Object>> deleteDraft(@Field("id") @NotNull String str);

    @GET("4/reasons/close/item/{itemId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3797)
    Observable<CloseReasonsResponse> getCloseReasons(@Path("itemId") @NotNull String str);

    @GET("15/profile/item/{itemId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3745)
    Single<MyAdvertDetails> getMyAdvertDetailsV15(@Path("itemId") @NotNull String str, @Query("includeRefs") boolean z, @NotNull @Query("action") String str2);

    @GET("16/profile/item/{itemId}")
    @NotNull
    @NetworkRequestEventId(eventId = 3745)
    Single<MyAdvertDetails> getMyAdvertDetailsV16(@Path("itemId") @NotNull String str, @Query("includeRefs") boolean z, @NotNull @Query("action") String str2);

    @GET("1/item/draft/getCard")
    @NotNull
    Single<TypedResult<MyAdvertDetails>> getMyDraftAdvertDetails(@NotNull @Query("id") String str);

    @POST("1/profile/item/budles/banner/closed")
    @NotNull
    Observable<TypedResult<Unit>> notifyBannerClosed(@NotNull @Query("advertisementId") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3753)
    @POST("1/profile/item/{id}/restore")
    Observable<TypedResult<RestoreAdvertResult>> restoreAdvert(@Path("id") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/item/edit/setPrice")
    Single<TypedResult<SimpleMessageResult>> setAdvertPrice(@Field("itemId") @NotNull String str, @Field("newPrice") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/autoPublish/set")
    Single<TypedResult<SimpleMessageResult>> setAutoPublishEnabled(@Field("itemId") @NotNull String str, @Field("enabled") boolean z);
}
