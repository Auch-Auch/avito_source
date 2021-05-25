package com.avito.android.messenger.conversation.mvi.messages;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff;
import com.avito.android.messenger.conversation.ChannelProgressOverlay;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.avito.android.util.BackingField;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003'\u0001B<\u0012\u0007\u0010\u0001\u001a\u00020D\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010?\u001a\u00020\u000b¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0018\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010$\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0007R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010H\u001a\n E*\u0004\u0018\u00010D0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\bI\u00105R\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u00103\u001a\u0004\bO\u00105R\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010LR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001e\u0010Y\u001a\n E*\u0004\u0018\u00010W0W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R%\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020_0^8B@\u0002X\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\"\u0010g\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u00103\u001a\u0004\bf\u00105R\u001e\u0010k\u001a\n E*\u0004\u0018\u00010h0h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR9\u0010v\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010p\u001a\u0004\u0018\u00010\u00138V@VX\u0002¢\u0006\u0012\n\u0004\b)\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010y\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bw\u00103\u001a\u0004\bx\u00105R\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R#\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b~\u00103\u001a\u0004\b\u00105R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010>R\u0018\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00108R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\f E*\u0005\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00108R\u0018\u0010\u0001\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010GR\u0018\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00108R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010n¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View$OnTouchListener;", "", "destroy", "()V", "onRefresh", "", "padding", "", "setExtraPaddingBottom", "(I)Z", "scrollToBottom", VKApiConst.POSITION, "scrollTo", "(I)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "prevState", "curState", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "dx", "dy", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/MotionEvent;", "event", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "delayed", AuthSource.BOOKING_ORDER, "(Z)V", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/jakewharton/rxrelay2/Relay;", "s", "Lcom/jakewharton/rxrelay2/Relay;", "getScrolledToBottomStream", "()Lcom/jakewharton/rxrelay2/Relay;", "scrolledToBottomStream", "z", "Z", "scrollPositionCheckPending", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "C", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "F", "hideKeyboardOnScroll", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "i", "Landroid/view/ViewGroup;", "replyTimeOverlay", "getInitialScrollStream", "initialScrollStream", "n", "I", "readMessageThreshold", "t", "getStartPaginationStream", "startPaginationStream", AuthSource.OPEN_CHANNEL_LIST, "hideKeyboardScrollThreshold", "Lcom/avito/konveyor/ItemBinder;", "D", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "Lru/avito/component/button/ButtonImpl;", "l", "Lru/avito/component/button/ButtonImpl;", "replyTimeAction", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "h", "Lkotlin/Lazy;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "u", "getUserInteractedWithListStream", "userInteractedWithListStream", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "replyTimeIcon", "Ljava/lang/Runnable;", "w", "Ljava/lang/Runnable;", "positionCheckAction", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;)V", "lastRenderedState", "r", "getCallUserClicksStream", "callUserClicksStream", "Lcom/avito/android/messenger/conversation/ChannelProgressOverlay;", "d", "Lcom/avito/android/messenger/conversation/ChannelProgressOverlay;", "progressOverlay", VKApiConst.Q, "getRefreshClicksStream", "refreshClicksStream", "", "o", "chatHeaderOverlapHeight", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "initialScrollPerformed", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListViewImpl$b;", g.a, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListViewImpl$b;", "bottomPaddingDecoration", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "replyTimeText", "B", "paginationOnScrolledToTopIsEnabled", "c", "contentHolder", "y", "scrollPending", "Landroidx/recyclerview/widget/LinearLayoutManager;", "f", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "x", "afterInitialScrollAction", "rootView", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/analytics/Analytics;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ClickableViewAccessibility"})
public final class MessageListViewImpl extends RecyclerView.OnScrollListener implements MessageListView, OnRefreshListener, View.OnTouchListener {
    public static final /* synthetic */ KProperty[] G = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(MessageListViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", 0))};
    public boolean A;
    public boolean B;
    public final AdapterPresenter C;
    public final ItemBinder D;
    public final ChannelTracker E;
    public final boolean F;
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    public final Resources b;
    public final ViewGroup c;
    public final ChannelProgressOverlay d;
    public final RecyclerView e;
    public final LinearLayoutManager f;
    public final b g;
    public final Lazy h;
    public final ViewGroup i;
    public final ImageView j;
    public final TextView k;
    public final ButtonImpl l;
    public final int m;
    public final int n;
    public final float o;
    public final CompositeDisposable p;
    @NotNull
    public final Relay<Unit> q;
    @NotNull
    public final Relay<Unit> r;
    @NotNull
    public final Relay<Boolean> s;
    @NotNull
    public final Relay<Unit> t;
    @NotNull
    public final Relay<Unit> u;
    @NotNull
    public final Relay<Unit> v;
    public final Runnable w;
    public final Runnable x;
    public boolean y;
    public boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ChatReplyTime.ActionType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            ChatReplyTime.ActionType actionType = ChatReplyTime.ActionType.CALL;
            iArr[0] = 1;
            ChatReplyTime.ActionType actionType2 = ChatReplyTime.ActionType.DEFAULT;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int findFirstVisibleItemPosition;
            Boolean bool;
            Relay<Boolean> relay;
            int i = this.a;
            View view = null;
            boolean z = true;
            if (i == 0) {
                ((MessageListViewImpl) this.b).z = false;
                MessageListViewImpl messageListViewImpl = (MessageListViewImpl) this.b;
                if (messageListViewImpl.e.getChildCount() > 0 && !messageListViewImpl.y && (findFirstVisibleItemPosition = messageListViewImpl.f.findFirstVisibleItemPosition()) >= 0) {
                    if (findFirstVisibleItemPosition != 0) {
                        relay = messageListViewImpl.getScrolledToBottomStream();
                        bool = Boolean.FALSE;
                    } else if (messageListViewImpl.e.getChildCount() < 2) {
                        relay = messageListViewImpl.getScrolledToBottomStream();
                        bool = Boolean.TRUE;
                    } else {
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = messageListViewImpl.e.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                        if (findViewHolderForAdapterPosition != null) {
                            view = findViewHolderForAdapterPosition.itemView;
                        }
                        if (view != null) {
                            Rect rect = new Rect();
                            messageListViewImpl.e.getDecoratedBoundsWithMargins(view, rect);
                            int paddingBottom = messageListViewImpl.e.getPaddingBottom() + (rect.bottom - messageListViewImpl.e.getHeight());
                            Relay<Boolean> scrolledToBottomStream = messageListViewImpl.getScrolledToBottomStream();
                            if (paddingBottom > messageListViewImpl.n) {
                                z = false;
                            }
                            scrolledToBottomStream.accept(Boolean.valueOf(z));
                            return;
                        }
                        return;
                    }
                    relay.accept(bool);
                }
            } else if (i == 1) {
                ((MessageListViewImpl) this.b).getInitialScrollStream().accept(Unit.INSTANCE);
                Views.show(((MessageListViewImpl) this.b).e);
                ((MessageListViewImpl) this.b).a();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends RecyclerView.ItemDecoration {
        public int a;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.set(0, 0, 0, this.a);
            } else {
                rect.set(0, 0, 0, 0);
            }
        }
    }

