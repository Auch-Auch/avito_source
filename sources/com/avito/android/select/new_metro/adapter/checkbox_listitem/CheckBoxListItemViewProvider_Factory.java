package com.avito.android.select.new_metro.adapter.checkbox_listitem;

import dagger.internal.Factory;
public final class CheckBoxListItemViewProvider_Factory implements Factory<CheckBoxListItemViewProvider> {

    public static final class a {
        public static final CheckBoxListItemViewProvider_Factory a = new CheckBoxListItemViewProvider_Factory();
    }

    public static CheckBoxListItemViewProvider_Factory create() {
        return a.a;
    }

    public static CheckBoxListItemViewProvider newInstance() {
        return new CheckBoxListItemViewProvider();
    }

    @Override // javax.inject.Provider
    public CheckBoxListItemViewProvider get() {
        return newInstance();
    }
}
