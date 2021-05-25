package com.avito.android.di.component;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.di.module.StoriesActivityModule;
import com.avito.android.stories.StoriesActivity;
import com.avito.android.stories.StoriesArguments;
import com.avito.android.stories.di.StoriesModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/StoriesComponent;", "", "Lcom/avito/android/stories/StoriesActivity;", "activity", "", "inject", "(Lcom/avito/android/stories/StoriesActivity;)V", "Builder", "serp_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StoriesDependencies.class}, modules = {StoriesModule.class, StoriesActivityModule.class})
@PerActivity
public interface StoriesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/component/StoriesComponent$Builder;", "", "Lcom/avito/android/stories/StoriesArguments;", "arguments", "storiesArguments", "(Lcom/avito/android/stories/StoriesArguments;)Lcom/avito/android/di/component/StoriesComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/di/component/StoriesComponent$Builder;", "Lcom/avito/android/di/component/StoriesDependencies;", "dependencies", "storiesDependencies", "(Lcom/avito/android/di/component/StoriesDependencies;)Lcom/avito/android/di/component/StoriesComponent$Builder;", "Lcom/avito/android/di/component/StoriesComponent;", "build", "()Lcom/avito/android/di/component/StoriesComponent;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        StoriesComponent build();

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder storiesArguments(@NotNull StoriesArguments storiesArguments);

        @NotNull
        Builder storiesDependencies(@NotNull StoriesDependencies storiesDependencies);
    }

    void inject(@NotNull StoriesActivity storiesActivity);
}
