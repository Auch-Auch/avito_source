package com.avito.android.authorization.select_profile.adapter.profile.di;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemBlueprint;
import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemPresenter;
import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/profile/di/ProfileItemModule;", "", "Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$authorization_release", "(Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "fieldClickStream", "providePresenter$authorization_release", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemPresenter;", "providePresenter", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ProfileItemModule {
    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideBlueprint$authorization_release(@NotNull ProfileItemPresenter profileItemPresenter) {
        Intrinsics.checkNotNullParameter(profileItemPresenter, "presenter");
        return new ProfileItemBlueprint(profileItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final ProfileItemPresenter providePresenter$authorization_release(@NotNull PublishRelay<SelectProfileField> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "fieldClickStream");
        return new ProfileItemPresenterImpl(publishRelay);
    }
}
