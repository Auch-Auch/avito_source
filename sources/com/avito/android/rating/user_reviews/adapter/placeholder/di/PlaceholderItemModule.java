package com.avito.android.rating.user_reviews.adapter.placeholder.di;

import com.avito.android.di.PerActivity;
import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItemBlueprint;
import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItemPresenter;
import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/user_reviews/adapter/placeholder/di/PlaceholderItemModule;", "", "Lcom/avito/android/rating/user_reviews/adapter/placeholder/PlaceholderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/user_reviews/adapter/placeholder/PlaceholderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "providePresenter$rating_release", "()Lcom/avito/android/rating/user_reviews/adapter/placeholder/PlaceholderItemPresenter;", "providePresenter", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PlaceholderItemModule {
    @NotNull
    public static final PlaceholderItemModule INSTANCE = new PlaceholderItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull PlaceholderItemPresenter placeholderItemPresenter) {
        Intrinsics.checkNotNullParameter(placeholderItemPresenter, "presenter");
        return new PlaceholderItemBlueprint(placeholderItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PlaceholderItemPresenter providePresenter$rating_release() {
        return new PlaceholderItemPresenterImpl();
    }
}
