package com.avito.android.authorization.select_profile.adapter.create_profile.di;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemBlueprint;
import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemPresenter;
import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/create_profile/di/CreateProfileItemModule;", "", "Lcom/avito/android/authorization/select_profile/adapter/create_profile/CreateProfileItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideCreateProfileItemBlueprint$authorization_release", "(Lcom/avito/android/authorization/select_profile/adapter/create_profile/CreateProfileItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideCreateProfileItemBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "fieldClickStream", "provideCreateProfileItemPresenter$authorization_release", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/authorization/select_profile/adapter/create_profile/CreateProfileItemPresenter;", "provideCreateProfileItemPresenter", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CreateProfileItemModule {
    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideCreateProfileItemBlueprint$authorization_release(@NotNull CreateProfileItemPresenter createProfileItemPresenter) {
        Intrinsics.checkNotNullParameter(createProfileItemPresenter, "presenter");
        return new CreateProfileItemBlueprint(createProfileItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final CreateProfileItemPresenter provideCreateProfileItemPresenter$authorization_release(@NotNull PublishRelay<SelectProfileField> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "fieldClickStream");
        return new CreateProfileItemPresenterImpl(publishRelay);
    }
}
