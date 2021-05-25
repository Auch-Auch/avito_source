package com.google.android.material.datepicker;

import a2.j.b.d.j.b;
import a2.j.b.d.j.l;
import a2.j.b.d.j.o;
import a2.j.b.d.j.t;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
public final class MaterialCalendarGridView extends GridView {
    public final Calendar a = t.i();
    public final boolean b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (MaterialDatePicker.b(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.b = MaterialDatePicker.c(getContext(), R.attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new l(this));
    }

    @NonNull
    /* renamed from: a */
    public o getAdapter() {
        return (o) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        o a3 = getAdapter();
        DateSelector<?> dateSelector = a3.b;
        b bVar = a3.d;
        Long c = a3.getItem(a3.b());
        Long c2 = a3.getItem(a3.d());
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            F f = pair.first;
            if (f != null) {
                if (pair.second != null) {
                    long longValue = f.longValue();
                    long longValue2 = pair.second.longValue();
                    Long valueOf = Long.valueOf(longValue);
                    Long valueOf2 = Long.valueOf(longValue2);
                    boolean z = true;
                    if (!(c == null || c2 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > c2.longValue() || valueOf2.longValue() < c.longValue())) {
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (longValue < c.longValue()) {
                            i2 = a3.b();
                            if (i2 % a3.a.d == 0) {
                                i = 0;
                            } else if (!isLayoutRtl) {
                                i = materialCalendarGridView.getChildAt(i2 - 1).getRight();
                            } else {
                                i = materialCalendarGridView.getChildAt(i2 - 1).getLeft();
                            }
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(longValue);
                            i2 = a3.a(materialCalendarGridView.a.get(5));
                            View childAt = materialCalendarGridView.getChildAt(i2);
                            i = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (longValue2 > c2.longValue()) {
                            i4 = Math.min(a3.d(), getChildCount() - 1);
                            if ((i4 + 1) % a3.a.d != 0) {
                                z = false;
                            }
                            if (z) {
                                i3 = getWidth();
                            } else if (!isLayoutRtl) {
                                i3 = materialCalendarGridView.getChildAt(i4).getRight();
                            } else {
                                i3 = materialCalendarGridView.getChildAt(i4).getLeft();
                            }
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(longValue2);
                            i4 = a3.a(materialCalendarGridView.a.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(i4);
                            i3 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) a3.getItemId(i2);
                        int itemId2 = (int) a3.getItemId(i4);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + bVar.a.a.top;
                            int bottom = childAt3.getBottom() - bVar.a.a.bottom;
                            if (!isLayoutRtl) {
                                i6 = numColumns > i2 ? 0 : i;
                                i5 = i4 > numColumns2 ? getWidth() : i3;
                            } else {
                                int i7 = i4 > numColumns2 ? 0 : i3;
                                i5 = numColumns > i2 ? getWidth() : i;
                                i6 = i7;
                            }
                            canvas.drawRect((float) i6, (float) top, (float) i5, (float) bottom, bVar.h);
                            itemId++;
                            materialCalendarGridView = this;
                            a3 = a3;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            a3 = a3;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
        } else if (i == 33) {
            setSelection(getAdapter().d());
        } else if (i == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.view.KeyEvent.Callback, android.widget.AbsListView, android.view.View
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.b) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof o) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), o.class.getCanonicalName()));
    }
}
