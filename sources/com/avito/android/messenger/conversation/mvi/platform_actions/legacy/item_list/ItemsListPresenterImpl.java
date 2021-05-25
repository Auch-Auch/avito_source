package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import androidx.lifecycle.MutableLiveData;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessengerRecommendationItemClickEvent;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.messenger.context_actions.ItemsRequest;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.context_actions.RecommendationItem;
import com.avito.android.remote.model.messenger.context_actions.RecommendationsResponse;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0007%&'()*+B)\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0006R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "", "onCleared", "()V", "", "itemId", "handleItemClick", "(Ljava/lang/String;)V", "handleRetryClick", "handleCloseAction", "Landroidx/lifecycle/MutableLiveData;", "p", "Landroidx/lifecycle/MutableLiveData;", "getOpenItemStream", "()Landroidx/lifecycle/MutableLiveData;", "openItemStream", "Lcom/avito/android/analytics/Analytics;", "s", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "r", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "parent", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;Lcom/avito/android/analytics/Analytics;)V", "CancelChecker", "CloseComposite", "EmptyMutator", "ItemClickedAction", "LoadingResultMutator", "NewChannelDataComposite", "RetryComposite", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsListPresenterImpl extends BaseMviEntityWithReducerQueue<ItemsListPresenter.State> implements ItemsListPresenter {
    @NotNull
    public final MutableLiveData<String> p = new SingleLiveEvent();
    public final CompositeDisposable q;
    public final ItemsListInteractor r;
    public final Analytics s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$CancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "aShouldCancelB", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Z", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelChecker implements ShouldCancelChecker<ItemsListPresenter.State> {
        @NotNull
        public static final CancelChecker INSTANCE = new CancelChecker();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<ItemsListPresenter.State> reducible, @NotNull Reducible<ItemsListPresenter.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof EmptyMutator) {
                if (((reducible2 instanceof Mutator) || (reducible2 instanceof MutatorSingle)) && !(reducible2 instanceof ItemClickedAction)) {
                    return true;
                }
            } else if (reducible instanceof NewChannelDataComposite.LoadingInProgressMutator) {
                if (((reducible2 instanceof Mutator) || (reducible2 instanceof MutatorSingle)) && !(reducible2 instanceof ItemClickedAction)) {
                    return true;
                }
            } else if (reducible instanceof RetryComposite.LoadingInProgressMutator) {
                if (reducible2 instanceof LoadingResultMutator) {
                    return true;
                }
            } else if ((reducible instanceof CloseComposite.CallCloseHandlerAction) && (reducible2 instanceof CloseComposite.CallCloseHandlerAction)) {
                return true;
            }
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$CloseComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;)V", "CallCloseHandlerAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class CloseComposite extends CompositeReducible<ItemsListPresenter.State> {
        @NotNull
        public final Function0<List<Reducible<ItemsListPresenter.State>>> d = new a(this);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$CloseComposite$CallCloseHandlerAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$CloseComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class CallCloseHandlerAction extends ActionSingle<ItemsListPresenter.State> {

            public static final class a extends Lambda implements Function1<ItemsListPresenter.State, Single<?>> {
                public final /* synthetic */ CloseComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(CloseComposite closeComposite) {
                    super(1);
                    this.a = closeComposite;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Type inference failed for r3v11. Raw type applied. Possible types: io.reactivex.Single<R>, java.lang.Object, io.reactivex.Single<?> */
                @Override // kotlin.jvm.functions.Function1
                public Single<?> invoke(ItemsListPresenter.State state) {
                    ItemsListPresenter.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    if (state2.getCloseHandler() == null) {
                        return Singles.toSingle(Unit.INSTANCE);
                    }
                    Single single = (Single<R>) ItemsListPresenterImpl.this.r.callApiMethod(state2.getCloseHandler().getMethod(), state2.getCloseHandler().getParams()).subscribeOn(ItemsListPresenterImpl.this.getSchedulers().io()).observeOn(ItemsListPresenterImpl.this.getSchedulers().computation()).map(a2.a.a.o1.d.a0.k.a.f.a.a).doOnError(new a2.a.a.o1.d.a0.k.a.f.b(this)).onErrorReturn(a2.a.a.o1.d.a0.k.a.f.c.a);
                    Intrinsics.checkNotNullExpressionValue(single, "interactor.callApiMethod…  .onErrorReturn { Unit }");
                    return single;
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public CallCloseHandlerAction(CloseComposite closeComposite) {
                super(closeComposite.getName() + ".CallCloseHandlerAction", closeComposite.getParams(), new a(closeComposite));
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ItemsListPresenter.State>>> {
            public final /* synthetic */ CloseComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(CloseComposite closeComposite) {
                super(0);
                this.a = closeComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ItemsListPresenter.State>> invoke() {
                CloseComposite closeComposite = this.a;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new EmptyMutator(ItemsListPresenterImpl.this, closeComposite.getName(), this.a.getParams()), new CallCloseHandlerAction(this.a)});
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public CloseComposite() {
            super(null, null, null, 7, null);
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ItemsListPresenter.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$EmptyMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "oldState", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Empty;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State$Empty;", "", "parentName", "parentParams", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class EmptyMutator extends Mutator<ItemsListPresenter.State> {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ EmptyMutator(ItemsListPresenterImpl itemsListPresenterImpl, String str, String str2, int i, j jVar) {
            this(itemsListPresenterImpl, str, (i & 2) != 0 ? "" : str2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyMutator(@NotNull ItemsListPresenterImpl itemsListPresenterImpl, @NotNull String str, String str2) {
            super(str + ".LoadingResultMutator", str2);
            Intrinsics.checkNotNullParameter(str, "parentName");
            Intrinsics.checkNotNullParameter(str2, "parentParams");
        }

        @NotNull
        public ItemsListPresenter.State.Empty invoke(@NotNull ItemsListPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return new ItemsListPresenter.State.Empty(state.getCloseHandler());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$ItemClickedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;)V", "", "d", "Ljava/lang/String;", "itemId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ItemClickedAction extends Action<ItemsListPresenter.State> {
        public final String d;
        public final /* synthetic */ ItemsListPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemClickedAction(@NotNull ItemsListPresenterImpl itemsListPresenterImpl, String str) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            this.e = itemsListPresenterImpl;
            this.d = str;
        }

        public void invoke(@NotNull ItemsListPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state instanceof ItemsListPresenter.State.Visible) {
                this.e.s.track(new MessengerRecommendationItemClickEvent(((ItemsListPresenter.State.Visible) state).getChannelId(), this.d));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$LoadingResultMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;)Lio/reactivex/Single;", "", "parentName", "parentParams", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class LoadingResultMutator extends MutatorSingle<ItemsListPresenter.State> {
        public final /* synthetic */ ItemsListPresenterImpl d;

        public static final class a<T, R> implements Function<RecommendationsResponse, ItemsListPresenter.State> {
            public final /* synthetic */ LoadingResultMutator a;
            public final /* synthetic */ ItemsListPresenter.State b;

            public a(LoadingResultMutator loadingResultMutator, ItemsListPresenter.State state) {
                this.a = loadingResultMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public ItemsListPresenter.State apply(RecommendationsResponse recommendationsResponse) {
                Loading loading;
                RecommendationsResponse recommendationsResponse2 = recommendationsResponse;
                Intrinsics.checkNotNullParameter(recommendationsResponse2, "<name for destructuring parameter 0>");
                List<RecommendationItem> component1 = recommendationsResponse2.component1();
                if (!component1.isEmpty()) {
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(component1, 10));
                    for (T t : component1) {
                        arrayList.add(new ItemsListSnippetData(t.getId(), t.getTitle(), t.getPrice(), t.getImage(), t.getLocation()));
                    }
                    loading = new Loading.Success(arrayList);
                } else {
                    loading = new Loading.Empty();
                }
                ItemsListPresenter.State.Visible visible = (ItemsListPresenter.State.Visible) this.b;
                return new ItemsListPresenter.State.Visible(visible.getChannelId(), visible.getTitle(), visible.getItemsRequest(), loading, visible.getCloseHandler());
            }
        }

        public static final class b<T, R> implements Function<Throwable, ItemsListPresenter.State> {
            public final /* synthetic */ ItemsListPresenter.State a;

            public b(ItemsListPresenter.State state) {
                this.a = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public ItemsListPresenter.State apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                ItemsListPresenter.State.Visible visible = (ItemsListPresenter.State.Visible) this.a;
                return new ItemsListPresenter.State.Visible(visible.getChannelId(), visible.getTitle(), visible.getItemsRequest(), new Loading.Error(th2), visible.getCloseHandler());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadingResultMutator(@NotNull ItemsListPresenterImpl itemsListPresenterImpl, @NotNull String str, String str2) {
            super(a2.b.a.a.a.c3(str, ".LoadingResultMutator"), str2);
            Intrinsics.checkNotNullParameter(str, "parentName");
            Intrinsics.checkNotNullParameter(str2, "parentParams");
            this.d = itemsListPresenterImpl;
        }

        public static final ItemsListSnippetData access$toItemListSnippetData(LoadingResultMutator loadingResultMutator, RecommendationItem recommendationItem) {
            Objects.requireNonNull(loadingResultMutator);
            return new ItemsListSnippetData(recommendationItem.getId(), recommendationItem.getTitle(), recommendationItem.getPrice(), recommendationItem.getImage(), recommendationItem.getLocation());
        }

        @NotNull
        public Single<ItemsListPresenter.State> invoke(@NotNull ItemsListPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof ItemsListPresenter.State.Visible) {
                ItemsListPresenter.State.Visible visible = (ItemsListPresenter.State.Visible) state;
                if (visible.getItemsState() instanceof Loading.InProgress) {
                    Single<R> onErrorReturn = this.d.r.getItems(visible.getItemsRequest().getMethod(), visible.getItemsRequest().getParams()).map(new a(this, state)).onErrorReturn(new b(state));
                    Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.getItems(\n   …r))\n                    }");
                    return onErrorReturn;
                }
            }
            return Singles.toSingle(state);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoadingResultMutator(ItemsListPresenterImpl itemsListPresenterImpl, String str, String str2, int i, j jVar) {
            this(itemsListPresenterImpl, str, (i & 2) != 0 ? "" : str2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$NewChannelDataComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "e", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "data", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;)V", "LoadingInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelDataComposite extends CompositeReducible<ItemsListPresenter.State> {
        @NotNull
        public final Function0<List<Reducible<ItemsListPresenter.State>>> d = new a(this);
        public final LegacyPlatformActionsPresenter.ChannelData e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$NewChannelDataComposite$LoadingInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "", "channelId", "title", "Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", PlatformActions.ItemsList.ITEMS_REQUEST, "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "closeHandler", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$NewChannelDataComposite;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class LoadingInProgressMutator extends Mutator<ItemsListPresenter.State> {

            public static final class a extends Lambda implements Function1<ItemsListPresenter.State, ItemsListPresenter.State> {
                public final /* synthetic */ String a;
                public final /* synthetic */ String b;
                public final /* synthetic */ ItemsRequest c;
                public final /* synthetic */ ContextActionHandler.MethodCall d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(String str, String str2, ItemsRequest itemsRequest, ContextActionHandler.MethodCall methodCall) {
                    super(1);
                    this.a = str;
                    this.b = str2;
                    this.c = itemsRequest;
                    this.d = methodCall;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public ItemsListPresenter.State invoke(ItemsListPresenter.State state) {
                    Intrinsics.checkNotNullParameter(state, "it");
                    return new ItemsListPresenter.State.Visible(this.a, this.b, this.c, new Loading.InProgress(0, 1, null), this.d);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LoadingInProgressMutator(@NotNull NewChannelDataComposite newChannelDataComposite, @NotNull String str, @NotNull String str2, @Nullable ItemsRequest itemsRequest, ContextActionHandler.MethodCall methodCall) {
                super(newChannelDataComposite.getName() + ".LoadingInProgressMutator", newChannelDataComposite.getParams(), new a(str, str2, itemsRequest, methodCall));
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(itemsRequest, PlatformActions.ItemsList.ITEMS_REQUEST);
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ItemsListPresenter.State>>> {
            public final /* synthetic */ NewChannelDataComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(NewChannelDataComposite newChannelDataComposite) {
                super(0);
                this.a = newChannelDataComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ItemsListPresenter.State>> invoke() {
                List<String> platforms;
                if (this.a.e != null && (this.a.e.actions instanceof PlatformActions.ItemsList)) {
                    PlatformSupport platformSupport = this.a.e.actions.getPlatformSupport();
                    if ((platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) ? true : platforms.contains("android")) {
                        NewChannelDataComposite newChannelDataComposite = this.a;
                        NewChannelDataComposite newChannelDataComposite2 = this.a;
                        return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new LoadingInProgressMutator(newChannelDataComposite, newChannelDataComposite.e.channelId, ((PlatformActions.ItemsList) this.a.e.actions).getTitle(), ((PlatformActions.ItemsList) this.a.e.actions).getItemsRequest(), ((PlatformActions.ItemsList) this.a.e.actions).getExpandableData().getCancelHandler()), new LoadingResultMutator(ItemsListPresenterImpl.this, newChannelDataComposite2.getName(), this.a.getParams())});
                    }
                }
                NewChannelDataComposite newChannelDataComposite3 = this.a;
                return t6.n.d.listOf(new EmptyMutator(ItemsListPresenterImpl.this, newChannelDataComposite3.getName(), this.a.getParams()));
            }
        }

        public NewChannelDataComposite(@Nullable LegacyPlatformActionsPresenter.ChannelData channelData) {
            super("NewChannelDataComposite", "data=" + channelData, null, 4, null);
            this.e = channelData;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ItemsListPresenter.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$RetryComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl;)V", "LoadingInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RetryComposite extends CompositeReducible<ItemsListPresenter.State> {
        @NotNull
        public final Function0<List<Reducible<ItemsListPresenter.State>>> d = new a(this);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$RetryComposite$LoadingInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenterImpl$RetryComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class LoadingInProgressMutator extends Mutator<ItemsListPresenter.State> {

            public static final class a extends Lambda implements Function1<ItemsListPresenter.State, ItemsListPresenter.State> {
                public static final a a = new a();

                public a() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public ItemsListPresenter.State invoke(ItemsListPresenter.State state) {
                    ItemsListPresenter.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    if (!(state2 instanceof ItemsListPresenter.State.Visible)) {
                        return state2;
                    }
                    ItemsListPresenter.State.Visible visible = (ItemsListPresenter.State.Visible) state2;
                    if (!(visible.getItemsState() instanceof Loading.Error)) {
                        return state2;
                    }
                    return new ItemsListPresenter.State.Visible(visible.getChannelId(), visible.getTitle(), visible.getItemsRequest(), new Loading.InProgress(0, 1, null), visible.getCloseHandler());
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public LoadingInProgressMutator(RetryComposite retryComposite) {
                super(retryComposite.getName() + ".LoadingInProgressMutator", retryComposite.getParams(), a.a);
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ItemsListPresenter.State>>> {
            public final /* synthetic */ RetryComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(RetryComposite retryComposite) {
                super(0);
                this.a = retryComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ItemsListPresenter.State>> invoke() {
                RetryComposite retryComposite = this.a;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new LoadingInProgressMutator(this.a), new LoadingResultMutator(ItemsListPresenterImpl.this, retryComposite.getName(), this.a.getParams())});
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RetryComposite() {
            super(null, null, null, 7, null);
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ItemsListPresenter.State>>> getBlock() {
            return this.d;
        }
    }

    public static final class a<T, R> implements Function<LegacyPlatformActionsPresenter.State, Option<? extends LegacyPlatformActionsPresenter.ChannelData>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LegacyPlatformActionsPresenter.ChannelData> apply(LegacyPlatformActionsPresenter.State state) {
            LegacyPlatformActionsPresenter.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "parentState");
            return OptionKt.toOption(state2.getChannelData());
        }
    }

    public static final class b<T> implements Consumer<Option<? extends LegacyPlatformActionsPresenter.ChannelData>> {
        public final /* synthetic */ ItemsListPresenterImpl a;

        public b(ItemsListPresenterImpl itemsListPresenterImpl) {
            this.a = itemsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends LegacyPlatformActionsPresenter.ChannelData> option) {
            this.a.getReducerQueue().plusAssign(new NewChannelDataComposite((LegacyPlatformActionsPresenter.ChannelData) option.orNull()));
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ ItemsListPresenterImpl a;

        public d(ItemsListPresenterImpl itemsListPresenterImpl) {
            this.a = itemsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getReducerQueue().plusAssign(new RetryComposite());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ItemsListPresenterImpl(@NotNull LegacyPlatformActionsPresenter legacyPlatformActionsPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ItemsListInteractor itemsListInteractor, @NotNull Analytics analytics) {
        super("ItemsListPresenter", new ItemsListPresenter.State.Empty(null), schedulersFactory, CancelChecker.INSTANCE, null, null, null, null, 240, null);
        Intrinsics.checkNotNullParameter(legacyPlatformActionsPresenter, "parent");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(itemsListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.r = itemsListInteractor;
        this.s = analytics;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.q = compositeDisposable;
        Disposable subscribe = legacyPlatformActionsPresenter.getStateObservable().observeOn(schedulersFactory.computation()).map(a.a).distinctUntilChanged().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "parent.stateObservable\n …a.orNull())\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Disposable subscribe2 = getStateObservable().distinctUntilChanged().subscribe(new a2.a.a.o1.d.a0.k.a.f.d(new Function1<LegacyPlatformActionsPresenter.ContentData, Unit>(legacyPlatformActionsPresenter) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenterImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LegacyPlatformActionsPresenter.ContentData contentData) {
                LegacyPlatformActionsPresenter.ContentData contentData2 = contentData;
                Intrinsics.checkNotNullParameter(contentData2, "p1");
                ((LegacyPlatformActionsPresenter) this.receiver).updateContent(contentData2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "stateObservable.distinct…be(parent::updateContent)");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Disposable subscribe3 = itemsListInteractor.getReconnects().subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "interactor.reconnects\n  …Composite()\n            }");
        DisposableKt.addTo(subscribe3, compositeDisposable);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter
    public void handleCloseAction() {
        getReducerQueue().plusAssign(new CloseComposite());
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetClickListener
    public void handleItemClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        getReducerQueue().plusAssign(new ItemClickedAction(this, str));
        getOpenItemStream().postValue(str);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter
    public void handleRetryClick() {
        getReducerQueue().plusAssign(new RetryComposite());
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.q.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter
    @NotNull
    public MutableLiveData<String> getOpenItemStream() {
        return this.p;
    }
}
