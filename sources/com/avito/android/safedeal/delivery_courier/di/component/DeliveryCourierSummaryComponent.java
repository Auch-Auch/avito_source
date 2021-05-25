package com.avito.android.safedeal.delivery_courier.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule;
import com.avito.android.safedeal.delivery_courier.di.qualifier.AdvertId;
import com.avito.android.safedeal.delivery_courier.di.qualifier.SearchContext;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryComponent;", "", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment;", "fragment", "", "inject", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryFragment;)V", "Factory", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryCourierSummaryDependencies.class}, modules = {DeliveryCourierSummaryModule.class})
@PerFragment
public interface DeliveryCourierSummaryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JM\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryComponent$Factory;", "", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "", BookingInfoActivity.EXTRA_ITEM_ID, "searchContext", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryDependencies;", "dependencies", "Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryComponent;", "create", "(Landroid/app/Activity;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryDependencies;)Lcom/avito/android/safedeal/delivery_courier/di/component/DeliveryCourierSummaryComponent;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        DeliveryCourierSummaryComponent create(@BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @AdvertId @Nullable String str, @BindsInstance @SearchContext @Nullable String str2, @NotNull DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies);
    }

    void inject(@NotNull DeliveryCourierSummaryFragment deliveryCourierSummaryFragment);
}
