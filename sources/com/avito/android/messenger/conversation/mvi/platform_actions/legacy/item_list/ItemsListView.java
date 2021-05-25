package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetData;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ItemsListView extends LegacyPlatformActionsView.ContentView<ItemsListPresenter.State, ItemsListPresenter> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListView$State;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetData;", "getItemsDataSource", "()Lcom/avito/konveyor/data_source/DataSource;", "itemsDataSource", "", "getShowProgress", "()Z", "showProgress", "", "getTitle", "()Ljava/lang/CharSequence;", "title", "getShowConnectionErrorIndicator", "showConnectionErrorIndicator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface State {
        @NotNull
        DataSource<ItemsListSnippetData> getItemsDataSource();

        boolean getShowConnectionErrorIndicator();

        boolean getShowProgress();

        @NotNull
        CharSequence getTitle();
    }
}
