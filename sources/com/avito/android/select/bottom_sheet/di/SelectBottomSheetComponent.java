package com.avito.android.select.bottom_sheet.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.select.Arguments;
import com.avito.android.select.bottom_sheet.SelectBottomSheetFragment;
import com.avito.android.select.di.SelectDialogDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent;", "", "Lcom/avito/android/select/bottom_sheet/SelectBottomSheetFragment;", "fragment", "", "inject", "(Lcom/avito/android/select/bottom_sheet/SelectBottomSheetFragment;)V", "Builder", "select_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SelectDialogDependencies.class}, modules = {SelectBottomSheetModule.class})
@PerFragment
public interface SelectBottomSheetComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent$Builder;", "", "Lcom/avito/android/select/di/SelectDialogDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/select/di/SelectDialogDependencies;)Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent$Builder;", "Landroid/os/Bundle;", "presenterState", "withPresenterState", "(Landroid/os/Bundle;)Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent$Builder;", "Lcom/avito/android/select/Arguments;", "arguments", "withArguments", "(Lcom/avito/android/select/Arguments;)Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent$Builder;", "Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent;", "build", "()Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetComponent;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SelectBottomSheetComponent build();

        @NotNull
        Builder dependentOn(@NotNull SelectDialogDependencies selectDialogDependencies);

        @BindsInstance
        @NotNull
        Builder withArguments(@NotNull Arguments arguments);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull SelectBottomSheetFragment selectBottomSheetFragment);
}
