package com.avito.android.advert_core.dialog.di;

import com.avito.android.advert_core.dialog.DialogDeepLinkActivity;
import com.avito.android.advert_core.dialog.DialogDeepLinkActivity_MembersInjector;
import com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Preconditions;
public final class DaggerDialogDeepLinkActivityComponent implements DialogDeepLinkActivityComponent {
    public final DialogDeepLinkActivityDependencies a;

    public static final class b implements DialogDeepLinkActivityComponent.Builder {
        public DialogDeepLinkActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityComponent.Builder
        public DialogDeepLinkActivityComponent.Builder bindDependencies(DialogDeepLinkActivityDependencies dialogDeepLinkActivityDependencies) {
            this.a = (DialogDeepLinkActivityDependencies) Preconditions.checkNotNull(dialogDeepLinkActivityDependencies);
            return this;
        }

        @Override // com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityComponent.Builder
        public DialogDeepLinkActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DialogDeepLinkActivityDependencies.class);
            return new DaggerDialogDeepLinkActivityComponent(this.a, null);
        }
    }

    public DaggerDialogDeepLinkActivityComponent(DialogDeepLinkActivityDependencies dialogDeepLinkActivityDependencies, a aVar) {
        this.a = dialogDeepLinkActivityDependencies;
    }

    public static DialogDeepLinkActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityComponent
    public void inject(DialogDeepLinkActivity dialogDeepLinkActivity) {
        DialogDeepLinkActivity_MembersInjector.injectIntentFactory(dialogDeepLinkActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
