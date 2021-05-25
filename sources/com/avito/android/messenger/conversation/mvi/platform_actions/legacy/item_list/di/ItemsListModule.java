package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenterImpl;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetBlueprint;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/di/ItemsListModule;", "", "Lcom/avito/android/messenger/conversation/ChannelFragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "provideItemsListPresenter", "(Lcom/avito/android/messenger/conversation/ChannelFragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "Ldagger/Lazy;", "presenter", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetPresenter;", "provideItemsListSnippetPresenter", "(Ldagger/Lazy;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetBlueprint;", "provideItemsListSnippetBlueprint", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetPresenter;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetBlueprint;", "blueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ItemsListModule {
    @NotNull
    public static final ItemsListModule INSTANCE = new ItemsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/di/ItemsListModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractorImpl;", "impl", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "bindItemsListInteractor", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;", "Landroidx/lifecycle/ViewModel;", "bindItemsListPresenterViewModel", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        ItemsListInteractor bindItemsListInteractor(@NotNull ItemsListInteractorImpl itemsListInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(ItemsListPresenterImpl.class)
        @IntoMap
        ViewModel bindItemsListPresenterViewModel(@NotNull ItemsListPresenterImpl itemsListPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ItemsList
    public static final AdapterPresenter provideAdapterPresenter(@ItemsList @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ItemsList
    public static final ItemBinder provideItemBinder(@NotNull ItemsListSnippetBlueprint itemsListSnippetBlueprint) {
        Intrinsics.checkNotNullParameter(itemsListSnippetBlueprint, "blueprint");
        return new ItemBinder.Builder().registerItem(itemsListSnippetBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ItemsListPresenter provideItemsListPresenter(@NotNull ChannelFragment channelFragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(channelFragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(channelFragment, viewModelFactory).get(ItemsListPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (ItemsListPresenter) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ItemsListSnippetBlueprint provideItemsListSnippetBlueprint(@NotNull ItemsListSnippetPresenter itemsListSnippetPresenter) {
        Intrinsics.checkNotNullParameter(itemsListSnippetPresenter, "presenter");
        return new ItemsListSnippetBlueprint(itemsListSnippetPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ItemsListSnippetPresenter provideItemsListSnippetPresenter(@NotNull Lazy<ItemsListPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "presenter");
        return new ItemsListSnippetPresenter(lazy);
    }
}
