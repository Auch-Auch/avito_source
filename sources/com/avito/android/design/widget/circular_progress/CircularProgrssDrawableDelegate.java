package com.avito.android.design.widget.circular_progress;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgrssDrawableDelegate;", "", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V", Tracker.Events.CREATIVE_START, "()V", "stop", "Lkotlin/Function1;", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "endListener", "progressiveStop", "(Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface CircularProgrssDrawableDelegate {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a extends Lambda implements Function1<CircularProgressDrawable, Unit> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CircularProgressDrawable circularProgressDrawable) {
                Intrinsics.checkNotNullParameter(circularProgressDrawable, "it");
                return Unit.INSTANCE;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void progressiveStop$default(CircularProgrssDrawableDelegate circularProgrssDrawableDelegate, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = a.a;
                }
                circularProgrssDrawableDelegate.progressiveStop(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: progressiveStop");
        }
    }

    void draw(@NotNull Canvas canvas, @NotNull Paint paint);

    void progressiveStop(@NotNull Function1<? super CircularProgressDrawable, Unit> function1);

    void start();

    void stop();
}
