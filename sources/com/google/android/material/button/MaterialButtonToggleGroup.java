package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String k = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final List<d> a;
    public final c b;
    public final e c;
    public final LinkedHashSet<OnButtonCheckedListener> d;
    public final Comparator<MaterialButton> e;
    public Integer[] f;
    public boolean g;
    public boolean h;
    public boolean i;
    @IdRes
    public int j;

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i, boolean z);
    }

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            String str = MaterialButtonToggleGroup.k;
            Objects.requireNonNull(materialButtonToggleGroup);
            if (view instanceof MaterialButton) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= materialButtonToggleGroup.getChildCount()) {
                        break;
                    } else if (materialButtonToggleGroup.getChildAt(i2) == view) {
                        i = i3;
                        break;
                    } else {
                        if ((materialButtonToggleGroup.getChildAt(i2) instanceof MaterialButton) && materialButtonToggleGroup.d(i2)) {
                            i3++;
                        }
                        i2++;
                    }
                }
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).isChecked()));
            }
            i = -1;
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.OnCheckedChangeListener {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (!materialButtonToggleGroup.g) {
                if (materialButtonToggleGroup.h) {
                    materialButtonToggleGroup.j = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.f(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.b(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    public static class d {
        public static final CornerSize e = new AbsoluteCornerSize(0.0f);
        public CornerSize a;
        public CornerSize b;
        public CornerSize c;
        public CornerSize d;

        public d(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.a = cornerSize;
            this.b = cornerSize3;
            this.c = cornerSize4;
            this.d = cornerSize2;
        }
    }

    public class e implements MaterialButton.a {
        public e(a aVar) {
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (d(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && d(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.j = i2;
        b(i2, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.b);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton c2 = c(i2);
                int min = Math.min(c2.getStrokeWidth(), c(i2 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams2 = c2.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                }
                if (getOrientation() == 0) {
                    MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
                    MarginLayoutParamsCompat.setMarginStart(layoutParams, -min);
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = -min;
                    MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
                }
                c2.setLayoutParams(layoutParams);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                MarginLayoutParamsCompat.setMarginEnd(layoutParams3, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParams3, 0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.d.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                f(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.a.add(new d(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
            ViewCompat.setAccessibilityDelegate(materialButton, new b());
        }
    }

    public final void b(@IdRes int i2, boolean z) {
        Iterator<OnButtonCheckedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i2, z);
        }
    }

    public final MaterialButton c(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public void check(@IdRes int i2) {
        if (i2 != this.j) {
            e(i2, true);
            f(i2, true);
            setCheckedId(i2);
        }
    }

    public void clearChecked() {
        this.g = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton c2 = c(i2);
            c2.setChecked(false);
            b(c2.getId(), false);
        }
        this.g = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.d.clear();
    }

    public final boolean d(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(@NonNull Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.e);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(c(i2), Integer.valueOf(i2));
        }
        this.f = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.g = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.g = false;
        }
    }

    public final boolean f(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.i || !checkedButtonIds.isEmpty()) {
            if (z && this.h) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    e(intValue, false);
                    b(intValue, false);
                }
            }
            return true;
        }
        e(i2, true);
        this.j = i2;
        return false;
    }

    @VisibleForTesting
    public void g() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton c2 = c(i2);
            if (c2.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builder = c2.getShapeAppearanceModel().toBuilder();
                d dVar2 = this.a.get(i2);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    if (i2 == firstVisibleChildIndex) {
                        if (z) {
                            CornerSize cornerSize = d.e;
                            if (ViewUtils.isLayoutRtl(this)) {
                                CornerSize cornerSize2 = d.e;
                                dVar = new d(cornerSize2, cornerSize2, dVar2.b, dVar2.c);
                            } else {
                                CornerSize cornerSize3 = dVar2.a;
                                CornerSize cornerSize4 = dVar2.d;
                                CornerSize cornerSize5 = d.e;
                                dVar = new d(cornerSize3, cornerSize4, cornerSize5, cornerSize5);
                            }
                        } else {
                            CornerSize cornerSize6 = dVar2.a;
                            CornerSize cornerSize7 = d.e;
                            dVar = new d(cornerSize6, cornerSize7, dVar2.b, cornerSize7);
                        }
                    } else if (i2 != lastVisibleChildIndex) {
                        dVar2 = null;
                    } else if (z) {
                        CornerSize cornerSize8 = d.e;
                        if (ViewUtils.isLayoutRtl(this)) {
                            CornerSize cornerSize9 = dVar2.a;
                            CornerSize cornerSize10 = dVar2.d;
                            CornerSize cornerSize11 = d.e;
                            dVar = new d(cornerSize9, cornerSize10, cornerSize11, cornerSize11);
                        } else {
                            CornerSize cornerSize12 = d.e;
                            dVar = new d(cornerSize12, cornerSize12, dVar2.b, dVar2.c);
                        }
                    } else {
                        CornerSize cornerSize13 = d.e;
                        dVar = new d(cornerSize13, dVar2.d, cornerSize13, dVar2.c);
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    builder.setAllCornerSizes(0.0f);
                } else {
                    builder.setTopLeftCornerSize(dVar2.a).setBottomLeftCornerSize(dVar2.d).setTopRightCornerSize(dVar2.b).setBottomRightCornerSize(dVar2.c);
                }
                c2.setShapeAppearanceModel(builder.build());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.h) {
            return this.j;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton c2 = c(i2);
            if (c2.isChecked()) {
                arrayList.add(Integer.valueOf(c2.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    public boolean isSelectionRequired() {
        return this.i;
    }

    public boolean isSingleSelection() {
        return this.h;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.j;
        if (i2 != -1) {
            e(i2, true);
            f(i2, true);
            setCheckedId(i2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        g();
        a();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.a.remove(indexOfChild);
        }
        g();
        a();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.d.remove(onButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z) {
        this.i = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.h != z) {
            this.h = z;
            clearChecked();
        }
    }

    public void uncheck(@IdRes int i2) {
        e(i2, false);
        f(i2, false);
        this.j = -1;
        b(i2, false);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.l
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$c r7 = new com.google.android.material.button.MaterialButtonToggleGroup$c
            r0 = 0
            r7.<init>(r0)
            r6.b = r7
            com.google.android.material.button.MaterialButtonToggleGroup$e r7 = new com.google.android.material.button.MaterialButtonToggleGroup$e
            r7.<init>(r0)
            r6.c = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.e = r7
            r7 = 0
            r6.g = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.j = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.i = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
