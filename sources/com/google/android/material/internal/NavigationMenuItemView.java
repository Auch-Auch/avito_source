package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    public static final int[] E = {16842912};
    public ColorStateList A;
    public boolean B;
    public Drawable C;
    public final AccessibilityDelegateCompat D;
    public int u;
    public boolean v;
    public boolean w;
    public final CheckedTextView x;
    public FrameLayout y;
    public MenuItemImpl z;

    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.w);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.y == null) {
                this.y = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.y.removeAllViews();
            this.y.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.z;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i) {
        StateListDrawable stateListDrawable;
        this.z = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        boolean z2 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(E, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            ViewCompat.setBackground(this, stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        if (!(this.z.getTitle() == null && this.z.getIcon() == null && this.z.getActionView() != null)) {
            z2 = false;
        }
        if (z2) {
            this.x.setVisibility(8);
            FrameLayout frameLayout = this.y;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                this.y.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.x.setVisibility(0);
        FrameLayout frameLayout2 = this.y;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            this.y.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.z;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.z.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, E);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.y;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.x.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.w != z2) {
            this.w = z2;
            this.D.sendAccessibilityEvent(this.x, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.x.setChecked(z2);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.B) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.A);
            }
            int i = this.u;
            drawable.setBounds(0, 0, i, i);
        } else if (this.v) {
            if (this.C == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                this.C = drawable2;
                if (drawable2 != null) {
                    int i2 = this.u;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.C;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.x, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.x.setCompoundDrawablePadding(i);
    }

    public void setIconSize(@Dimension int i) {
        this.u = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.A = colorStateList;
        this.B = colorStateList != null;
        MenuItemImpl menuItemImpl = this.z;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.x.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.v = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z2, char c) {
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.x, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.x.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.x.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a();
        this.D = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.x = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }
}
