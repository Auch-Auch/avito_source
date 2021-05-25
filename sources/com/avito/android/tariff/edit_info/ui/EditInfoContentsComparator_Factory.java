package com.avito.android.tariff.edit_info.ui;

import dagger.internal.Factory;
public final class EditInfoContentsComparator_Factory implements Factory<EditInfoContentsComparator> {

    public static final class a {
        public static final EditInfoContentsComparator_Factory a = new EditInfoContentsComparator_Factory();
    }

    public static EditInfoContentsComparator_Factory create() {
        return a.a;
    }

    public static EditInfoContentsComparator newInstance() {
        return new EditInfoContentsComparator();
    }

    @Override // javax.inject.Provider
    public EditInfoContentsComparator get() {
        return newInstance();
    }
}
