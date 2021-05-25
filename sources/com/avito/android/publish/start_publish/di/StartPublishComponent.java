package com.avito.android.publish.start_publish.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishAnalyticModule;
import com.avito.android.publish.start_publish.StartPublishFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishComponent;", "", "Lcom/avito/android/publish/start_publish/StartPublishFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/start_publish/StartPublishFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StartPublishDependencies.class}, modules = {StartPublishModule.class, PublishAnalyticModule.class})
@PerFragment
public interface StartPublishComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishComponent$Builder;", "", "Lcom/avito/android/publish/start_publish/di/StartPublishDependencies;", "startPublishDependencies", "(Lcom/avito/android/publish/start_publish/di/StartPublishDependencies;)Lcom/avito/android/publish/start_publish/di/StartPublishComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/start_publish/di/StartPublishComponent$Builder;", "Lcom/avito/android/publish/start_publish/di/StartPublishComponent;", "build", "()Lcom/avito/android/publish/start_publish/di/StartPublishComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        StartPublishComponent build();

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @NotNull
        Builder startPublishDependencies(@NotNull StartPublishDependencies startPublishDependencies);
    }

    void inject(@NotNull StartPublishFragment startPublishFragment);
}
