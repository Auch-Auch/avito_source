package com.avito.android.app_rater.di;

import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/app_rater/di/AppRaterDialogComponent;", "", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment;", "dialog", "", "inject", "(Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment;)V", "Builder", "app-rater_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AppRaterDependencies.class}, modules = {AppRaterModule.class, AppRaterDialogModule.class})
@PerFragment
public interface AppRaterDialogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/app_rater/di/AppRaterDialogComponent$Builder;", "", "Lcom/avito/android/app_rater/di/AppRaterDependencies;", "dependencies", "appRaterDependencies", "(Lcom/avito/android/app_rater/di/AppRaterDependencies;)Lcom/avito/android/app_rater/di/AppRaterDialogComponent$Builder;", "Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;", "page", "withSourcePage", "(Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;)Lcom/avito/android/app_rater/di/AppRaterDialogComponent$Builder;", "Lcom/avito/android/app_rater/di/AppRaterDialogComponent;", "build", "()Lcom/avito/android/app_rater/di/AppRaterDialogComponent;", "app-rater_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder appRaterDependencies(@NotNull AppRaterDependencies appRaterDependencies);

        @NotNull
        AppRaterDialogComponent build();

        @BindsInstance
        @NotNull
        Builder withSourcePage(@Nullable AppRaterEventSourcePage appRaterEventSourcePage);
    }

    void inject(@NotNull AppRaterDialogFragment appRaterDialogFragment);
}
