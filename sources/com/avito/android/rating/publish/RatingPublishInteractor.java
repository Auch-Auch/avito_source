package com.avito.android.rating.publish;

import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.AddRatingResult;
import com.avito.android.remote.model.publish.RatingPublishResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishInteractor;", "", "Lcom/avito/android/ratings/RatingPublishData;", "data", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/publish/AddRatingResult;", "sendRating", "(Lcom/avito/android/ratings/RatingPublishData;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/publish/RatingPublishResult;", "sendRatingForm", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingPublishInteractor {
    @NotNull
    Single<AddRatingResult> sendRating(@NotNull RatingPublishData ratingPublishData);

    @NotNull
    Single<RatingPublishResult> sendRatingForm(@NotNull RatingPublishData ratingPublishData);
}
