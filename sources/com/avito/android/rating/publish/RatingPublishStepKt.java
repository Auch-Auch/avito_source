package com.avito.android.rating.publish;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "stepId", "Lcom/avito/android/rating/publish/RatingPublishStep;", "parseRatingPublishStep", "(Ljava/lang/String;)Lcom/avito/android/rating/publish/RatingPublishStep;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class RatingPublishStepKt {
    @Nullable
    public static final RatingPublishStep parseRatingPublishStep(@Nullable String str) {
        RatingPublishStep[] values = RatingPublishStep.values();
        for (int i = 0; i < 8; i++) {
            RatingPublishStep ratingPublishStep = values[i];
            if (Intrinsics.areEqual(ratingPublishStep.getStepId(), str)) {
                return ratingPublishStep;
            }
        }
        return null;
    }
}
