package com.avito.android.profile.di;

import com.avito.android.recycler.data_aware.ContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class EditProfileModule_ProvideContentsComparatorFactory implements Factory<ContentsComparator> {

    public static final class a {
        public static final EditProfileModule_ProvideContentsComparatorFactory a = new EditProfileModule_ProvideContentsComparatorFactory();
    }

    public static EditProfileModule_ProvideContentsComparatorFactory create() {
        return a.a;
    }

    public static ContentsComparator provideContentsComparator() {
        return (ContentsComparator) Preconditions.checkNotNullFromProvides(EditProfileModule.provideContentsComparator());
    }

    @Override // javax.inject.Provider
    public ContentsComparator get() {
        return provideContentsComparator();
    }
}
