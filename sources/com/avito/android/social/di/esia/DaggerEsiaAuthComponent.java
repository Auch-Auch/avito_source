package com.avito.android.social.di.esia;

import com.avito.android.Features;
import com.avito.android.social.di.esia.EsiaAuthComponent;
import com.avito.android.social.esia.EsiaAuthFragment;
import com.avito.android.social.esia.EsiaAuthFragment_MembersInjector;
import com.avito.android.social.esia.EsiaAuthPresenterImpl;
import dagger.internal.Preconditions;
public final class DaggerEsiaAuthComponent implements EsiaAuthComponent {
    public final EsiaAuthDependencies a;

    public static final class b implements EsiaAuthComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.social.di.esia.EsiaAuthComponent.Factory
        public EsiaAuthComponent create(EsiaAuthDependencies esiaAuthDependencies) {
            Preconditions.checkNotNull(esiaAuthDependencies);
            return new DaggerEsiaAuthComponent(esiaAuthDependencies, null);
        }
    }

    public DaggerEsiaAuthComponent(EsiaAuthDependencies esiaAuthDependencies, a aVar) {
        this.a = esiaAuthDependencies;
    }

    public static EsiaAuthComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.social.di.esia.EsiaAuthComponent
    public void inject(EsiaAuthFragment esiaAuthFragment) {
        EsiaAuthFragment_MembersInjector.injectPresenter(esiaAuthFragment, new EsiaAuthPresenterImpl((Features) Preconditions.checkNotNullFromComponent(this.a.features())));
    }
}
