package com.avito.android.in_app_calls.logging;

import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/avito/android/in_app_calls/logging/LogHeader;", "", "", "osApi", "I", "getOsApi", "()I", "", "osVersion", "Ljava/lang/String;", "getOsVersion", "()Ljava/lang/String;", "os", "getOs", ChannelContext.Item.USER_ID, "getUserId", "appVersion", "getAppVersion", "vendor", "getVendor", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "getModel", "deviceId", "getDeviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class LogHeader {
    @SerializedName("appVersion")
    @NotNull
    private final String appVersion;
    @SerializedName("deviceId")
    @NotNull
    private final String deviceId;
    @SerializedName(VerticalFilterCloseDialogEventKt.MODEL_DIALOG)
    @NotNull
    private final String model;
    @SerializedName("osType")
    @NotNull
    private final String os;
    @SerializedName("osApi")
    private final int osApi;
    @SerializedName("osVersion")
    @NotNull
    private final String osVersion;
    @SerializedName(ChannelContext.Item.USER_ID)
    @NotNull
    private final String userId;
    @SerializedName("vendor")
    @NotNull
    private final String vendor;

    public LogHeader(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        Intrinsics.checkNotNullParameter(str3, "os");
        Intrinsics.checkNotNullParameter(str4, "vendor");
        Intrinsics.checkNotNullParameter(str5, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(str6, "osVersion");
        Intrinsics.checkNotNullParameter(str7, "appVersion");
        this.userId = str;
        this.deviceId = str2;
        this.os = str3;
        this.vendor = str4;
        this.model = str5;
        this.osVersion = str6;
        this.osApi = i;
        this.appVersion = str7;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getOs() {
        return this.os;
    }

    public final int getOsApi() {
        return this.osApi;
    }

    @NotNull
    public final String getOsVersion() {
        return this.osVersion;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getVendor() {
        return this.vendor;
    }
}
