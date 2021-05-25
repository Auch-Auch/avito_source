package com.avito.android.safedeal.profile_settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/DeliveryProfileSettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "e", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "c", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "itemsConverter", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "d", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "resProvider", "<init>", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsViewModelFactory implements ViewModelProvider.Factory {
    public final ProfileDeliverySettingsInteractor a;
    public final SchedulersFactory3 b;
    public final ProfileDeliverySettingsItemsConverter c;
    public final ProfileDeliverySettingsResourceProvider d;
    public final BaseScreenPerformanceTracker e;

    @Inject
    public DeliveryProfileSettingsViewModelFactory(@NotNull ProfileDeliverySettingsInteractor profileDeliverySettingsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ProfileDeliverySettingsItemsConverter profileDeliverySettingsItemsConverter, @NotNull ProfileDeliverySettingsResourceProvider profileDeliverySettingsResourceProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(profileDeliverySettingsItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(profileDeliverySettingsResourceProvider, "resProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = profileDeliverySettingsInteractor;
        this.b = schedulersFactory3;
        this.c = profileDeliverySettingsItemsConverter;
        this.d = profileDeliverySettingsResourceProvider;
        this.e = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ProfileDeliverySettingsViewModelImpl.class)) {
            return new ProfileDeliverySettingsViewModelImpl(this.a, this.b, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class".toString());
    }
}
