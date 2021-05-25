package com.avito.android.authorization.login_suggests.di;

import android.content.res.Resources;
import com.avito.android.authorization.login_suggests.LoginSuggestsActivity;
import com.avito.android.authorization.login_suggests.adapter.common_login.di.CommonLoginItemModule;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.authorization.login_suggests.adapter.progress.di.ProgressItemModule;
import com.avito.android.authorization.login_suggests.adapter.suggest.di.SuggestItemModule;
import com.avito.android.authorization.login_suggests.tracker.LoginSuggestTrackersModule;
import com.avito.android.di.PerActivity;
import com.avito.android.performance.di.PerformanceTrackersModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent;", "", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsActivity;", "activity", "", "inject", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsActivity;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LoginSuggestsDependencies.class}, modules = {PerformanceTrackersModule.class, LoginSuggestsModule.class, SuggestItemModule.class, ErrorSnippetItemModule.class, CommonLoginItemModule.class, ProgressItemModule.class, LoginSuggestTrackersModule.class})
@PerActivity
public interface LoginSuggestsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent$Builder;", "", "Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsDependencies;)Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent$Builder;", "Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent;", "build", "()Lcom/avito/android/authorization/login_suggests/di/LoginSuggestsComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        LoginSuggestsComponent build();

        @NotNull
        Builder dependentOn(@NotNull LoginSuggestsDependencies loginSuggestsDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull LoginSuggestsActivity loginSuggestsActivity);
}
