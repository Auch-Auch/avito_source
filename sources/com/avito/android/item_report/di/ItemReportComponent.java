package com.avito.android.item_report.di;

import com.avito.android.di.PerActivity;
import com.avito.android.item_report.ItemReportActivity;
import com.avito.android.item_report.ItemReportFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/item_report/di/ItemReportComponent;", "", "Lcom/avito/android/item_report/ItemReportActivity;", "infoActivity", "", "inject", "(Lcom/avito/android/item_report/ItemReportActivity;)V", "Lcom/avito/android/item_report/ItemReportFragment;", "itemReportFragment", "(Lcom/avito/android/item_report/ItemReportFragment;)V", "Builder", "item-report_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ItemReportDependencies.class})
@PerActivity
public interface ItemReportComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/item_report/di/ItemReportComponent$Builder;", "", "Lcom/avito/android/item_report/di/ItemReportDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/item_report/di/ItemReportDependencies;)Lcom/avito/android/item_report/di/ItemReportComponent$Builder;", "Lcom/avito/android/item_report/di/ItemReportComponent;", "build", "()Lcom/avito/android/item_report/di/ItemReportComponent;", "item-report_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ItemReportComponent build();

        @NotNull
        Builder dependentOn(@NotNull ItemReportDependencies itemReportDependencies);
    }

    void inject(@NotNull ItemReportActivity itemReportActivity);

    void inject(@NotNull ItemReportFragment itemReportFragment);
}
