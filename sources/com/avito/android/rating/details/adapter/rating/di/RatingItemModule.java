package com.avito.android.rating.details.adapter.rating.di;

import com.avito.android.di.PerActivity;
import com.avito.android.rating.details.adapter.rating.RatingItemBlueprint;
import com.avito.android.rating.details.adapter.rating.RatingItemPresenter;
import com.avito.android.rating.details.adapter.rating.RatingItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/di/RatingItemModule;", "", "Lcom/avito/android/rating/details/adapter/rating/RatingItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/details/adapter/rating/RatingItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "providePresenter$rating_release", "()Lcom/avito/android/rating/details/adapter/rating/RatingItemPresenter;", "providePresenter", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class RatingItemModule {
    @NotNull
    public static final RatingItemModule INSTANCE = new RatingItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull RatingItemPresenter ratingItemPresenter) {
        Intrinsics.checkNotNullParameter(ratingItemPresenter, "presenter");
        return new RatingItemBlueprint(ratingItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final RatingItemPresenter providePresenter$rating_release() {
        return new RatingItemPresenterImpl();
    }
}
