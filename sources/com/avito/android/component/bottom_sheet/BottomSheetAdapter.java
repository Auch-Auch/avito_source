package com.avito.android.component.bottom_sheet;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/component/bottom_sheet/BottomSheetAdapter;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "callback", "", "addBottomSheetCallback", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V", "removeBottomSheetCallback", "Landroid/view/View;", "bottomSheet", "", "slideOffset", "onSlide", "(Landroid/view/View;F)V", "", "newState", "onStateChanged", "(Landroid/view/View;I)V", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "callbacks", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetAdapter extends BottomSheetBehavior.BottomSheetCallback {
    public final List<BottomSheetBehavior.BottomSheetCallback> a = new ArrayList();

    public final void addBottomSheetCallback(@NotNull BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        Intrinsics.checkNotNullParameter(bottomSheetCallback, "callback");
        this.a.add(bottomSheetCallback);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSlide(view, f);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(view, i);
        }
    }

    public final void removeBottomSheetCallback(@NotNull BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        Intrinsics.checkNotNullParameter(bottomSheetCallback, "callback");
        this.a.remove(bottomSheetCallback);
    }
}
