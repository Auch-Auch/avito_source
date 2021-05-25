package com.avito.android.messenger.search;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchPresenter;
import com.avito.android.messenger.search.ChannelsSearchView;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.NetworkException;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\b789:;<=>B/\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020/\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0016\u0010\fR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u0006?"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "", "query", "", "force", "", "search", "(Ljava/lang/String;Z)V", "requestNextPage", "()V", "retry", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "item", "", VKApiConst.POSITION, "onItemClick", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;I)V", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;I)V", "onCleared", "Ljava/util/concurrent/atomic/AtomicLong;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/concurrent/atomic/AtomicLong;", AnalyticFieldsName.searchId, "Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "p", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "n", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/Formatter;", "", "r", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter$ChatNavigationData;", "o", "Landroidx/lifecycle/MutableLiveData;", "getChatNavigationStream", "()Landroidx/lifecycle/MutableLiveData;", "chatNavigationStream", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;", VKApiConst.Q, "Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchInteractor;Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/SchedulersFactory;)V", "c", "NewInteractorStateMutator", "d", "RequestNextPageAction", "RetryAction", "SearchAction", "StartPaginationMutator", "StartSearchMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchPresenterImpl extends BaseMviEntityWithMutatorsRelay<ChannelsSearchView.State> implements ChannelsSearchPresenter {
    public final AtomicLong m = new AtomicLong(0);
    public final CompositeDisposable n;
    @NotNull
    public final MutableLiveData<ChannelsSearchPresenter.ChatNavigationData> o;
    public final ChannelsSearchInteractor p;
    public final ChannelsSearchResultConverter q;
    public final Formatter<Throwable> r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$NewInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "c", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewInteractorStateMutator extends Mutator<ChannelsSearchView.State> {
        public final ChannelsSearchInteractor.State c;
        public final /* synthetic */ ChannelsSearchPresenterImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewInteractorStateMutator(@NotNull ChannelsSearchPresenterImpl channelsSearchPresenterImpl, ChannelsSearchInteractor.State state) {
            super("NewInteractorStateMutator");
            Intrinsics.checkNotNullParameter(state, "interactorState");
            this.d = channelsSearchPresenterImpl;
            this.c = state;
        }

        public static final ChannelsSearchView.State.PaginationState access$map(NewInteractorStateMutator newInteractorStateMutator, ChannelsSearchInteractor.State.PaginationState paginationState) {
            Objects.requireNonNull(newInteractorStateMutator);
            if (Intrinsics.areEqual(paginationState, ChannelsSearchInteractor.State.PaginationState.Idle.INSTANCE)) {
                return ChannelsSearchView.State.PaginationState.Idle.INSTANCE;
            }
            if (paginationState instanceof ChannelsSearchInteractor.State.PaginationState.Error) {
                ChannelsSearchInteractor.State.PaginationState.Error error = (ChannelsSearchInteractor.State.PaginationState.Error) paginationState;
                return new ChannelsSearchView.State.PaginationState.Error(newInteractorStateMutator.d.r.format(error.getError()), error.getError());
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public ChannelsSearchView.State invoke(@NotNull ChannelsSearchView.State state) {
            ChannelsSearchView.State.PaginationState paginationState;
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!Intrinsics.areEqual(this.c.getQuery(), state.getQuery())) {
                return state;
            }
            ChannelsSearchInteractor.State state2 = this.c;
            if (state2 instanceof ChannelsSearchInteractor.State.Empty) {
                return ChannelsSearchView.State.Empty.INSTANCE;
            }
            if (state2 instanceof ChannelsSearchInteractor.State.Loaded) {
                ChannelsSearchInteractor.State.Loaded loaded = (ChannelsSearchInteractor.State.Loaded) state2;
                ChannelsSearchResultConverter channelsSearchResultConverter = this.d.q;
                String currentUserId = loaded.getCurrentUserId();
                List<ChannelsSearchInteractor.SearchResults.Result> items = loaded.getResults().getItems();
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (T t : items) {
                    T t2 = t;
                    if (hashSet.add(TuplesKt.to(t2.getChannel().getChannelId(), t2.getMessageId()))) {
                        arrayList.add(t);
                    }
                }
                List<ChannelsSearchListItem> convert = channelsSearchResultConverter.convert(currentUserId, arrayList);
                if (convert.isEmpty()) {
                    return new ChannelsSearchView.State.Loaded.Empty(loaded.getQuery());
                }
                ChannelsSearchView.State.SearchResults searchResults = new ChannelsSearchView.State.SearchResults(loaded.getQuery(), convert, loaded.getResults().getHasMore());
                ChannelsSearchInteractor.State.PaginationState paginationState2 = loaded.getPaginationState();
                if (Intrinsics.areEqual(paginationState2, ChannelsSearchInteractor.State.PaginationState.Idle.INSTANCE)) {
                    paginationState = ChannelsSearchView.State.PaginationState.Idle.INSTANCE;
                } else if (paginationState2 instanceof ChannelsSearchInteractor.State.PaginationState.Error) {
                    ChannelsSearchInteractor.State.PaginationState.Error error = (ChannelsSearchInteractor.State.PaginationState.Error) paginationState2;
                    paginationState = new ChannelsSearchView.State.PaginationState.Error(this.d.r.format(error.getError()), error.getError());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return new ChannelsSearchView.State.Loaded.Results(searchResults, paginationState);
            } else if (state2 instanceof ChannelsSearchInteractor.State.Error) {
                ChannelsSearchInteractor.State.Error error2 = (ChannelsSearchInteractor.State.Error) state2;
                ChannelsSearchView.State.SearchResults results = state.getResults();
                SearchQuery query = error2.getQuery();
                List<ChannelsSearchListItem> items2 = results.getItems();
                ArrayList arrayList2 = new ArrayList();
                for (T t3 : items2) {
                    if (!Intrinsics.areEqual(t3, ChannelsSearchListItem.Pagination.INSTANCE)) {
                        arrayList2.add(t3);
                    }
                }
                return new ChannelsSearchView.State.Error(query, ChannelsSearchView.State.SearchResults.copy$default(results, null, arrayList2, false, 1, null), this.d.r.format(error2.getError()), error2.getError());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$RequestNextPageAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)V", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RequestNextPageAction extends Action<ChannelsSearchView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RequestNextPageAction() {
            super("RequestNextPageAction");
        }

        public void invoke(@NotNull ChannelsSearchView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if ((state instanceof ChannelsSearchView.State.Loaded.Results) && (((ChannelsSearchView.State.Loaded.Results) state).getPaginationState() instanceof ChannelsSearchView.State.PaginationState.InProgress)) {
                ChannelsSearchPresenterImpl.this.p.requestNextPage();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$RetryAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)V", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RetryAction extends Action<ChannelsSearchView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RetryAction() {
            super("RetryAction");
        }

        public void invoke(@NotNull ChannelsSearchView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state instanceof ChannelsSearchView.State.Loaded) {
                if (((ChannelsSearchView.State.Loaded) state).getPaginationState() instanceof ChannelsSearchView.State.PaginationState.Error) {
                    ChannelsSearchPresenterImpl.this.requestNextPage();
                } else {
                    ChannelsSearchPresenterImpl.this.search(state.getQuery().getText(), true);
                }
            } else if (state instanceof ChannelsSearchView.State.Error) {
                ChannelsSearchPresenterImpl.this.search(state.getQuery().getText(), true);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$SearchAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)V", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class SearchAction extends Action<ChannelsSearchView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public SearchAction() {
            super("SearchAction");
        }

        public void invoke(@NotNull ChannelsSearchView.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state instanceof ChannelsSearchView.State.Loading) {
                ChannelsSearchPresenterImpl.this.p.startSearch(state.getQuery());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$StartPaginationMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StartPaginationMutator extends Mutator<ChannelsSearchView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StartPaginationMutator() {
            super("StartPaginationMutator");
        }

        @NotNull
        public ChannelsSearchView.State invoke(@NotNull ChannelsSearchView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof ChannelsSearchView.State.Loaded.Results) || !state.getResults().getHasMorePages()) {
                return state;
            }
            Relay mutatorsRelay = ChannelsSearchPresenterImpl.this.getMutatorsRelay();
            RequestNextPageAction requestNextPageAction = new RequestNextPageAction();
            mutatorsRelay.accept(new MutatorSingle(requestNextPageAction.getName(), new ChannelsSearchPresenterImpl$StartPaginationMutator$invoke$$inlined$plusAssign$1(requestNextPageAction)));
            ChannelsSearchView.State.Loaded.Results results = (ChannelsSearchView.State.Loaded.Results) state;
            ChannelsSearchView.State.SearchResults results2 = results.getResults();
            List<ChannelsSearchListItem> items = results.getResults().getItems();
            ArrayList arrayList = new ArrayList();
            for (T t : items) {
                if (!Intrinsics.areEqual(t, ChannelsSearchListItem.Pagination.INSTANCE)) {
                    arrayList.add(t);
                }
            }
            return results.copy(ChannelsSearchView.State.SearchResults.copy$default(results2, null, CollectionsKt___CollectionsKt.plus((Collection<? extends ChannelsSearchListItem.Pagination>) arrayList, ChannelsSearchListItem.Pagination.INSTANCE), true, 1, null), ChannelsSearchView.State.PaginationState.InProgress.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl$StartSearchMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State;)Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "", "d", "Z", "force", "", "c", "Ljava/lang/String;", "query", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenterImpl;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class StartSearchMutator extends Mutator<ChannelsSearchView.State> {
        public final String c;
        public final boolean d;
        public final /* synthetic */ ChannelsSearchPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartSearchMutator(@NotNull ChannelsSearchPresenterImpl channelsSearchPresenterImpl, String str, boolean z) {
            super("StartSearchMutator(" + str + ", " + z + ')');
            Intrinsics.checkNotNullParameter(str, "query");
            this.e = channelsSearchPresenterImpl;
            this.c = str;
            this.d = z;
        }

        @NotNull
        public ChannelsSearchView.State invoke(@NotNull ChannelsSearchView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String take = StringsKt___StringsKt.take(this.c, 255);
            Objects.requireNonNull(take, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.trim(take).toString();
            if (!this.d && !(!Intrinsics.areEqual(state.getQuery().getText(), obj))) {
                return state;
            }
            int length = this.c.length();
            if (length == 0) {
                return ChannelsSearchView.State.Empty.INSTANCE;
            }
            if (1 <= length && 2 > length) {
                return new ChannelsSearchView.State.ShortQuery(new SearchQuery(0, this.c));
            }
            SearchQuery searchQuery = new SearchQuery(this.e.m.incrementAndGet(), this.c);
            Relay mutatorsRelay = this.e.getMutatorsRelay();
            SearchAction searchAction = new SearchAction();
            mutatorsRelay.accept(new MutatorSingle(searchAction.getName(), new ChannelsSearchPresenterImpl$StartSearchMutator$invoke$$inlined$plusAssign$1(searchAction)));
            return new ChannelsSearchView.State.Loading(searchQuery, state.getResults());
        }
    }

    public static final class a<T> implements Consumer<ChannelsSearchInteractor.State> {
        public final /* synthetic */ ChannelsSearchPresenterImpl a;

        public a(ChannelsSearchPresenterImpl channelsSearchPresenterImpl) {
            this.a = channelsSearchPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChannelsSearchInteractor.State state) {
            ChannelsSearchInteractor.State state2 = state;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            ChannelsSearchPresenterImpl channelsSearchPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(state2, "interactorState");
            NewInteractorStateMutator newInteractorStateMutator = new NewInteractorStateMutator(channelsSearchPresenterImpl, state2);
            mutatorsRelay.accept(new MutatorSingle(newInteractorStateMutator.getName(), new ChannelsSearchPresenterImpl$1$$special$$inlined$plusAssign$1(newInteractorStateMutator)));
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ ChannelsSearchPresenterImpl a;

        public b(ChannelsSearchPresenterImpl channelsSearchPresenterImpl) {
            this.a = channelsSearchPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            d dVar = new d();
            mutatorsRelay.accept(new MutatorSingle(dVar.getName(), new ChannelsSearchPresenterImpl$2$$special$$inlined$plusAssign$1(dVar)));
        }
    }

    public final class c extends Action<ChannelsSearchView.State> {
        public final String c;
        public final String d;
        public final int e;
        public final /* synthetic */ ChannelsSearchPresenterImpl f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull ChannelsSearchPresenterImpl channelsSearchPresenterImpl, @Nullable String str, String str2, int i) {
            super(a2.b.a.a.a.i(a2.b.a.a.a.W("ItemClickAction(channelId=", str, " messageId=", str2, " position="), i, ')'));
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.f = channelsSearchPresenterImpl;
            this.c = str;
            this.d = str2;
            this.e = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Action
        public void invoke(ChannelsSearchView.State state) {
            ChannelsSearchView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "curState");
            this.f.getChatNavigationStream().postValue(new ChannelsSearchPresenter.ChatNavigationData(this.c, this.e, this.d, state2.getResults().getQuery().getText()));
        }
    }

    public final class d extends Action<ChannelsSearchView.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
            super("ReconnectAction");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Action
        public void invoke(ChannelsSearchView.State state) {
            ChannelsSearchView.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "curState");
            if (state2 instanceof ChannelsSearchView.State.Loaded) {
                ChannelsSearchView.State.PaginationState paginationState = ((ChannelsSearchView.State.Loaded) state2).getPaginationState();
                if ((paginationState instanceof ChannelsSearchView.State.PaginationState.Error) && (((ChannelsSearchView.State.PaginationState.Error) paginationState).getError() instanceof NetworkException)) {
                    ChannelsSearchPresenterImpl.this.retry();
                }
            } else if ((state2 instanceof ChannelsSearchView.State.Error) && (((ChannelsSearchView.State.Error) state2).getError() instanceof NetworkException)) {
                ChannelsSearchPresenterImpl.this.retry();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsSearchPresenterImpl(@NotNull ChannelsSearchInteractor channelsSearchInteractor, @NotNull ChannelsSearchResultConverter channelsSearchResultConverter, @NotNull Formatter<Throwable> formatter, @NotNull SchedulersFactory schedulersFactory) {
        super("ChannelsSearchPresenter", ChannelsSearchView.State.Empty.INSTANCE, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(channelsSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(channelsSearchResultConverter, "converter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.p = channelsSearchInteractor;
        this.q = channelsSearchResultConverter;
        this.r = formatter;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.n = compositeDisposable;
        this.o = new SingleLiveEvent();
        Disposable subscribe = channelsSearchInteractor.getStateObservable().observeOn(schedulersFactory.computation()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.stateObservab…utator(interactorState) }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = channelsSearchInteractor.getReconnectsStream().observeOn(schedulersFactory.computation()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.reconnectsStr…ay += ReconnectAction() }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.n.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter.Listener
    public void onItemClick(@NotNull ChannelsSearchListItem.Channel channel, int i) {
        Intrinsics.checkNotNullParameter(channel, "item");
        Relay mutatorsRelay = getMutatorsRelay();
        c cVar = new c(this, channel.getChannelId(), channel.getMessageId(), i);
        mutatorsRelay.accept(new MutatorSingle(cVar.getName(), new ChannelsSearchPresenterImpl$onItemClick$$inlined$plusAssign$1(cVar)));
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchPresenter
    public void requestNextPage() {
        Relay mutatorsRelay = getMutatorsRelay();
        StartPaginationMutator startPaginationMutator = new StartPaginationMutator();
        mutatorsRelay.accept(new MutatorSingle(startPaginationMutator.getName(), new ChannelsSearchPresenterImpl$requestNextPage$$inlined$plusAssign$1(startPaginationMutator)));
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchPresenter
    public void retry() {
        Relay mutatorsRelay = getMutatorsRelay();
        RetryAction retryAction = new RetryAction();
        mutatorsRelay.accept(new MutatorSingle(retryAction.getName(), new ChannelsSearchPresenterImpl$retry$$inlined$plusAssign$1(retryAction)));
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchPresenter
    public void search(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "query");
        Relay mutatorsRelay = getMutatorsRelay();
        StartSearchMutator startSearchMutator = new StartSearchMutator(this, str, z);
        mutatorsRelay.accept(new MutatorSingle(startSearchMutator.getName(), new ChannelsSearchPresenterImpl$search$$inlined$plusAssign$1(startSearchMutator)));
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchPresenter
    @NotNull
    public MutableLiveData<ChannelsSearchPresenter.ChatNavigationData> getChatNavigationStream() {
        return this.o;
    }

    @Override // com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter.Listener
    public void onItemClick(@NotNull ChannelsSearchListItem.SupportChannel supportChannel, int i) {
        Intrinsics.checkNotNullParameter(supportChannel, "item");
        Relay mutatorsRelay = getMutatorsRelay();
        c cVar = new c(this, supportChannel.getChannelId(), supportChannel.getMessageId(), i);
        mutatorsRelay.accept(new MutatorSingle(cVar.getName(), new ChannelsSearchPresenterImpl$onItemClick$$inlined$plusAssign$2(cVar)));
    }
}
