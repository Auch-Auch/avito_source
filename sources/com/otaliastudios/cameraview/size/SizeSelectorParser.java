package com.otaliastudios.cameraview.size;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.R;
import java.util.ArrayList;
public class SizeSelectorParser {
    public SizeSelector a;
    public SizeSelector b;

    public SizeSelectorParser(@NonNull TypedArray typedArray) {
        SizeSelector sizeSelector;
        SizeSelector sizeSelector2;
        ArrayList arrayList = new ArrayList(3);
        int i = R.styleable.CameraView_cameraPictureSizeMinWidth;
        if (typedArray.hasValue(i)) {
            arrayList.add(SizeSelectors.minWidth(typedArray.getInteger(i, 0)));
        }
        int i2 = R.styleable.CameraView_cameraPictureSizeMaxWidth;
        if (typedArray.hasValue(i2)) {
            arrayList.add(SizeSelectors.maxWidth(typedArray.getInteger(i2, 0)));
        }
        int i3 = R.styleable.CameraView_cameraPictureSizeMinHeight;
        if (typedArray.hasValue(i3)) {
            arrayList.add(SizeSelectors.minHeight(typedArray.getInteger(i3, 0)));
        }
        int i4 = R.styleable.CameraView_cameraPictureSizeMaxHeight;
        if (typedArray.hasValue(i4)) {
            arrayList.add(SizeSelectors.maxHeight(typedArray.getInteger(i4, 0)));
        }
        int i5 = R.styleable.CameraView_cameraPictureSizeMinArea;
        if (typedArray.hasValue(i5)) {
            arrayList.add(SizeSelectors.minArea(typedArray.getInteger(i5, 0)));
        }
        int i6 = R.styleable.CameraView_cameraPictureSizeMaxArea;
        if (typedArray.hasValue(i6)) {
            arrayList.add(SizeSelectors.maxArea(typedArray.getInteger(i6, 0)));
        }
        int i7 = R.styleable.CameraView_cameraPictureSizeAspectRatio;
        if (typedArray.hasValue(i7)) {
            arrayList.add(SizeSelectors.aspectRatio(AspectRatio.parse(typedArray.getString(i7)), 0.0f));
        }
        if (typedArray.getBoolean(R.styleable.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(SizeSelectors.smallest());
        }
        if (typedArray.getBoolean(R.styleable.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(SizeSelectors.biggest());
        }
        if (!arrayList.isEmpty()) {
            sizeSelector = SizeSelectors.and((SizeSelector[]) arrayList.toArray(new SizeSelector[0]));
        } else {
            sizeSelector = SizeSelectors.biggest();
        }
        this.a = sizeSelector;
        ArrayList arrayList2 = new ArrayList(3);
        int i8 = R.styleable.CameraView_cameraVideoSizeMinWidth;
        if (typedArray.hasValue(i8)) {
            arrayList2.add(SizeSelectors.minWidth(typedArray.getInteger(i8, 0)));
        }
        int i9 = R.styleable.CameraView_cameraVideoSizeMaxWidth;
        if (typedArray.hasValue(i9)) {
            arrayList2.add(SizeSelectors.maxWidth(typedArray.getInteger(i9, 0)));
        }
        int i10 = R.styleable.CameraView_cameraVideoSizeMinHeight;
        if (typedArray.hasValue(i10)) {
            arrayList2.add(SizeSelectors.minHeight(typedArray.getInteger(i10, 0)));
        }
        int i11 = R.styleable.CameraView_cameraVideoSizeMaxHeight;
        if (typedArray.hasValue(i11)) {
            arrayList2.add(SizeSelectors.maxHeight(typedArray.getInteger(i11, 0)));
        }
        int i12 = R.styleable.CameraView_cameraVideoSizeMinArea;
        if (typedArray.hasValue(i12)) {
            arrayList2.add(SizeSelectors.minArea(typedArray.getInteger(i12, 0)));
        }
        int i13 = R.styleable.CameraView_cameraVideoSizeMaxArea;
        if (typedArray.hasValue(i13)) {
            arrayList2.add(SizeSelectors.maxArea(typedArray.getInteger(i13, 0)));
        }
        int i14 = R.styleable.CameraView_cameraVideoSizeAspectRatio;
        if (typedArray.hasValue(i14)) {
            arrayList2.add(SizeSelectors.aspectRatio(AspectRatio.parse(typedArray.getString(i14)), 0.0f));
        }
        if (typedArray.getBoolean(R.styleable.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(SizeSelectors.smallest());
        }
        if (typedArray.getBoolean(R.styleable.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(SizeSelectors.biggest());
        }
        if (!arrayList2.isEmpty()) {
            sizeSelector2 = SizeSelectors.and((SizeSelector[]) arrayList2.toArray(new SizeSelector[0]));
        } else {
            sizeSelector2 = SizeSelectors.biggest();
        }
        this.b = sizeSelector2;
    }

    @NonNull
    public SizeSelector getPictureSizeSelector() {
        return this.a;
    }

    @NonNull
    public SizeSelector getVideoSizeSelector() {
        return this.b;
    }
}
