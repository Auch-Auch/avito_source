package com.avito.android.tariff.edit_info.ui;

import dagger.internal.Factory;
public final class EditInfoEqualityComparator_Factory implements Factory<EditInfoEqualityComparator> {

    public static final class a {
        public static final EditInfoEqualityComparator_Factory a = new EditInfoEqualityComparator_Factory();
    }

    public static EditInfoEqualityComparator_Factory create() {
        return a.a;
    }

    public static EditInfoEqualityComparator newInstance() {
        return new EditInfoEqualityComparator();
    }

    @Override // javax.inject.Provider
    public EditInfoEqualityComparator get() {
        return newInstance();
    }
}
