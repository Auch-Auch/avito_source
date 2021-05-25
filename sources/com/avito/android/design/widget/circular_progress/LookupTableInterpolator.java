package com.avito.android.design.widget.circular_progress;

import a2.b.a.a.a;
import android.view.animation.Interpolator;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/LookupTableInterpolator;", "Landroid/view/animation/Interpolator;", "", "input", "getInterpolation", "(F)F", AuthSource.SEND_ABUSE, "F", "stepSize", "", AuthSource.BOOKING_ORDER, "[F", ResidentialComplexModuleKt.VALUES, "<init>", "([F)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class LookupTableInterpolator implements Interpolator {
    public final float a;
    public final float[] b;

    public LookupTableInterpolator(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ResidentialComplexModuleKt.VALUES);
        this.b = fArr;
        this.a = 1.0f / ((float) (fArr.length - 1));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.b;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.a;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.b;
        return a.b(fArr2[min + 1], fArr2[min], f3, fArr2[min]);
    }
}
