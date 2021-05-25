package com.avito.android.select.new_metro.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.PerFragment;
import com.avito.android.select.new_metro.SelectMetroFragment;
import com.avito.android.select.new_metro.SelectMetroParams;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent;", "", "Lcom/avito/android/select/new_metro/SelectMetroFragment;", "fragment", "", "inject", "(Lcom/avito/android/select/new_metro/SelectMetroFragment;)V", "Builder", "select_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CoreComponentDependencies.class}, modules = {SelectMetroFragmentModule.class})
@PerFragment
public interface SelectMetroFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent$Builder;", "", "Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent;", "build", "()Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent;", "Landroidx/fragment/app/Fragment;", "fragment", "bindFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent$Builder;", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "params", "bindParams", "(Lcom/avito/android/select/new_metro/SelectMetroParams;)Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent$Builder;", "", "", "selected", "bindSelectedStations", "(Ljava/util/List;)Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent$Builder;", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "setDependencies", "(Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/select/new_metro/di/SelectMetroFragmentComponent$Builder;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder bindParams(@NotNull SelectMetroParams selectMetroParams);

        @BindsInstance
        @NotNull
        Builder bindSelectedStations(@NotNull List<Integer> list);

        @NotNull
        SelectMetroFragmentComponent build();

        @NotNull
        Builder setDependencies(@NotNull CoreComponentDependencies coreComponentDependencies);
    }

    void inject(@NotNull SelectMetroFragment selectMetroFragment);
}
