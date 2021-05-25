package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.messenger.conversation.mvi.send.SendMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.UrlParams;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxbinding3.core.RxNestedScrollView;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010r\u001a\u00020q¢\u0006\u0004\bs\u0010tJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u0010\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJG\u0010\u001f\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\t\"\u000e\b\u0001\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00101\u001a\n .*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R2\u00105\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR9\u0010N\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010H\u001a\u0004\u0018\u00010\u00168V@VX\u0002¢\u0006\u0012\n\u0004\b\u0007\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010P\u001a\n .*\u0004\u0018\u00010\u00040\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010>R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010V\u001a\n .*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u00100R\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010>R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010+R\u0016\u0010d\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010FR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010+R\"\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00060k8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o¨\u0006u"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;", "", "willShow", "Landroid/view/View;", "titleView", "", AuthSource.SEND_ABUSE, "(ZLandroid/view/View;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "T", "Ljava/lang/Class;", "clazz", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "view", "addContentView", "(Ljava/lang/Class;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;)V", "visible", "onKeyboardVisibilityChanged", "(Z)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;)V", "P", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "presenter", "bindContentPresenter", "(Ljava/lang/Class;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;)V", "unbindContentPresenters", "()V", "onBackPressed", "()Z", "destroyViews", "Lru/avito/component/bottom_sheet/BottomSheet;", "h", "Lru/avito/component/bottom_sheet/BottomSheet;", "bottomSheet", "o", "Z", "isKeyboardVisible", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "f", "Landroid/widget/FrameLayout;", "stickyView", "", "c", "Ljava/util/Map;", "contentViews", "Landroidx/core/widget/NestedScrollView;", "j", "Landroidx/core/widget/NestedScrollView;", "bottomSheetContainer", VKApiConst.Q, "Ljava/lang/Boolean;", "bottomSheetShouldBeCollapsed", "k", "Landroid/view/View;", "bottomSheetCloseButton", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "u", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "messageListView", "", AuthSource.OPEN_CHANNEL_LIST, "I", "bottomSheetTransparentOffset", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;)V", "lastRenderedState", "e", "newMessagesIndicator", "", "l", "F", "density", a2.g.r.g.a, "stickyContentView", "Ljava/lang/Runnable;", "s", "Ljava/lang/Runnable;", "bottomSheetScrollRunnable", "i", "bottomSheetContentView", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "r", "bottomSheetScrollIsScheduled", "n", "bottomFallbackPeekHeight", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "rootView", "p", "bottomSheetIsScrolledToTop", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getBottomSheetOpenedStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "bottomSheetOpenedStream", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageView;", "sendMessageView", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;Lcom/avito/android/messenger/conversation/mvi/send/SendMessageView;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPlatformActionsViewImpl implements LegacyPlatformActionsView {
    public static final /* synthetic */ KProperty[] v = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(LegacyPlatformActionsViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", 0))};
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    @NotNull
    public final PublishRelay<Unit> b;
    public final Map<Class<? extends LegacyPlatformActionsPresenter.ContentData>, LegacyPlatformActionsView.ContentView<?, ?>> c;
    public final CompositeDisposable d;
    public final View e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final BottomSheet h;
    public final View i;
    public final NestedScrollView j;
    public final View k;
    public final float l;
    public final int m;
    public final int n;
    public boolean o;
    public boolean p;
    public Boolean q;
    public boolean r;
    public Runnable s;
    public final ViewGroup t;
    public final MessageListView u;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((LegacyPlatformActionsViewImpl) this.b).q = Boolean.FALSE;
                boolean areEqual = Intrinsics.areEqual(((LegacyPlatformActionsViewImpl) this.b).h.getVisibility(), BottomSheet.Visibility.Expanded.INSTANCE);
                if (Views.isVisible(((LegacyPlatformActionsViewImpl) this.b).h.getView()) && areEqual) {
                    LegacyPlatformActionsViewImpl.access$schedulerScrollBottomSheetContainerToTop((LegacyPlatformActionsViewImpl) this.b);
                    ((LegacyPlatformActionsViewImpl) this.b).h.collapse();
                }
            } else if (i == 1) {
                ((LegacyPlatformActionsViewImpl) this.b).q = Boolean.TRUE;
                if (Views.isVisible(((LegacyPlatformActionsViewImpl) this.b).h.getView())) {
                    LegacyPlatformActionsViewImpl.access$schedulerScrollBottomSheetContainerToTop((LegacyPlatformActionsViewImpl) this.b);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<String, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, ObservableSource<Unit>> {
        public final /* synthetic */ LegacyPlatformActionsViewImpl a;
        public final /* synthetic */ int b;

        public c(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl, int i) {
            this.a = legacyPlatformActionsViewImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<Unit> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Observable.just(Unit.INSTANCE).delay(this.a.o ? 0 : (long) this.b, TimeUnit.MILLISECONDS);
        }
    }

    public static final class d<T, R> implements Function<BottomSheet.Visibility.Collapsed, Unit> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(BottomSheet.Visibility.Collapsed collapsed) {
            Intrinsics.checkNotNullParameter(collapsed, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer<BottomSheet.Visibility.Expanded> {
        public final /* synthetic */ LegacyPlatformActionsViewImpl a;

        public e(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
            this.a = legacyPlatformActionsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BottomSheet.Visibility.Expanded expanded) {
            this.a.q = Boolean.FALSE;
            this.a.getBottomSheetOpenedStream().accept(Unit.INSTANCE);
        }
    }

    public static final class f<T, R> implements Function<ViewScrollChangeEvent, Boolean> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(ViewScrollChangeEvent viewScrollChangeEvent) {
            ViewScrollChangeEvent viewScrollChangeEvent2 = viewScrollChangeEvent;
            Intrinsics.checkNotNullParameter(viewScrollChangeEvent2, "it");
            return Boolean.valueOf(viewScrollChangeEvent2.getScrollY() == 0);
        }
    }

    public static final class g<T> implements Consumer<Boolean> {
        public final /* synthetic */ LegacyPlatformActionsViewImpl a;

        public g(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
            this.a = legacyPlatformActionsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "isScrolledToTop");
            legacyPlatformActionsViewImpl.p = bool2.booleanValue();
            LegacyPlatformActionsViewImpl.access$schedulerScrollBottomSheetContainerToTop(this.a);
        }
    }

    public static final class h extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ LegacyPlatformActionsViewImpl a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl, boolean z) {
            super(0);
            this.a = legacyPlatformActionsViewImpl;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            int i;
            MessageListView messageListView = this.a.u;
            if (this.b) {
                FrameLayout frameLayout = this.a.f;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "stickyView");
                i = frameLayout.getHeight();
            } else {
                i = 0;
            }
            return Boolean.valueOf(messageListView.setExtraPaddingBottom(i));
        }
    }

    public LegacyPlatformActionsViewImpl(@NotNull ViewGroup viewGroup, @NotNull MessageListView messageListView, @NotNull SendMessageView sendMessageView) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(messageListView, "messageListView");
        Intrinsics.checkNotNullParameter(sendMessageView, "sendMessageView");
        this.t = viewGroup;
        this.u = messageListView;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
        this.c = new LinkedHashMap();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        this.e = viewGroup.findViewById(R.id.update_proposal);
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.context_actions);
        this.f = frameLayout;
        this.g = (FrameLayout) frameLayout.findViewById(R.id.platform_actions_panel_content);
        BottomSheet.Companion companion = BottomSheet.Companion;
        View findViewById = viewGroup.findViewById(R.id.bottom_sheet);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bottom_sheet)");
        BottomSheet create2 = companion.create(findViewById);
        this.h = create2;
        Resources resources = viewGroup.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        float f2 = resources.getDisplayMetrics().density;
        this.l = f2;
        this.m = t6.s.c.roundToInt(((float) 16) * f2);
        this.n = t6.s.c.roundToInt(((float) 160) * f2);
        this.p = true;
        Views.conceal(create2.getView());
        create2.setHideable(false);
        create2.setDimBackgroundOnExpand(true);
        create2.setPeekHeight(new BottomSheet.PeekHeight.Absolute(t6.s.c.roundToInt(((float) 60) * f2)));
        View contentView = create2.setContentView(R.layout.messenger_platform_actions_sheet);
        Objects.requireNonNull(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) contentView;
        this.i = viewGroup2;
        View findViewById2 = viewGroup2.findViewById(R.id.platform_actions_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bottomSheetContentView.f…atform_actions_container)");
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById2;
        this.j = nestedScrollView;
        View findViewById3 = viewGroup2.findViewById(R.id.platform_actions_close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bottomSheetContentView.f…orm_actions_close_button)");
        this.k = findViewById3;
        Disposable subscribe = sendMessageView.getTouches().mergeWith(sendMessageView.getMessageTextChangesByUser().map(b.a)).debounce(new c(this, viewGroup.getResources().getInteger(17694720))).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sendMessageView.touches\n…          }\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Observable distinctUntilChanged = InteropKt.toV2(create2.getVisibilityObservable()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "bottomSheet.visibilityOb…  .distinctUntilChanged()");
        Observable ofType = distinctUntilChanged.ofType(BottomSheet.Visibility.Collapsed.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Disposable subscribe2 = ofType.map(d.a).subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "bottomSheet.visibilityOb…          }\n            }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Observable distinctUntilChanged2 = InteropKt.toV2(create2.getVisibilityObservable()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "bottomSheet.visibilityOb…  .distinctUntilChanged()");
        Observable ofType2 = distinctUntilChanged2.ofType(BottomSheet.Visibility.Expanded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
        Disposable subscribe3 = ofType2.subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "bottomSheet.visibilityOb…eam += Unit\n            }");
        DisposableKt.addTo(subscribe3, compositeDisposable);
        Disposable subscribe4 = RxNestedScrollView.scrollChangeEvents(nestedScrollView).map(f.a).distinctUntilChanged().subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "bottomSheetContainer.scr…inerToTop()\n            }");
        DisposableKt.addTo(subscribe4, compositeDisposable);
    }

    public static final void access$schedulerScrollBottomSheetContainerToTop(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
        if (!legacyPlatformActionsViewImpl.r) {
            legacyPlatformActionsViewImpl.r = true;
            legacyPlatformActionsViewImpl.j.removeCallbacks(legacyPlatformActionsViewImpl.s);
            if (Intrinsics.areEqual(legacyPlatformActionsViewImpl.q, Boolean.TRUE) && !legacyPlatformActionsViewImpl.p) {
                legacyPlatformActionsViewImpl.j.scrollTo(0, 0);
            }
            a2.a.a.o1.d.a0.k.a.d dVar = new a2.a.a.o1.d.a0.k.a.d(legacyPlatformActionsViewImpl);
            legacyPlatformActionsViewImpl.s = dVar;
            legacyPlatformActionsViewImpl.j.postDelayed(dVar, 1000);
        }
    }

    public static final void access$scrollBottomSheetContainerToTopIfNeeded(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl) {
        Objects.requireNonNull(legacyPlatformActionsViewImpl);
        if (Intrinsics.areEqual(legacyPlatformActionsViewImpl.q, Boolean.TRUE) && !legacyPlatformActionsViewImpl.p) {
            legacyPlatformActionsViewImpl.j.scrollTo(0, 0);
        }
    }

    public final void a(boolean z, View view) {
        if (view != null) {
            view.setOnClickListener(null);
        }
        View view2 = this.e;
        Intrinsics.checkNotNullExpressionValue(view2, "newMessagesIndicator");
        Views.changePadding$default(view2, 0, 0, 0, 0, 7, null);
        Views.runOnPreDraw(this.t, new h(this, z));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    public <T extends LegacyPlatformActionsPresenter.ContentData> void addContentView(@NotNull Class<T> cls, @NotNull LegacyPlatformActionsView.ContentView<T, ? extends LegacyPlatformActionsView.ContentPresenter<T>> contentView) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(contentView, "view");
        this.c.put(cls, contentView);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    public <T extends LegacyPlatformActionsPresenter.ContentData, P extends LegacyPlatformActionsView.ContentPresenter<T>> void bindContentPresenter(@NotNull Class<T> cls, @NotNull LifecycleOwner lifecycleOwner, @NotNull P p2) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(p2, "presenter");
        LegacyPlatformActionsView.ContentView<?, ?> contentView = this.c.get(cls);
        if (!(contentView instanceof LegacyPlatformActionsView.ContentView)) {
            contentView = null;
        }
        LegacyPlatformActionsView.ContentView<?, ?> contentView2 = contentView;
        if (contentView2 != null) {
            contentView2.bindPresenter(lifecycleOwner, p2);
            return;
        }
        throw new IllegalStateException("No view for class: " + cls);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    public void destroyViews() {
        this.j.removeCallbacks(this.s);
        this.d.clear();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public LegacyPlatformActionsPresenter.State getLastRenderedState(@NotNull Renderer<LegacyPlatformActionsPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (LegacyPlatformActionsPresenter.State) this.a.getValue(renderer, v[0]);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        if (!Intrinsics.areEqual(this.h.getVisibility(), BottomSheet.Visibility.Expanded.INSTANCE)) {
            return false;
        }
        this.q = Boolean.TRUE;
        this.h.collapse();
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    public void onKeyboardVisibilityChanged(boolean z) {
        LegacyPlatformActionsPresenter.State lastRenderedState = getLastRenderedState((Renderer<LegacyPlatformActionsPresenter.State>) this);
        if (this.o != z && lastRenderedState != null) {
            this.o = z;
            doRender((Renderer<LegacyPlatformActionsPresenter.State>) this, (LegacyPlatformActionsPresenter.State) null, lastRenderedState);
        }
    }

    public void render(@NotNull LegacyPlatformActionsPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        LegacyPlatformActionsView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<LegacyPlatformActionsPresenter.State> renderer, @Nullable LegacyPlatformActionsPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, v[0], state);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    public void unbindContentPresenters() {
        Iterator<T> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().unbindPresenter();
        }
    }

    public void doRender(@NotNull Renderer<LegacyPlatformActionsPresenter.State> renderer, @Nullable LegacyPlatformActionsPresenter.State state, @NotNull LegacyPlatformActionsPresenter.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        LegacyPlatformActionsPresenter.UiData uiData = state2.getUiData();
        boolean z = true;
        View view = null;
        if (uiData instanceof LegacyPlatformActionsPresenter.UiData.Sticky) {
            LegacyPlatformActionsPresenter.ContentData contentData = state2.getContentData();
            LegacyPlatformActionsPresenter.UiData.Sticky sticky = (LegacyPlatformActionsPresenter.UiData.Sticky) uiData;
            Views.conceal(this.h.getView());
            this.q = Boolean.TRUE;
            this.h.collapse();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            for (Map.Entry<Class<? extends LegacyPlatformActionsPresenter.ContentData>, LegacyPlatformActionsView.ContentView<?, ?>> entry : this.c.entrySet()) {
                Class<? extends LegacyPlatformActionsPresenter.ContentData> key = entry.getKey();
                T t2 = (T) entry.getValue();
                Objects.requireNonNull(t2, "null cannot be cast to non-null type com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView<com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.ContentData, *>");
                LegacyPlatformActionsPresenter.ContentData contentData2 = (LegacyPlatformActionsPresenter.ContentData) (key.isInstance(contentData) ? key.cast(contentData) : null);
                if (objectRef.element != null || contentData2 == null) {
                    t2.removeFromParent(this.g, null);
                } else if (t2.render(contentData2, sticky)) {
                    FrameLayout frameLayout = this.g;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "stickyContentView");
                    t2.addToParent(frameLayout, new FrameLayout.LayoutParams(-1, -2), null);
                    objectRef.element = t2;
                } else {
                    t2.removeFromParent(this.g, null);
                }
            }
            if (objectRef.element == null) {
                z = false;
            }
            FrameLayout frameLayout2 = this.f;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "stickyView");
            if (z != Views.isVisible(frameLayout2)) {
                if (!z) {
                    this.u.setExtraPaddingBottom(0);
                }
                ViewGroup viewGroup = this.t;
                TransitionDsl transitionDsl = new TransitionDsl(new Slide());
                FrameLayout frameLayout3 = this.f;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "stickyView");
                transitionDsl.addTarget(frameLayout3.getId());
                View view2 = this.e;
                Intrinsics.checkNotNullExpressionValue(view2, "newMessagesIndicator");
                transitionDsl.addTarget(view2.getId());
                transitionDsl.onTransitionEnd(new a2.a.a.o1.d.a0.k.a.c(this, z, objectRef));
                TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
                if (z) {
                    Views.show(this.f);
                } else {
                    Views.hide(this.f);
                }
            } else {
                T t3 = objectRef.element;
                if (t3 != null) {
                    view = t3.getTitleView();
                }
                a(z, view);
            }
        } else if (uiData instanceof LegacyPlatformActionsPresenter.UiData.Sheet) {
            LegacyPlatformActionsPresenter.ContentData contentData3 = state2.getContentData();
            LegacyPlatformActionsPresenter.UiData.Sheet sheet = (LegacyPlatformActionsPresenter.UiData.Sheet) uiData;
            Views.hide(this.f);
            LegacyPlatformActionsView.ContentView<?, ?> contentView = null;
            for (Map.Entry<Class<? extends LegacyPlatformActionsPresenter.ContentData>, LegacyPlatformActionsView.ContentView<?, ?>> entry2 : this.c.entrySet()) {
                Class<? extends LegacyPlatformActionsPresenter.ContentData> key2 = entry2.getKey();
                LegacyPlatformActionsView.ContentView<?, ?> value = entry2.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView<com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.ContentData, *>");
                LegacyPlatformActionsPresenter.ContentData contentData4 = (LegacyPlatformActionsPresenter.ContentData) (key2.isInstance(contentData3) ? key2.cast(contentData3) : null);
                if (contentView != null || contentData4 == null) {
                    value.removeFromParent(this.f, null);
                } else if (value.render(contentData4, sheet)) {
                    value.addToParent(this.j, new FrameLayout.LayoutParams(-1, -2), this.k);
                    contentView = value;
                } else {
                    value.removeFromParent(this.j, this.k);
                }
            }
            if (contentView != null) {
                View titleView = contentView.getTitleView();
                if (titleView != null) {
                    titleView.setOnClickListener(new a2.a.a.o1.d.a0.k.a.a(this));
                }
                Views.runOnPreDraw(this.t, new a2.a.a.o1.d.a0.k.a.b(this, true, titleView));
                Views.show(this.h.getView());
                if (Intrinsics.areEqual(this.h.getVisibility(), BottomSheet.Visibility.Closed.INSTANCE)) {
                    this.q = Boolean.TRUE;
                    this.h.collapse();
                    return;
                }
                return;
            }
            Views.conceal(this.h.getView());
            this.q = Boolean.TRUE;
            this.h.collapse();
            Views.runOnPreDraw(this.t, new a2.a.a.o1.d.a0.k.a.b(this, false, null));
        } else if (uiData == null) {
            Iterator<T> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().removeFromParent(null, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView
    @NotNull
    public PublishRelay<Unit> getBottomSheetOpenedStream() {
        return this.b;
    }
}
