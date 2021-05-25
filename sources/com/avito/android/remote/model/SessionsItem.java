package com.avito.android.remote.model;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/SessionsItem;", "Lcom/avito/android/remote/model/SessionsElement;", "", "Lcom/avito/android/remote/model/SessionsAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "", "deviceId", "Ljava/lang/String;", "getDeviceId", "()Ljava/lang/String;", "sessionIdHash", "getSessionIdHash", "loginType", "getLoginType", "title", "getTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "", "isCurrent", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V", "sessions_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsItem implements SessionsElement {
    @SerializedName("actions")
    @Nullable
    private final List<SessionsAction> actions;
    @SerializedName("deviceId")
    @Nullable
    private final String deviceId;
    @SerializedName("isCurrent")
    @Nullable
    private final Boolean isCurrent;
    @SerializedName("loginType")
    @Nullable
    private final String loginType;
    @SerializedName("sessionIdHash")
    @Nullable
    private final String sessionIdHash;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public SessionsItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable List<SessionsAction> list, @Nullable Boolean bool, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        this.title = str;
        this.subtitle = str2;
        this.sessionIdHash = str3;
        this.deviceId = str4;
        this.actions = list;
        this.isCurrent = bool;
        this.loginType = str5;
    }

    @Nullable
    public final List<SessionsAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final String getLoginType() {
        return this.loginType;
    }

    @Nullable
    public final String getSessionIdHash() {
        return this.sessionIdHash;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isCurrent() {
        return this.isCurrent;
    }
}
