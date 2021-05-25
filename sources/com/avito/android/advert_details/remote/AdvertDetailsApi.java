package com.avito.android.advert_details.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.messenger.UserOnlineStatus;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.ConsultationRequestResult;
import com.avito.android.remote.model.ContactInfoResponse;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UpdateAdvertNoteResponse;
import com.avito.android.remote.model.advert_badge_bar.BadgeDetailsResponse;
import com.avito.android.remote.model.advert_details.FeedbackResponse;
import com.avito.android.remote.model.advert_details.commercials.AdvertCommercialsResponse;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.remote.parse.adapter.stream_gson.StreamParsing;
import com.google.firebase.messaging.Constants;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJC\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\r\u0010\u000eJC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000f\u0010\u000eJ%\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\bJ+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\bJ/\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00050\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0002H'¢\u0006\u0004\b\u001c\u0010\u0017J1\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001e\u0010\u0017Ja\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00050\u0004H'¢\u0006\u0004\b'\u0010(JS\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00050\u00042\b\b\u0001\u0010)\u001a\u00020\u00022\b\b\u0001\u0010*\u001a\u00020\u00022\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b.\u0010/J9\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00050\u00042\b\b\u0001\u00100\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u000202H'¢\u0006\u0004\b5\u00106JI\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00108\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b:\u0010\u000eJI\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00108\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b;\u0010\u000eJM\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00050\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b=\u0010\u000e¨\u0006>"}, d2 = {"Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/DfpBannerItem;", "getCreditInfo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "context", "requestId", "locationId", "Lcom/avito/android/remote/model/AdvertDetails;", "getAdvertDetailsV15", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getAdvertDetails", "userHashId", "Lcom/avito/android/remote/messenger/UserOnlineStatus;", "getUserOnlineStatus", BookingInfoActivity.EXTRA_ITEM_ID, "from", "Lcom/avito/android/remote/model/section/SectionResponse;", "getComplementaryItems", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/advert_details/commercials/AdvertCommercialsResponse;", "getCommercials", "content", "", "createNote", "Lcom/avito/android/remote/model/UpdateAdvertNoteResponse;", "updateNote", ChannelContext.Item.USER_ID, "categoryId", "feedback", Constants.FirelogAnalytics.PARAM_TOPIC, "Lcom/avito/android/remote/model/advert_details/FeedbackResponse;", "sendFeedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ContactInfoResponse;", "getContactInfo", "()Lio/reactivex/rxjava3/core/Observable;", "phone", "name", "url", "developmentId", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "getAdvice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "objectId", "objectEntity", "", "badgeId", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;", "getBadgeDetails", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "locationIdFrom", "locationIdTo", "Lcom/avito/android/remote/model/DeliveryInfoResponse;", "getDeliveryInfo", "getDeliveryInfoWithOptionalAction", "reportType", "sendCreReportsData", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getAdvertDetails$default(AdvertDetailsApi advertDetailsApi, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return advertDetailsApi.getAdvertDetails(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAdvertDetails");
        }

        public static /* synthetic */ Observable getAdvertDetailsV15$default(AdvertDetailsApi advertDetailsApi, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return advertDetailsApi.getAdvertDetailsV15(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAdvertDetailsV15");
        }

        public static /* synthetic */ Observable getComplementaryItems$default(AdvertDetailsApi advertDetailsApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return advertDetailsApi.getComplementaryItems(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComplementaryItems");
        }
    }

    @NotNull
    @FormUrlEncoded
    @POST("1/notes/create")
    Observable<TypedResult<Unit>> createNote(@Field("itemId") @NotNull String str, @Field("content") @NotNull String str2);

    @GET("16/items/{itemId}?includeRefs=1")
    @NotNull
    @NetworkRequestEventId(eventId = 3376)
    Observable<AdvertDetails> getAdvertDetails(@Path("itemId") @NotNull String str, @Nullable @Query("context") String str2, @Nullable @Query("requestId") String str3, @Nullable @Query("locationId") String str4);

    @GET("15/items/{itemId}?includeRefs=1")
    @NotNull
    @NetworkRequestEventId(eventId = 3376)
    Observable<AdvertDetails> getAdvertDetailsV15(@Path("itemId") @NotNull String str, @Nullable @Query("context") String str2, @Nullable @Query("requestId") String str3, @Nullable @Query("locationId") String str4);

    @NotNull
    @FormUrlEncoded
    @POST("1/developments-advice/getAdvice")
    Observable<TypedResult<ConsultationRequestResult>> getAdvice(@Field("phone") @NotNull String str, @Field("name") @NotNull String str2, @Field("url") @Nullable String str3, @Field("itemId") @Nullable String str4, @Field("developmentId") @Nullable String str5);

    @GET("1/badges/content")
    @NotNull
    Observable<TypedResult<BadgeDetailsResponse>> getBadgeDetails(@NotNull @Query("objectId") String str, @NotNull @Query("objectEntity") String str2, @Query("badgeId") int i);

    @StreamParsing
    @GET("2/items/{advertId}/banners")
    @NotNull
    @NetworkRequestEventId(eventId = 3666)
    Observable<TypedResult<AdvertCommercialsResponse>> getCommercials(@Path("advertId") @NotNull String str);

    @GET("2/items/{advertId}/complementary")
    @NotNull
    @NetworkRequestEventId(eventId = 3667)
    Observable<SectionResponse> getComplementaryItems(@Path("advertId") @NotNull String str, @Nullable @Query("from") String str2);

    @POST("1/developments-advice/getContactInfo")
    @NotNull
    Observable<TypedResult<ContactInfoResponse>> getContactInfo();

    @StreamParsing
    @GET("1/items/{itemId}/credit_info")
    @NotNull
    @NetworkRequestEventId(eventId = 3671)
    Observable<TypedResult<DfpBannerItem>> getCreditInfo(@Path("itemId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/delivery/pricesAndTerms")
    Observable<TypedResult<DeliveryInfoResponse>> getDeliveryInfo(@Field("itemId") @NotNull String str, @Field("context") @Nullable String str2, @Field("locationIdFrom") @Nullable String str3, @Field("locationIdTo") @Nullable String str4);

    @NotNull
    @FormUrlEncoded
    @POST("2/delivery/pricesAndTerms")
    Observable<TypedResult<DeliveryInfoResponse>> getDeliveryInfoWithOptionalAction(@Field("itemId") @NotNull String str, @Field("context") @Nullable String str2, @Field("locationIdFrom") @Nullable String str3, @Field("locationIdTo") @Nullable String str4);

    @GET("1/user/{userHashId}/get-status")
    @NotNull
    @NetworkRequestEventId(eventId = 3844)
    Observable<TypedResult<UserOnlineStatus>> getUserOnlineStatus(@Path("userHashId") @NotNull String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/cre-report/acceptFakeOffer")
    Observable<TypedResult<Unit>> sendCreReportsData(@Field("itemId") @Nullable String str, @Field("name") @Nullable String str2, @Field("phone") @Nullable String str3, @Field("type") @Nullable String str4);

    @NotNull
    @FormUrlEncoded
    @POST("1/feedback/add")
    Observable<TypedResult<FeedbackResponse>> sendFeedback(@Field("itemId") @Nullable String str, @Field("userId") @Nullable String str2, @Field("requestId") @NotNull String str3, @Field("categoryId") @Nullable String str4, @Field("feedback") @Nullable String str5, @Field("topic") @Nullable String str6);

    @NotNull
    @FormUrlEncoded
    @POST("1/notes/update")
    Observable<TypedResult<UpdateAdvertNoteResponse>> updateNote(@Field("itemId") @NotNull String str, @Field("content") @Nullable String str2);
}
