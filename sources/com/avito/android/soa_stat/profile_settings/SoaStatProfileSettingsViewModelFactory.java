package com.avito.android.soa_stat.profile_settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/analytics/Analytics;)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatProfileSettingsViewModelFactory implements ViewModelProvider.Factory {
    public final SoaStatProfileSettingsInteractor a;
    public final SchedulersFactory b;
    public final AttributedTextFormatter c;
    public final Analytics d;

    @Inject
    public SoaStatProfileSettingsViewModelFactory(@NotNull SoaStatProfileSettingsInteractor soaStatProfileSettingsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(soaStatProfileSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = soaStatProfileSettingsInteractor;
        this.b = schedulersFactory;
        this.c = attributedTextFormatter;
        this.d = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(SoaStatProfileSettingsViewModel.class)) {
            return new SoaStatProfileSettingsViewModel(this.a, this.b, this.c, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
