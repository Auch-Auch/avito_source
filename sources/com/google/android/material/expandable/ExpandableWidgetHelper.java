package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.search.map.view.PanelStateKt;
public final class ExpandableWidgetHelper {
    @NonNull
    public final View a;
    public boolean b = false;
    @IdRes
    public int c = 0;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.a = (View) expandableWidget;
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        return this.c;
    }

    public boolean isExpanded() {
        return this.b;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        this.b = bundle.getBoolean(PanelStateKt.PANEL_EXPANDED, false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            ViewParent parent = this.a.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.a);
            }
        }
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PanelStateKt.PANEL_EXPANDED, this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public boolean setExpanded(boolean z) {
        if (this.b == z) {
            return false;
        }
        this.b = z;
        ViewParent parent = this.a.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return true;
        }
        ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.a);
        return true;
    }

    public void setExpandedComponentIdHint(@IdRes int i) {
        this.c = i;
    }
}
