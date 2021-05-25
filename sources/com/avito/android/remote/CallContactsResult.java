package com.avito.android.remote;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/CallContactsResult;", "", "", "callAvailable", "Z", "getCallAvailable", "()Z", "", "callerName", "Ljava/lang/String;", "getCallerName", "()Ljava/lang/String;", "callTo", "getCallTo", "cannotCallReason", "getCannotCallReason", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallContactsResult {
    @SerializedName("can")
    private final boolean callAvailable;
    @SerializedName("recipientLogin")
    @Nullable
    private final String callTo;
    @SerializedName("callerLogin")
    @Nullable
    private final String callerName;
    @SerializedName("reason")
    @Nullable
    private final String cannotCallReason;

    public CallContactsResult(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.callAvailable = z;
        this.callTo = str;
        this.callerName = str2;
        this.cannotCallReason = str3;
    }

    public final boolean getCallAvailable() {
        return this.callAvailable;
    }

    @Nullable
    public final String getCallTo() {
        return this.callTo;
    }

    @Nullable
    public final String getCallerName() {
        return this.callerName;
    }

    @Nullable
    public final String getCannotCallReason() {
        return this.cannotCallReason;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallContactsResult(boolean z, String str, String str2, String str3, int i, j jVar) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
