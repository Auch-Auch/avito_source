package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirelogAnalyticsEvent;
public class MessagingAnalytics {
    private static final DataEncoder dataEncoder = new JsonDataEncoderBuilder().registerEncoder(FirelogAnalyticsEvent.FirelogAnalyticsEventWrapper.class, (ObjectEncoder) new FirelogAnalyticsEvent.FirelogAnalyticsEventWrapperEncoder()).registerEncoder(FirelogAnalyticsEvent.class, (ObjectEncoder) new FirelogAnalyticsEvent.FirelogAnalyticsEventEncoder()).build();

    public static boolean deliveryMetricsExportToBigQueryEnabled() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            FirebaseApp.getInstance();
            Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            PackageManager packageManager = applicationContext.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("delivery_metrics_exported_to_big_query_enabled"))) {
                return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    @Nullable
    public static String getCollapseKey(Intent intent) {
        return intent.getStringExtra(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    @Nullable
    public static String getComposerId(Intent intent) {
        return intent.getStringExtra(Constants.AnalyticsKeys.COMPOSER_ID);
    }

    @Nullable
    public static String getComposerLabel(Intent intent) {
        return intent.getStringExtra(Constants.AnalyticsKeys.COMPOSER_LABEL);
    }

    @NonNull
    public static String getInstanceId() {
        return FirebaseInstanceId.getInstance(FirebaseApp.getInstance()).getId();
    }

    @Nullable
    public static String getMessageChannel(Intent intent) {
        return intent.getStringExtra(Constants.AnalyticsKeys.MESSAGE_CHANNEL);
    }

    @Nullable
    public static String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    @Nullable
    public static String getMessageLabel(Intent intent) {
        return intent.getStringExtra(Constants.AnalyticsKeys.MESSAGE_LABEL);
    }

    @NonNull
    private static int getMessagePriority(String str) {
        if (com.adjust.sdk.Constants.HIGH.equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public static String getMessageTime(Intent intent) {
        return intent.getStringExtra(Constants.AnalyticsKeys.MESSAGE_TIMESTAMP);
    }

    @NonNull
    @Constants.FirelogAnalytics.MessageType
    public static String getMessageTypeForFirelog(Intent intent) {
        return (intent.getExtras() == null || !NotificationParams.isNotification(intent.getExtras())) ? Constants.FirelogAnalytics.MessageType.DATA_MESSAGE : Constants.FirelogAnalytics.MessageType.DISPLAY_NOTIFICATION;
    }

    @NonNull
    public static String getMessageTypeForScion(Intent intent) {
        return (intent.getExtras() == null || !NotificationParams.isNotification(intent.getExtras())) ? "data" : "display";
    }

    @NonNull
    public static String getPackageName() {
        return FirebaseApp.getInstance().getApplicationContext().getPackageName();
    }

    @NonNull
    public static int getPriority(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.DELIVERED_PRIORITY);
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_REDUCED_V19))) {
                return 2;
            }
            stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return getMessagePriority(stringExtra);
    }

    @Nullable
    public static String getProjectNumber() {
        FirebaseApp instance = FirebaseApp.getInstance();
        String gcmSenderId = instance.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = instance.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    @Nullable
    public static String getTopic(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    @NonNull
    public static int getTtl(Intent intent) {
        Object obj = intent.getExtras().get(Constants.MessagePayloadKeys.TTL);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String.valueOf(obj).length();
            return 0;
        }
    }

    @Nullable
    public static String getUseDeviceTime(Intent intent) {
        if (intent.hasExtra(Constants.AnalyticsKeys.MESSAGE_USE_DEVICE_TIME)) {
            return intent.getStringExtra(Constants.AnalyticsKeys.MESSAGE_USE_DEVICE_TIME);
        }
        return null;
    }

    private static boolean isDirectBootMessage(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    public static void logNotificationDismiss(Intent intent) {
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_DISMISS, intent);
    }

    public static void logNotificationForeground(Intent intent) {
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_FOREGROUND, intent);
    }

    public static void logNotificationOpen(Intent intent) {
        setUserPropertyIfRequired(intent);
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_OPEN, intent);
    }

    public static void logNotificationReceived(Intent intent, @Nullable Transport<String> transport) {
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_RECEIVE, intent);
        if (transport != null) {
            logToFirelog(Constants.FirelogAnalytics.EventType.MESSAGE_DELIVERED, intent, transport);
        }
    }

    private static void logToFirelog(@Constants.FirelogAnalytics.EventType String str, Intent intent, Transport<String> transport) {
        try {
            transport.send(Event.ofTelemetry(dataEncoder.encode(new FirelogAnalyticsEvent.FirelogAnalyticsEventWrapper(new FirelogAnalyticsEvent(str, intent)))));
        } catch (EncodingException unused) {
        }
    }

    @VisibleForTesting
    public static void logToScion(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String composerId = getComposerId(intent);
        if (composerId != null) {
            bundle.putString("_nmid", composerId);
        }
        String composerLabel = getComposerLabel(intent);
        if (composerLabel != null) {
            bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_NAME, composerLabel);
        }
        String messageLabel = getMessageLabel(intent);
        if (!TextUtils.isEmpty(messageLabel)) {
            bundle.putString("label", messageLabel);
        }
        String messageChannel = getMessageChannel(intent);
        if (!TextUtils.isEmpty(messageChannel)) {
            bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_CHANNEL, messageChannel);
        }
        String topic = getTopic(intent);
        if (topic != null) {
            bundle.putString(Constants.ScionAnalytics.PARAM_TOPIC, topic);
        }
        String messageTime = getMessageTime(intent);
        if (messageTime != null) {
            try {
                bundle.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_TIME, Integer.parseInt(messageTime));
            } catch (NumberFormatException unused) {
            }
        }
        String useDeviceTime = getUseDeviceTime(intent);
        if (useDeviceTime != null) {
            try {
                bundle.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_DEVICE_TIME, Integer.parseInt(useDeviceTime));
            } catch (NumberFormatException unused2) {
            }
        }
        String messageTypeForScion = getMessageTypeForScion(intent);
        if (Constants.ScionAnalytics.EVENT_NOTIFICATION_RECEIVE.equals(str) || Constants.ScionAnalytics.EVENT_NOTIFICATION_FOREGROUND.equals(str)) {
            bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_TYPE, messageTypeForScion);
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String valueOf = String.valueOf(bundle);
            String.valueOf(str).length();
            valueOf.length();
        }
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if (analyticsConnector != null) {
            analyticsConnector.logEvent("fcm", str, bundle);
        }
    }

    public static void setDeliveryMetricsExportToBigQuery(boolean z) {
        FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", z).apply();
    }

    private static void setUserPropertyIfRequired(Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra(Constants.AnalyticsKeys.TRACK_CONVERSIONS))) {
                AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.getInstance().get(AnalyticsConnector.class);
                Log.isLoggable(Constants.TAG, 3);
                if (analyticsConnector != null) {
                    String stringExtra = intent.getStringExtra(Constants.AnalyticsKeys.COMPOSER_ID);
                    analyticsConnector.setUserProperty("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    analyticsConnector.logEvent("fcm", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                    return;
                }
                return;
            }
            Log.isLoggable(Constants.TAG, 3);
        }
    }

    public static boolean shouldUploadFirelogAnalytics(Intent intent) {
        if (intent == null || isDirectBootMessage(intent)) {
            return false;
        }
        return deliveryMetricsExportToBigQueryEnabled();
    }

    public static boolean shouldUploadScionMetrics(Intent intent) {
        if (intent == null || isDirectBootMessage(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra(Constants.AnalyticsKeys.ENABLED));
    }
}
