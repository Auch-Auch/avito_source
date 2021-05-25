package com.avito.android.publish.residential_complex_search.di;

import com.avito.android.di.PerActivity;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent;", "", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexActivity;", "activity", "", "inject", "(Lcom/avito/android/publish/residential_complex_search/ResidentialComplexActivity;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ResidentialComplexComponentDependencies.class}, modules = {ResidentialComplexModule.class})
@PerActivity
public interface ResidentialComplexComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00002\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\r\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00002\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent$Builder;", "", "Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponentDependencies;", "dependencies", "(Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponentDependencies;)Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent$Builder;", "Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexModule;)Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent$Builder;", "", "lat", "withLat", "(Ljava/lang/Double;)Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent$Builder;", "lng", "withLng", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", ResidentialComplexModuleKt.VALUES, "withValues", "(Ljava/util/List;)Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent$Builder;", "Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent;", "build", "()Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ResidentialComplexComponent build();

        @NotNull
        Builder dependencies(@NotNull ResidentialComplexComponentDependencies residentialComplexComponentDependencies);

        @NotNull
        Builder module(@NotNull ResidentialComplexModule residentialComplexModule);

        @BindsInstance
        @NotNull
        Builder withLat(@Named("lat") @Nullable Double d);

        @BindsInstance
        @NotNull
        Builder withLng(@Named("lng") @Nullable Double d);

        @BindsInstance
        @NotNull
        Builder withValues(@Named("values") @Nullable List<SelectParameter.Value> list);
    }

    void inject(@NotNull ResidentialComplexActivity residentialComplexActivity);
}
