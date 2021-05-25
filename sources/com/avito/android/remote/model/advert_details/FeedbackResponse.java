package com.avito.android.remote.model.advert_details;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/advert_details/FeedbackResponse;", "", "", "success", "Ljava/lang/Boolean;", "getSuccess", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackResponse {
    @SerializedName("success")
    @Nullable
    private final Boolean success;

    public FeedbackResponse(@Nullable Boolean bool) {
        this.success = bool;
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }
}
