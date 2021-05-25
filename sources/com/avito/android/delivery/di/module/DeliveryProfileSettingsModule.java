package com.avito.android.delivery.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsRepository;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsRepositoryImpl;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverter;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverterImpl;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelFactory;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryProfileSettingsModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;", "converter", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;", "repository", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModelFactory;", "provideDeliveryProfileSettingsViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "provideDeliveryProfileSettingsViewModel", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModelFactory;)Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "provideDeliveryProfileSettingsRepository", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;", "provideDeliveryProfileSettingsResponseConverter", "()Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;", "activity", "<init>", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AttributedTextFormatterModule.class, DeliveryProfileSettingsTrackerModule.class})
public final class DeliveryProfileSettingsModule {
    public final DeliveryProfileSettingsActivity a;

    public DeliveryProfileSettingsModule(@NotNull DeliveryProfileSettingsActivity deliveryProfileSettingsActivity) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsActivity, "activity");
        this.a = deliveryProfileSettingsActivity;
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeliveryProfileSettingsRepository provideDeliveryProfileSettingsRepository(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new DeliveryProfileSettingsRepositoryImpl(profileApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeliveryProfileSettingsResponseConverter provideDeliveryProfileSettingsResponseConverter() {
        return new DeliveryProfileSettingsResponseConverterImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeliveryProfileSettingsViewModel provideDeliveryProfileSettingsViewModel(@NotNull DeliveryProfileSettingsViewModelFactory deliveryProfileSettingsViewModelFactory) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(this.a, deliveryProfileSettingsViewModelFactory).get(DeliveryProfileSettingsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (DeliveryProfileSettingsViewModel) viewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeliveryProfileSettingsViewModelFactory provideDeliveryProfileSettingsViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryProfileSettingsResponseConverter deliveryProfileSettingsResponseConverter, @NotNull DeliveryProfileSettingsRepository deliveryProfileSettingsRepository, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsResponseConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsRepository, "repository");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        return new DeliveryProfileSettingsViewModelFactory(deliveryProfileSettingsRepository, deliveryProfileSettingsResponseConverter, schedulersFactory, baseScreenPerformanceTracker);
    }
}
