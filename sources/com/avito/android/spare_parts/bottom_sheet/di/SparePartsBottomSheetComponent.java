package com.avito.android.spare_parts.bottom_sheet.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent;", "", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetActivity;", "activity", "", "inject", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetActivity;)V", "Builder", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
@Component(modules = {SparePartsBottomSheetModule.class})
@PerActivity
public interface SparePartsBottomSheetComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent$Builder;", "", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", Navigation.GROUP, "withRootGroup", "(Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;)Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent$Builder;", "Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent;", "build", "()Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetComponent;", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SparePartsBottomSheetComponent build();

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withRootGroup(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup);
    }

    void inject(@NotNull SparePartsBottomSheetActivity sparePartsBottomSheetActivity);
}
