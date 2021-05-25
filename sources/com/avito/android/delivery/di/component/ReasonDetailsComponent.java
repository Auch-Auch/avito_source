package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.delivery.di.module.ReasonDetailsModule;
import com.avito.android.delivery.di.qualifier.OrderId;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.model.ReasonRds;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/ReasonDetailsComponent;", "", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment;", "fragment", "", "inject", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsFragment;)V", "Builder", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryDependencies.class}, modules = {ReasonDetailsModule.class})
@PerFragment
public interface ReasonDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "Lcom/avito/android/remote/model/ReasonRds;", "reason", "(Lcom/avito/android/remote/model/ReasonRds;)Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "", "id", AnalyticFieldsName.orderId, "(Ljava/lang/String;)Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "Lcom/avito/android/delivery/di/component/DeliveryDependencies;", "dependencies", "deliveryDependencies", "(Lcom/avito/android/delivery/di/component/DeliveryDependencies;)Lcom/avito/android/delivery/di/component/ReasonDetailsComponent$Builder;", "Lcom/avito/android/delivery/di/component/ReasonDetailsComponent;", "build", "()Lcom/avito/android/delivery/di/component/ReasonDetailsComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ReasonDetailsComponent build();

        @NotNull
        Builder deliveryDependencies(@NotNull DeliveryDependencies deliveryDependencies);

        @BindsInstance
        @NotNull
        Builder orderId(@OrderId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder reason(@NotNull ReasonRds reasonRds);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull ReasonDetailsFragment reasonDetailsFragment);
}
