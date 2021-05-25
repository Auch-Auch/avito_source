package com.avito.android.messenger.channels.mvi.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.messenger.channels.ChannelsFragmentData;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import com.avito.android.messenger.conversation.ChannelActivityFragment;
import com.avito.android.messenger.conversation.ChannelActivityFragmentData;
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
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/MessengerTabFragmentFactoryModule;", "", "", "Lcom/avito/android/bottom_navigation/NavigationTabFragmentFactory;", "provideNavigationTabFragmentFactories", "()Ljava/util/Set;", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class MessengerTabFragmentFactoryModule {
    @NotNull
    public static final MessengerTabFragmentFactoryModule INSTANCE = new MessengerTabFragmentFactoryModule();

    public static final class a extends Lambda implements Function1<NavigationTab.MESSAGE, TabBaseFragment> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TabBaseFragment invoke(NavigationTab.MESSAGE message) {
            Intrinsics.checkNotNullParameter(message, "it");
            return new ChannelsFragment();
        }
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return y.setOf((Object[]) new DataTabFragmentFactory[]{new DataTabFragmentFactory() { // from class: com.avito.android.messenger.channels.mvi.di.MessengerTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = ChannelsFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ChannelsFragmentData channelsFragmentData = (ChannelsFragmentData) data;
                return new ChannelsFragment();
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.messenger.channels.mvi.di.MessengerTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$2
            @NotNull
            public final Class<?> a = ChannelActivityFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return ChannelActivityFragment.Companion.newInstance(((ChannelActivityFragmentData) data).getArguments());
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
    public static final Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories() {
        return x.setOf(NavigationTabFragmentFactory.Companion.create(NavigationTab.MESSAGE.INSTANCE, a.a));
    }
}
