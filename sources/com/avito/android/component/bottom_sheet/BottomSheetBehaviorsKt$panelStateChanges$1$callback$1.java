package com.avito.android.component.bottom_sheet;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"com/avito/android/component/bottom_sheet/BottomSheetBehaviorsKt$panelStateChanges$1$callback$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "Landroid/view/View;", "bottomSheet", "", "slideOffset", "", "onSlide", "(Landroid/view/View;F)V", "", "newState", "onStateChanged", "(Landroid/view/View;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "previewState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetBehaviorsKt$panelStateChanges$1$callback$1 extends BottomSheetBehavior.BottomSheetCallback {
    public Integer a;
    public final /* synthetic */ ObservableEmitter b;

    public BottomSheetBehaviorsKt$panelStateChanges$1$callback$1(ObservableEmitter observableEmitter) {
        this.b = observableEmitter;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(@org.jetbrains.annotations.NotNull android.view.View r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "bottomSheet"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r4 = 0
            r0 = 1
            if (r5 != r0) goto L_0x0010
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r3.a = r5
            goto L_0x0037
        L_0x0010:
            java.lang.Integer r1 = r3.a
            r2 = 2
            if (r1 != 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            int r1 = r1.intValue()
            if (r1 == r0) goto L_0x002f
        L_0x001c:
            java.lang.Integer r0 = r3.a
            if (r0 != 0) goto L_0x0021
            goto L_0x002f
        L_0x0021:
            if (r0 != 0) goto L_0x0024
            goto L_0x0037
        L_0x0024:
            int r0 = r0.intValue()
            if (r0 != r2) goto L_0x0037
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0050
        L_0x002f:
            if (r5 != r2) goto L_0x0039
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r3.a = r5
        L_0x0037:
            r5 = r4
            goto L_0x0050
        L_0x0039:
            r0 = 3
            if (r5 != r0) goto L_0x0041
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            goto L_0x0050
        L_0x0041:
            r0 = 5
            if (r5 != r0) goto L_0x0049
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            goto L_0x0050
        L_0x0049:
            r0 = 4
            if (r5 != r0) goto L_0x0037
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
        L_0x0050:
            if (r5 == 0) goto L_0x0059
            r3.a = r4
            io.reactivex.rxjava3.core.ObservableEmitter r4 = r3.b
            r4.onNext(r5)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.bottom_sheet.BottomSheetBehaviorsKt$panelStateChanges$1$callback$1.onStateChanged(android.view.View, int):void");
    }
}
