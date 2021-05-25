package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsEditContactsComponent;", "", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog;", "dialog", "", "inject", "(Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog;)V", "Builder", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliverySummaryDependencies.class}, modules = {DeliveryRdsEditContactsModule.class})
@PerFragment
public interface DeliveryRdsEditContactsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryRdsEditContactsComponent$Builder;", "", "Lcom/avito/android/delivery/di/component/DeliverySummaryDependencies;", "summaryDependencies", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/di/component/DeliveryRdsEditContactsComponent;", "create", "(Lcom/avito/android/delivery/di/component/DeliverySummaryDependencies;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;)Lcom/avito/android/delivery/di/component/DeliveryRdsEditContactsComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Builder {
        @NotNull
        DeliveryRdsEditContactsComponent create(@NotNull DeliverySummaryDependencies deliverySummaryDependencies, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment);
    }

    void inject(@NotNull DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog);
}
