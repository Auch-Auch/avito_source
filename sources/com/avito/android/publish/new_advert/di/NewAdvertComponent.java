package com.avito.android.publish.new_advert.di;

import com.avito.android.di.PerActivity;
import com.avito.android.publish.di.NewAdvertDependencies;
import com.avito.android.publish.di.PublishAnalyticModule;
import com.avito.android.publish.new_advert.NewAdvertFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/new_advert/di/NewAdvertComponent;", "", "Lcom/avito/android/publish/new_advert/NewAdvertFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/new_advert/NewAdvertFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NewAdvertDependencies.class}, modules = {NewAdvertModule.class, PublishAnalyticModule.class})
@PerActivity
public interface NewAdvertComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/new_advert/di/NewAdvertComponent$Builder;", "", "Lcom/avito/android/publish/di/NewAdvertDependencies;", "newAdvertDependencies", "(Lcom/avito/android/publish/di/NewAdvertDependencies;)Lcom/avito/android/publish/new_advert/di/NewAdvertComponent$Builder;", "Lcom/avito/android/publish/new_advert/di/NewAdvertModule;", "newAdvertModule", "(Lcom/avito/android/publish/new_advert/di/NewAdvertModule;)Lcom/avito/android/publish/new_advert/di/NewAdvertComponent$Builder;", "Lcom/avito/android/publish/new_advert/di/NewAdvertComponent;", "build", "()Lcom/avito/android/publish/new_advert/di/NewAdvertComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NewAdvertComponent build();

        @NotNull
        Builder newAdvertDependencies(@NotNull NewAdvertDependencies newAdvertDependencies);

        @NotNull
        Builder newAdvertModule(@NotNull NewAdvertModule newAdvertModule);
    }

    void inject(@NotNull NewAdvertFragment newAdvertFragment);
}
