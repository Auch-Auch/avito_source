package com.avito.android.remote.notification;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.notification.NotificationParameters;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/remote/notification/PushNotification;", "", "", "soundAndVibrateEnabled", "Z", "getSoundAndVibrateEnabled", "()Z", "Lcom/avito/android/remote/model/notification/Payload;", "payload", "Lcom/avito/android/remote/model/notification/Payload;", "getPayload", "()Lcom/avito/android/remote/model/notification/Payload;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "analytics", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "Lcom/avito/android/remote/notification/NotificationParameters$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/notification/NotificationParameters$Style;", "getStyle", "()Lcom/avito/android/remote/notification/NotificationParameters$Style;", SDKConstants.PARAM_A2U_BODY, "getBody", "", "Lcom/avito/android/remote/model/Action;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/notification/Payload;Lcom/avito/android/remote/notification/NotificationParameters$Style;Ljava/util/List;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class PushNotification {
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName(SDKConstants.PARAM_A2U_BODY)
    @Nullable
    private final String body;
    @SerializedName("payload")
    @Nullable
    private final Payload payload;
    @SerializedName("soundAndVibrateEnabled")
    private final boolean soundAndVibrateEnabled;
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @Nullable
    private final NotificationParameters.Style style;
    @SerializedName("title")
    @Nullable
    private final String title;

    public PushNotification(@Nullable Map<String, String> map, @Nullable String str, @Nullable String str2, boolean z, @Nullable Payload payload2, @Nullable NotificationParameters.Style style2, @Nullable List<Action> list) {
        this.analytics = map;
        this.title = str;
        this.body = str2;
        this.soundAndVibrateEnabled = z;
        this.payload = payload2;
        this.style = style2;
        this.actions = list;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final Payload getPayload() {
        return this.payload;
    }

    public final boolean getSoundAndVibrateEnabled() {
        return this.soundAndVibrateEnabled;
    }

    @Nullable
    public final NotificationParameters.Style getStyle() {
        return this.style;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
