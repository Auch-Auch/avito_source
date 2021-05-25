package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Preference implements Comparable<Preference> {
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public b J;
    public List<Preference> K;
    public PreferenceGroup L;
    public boolean M;
    public boolean N;
    public c O;
    public SummaryProvider P;
    public final View.OnClickListener Q;
    public Context a;
    @Nullable
    public PreferenceManager b;
    @Nullable
    public PreferenceDataStore c;
    public long d;
    public boolean e;
    public OnPreferenceChangeListener f;
    public OnPreferenceClickListener g;
    public int h;
    public int i;
    public CharSequence j;
    public CharSequence k;
    public int l;
    public Drawable m;
    public String n;
    public Intent o;
    public String p;
    public Bundle q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public Object w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        public static class a implements Parcelable.Creator<BaseSavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public interface SummaryProvider<T extends Preference> {
        CharSequence provideSummary(T t);
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.performClick(view);
        }
    }

    public interface b {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    public static class c implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public final Preference a;

        public c(Preference preference) {
            this.a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence summary = this.a.getSummary();
            if (this.a.isCopyingEnabled() && !TextUtils.isEmpty(summary)) {
                contextMenu.setHeaderTitle(summary);
                contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            CharSequence summary = this.a.getSummary();
            ((ClipboardManager) this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", summary));
            Toast.makeText(this.a.getContext(), this.a.getContext().getString(R.string.preference_copied, summary), 0).show();
            return true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.r = true;
        this.s = true;
        this.u = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.D = true;
        this.G = true;
        int i4 = R.layout.preference;
        this.H = i4;
        this.Q = new a();
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, i3);
        this.l = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.n = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.j = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.k = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.h = TypedArrayUtils.getInt(obtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.p = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.H = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, i4);
        this.I = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.r = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.s = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.u = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.v = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        int i5 = R.styleable.Preference_allowDividerAbove;
        this.A = TypedArrayUtils.getBoolean(obtainStyledAttributes, i5, i5, this.s);
        int i6 = R.styleable.Preference_allowDividerBelow;
        this.B = TypedArrayUtils.getBoolean(obtainStyledAttributes, i6, i6, this.s);
        int i7 = R.styleable.Preference_defaultValue;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.w = onGetDefaultValue(obtainStyledAttributes, i7);
        } else {
            int i8 = R.styleable.Preference_android_defaultValue;
            if (obtainStyledAttributes.hasValue(i8)) {
                this.w = onGetDefaultValue(obtainStyledAttributes, i8);
            }
        }
        this.G = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        int i9 = R.styleable.Preference_singleLineTitle;
        boolean hasValue = obtainStyledAttributes.hasValue(i9);
        this.C = hasValue;
        if (hasValue) {
            this.D = TypedArrayUtils.getBoolean(obtainStyledAttributes, i9, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.E = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        int i10 = R.styleable.Preference_isPreferenceVisible;
        this.z = TypedArrayUtils.getBoolean(obtainStyledAttributes, i10, i10, true);
        int i11 = R.styleable.Preference_enableCopying;
        this.F = TypedArrayUtils.getBoolean(obtainStyledAttributes, i11, i11, false);
        obtainStyledAttributes.recycle();
    }

    public long a() {
        return this.d;
    }

    public final void b() {
        if (!TextUtils.isEmpty(this.v)) {
            Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.v);
            if (findPreferenceInHierarchy != null) {
                if (findPreferenceInHierarchy.K == null) {
                    findPreferenceInHierarchy.K = new ArrayList();
                }
                findPreferenceInHierarchy.K.add(this);
                onDependencyChanged(findPreferenceInHierarchy, findPreferenceInHierarchy.shouldDisableDependents());
                return;
            }
            StringBuilder L2 = a2.b.a.a.a.L("Dependency \"");
            L2.append(this.v);
            L2.append("\" not found for preference \"");
            L2.append(this.n);
            L2.append("\" (title: \"");
            L2.append((Object) this.j);
            L2.append("\"");
            throw new IllegalStateException(L2.toString());
        }
    }

    public final void c(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                c(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    public boolean callChangeListener(Object obj) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.f;
        return onPreferenceChangeListener == null || onPreferenceChangeListener.onPreferenceChange(this, obj);
    }

    public final void d() {
        Preference findPreferenceInHierarchy;
        List<Preference> list;
        String str = this.v;
        if (str != null && (findPreferenceInHierarchy = findPreferenceInHierarchy(str)) != null && (list = findPreferenceInHierarchy.K) != null) {
            list.remove(this);
        }
    }

    public void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.n)) != null) {
            this.N = false;
            onRestoreInstanceState(parcelable);
            if (!this.N) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.N = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (!this.N) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (onSaveInstanceState != null) {
                bundle.putParcelable(this.n, onSaveInstanceState);
            }
        }
    }

    @Nullable
    public <T extends Preference> T findPreferenceInHierarchy(@NonNull String str) {
        PreferenceManager preferenceManager = this.b;
        if (preferenceManager == null) {
            return null;
        }
        return (T) preferenceManager.findPreference(str);
    }

    public Context getContext() {
        return this.a;
    }

    public String getDependency() {
        return this.v;
    }

    public Bundle getExtras() {
        if (this.q == null) {
            this.q = new Bundle();
        }
        return this.q;
    }

    public String getFragment() {
        return this.p;
    }

    public Drawable getIcon() {
        int i2;
        if (this.m == null && (i2 = this.l) != 0) {
            this.m = AppCompatResources.getDrawable(this.a, i2);
        }
        return this.m;
    }

    public Intent getIntent() {
        return this.o;
    }

    public String getKey() {
        return this.n;
    }

    public final int getLayoutResource() {
        return this.H;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.f;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.g;
    }

    public int getOrder() {
        return this.h;
    }

    @Nullable
    public PreferenceGroup getParent() {
        return this.L;
    }

    public boolean getPersistedBoolean(boolean z2) {
        if (!shouldPersist()) {
            return z2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getBoolean(this.n, z2);
        }
        return this.b.getSharedPreferences().getBoolean(this.n, z2);
    }

    public float getPersistedFloat(float f2) {
        if (!shouldPersist()) {
            return f2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getFloat(this.n, f2);
        }
        return this.b.getSharedPreferences().getFloat(this.n, f2);
    }

    public int getPersistedInt(int i2) {
        if (!shouldPersist()) {
            return i2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getInt(this.n, i2);
        }
        return this.b.getSharedPreferences().getInt(this.n, i2);
    }

    public long getPersistedLong(long j2) {
        if (!shouldPersist()) {
            return j2;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getLong(this.n, j2);
        }
        return this.b.getSharedPreferences().getLong(this.n, j2);
    }

    public String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getString(this.n, str);
        }
        return this.b.getSharedPreferences().getString(this.n, str);
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getStringSet(this.n, set);
        }
        return this.b.getSharedPreferences().getStringSet(this.n, set);
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        PreferenceDataStore preferenceDataStore = this.c;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.b;
        if (preferenceManager != null) {
            return preferenceManager.getPreferenceDataStore();
        }
        return null;
    }

    public PreferenceManager getPreferenceManager() {
        return this.b;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.b == null || getPreferenceDataStore() != null) {
            return null;
        }
        return this.b.getSharedPreferences();
    }

    public boolean getShouldDisableView() {
        return this.G;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        return this.k;
    }

    @Nullable
    public final SummaryProvider getSummaryProvider() {
        return this.P;
    }

    public CharSequence getTitle() {
        return this.j;
    }

    public final int getWidgetLayoutResource() {
        return this.I;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.n);
    }

    public boolean isCopyingEnabled() {
        return this.F;
    }

    public boolean isEnabled() {
        return this.r && this.x && this.y;
    }

    public boolean isIconSpaceReserved() {
        return this.E;
    }

    public boolean isPersistent() {
        return this.u;
    }

    public boolean isSelectable() {
        return this.s;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().getPreferenceScreen()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.D;
    }

    public final boolean isVisible() {
        return this.z;
    }

    public void notifyChanged() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.onPreferenceChange(this);
        }
    }

    public void notifyDependencyChange(boolean z2) {
        List<Preference> list = this.K;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).onDependencyChanged(this, z2);
            }
        }
    }

    public void notifyHierarchyChanged() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.onPreferenceHierarchyChange(this);
        }
    }

    public void onAttached() {
        b();
    }

    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        long j2;
        this.b = preferenceManager;
        if (!this.e) {
            synchronized (preferenceManager) {
                j2 = preferenceManager.b;
                preferenceManager.b = 1 + j2;
            }
            this.d = j2;
        }
        if (getPreferenceDataStore() != null) {
            onSetInitialValue(true, this.w);
        } else if (!shouldPersist() || !getSharedPreferences().contains(this.n)) {
            Object obj = this.w;
            if (obj != null) {
                onSetInitialValue(false, obj);
            }
        } else {
            onSetInitialValue(true, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.preference.PreferenceViewHolder r9) {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.onBindViewHolder(androidx.preference.PreferenceViewHolder):void");
    }

    public void onClick() {
    }

    public void onDependencyChanged(Preference preference, boolean z2) {
        if (this.x == z2) {
            this.x = !z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onDetached() {
        d();
        this.M = true;
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return null;
    }

    @CallSuper
    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void onParentChanged(Preference preference, boolean z2) {
        if (this.y == z2) {
            this.y = !z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onPrepareForRemoval() {
        d();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.N = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable onSaveInstanceState() {
        this.N = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void onSetInitialValue(@Nullable Object obj) {
    }

    @Deprecated
    public void onSetInitialValue(boolean z2, Object obj) {
        onSetInitialValue(obj);
    }

    public Bundle peekExtras() {
        return this.q;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void performClick(View view) {
        performClick();
    }

    public boolean persistBoolean(boolean z2) {
        if (!shouldPersist()) {
            return false;
        }
        if (z2 == getPersistedBoolean(!z2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putBoolean(this.n, z2);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putBoolean(this.n, z2);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public boolean persistFloat(float f2) {
        if (!shouldPersist()) {
            return false;
        }
        if (f2 == getPersistedFloat(Float.NaN)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putFloat(this.n, f2);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putFloat(this.n, f2);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public boolean persistInt(int i2) {
        if (!shouldPersist()) {
            return false;
        }
        if (i2 == getPersistedInt(~i2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putInt(this.n, i2);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putInt(this.n, i2);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public boolean persistLong(long j2) {
        if (!shouldPersist()) {
            return false;
        }
        if (j2 == getPersistedLong(~j2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putLong(this.n, j2);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putLong(this.n, j2);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(str, getPersistedString(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putString(this.n, str);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putString(this.n, str);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public boolean persistStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(getPersistedStringSet(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putStringSet(this.n, set);
        } else {
            SharedPreferences.Editor b2 = this.b.b();
            b2.putStringSet(this.n, set);
            if (!this.b.f) {
                b2.apply();
            }
        }
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCopyingEnabled(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            notifyChanged();
        }
    }

    public void setDefaultValue(Object obj) {
        this.w = obj;
    }

    public void setDependency(String str) {
        d();
        this.v = str;
        b();
    }

    public void setEnabled(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.p = str;
    }

    public void setIcon(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            this.l = 0;
            notifyChanged();
        }
    }

    public void setIconSpaceReserved(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        this.o = intent;
    }

    public void setKey(String str) {
        this.n = str;
        if (this.t && !hasKey()) {
            if (!TextUtils.isEmpty(this.n)) {
                this.t = true;
                return;
            }
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
    }

    public void setLayoutResource(int i2) {
        this.H = i2;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.f = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.g = onPreferenceClickListener;
    }

    public void setOrder(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z2) {
        this.u = z2;
    }

    public void setPreferenceDataStore(PreferenceDataStore preferenceDataStore) {
        this.c = preferenceDataStore;
    }

    public void setSelectable(boolean z2) {
        if (this.s != z2) {
            this.s = z2;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z2) {
        if (this.G != z2) {
            this.G = z2;
            notifyChanged();
        }
    }

    public void setSingleLineTitle(boolean z2) {
        this.C = true;
        this.D = z2;
    }

    public void setSummary(CharSequence charSequence) {
        if (getSummaryProvider() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.k, charSequence)) {
            this.k = charSequence;
            notifyChanged();
        }
    }

    public final void setSummaryProvider(@Nullable SummaryProvider summaryProvider) {
        this.P = summaryProvider;
        notifyChanged();
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.j != null) || (charSequence != null && !charSequence.equals(this.j))) {
            this.j = charSequence;
            notifyChanged();
        }
    }

    public void setViewId(int i2) {
        this.i = i2;
    }

    public final void setVisible(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            b bVar = this.J;
            if (bVar != null) {
                bVar.onPreferenceVisibilityChange(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i2) {
        this.I = i2;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public boolean shouldPersist() {
        return this.b != null && isPersistent() && hasKey();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public int compareTo(@NonNull Preference preference) {
        int i2 = this.h;
        int i3 = preference.h;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.j;
        CharSequence charSequence2 = preference.j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.j.toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener onPreferenceTreeClickListener;
        if (isEnabled() && isSelectable()) {
            onClick();
            OnPreferenceClickListener onPreferenceClickListener = this.g;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (onPreferenceTreeClickListener = preferenceManager.getOnPreferenceTreeClickListener()) == null || !onPreferenceTreeClickListener.onPreferenceTreeClick(this)) && this.o != null) {
                    getContext().startActivity(this.o);
                }
            }
        }
    }

    public void setTitle(int i2) {
        setTitle(this.a.getString(i2));
    }

    public void setIcon(int i2) {
        setIcon(AppCompatResources.getDrawable(this.a, i2));
        this.l = i2;
    }

    public void setSummary(int i2) {
        setSummary(this.a.getString(i2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onAttachedToHierarchy(PreferenceManager preferenceManager, long j2) {
        this.d = j2;
        this.e = true;
        boolean z2 = false;
        try {
            onAttachedToHierarchy(preferenceManager);
        } finally {
            this.e = z2;
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
