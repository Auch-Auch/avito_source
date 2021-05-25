package com.avito.android.rating.user_reviews.di;

import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.details.ReviewReplyResultConverter;
import com.avito.android.rating.details.ReviewReplyResultConverterImpl;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_reviews.ItemToReviewDataConverter;
import com.avito.android.rating.user_reviews.ItemToReviewDataConverterImpl;
import com.avito.android.rating.user_reviews.ReviewItemConverter;
import com.avito.android.rating.user_reviews.ReviewItemConverterImpl;
import com.avito.android.rating.user_reviews.UserReviewsInteractor;
import com.avito.android.rating.user_reviews.UserReviewsInteractorImpl;
import com.avito.android.rating.user_reviews.UserReviewsPresenter;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/user_reviews/di/UserReviewsModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "provideRatingDetailsItemStream$rating_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideRatingDetailsItemStream", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$rating_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$rating_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class UserReviewsModule {
    @NotNull
    public static final UserReviewsModule INSTANCE = new UserReviewsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/rating/user_reviews/di/UserReviewsModule$Declarations;", "", "Lcom/avito/android/rating/user_reviews/UserReviewsPresenterImpl;", "presenter", "Lcom/avito/android/rating/user_reviews/UserReviewsPresenter;", "bindUserReviewsPresenter", "(Lcom/avito/android/rating/user_reviews/UserReviewsPresenterImpl;)Lcom/avito/android/rating/user_reviews/UserReviewsPresenter;", "Lcom/avito/android/rating/user_reviews/UserReviewsInteractorImpl;", "interactor", "Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;", "bindUserReviewsInteractor", "(Lcom/avito/android/rating/user_reviews/UserReviewsInteractorImpl;)Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;", "Lcom/avito/android/rating/user_reviews/ReviewItemConverterImpl;", "converter", "Lcom/avito/android/rating/user_reviews/ReviewItemConverter;", "bindReviewItemConverter", "(Lcom/avito/android/rating/user_reviews/ReviewItemConverterImpl;)Lcom/avito/android/rating/user_reviews/ReviewItemConverter;", "Lcom/avito/android/rating/details/ReviewReplyResultConverterImpl;", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "bindReviewReplyResultConverter", "(Lcom/avito/android/rating/details/ReviewReplyResultConverterImpl;)Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverterImpl;", "Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;", "bindItemToReviewDataConverter", "(Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverterImpl;)Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        ItemToReviewDataConverter bindItemToReviewDataConverter(@NotNull ItemToReviewDataConverterImpl itemToReviewDataConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        ReviewItemConverter bindReviewItemConverter(@NotNull ReviewItemConverterImpl reviewItemConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        ReviewReplyResultConverter bindReviewReplyResultConverter(@NotNull ReviewReplyResultConverterImpl reviewReplyResultConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        UserReviewsInteractor bindUserReviewsInteractor(@NotNull UserReviewsInteractorImpl userReviewsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        UserReviewsPresenter bindUserReviewsPresenter(@NotNull UserReviewsPresenterImpl userReviewsPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ResponsiveAdapterPresenter provideAdapterPresenter$rating_release(@NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "callableResponsiveItemPresenterRegistry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<RatingDetailsItem> provideRatingDetailsItemStream$rating_release() {
        PublishRelay<RatingDetailsItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$rating_release() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }
}
