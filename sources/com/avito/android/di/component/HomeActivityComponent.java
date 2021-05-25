package com.avito.android.di.component;

import com.avito.android.di.PerActivity;
import com.avito.android.home.HomeActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/HomeActivityComponent;", "", "Lcom/avito/android/home/HomeActivity;", "homeActivity", "", "inject", "(Lcom/avito/android/home/HomeActivity;)V", "Builder", "serp_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HomeActivityDependencies.class})
@PerActivity
public interface HomeActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/HomeActivityComponent$Builder;", "", "Lcom/avito/android/di/component/HomeActivityDependencies;", "dependencies", "(Lcom/avito/android/di/component/HomeActivityDependencies;)Lcom/avito/android/di/component/HomeActivityComponent$Builder;", "Lcom/avito/android/di/component/HomeActivityComponent;", "build", "()Lcom/avito/android/di/component/HomeActivityComponent;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        HomeActivityComponent build();

        @NotNull
        Builder dependencies(@NotNull HomeActivityDependencies homeActivityDependencies);
    }

    void inject(@NotNull HomeActivity homeActivity);
}
