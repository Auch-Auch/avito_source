package com.avito.android.profile.tfa.settings.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile.tfa.settings.TfaSettingsInteractor;
import com.avito.android.profile.tfa.settings.TfaSettingsInteractorImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenter;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/tfa/settings/di/TfaSettingsModule;", "", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenterImpl;", "impl", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "bindTfaSettingsPresenter", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenterImpl;)Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractorImpl;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;", "bindTfaSettingsInteractor", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractorImpl;)Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface TfaSettingsModule {
    @PerFragment
    @Binds
    @NotNull
    TfaSettingsInteractor bindTfaSettingsInteractor(@NotNull TfaSettingsInteractorImpl tfaSettingsInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    TfaSettingsPresenter bindTfaSettingsPresenter(@NotNull TfaSettingsPresenterImpl tfaSettingsPresenterImpl);
}
