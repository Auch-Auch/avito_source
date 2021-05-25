package com.avito.android.rating.details.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.details.PublicProfileRatingDetailsInteractor;
import com.avito.android.rating.details.PublicProfileRatingDetailsResourceProvider;
import com.avito.android.rating.details.RatingDetailsConverter;
import com.avito.android.rating.details.RatingDetailsConverterImpl;
import com.avito.android.rating.details.RatingDetailsInteractor;
import com.avito.android.rating.details.RatingDetailsPresenter;
import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.rating.details.RatingDetailsResourceProvider;
import com.avito.android.rating.details.ReviewReplyResultConverter;
import com.avito.android.rating.details.ReviewReplyResultConverterImpl;
import com.avito.android.rating.details.ShopRatingDetailsInteractor;
import com.avito.android.rating.details.ShopRatingDetailsResourceProvider;
import com.avito.android.rating.details.UserProfileRatingDetailsConverter;
import com.avito.android.rating.details.UserProfileRatingDetailsInteractor;
import com.avito.android.rating.details.UserProfileRatingDetailsResourceProvider;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003-./B\t\b\u0002¢\u0006\u0004\b+\u0010,J?\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u001a\u001a\u00020\u00172\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010#\u001a\u00020 H\u0001¢\u0006\u0004\b!\u0010\"J\u001f\u0010*\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020 H\u0001¢\u0006\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsModule;", "", "Lcom/avito/android/rating/remote/RatingApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/Features;", "features", "", "userKey", "shopId", "Lcom/avito/android/rating/details/RatingDetailsInteractor;", "provideInteractor$rating_release", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/rating/details/RatingDetailsInteractor;", "provideInteractor", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/rating/details/RatingDetailsResourceProvider;", "provideResourceProvider$rating_release", "(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/rating/details/RatingDetailsResourceProvider;", "provideResourceProvider", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "replyResultConverter", "Lcom/avito/android/rating/details/RatingDetailsConverter;", "provideRatingDetailsConverter$rating_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/Features;Lcom/avito/android/rating/details/ReviewReplyResultConverter;)Lcom/avito/android/rating/details/RatingDetailsConverter;", "provideRatingDetailsConverter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "provideItemClicksStream$rating_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideItemClicksStream", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$rating_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$rating_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "ShopId", "UserKey", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class RatingDetailsModule {
    @NotNull
    public static final RatingDetailsModule INSTANCE = new RatingDetailsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsModule$Declarations;", "", "Lcom/avito/android/rating/details/RatingDetailsPresenterImpl;", "presenter", "Lcom/avito/android/rating/details/RatingDetailsPresenter;", "bindRatingDetailsPresenter", "(Lcom/avito/android/rating/details/RatingDetailsPresenterImpl;)Lcom/avito/android/rating/details/RatingDetailsPresenter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/rating/details/ReviewReplyResultConverterImpl;", "converter", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "bindReviewReplyResultConverter", "(Lcom/avito/android/rating/details/ReviewReplyResultConverterImpl;)Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @PerActivity
        @Binds
        @NotNull
        RatingDetailsPresenter bindRatingDetailsPresenter(@NotNull RatingDetailsPresenterImpl ratingDetailsPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        ReviewReplyResultConverter bindReviewReplyResultConverter(@NotNull ReviewReplyResultConverterImpl reviewReplyResultConverterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsModule$ShopId;", "", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopId {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsModule$UserKey;", "", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UserKey {
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
    public static final RatingDetailsInteractor provideInteractor$rating_release(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @UserKey @Nullable String str, @ShopId @Nullable String str2) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        if (str != null) {
            return new PublicProfileRatingDetailsInteractor(ratingApi, schedulersFactory3, str);
        }
        if (str2 != null) {
            return new ShopRatingDetailsInteractor(ratingApi, schedulersFactory3, str2);
        }
        return new UserProfileRatingDetailsInteractor(ratingApi, schedulersFactory3, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<RatingDetailsItem> provideItemClicksStream$rating_release() {
        PublishRelay<RatingDetailsItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final RatingDetailsConverter provideRatingDetailsConverter$rating_release(@UserKey @Nullable String str, @ShopId @Nullable String str2, @NotNull Features features, @NotNull ReviewReplyResultConverter reviewReplyResultConverter) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(reviewReplyResultConverter, "replyResultConverter");
        if (str == null && str2 == null) {
            return new UserProfileRatingDetailsConverter(features, reviewReplyResultConverter);
        }
        return new RatingDetailsConverterImpl(features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final RatingDetailsResourceProvider provideResourceProvider$rating_release(@NotNull Resources resources, @UserKey @Nullable String str, @ShopId @Nullable String str2) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (str != null) {
            return new PublicProfileRatingDetailsResourceProvider(resources);
        }
        if (str2 != null) {
            return new ShopRatingDetailsResourceProvider(resources);
        }
        return new UserProfileRatingDetailsResourceProvider(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$rating_release() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }
}
