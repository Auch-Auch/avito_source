package com.avito.android.extended_profile_settings;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModelImpl;", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractor;", "c", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractor;", "interactor", "<init>", "(Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractor;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSettingsViewModelImpl extends ViewModel implements ExtendedProfileSettingsViewModel {
    public final ExtendedProfileSettingsInteractor c;

    public ExtendedProfileSettingsViewModelImpl(@NotNull ExtendedProfileSettingsInteractor extendedProfileSettingsInteractor) {
        Intrinsics.checkNotNullParameter(extendedProfileSettingsInteractor, "interactor");
        this.c = extendedProfileSettingsInteractor;
    }
}
