package com.avito.android.safedeal.delivery_courier.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule;
import com.avito.android.safedeal.delivery_courier.di.qualifier.OrderID;
import com.avito.android.safedeal.delivery_courier.di.qualifier.Source;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent;", "", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment;", "fragment", "", "inject", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateFragment;)V", "Builder", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryCourierOrderUpdateDependencies.class}, modules = {DeliveryCourierOrderUpdateModule.class})
@PerFragment
public interface DeliveryCourierOrderUpdateComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "", "orderID", "(Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "source", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateDependencies;", "dependencies", "deliveryCourierOrderUpdateDependencies", "(Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateDependencies;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent$Builder;", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent;", "build", "()Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierOrderUpdateComponent;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        DeliveryCourierOrderUpdateComponent build();

        @NotNull
        Builder deliveryCourierOrderUpdateDependencies(@NotNull DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies);

        @BindsInstance
        @NotNull
        Builder orderID(@OrderID @NotNull String str);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder source(@Source @NotNull String str);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment);
}
