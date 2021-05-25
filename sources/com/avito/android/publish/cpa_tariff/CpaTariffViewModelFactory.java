package com.avito.android.publish.cpa_tariff;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "c", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "tracker", "Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffViewModelFactory implements ViewModelProvider.Factory {
    public final CpaTariffRepository a;
    public final SchedulersFactory3 b;
    public final PublishEventTracker c;

    @Inject
    public CpaTariffViewModelFactory(@NotNull CpaTariffRepository cpaTariffRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(cpaTariffRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        this.a = cpaTariffRepository;
        this.b = schedulersFactory3;
        this.c = publishEventTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(CpaTariffViewModel.class)) {
            return new CpaTariffViewModel(this.a, this.b, this.c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
