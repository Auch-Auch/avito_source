package com.avito.android.publish.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.publish.new_advert.AddFragmentData;
import com.avito.android.publish.new_advert.NewAdvertFragment;
import com.avito.android.publish.start_publish.StartPublishFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/di/PublishTabFragmentFactoryModule;", "", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "provideNavigationTabFragmentFactories", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Ljava/util/Set;", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "", "calledFrom", "Lcom/avito/android/ui/fragments/TabBaseFragment;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;Ljava/lang/String;)Lcom/avito/android/ui/fragments/TabBaseFragment;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishTabFragmentFactoryModule {
    @NotNull
    public static final PublishTabFragmentFactoryModule INSTANCE = new PublishTabFragmentFactoryModule();

    public static final class a extends Lambda implements Function1<NavigationTab.ADD, TabBaseFragment> {
        public final /* synthetic */ AbTestsConfigProvider a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbTestsConfigProvider abTestsConfigProvider) {
            super(1);
            this.a = abTestsConfigProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TabBaseFragment invoke(NavigationTab.ADD add) {
            Intrinsics.checkNotNullParameter(add, "it");
            return PublishTabFragmentFactoryModule.INSTANCE.a(this.a, null);
        }
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return x.setOf(new DataTabFragmentFactory(abTestsConfigProvider) { // from class: com.avito.android.publish.di.PublishTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = AddFragmentData.class;
            public final /* synthetic */ AbTestsConfigProvider b;

            {
                this.b = r1;
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return PublishTabFragmentFactoryModule.access$createStartPublishFragment(PublishTabFragmentFactoryModule.INSTANCE, this.b, ((AddFragmentData) data).getCalledFrom());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        });
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return x.setOf(NavigationTabFragmentFactory.Companion.create(NavigationTab.ADD.INSTANCE, new a(abTestsConfigProvider)));
    }

    public final TabBaseFragment a(AbTestsConfigProvider abTestsConfigProvider, String str) {
        abTestsConfigProvider.draftsOnStartPublishSheet().expose();
        if (abTestsConfigProvider.draftsOnStartPublishSheet().getTestGroup().isTest()) {
            return StartPublishFragment.Companion.createFragment(str);
        }
        return NewAdvertFragment.Companion.createFragment(str);
    }
}
