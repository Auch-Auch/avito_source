package com.avito.android.image_loader.fresco.postprocessor;

import android.graphics.Color;
import com.avito.android.image_loader.fresco.postprocessor.DominantColorBackgroundPostProcessor;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"", "bucketCount", "I", "iterations", "minSideForCalculation", "reducedMaxPixelsForSide", "image-loader-fresco_release"}, k = 2, mv = {1, 4, 2})
public final class DominantColorBackgroundPostProcessorKt {
    public static final int bucketCount = 12;
    public static final int iterations = 8;
    public static final int minSideForCalculation = 10;
    public static final int reducedMaxPixelsForSide = 100;

    public static final DominantColorBackgroundPostProcessor.ColorVector access$toColorVector(int i) {
        return new DominantColorBackgroundPostProcessor.ColorVector(Color.red(i), Color.green(i), Color.blue(i));
    }
}
