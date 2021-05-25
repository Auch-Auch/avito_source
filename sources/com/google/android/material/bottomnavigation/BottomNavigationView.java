package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
public class BottomNavigationView extends FrameLayout {
    public static final int h = R.style.Widget_Design_BottomNavigationView;
    @NonNull
    public final MenuBuilder a;
    @NonNull
    @VisibleForTesting
    public final BottomNavigationMenuView b;
    public final BottomNavigationPresenter c;
    @Nullable
    public ColorStateList d;
    public MenuInflater e;
    public OnNavigationItemSelectedListener f;
    public OnNavigationItemReselectedListener g;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (BottomNavigationView.this.g == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = BottomNavigationView.this.f;
                if (onNavigationItemSelectedListener == null || onNavigationItemSelectedListener.onNavigationItemSelected(menuItem)) {
                    return false;
                }
                return true;
            }
            BottomNavigationView.this.g.onNavigationItemReselected(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        @Nullable
        public Bundle b;

        public static class a implements Parcelable.ClassLoaderCreator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public b createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new b[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new b(parcel, null);
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.b);
        }

        public b(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readBundle(classLoader == null ? b.class.getClassLoader() : classLoader);
        }
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.e == null) {
            this.e = new SupportMenuInflater(getContext());
        }
        return this.e;
    }

    @Nullable
    public BadgeDrawable getBadge(int i) {
        return this.b.x.get(i);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.d;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    @NonNull
    public Menu getMenu() {
        return this.a;
    }

    public BadgeDrawable getOrCreateBadge(int i) {
        BottomNavigationMenuView bottomNavigationMenuView = this.b;
        bottomNavigationMenuView.c(i);
        BadgeDrawable badgeDrawable = bottomNavigationMenuView.x.get(i);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(bottomNavigationMenuView.getContext());
            bottomNavigationMenuView.x.put(i, badgeDrawable);
        }
        BottomNavigationItemView a3 = bottomNavigationMenuView.a(i);
        if (a3 != null) {
            a3.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    public void inflateMenu(int i) {
        this.c.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.a);
        this.c.setUpdateSuspended(false);
        this.c.updateMenuView(true);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.b.isItemHorizontalTranslationEnabled();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.a.restorePresenterStates(bVar.b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        bVar.b = bundle;
        this.a.savePresenterStates(bundle);
        return bVar;
    }

    public void removeBadge(int i) {
        BottomNavigationMenuView bottomNavigationMenuView = this.b;
        bottomNavigationMenuView.c(i);
        BadgeDrawable badgeDrawable = bottomNavigationMenuView.x.get(i);
        BottomNavigationItemView a3 = bottomNavigationMenuView.a(i);
        if (a3 != null) {
            a3.c();
        }
        if (badgeDrawable != null) {
            bottomNavigationMenuView.x.remove(i);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.setElevation(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.d = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i) {
        this.b.setItemBackgroundRes(i);
        this.d = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.b.isItemHorizontalTranslationEnabled() != z) {
            this.b.setItemHorizontalTranslationEnabled(z);
            this.c.updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i) {
        this.b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(@DimenRes int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i, @Nullable View.OnTouchListener onTouchListener) {
        this.b.setItemOnTouchListener(i, onTouchListener);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            if (colorStateList == null) {
                this.b.setItemBackground(null);
                return;
            }
            this.b.setItemBackground(new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList), null, null));
        } else if (colorStateList == null && this.b.getItemBackground() != null) {
            this.b.setItemBackground(null);
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i) {
        this.b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i) {
        this.b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        this.g = onNavigationItemReselectedListener;
    }

    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f = onNavigationItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i) {
        MenuItem findItem = this.a.findItem(i);
        if (findItem != null && !this.a.performItemAction(findItem, this.c, 0)) {
            findItem.setChecked(true);
        }
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, h), attributeSet, i);
        BottomNavigationPresenter bottomNavigationPresenter = new BottomNavigationPresenter();
        this.c = bottomNavigationPresenter;
        Context context2 = getContext();
        MenuBuilder bottomNavigationMenu = new BottomNavigationMenu(context2);
        this.a = bottomNavigationMenu;
        BottomNavigationMenuView bottomNavigationMenuView = new BottomNavigationMenuView(context2);
        this.b = bottomNavigationMenuView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        bottomNavigationMenuView.setLayoutParams(layoutParams);
        bottomNavigationPresenter.setBottomNavigationMenuView(bottomNavigationMenuView);
        bottomNavigationPresenter.setId(1);
        bottomNavigationMenuView.setPresenter(bottomNavigationPresenter);
        bottomNavigationMenu.addMenuPresenter(bottomNavigationPresenter);
        bottomNavigationPresenter.initForMenu(getContext(), bottomNavigationMenu);
        int[] iArr = R.styleable.BottomNavigationView;
        int i2 = R.style.Widget_Design_BottomNavigationView;
        int i3 = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
        int i4 = R.styleable.BottomNavigationView_itemTextAppearanceActive;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i, i2, i3, i4);
        int i5 = R.styleable.BottomNavigationView_itemIconTint;
        if (obtainTintedStyledAttributes.hasValue(i5)) {
            bottomNavigationMenuView.setIconTintList(obtainTintedStyledAttributes.getColorStateList(i5));
        } else {
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.createDefaultColorStateList(16842808));
        }
        setItemIconSize(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (obtainTintedStyledAttributes.hasValue(i3)) {
            setItemTextAppearanceInactive(obtainTintedStyledAttributes.getResourceId(i3, 0));
        }
        if (obtainTintedStyledAttributes.hasValue(i4)) {
            setItemTextAppearanceActive(obtainTintedStyledAttributes.getResourceId(i4, 0));
        }
        int i6 = R.styleable.BottomNavigationView_itemTextColor;
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            setItemTextColor(obtainTintedStyledAttributes.getColorStateList(i6));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        int i7 = R.styleable.BottomNavigationView_elevation;
        if (obtainTintedStyledAttributes.hasValue(i7)) {
            setElevation((float) obtainTintedStyledAttributes.getDimensionPixelSize(i7, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(obtainTintedStyledAttributes.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (resourceId != 0) {
            bottomNavigationMenuView.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.BottomNavigationView_itemRippleColor));
        }
        int i8 = R.styleable.BottomNavigationView_menu;
        if (obtainTintedStyledAttributes.hasValue(i8)) {
            inflateMenu(obtainTintedStyledAttributes.getResourceId(i8, 0));
        }
        obtainTintedStyledAttributes.recycle();
        addView(bottomNavigationMenuView, layoutParams);
        bottomNavigationMenu.setCallback(new a());
        ViewUtils.doOnApplyWindowInsets(this, new a2.j.b.d.e.a(this));
    }
}
