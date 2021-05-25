package com.avito.android.fees.refactor.di;

import android.app.Activity;
import com.avito.android.di.PerFragment;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/fees/refactor/di/PackageFeesComponent;", "", "Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "fragment", "", "inject", "(Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;)V", "Builder", "fees_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PackageFeesDependencies.class}, modules = {PackageFeesUiModule.class, PackageFeesModule.class})
@PerFragment
public interface PackageFeesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/fees/refactor/di/PackageFeesComponent$Builder;", "", "Lcom/avito/android/fees/refactor/di/PackageFeesDependencies;", "packageFeesDependencies", "dependencies", "(Lcom/avito/android/fees/refactor/di/PackageFeesDependencies;)Lcom/avito/android/fees/refactor/di/PackageFeesComponent$Builder;", "Lcom/avito/android/fees/refactor/di/PackageFeesModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/fees/refactor/di/PackageFeesModule;)Lcom/avito/android/fees/refactor/di/PackageFeesComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/fees/refactor/di/PackageFeesComponent$Builder;", "Lcom/avito/android/fees/refactor/di/PackageFeesComponent;", "build", "()Lcom/avito/android/fees/refactor/di/PackageFeesComponent;", "fees_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        PackageFeesComponent build();

        @NotNull
        Builder dependencies(@NotNull PackageFeesDependencies packageFeesDependencies);

        @NotNull
        Builder module(@NotNull PackageFeesModule packageFeesModule);
    }

    void inject(@NotNull MvvmPackageFeeFragment mvvmPackageFeeFragment);
}
