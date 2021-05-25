package com.avito.android.profile.sessions.list.di;

import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.profile.sessions.adapter.error.di.SessionsErrorItemModule;
import com.avito.android.profile.sessions.adapter.header.di.SessionsHeaderItemModule;
import com.avito.android.profile.sessions.adapter.info.di.SessionsInfoItemModule;
import com.avito.android.profile.sessions.adapter.loading.di.SessionsLoadingItemModule;
import com.avito.android.profile.sessions.adapter.session.di.SessionItemModule;
import com.avito.android.profile.sessions.list.SessionsListInteractor;
import com.avito.android.profile.sessions.list.SessionsListInteractorImpl;
import com.avito.android.profile.sessions.list.SessionsListPresenter;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl;
import com.avito.android.profile.sessions.list.SessionsListResourceProvider;
import com.avito.android.profile.sessions.list.SessionsListResourceProviderImpl;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/sessions/list/di/SessionsListModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "provideActionRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, SessionItemModule.class, SessionsHeaderItemModule.class, SessionsInfoItemModule.class, SessionsLoadingItemModule.class, SessionsErrorItemModule.class, ErrorHelperModule.class, AdapterModule.class})
public final class SessionsListModule {
    @NotNull
    public static final SessionsListModule INSTANCE = new SessionsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\r2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile/sessions/list/di/SessionsListModule$Declarations;", "", "Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl;", "impl", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "bindSessionsListPresenter", "(Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl;)Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "Lcom/avito/android/profile/sessions/list/SessionsListInteractorImpl;", "Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "bindSessionListInteractor", "(Lcom/avito/android/profile/sessions/list/SessionsListInteractorImpl;)Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "Lio/reactivex/rxjava3/core/Observable;", "bindActionItemObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindActionItemConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile/sessions/list/SessionsListResourceProviderImpl;", "Lcom/avito/android/profile/sessions/list/SessionsListResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/profile/sessions/list/SessionsListResourceProviderImpl;)Lcom/avito/android/profile/sessions/list/SessionsListResourceProvider;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        Consumer<SessionsItemAction> bindActionItemConsumer(@NotNull PublishRelay<SessionsItemAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<SessionsItemAction> bindActionItemObservable(@NotNull PublishRelay<SessionsItemAction> publishRelay);

        @Binds
        @NotNull
        SessionsListResourceProvider bindResourceProvider(@NotNull SessionsListResourceProviderImpl sessionsListResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SessionsListInteractor bindSessionListInteractor(@NotNull SessionsListInteractorImpl sessionsListInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SessionsListPresenter bindSessionsListPresenter(@NotNull SessionsListPresenterImpl sessionsListPresenterImpl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PublishRelay<SessionsItemAction> provideActionRelay() {
        PublishRelay<SessionsItemAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
