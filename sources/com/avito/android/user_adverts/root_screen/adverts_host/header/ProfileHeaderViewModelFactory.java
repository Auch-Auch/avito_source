package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BY\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b0\u00101J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "d", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "charityInteractor", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "c", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "profileHeaderInteractor", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/account/AccountStateProvider;", g.a, "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "j", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "i", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;Lcom/avito/android/user_adverts_common/charity/CharityInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderViewModelFactory implements ViewModelProvider.Factory {
    public final AccountStorageInteractor a;
    public final NotificationCenterCounterInteractor b;
    public final ProfileHeaderInteractor c;
    public final CharityInteractor d;
    public final SchedulersFactory e;
    public final Analytics f;
    public final AccountStateProvider g;
    public final Features h;
    public final ProfileHeaderResourceProvider i;
    public UserAdvertsTabTestGroup j;

    @Inject
    public ProfileHeaderViewModelFactory(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @NotNull ProfileHeaderInteractor profileHeaderInteractor, @NotNull CharityInteractor charityInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider, @NotNull Features features, @NotNull ProfileHeaderResourceProvider profileHeaderResourceProvider, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(profileHeaderInteractor, "profileHeaderInteractor");
        Intrinsics.checkNotNullParameter(charityInteractor, "charityInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(profileHeaderResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        this.a = accountStorageInteractor;
        this.b = notificationCenterCounterInteractor;
        this.c = profileHeaderInteractor;
        this.d = charityInteractor;
        this.e = schedulersFactory;
        this.f = analytics;
        this.g = accountStateProvider;
        this.h = features;
        this.i = profileHeaderResourceProvider;
        this.j = userAdvertsTabTestGroup;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ProfileHeaderViewModel.class)) {
            return new ProfileHeaderViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
