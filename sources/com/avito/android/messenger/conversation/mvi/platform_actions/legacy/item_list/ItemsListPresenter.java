package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetClickListener;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.messenger.context_actions.ItemsRequest;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\u00020\u0004:\u0001\u000eJ\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetClickListener;", "", "handleRetryClick", "()V", "handleCloseAction", "Landroidx/lifecycle/LiveData;", "", "getOpenItemStream", "()Landroidx/lifecycle/LiveData;", "openItemStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ItemsListPresenter extends LegacyPlatformActionsView.ContentPresenter<State>, MviEntity<State>, ItemsListSnippetClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\t\nR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListView$State;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "getCloseHandler", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "closeHandler", "Empty", "Visible", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Visible;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State implements LegacyPlatformActionsPresenter.ContentData, ItemsListView.State {
        @Nullable
        public final ContextActionHandler.MethodCall a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData$Unsupported;", "", "showConnectionErrorIndicator", "Z", "getShowConnectionErrorIndicator", "()Z", "showProgress", "getShowProgress", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetData;", "c", "Lcom/avito/konveyor/data_source/ListDataSource;", "getItemsDataSource", "()Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDataSource", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "closeHandler", "<init>", "(Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State implements LegacyPlatformActionsPresenter.ContentData.Unsupported {
            @NotNull
            public final String b = "";
            @NotNull
            public final ListDataSource<ItemsListSnippetData> c = new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList());

            public Empty(@Nullable ContextActionHandler.MethodCall methodCall) {
                super(methodCall, null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            public boolean getShowConnectionErrorIndicator() {
                return false;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            public boolean getShowProgress() {
                return false;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            @NotNull
            public ListDataSource<ItemsListSnippetData> getItemsDataSource() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            @NotNull
            public String getTitle() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b0\u00101JP\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0011¨\u00062"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Visible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "", "channelId", "", "title", "Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", PlatformActions.ItemsList.ITEMS_REQUEST, "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetData;", "itemsState", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "closeHandler", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;Lcom/avito/android/messenger/channels/mvi/common/Loading;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Visible;", "toString", "()Ljava/lang/String;", "", "c", "Z", "getShowProgress", "()Z", "showProgress", g.a, "Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "getItemsRequest", "()Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "h", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "getItemsState", "()Lcom/avito/android/messenger/channels/mvi/common/Loading;", "Lcom/avito/konveyor/data_source/ListDataSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/data_source/ListDataSource;", "getItemsDataSource", "()Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDataSource", "d", "getShowConnectionErrorIndicator", "showConnectionErrorIndicator", "f", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "e", "Ljava/lang/String;", "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;Lcom/avito/android/messenger/channels/mvi/common/Loading;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Visible extends State {
            @NotNull
            public final ListDataSource<ItemsListSnippetData> b;
            public final boolean c;
            public final boolean d;
            @NotNull
            public final String e;
            @NotNull
            public final CharSequence f;
            @NotNull
            public final ItemsRequest g;
            @NotNull
            public final Loading<List<ItemsListSnippetData>> h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Visible(@NotNull String str, @NotNull CharSequence charSequence, @NotNull ItemsRequest itemsRequest, @NotNull Loading<List<ItemsListSnippetData>> loading, @Nullable ContextActionHandler.MethodCall methodCall) {
                super(methodCall, null);
                ListDataSource<ItemsListSnippetData> listDataSource;
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(charSequence, "title");
                Intrinsics.checkNotNullParameter(itemsRequest, PlatformActions.ItemsList.ITEMS_REQUEST);
                Intrinsics.checkNotNullParameter(loading, "itemsState");
                this.e = str;
                this.f = charSequence;
                this.g = itemsRequest;
                this.h = loading;
                if (loading instanceof Loading.Empty) {
                    listDataSource = new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList());
                } else if (loading instanceof Loading.InProgress) {
                    listDataSource = new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList());
                } else if (loading instanceof Loading.Success) {
                    listDataSource = new ListDataSource<>((List) ((Loading.Success) loading).getValue());
                } else if (loading instanceof Loading.Error) {
                    listDataSource = new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                this.b = listDataSource;
                this.c = loading instanceof Loading.InProgress;
                this.d = loading instanceof Loading.Error;
            }

            public static /* synthetic */ Visible copy$default(Visible visible, String str, CharSequence charSequence, ItemsRequest itemsRequest, Loading loading, ContextActionHandler.MethodCall methodCall, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = visible.getChannelId();
                }
                if ((i & 2) != 0) {
                    charSequence = visible.getTitle();
                }
                if ((i & 4) != 0) {
                    itemsRequest = visible.getItemsRequest();
                }
                if ((i & 8) != 0) {
                    loading = visible.getItemsState();
                }
                if ((i & 16) != 0) {
                    methodCall = visible.getCloseHandler();
                }
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(charSequence, "title");
                Intrinsics.checkNotNullParameter(itemsRequest, PlatformActions.ItemsList.ITEMS_REQUEST);
                Intrinsics.checkNotNullParameter(loading, "itemsState");
                return new Visible(str, charSequence, itemsRequest, loading, methodCall);
            }

            @NotNull
            public final Visible copy(@NotNull String str, @NotNull CharSequence charSequence, @NotNull ItemsRequest itemsRequest, @NotNull Loading<List<ItemsListSnippetData>> loading, @Nullable ContextActionHandler.MethodCall methodCall) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(charSequence, "title");
                Intrinsics.checkNotNullParameter(itemsRequest, PlatformActions.ItemsList.ITEMS_REQUEST);
                Intrinsics.checkNotNullParameter(loading, "itemsState");
                return new Visible(str, charSequence, itemsRequest, loading, methodCall);
            }

            @NotNull
            public final String getChannelId() {
                return this.e;
            }

            @NotNull
            public final ItemsRequest getItemsRequest() {
                return this.g;
            }

            @NotNull
            public final Loading<List<ItemsListSnippetData>> getItemsState() {
                return this.h;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            public boolean getShowConnectionErrorIndicator() {
                return this.d;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            public boolean getShowProgress() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            @NotNull
            public CharSequence getTitle() {
                return this.f;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Visible(\n                    |channelId=");
                L.append(this.e);
                L.append(",\n                    |title=");
                L.append(getTitle());
                L.append(", \n                    |itemsRequest=");
                L.append(this.g);
                L.append(", \n                    |itemsState=");
                L.append(this.h);
                L.append(", \n                    |closeHandler=");
                L.append(getCloseHandler());
                L.append(",\n                    | \n                    |itemsDataSource=");
                L.append(getItemsDataSource());
                L.append(", \n                    |showProgress=");
                L.append(getShowProgress());
                L.append(", \n                    |showConnectionErrorIndicator=");
                L.append(getShowConnectionErrorIndicator());
                L.append(')');
                return f.trimMargin$default(L.toString(), null, 1, null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListView.State
            @NotNull
            public ListDataSource<ItemsListSnippetData> getItemsDataSource() {
                return this.b;
            }
        }

        public State(ContextActionHandler.MethodCall methodCall, j jVar) {
            this.a = methodCall;
        }

        @Nullable
        public final ContextActionHandler.MethodCall getCloseHandler() {
            return this.a;
        }
    }

    @NotNull
    LiveData<String> getOpenItemStream();

    void handleCloseAction();

    void handleRetryClick();
}
