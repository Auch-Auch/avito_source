package com.avito.android.photo_picker.legacy;

import a2.a.a.x1.q.b;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import com.avito.android.util.Dimension;
import com.avito.android.util.Logs;
import com.avito.android.util.NormalizedRect;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class CameraInteractorKt {
    public static final void access$changeParams(Camera camera, Function1 function1) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters != null) {
            function1.invoke(parameters);
            try {
                camera.setParameters(parameters);
            } catch (RuntimeException e) {
                Logs.error(e);
            }
        }
    }

    public static final Observable access$changeParamsObservable(Camera camera, Function1 function1) {
        Observable fromCallable = Observable.fromCallable(new b(camera, function1));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …hangeParams(action)\n    }");
        return fromCallable;
    }

    public static final Rect access$toCameraRect(NormalizedRect normalizedRect) {
        Rect rect = normalizedRect.toRect(2000, 2000);
        rect.offset(-1000, -1000);
        return rect;
    }

    public static final Dimension access$toDimension(Camera.Size size) {
        return new Dimension(size.width, size.height);
    }

    public static final Rect access$toCameraRect(RectF rectF) {
        return new Rect(c.roundToInt(rectF.left), c.roundToInt(rectF.top), c.roundToInt(rectF.right), c.roundToInt(rectF.bottom));
    }
}
