package com.avito.android.rating.publish;

import com.avito.android.ratings.RatingPublishData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\rJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/rating/publish/StepListener;", "", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "", "isCompleted", "", "onStepDataProvided", "(Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Z)V", "onBackPressed", "()V", "Holder", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface StepListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/rating/publish/StepListener$Holder;", "", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Holder {
        @NotNull
        StepListener getStepListener();
    }

    void onBackPressed();

    void onStepDataProvided(@NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, boolean z);
}
