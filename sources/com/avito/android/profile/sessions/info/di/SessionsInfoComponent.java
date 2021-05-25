package com.avito.android.profile.sessions.info.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.PerFragment;
import com.avito.android.profile.sessions.info.SessionsInfoFragment;
import com.avito.android.profile.sessions.info.SessionsInfoPresenter;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/sessions/info/di/SessionsInfoComponent;", "", "Lcom/avito/android/profile/sessions/info/SessionsInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile/sessions/info/SessionsInfoFragment;)V", "Factory", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CoreComponentDependencies.class}, modules = {SessionsInfoModule.class})
@PerFragment
public interface SessionsInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/sessions/info/di/SessionsInfoComponent$Factory;", "", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;", "mode", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "Lcom/avito/android/profile/sessions/info/di/SessionsInfoComponent;", "create", "(Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/profile/sessions/info/di/SessionsInfoComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SessionsInfoComponent create(@BindsInstance @NotNull SessionsInfoPresenter.Mode mode, @NotNull CoreComponentDependencies coreComponentDependencies);
    }

    void inject(@NotNull SessionsInfoFragment sessionsInfoFragment);
}
