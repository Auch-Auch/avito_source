package com.avito.android.user_adverts.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragmentData;
import com.avito.android.user_adverts.root_screen.UserAdvertsFragmentData;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
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
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsTabFragmentFactoryModule;", "", "", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "provideProfileNavigationTabFragmentFactories", "()Ljava/util/Set;", "provideUserAdvertsNavigationTabFragmentFactories", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertsTabFragmentFactoryModule {
    @NotNull
    public static final UserAdvertsTabFragmentFactoryModule INSTANCE = new UserAdvertsTabFragmentFactoryModule();

    public static final class a extends Lambda implements Function1<NavigationTab.PROFILE, TabBaseFragment> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TabBaseFragment invoke(NavigationTab.PROFILE profile) {
            Intrinsics.checkNotNullParameter(profile, "it");
            return UserAdvertsHostFragment.Companion.newInstance$default(UserAdvertsHostFragment.Companion, null, null, false, 7, null);
        }
    }

    public static final class b extends Lambda implements Function1<NavigationTab.USER_ADVERTS, TabBaseFragment> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TabBaseFragment invoke(NavigationTab.USER_ADVERTS user_adverts) {
            Intrinsics.checkNotNullParameter(user_adverts, "it");
            return UserAdvertsHostFragment.Companion.newInstance$default(UserAdvertsHostFragment.Companion, null, null, false, 7, null);
        }
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return y.setOf((Object[]) new DataTabFragmentFactory[]{new DataTabFragmentFactory() { // from class: com.avito.android.user_adverts.di.UserAdvertsTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = UserAdvertsFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                UserAdvertsFragmentData userAdvertsFragmentData = (UserAdvertsFragmentData) data;
                return UserAdvertsHostFragment.Companion.newInstance(userAdvertsFragmentData.getShortcut(), userAdvertsFragmentData.getAdvertAction(), userAdvertsFragmentData.getOpenPublish());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.user_adverts.di.UserAdvertsTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$2
            @NotNull
            public final Class<?> a = ProfileItemsSearchFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return ProfileItemsSearchFragment.Companion.newInstance(((ProfileItemsSearchFragmentData) data).getShortcut());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }});
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<NavigationTabFragmentFactory> provideProfileNavigationTabFragmentFactories() {
        return x.setOf(NavigationTabFragmentFactory.Companion.create(NavigationTab.PROFILE.INSTANCE, a.a));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<NavigationTabFragmentFactory> provideUserAdvertsNavigationTabFragmentFactories() {
        return x.setOf(NavigationTabFragmentFactory.Companion.create(NavigationTab.USER_ADVERTS.INSTANCE, b.a));
    }
}
