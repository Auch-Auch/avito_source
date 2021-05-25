package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.di.module.DeliveryRdsMapModule;
import com.avito.android.delivery.di.module.DeliveryRdsPointInfoModule;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingModule;
import com.avito.android.delivery.di.qualifier.AdvertId;
import com.avito.android.delivery.di.qualifier.AnalyticsAdvertId;
import com.avito.android.delivery.di.qualifier.CartFlag;
import com.avito.android.delivery.di.qualifier.CartItems;
import com.avito.android.delivery.di.qualifier.MarketplaceFlag;
import com.avito.android.delivery.di.qualifier.Source;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.model.ParametrizedEvent;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsStartOrderingComponent;", "", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;", "fragment", "", "inject", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;)V", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryRdsCommonDependencies.class}, modules = {DeliveryRdsStartOrderingModule.class, DeliveryRdsMapModule.class, DeliveryRdsPointInfoModule.class})
@PerFragment
public interface DeliveryRdsStartOrderingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0001\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsStartOrderingComponent$Factory;", "", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "analyticsAdvertId", "source", "", "isMarketplace", "isCart", "cartItems", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Lcom/avito/android/delivery/di/component/DeliveryRdsCommonDependencies;", "dependencies", "Lcom/avito/android/delivery/di/component/DeliveryRdsStartOrderingComponent;", "create", "(Landroid/app/Activity;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;Lcom/avito/android/delivery/di/component/DeliveryRdsCommonDependencies;)Lcom/avito/android/delivery/di/component/DeliveryRdsStartOrderingComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        DeliveryRdsStartOrderingComponent create(@BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Context context, @BindsInstance @AdvertId @Nullable String str, @BindsInstance @AnalyticsAdvertId @Nullable String str2, @Source @BindsInstance @Nullable String str3, @BindsInstance @MarketplaceFlag boolean z, @BindsInstance @CartFlag boolean z2, @BindsInstance @CartItems @Nullable String str4, @BindsInstance @Nullable ParametrizedEvent parametrizedEvent, @NotNull DeliveryRdsCommonDependencies deliveryRdsCommonDependencies);
    }

    void inject(@NotNull DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment);
}
