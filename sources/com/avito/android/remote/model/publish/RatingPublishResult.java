package com.avito.android.remote.model.publish;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/publish/RatingPublishResult;", "", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "getPayload", "()Lcom/avito/android/remote/model/publish/NextStagePayload;", "", "nextStep", "Ljava/lang/String;", "getNextStep", "()Ljava/lang/String;", "", DecodeProducer.EXTRA_IS_FINAL, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "nextStepType", "getNextStepType", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/publish/NextStagePayload;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishResult {
    @SerializedName(DecodeProducer.EXTRA_IS_FINAL)
    @Nullable
    private final Boolean isFinal;
    @SerializedName("nextStep")
    @Nullable
    private final String nextStep;
    @SerializedName("nextStepType")
    @Nullable
    private final String nextStepType;
    @SerializedName("payload")
    @Nullable
    private final NextStagePayload payload;

    public RatingPublishResult(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable NextStagePayload nextStagePayload) {
        this.nextStep = str;
        this.isFinal = bool;
        this.nextStepType = str2;
        this.payload = nextStagePayload;
    }

    @Nullable
    public final String getNextStep() {
        return this.nextStep;
    }

    @Nullable
    public final String getNextStepType() {
        return this.nextStepType;
    }

    @Nullable
    public final NextStagePayload getPayload() {
        return this.payload;
    }

    @Nullable
    public final Boolean isFinal() {
        return this.isFinal;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingPublishResult(String str, Boolean bool, String str2, NextStagePayload nextStagePayload, int i, j jVar) {
        this(str, bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : nextStagePayload);
    }
}
