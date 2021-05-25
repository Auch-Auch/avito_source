package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public static final int[] A = {16842912};
    public static final int[] B = {-16842910};
    @NonNull
    public final TransitionSet a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    @NonNull
    public final View.OnClickListener g;
    public final Pools.Pool<BottomNavigationItemView> h;
    @NonNull
    public final SparseArray<View.OnTouchListener> i;
    public boolean j;
    public int k;
    @Nullable
    public BottomNavigationItemView[] l;
    public int m;
    public int n;
    public ColorStateList o;
    @Dimension
    public int p;
    public ColorStateList q;
    @Nullable
    public final ColorStateList r;
    @StyleRes
    public int s;
    @StyleRes
    public int t;
    public Drawable u;
    public int v;
    public int[] w;
    @NonNull
    public SparseArray<BadgeDrawable> x;
    public BottomNavigationPresenter y;
    public MenuBuilder z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
            BottomNavigationMenuView bottomNavigationMenuView = BottomNavigationMenuView.this;
            if (!bottomNavigationMenuView.z.performItemAction(itemData, bottomNavigationMenuView.y, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.h.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if ((id != -1) && (badgeDrawable = this.x.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    @Nullable
    @VisibleForTesting
    public BottomNavigationItemView a(int i2) {
        c(i2);
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr == null) {
            return null;
        }
        for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
            if (bottomNavigationItemView.getId() == i2) {
                return bottomNavigationItemView;
            }
        }
        return null;
    }

    public final boolean b(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.h.release(bottomNavigationItemView);
                    bottomNavigationItemView.c();
                }
            }
        }
        if (this.z.size() == 0) {
            this.m = 0;
            this.n = 0;
            this.l = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            hashSet.add(Integer.valueOf(this.z.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.x.size(); i3++) {
            int keyAt = this.x.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.x.delete(keyAt);
            }
        }
        this.l = new BottomNavigationItemView[this.z.size()];
        boolean b2 = b(this.k, this.z.getVisibleItems().size());
        for (int i4 = 0; i4 < this.z.size(); i4++) {
            this.y.setUpdateSuspended(true);
            this.z.getItem(i4).setCheckable(true);
            this.y.setUpdateSuspended(false);
            BottomNavigationItemView newItem = getNewItem();
            this.l[i4] = newItem;
            newItem.setIconTintList(this.o);
            newItem.setIconSize(this.p);
            newItem.setTextColor(this.r);
            newItem.setTextAppearanceInactive(this.s);
            newItem.setTextAppearanceActive(this.t);
            newItem.setTextColor(this.q);
            Drawable drawable = this.u;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.v);
            }
            newItem.setShifting(b2);
            newItem.setLabelVisibilityMode(this.k);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.z.getItem(i4);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i4);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.i.get(itemId));
            newItem.setOnClickListener(this.g);
            int i5 = this.m;
            if (i5 != 0 && itemId == i5) {
                this.n = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.z.size() - 1, this.n);
        this.n = min;
        this.z.getItem(min).setChecked(true);
    }

    public final void c(int i2) {
        if (!(i2 != -1)) {
            throw new IllegalArgumentException(i2 + " is not a valid view id");
        }
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = B;
        return new ColorStateList(new int[][]{iArr, A, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.x;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) {
            return this.u;
        }
        return bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.v;
    }

    @Dimension
    public int getItemIconSize() {
        return this.p;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.t;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.s;
    }

    public ColorStateList getItemTextColor() {
        return this.q;
    }

    public int getLabelVisibilityMode() {
        return this.k;
    }

    public int getSelectedItemId() {
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.z = menuBuilder;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.j;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.z.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.z.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f, 1073741824);
        if (!b(this.k, size2) || !this.j) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.d);
            int i4 = size - (size2 * min);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getVisibility() != 8) {
                    int[] iArr = this.w;
                    iArr[i5] = min;
                    if (i4 > 0) {
                        iArr[i5] = iArr[i5] + 1;
                        i4--;
                    }
                } else {
                    this.w[i5] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.n);
            int i6 = this.e;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.d, Integer.MIN_VALUE), makeMeasureSpec);
                i6 = Math.max(i6, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.c * i7), Math.min(i6, this.d));
            int i8 = size - min2;
            int min3 = Math.min(i8 / (i7 == 0 ? 1 : i7), this.b);
            int i9 = i8 - (i7 * min3);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.w;
                    iArr2[i10] = i10 == this.n ? min2 : min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.w[i10] = 0;
                }
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.w[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.f, makeMeasureSpec, 0));
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.x = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.u = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.j = z2;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.p = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i2, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.i.remove(i2);
        } else {
            this.i.put(i2, onTouchListener);
        }
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView.getItemData().getItemId() == i2) {
                    bottomNavigationItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.t = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.s = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.q = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.l;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.k = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder = this.z;
        if (!(menuBuilder == null || this.l == null)) {
            int size = menuBuilder.size();
            if (size != this.l.length) {
                buildMenuView();
                return;
            }
            int i2 = this.m;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.z.getItem(i3);
                if (item.isChecked()) {
                    this.m = item.getItemId();
                    this.n = i3;
                }
            }
            if (i2 != this.m) {
                TransitionManager.beginDelayedTransition(this, this.a);
            }
            boolean b2 = b(this.k, this.z.getVisibleItems().size());
            for (int i4 = 0; i4 < size; i4++) {
                this.y.setUpdateSuspended(true);
                this.l[i4].setLabelVisibilityMode(this.k);
                this.l[i4].setShifting(b2);
                this.l[i4].initialize((MenuItemImpl) this.z.getItem(i4), 0);
                this.y.setUpdateSuspended(false);
            }
        }
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new Pools.SynchronizedPool(5);
        this.i = new SparseArray<>(5);
        this.m = 0;
        this.n = 0;
        this.x = new SparseArray<>(5);
        Resources resources = getResources();
        this.b = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.c = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.d = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.e = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.f = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.r = createDefaultColorStateList(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.a = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(115L);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new TextScale());
        this.g = new a();
        this.w = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
