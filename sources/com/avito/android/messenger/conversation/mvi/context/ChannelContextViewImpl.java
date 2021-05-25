package com.avito.android.messenger.conversation.mvi.context;

import a2.a.a.o1.d.a0.a.c;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.chat_header.ChatHeader;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u0002010\r\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b@\u0010AJ+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR9\u0010\u0018\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000fR\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u000f¨\u0006B"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;)V", "clearSubscriptions", "()V", "destroyView", "attachView", "Lio/reactivex/Observable;", "getTitleClicks", "()Lio/reactivex/Observable;", "titleClicks", "<set-?>", AuthSource.SEND_ABUSE, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;)V", "lastRenderedState", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "i", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader;", "chatHeader", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "collapseTriggersSubscription", "getItemImageClicks", "itemImageClicks", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", g.a, "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "getBackClicks", "backClicks", "", "f", "Lio/reactivex/Observable;", "keyboardVisibilityObservable", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "d", "Z", "priceEnabled", "getItemBlockClicks", "itemBlockClicks", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView;Lio/reactivex/Observable;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Lcom/avito/android/Features;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelContextViewImpl implements ChannelContextView {
    public static final /* synthetic */ KProperty[] j = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelContextViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", 0))};
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    public final ChatHeader b;
    public Disposable c;
    public final boolean d;
    public final RecyclerView e;
    public final Observable<Boolean> f;
    public final ChannelTracker g;
    public final Features h;
    public final RecyclerView.OnScrollListener i;

    public ChannelContextViewImpl(@NotNull ViewGroup viewGroup, @NotNull RecyclerView recyclerView, @NotNull Observable<Boolean> observable, @NotNull ChannelTracker channelTracker, @NotNull Features features, @NotNull RecyclerView.OnScrollListener onScrollListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics.checkNotNullParameter(observable, "keyboardVisibilityObservable");
        Intrinsics.checkNotNullParameter(channelTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        this.e = recyclerView;
        this.f = observable;
        this.g = channelTracker;
        this.h = features;
        this.i = onScrollListener;
        ChatHeader.Companion companion = ChatHeader.Companion;
        View findViewById = viewGroup.findViewById(R.id.channel_header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.channel_header)");
        this.b = companion.create((ConstraintLayout) findViewById);
        this.d = features.getMessengerPriceInChatHeader().invoke().booleanValue();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    public void attachView() {
        this.e.addOnScrollListener(this.i);
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    public void clearSubscriptions() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    public void destroyView() {
        this.e.removeOnScrollListener(this.i);
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    @NotNull
    public Observable<Unit> getBackClicks() {
        return this.b.getBackNavigationClicks();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    @NotNull
    public Observable<Unit> getItemBlockClicks() {
        return this.b.getItemTitleClicks();
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    @NotNull
    public Observable<Unit> getItemImageClicks() {
        return this.b.getItemImageClicks();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public ChannelContextView.State getLastRenderedState(@NotNull Renderer<ChannelContextView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (ChannelContextView.State) this.a.getValue(renderer, j[0]);
    }

    @Override // com.avito.android.messenger.conversation.mvi.context.ChannelContextView
    @NotNull
    public Observable<Unit> getTitleClicks() {
        return this.b.getTitleClicks();
    }

    public void render(@NotNull ChannelContextView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChannelContextView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<ChannelContextView.State> renderer, @Nullable ChannelContextView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, j[0], state);
    }

    public void doRender(@NotNull Renderer<ChannelContextView.State> renderer, @Nullable ChannelContextView.State state, @NotNull ChannelContextView.State state2) {
        ChatHeader.Context context;
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        this.g.startContextDraw();
        ChannelContextView.ItemBlock itemBlock = state2.itemBlock;
        DeepLink deepLink = null;
        if (itemBlock instanceof ChannelContextView.ItemBlock.Loaded) {
            String str = ((ChannelContextView.ItemBlock.Loaded) itemBlock).title;
            String str2 = ((ChannelContextView.ItemBlock.Loaded) itemBlock).price;
            if (!this.d) {
                str2 = null;
            }
            context = new ChatHeader.Context.Item(str, str2, ((ChannelContextView.ItemBlock.Loaded) itemBlock).image, ((ChannelContextView.ItemBlock.Loaded) itemBlock).dealActionTitle);
        } else if (Intrinsics.areEqual(itemBlock, ChannelContextView.ItemBlock.Empty.INSTANCE)) {
            context = new ChatHeader.Context.Item(null, null, null, null, 15, null);
        } else if (Intrinsics.areEqual(itemBlock, ChannelContextView.ItemBlock.Hidden.INSTANCE)) {
            context = ChatHeader.Context.Hidden.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.b.render(new ChatHeader.State(state2.chatTitle, state2.onlineStatus, context, state2.isConnecting));
        ChannelContextView.ItemBlock itemBlock2 = state != null ? state.itemBlock : null;
        if (!(itemBlock2 instanceof ChannelContextView.ItemBlock.Loaded)) {
            itemBlock2 = null;
        }
        ChannelContextView.ItemBlock.Loaded loaded = (ChannelContextView.ItemBlock.Loaded) itemBlock2;
        DeepLink deepLink2 = loaded != null ? loaded.dealActionDeepLink : null;
        ChannelContextView.ItemBlock itemBlock3 = state2.itemBlock;
        if (!(itemBlock3 instanceof ChannelContextView.ItemBlock.Loaded)) {
            itemBlock3 = null;
        }
        ChannelContextView.ItemBlock.Loaded loaded2 = (ChannelContextView.ItemBlock.Loaded) itemBlock3;
        if (loaded2 != null) {
            deepLink = loaded2.dealActionDeepLink;
        }
        boolean z = true;
        if (!Intrinsics.areEqual(deepLink, deepLink2)) {
            this.b.expand(true);
        }
        if (context instanceof ChatHeader.Context.Item) {
            Disposable disposable = this.c;
            if (disposable != null && !disposable.isDisposed()) {
                z = false;
            }
            if (z) {
                this.c = this.f.skip(1).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).takeUntil(RxView.detaches(this.e)).subscribe(new c(this));
            }
        } else {
            Disposable disposable2 = this.c;
            if (disposable2 != null) {
                disposable2.dispose();
            }
        }
        this.g.trackContextDraw();
    }
}
