package com.avito.android.authorization.login_suggests.adapter.progress.di;

import com.avito.android.authorization.login_suggests.adapter.progress.ProgressItemBlueprint;
import com.avito.android.authorization.login_suggests.adapter.progress.ProgressItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.progress.ProgressItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/progress/di/ProgressItemModule;", "", "Lcom/avito/android/authorization/login_suggests/adapter/progress/ProgressItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$authorization_release", "(Lcom/avito/android/authorization/login_suggests/adapter/progress/ProgressItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "providePresenter$authorization_release", "()Lcom/avito/android/authorization/login_suggests/adapter/progress/ProgressItemPresenter;", "providePresenter", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ProgressItemModule {
    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideBlueprint$authorization_release(@NotNull ProgressItemPresenter progressItemPresenter) {
        Intrinsics.checkNotNullParameter(progressItemPresenter, "presenter");
        return new ProgressItemBlueprint(progressItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ProgressItemPresenter providePresenter$authorization_release() {
        return new ProgressItemPresenterImpl();
    }
}
