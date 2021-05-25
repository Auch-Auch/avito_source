package com.avito.android.advert.badge_details.di;

import com.avito.android.advert.badge_details.BadgeDetailsInteractor;
import com.avito.android.advert.badge_details.BadgeDetailsInteractorImpl;
import com.avito.android.advert.badge_details.BadgeDetailsPresenter;
import com.avito.android.advert.badge_details.BadgeDetailsPresenterImpl;
import com.avito.android.advert.badge_details.BadgeDetailsResourceProvider;
import com.avito.android.advert.badge_details.BadgeDetailsResourceProviderImpl;
import com.avito.android.di.PerActivity;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/badge_details/di/BadgeDetailsModule;", "", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenterImpl;", "presenter", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "bindPresenter", "(Lcom/avito/android/advert/badge_details/BadgeDetailsPresenterImpl;)Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "Lcom/avito/android/advert/badge_details/BadgeDetailsInteractorImpl;", "interactor", "Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;", "bindInteractor", "(Lcom/avito/android/advert/badge_details/BadgeDetailsInteractorImpl;)Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;", "Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProviderImpl;)Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProvider;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface BadgeDetailsModule {
    @PerActivity
    @Binds
    @NotNull
    BadgeDetailsInteractor bindInteractor(@NotNull BadgeDetailsInteractorImpl badgeDetailsInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    BadgeDetailsPresenter bindPresenter(@NotNull BadgeDetailsPresenterImpl badgeDetailsPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    BadgeDetailsResourceProvider bindResourceProvider(@NotNull BadgeDetailsResourceProviderImpl badgeDetailsResourceProviderImpl);
}
