package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/StartSupportChatResponse;", "", "Lcom/avito/android/remote/model/StartSupportChatResult;", "component1", "()Lcom/avito/android/remote/model/StartSupportChatResult;", "result", "copy", "(Lcom/avito/android/remote/model/StartSupportChatResult;)Lcom/avito/android/remote/model/StartSupportChatResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/StartSupportChatResult;", "getResult", "<init>", "(Lcom/avito/android/remote/model/StartSupportChatResult;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class StartSupportChatResponse {
    @SerializedName("result")
    @NotNull
    private final StartSupportChatResult result;

    public StartSupportChatResponse(@NotNull StartSupportChatResult startSupportChatResult) {
        Intrinsics.checkNotNullParameter(startSupportChatResult, "result");
        this.result = startSupportChatResult;
    }

    public static /* synthetic */ StartSupportChatResponse copy$default(StartSupportChatResponse startSupportChatResponse, StartSupportChatResult startSupportChatResult, int i, Object obj) {
        if ((i & 1) != 0) {
            startSupportChatResult = startSupportChatResponse.result;
        }
        return startSupportChatResponse.copy(startSupportChatResult);
    }

    @NotNull
    public final StartSupportChatResult component1() {
        return this.result;
    }

    @NotNull
    public final StartSupportChatResponse copy(@NotNull StartSupportChatResult startSupportChatResult) {
        Intrinsics.checkNotNullParameter(startSupportChatResult, "result");
        return new StartSupportChatResponse(startSupportChatResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof StartSupportChatResponse) && Intrinsics.areEqual(this.result, ((StartSupportChatResponse) obj).result);
        }
        return true;
    }

    @NotNull
    public final StartSupportChatResult getResult() {
        return this.result;
    }

    public int hashCode() {
        StartSupportChatResult startSupportChatResult = this.result;
        if (startSupportChatResult != null) {
            return startSupportChatResult.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("StartSupportChatResponse(result=");
        L.append(this.result);
        L.append(")");
        return L.toString();
    }
}
