package com.avito.android.section.expand_sections_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ComplementaryExpandSectionsButtonBlueprint_Factory implements Factory<ComplementaryExpandSectionsButtonBlueprint> {
    public final Provider<ExpandSectionsButtonPresenter> a;

    public ComplementaryExpandSectionsButtonBlueprint_Factory(Provider<ExpandSectionsButtonPresenter> provider) {
        this.a = provider;
    }

    public static ComplementaryExpandSectionsButtonBlueprint_Factory create(Provider<ExpandSectionsButtonPresenter> provider) {
        return new ComplementaryExpandSectionsButtonBlueprint_Factory(provider);
    }

    public static ComplementaryExpandSectionsButtonBlueprint newInstance(ExpandSectionsButtonPresenter expandSectionsButtonPresenter) {
        return new ComplementaryExpandSectionsButtonBlueprint(expandSectionsButtonPresenter);
    }

    @Override // javax.inject.Provider
    public ComplementaryExpandSectionsButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
