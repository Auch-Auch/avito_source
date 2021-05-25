package com.avito.android.user_subscribers.di;

import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.user_subscribers.UserSubscribersConverter;
import com.avito.android.user_subscribers.UserSubscribersConverterImpl;
import com.avito.android.user_subscribers.UserSubscribersInteractor;
import com.avito.android.user_subscribers.UserSubscribersInteractorImpl;
import com.avito.android.user_subscribers.UserSubscribersPresenter;
import com.avito.android.user_subscribers.UserSubscribersPresenterImpl;
import com.avito.android.user_subscribers.action.SubscriberAction;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/user_subscribers/di/UserSubscribersModule;", "", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "provideRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "<init>", "()V", "Declarations", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class UserSubscribersModule {
    @NotNull
    public static final UserSubscribersModule INSTANCE = new UserSubscribersModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_subscribers/di/UserSubscribersModule$Declarations;", "", "Lcom/avito/android/user_subscribers/UserSubscribersPresenterImpl;", "presenter", "Lcom/avito/android/user_subscribers/UserSubscribersPresenter;", "bindPresenter", "(Lcom/avito/android/user_subscribers/UserSubscribersPresenterImpl;)Lcom/avito/android/user_subscribers/UserSubscribersPresenter;", "Lcom/avito/android/user_subscribers/UserSubscribersInteractorImpl;", "Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "bindInteractor", "(Lcom/avito/android/user_subscribers/UserSubscribersInteractorImpl;)Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "Lcom/avito/android/user_subscribers/UserSubscribersConverterImpl;", "converter", "Lcom/avito/android/user_subscribers/UserSubscribersConverter;", "bindConverter", "(Lcom/avito/android/user_subscribers/UserSubscribersConverterImpl;)Lcom/avito/android/user_subscribers/UserSubscribersConverter;", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "relay", "Lio/reactivex/Observable;", "bindActionRelayToObservale", "(Lcom/jakewharton/rxrelay2/Relay;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "bindActionRelayToConsumer", "(Lcom/jakewharton/rxrelay2/Relay;)Lio/reactivex/functions/Consumer;", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerActivity
        Consumer<SubscriberAction> bindActionRelayToConsumer(@NotNull Relay<SubscriberAction> relay);

        @Binds
        @NotNull
        @PerActivity
        Observable<SubscriberAction> bindActionRelayToObservale(@NotNull Relay<SubscriberAction> relay);

        @PerActivity
        @Binds
        @NotNull
        UserSubscribersConverter bindConverter(@NotNull UserSubscribersConverterImpl userSubscribersConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        UserSubscribersInteractor bindInteractor(@NotNull UserSubscribersInteractorImpl userSubscribersInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        UserSubscribersPresenter bindPresenter(@NotNull UserSubscribersPresenterImpl userSubscribersPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Relay<SubscriberAction> provideRelay() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
