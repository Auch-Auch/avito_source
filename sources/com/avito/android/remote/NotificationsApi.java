package com.avito.android.remote;

import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.ResultWithSuccess;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.notification.NotificationsCount;
import com.avito.android.remote.model.notification.NotificationsResponse;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedback;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedbackResult;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedbackResult;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingMain;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingShare;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingUnified;
import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.GeoContract;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0007H'¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u0010J%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0010J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u0007H'¢\u0006\u0004\b\u0014\u0010\u000eJ%\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0010J%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u0010J%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u0010J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b0\u0007H'¢\u0006\u0004\b\u001d\u0010\u000eJ9\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b&\u0010\u0010J/\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\u0005H'¢\u0006\u0004\b)\u0010*J/\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020 H'¢\u0006\u0004\b-\u0010.J/\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010/\u001a\u00020\u0002H'¢\u0006\u0004\b1\u00102J/\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0002H'¢\u0006\u0004\b4\u00102J%\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\b0\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b6\u0010\u0010¨\u00067"}, d2 = {"Lcom/avito/android/remote/NotificationsApi;", "", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, GeoContract.PROVIDER, "", "isSandbox", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ResultWithSuccess;", "registerNotificationToken", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/notification/NotificationsResponse;", "getNotifications", "()Lio/reactivex/rxjava3/core/Observable;", "nextPage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "notificationId", "Lcom/avito/android/remote/model/notification/NotificationsCount;", "markNotificationAsRead", "getNotificationsCount", "id", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "getNotificationCenterLandingUnified", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;", "getNotificationCenterLandingMain", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;", "getNotificationCenterLandingRecommends", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "getNotificationsSettings", "section", "channel", "", "value", "", "saveNotificationsSettings", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "getNotificationCenterLandingFeedback", "isPositiveAction", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedbackResult;", "sendNotificationCenterLandingFeedbackResult", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", ContextActionHandler.MethodCall.REACTION, "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedback;", "getNcRecommendsFeedback", "(Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "reasonId", "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedbackResult;", "getNcRecommendsFeedbackResultWithId", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", AvatarStatus.REVIEW, "getNcRecommendsFeedbackResultWithReview", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare;", "getNotificationsShare", "notifications_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsApi {
    @GET("1/notifications/recommends/{id}/feedback/show")
    @NotNull
    @NetworkRequestEventId(eventId = 3607)
    Observable<TypedResult<NcRecommendsFeedback>> getNcRecommendsFeedback(@Path("id") @NotNull String str, @Query("reaction") int i);

    @NotNull
    @NetworkRequestEventId(eventId = 3698)
    @FormUrlEncoded
    @POST("1/notifications/recommends/{id}/feedback/reasons/result")
    Observable<TypedResult<NcRecommendsFeedbackResult>> getNcRecommendsFeedbackResultWithId(@Path("id") @NotNull String str, @Field("reasonId") @NotNull String str2);

    @NotNull
    @NetworkRequestEventId(eventId = 3699)
    @FormUrlEncoded
    @POST("1/notifications/recommends/{id}/feedback/review/result")
    Observable<TypedResult<NcRecommendsFeedbackResult>> getNcRecommendsFeedbackResultWithReview(@Path("id") @NotNull String str, @Field("review") @NotNull String str2);

    @GET("1/notifications/feedback/{id}/show")
    @NotNull
    @NetworkRequestEventId(eventId = 3605)
    Observable<TypedResult<NotificationCenterLandingFeedback>> getNotificationCenterLandingFeedback(@Path("id") @NotNull String str);

    @GET("1/notifications/main/{id}")
    @NotNull
    @NetworkRequestEventId(eventId = 3697)
    Observable<TypedResult<NotificationCenterLandingMain>> getNotificationCenterLandingMain(@Path("id") @NotNull String str);

    @GET("1/notifications/recommends/{id}")
    @NotNull
    @NetworkRequestEventId(eventId = 3606)
    @Headers({ConstsKt.GEO})
    Observable<TypedResult<NotificationCenterLandingRecommends>> getNotificationCenterLandingRecommends(@Path("id") @NotNull String str);

    @GET("1/notifications/unified/{id}")
    @NotNull
    @NetworkRequestEventId(eventId = 3705)
    Observable<TypedResult<NotificationCenterLandingUnified>> getNotificationCenterLandingUnified(@Path("id") @NotNull String str);

    @GET("1/notifications")
    @NotNull
    @NetworkRequestEventId(eventId = 3695)
    Observable<TypedResult<NotificationsResponse>> getNotifications();

    @GET
    @NotNull
    Observable<TypedResult<NotificationsResponse>> getNotifications(@Url @NotNull String str);

    @GET("1/notifications/count")
    @NotNull
    @NetworkRequestEventId(eventId = 3696)
    Observable<TypedResult<NotificationsCount>> getNotificationsCount();

    @GET("2/notifications/settings")
    @NotNull
    Observable<TypedResult<NotificationsSettings>> getNotificationsSettings();

    @GET("2/notifications/share/{id}")
    @NotNull
    Observable<TypedResult<NotificationCenterLandingShare>> getNotificationsShare(@Path("id") @NotNull String str);

    @PUT("1/notifications/{id}/read")
    @NotNull
    @NetworkRequestEventId(eventId = 3706)
    Observable<TypedResult<NotificationsCount>> markNotificationAsRead(@Path("id") @NotNull String str);

    @NotNull
    @NetworkRequestEventId(eventId = 3704)
    @FormUrlEncoded
    @POST("2/notifications/token")
    Observable<TypedResult<ResultWithSuccess>> registerNotificationToken(@Field("token") @NotNull String str, @Field("provider") @Nullable String str2, @Field("isSandbox") boolean z);

    @PATCH("2/notifications/settings")
    @NotNull
    @FormUrlEncoded
    Observable<TypedResult<Unit>> saveNotificationsSettings(@Field("section") @NotNull String str, @Field("channel") @NotNull String str2, @Field("value") int i);

    @NotNull
    @NetworkRequestEventId(eventId = 3604)
    @FormUrlEncoded
    @POST("1/notifications/feedback/{id}/result")
    Observable<TypedResult<NotificationCenterLandingFeedbackResult>> sendNotificationCenterLandingFeedbackResult(@Path("id") @NotNull String str, @Field("isPositiveAction") boolean z);
}
