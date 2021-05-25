package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.SummaryState;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule;
import com.avito.android.delivery.di.qualifier.CartFlag;
import com.avito.android.delivery.di.qualifier.PayOrderId;
import com.avito.android.delivery.di.qualifier.SearchContext;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsSummaryComponent;", "", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;", "fragment", "", "inject", "(Lcom/avito/android/delivery/summary/DeliveryRdsSummaryFragment;)V", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliverySummaryDependencies.class}, modules = {DeliveryRdsSummaryModule.class})
@PerFragment
public interface DeliveryRdsSummaryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001Jc\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsSummaryComponent$Factory;", "", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "", "searchContext", "payOrderId", "Lcom/avito/android/SummaryState;", "summaryState", "", "cartFlag", "Lcom/avito/android/delivery/di/component/DeliverySummaryDependencies;", "summaryDependencies", "Lcom/avito/android/delivery/di/component/DeliveryRdsSummaryComponent;", "create", "(Landroid/app/Activity;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/SummaryState;ZLcom/avito/android/delivery/di/component/DeliverySummaryDependencies;)Lcom/avito/android/delivery/di/component/DeliveryRdsSummaryComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        DeliveryRdsSummaryComponent create(@BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @SearchContext @Nullable String str, @BindsInstance @PayOrderId @Nullable String str2, @BindsInstance @Nullable SummaryState summaryState, @BindsInstance @CartFlag boolean z, @NotNull DeliverySummaryDependencies deliverySummaryDependencies);
    }

    void inject(@NotNull DeliveryRdsSummaryFragment deliveryRdsSummaryFragment);
}
