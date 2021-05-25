package com.avito.android.vas_discount.di;

import com.avito.android.di.PerFragment;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_discount/di/PickerComponent;", "", "Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment;", "fragment", "", "inject", "(Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment;)V", "Builder", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PickerDependencies.class}, modules = {PickerModule.class})
@PerFragment
public interface PickerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/vas_discount/di/PickerComponent$Builder;", "", "Lcom/avito/android/vas_discount/di/PickerDependencies;", "discountDependencies", "dependencies", "(Lcom/avito/android/vas_discount/di/PickerDependencies;)Lcom/avito/android/vas_discount/di/PickerComponent$Builder;", "Lcom/avito/android/vas_discount/di/PickerModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "discountModule", "(Lcom/avito/android/vas_discount/di/PickerModule;)Lcom/avito/android/vas_discount/di/PickerComponent$Builder;", "Lcom/avito/android/vas_discount/di/PickerComponent;", "build", "()Lcom/avito/android/vas_discount/di/PickerComponent;", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PickerComponent build();

        @NotNull
        Builder dependencies(@NotNull PickerDependencies pickerDependencies);

        @NotNull
        Builder discountModule(@NotNull PickerModule pickerModule);
    }

    void inject(@NotNull DiscountDialogFragment discountDialogFragment);
}
