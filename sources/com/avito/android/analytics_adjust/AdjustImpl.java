package com.avito.android.analytics_adjust;

import a2.g.r.g;
import android.app.Application;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;
import com.avito.android.analytics_adjust.di.AdjustAppToken;
import com.avito.android.analytics_adjust.di.AdjustDefaultTracker;
import com.avito.android.di.module.DeviceId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.Strings;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sumsub.sns.core.common.SNSConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0001\u0010 \u001a\u00020\n\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0018\u0010(\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001e¨\u0006+"}, d2 = {"Lcom/avito/android/analytics_adjust/AdjustImpl;", "Lcom/avito/android/analytics_adjust/Adjust;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "setPushToken", "(Ljava/lang/String;)V", ChannelContext.Item.USER_ID, "setUserIdentifier", "Lcom/adjust/sdk/AdjustEvent;", "event", "trackEvent", "(Lcom/adjust/sdk/AdjustEvent;)V", "onPause", "()V", "onResume", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "Z", "Landroid/app/Application;", "c", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Ljava/lang/String;", "e", "appToken", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "buildInfo", g.a, "deviceId", "f", "adjustDefaultTracker", "<init>", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public final class AdjustImpl implements Adjust {
    public String a;
    public volatile boolean b;
    public final Application c;
    public final BuildInfo d;
    public final String e;
    public final String f;
    public final String g;

    @Inject
    public AdjustImpl(@NotNull Application application, @NotNull BuildInfo buildInfo, @AdjustAppToken @NotNull String str, @AdjustDefaultTracker @Nullable String str2, @DeviceId @Nullable String str3) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(str, "appToken");
        this.c = application;
        this.d = buildInfo;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    public final void a() {
        boolean isDebug = this.d.isDebug();
        AdjustConfig adjustConfig = new AdjustConfig(this.c, this.e, isDebug ? AdjustConfig.ENVIRONMENT_SANDBOX : AdjustConfig.ENVIRONMENT_PRODUCTION, isDebug);
        adjustConfig.setSendInBackground(true);
        adjustConfig.setLogLevel(isDebug ? LogLevel.DEBUG : LogLevel.SUPRESS);
        String str = this.f;
        if (str != null) {
            adjustConfig.setDefaultTracker(str);
        }
        String str2 = this.g;
        if (str2 != null) {
            Adjust.addSessionCallbackParameter("android_deviceid", str2);
        }
        Adjust.onCreate(adjustConfig);
        Logs.verbose$default("AdjustWrapper", "Adjust initialized", null, 4, null);
    }

    @Override // com.avito.android.util.Initializable
    public synchronized void initialize(@Nullable Function0<Unit> function0) {
        if (!this.b) {
            a();
            this.b = true;
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.b;
    }

    @Override // com.avito.android.analytics_adjust.Adjust
    public void onPause() {
        Adjust.onPause();
    }

    @Override // com.avito.android.analytics_adjust.Adjust
    public void onResume() {
        Adjust.onResume();
    }

    @Override // com.avito.android.analytics_adjust.Adjust
    public void setPushToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Adjust.setPushToken(str, this.c);
    }

    @Override // com.avito.android.analytics_adjust.Adjust
    public void setUserIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.a = str.length() > 0 ? Strings.md5(str) : null;
    }

    @Override // com.avito.android.analytics_adjust.Adjust
    public void trackEvent(@NotNull AdjustEvent adjustEvent) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        String str = this.a;
        if (str != null) {
            adjustEvent.addPartnerParameter("user_id", str);
        } else {
            String str2 = this.g;
            if (str2 != null) {
                adjustEvent.addPartnerParameter(SNSConstants.Preference.KEY_DEVICE_ID, str2);
            }
        }
        Adjust.trackEvent(adjustEvent);
    }
}
