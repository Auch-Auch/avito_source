package com.avito.android.rating.publish;

import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishStep;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStepId", "()Ljava/lang/String;", "stepId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ITEMS", "STAGES", "SCORE", "COMMENT", "DEAL_PROOF", "IMAGES", "BUYER_INFO", "REG_VEHICLE", "rating_release"}, k = 1, mv = {1, 4, 2})
public enum RatingPublishStep {
    ITEMS("items"),
    STAGES("stages"),
    SCORE("score"),
    COMMENT(AbuseSendingResult.COMMENT),
    DEAL_PROOF("dealProof"),
    IMAGES("images"),
    BUYER_INFO("buyerInfo"),
    REG_VEHICLE("regVehicle");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    RatingPublishStep(String str) {
        this.a = str;
    }

    @NotNull
    public final String getStepId() {
        return this.a;
    }
}
