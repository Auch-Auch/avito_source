package com.avito.android.safedeal.profile_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.profile_settings.DeliveryProfileSettingsViewModelFactory;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractor;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractorImpl;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsResourceProvider;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsResourceProviderImpl;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverterImpl;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/safedeal/profile_settings/DeliveryProfileSettingsViewModelFactory;", "factory", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "provideDeliveryProfileSettingsViewModel$safedeal_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/safedeal/profile_settings/DeliveryProfileSettingsViewModelFactory;)Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "provideDeliveryProfileSettingsViewModel", "<init>", "()V", "Declarations", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class, ProfileDeliverySettingsBlueprintsModule.class, ProfileDeliverySettingsTrackerModule.class})
public final class ProfileDeliverySettingsModule {
    @NotNull
    public static final ProfileDeliverySettingsModule INSTANCE = new ProfileDeliverySettingsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH!¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH!¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsModule$Declarations;", "", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractorImpl;", "interactorImpl", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "bindDeliveryProfileSettingsInteractor$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractorImpl;)Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "bindDeliveryProfileSettingsInteractor", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverterImpl;", "converterImpl", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "bindDeliveryProfileSettingsItemsConverter$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverterImpl;)Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "bindDeliveryProfileSettingsItemsConverter", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProviderImpl;", "resProviderImpl", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "bindProfileDeliverySettingsResourceProvider$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProviderImpl;)Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "bindProfileDeliverySettingsResourceProvider", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static abstract class Declarations {
        @PerFragment
        @Binds
        @NotNull
        public abstract ProfileDeliverySettingsInteractor bindDeliveryProfileSettingsInteractor$safedeal_release(@NotNull ProfileDeliverySettingsInteractorImpl profileDeliverySettingsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        public abstract ProfileDeliverySettingsItemsConverter bindDeliveryProfileSettingsItemsConverter$safedeal_release(@NotNull ProfileDeliverySettingsItemsConverterImpl profileDeliverySettingsItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        public abstract ProfileDeliverySettingsResourceProvider bindProfileDeliverySettingsResourceProvider$safedeal_release(@NotNull ProfileDeliverySettingsResourceProviderImpl profileDeliverySettingsResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ProfileDeliverySettingsViewModel provideDeliveryProfileSettingsViewModel$safedeal_release(@NotNull Fragment fragment, @NotNull DeliveryProfileSettingsViewModelFactory deliveryProfileSettingsViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryProfileSettingsViewModelFactory).get(ProfileDeliverySettingsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (ProfileDeliverySettingsViewModel) viewModel;
    }
}
