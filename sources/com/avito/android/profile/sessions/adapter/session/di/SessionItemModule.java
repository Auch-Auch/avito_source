package com.avito.android.profile.sessions.adapter.session.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile.sessions.adapter.session.SessionItemBlueprint;
import com.avito.android.profile.sessions.adapter.session.SessionItemPresenter;
import com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/di/SessionItemModule;", "", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemBlueprint;", "impl", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/profile/sessions/adapter/session/SessionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenterImpl;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenter;", "bindPresenter", "(Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenterImpl;)Lcom/avito/android/profile/sessions/adapter/session/SessionItemPresenter;", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SessionItemModule {
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindBlueprint(@NotNull SessionItemBlueprint sessionItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    SessionItemPresenter bindPresenter(@NotNull SessionItemPresenterImpl sessionItemPresenterImpl);
}
