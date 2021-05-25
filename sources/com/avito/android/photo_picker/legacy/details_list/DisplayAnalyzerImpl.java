package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.photo_picker.legacy.PhotoPickerView;
import com.avito.android.photo_picker.legacy.details_list.DisplayType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzerImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayAnalyzer;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "getDisplayType", "()Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "displayType", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "", "minHeight", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;", "layoutConfig", "<init>", "(Lcom/avito/android/util/DeviceMetrics;ILcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DisplayAnalyzerImpl implements DisplayAnalyzer {
    public final DisplayType a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhotoPickerView.PhotoPickerLayoutConfig.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_APPBAR;
            iArr[0] = 1;
            PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig2 = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_FOOTER;
            iArr[1] = 2;
        }
    }

    public DisplayAnalyzerImpl(@NotNull DeviceMetrics deviceMetrics, int i, @NotNull PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig) {
        DisplayType displayType;
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(photoPickerLayoutConfig, "layoutConfig");
        int displayHeight = (int) (((float) deviceMetrics.getDisplayHeight()) - (((float) deviceMetrics.getDisplayWidth()) / 0.75f));
        if (displayHeight > i) {
            displayType = new DisplayType.Normal(displayHeight);
        } else {
            int ordinal = photoPickerLayoutConfig.ordinal();
            if (ordinal == 0) {
                displayType = new DisplayType.FourOnThree();
            } else if (ordinal == 1) {
                displayType = new DisplayType.ExtraSmall();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.a = displayType;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer
    @NotNull
    public DisplayType getDisplayType() {
        return this.a;
    }
}
