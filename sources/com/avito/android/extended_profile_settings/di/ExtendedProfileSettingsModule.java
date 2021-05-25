package com.avito.android.extended_profile_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsInteractor;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsInteractorImpl;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModel;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModelFactory;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModelImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "<init>", "()V", "Declarations", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ExtendedProfileSettingsModule {
    @NotNull
    public static final ExtendedProfileSettingsModule INSTANCE = new ExtendedProfileSettingsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsModule$Declarations;", "", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractorImpl;", "impl", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractor;", "bindInteractor", "(Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractorImpl;)Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsInteractor;", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindViewModelFactory", "(Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ExtendedProfileSettingsInteractor bindInteractor(@NotNull ExtendedProfileSettingsInteractorImpl extendedProfileSettingsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory bindViewModelFactory(@NotNull ExtendedProfileSettingsViewModelFactory extendedProfileSettingsViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ExtendedProfileSettingsViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, factory).get(ExtendedProfileSettingsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (ExtendedProfileSettingsViewModel) viewModel;
    }
}