    public static final class c extends LinearLayoutManager {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull Context context) {
            super(context, 1, true);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean isAutoMeasureEnabled() {
            return false;
        }
    }

    public static final class d extends Lambda implements Function0<SimpleRecyclerAdapter> {
        public final /* synthetic */ MessageListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MessageListViewImpl messageListViewImpl) {
            super(0);
            this.a = messageListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleRecyclerAdapter invoke() {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.a.C, this.a.D);
            this.a.e.setAdapter(simpleRecyclerAdapter);
            return simpleRecyclerAdapter;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MessageListViewImpl a;
        public final /* synthetic */ int b;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;

            public a(e eVar) {
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int findLastVisibleItemPosition = this.a.a.f.findLastVisibleItemPosition();
                e eVar = this.a;
                if (findLastVisibleItemPosition >= eVar.b) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = eVar.a.e.findViewHolderForAdapterPosition(this.a.b);
                    View view = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
                    if (view != null) {
                        Rect rect = new Rect();
                        this.a.a.e.getDecoratedBoundsWithMargins(view, rect);
                        this.a.a.e.scrollBy(0, t6.s.c.roundToInt(((float) rect.top) - this.a.a.o));
                    }
                }
                this.a.a.y = false;
                this.a.a.b(true);
            }
        }

        public e(MessageListViewImpl messageListViewImpl, int i) {
            this.a = messageListViewImpl;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e.scrollToPosition(this.b);
            if (this.b > 0) {
                this.a.e.post(new a(this));
                return;
            }
            this.a.y = false;
            MessageListViewImpl.c(this.a, false, 1);
            this.a.getScrolledToBottomStream().accept(Boolean.TRUE);
        }
    }

    public MessageListViewImpl(@NotNull ViewGroup viewGroup, @NotNull Analytics analytics, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull ChannelTracker channelTracker, boolean z2) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(channelTracker, "perfTracker");
        this.C = adapterPresenter;
        this.D = itemBinder;
        this.E = channelTracker;
        this.F = z2;
        Resources resources = viewGroup.getResources();
        this.b = resources;
        View findViewById = viewGroup.findViewById(R.id.channel_screen_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.channel_screen_root)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        this.c = viewGroup2;
        ChannelProgressOverlay channelProgressOverlay = new ChannelProgressOverlay(viewGroup2, analytics);
        this.d = channelProgressOverlay;
        View findViewById2 = viewGroup.findViewById(16908298);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(android.R.id.list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.e = recyclerView;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        c cVar = new c(context);
        this.f = cVar;
        b bVar = new b();
        this.g = bVar;
        this.h = t6.c.lazy(LazyThreadSafetyMode.NONE, (Function0) new d(this));
        this.i = (ViewGroup) viewGroup.findViewById(R.id.reply_time_overlay);
        this.j = (ImageView) viewGroup.findViewById(R.id.reply_time_icon);
        this.k = (TextView) viewGroup.findViewById(R.id.reply_time_text);
        View findViewById3 = viewGroup.findViewById(R.id.reply_time_action);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te…>(R.id.reply_time_action)");
        this.l = new ButtonImpl(findViewById3);
        this.m = resources.getDimensionPixelSize(R.dimen.messenger_hide_keyboard_scroll_threshold);
        this.n = resources.getDimensionPixelSize(R.dimen.messenger_read_message_threshold);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.o = ((float) 52) * resources.getDisplayMetrics().density;
        this.p = new CompositeDisposable();
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Unit>()");
        this.q = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create<Unit>()");
        this.r = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create<Boolean>()");
        this.s = create3;
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create<Unit>()");
        this.t = create4;
        PublishRelay create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create<Unit>()");
        this.u = create5;
        BehaviorRelay create6 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "BehaviorRelay.create()");
        this.v = create6;
        Context context2 = viewGroup2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "contentHolder.context");
        viewGroup2.setBackgroundColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        recyclerView.setLayoutManager(cVar);
        recyclerView.setOnTouchListener(this);
        recyclerView.addOnScrollListener(this);
        recyclerView.setItemAnimator(null);
        channelProgressOverlay.setOnRefreshListener(this);
        this.w = new a(0, this);
        this.x = new a(1, this);
        recyclerView.addItemDecoration(bVar);
    }

    public static final void access$checkScrollPositionAndNotify(MessageListViewImpl messageListViewImpl) {
        int findFirstVisibleItemPosition;
        Objects.requireNonNull(messageListViewImpl);
        if (messageListViewImpl.e.getChildCount() > 0 && !messageListViewImpl.y && (findFirstVisibleItemPosition = messageListViewImpl.f.findFirstVisibleItemPosition()) >= 0) {
            if (findFirstVisibleItemPosition != 0) {
                messageListViewImpl.getScrolledToBottomStream().accept(Boolean.FALSE);
            } else if (messageListViewImpl.e.getChildCount() < 2) {
                messageListViewImpl.getScrolledToBottomStream().accept(Boolean.TRUE);
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = messageListViewImpl.e.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                View view = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
                if (view != null) {
                    Rect rect = new Rect();
                    messageListViewImpl.e.getDecoratedBoundsWithMargins(view, rect);
                    messageListViewImpl.getScrolledToBottomStream().accept(Boolean.valueOf(messageListViewImpl.e.getPaddingBottom() + (rect.bottom - messageListViewImpl.e.getHeight()) <= messageListViewImpl.n));
                }
            }
        }
    }

    public static final RecyclerView.Adapter access$getAdapter$p(MessageListViewImpl messageListViewImpl) {
        return (RecyclerView.Adapter) messageListViewImpl.h.getValue();
    }

    public static final void access$hideReplyTime(MessageListViewImpl messageListViewImpl) {
        Objects.requireNonNull(messageListViewImpl);
        Views.hide(messageListViewImpl.i);
    }

    public static final void access$showReplyTime(MessageListViewImpl messageListViewImpl, ChatReplyTime chatReplyTime, boolean z2) {
        Objects.requireNonNull(messageListViewImpl);
        TextView textView = messageListViewImpl.k;
        Intrinsics.checkNotNullExpressionValue(textView, "replyTimeText");
        textView.setText(chatReplyTime.getText());
        int ordinal = chatReplyTime.getActionType().ordinal();
        if (ordinal == 0) {
            ImageView imageView = messageListViewImpl.j;
            ImageView imageView2 = messageListViewImpl.j;
            Intrinsics.checkNotNullExpressionValue(imageView2, "replyTimeIcon");
            Context context = imageView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "replyTimeIcon.context");
            imageView.setImageResource(Contexts.getResourceIdByAttr(context, com.avito.android.lib.design.R.attr.img_longAnswerTime));
            if (z2) {
                messageListViewImpl.l.setText(R.string.messenger_call_action);
                messageListViewImpl.l.setClickListener(new MessageListViewImpl$showReplyTime$1(messageListViewImpl));
                ButtonsKt.show(messageListViewImpl.l);
            } else {
                ButtonsKt.hide(messageListViewImpl.l);
            }
        } else if (ordinal == 1) {
            ImageView imageView3 = messageListViewImpl.j;
            ImageView imageView4 = messageListViewImpl.j;
            Intrinsics.checkNotNullExpressionValue(imageView4, "replyTimeIcon");
            Context context2 = imageView4.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "replyTimeIcon.context");
            imageView3.setImageResource(Contexts.getResourceIdByAttr(context2, com.avito.android.lib.design.R.attr.img_fastAnswerTime));
        }
        Views.show(messageListViewImpl.i);
    }

    public static /* synthetic */ void c(MessageListViewImpl messageListViewImpl, boolean z2, int i2) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        messageListViewImpl.b(z2);
    }

    public final void a() {
        if (!this.y && !this.z && this.A) {
            this.z = true;
            this.e.postDelayed(this.w, 200);
        }
    }

    public final void b(boolean z2) {
        if (!this.A) {
            this.A = true;
            if (z2) {
                this.e.postDelayed(this.x, 50);
            } else {
                this.x.run();
            }
        } else {
            a();
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    public void destroy() {
        this.p.clear();
        this.e.removeCallbacks(this.w);
        this.e.removeCallbacks(this.x);
        this.e.removeOnScrollListener(this);
        this.d.setOnRefreshListener((OnRefreshListener) null);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff
    @Nullable
    public MessageListView.State getLastRenderedState(@NotNull RendererWithDiff<MessageListView.State> rendererWithDiff) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        return (MessageListView.State) this.a.getValue(rendererWithDiff, G[0]);
    }

    @Override // com.avito.android.progress_overlay.OnRefreshListener
    public void onRefresh() {
        getRefreshClicksStream().accept(Unit.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        boolean z2 = false;
        if (this.F && i3 < 0 && Math.abs(i3) >= this.m) {
            Keyboards.hideKeyboard(this.e, false);
        }
        int childCount = this.f.getChildCount();
        int itemCount = ((RecyclerView.Adapter) this.h.getValue()).getItemCount();
        int findLastVisibleItemPosition = this.f.findLastVisibleItemPosition();
        int i4 = itemCount - 1;
        if (1 <= childCount && i4 >= childCount && findLastVisibleItemPosition == i4) {
            z2 = true;
        }
        if (z2 && this.B) {
            Logs.verbose$default("MessageListView", "Scrolled to top && paginationOnScrolledToTopIsEnabled", null, 4, null);
            getStartPaginationStream().accept(Unit.INSTANCE);
        } else if (z2) {
            Logs.verbose$default("MessageListView", "Scrolled to top, but pagination is disabled", null, 4, null);
        }
        a();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getActionMasked() == 2) {
            getUserInteractedWithListStream().accept(Unit.INSTANCE);
            b(false);
        }
        return false;
    }

    public void render(@NotNull MessageListView.State state, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(state, "state");
        MessageListView.DefaultImpls.render(this, state, diffResult);
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    public void scrollTo(int i2) {
        this.y = true;
        this.e.post(new e(this, i2));
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    public void scrollToBottom() {
        int findFirstVisibleItemPosition = this.f.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && 20 >= findFirstVisibleItemPosition) {
            this.e.smoothScrollToPosition(0);
            getUserInteractedWithListStream().accept(Unit.INSTANCE);
            getScrolledToBottomStream().accept(Boolean.TRUE);
            b(false);
            return;
        }
        scrollTo(0);
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    public boolean setExtraPaddingBottom(int i2) {
        b bVar = this.g;
        if (bVar.a == i2) {
            return true;
        }
        bVar.a = i2;
        this.e.invalidateItemDecorations();
        return false;
    }

    public void setLastRenderedState(@NotNull RendererWithDiff<MessageListView.State> rendererWithDiff, @Nullable MessageListView.State state) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        this.a.setValue(rendererWithDiff, G[0], state);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0119, code lost:
        if (r7 != null) goto L_0x011b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRender(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff<com.avito.android.messenger.conversation.mvi.messages.MessageListView.State> r7, @org.jetbrains.annotations.Nullable com.avito.android.messenger.conversation.mvi.messages.MessageListView.State r8, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.messages.MessageListView.State r9, @org.jetbrains.annotations.Nullable androidx.recyclerview.widget.DiffUtil.DiffResult r10) {
        /*
        // Method dump skipped, instructions count: 361
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListViewImpl.doRender(com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff, com.avito.android.messenger.conversation.mvi.messages.MessageListView$State, com.avito.android.messenger.conversation.mvi.messages.MessageListView$State, androidx.recyclerview.widget.DiffUtil$DiffResult):void");
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Unit> getCallUserClicksStream() {
        return this.r;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Unit> getInitialScrollStream() {
        return this.v;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Unit> getRefreshClicksStream() {
        return this.q;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Boolean> getScrolledToBottomStream() {
        return this.s;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Unit> getStartPaginationStream() {
        return this.t;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView
    @NotNull
    public Relay<Unit> getUserInteractedWithListStream() {
        return this.u;
    }
}
