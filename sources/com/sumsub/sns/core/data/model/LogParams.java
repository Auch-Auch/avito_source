package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import androidx.annotation.Keep;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004Jb\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/sumsub/sns/core/data/model/LogParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "errorType", "location", "externalUserId", "fileName", "applicantId", "message", MessageBody.Location.KIND, "stacktrace", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/LogParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStacktrace", "getLocation", "getKind", "getExternalUserId", "getErrorType", "getApplicantId", "getFileName", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class LogParams {
    @NotNull
    private final String applicantId;
    @NotNull
    private final String errorType;
    @Nullable
    private final String externalUserId;
    @NotNull
    private final String fileName;
    @NotNull
    private final String kind;
    @NotNull
    private final String location;
    @NotNull
    private final String message;
    @NotNull
    private final String stacktrace;

    public LogParams(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "errorType");
        Intrinsics.checkNotNullParameter(str2, "location");
        Intrinsics.checkNotNullParameter(str4, "fileName");
        Intrinsics.checkNotNullParameter(str5, "applicantId");
        Intrinsics.checkNotNullParameter(str6, "message");
        Intrinsics.checkNotNullParameter(str7, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(str8, "stacktrace");
        this.errorType = str;
        this.location = str2;
        this.externalUserId = str3;
        this.fileName = str4;
        this.applicantId = str5;
        this.message = str6;
        this.kind = str7;
        this.stacktrace = str8;
    }

    public static /* synthetic */ LogParams copy$default(LogParams logParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        return logParams.copy((i & 1) != 0 ? logParams.errorType : str, (i & 2) != 0 ? logParams.location : str2, (i & 4) != 0 ? logParams.externalUserId : str3, (i & 8) != 0 ? logParams.fileName : str4, (i & 16) != 0 ? logParams.applicantId : str5, (i & 32) != 0 ? logParams.message : str6, (i & 64) != 0 ? logParams.kind : str7, (i & 128) != 0 ? logParams.stacktrace : str8);
    }

    @NotNull
    public final String component1() {
        return this.errorType;
    }

    @NotNull
    public final String component2() {
        return this.location;
    }

    @Nullable
    public final String component3() {
        return this.externalUserId;
    }

    @NotNull
    public final String component4() {
        return this.fileName;
    }

    @NotNull
    public final String component5() {
        return this.applicantId;
    }

    @NotNull
    public final String component6() {
        return this.message;
    }

    @NotNull
    public final String component7() {
        return this.kind;
    }

    @NotNull
    public final String component8() {
        return this.stacktrace;
    }

    @NotNull
    public final LogParams copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "errorType");
        Intrinsics.checkNotNullParameter(str2, "location");
        Intrinsics.checkNotNullParameter(str4, "fileName");
        Intrinsics.checkNotNullParameter(str5, "applicantId");
        Intrinsics.checkNotNullParameter(str6, "message");
        Intrinsics.checkNotNullParameter(str7, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(str8, "stacktrace");
        return new LogParams(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogParams)) {
            return false;
        }
        LogParams logParams = (LogParams) obj;
        return Intrinsics.areEqual(this.errorType, logParams.errorType) && Intrinsics.areEqual(this.location, logParams.location) && Intrinsics.areEqual(this.externalUserId, logParams.externalUserId) && Intrinsics.areEqual(this.fileName, logParams.fileName) && Intrinsics.areEqual(this.applicantId, logParams.applicantId) && Intrinsics.areEqual(this.message, logParams.message) && Intrinsics.areEqual(this.kind, logParams.kind) && Intrinsics.areEqual(this.stacktrace, logParams.stacktrace);
    }

    @NotNull
    public final String getApplicantId() {
        return this.applicantId;
    }

    @NotNull
    public final String getErrorType() {
        return this.errorType;
    }

    @Nullable
    public final String getExternalUserId() {
        return this.externalUserId;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    @NotNull
    public final String getKind() {
        return this.kind;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getStacktrace() {
        return this.stacktrace;
    }

    public int hashCode() {
        String str = this.errorType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.location;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.externalUserId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fileName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.applicantId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.message;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.kind;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.stacktrace;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LogParams(errorType=");
        L.append(this.errorType);
        L.append(", location=");
        L.append(this.location);
        L.append(", externalUserId=");
        L.append(this.externalUserId);
        L.append(", fileName=");
        L.append(this.fileName);
        L.append(", applicantId=");
        L.append(this.applicantId);
        L.append(", message=");
        L.append(this.message);
        L.append(", kind=");
        L.append(this.kind);
        L.append(", stacktrace=");
        return a.t(L, this.stacktrace, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, j jVar) {
        this((i & 1) != 0 ? "msdkError" : str, str2, str3, str4, str5, str6, (i & 64) != 0 ? ServerProtocol.DIALOG_PARAM_SDK_VERSION : str7, str8);
    }
}
