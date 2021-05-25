package com.avito.android.tariff.fees_methods.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent;", "", "Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment;", "feesMethodsFragment", "", "inject", "(Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment;)V", "Builder", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {FeeMethodsModule.class, PublishLimitsAnalyticsModule.class})
@PerFragment
public interface FeeMethodsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "(Lcom/avito/android/tariff/di/TariffStepDependencies;)Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "", "checkoutContext", "(Ljava/lang/String;)Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "", "isClosable", "(Z)Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent$Builder;", "Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent;", "build", "()Lcom/avito/android/tariff/fees_methods/di/FeeMethodsComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FeeMethodsComponent build();

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
        Builder isClosable(boolean z);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull FeesMethodsFragment feesMethodsFragment);
}
