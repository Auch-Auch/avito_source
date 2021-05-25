package com.avito.android.profile_phones.phones_list;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;Lcom/avito/android/analytics/Analytics;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesListViewModelFactory implements ViewModelProvider.Factory {
    public final PhonesListInteractor a;
    public final Analytics b;

    @Inject
    public PhonesListViewModelFactory(@NotNull PhonesListInteractor phonesListInteractor, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(phonesListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = phonesListInteractor;
        this.b = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PhonesListViewModelImpl.class)) {
            return new PhonesListViewModelImpl(this.a, this.b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
