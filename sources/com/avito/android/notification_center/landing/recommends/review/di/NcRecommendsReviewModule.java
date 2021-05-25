package com.avito.android.notification_center.landing.recommends.review.di;

import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractor;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewInteractorImpl;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewModule;", "", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;", "bindNcRecommendsReviewInteractor", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractorImpl;)Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "bindNcRecommendsReviewPresenter", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenterImpl;)Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public interface NcRecommendsReviewModule {
    @PerFragment
    @Binds
    @NotNull
    NcRecommendsReviewInteractor bindNcRecommendsReviewInteractor(@NotNull NcRecommendsReviewInteractorImpl ncRecommendsReviewInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    NcRecommendsReviewPresenter bindNcRecommendsReviewPresenter(@NotNull NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl);
}
