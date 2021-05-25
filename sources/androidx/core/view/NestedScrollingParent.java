package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
public interface NestedScrollingParent {
    @Override // androidx.core.view.NestedScrollingParent
    int getNestedScrollAxes();

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onNestedFling(@NonNull View view, float f, float f2, boolean z);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onNestedPreFling(@NonNull View view, float f, float f2);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onStopNestedScroll(@NonNull View view);
}
