package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public abstract class PreferenceGroup extends Preference {
    public final SimpleArrayMap<String, Long> R;
    public final Handler S;
    public List<Preference> T;
    public boolean U;
    public int V;
    public boolean W;
    public int X;
    public OnExpandButtonClickListener Y;
    public final Runnable Z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface OnExpandButtonClickListener {
        void onExpandButtonClick();
    }

    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference preference);

        int getPreferenceAdapterPosition(String str);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.R.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.R = new SimpleArrayMap<>();
        this.S = new Handler();
        this.U = true;
        this.V = 0;
        this.W = false;
        this.X = Integer.MAX_VALUE;
        this.Y = null;
        this.Z = new a();
        this.T = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i, i2);
        int i3 = R.styleable.PreferenceGroup_orderingFromXml;
        this.U = TypedArrayUtils.getBoolean(obtainStyledAttributes, i3, i3, true);
        int i4 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
        if (obtainStyledAttributes.hasValue(i4)) {
            setInitialExpandedChildrenCount(TypedArrayUtils.getInt(obtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        long j;
        if (this.T.contains(preference)) {
            return true;
        }
        if (preference.getKey() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.getParent() != null) {
                preferenceGroup = preferenceGroup.getParent();
            }
            preferenceGroup.findPreference(preference.getKey());
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.U) {
                int i = this.V;
                this.V = i + 1;
                preference.setOrder(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.U);
            }
        }
        int binarySearch = Collections.binarySearch(this.T, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * -1) - 1;
        }
        if (!onPrepareAddPreference(preference)) {
            return false;
        }
        synchronized (this) {
            this.T.add(binarySearch, preference);
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        String key = preference.getKey();
        if (key == null || !this.R.containsKey(key)) {
            synchronized (preferenceManager) {
                j = preferenceManager.b;
                preferenceManager.b = 1 + j;
            }
        } else {
            j = this.R.get(key).longValue();
            this.R.remove(key);
        }
        preference.onAttachedToHierarchy(preferenceManager, j);
        if (preference.L == null) {
            preference.L = this;
            if (this.W) {
                preference.onAttached();
            }
            notifyHierarchyChanged();
            return true;
        }
        throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
    }

    @Override // androidx.preference.Preference
    public void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchSaveInstanceState(bundle);
        }
    }

    public final boolean e(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.onPrepareForRemoval();
            if (preference.getParent() == this) {
                preference.L = null;
            }
            remove = this.T.remove(preference);
            if (remove) {
                String key = preference.getKey();
                if (key != null) {
                    this.R.put(key, Long.valueOf(preference.a()));
                    this.S.removeCallbacks(this.Z);
                    this.S.post(this.Z);
                }
                if (this.W) {
                    preference.onDetached();
                }
            }
        }
        return remove;
    }

    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        T t;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        } else {
            int preferenceCount = getPreferenceCount();
            for (int i = 0; i < preferenceCount; i++) {
                T t2 = (T) getPreference(i);
                if (TextUtils.equals(t2.getKey(), charSequence)) {
                    return t2;
                }
                if ((t2 instanceof PreferenceGroup) && (t = (T) ((PreferenceGroup) t2).findPreference(charSequence)) != null) {
                    return t;
                }
            }
            return null;
        }
    }

    public int getInitialExpandedChildrenCount() {
        return this.X;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public OnExpandButtonClickListener getOnExpandButtonClickListener() {
        return this.Y;
    }

    public Preference getPreference(int i) {
        return this.T.get(i);
    }

    public int getPreferenceCount() {
        return this.T.size();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAttached() {
        return this.W;
    }

    public boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return this.U;
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onParentChanged(this, z);
        }
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.W = true;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onAttached();
        }
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        this.W = false;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onDetached();
        }
    }

    public boolean onPrepareAddPreference(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(b.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        this.X = bVar.a;
        super.onRestoreInstanceState(bVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        return new b(super.onSaveInstanceState(), this.X);
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.T;
            for (int size = list.size() - 1; size >= 0; size--) {
                e(list.get(0));
            }
        }
        notifyHierarchyChanged();
    }

    public boolean removePreference(Preference preference) {
        boolean e = e(preference);
        notifyHierarchyChanged();
        return e;
    }

    public boolean removePreferenceRecursively(@NonNull CharSequence charSequence) {
        Preference findPreference = findPreference(charSequence);
        if (findPreference == null) {
            return false;
        }
        return findPreference.getParent().removePreference(findPreference);
    }

    public void setInitialExpandedChildrenCount(int i) {
        if (i != Integer.MAX_VALUE && !hasKey()) {
            getClass().getSimpleName();
        }
        this.X = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOnExpandButtonClickListener(@Nullable OnExpandButtonClickListener onExpandButtonClickListener) {
        this.Y = onExpandButtonClickListener;
    }

    public void setOrderingAsAdded(boolean z) {
        this.U = z;
    }

    public static class b extends Preference.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public int a;

        public static class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
