package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter implements MenuPresenter {
    public MenuBuilder a;
    public BottomNavigationMenuView b;
    public boolean c = false;
    public int d;

    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0272a();
        public int a;
        @Nullable
        public ParcelableSparseArray b;

        /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationPresenter$a$a  reason: collision with other inner class name */
        public static class C0272a implements Parcelable.Creator<a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public a createFromParcel(@NonNull Parcel parcel) {
                return new a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, 0);
        }

        public a(@NonNull Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (ParcelableSparseArray) parcel.readParcelable(a.class.getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.b;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.a = menuBuilder;
        this.b.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof a) {
            BottomNavigationMenuView bottomNavigationMenuView = this.b;
            a aVar = (a) parcelable;
            int i = aVar.a;
            int size = bottomNavigationMenuView.z.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item = bottomNavigationMenuView.z.getItem(i2);
                if (i == item.getItemId()) {
                    bottomNavigationMenuView.m = i;
                    bottomNavigationMenuView.n = i2;
                    item.setChecked(true);
                    break;
                }
                i2++;
            }
            this.b.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.b.getContext(), aVar.b));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        a aVar = new a();
        aVar.a = this.b.getSelectedItemId();
        aVar.b = BadgeUtils.createParcelableBadgeStates(this.b.getBadgeDrawables());
        return aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.b = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
    }

    public void setId(int i) {
        this.d = i;
    }

    public void setUpdateSuspended(boolean z) {
        this.c = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (!this.c) {
            if (z) {
                this.b.buildMenuView();
            } else {
                this.b.updateMenuView();
            }
        }
    }
}
