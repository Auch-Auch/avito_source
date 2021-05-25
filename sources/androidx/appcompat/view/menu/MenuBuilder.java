package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {
    public static final int[] A = {1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;
    public boolean d;
    public Callback e;
    public ArrayList<MenuItemImpl> f;
    public ArrayList<MenuItemImpl> g;
    public boolean h;
    public ArrayList<MenuItemImpl> i;
    public ArrayList<MenuItemImpl> j;
    public boolean k;
    public int l = 0;
    public ContextMenu.ContextMenuInfo m;
    public CharSequence n;
    public Drawable o;
    public View p;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<MenuItemImpl> v = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<MenuPresenter>> w = new CopyOnWriteArrayList<>();
    public MenuItemImpl x;
    public boolean y = false;
    public boolean z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.a = context;
        this.b = context.getResources();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = true;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = true;
        h(true);
    }

    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.e;
        return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    public MenuItem addInternal(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = (-65536 & i4) >> 16;
        if (i6 >= 0) {
            int[] iArr = A;
            if (i6 < iArr.length) {
                int i7 = (iArr[i6] << 16) | (65535 & i4);
                MenuItemImpl menuItemImpl = new MenuItemImpl(this, i2, i3, i4, i7, charSequence, this.l);
                ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
                if (contextMenuInfo != null) {
                    menuItemImpl.E = contextMenuInfo;
                }
                ArrayList<MenuItemImpl> arrayList = this.f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).getOrdering() <= i7) {
                            i5 = size + 1;
                            break;
                        }
                    } else {
                        i5 = 0;
                        break;
                    }
                }
                arrayList.add(i5, menuItemImpl);
                onItemsChanged(true);
                return menuItemImpl;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.a);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public MenuItemImpl b(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<MenuItemImpl> arrayList = this.v;
        arrayList.clear();
        c(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = arrayList.get(i3);
            if (isQwertyMode) {
                c2 = menuItemImpl.getAlphabeticShortcut();
            } else {
                c2 = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c2 == '\b' && i2 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public void c(List<MenuItemImpl> list, int i2, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = this.f.get(i3);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).c(list, i2, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((isQwertyMode ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == '\b' && i2 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void changeMenuMode() {
        Callback callback = this.e;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.x;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.f.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.q = true;
        clear();
        clearHeader();
        this.w.clear();
        this.q = false;
        this.r = false;
        this.s = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        onItemsChanged(false);
    }

    public final void close(boolean z2) {
        if (!this.u) {
            this.u = true;
            Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.w.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z2);
                }
            }
            this.u = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (!this.w.isEmpty() && this.x == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.w.remove(next);
                } else {
                    z2 = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z2) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z2) {
                this.x = null;
            }
        }
        return z2;
    }

    public void d() {
        this.k = true;
        onItemsChanged(true);
    }

    public void e() {
        this.h = true;
        onItemsChanged(true);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (this.w.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.w.remove(next);
            } else {
                z2 = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z2) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z2) {
            this.x = menuItemImpl;
        }
        return z2;
    }

    public final void f(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f.size()) {
            this.f.remove(i2);
            if (z2) {
                onItemsChanged(true);
            }
        }
    }

    public int findGroupIndex(int i2) {
        return findGroupIndex(i2, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f.get(i3);
            if (menuItemImpl.getItemId() == i2) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.k) {
            Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.w.remove(next);
                } else {
                    z2 |= menuPresenter.flagActionItems();
                }
            }
            if (z2) {
                this.i.clear();
                this.j.clear();
                int size = visibleItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i2);
                    if (menuItemImpl.isActionButton()) {
                        this.i.add(menuItemImpl);
                    } else {
                        this.j.add(menuItemImpl);
                    }
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(getVisibleItems());
            }
            this.k = false;
        }
    }

    public final void g(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.b;
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i2 > 0) {
                this.n = resources.getText(i2);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i3 > 0) {
                this.o = ContextCompat.getDrawable(getContext(), i3);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        onItemsChanged(false);
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.i;
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.a;
    }

    public MenuItemImpl getExpandedItem() {
        return this.x;
    }

    public Drawable getHeaderIcon() {
        return this.o;
    }

    public CharSequence getHeaderTitle() {
        return this.n;
    }

    public View getHeaderView() {
        return this.p;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f.get(i2);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.j;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f.get(i2);
            if (menuItemImpl.isVisible()) {
                this.g.add(menuItemImpl);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public final void h(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.b.getConfiguration().keyboard == 1 || !ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.a), this.a)) {
            z3 = false;
        }
        this.d = z3;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.y;
    }

    public boolean isQwertyMode() {
        return this.c;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return b(i2, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.d;
    }

    public void onItemsChanged(boolean z2) {
        if (!this.q) {
            if (z2) {
                this.h = true;
                this.k = true;
            }
            if (!this.w.isEmpty()) {
                stopDispatchingItemsChanged();
                Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
                while (it.hasNext()) {
                    WeakReference<MenuPresenter> next = it.next();
                    MenuPresenter menuPresenter = next.get();
                    if (menuPresenter == null) {
                        this.w.remove(next);
                    } else {
                        menuPresenter.updateMenuView(z2);
                    }
                }
                startDispatchingItemsChanged();
                return;
            }
            return;
        }
        this.r = true;
        if (z2) {
            this.s = true;
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return performItemAction(findItem(i2), i3);
    }

    public boolean performItemAction(MenuItem menuItem, int i2) {
        return performItemAction(menuItem, null, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        MenuItemImpl b2 = b(i2, keyEvent);
        boolean performItemAction = b2 != null ? performItemAction(b2, i3) : false;
        if ((i3 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int findGroupIndex = findGroupIndex(i2);
        if (findGroupIndex >= 0) {
            int size = this.f.size() - findGroupIndex;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f.get(findGroupIndex).getGroupId() != i2) {
                    break;
                }
                f(findGroupIndex, false);
                i3 = i4;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        f(findItemIndex(i2), true);
    }

    public void removeItemAt(int i2) {
        f(i2, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.w.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.w.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.w.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public void setCallback(Callback callback) {
        this.e = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.m = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i2) {
        this.l = i2;
        return this;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setExclusiveCheckable(z3);
                menuItemImpl.setCheckable(z2);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.f.get(i3);
            if (menuItemImpl.getGroupId() == i2 && menuItemImpl.e(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            onItemsChanged(true);
        }
    }

    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        g(0, null, 0, drawable, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        g(0, charSequence, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View view) {
        g(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z2) {
        this.t = z2;
    }

    public void setOverrideVisibleItems(boolean z2) {
        this.z = z2;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.c = z2;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z2) {
        if (this.d != z2) {
            h(z2);
            onItemsChanged(false);
        }
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    public void startDispatchingItemsChanged() {
        this.q = false;
        if (this.r) {
            this.r = false;
            onItemsChanged(this.s);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return addInternal(0, 0, 0, this.b.getString(i2));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.w.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.k = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.b.getString(i2));
    }

    public int findGroupIndex(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i2) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        boolean z2 = false;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z3 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z3) {
            if ((i2 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z3) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            if (!this.w.isEmpty()) {
                if (menuPresenter != null) {
                    z2 = menuPresenter.onSubMenuSelected(subMenuBuilder);
                }
                Iterator<WeakReference<MenuPresenter>> it = this.w.iterator();
                while (it.hasNext()) {
                    WeakReference<MenuPresenter> next = it.next();
                    MenuPresenter menuPresenter2 = next.get();
                    if (menuPresenter2 == null) {
                        this.w.remove(next);
                    } else if (!z2) {
                        z2 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
                    }
                }
            }
            invoke |= z2;
            if (!invoke) {
                close(true);
            }
        } else if ((i2 & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    public MenuBuilder setHeaderIconInt(int i2) {
        g(0, null, i2, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int i2) {
        g(i2, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return addInternal(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i2, i3, i4, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.a, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return addInternal(i2, i3, i4, this.b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.b.getString(i5));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
