package com.avito.android.tariff.count.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/count/di/TariffCountComponent;", "", "Lcom/avito/android/tariff/count/TariffCountFragment;", "fragment", "", "inject", "(Lcom/avito/android/tariff/count/TariffCountFragment;)V", "Builder", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {TariffCountModule.class})
@PerFragment
public interface TariffCountComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/count/di/TariffCountComponent$Builder;", "", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "(Lcom/avito/android/tariff/di/TariffStepDependencies;)Lcom/avito/android/tariff/count/di/TariffCountComponent$Builder;", "", "checkoutContext", "(Ljava/lang/String;)Lcom/avito/android/tariff/count/di/TariffCountComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/tariff/count/di/TariffCountComponent$Builder;", "Lcom/avito/android/util/Kundle;", "savedState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/tariff/count/di/TariffCountComponent$Builder;", "Lcom/avito/android/tariff/count/di/TariffCountComponent;", "build", "()Lcom/avito/android/tariff/count/di/TariffCountComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        TariffCountComponent build();

        @BindsInstance
        @NotNull
        Builder checkoutContext(@NotNull String str);

        @NotNull
        Builder dependencies(@NotNull TariffStepDependencies tariffStepDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder savedState(@NotNull Kundle kundle);
    }

    void inject(@NotNull TariffCountFragment tariffCountFragment);
}
