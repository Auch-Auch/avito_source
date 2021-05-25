package com.avito.android.social.di;

import android.content.Context;
import android.os.Bundle;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.AppleSignInManagerImpl_Factory;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.EsiaSignInManagerImpl_Factory;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl_Factory;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.GoogleSocialManagerImpl;
import com.avito.android.social.GoogleSocialManagerImpl_Factory;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl_Factory;
import com.avito.android.social.SocialActivity;
import com.avito.android.social.SocialActivityPresenter;
import com.avito.android.social.SocialActivity_MembersInjector;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManagerImpl_Factory;
import com.avito.android.social.di.SocialActivityComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerSocialActivityComponent implements SocialActivityComponent {
    public Provider<FacebookSocialManager> a = SingleCheck.provider(FacebookSocialManagerImpl_Factory.create());
    public Provider<Context> b;
    public Provider<OdnoklassnikiSocialManagerImpl> c;
    public Provider<OdnoklassnikiSocialManager> d;
    public Provider<VkontakteSocialManagerImpl> e;
    public Provider<VkontakteSocialManager> f;
    public Provider<GoogleSocialManagerImpl> g;
    public Provider<GoogleSocialManager> h;
    public Provider<AppleSignInManager> i;
    public Provider<EsiaSignInManager> j;
    public Provider<Bundle> k;
    public Provider<SocialActivityPresenter> l;

    public static final class b implements SocialActivityComponent.Builder {
        public SocialActivityDependencies a;
        public Bundle b;

        public b(a aVar) {
        }

        @Override // com.avito.android.social.di.SocialActivityComponent.Builder
        public SocialActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SocialActivityDependencies.class);
            return new DaggerSocialActivityComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.social.di.SocialActivityComponent.Builder
        public SocialActivityComponent.Builder dependencies(SocialActivityDependencies socialActivityDependencies) {
            this.a = (SocialActivityDependencies) Preconditions.checkNotNull(socialActivityDependencies);
            return this;
        }

        @Override // com.avito.android.social.di.SocialActivityComponent.Builder
        public SocialActivityComponent.Builder with(Bundle bundle) {
            this.b = bundle;
            return this;
        }
    }

    public static class c implements Provider<Context> {
        public final SocialActivityDependencies a;

        public c(SocialActivityDependencies socialActivityDependencies) {
            this.a = socialActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public DaggerSocialActivityComponent(SocialActivityDependencies socialActivityDependencies, Bundle bundle, a aVar) {
        c cVar = new c(socialActivityDependencies);
        this.b = cVar;
        OdnoklassnikiSocialManagerImpl_Factory create = OdnoklassnikiSocialManagerImpl_Factory.create(cVar);
        this.c = create;
        this.d = SingleCheck.provider(create);
        VkontakteSocialManagerImpl_Factory create2 = VkontakteSocialManagerImpl_Factory.create(this.b);
        this.e = create2;
        this.f = SingleCheck.provider(create2);
        GoogleSocialManagerImpl_Factory create3 = GoogleSocialManagerImpl_Factory.create(this.b);
        this.g = create3;
        this.h = SingleCheck.provider(create3);
        this.i = SingleCheck.provider(AppleSignInManagerImpl_Factory.create());
        this.j = SingleCheck.provider(EsiaSignInManagerImpl_Factory.create());
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.k = createNullable;
        this.l = DoubleCheck.provider(SocialActivityModule_ProvideSocialActivityPresenterFactory.create(this.a, this.d, this.f, this.h, this.i, this.j, createNullable));
    }

    public static SocialActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.social.di.SocialActivityComponent
    public void inject(SocialActivity socialActivity) {
        SocialActivity_MembersInjector.injectPresenter(socialActivity, this.l.get());
    }
}
