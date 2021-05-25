package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule;
import com.avito.android.delivery.di.qualifier.OrderId;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/RdsOrderCancellationComponent;", "", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment;", "fragment", "", "inject", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsFragment;)V", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryDependencies.class}, modules = {RdsOrderCancellationReasonsModule.class})
@PerFragment
public interface RdsOrderCancellationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/di/component/RdsOrderCancellationComponent$Factory;", "", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "", AnalyticFieldsName.orderId, "Lcom/avito/android/delivery/di/component/DeliveryDependencies;", "dependencies", "Lcom/avito/android/delivery/di/component/RdsOrderCancellationComponent;", "create", "(Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/avito/android/delivery/di/component/DeliveryDependencies;)Lcom/avito/android/delivery/di/component/RdsOrderCancellationComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        RdsOrderCancellationComponent create(@BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @OrderId @NotNull String str, @NotNull DeliveryDependencies deliveryDependencies);
    }

    void inject(@NotNull RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment);
}
