package com.avito.android.rating.publish;

import android.content.Context;
import android.content.Intent;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/ratings/RatingPublishConfig;", Navigation.CONFIG, "Landroid/content/Intent;", "createRatingPublishActivityIntent", "(Landroid/content/Context;Lcom/avito/android/ratings/RatingPublishConfig;)Landroid/content/Intent;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class RatingPublishActivityKt {
    @NotNull
    public static final Intent createRatingPublishActivityIntent(@NotNull Context context, @NotNull RatingPublishConfig ratingPublishConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ratingPublishConfig, Navigation.CONFIG);
        Intent putExtra = new Intent(context, RatingPublishActivity.class).putExtra(Navigation.CONFIG, ratingPublishConfig);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…Extra(KEY_CONFIG, config)");
        return putExtra;
    }
}
