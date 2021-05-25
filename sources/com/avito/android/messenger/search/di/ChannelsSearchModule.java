package com.avito.android.messenger.search.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import com.avito.android.messenger.search.ChannelsSearchPresenter;
import com.avito.android.messenger.search.ChannelsSearchPresenterImpl;
import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverter;
import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverterImpl;
import com.avito.android.messenger.search.adapter.channel.ChannelItemBlueprint;
import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter;
import com.avito.android.messenger.search.adapter.pagination.PaginationItemBlueprint;
import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemBlueprint;
import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0019\u001a\u00020\u00182\u0019\u0010\u0017\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015¢\u0006\u0002\b\u00160\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015H\u0007¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\"\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/search/di/ChannelsSearchModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "provideChannelsSearchInteractor$messenger_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "provideChannelsSearchInteractor", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "provideChannelsSearchPresenter$messenger_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "provideChannelsSearchPresenter", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "providePaginationItemBlueprint", "()Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/messenger/search/adapter/channel/ChannelItemPresenter;", "presenter", "provideChannelItemBlueprint", "(Lcom/avito/android/messenger/search/adapter/channel/ChannelItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter;", "provideSupportChannelItemBlueprint", "(Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class ChannelsSearchModule {
    @NotNull
    public static final ChannelsSearchModule INSTANCE = new ChannelsSearchModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/search/di/ChannelsSearchModule$Declarations;", "", "Lcom/avito/android/messenger/search/ChannelsSearchInteractorImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "channelsSearchInteractorViewModel", "(Lcom/avito/android/messenger/search/ChannelsSearchInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;", "channelsSearchPresenterViewModel", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverterImpl;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;", "channelsSearchResultConverter", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverterImpl;)Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProviderImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "messagePreviewProvider", "(Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProviderImpl;)Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "Lcom/avito/android/messenger/search/adapter/channel/ChannelItemPresenter$Listener;", "channelItemPresenterListener", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenter;)Lcom/avito/android/messenger/search/adapter/channel/ChannelItemPresenter$Listener;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter$Listener;", "supportChannelItemPresenterListener", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenter;)Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter$Listener;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        ChannelItemPresenter.Listener channelItemPresenterListener(@NotNull ChannelsSearchPresenter channelsSearchPresenter);

        @Binds
        @NotNull
        @ClassKey(ChannelsSearchInteractorImpl.class)
        @IntoMap
        ViewModel channelsSearchInteractorViewModel(@NotNull ChannelsSearchInteractorImpl channelsSearchInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ChannelsSearchPresenterImpl.class)
        @IntoMap
        ViewModel channelsSearchPresenterViewModel(@NotNull ChannelsSearchPresenterImpl channelsSearchPresenterImpl);

        @Binds
        @NotNull
        ChannelsSearchResultConverter channelsSearchResultConverter(@NotNull ChannelsSearchResultConverterImpl channelsSearchResultConverterImpl);

        @Binds
        @NotNull
        LocalMessagePreviewProvider messagePreviewProvider(@NotNull LocalMessagePreviewProviderImpl localMessagePreviewProviderImpl);

        @Binds
        @NotNull
        SupportChannelItemPresenter.Listener supportChannelItemPresenterListener(@NotNull ChannelsSearchPresenter channelsSearchPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    public static final ItemBlueprint<?, ?> provideChannelItemBlueprint(@NotNull ChannelItemPresenter channelItemPresenter) {
        Intrinsics.checkNotNullParameter(channelItemPresenter, "presenter");
        return new ChannelItemBlueprint(channelItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ChannelsSearchInteractor provideChannelsSearchInteractor$messenger_release(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(ChannelsSearchInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (ChannelsSearchInteractor) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ChannelsSearchPresenter provideChannelsSearchPresenter$messenger_release(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(ChannelsSearchPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (ChannelsSearchPresenter) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Formatter<Throwable> provideErrorFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    public static final ItemBlueprint<?, ?> providePaginationItemBlueprint() {
        return new PaginationItemBlueprint();
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    public static final ItemBlueprint<?, ?> provideSupportChannelItemBlueprint(@NotNull SupportChannelItemPresenter supportChannelItemPresenter) {
        Intrinsics.checkNotNullParameter(supportChannelItemPresenter, "presenter");
        return new SupportChannelItemBlueprint(supportChannelItemPresenter);
    }
}
