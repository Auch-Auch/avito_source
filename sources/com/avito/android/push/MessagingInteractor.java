package com.avito.android.push;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.analytics.event.ShowPushEvent;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.notification.NotificationParameters;
import com.avito.android.remote.notification.PushNotification;
import com.avito.android.util.GsonsKt;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/push/MessagingInteractor;", "", "", "", "data", "Lcom/avito/android/remote/notification/NotificationParameters;", "handleMessage", "(Ljava/util/Map;)Lcom/avito/android/remote/notification/NotificationParameters;", "Impl", "push_release"}, k = 1, mv = {1, 4, 2})
public interface MessagingInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/push/MessagingInteractor$Impl;", "Lcom/avito/android/push/MessagingInteractor;", "", "", "data", "Lcom/avito/android/remote/notification/NotificationParameters;", "handleMessage", "(Ljava/util/Map;)Lcom/avito/android/remote/notification/NotificationParameters;", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/push/MessagingResourceProvider;", "d", "Lcom/avito/android/push/MessagingResourceProvider;", "messagingResourceProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "e", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/google/gson/Gson;Lcom/avito/android/push/MessagingResourceProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "push_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements MessagingInteractor {
        public final Analytics a;
        public final DeepLinkFactory b;
        public final Gson c;
        public final MessagingResourceProvider d;
        public final NotificationManagerProvider e;

        public Impl(@NotNull Analytics analytics, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Gson gson, @NotNull MessagingResourceProvider messagingResourceProvider, @NotNull NotificationManagerProvider notificationManagerProvider) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(messagingResourceProvider, "messagingResourceProvider");
            Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
            this.a = analytics;
            this.b = deepLinkFactory;
            this.c = gson;
            this.d = messagingResourceProvider;
            this.e = notificationManagerProvider;
        }

        @Override // com.avito.android.push.MessagingInteractor
        @Nullable
        public NotificationParameters handleMessage(@NotNull Map<String, String> map) {
            String str;
            PushNotification pushNotification;
            Type type;
            Intrinsics.checkNotNullParameter(map, "data");
            String str2 = map.get(ShareConstants.MEDIA_URI);
            NotificationParameters notificationParameters = null;
            if (!(str2 == null || (str = map.get("notification")) == null)) {
                try {
                    Gson gson = this.c;
                    Type type2 = new MessagingInteractor$Impl$parsePushNotification$$inlined$fromJson$1().getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                    if (!(type2 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type2)) {
                        type = GsonsKt.removeTypeWildcards(type2);
                    } else {
                        type = ((ParameterizedType) type2).getRawType();
                        Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                    }
                    Object fromJson = gson.fromJson(str, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                    pushNotification = (PushNotification) fromJson;
                } catch (Exception e2) {
                    this.a.track(new ExceptionEvent(e2, null, 2, null));
                    pushNotification = null;
                }
                if (pushNotification != null) {
                    Map<String, String> analytics = pushNotification.getAnalytics();
                    if (this.e.getAreNotificationsEnabled() && analytics != null) {
                        this.a.track(new ShowPushEvent(analytics));
                    }
                    DeepLink createFromUri = this.b.createFromUri(str2);
                    Map<String, String> analytics2 = pushNotification.getAnalytics();
                    String title = pushNotification.getTitle();
                    if (title == null) {
                        title = this.d.getTitle();
                    }
                    String body = pushNotification.getBody();
                    if (body == null) {
                        body = "";
                    }
                    notificationParameters = new NotificationParameters(createFromUri, analytics2, title, body, pushNotification.getSoundAndVibrateEnabled(), pushNotification.getPayload(), pushNotification.getStyle(), pushNotification.getActions());
                }
            }
            return notificationParameters;
        }
    }

    @Nullable
    NotificationParameters handleMessage(@NotNull Map<String, String> map);
}
