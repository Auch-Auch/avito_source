package com.avito.android.rating.user_contacts.di;

import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_contacts.UserContactsConverter;
import com.avito.android.rating.user_contacts.UserContactsConverterImpl;
import com.avito.android.rating.user_contacts.UserContactsInteractor;
import com.avito.android.rating.user_contacts.UserContactsInteractorImpl;
import com.avito.android.rating.user_contacts.UserContactsPresenter;
import com.avito.android.rating.user_contacts.UserContactsPresenterImpl;
import com.avito.android.rating.user_contacts.UserContactsSpanProvider;
import com.avito.android.rating.user_contacts.UserContactsSpanProviderImpl;
import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\f\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/user_contacts/di/UserContactsModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "provideRatingStream", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "provideItemClicksStream$rating_release", "provideItemClicksStream", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$rating_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$rating_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class UserContactsModule {
    @NotNull
    public static final UserContactsModule INSTANCE = new UserContactsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/rating/user_contacts/di/UserContactsModule$Declarations;", "", "Lcom/avito/android/rating/user_contacts/UserContactsPresenterImpl;", "presenter", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "bindPresenter", "(Lcom/avito/android/rating/user_contacts/UserContactsPresenterImpl;)Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "Lcom/avito/android/rating/user_contacts/UserContactsInteractorImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "bindInteractor", "(Lcom/avito/android/rating/user_contacts/UserContactsInteractorImpl;)Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "Lcom/avito/android/rating/user_contacts/UserContactsConverterImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsConverter;", "bindConverter", "(Lcom/avito/android/rating/user_contacts/UserContactsConverterImpl;)Lcom/avito/android/rating/user_contacts/UserContactsConverter;", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "bindSpanProvider", "(Lcom/avito/android/rating/user_contacts/UserContactsSpanProviderImpl;)Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "stream", "Lio/reactivex/rxjava3/core/Observable;", "bindRatingObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindRatingConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        UserContactsConverter bindConverter(@NotNull UserContactsConverterImpl userContactsConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        UserContactsInteractor bindInteractor(@NotNull UserContactsInteractorImpl userContactsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        UserContactsPresenter bindPresenter(@NotNull UserContactsPresenterImpl userContactsPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        Consumer<UserContactAction> bindRatingConsumer(@NotNull PublishRelay<UserContactAction> publishRelay);

        @Binds
        @NotNull
        @PerActivity
        Observable<UserContactAction> bindRatingObservable(@NotNull PublishRelay<UserContactAction> publishRelay);

        @PerActivity
        @Binds
        @NotNull
        UserContactsSpanProvider bindSpanProvider(@NotNull UserContactsSpanProviderImpl userContactsSpanProviderImpl);
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
    public static final PublishRelay<RatingDetailsItem> provideItemClicksStream$rating_release() {
        PublishRelay<RatingDetailsItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<UserContactAction> provideRatingStream() {
        PublishRelay<UserContactAction> create = PublishRelay.create();
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
