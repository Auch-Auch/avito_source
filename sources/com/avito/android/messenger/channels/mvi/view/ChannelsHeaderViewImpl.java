package com.avito.android.messenger.channels.mvi.view;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import com.avito.android.messenger.channels.mvi.view.ChannelsHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR9\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsHeaderViewImpl;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsHeaderView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "screenTitle", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;)V", "lastRenderedState", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "c", "connectionIndicator", "rootView", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsHeaderViewImpl implements ChannelsHeaderView {
    public static final /* synthetic */ KProperty[] e = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelsHeaderViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", 0))};
    public final Toolbar a;
    public final View b;
    public final View c;
    @Nullable
    public final ReadWriteProperty d = new BackingField(null);

    public ChannelsHeaderViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(R.id.screen_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.connection_indicator);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public ChannelsHeaderPresenter.State getLastRenderedState(@NotNull Renderer<ChannelsHeaderPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (ChannelsHeaderPresenter.State) this.d.getValue(renderer, e[0]);
    }

    public void render(@NotNull ChannelsHeaderPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChannelsHeaderView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<ChannelsHeaderPresenter.State> renderer, @Nullable ChannelsHeaderPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.d.setValue(renderer, e[0], state);
    }

    public void doRender(@NotNull Renderer<ChannelsHeaderPresenter.State> renderer, @Nullable ChannelsHeaderPresenter.State state, @NotNull ChannelsHeaderPresenter.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (state == null || state.isConnecting() != state2.isConnecting()) {
            Toolbar toolbar = this.a;
            TransitionDsl transitionDsl = new TransitionDsl(new Fade());
            transitionDsl.addTarget(this.b);
            transitionDsl.addTarget(this.c);
            Unit unit = Unit.INSTANCE;
            TransitionManager.beginDelayedTransition(toolbar, transitionDsl.buildTransition());
            if (state2.isConnecting()) {
                Views.conceal(this.b);
                Views.show(this.c);
                return;
            }
            Views.conceal(this.c);
            Views.show(this.b);
        }
    }
}
