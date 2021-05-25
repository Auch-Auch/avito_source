package com.avito.android.rating.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.publish.AddRatingResult;
import com.avito.android.remote.model.publish.DealStagesResult;
import com.avito.android.remote.model.publish.RatingPublishResult;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import com.avito.android.remote.model.rating_details_legacy.RatingDetailsResult;
import com.avito.android.remote.model.review_reply.AddReviewReplyResult;
import com.avito.android.remote.model.review_reply.DeleteReviewReplyResult;
import com.avito.android.remote.model.user_contacts.UserContactsResult;
import com.avito.android.remote.model.user_reviews.UserReviewsResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\nJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u000e\u0010\nJ%\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\nJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0011\u0010\nJ\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00030\u0002H'¢\u0006\u0004\b\u0013\u0010\u0006J%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0013\u0010\nJ%\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u001b\u0010\nJ\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00030\u0002H'¢\u0006\u0004\b\u001e\u0010\u0006J\u0001\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b)\u0010*J\u0001\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b.\u0010/J\u0001\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b0\u0010/Jµ\u0001\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00072\u0016\b\u0001\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000101H'¢\u0006\u0004\b3\u00104J%\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b5\u0010\nJ'\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00030\u00022\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b7\u0010\nJ%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00030\u00022\b\b\u0001\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b8\u0010\nJ/\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u001f\u001a\u00020\u0007H'¢\u0006\u0004\b9\u0010\u001cJ;\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00030\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010:\u001a\u00020\u00072\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b<\u0010=J1\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00030\u00022\b\b\u0001\u0010>\u001a\u00020\u00142\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b@\u0010AJ%\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u00022\b\b\u0001\u0010'\u001a\u00020\u0007H'¢\u0006\u0004\bB\u0010\n¨\u0006C"}, d2 = {"Lcom/avito/android/rating/remote/RatingApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/rating_details/RatingDetailsResult;", "getUserProfileRatingDetails", "()Lio/reactivex/rxjava3/core/Observable;", "", "userKey", "getPublicProfileRatingDetails", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "shopId", "getShopRatingDetails", "nextPage", "getRatingDetails", "Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsResult;", "getLegacyPublicProfileRatingDetails", "getLegacyRatingDetails", "Lcom/avito/android/remote/model/user_reviews/UserReviewsResult;", "getUserReviews", "", "reviewId", "", "deleteReview", "(J)Lio/reactivex/rxjava3/core/Observable;", "query", "Lcom/avito/android/remote/model/publish/SearchUserAdvertsResult;", "searchUserAdverts", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/publish/DealStagesResult;", "getDealStages", "itemId", "stageId", "", "score", AbuseSendingResult.COMMENT, "files", "images", "buyerInfo", "context", "Lcom/avito/android/remote/model/publish/AddRatingResult;", "addRating", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "stepId", "autoFiles", "Lcom/avito/android/remote/model/publish/RatingPublishResult;", "addRatingForm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "addRatingFormV2", "", "dynamicParams", "addRatingFormV3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "checkRatingPublish", "Lcom/avito/android/remote/model/user_contacts/UserContactsResult;", "getContactList", "getContactListNextPage", "removeContact", "text", "Lcom/avito/android/remote/model/review_reply/AddReviewReplyResult;", "addReviewReply", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "answerId", "Lcom/avito/android/remote/model/review_reply/DeleteReviewReplyResult;", "deleteReviewReply", "(JLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "requestReview", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingApi {
    @NotNull
    @NetworkRequestEventId(eventId = 3789)
    @FormUrlEncoded
    @POST("2/rating/add")
    Observable<TypedResult<AddRatingResult>> addRating(@Field("userKey") @NotNull String str, @Field("itemId") @Nullable String str2, @Field("stageId") @Nullable Long l, @Field("score") @Nullable Integer num, @Field("comment") @Nullable String str3, @Field("files") @Nullable String str4, @Field("images") @Nullable String str5, @Field("buyerInfo") @Nullable String str6, @Field("context") @Nullable String str7);

    @NotNull
    @FormUrlEncoded
    @POST("1/rating/add/form")
    Observable<TypedResult<RatingPublishResult>> addRatingForm(@Field("userKey") @NotNull String str, @Field("context") @Nullable String str2, @Field("stepId") @Nullable String str3, @Field("items[itemId]") @Nullable String str4, @Field("score[score]") @Nullable Integer num, @Field("stages[stageId]") @Nullable Long l, @Field("comment[comment]") @Nullable String str5, @Field("dealProof[files]") @Nullable String str6, @Field("buyerInfo[buyerInfo]") @Nullable String str7, @Field("regVehicle[files]") @Nullable String str8, @Field("images[images]") @Nullable String str9);

    @NotNull
    @FormUrlEncoded
    @POST("2/rating/add/form")
    Observable<TypedResult<RatingPublishResult>> addRatingFormV2(@Field("userKey") @NotNull String str, @Field("context") @Nullable String str2, @Field("stepId") @Nullable String str3, @Field("items[itemId]") @Nullable String str4, @Field("score[score]") @Nullable Integer num, @Field("stages[stageId]") @Nullable Long l, @Field("comment[comment]") @Nullable String str5, @Field("dealProof[files]") @Nullable String str6, @Field("buyerInfo[buyerInfo]") @Nullable String str7, @Field("regVehicle[files]") @Nullable String str8, @Field("images[images]") @Nullable String str9);

    @NotNull
    @FormUrlEncoded
    @POST("3/rating/add/form")
    Observable<TypedResult<RatingPublishResult>> addRatingFormV3(@Field("userKey") @NotNull String str, @Field("context") @Nullable String str2, @Field("stepId") @Nullable String str3, @Field("items[itemId]") @Nullable String str4, @Field("score[score]") @Nullable Integer num, @Field("stages[stageId]") @Nullable Long l, @Field("comment[comment]") @Nullable String str5, @Field("dealProof[files]") @Nullable String str6, @Field("buyerInfo[buyerInfo]") @Nullable String str7, @Field("regVehicle[files]") @Nullable String str8, @Field("images[images]") @Nullable String str9, @FieldMap @Nullable Map<String, String> map);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/reviews/answer/add")
    Observable<TypedResult<AddReviewReplyResult>> addReviewReply(@Field("reviewId") long j, @Field("text") @NotNull String str, @Field("context") @Nullable String str2);

    @GET("1/rating/check")
    @NotNull
    @NetworkRequestEventId(eventId = 3791)
    Observable<TypedResult<Unit>> checkRatingPublish(@NotNull @Query("userKey") String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3773)
    @FormUrlEncoded
    @HTTP(hasBody = true, method = "DELETE", path = "1/profile/reviews/delete")
    Observable<TypedResult<Unit>> deleteReview(@Field("reviewId") long j);

    @NotNull
    @FormUrlEncoded
    @POST("1/profile/reviews/answer/delete")
    Observable<TypedResult<DeleteReviewReplyResult>> deleteReviewReply(@Field("answerId") long j, @Field("context") @Nullable String str);

    @GET("1/rating/contacts/list")
    @NotNull
    @NetworkRequestEventId(eventId = 3792)
    Observable<TypedResult<UserContactsResult>> getContactList(@Nullable @Query("context") String str);

    @GET
    @NotNull
    Observable<TypedResult<UserContactsResult>> getContactListNextPage(@Url @NotNull String str);

    @GET("1/rating/stages")
    @NotNull
    @NetworkRequestEventId(eventId = 3795)
    Observable<TypedResult<DealStagesResult>> getDealStages();

    @GET("2/user/{userKey}/ratings")
    @NotNull
    @NetworkRequestEventId(eventId = 3600)
    Observable<TypedResult<RatingDetailsResult>> getLegacyPublicProfileRatingDetails(@Path("userKey") @NotNull String str);

    @GET
    @NotNull
    Observable<TypedResult<RatingDetailsResult>> getLegacyRatingDetails(@Url @NotNull String str);

    @GET("3/user/{userKey}/ratings")
    @NotNull
    @NetworkRequestEventId(eventId = 3600)
    Observable<TypedResult<com.avito.android.remote.model.rating_details.RatingDetailsResult>> getPublicProfileRatingDetails(@Path("userKey") @NotNull String str);

    @GET
    @NotNull
    Observable<TypedResult<com.avito.android.remote.model.rating_details.RatingDetailsResult>> getRatingDetails(@Url @NotNull String str);

    @GET("2/shop/{shopId}/ratings")
    @NotNull
    @NetworkRequestEventId(eventId = 3818)
    Observable<TypedResult<com.avito.android.remote.model.rating_details.RatingDetailsResult>> getShopRatingDetails(@Path("shopId") @NotNull String str);

    @GET("4/profile/ratings")
    @NotNull
    @NetworkRequestEventId(eventId = 3771)
    Observable<TypedResult<com.avito.android.remote.model.rating_details.RatingDetailsResult>> getUserProfileRatingDetails();

    @GET("2/profile/reviews")
    @NotNull
    Observable<TypedResult<UserReviewsResult>> getUserReviews();

    @GET
    @NotNull
    Observable<TypedResult<UserReviewsResult>> getUserReviews(@Url @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3793)
    @FormUrlEncoded
    @POST("1/rating/contacts/remove")
    Observable<TypedResult<Unit>> removeContact(@Field("hashUserId") @NotNull String str, @Field("itemId") @NotNull String str2);

    @NotNull
    @FormUrlEncoded
    @POST("1/rating/messenger/request/send")
    Observable<TypedResult<Unit>> requestReview(@Field("context") @NotNull String str);

    @GET
    @NotNull
    Observable<TypedResult<SearchUserAdvertsResult>> searchUserAdverts(@Url @NotNull String str);

    @GET("1/user/{userKey}/search")
    @NotNull
    Observable<TypedResult<SearchUserAdvertsResult>> searchUserAdverts(@Path("userKey") @NotNull String str, @Nullable @Query("query") String str2);
}
