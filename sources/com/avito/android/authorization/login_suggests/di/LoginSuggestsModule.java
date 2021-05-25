package com.avito.android.authorization.login_suggests.di;

import com.avito.android.authorization.login_suggests.LoginSuggestsInteractor;
import com.avito.android.authorization.login_suggests.LoginSuggestsInteractorImpl;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenter;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenterImpl;
import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider;
import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProviderImpl;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsModule;", "", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", "provideClicksStream$authorization_release", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "provideClicksStream", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class LoginSuggestsModule {
    @NotNull
    public static final LoginSuggestsModule INSTANCE = new LoginSuggestsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsModule$Declarations;", "", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractorImpl;", "presenter", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;", "bindLoginSuggestsInteractor", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractorImpl;)Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenterImpl;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "bindLoginSuggestsPresenter", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenterImpl;)Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", "bindLoginSuggestsResourceProvider", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProviderImpl;)Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        LoginSuggestsInteractor bindLoginSuggestsInteractor(@NotNull LoginSuggestsInteractorImpl loginSuggestsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        LoginSuggestsPresenter bindLoginSuggestsPresenter(@NotNull LoginSuggestsPresenterImpl loginSuggestsPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        LoginSuggestsResourceProvider bindLoginSuggestsResourceProvider(@NotNull LoginSuggestsResourceProviderImpl loginSuggestsResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<LoginSuggestsItem> provideClicksStream$authorization_release() {
        PublishRelay<LoginSuggestsItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<LoginSuggestsItem>()");
        return create;
    }
}
