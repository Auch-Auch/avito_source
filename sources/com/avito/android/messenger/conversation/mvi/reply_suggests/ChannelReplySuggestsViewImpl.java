package com.avito.android.messenger.conversation.mvi.reply_suggests;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.avito.android.component.message_suggest_element.MessageSuggestElementImpl;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.BackingField;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.Relay;
import java.util.List;
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
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b7\u00108J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR9\u0010$\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010'R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010'R\u001d\u00106\u001a\u0002028B@\u0002X\u0002¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;)V", "", "e", "Z", "initialized", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "rootView", "Lcom/jakewharton/rxrelay2/Relay;", "h", "Lcom/jakewharton/rxrelay2/Relay;", "closeButtonClickedRelay", "", "f", "replySuggestClickedRelay", "Landroid/view/View;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "<set-?>", AuthSource.SEND_ABUSE, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;)V", "lastRenderedState", g.a, "getReplySuggestClickedObservable", "()Lcom/jakewharton/rxrelay2/Relay;", "replySuggestClickedObservable", "Landroid/widget/ImageButton;", "d", "Lkotlin/Lazy;", "getCloseButton", "()Landroid/widget/ImageButton;", "closeButton", "i", "getCloseButtonClickedObservable", "closeButtonClickedObservable", "Landroid/widget/LinearLayout;", "c", "getContainer", "()Landroid/widget/LinearLayout;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelReplySuggestsViewImpl implements ChannelReplySuggestsView {
    public static final /* synthetic */ KProperty[] k = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelReplySuggestsViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", 0))};
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    public final View b;
    public final Lazy c;
    public final Lazy d;
    public boolean e;
    public final Relay<String> f;
    @NotNull
    public final Relay<String> g;
    public final Relay<Unit> h;
    @NotNull
    public final Relay<Unit> i;
    public final ViewGroup j;

    public static final class a extends Lambda implements Function0<ImageButton> {
        public final /* synthetic */ ChannelReplySuggestsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl) {
            super(0);
            this.a = channelReplySuggestsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ImageButton invoke() {
            View view = this.a.b;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            View findViewById = view.findViewById(R.id.message_suggest_close_btn);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageButton");
            return (ImageButton) findViewById;
        }
    }

    public static final class b extends Lambda implements Function0<LinearLayout> {
        public final /* synthetic */ ChannelReplySuggestsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl) {
            super(0);
            this.a = channelReplySuggestsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            View view = this.a.b;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            View findViewById = view.findViewById(R.id.message_suggest_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            return (LinearLayout) findViewById;
        }
    }

    public ChannelReplySuggestsViewImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.j = viewGroup;
        this.b = viewGroup.findViewById(com.avito.android.messenger.R.id.reply_suggests);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.c = c.lazy(lazyThreadSafetyMode, (Function0) new b(this));
        this.d = c.lazy(lazyThreadSafetyMode, (Function0) new a(this));
        Relay<String> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.f = J1;
        this.g = J1;
        Relay<Unit> J12 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.h = J12;
        this.i = J12;
    }

    public static final void access$addItemView(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl, String str) {
        Objects.requireNonNull(channelReplySuggestsViewImpl);
        View inflate = LayoutInflater.from(access$getContainer$p(channelReplySuggestsViewImpl).getContext()).inflate(R.layout.message_suggest_element, (ViewGroup) access$getContainer$p(channelReplySuggestsViewImpl), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int dimensionPixelSize = access$getContainer$p(channelReplySuggestsViewImpl).getResources().getDimensionPixelSize(R.dimen.message_suggest_panel_elements_horizontal_margin);
        marginLayoutParams.rightMargin = dimensionPixelSize;
        marginLayoutParams.leftMargin = dimensionPixelSize;
        MessageSuggestElementImpl messageSuggestElementImpl = new MessageSuggestElementImpl(inflate);
        messageSuggestElementImpl.setText(str);
        messageSuggestElementImpl.setOnClickListener(new ChannelReplySuggestsViewImpl$addItemView$1(channelReplySuggestsViewImpl, str));
        access$getContainer$p(channelReplySuggestsViewImpl).addView(inflate, access$getContainer$p(channelReplySuggestsViewImpl).getChildCount() - 1, marginLayoutParams);
    }

    public static final ImageButton access$getCloseButton$p(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl) {
        return (ImageButton) channelReplySuggestsViewImpl.d.getValue();
    }

    public static final LinearLayout access$getContainer$p(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl) {
        return (LinearLayout) channelReplySuggestsViewImpl.c.getValue();
    }

    public static final void access$initialize(ChannelReplySuggestsViewImpl channelReplySuggestsViewImpl) {
        Objects.requireNonNull(channelReplySuggestsViewImpl);
        if (!channelReplySuggestsViewImpl.e) {
            access$getCloseButton$p(channelReplySuggestsViewImpl).setOnClickListener(new ChannelReplySuggestsViewImpl$initialize$1(channelReplySuggestsViewImpl));
            channelReplySuggestsViewImpl.e = true;
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public ChannelReplySuggestsView.State getLastRenderedState(@NotNull Renderer<ChannelReplySuggestsView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (ChannelReplySuggestsView.State) this.a.getValue(renderer, k[0]);
    }

    public void render(@NotNull ChannelReplySuggestsView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChannelReplySuggestsView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<ChannelReplySuggestsView.State> renderer, @Nullable ChannelReplySuggestsView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, k[0], state);
    }

    public void doRender(@NotNull Renderer<ChannelReplySuggestsView.State> renderer, @Nullable ChannelReplySuggestsView.State state, @NotNull ChannelReplySuggestsView.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (!Intrinsics.areEqual(state, state2)) {
            if (state != null && (!state.getSuggests().isEmpty())) {
                access$getContainer$p(this).removeViews(0, access$getContainer$p(this).getChildCount() - 1);
            }
            if (!state2.getSuggests().isEmpty()) {
                List<String> suggests = state2.getSuggests();
                if (!this.e) {
                    access$getCloseButton$p(this).setOnClickListener(new ChannelReplySuggestsViewImpl$initialize$1(this));
                    this.e = true;
                }
                for (T t : suggests) {
                    View inflate = LayoutInflater.from(access$getContainer$p(this).getContext()).inflate(R.layout.message_suggest_element, (ViewGroup) access$getContainer$p(this), false);
                    Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
                    ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int dimensionPixelSize = access$getContainer$p(this).getResources().getDimensionPixelSize(R.dimen.message_suggest_panel_elements_horizontal_margin);
                    marginLayoutParams.rightMargin = dimensionPixelSize;
                    marginLayoutParams.leftMargin = dimensionPixelSize;
                    MessageSuggestElementImpl messageSuggestElementImpl = new MessageSuggestElementImpl(inflate);
                    messageSuggestElementImpl.setText(t);
                    messageSuggestElementImpl.setOnClickListener(new ChannelReplySuggestsViewImpl$addItemView$1(this, t));
                    access$getContainer$p(this).addView(inflate, access$getContainer$p(this).getChildCount() - 1, marginLayoutParams);
                }
                View view = this.b;
                Intrinsics.checkNotNullExpressionValue(view, "view");
                if (!Views.isVisible(view)) {
                    ViewGroup viewGroup = this.j;
                    TransitionDsl transitionDsl = new TransitionDsl(new AutoTransition());
                    transitionDsl.addTarget(com.avito.android.messenger.R.id.reply_suggests);
                    TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
                }
                Views.show(this.b);
                return;
            }
            View view2 = this.b;
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            if (Views.isVisible(view2)) {
                ViewGroup viewGroup2 = this.j;
                TransitionDsl transitionDsl2 = new TransitionDsl(new AutoTransition());
                transitionDsl2.addTarget(com.avito.android.messenger.R.id.reply_suggests);
                TransitionManager.beginDelayedTransition(viewGroup2, transitionDsl2.buildTransition());
            }
            Views.hide(this.b);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView
    @NotNull
    public Relay<Unit> getCloseButtonClickedObservable() {
        return this.i;
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView
    @NotNull
    public Relay<String> getReplySuggestClickedObservable() {
        return this.g;
    }
}
