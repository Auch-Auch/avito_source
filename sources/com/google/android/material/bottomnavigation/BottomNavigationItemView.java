package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    public static final int INVALID_ITEM_POSITION = -1;
    public static final int[] q = {16842912};
    public final int a;
    public float b;
    public float c;
    public float d;
    public int e;
    public boolean f;
    public ImageView g;
    public final ViewGroup h;
    public final TextView i;
    public final TextView j;
    public int k;
    @Nullable
    public MenuItemImpl l;
    @Nullable
    public ColorStateList m;
    @Nullable
    public Drawable n;
    @Nullable
    public Drawable o;
    @Nullable
    public BadgeDrawable p;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (BottomNavigationItemView.this.g.getVisibility() == 0) {
                BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                ImageView imageView = bottomNavigationItemView.g;
                if (bottomNavigationItemView.b()) {
                    BadgeDrawable badgeDrawable = bottomNavigationItemView.p;
                    ImageView imageView2 = bottomNavigationItemView.g;
                    FrameLayout frameLayout = null;
                    if (imageView == imageView2 && BadgeUtils.USE_COMPAT_PARENT) {
                        frameLayout = (FrameLayout) imageView2.getParent();
                    }
                    BadgeUtils.setBadgeDrawableBounds(badgeDrawable, imageView, frameLayout);
                }
            }
        }
    }

    public BottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    public static void d(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void e(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public static void f(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < indexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof BottomNavigationItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    public final void a(float f2, float f3) {
        this.b = f2 - f3;
        this.c = (f3 * 1.0f) / f2;
        this.d = (f2 * 1.0f) / f3;
    }

    public final boolean b() {
        return this.p != null;
    }

    public void c() {
        ImageView imageView = this.g;
        if (b()) {
            if (imageView != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.p, imageView);
            }
            this.p = null;
        }
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.p;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.l;
    }

    public int getItemPosition() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        CharSequence charSequence;
        this.l = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            charSequence = menuItemImpl.getTooltipText();
        } else {
            charSequence = menuItemImpl.getTitle();
        }
        TooltipCompat.setTooltipText(this, charSequence);
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.View, android.view.ViewGroup
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.l.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.p;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.l.getTitle();
            if (!TextUtils.isEmpty(this.l.getContentDescription())) {
                title = this.l.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.p.getContentDescription()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.p = badgeDrawable;
        ImageView imageView = this.g;
        if (imageView != null && b() && imageView != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeDrawable badgeDrawable2 = this.p;
            ImageView imageView2 = this.g;
            FrameLayout frameLayout = null;
            if (imageView == imageView2 && BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = (FrameLayout) imageView2.getParent();
            }
            BadgeUtils.attachBadgeDrawable(badgeDrawable2, imageView, frameLayout);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        TextView textView = this.j;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.j;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.i;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.i;
        textView4.setPivotY((float) textView4.getBaseline());
        int i2 = this.e;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    d(this.g, this.a, 49);
                    ViewGroup viewGroup = this.h;
                    f(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.j.setVisibility(0);
                } else {
                    d(this.g, this.a, 17);
                    f(this.h, 0);
                    this.j.setVisibility(4);
                }
                this.i.setVisibility(4);
            } else if (i2 == 1) {
                ViewGroup viewGroup2 = this.h;
                f(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    d(this.g, (int) (((float) this.a) + this.b), 49);
                    e(this.j, 1.0f, 1.0f, 0);
                    TextView textView5 = this.i;
                    float f2 = this.c;
                    e(textView5, f2, f2, 4);
                } else {
                    d(this.g, this.a, 49);
                    TextView textView6 = this.j;
                    float f3 = this.d;
                    e(textView6, f3, f3, 4);
                    e(this.i, 1.0f, 1.0f, 0);
                }
            } else if (i2 == 2) {
                d(this.g, this.a, 17);
                this.j.setVisibility(8);
                this.i.setVisibility(8);
            }
        } else if (this.f) {
            if (z) {
                d(this.g, this.a, 49);
                ViewGroup viewGroup3 = this.h;
                f(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.j.setVisibility(0);
            } else {
                d(this.g, this.a, 17);
                f(this.h, 0);
                this.j.setVisibility(4);
            }
            this.i.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.h;
            f(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                d(this.g, (int) (((float) this.a) + this.b), 49);
                e(this.j, 1.0f, 1.0f, 0);
                TextView textView7 = this.i;
                float f4 = this.c;
                e(textView7, f4, f4, 4);
            } else {
                d(this.g, this.a, 49);
                TextView textView8 = this.j;
                float f5 = this.d;
                e(textView8, f5, f5, 4);
                e(this.i, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.i.setEnabled(z);
        this.j.setEnabled(z);
        this.g.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != this.n) {
            this.n = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                this.o = drawable;
                ColorStateList colorStateList = this.m;
                if (colorStateList != null) {
                    DrawableCompat.setTintList(drawable, colorStateList);
                }
            }
            this.g.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.m = colorStateList;
        if (this.l != null && (drawable = this.o) != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            this.o.invalidateSelf();
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.k = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.e != i2) {
            this.e = i2;
            MenuItemImpl menuItemImpl = this.l;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f != z) {
            this.f = z;
            MenuItemImpl menuItemImpl = this.l;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.j, i2);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.i, i2);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.i.setTextColor(colorStateList);
            this.j.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.i.setText(charSequence);
        this.j.setText(charSequence);
        MenuItemImpl menuItemImpl = this.l;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.l;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.l.getTooltipText();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.a = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.g = (ImageView) findViewById(R.id.icon);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.labelGroup);
        this.h = viewGroup;
        TextView textView = (TextView) findViewById(R.id.smallLabel);
        this.i = textView;
        TextView textView2 = (TextView) findViewById(R.id.largeLabel);
        this.j = textView2;
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}
