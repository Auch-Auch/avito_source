package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;
@ExperimentalBadgeUtils
public class BadgeUtils {
    public static final boolean USE_COMPAT_PARENT = false;

    public static class a implements Runnable {
        public final /* synthetic */ Toolbar a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BadgeDrawable c;
        public final /* synthetic */ FrameLayout d;

        public a(Toolbar toolbar, int i, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.a = toolbar;
            this.b = i;
            this.c = badgeDrawable;
            this.d = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(this.a, this.b);
            if (actionMenuItemView != null) {
                BadgeDrawable badgeDrawable = this.c;
                badgeDrawable.setHorizontalOffset(this.a.getResources().getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset) + badgeDrawable.getHorizontalOffset());
                BadgeDrawable badgeDrawable2 = this.c;
                badgeDrawable2.setVerticalOffset(this.a.getResources().getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset) + badgeDrawable2.getVerticalOffset());
                BadgeUtils.attachBadgeDrawable(this.c, actionMenuItemView, this.d);
            }
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i = 0; i < parcelableSparseArray.size(); i++) {
            int keyAt = parcelableSparseArray.keyAt(i);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i);
            if (savedState != null) {
                BadgeDrawable badgeDrawable = new BadgeDrawable(context);
                badgeDrawable.setMaxCharacterCount(savedState.e);
                int i2 = savedState.d;
                if (i2 != -1) {
                    badgeDrawable.setNumber(i2);
                }
                badgeDrawable.setBackgroundColor(savedState.a);
                badgeDrawable.setBadgeTextColor(savedState.b);
                badgeDrawable.setBadgeGravity(savedState.i);
                badgeDrawable.setHorizontalOffset(savedState.k);
                badgeDrawable.setVerticalOffset(savedState.l);
                badgeDrawable.setVisible(savedState.j);
                sparseArray.put(keyAt, badgeDrawable);
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            BadgeDrawable valueAt = sparseArray.valueAt(i);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.getSavedState());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable != null) {
            if (USE_COMPAT_PARENT || badgeDrawable.getCustomBadgeParent() != null) {
                badgeDrawable.getCustomBadgeParent().setForeground(null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    public static void updateBadgeBounds(@NonNull Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else if (!USE_COMPAT_PARENT) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i) {
        ActionMenuItemView actionMenuItemView;
        if (badgeDrawable != null && (actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i)) != null) {
            detachBadgeDrawable(badgeDrawable, actionMenuItemView);
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i) {
        attachBadgeDrawable(badgeDrawable, toolbar, i, null);
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i, @Nullable FrameLayout frameLayout) {
        toolbar.post(new a(toolbar, i, badgeDrawable, frameLayout));
    }
}
