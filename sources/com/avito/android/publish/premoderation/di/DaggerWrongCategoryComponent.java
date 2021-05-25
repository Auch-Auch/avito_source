package com.avito.android.publish.premoderation.di;

import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.WrongCategoryFragment;
import com.avito.android.publish.premoderation.WrongCategoryFragment_MembersInjector;
import com.avito.android.publish.premoderation.WrongCategoryPresenter;
import com.avito.android.publish.premoderation.di.WrongCategoryComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerWrongCategoryComponent implements WrongCategoryComponent {
    public Provider<WrongCategoryPresenter> a;

    public static final class b implements WrongCategoryComponent.Builder {
        public PublishDependencies a;
        public WrongCategoryModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.premoderation.di.WrongCategoryComponent.Builder
        public WrongCategoryComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, WrongCategoryModule.class);
            return new DaggerWrongCategoryComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.premoderation.di.WrongCategoryComponent.Builder
        public WrongCategoryComponent.Builder publishDependencies(PublishDependencies publishDependencies) {
            this.a = (PublishDependencies) Preconditions.checkNotNull(publishDependencies);
            return this;
        }

        @Override // com.avito.android.publish.premoderation.di.WrongCategoryComponent.Builder
        public WrongCategoryComponent.Builder wrongCategoryModule(WrongCategoryModule wrongCategoryModule) {
            this.b = (WrongCategoryModule) Preconditions.checkNotNull(wrongCategoryModule);
            return this;
        }
    }

    public DaggerWrongCategoryComponent(WrongCategoryModule wrongCategoryModule, PublishDependencies publishDependencies, a aVar) {
        this.a = DoubleCheck.provider(WrongCategoryModule_ProviderWrongCategoryPresenterFactory.create(wrongCategoryModule));
    }

    public static WrongCategoryComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.premoderation.di.WrongCategoryComponent
    public void inject(WrongCategoryFragment wrongCategoryFragment) {
        WrongCategoryFragment_MembersInjector.injectPresenter(wrongCategoryFragment, this.a.get());
    }
}
