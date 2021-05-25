package com.avito.android.safedeal.delivery_courier.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule;
import com.avito.android.safedeal.delivery_courier.di.qualifier.OrderID;
import com.avito.android.safedeal.delivery_courier.di.qualifier.Source;
import com.avito.android.safedeal.delivery_courier.di.qualifier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent;", "", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment;", "fragment", "", "inject", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment;)V", "Builder", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryCourierCommonDependencies.class}, modules = {DeliveryCourierTimeIntervalSelectModule.class})
@PerFragment
public interface DeliveryCourierTimeIntervalSelectComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "", "orderID", "(Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "source", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "timeInterval", "selectedTimeInterval", "(Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierCommonDependencies;", "dependencies", "deliveryTimeIntervalSuggestDependencies", "(Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierCommonDependencies;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent$Builder;", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent;", "build", "()Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierTimeIntervalSelectComponent;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        DeliveryCourierTimeIntervalSelectComponent build();

        @NotNull
        Builder deliveryTimeIntervalSuggestDependencies(@NotNull DeliveryCourierCommonDependencies deliveryCourierCommonDependencies);

        @BindsInstance
        @NotNull
        Builder orderID(@OrderID @NotNull String str);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder selectedTimeInterval(@TimeInterval @Nullable com.avito.android.remote.model.delivery_courier.TimeInterval timeInterval);

        @BindsInstance
        @NotNull
        Builder source(@Source @NotNull String str);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment);
}
