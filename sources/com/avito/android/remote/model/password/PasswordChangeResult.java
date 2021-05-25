package com.avito.android.remote.model.password;

import a2.b.a.a.a;
import com.avito.android.util.preferences.SessionContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/password/PasswordChangeResult;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", SessionContract.SESSION, "getSession", "refreshToken", "getRefreshToken", "pushToken", "getPushToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeResult {
    @SerializedName("phash")
    @NotNull
    private final String pushToken;
    @SerializedName("refreshToken")
    @NotNull
    private final String refreshToken;
    @SerializedName(SessionContract.SESSION)
    @NotNull
    private final String session;
    @SerializedName("text")
    @NotNull
    private final String text;

    public PasswordChangeResult(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.b1(str, "text", str2, SessionContract.SESSION, str3, "refreshToken", str4, "pushToken");
        this.text = str;
        this.session = str2;
        this.refreshToken = str3;
        this.pushToken = str4;
    }

    @NotNull
    public final String getPushToken() {
        return this.pushToken;
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getSession() {
        return this.session;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
