package com.avito.android.rating.details.adapter.button.di;

import com.avito.android.di.PerActivity;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.button.ButtonItemBlueprint;
import com.avito.android.rating.details.adapter.button.ButtonItemPresenter;
import com.avito.android.rating.details.adapter.button.ButtonItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/details/adapter/button/di/ButtonItemModule;", "", "Lcom/avito/android/rating/details/adapter/button/ButtonItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/details/adapter/button/ButtonItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "clicksRelay", "providePresenter$rating_release", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/rating/details/adapter/button/ButtonItemPresenter;", "providePresenter", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ButtonItemModule {
    @NotNull
    public static final ButtonItemModule INSTANCE = new ButtonItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "presenter");
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ButtonItemPresenter providePresenter$rating_release(@NotNull PublishRelay<RatingDetailsItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksRelay");
        return new ButtonItemPresenterImpl(publishRelay);
    }
}
