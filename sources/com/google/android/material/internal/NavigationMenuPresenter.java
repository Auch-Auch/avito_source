package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.Objects;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public NavigationMenuView a;
    public LinearLayout b;
    public MenuPresenter.Callback c;
    public MenuBuilder d;
    public int e;
    public c f;
    public LayoutInflater g;
    public int h;
    public boolean i;
    public ColorStateList j;
    public ColorStateList k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q = true;
    public int r;
    public int s;
    public int t;
    public int u = -1;
    public final View.OnClickListener v = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.d.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z = false;
            } else {
                NavigationMenuPresenter.this.f.b(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    public class c extends RecyclerView.Adapter<l> {
        public final ArrayList<e> c = new ArrayList<>();
        public MenuItemImpl d;
        public boolean e;

        public c() {
            a();
        }

        public final void a() {
            if (!this.e) {
                this.e = true;
                this.c.clear();
                this.c.add(new d());
                int i = -1;
                int size = NavigationMenuPresenter.this.d.getVisibleItems().size();
                boolean z = false;
                int i2 = 0;
                boolean z2 = false;
                int i3 = 0;
                while (i2 < size) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.d.getVisibleItems().get(i2);
                    if (menuItemImpl.isChecked()) {
                        b(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(z);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i2 != 0) {
                                ArrayList<e> arrayList = this.c;
                                int i4 = NavigationMenuPresenter.this.t;
                                int i5 = z ? 1 : 0;
                                int i6 = z ? 1 : 0;
                                int i7 = z ? 1 : 0;
                                int i8 = z ? 1 : 0;
                                arrayList.add(new f(i4, i5));
                            }
                            this.c.add(new g(menuItemImpl));
                            int size2 = subMenu.size();
                            int i9 = 0;
                            boolean z3 = false;
                            while (i9 < size2) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i9);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(z);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        b(menuItemImpl);
                                    }
                                    this.c.add(new g(menuItemImpl2));
                                }
                                i9++;
                                z = false;
                            }
                            if (z3) {
                                int size3 = this.c.size();
                                for (int size4 = this.c.size(); size4 < size3; size4++) {
                                    ((g) this.c.get(size4)).b = true;
                                }
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i) {
                            i3 = this.c.size();
                            z2 = menuItemImpl.getIcon() != null;
                            if (i2 != 0) {
                                i3++;
                                ArrayList<e> arrayList2 = this.c;
                                int i10 = NavigationMenuPresenter.this.t;
                                arrayList2.add(new f(i10, i10));
                            }
                        } else if (!z2 && menuItemImpl.getIcon() != null) {
                            int size5 = this.c.size();
                            for (int i11 = i3; i11 < size5; i11++) {
                                ((g) this.c.get(i11)).b = true;
                            }
                            z2 = true;
                        }
                        g gVar = new g(menuItemImpl);
                        gVar.b = z2;
                        this.c.add(gVar);
                        i = groupId;
                    }
                    i2++;
                    z = false;
                }
                this.e = false;
            }
        }

        public void b(@NonNull MenuItemImpl menuItemImpl) {
            if (this.d != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.d;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.d = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            e eVar = this.c.get(i);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull l lVar, int i) {
            l lVar2 = lVar;
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar2.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.k);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                if (navigationMenuPresenter.i) {
                    navigationMenuItemView.setTextAppearance(navigationMenuPresenter.h);
                }
                ColorStateList colorStateList = NavigationMenuPresenter.this.j;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = NavigationMenuPresenter.this.l;
                ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                g gVar = (g) this.c.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(gVar.b);
                navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.m);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.n);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.p) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.o);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.r);
                navigationMenuItemView.initialize(gVar.a, 0);
            } else if (itemViewType == 1) {
                ((TextView) lVar2.itemView).setText(((g) this.c.get(i)).a.getTitle());
            } else if (itemViewType == 2) {
                f fVar = (f) this.c.get(i);
                lVar2.itemView.setPadding(0, fVar.a, 0, fVar.b);
            }
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public l onCreateViewHolder(ViewGroup viewGroup, int i) {
            l lVar;
            if (i == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                lVar = new i(navigationMenuPresenter.g, viewGroup, navigationMenuPresenter.v);
            } else if (i == 1) {
                lVar = new k(NavigationMenuPresenter.this.g, viewGroup);
            } else if (i == 2) {
                lVar = new j(NavigationMenuPresenter.this.g, viewGroup);
            } else if (i != 3) {
                return null;
            } else {
                return new b(NavigationMenuPresenter.this.b);
            }
            return lVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(l lVar) {
            l lVar2 = lVar;
            if (lVar2 instanceof i) {
                ((NavigationMenuItemView) lVar2.itemView).recycle();
            }
        }
    }

    public static class d implements e {
    }

    public interface e {
    }

    public static class f implements e {
        public final int a;
        public final int b;

        public f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static class g implements e {
        public final MenuItemImpl a;
        public boolean b;

        public g(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }
    }

    public class h extends RecyclerViewAccessibilityDelegate {
        public h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            c cVar = NavigationMenuPresenter.this.f;
            int i = NavigationMenuPresenter.this.b.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.f.getItemCount(); i2++) {
                if (NavigationMenuPresenter.this.f.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, 0, false));
        }
    }

    public static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    public final void a() {
        int i2 = (this.b.getChildCount() != 0 || !this.q) ? 0 : this.s;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.b.addView(view);
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.s != systemWindowInsetTop) {
            this.s = systemWindowInsetTop;
            a();
        }
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.b, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.f.d;
    }

    public int getHeaderCount() {
        return this.b.getChildCount();
    }

    public View getHeaderView(int i2) {
        return this.b.getChildAt(i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.e;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.l;
    }

    public int getItemHorizontalPadding() {
        return this.m;
    }

    public int getItemIconPadding() {
        return this.n;
    }

    public int getItemMaxLines() {
        return this.r;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.j;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f == null) {
                this.f = new c();
            }
            int i2 = this.u;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            this.b = (LinearLayout) this.g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.a, false);
            this.a.setAdapter(this.f);
        }
        return this.a;
    }

    public View inflateHeaderView(@LayoutRes int i2) {
        View inflate = this.g.inflate(i2, (ViewGroup) this.b, false);
        addHeaderView(inflate);
        return inflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.g = LayoutInflater.from(context);
        this.d = menuBuilder;
        this.t = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.q;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.c;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItemImpl menuItemImpl;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        MenuItemImpl menuItemImpl2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                c cVar = this.f;
                Objects.requireNonNull(cVar);
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    cVar.e = true;
                    int size = cVar.c.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        e eVar = cVar.c.get(i3);
                        if ((eVar instanceof g) && (menuItemImpl2 = ((g) eVar).a) != null && menuItemImpl2.getItemId() == i2) {
                            cVar.b(menuItemImpl2);
                            break;
                        }
                        i3++;
                    }
                    cVar.e = false;
                    cVar.a();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = cVar.c.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e eVar2 = cVar.c.get(i4);
                        if (!(!(eVar2 instanceof g) || (menuItemImpl = ((g) eVar2).a) == null || (actionView = menuItemImpl.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(menuItemImpl.getItemId())) == null)) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        c cVar = this.f;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
            Bundle bundle2 = new Bundle();
            MenuItemImpl menuItemImpl = cVar.d;
            if (menuItemImpl != null) {
                bundle2.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = cVar.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = cVar.c.get(i2);
                if (eVar instanceof g) {
                    MenuItemImpl menuItemImpl2 = ((g) eVar).a;
                    View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(menuItemImpl2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.b != null) {
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.b.removeView(view);
        if (this.b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.a;
            navigationMenuView.setPadding(0, this.s, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z) {
        if (this.q != z) {
            this.q = z;
            a();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.c = callback;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.f.b(menuItemImpl);
    }

    public void setId(int i2) {
        this.e = i2;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.l = drawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i2) {
        this.m = i2;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.k = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i2) {
        this.r = i2;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.h = i2;
        this.i = true;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.j = colorStateList;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i2) {
        this.u = i2;
        NavigationMenuView navigationMenuView = this.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void setUpdateSuspended(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.e = z;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
            cVar.notifyDataSetChanged();
        }
    }
}
