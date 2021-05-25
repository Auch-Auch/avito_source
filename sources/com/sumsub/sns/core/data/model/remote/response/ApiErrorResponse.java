package com.sumsub.sns.core.data.model.remote.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ApiErrorResponse;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "description", "code", "correlationId", CommonKt.TAG_ERROR_CODE, "errorName", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/response/ApiErrorResponse;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "Ljava/lang/Integer;", "getCode", "getCorrelationId", "getErrorCode", "getErrorName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApiErrorResponse {
    @SerializedName("code")
    @Nullable
    private final Integer code;
    @SerializedName("correlationId")
    @Nullable
    private final String correlationId;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName(CommonKt.TAG_ERROR_CODE)
    @Nullable
    private final Integer errorCode;
    @SerializedName("errorName")
    @Nullable
    private final String errorName;

    public ApiErrorResponse(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
        this.description = str;
        this.code = num;
        this.correlationId = str2;
        this.errorCode = num2;
        this.errorName = str3;
    }

    public static /* synthetic */ ApiErrorResponse copy$default(ApiErrorResponse apiErrorResponse, String str, Integer num, String str2, Integer num2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apiErrorResponse.description;
        }
        if ((i & 2) != 0) {
            num = apiErrorResponse.code;
        }
        if ((i & 4) != 0) {
            str2 = apiErrorResponse.correlationId;
        }
        if ((i & 8) != 0) {
            num2 = apiErrorResponse.errorCode;
        }
        if ((i & 16) != 0) {
            str3 = apiErrorResponse.errorName;
        }
        return apiErrorResponse.copy(str, num, str2, num2, str3);
    }

    @Nullable
    public final String component1() {
        return this.description;
    }

    @Nullable
    public final Integer component2() {
        return this.code;
    }

    @Nullable
    public final String component3() {
        return this.correlationId;
    }

    @Nullable
    public final Integer component4() {
        return this.errorCode;
    }

    @Nullable
    public final String component5() {
        return this.errorName;
    }

    @NotNull
    public final ApiErrorResponse copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
        return new ApiErrorResponse(str, num, str2, num2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiErrorResponse)) {
            return false;
        }
        ApiErrorResponse apiErrorResponse = (ApiErrorResponse) obj;
        return Intrinsics.areEqual(this.description, apiErrorResponse.description) && Intrinsics.areEqual(this.code, apiErrorResponse.code) && Intrinsics.areEqual(this.correlationId, apiErrorResponse.correlationId) && Intrinsics.areEqual(this.errorCode, apiErrorResponse.errorCode) && Intrinsics.areEqual(this.errorName, apiErrorResponse.errorName);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorName() {
        return this.errorName;
    }

    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.code;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.correlationId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.errorCode;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str3 = this.errorName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ApiErrorResponse(description=");
        L.append(this.description);
        L.append(", code=");
        L.append(this.code);
        L.append(", correlationId=");
        L.append(this.correlationId);
        L.append(", errorCode=");
        L.append(this.errorCode);
        L.append(", errorName=");
        return a.t(L, this.errorName, ")");
    }
}
