package com.avito.android.select.new_metro.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.select.new_metro.SelectMetroActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {CoreComponentDependencies.class}, modules = {SelectMetroBaseModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroActivityComponent;", "", "Lcom/avito/android/select/new_metro/SelectMetroActivity;", "activity", "", "inject", "(Lcom/avito/android/select/new_metro/SelectMetroActivity;)V", "Builder", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroActivityComponent$Builder;", "", "Lcom/avito/android/select/new_metro/di/SelectMetroActivityComponent;", "build", "()Lcom/avito/android/select/new_metro/di/SelectMetroActivityComponent;", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "setDependencies", "(Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/select/new_metro/di/SelectMetroActivityComponent$Builder;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SelectMetroActivityComponent build();

        @NotNull
        Builder setDependencies(@NotNull CoreComponentDependencies coreComponentDependencies);
    }

    void inject(@NotNull SelectMetroActivity selectMetroActivity);
}
