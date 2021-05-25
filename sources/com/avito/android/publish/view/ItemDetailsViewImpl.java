package com.avito.android.publish.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish.ActionMode;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.R;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.publish.view.html_editor_toolbar.HtmlEditorToolbarImpl;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.publish.view.publish_button.PublishButtonImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010x\u001a\u00020u\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\b\u0002\u0010\u0001\u001a\u00030\u0001\u0012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u0001\u0012\u0006\u0010|\u001a\u00020y\u0012\u0007\u0010\u0001\u001a\u00020\u000f¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0014J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\u0014J\u0019\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b%\u0010\u0014J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010 J?\u0010-\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010\u0019J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0019J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0019J\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0019J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0019J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0019J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0019J\u001d\u00108\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060+H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0006H\u0016¢\u0006\u0004\b:\u0010\u0019J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0019J\u000f\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\b@\u0010\u0019J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010 J\u001f\u0010E\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010`\u001a\b\u0012\u0004\u0012\u00020[0Z8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010t\u001a\b\u0012\u0004\u0012\u00020q0Z8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\br\u0010]\u001a\u0004\bs\u0010_R\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsViewImpl;", "Lcom/avito/android/publish/view/ItemDetailsView;", "Landroid/view/View;", "itemView", "", "itemPosition", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;I)V", "", "title", "Lcom/avito/android/publish/view/ItemDetailsView$RightTopButtonStyle;", "buttonStyle", "setAppBarActionButton", "(Ljava/lang/String;Lcom/avito/android/publish/view/ItemDetailsView$RightTopButtonStyle;)V", "", "waitForRelayout", "scrollToItem", "(IZ)V", "setMainButtonTitle", "(Ljava/lang/String;)V", "isEnabled", "setAppbarExpandEnabled", "(Z)V", "showProgress", "()V", "showRetry", "showContent", "error", "showError", "id", "setAppBarHomeIcon", "(I)V", "setAppBarTitle", "shortTitle", "setAppBarShortTitle", MessengerShareContentUtility.SUBTITLE, "setAppBarSubtitle", "padding", "setBottomPadding", "message", "positiveOption", "negativeOption", "Lkotlin/Function0;", "onPositiveClicked", "showDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showValidationProgress", "hideValidationProgress", PlatformActions.HIDE_KEYBOARD, "showMainButtonDelayed", "showMainButton", "hideMainButton", "disableMainButton", "enableMainButton", "onScroll", "startScrollListening", "(Lkotlin/jvm/functions/Function0;)V", "stopScrollListening", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "showHtmlEditorToolbar", "hideHtmlEditorToolbar", "flags", "setEditorToolbarStateFlags", "undoEnabled", "redoEnabled", "setEditorNavigationButtonsStates", "(ZZ)V", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "dialog", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ljava/lang/Runnable;", a2.g.r.g.a, "Ljava/lang/Runnable;", "mainButtonShowRunnable", "Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbarImpl;", "i", "Lcom/avito/android/publish/view/html_editor_toolbar/HtmlEditorToolbarImpl;", "htmlEditorToolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lio/reactivex/Observable;", "Lcom/avito/android/html_formatter/FormatChange;", "k", "Lio/reactivex/Observable;", "getHtmlPanelStateFlags", "()Lio/reactivex/Observable;", "htmlPanelStateFlags", "Lcom/avito/android/publish/PublishAppbarView;", "h", "Lcom/avito/android/publish/PublishAppbarView;", "appbarView", "Landroid/view/ViewGroup;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/ViewGroup;", "root", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "j", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollListener", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "l", "getHtmlPanelNavigationEvent", "htmlPanelNavigationEvent", "Lcom/avito/android/publish/view/ItemDetailsView$Presenter;", "n", "Lcom/avito/android/publish/view/ItemDetailsView$Presenter;", "presenter", "Lcom/avito/android/util/DialogRouter;", "o", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "f", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "publishButton", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "animationDuration", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "appBarSaveActionEnabled", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/publish/view/ItemDetailsView$Presenter;Lcom/avito/android/analytics/Analytics;JLandroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/util/DialogRouter;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemDetailsViewImpl implements ItemDetailsView {
    public final Context a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final LinearLayoutManager d;
    public Dialog e;
    public final PublishButton f;
    public final Runnable g;
    public final PublishAppbarView h;
    public final HtmlEditorToolbarImpl i;
    public RecyclerView.OnScrollListener j;
    @NotNull
    public final Observable<FormatChange> k;
    @NotNull
    public final Observable<EditorNavigationEvent> l;
    public final ViewGroup m;
    public final ItemDetailsView.Presenter n;
    public final DialogRouter o;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemDetailsView.RightTopButtonStyle.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((ItemDetailsViewImpl) this.b).n.onCancelClicked(true);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ItemDetailsView.Presenter.DefaultImpls.onCancelClicked$default(((ItemDetailsViewImpl) this.b).n, false, 1, null);
                return Unit.INSTANCE;
            } else if (i == 2) {
                ItemDetailsView.Presenter.DefaultImpls.onCancelClicked$default(((ItemDetailsViewImpl) this.b).n, false, 1, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ItemDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ItemDetailsViewImpl itemDetailsViewImpl) {
            super(0);
            this.a = itemDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.n.onRetryClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;

        public c(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Views.show(this.a);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ItemDetailsViewImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public d(ItemDetailsViewImpl itemDetailsViewImpl, int i, int i2) {
            this.a = itemDetailsViewImpl;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.scrollToPositionWithOffset(this.b, this.c);
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ItemDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ItemDetailsViewImpl itemDetailsViewImpl) {
            super(0);
            this.a = itemDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.hideValidationProgress();
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ItemDetailsViewImpl a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ItemDetailsViewImpl itemDetailsViewImpl, Function0 function0) {
            super(0);
            this.a = itemDetailsViewImpl;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.hideValidationProgress();
            this.b.invoke();
            return Unit.INSTANCE;
        }
    }

    public ItemDetailsViewImpl(@NotNull ViewGroup viewGroup, @NotNull ItemDetailsView.Presenter presenter, @NotNull Analytics analytics, long j2, @NotNull RecyclerView.Adapter<?> adapter, @NotNull DialogRouter dialogRouter, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.m = viewGroup;
        this.n = presenter;
        this.o = dialogRouter;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.a = context;
        int i2 = R.id.recycler_view;
        View findViewById = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = viewGroup.findViewById(R.id.progress_view_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i2, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.d = linearLayoutManager;
        PublishButtonImpl publishButtonImpl = new PublishButtonImpl(viewGroup);
        this.f = publishButtonImpl;
        View buttonView = publishButtonImpl.getButtonView();
        this.g = buttonView != null ? new c(buttonView) : null;
        this.h = new PublishAppbarView(viewGroup, z);
        View findViewById3 = viewGroup.findViewById(R.id.editor_panel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.editor_panel)");
        HtmlEditorToolbarImpl htmlEditorToolbarImpl = new HtmlEditorToolbarImpl(findViewById3);
        this.i = htmlEditorToolbarImpl;
        this.k = htmlEditorToolbarImpl.getEditorToolbarStateFlagsObservable();
        this.l = htmlEditorToolbarImpl.getEditorToolbarNavigationEventObservable();
        String string = viewGroup.getResources().getString(com.avito.android.ui_components.R.string.continue_string);
        Intrinsics.checkNotNullExpressionValue(string, "root.resources.getString…R.string.continue_string)");
        publishButtonImpl.setText(string);
        publishButtonImpl.setClickListener(new a2.a.a.e2.g0.a(this));
        setBottomPadding(viewGroup.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.publish_params_bottom_padding));
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(j2);
        }
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setChangeDuration(j2);
        }
        progressOverlay.setOnRefreshListener(new b(this));
        recyclerView.setAdapter(adapter);
    }

    public static final void access$provideCompleteVisibilityOfItem(ItemDetailsViewImpl itemDetailsViewImpl, int i2, boolean z) {
        View findViewByPosition = itemDetailsViewImpl.d.findViewByPosition(i2);
        if (findViewByPosition != null) {
            Intrinsics.checkNotNullExpressionValue(findViewByPosition, "layoutManager.findViewBy…n(itemPosition) ?: return");
            if (z) {
                findViewByPosition.addOnLayoutChangeListener(new View.OnLayoutChangeListener(findViewByPosition, itemDetailsViewImpl, findViewByPosition, i2) { // from class: com.avito.android.publish.view.ItemDetailsViewImpl$provideCompleteVisibilityOfItem$$inlined$runOnNextLayoutChange$1
                    public final /* synthetic */ View a;
                    public final /* synthetic */ ItemDetailsViewImpl b;
                    public final /* synthetic */ View c;
                    public final /* synthetic */ int d;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(@Nullable View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                        this.b.a(this.c, this.d);
                        this.a.removeOnLayoutChangeListener(this);
                    }
                });
            } else {
                itemDetailsViewImpl.a(findViewByPosition, i2);
            }
        }
    }

    public final void a(View view, int i2) {
        int i3;
        if (this.i.isVisible()) {
            i3 = this.m.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.html_editor_toolbar_bottom_height) + this.f.getHeight();
        } else {
            i3 = this.f.getHeight();
        }
        this.b.post(new d(this, i2, view.getHeight() > this.b.getHeight() - i3 ? (this.b.getHeight() - view.getHeight()) - i3 : 0));
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void disableMainButton() {
        this.f.disable();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void enableMainButton() {
        this.f.enable();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    @NotNull
    public Observable<EditorNavigationEvent> getHtmlPanelNavigationEvent() {
        return this.l;
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    @NotNull
    public Observable<FormatChange> getHtmlPanelStateFlags() {
        return this.k;
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void hideHtmlEditorToolbar() {
        setBottomPadding(this.m.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.publish_params_bottom_padding));
        this.i.hide();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.m, false, 1, null);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void hideMainButton() {
        View buttonView = this.f.getButtonView();
        if (buttonView != null) {
            buttonView.removeCallbacks(this.g);
        }
        this.f.hide();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void hideValidationProgress() {
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void scrollToItem(int i2, boolean z) {
        int itemCount = this.d.getItemCount();
        if (i2 >= 0 && itemCount > i2) {
            this.h.setExpanded(false);
            View findViewByPosition = this.d.findViewByPosition(i2);
            if (findViewByPosition != null) {
                a(findViewByPosition, i2);
            } else if (this.b.getChildCount() == 0) {
                this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, i2, z) { // from class: com.avito.android.publish.view.ItemDetailsViewImpl$scrollToItem$1
                    public final /* synthetic */ ItemDetailsViewImpl a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ boolean c;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver = this.a.b.getViewTreeObserver();
                        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "recycler.viewTreeObserver");
                        ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                        this.a.scrollToItem(this.b, this.c);
                    }
                });
            } else {
                this.b.addOnScrollListener(new RecyclerView.OnScrollListener(this, i2, z) { // from class: com.avito.android.publish.view.ItemDetailsViewImpl$scrollToItem$2
                    public final /* synthetic */ ItemDetailsViewImpl a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ boolean c;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(@NotNull RecyclerView recyclerView, int i3, int i4) {
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        this.a.b.removeOnScrollListener(this);
                        ItemDetailsViewImpl.access$provideCompleteVisibilityOfItem(this.a, this.b, this.c);
                    }
                });
                this.d.scrollToPosition(i2);
            }
        }
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppBarActionButton(@Nullable String str, @NotNull ItemDetailsView.RightTopButtonStyle rightTopButtonStyle) {
        Intrinsics.checkNotNullParameter(rightTopButtonStyle, "buttonStyle");
        int ordinal = rightTopButtonStyle.ordinal();
        if (ordinal == 0) {
            this.h.setActionsListener(new a(0, this), new a(1, this));
        } else if (ordinal == 1) {
            this.h.setActionMode(ActionMode.NONE);
            this.h.setActionsListener(e.a, new a(2, this));
        }
        if (str != null) {
            this.h.setActionTitle(str);
        }
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppBarHomeIcon(int i2) {
        this.h.setHomeIcon(i2);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppBarShortTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortTitle");
        this.h.setShortTitle(str);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppBarSubtitle(@Nullable String str) {
        this.h.setSubtitle(str);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.h.setTitle(str);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setAppbarExpandEnabled(boolean z) {
        if (!z) {
            this.h.setExpanded(false);
        }
        this.b.setNestedScrollingEnabled(z);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setBottomPadding(int i2) {
        Views.changePadding$default(this.b, 0, 0, 0, i2, 7, null);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setEditorNavigationButtonsStates(boolean z, boolean z2) {
        this.i.setNavigationButtonsStates(z, z2);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setEditorToolbarStateFlags(int i2) {
        this.i.setEditorToolbarStateFlags(i2);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void setMainButtonTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f.setText(str);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showActionOnboarding(@NotNull OnboardingData onboardingData) {
        Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
        this.h.showActionOnboarding(onboardingData);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showContent() {
        this.c.showContent();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showDialog(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "positiveOption");
        Intrinsics.checkNotNullParameter(str4, "negativeOption");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClicked");
        this.e = this.o.showCancelableNotifyingDialog(str, true, str2, str4, new f(this), str3, new g(this, function0));
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.m, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showHtmlEditorToolbar() {
        setBottomPadding(this.m.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.publish_params_with_html_editor_toolbar_bottom_padding));
        this.i.show();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showMainButton() {
        View buttonView = this.f.getButtonView();
        if (buttonView != null) {
            buttonView.removeCallbacks(this.g);
        }
        this.f.show();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showMainButtonDelayed() {
        View buttonView = this.f.getButtonView();
        if (buttonView != null) {
            buttonView.removeCallbacks(this.g);
            buttonView.postDelayed(this.g, 200);
        }
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showRetry() {
        this.h.setExpanded(false);
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void showValidationProgress() {
        this.e = this.o.showSimpleWaitingDialogWithMessage(R.string.sending);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void startScrollListening(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onScroll");
        ItemDetailsViewImpl$startScrollListening$listener$1 itemDetailsViewImpl$startScrollListening$listener$1 = new RecyclerView.OnScrollListener(function0) { // from class: com.avito.android.publish.view.ItemDetailsViewImpl$startScrollListening$listener$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.a.invoke();
                }
            }
        };
        this.b.addOnScrollListener(itemDetailsViewImpl$startScrollListening$listener$1);
        this.j = itemDetailsViewImpl$startScrollListening$listener$1;
    }

    @Override // com.avito.android.publish.view.ItemDetailsView
    public void stopScrollListening() {
        RecyclerView.OnScrollListener onScrollListener = this.j;
        if (onScrollListener != null) {
            this.b.removeOnScrollListener(onScrollListener);
        }
        this.j = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemDetailsViewImpl(ViewGroup viewGroup, ItemDetailsView.Presenter presenter, Analytics analytics, long j2, RecyclerView.Adapter adapter, DialogRouter dialogRouter, boolean z, int i2, j jVar) {
        this(viewGroup, presenter, analytics, (i2 & 8) != 0 ? 500 : j2, adapter, dialogRouter, z);
    }
}
