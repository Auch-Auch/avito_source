package com.avito.android.authorization.login_suggests.adapter.suggest.di;

import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemBlueprint;
import com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000f\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/suggest/di/SuggestItemModule;", "", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$authorization_release", "(Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", "clicksRelay", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", "resourceProvider", "providePresenter$authorization_release", "(Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;)Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemPresenter;", "providePresenter", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SuggestItemModule {
    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideBlueprint$authorization_release(@NotNull SuggestItemPresenter suggestItemPresenter) {
        Intrinsics.checkNotNullParameter(suggestItemPresenter, "presenter");
        return new SuggestItemBlueprint(suggestItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final SuggestItemPresenter providePresenter$authorization_release(@NotNull PublishRelay<LoginSuggestsItem> publishRelay, @NotNull LoginSuggestsResourceProvider loginSuggestsResourceProvider) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksRelay");
        Intrinsics.checkNotNullParameter(loginSuggestsResourceProvider, "resourceProvider");
        return new SuggestItemPresenterImpl(publishRelay, loginSuggestsResourceProvider);
    }
}
