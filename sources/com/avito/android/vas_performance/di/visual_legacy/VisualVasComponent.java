package com.avito.android.vas_performance.di.visual_legacy;

import com.avito.android.di.PerFragment;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent;", "", "Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment;", "fragment", "", "inject", "(Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment;)V", "Builder", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {VisualVasDependencies.class}, modules = {VasListModule.class})
@PerFragment
public interface VisualVasComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent$Builder;", "", "Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasDependencies;", "dependencies", "(Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasDependencies;)Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent$Builder;", "Lcom/avito/android/vas_performance/di/visual_legacy/VasListModule;", "listModule", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/vas_performance/di/visual_legacy/VasListModule;)Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent$Builder;", "Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent;", "build", "()Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasComponent;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        VisualVasComponent build();

        @NotNull
        Builder dependencies(@NotNull VisualVasDependencies visualVasDependencies);

        @NotNull
        Builder module(@NotNull VasListModule vasListModule);
    }

    void inject(@NotNull LegacyVisualVasFragment legacyVisualVasFragment);
}
