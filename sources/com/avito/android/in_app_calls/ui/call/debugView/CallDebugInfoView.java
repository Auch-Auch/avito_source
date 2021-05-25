package com.avito.android.in_app_calls.ui.call.debugView;

import a2.b.a.a.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR9\u0010\u0010\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00028V@VX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013¨\u0006("}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/debugView/CallDebugInfoView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "Landroid/widget/FrameLayout;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "<set-?>", "f", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "lastRenderedState", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "callStateView", "", "", "e", "Ljava/util/List;", "callStateHistory", "d", "callResultView", AuthSource.SEND_ABUSE, "callIdView", AuthSource.BOOKING_ORDER, "receiverIdView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallDebugInfoView extends FrameLayout implements Renderer<CallPresenter.State> {
    public static final /* synthetic */ KProperty[] g = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(CallDebugInfoView.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", 0))};
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final List<String> e;
    @Nullable
    public final ReadWriteProperty f;

    @JvmOverloads
    public CallDebugInfoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public CallDebugInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallDebugInfoView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public CallPresenter.State getLastRenderedState(@NotNull Renderer<CallPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (CallPresenter.State) this.f.getValue(renderer, g[0]);
    }

    public void render(@NotNull CallPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Renderer.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<CallPresenter.State> renderer, @Nullable CallPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.f.setValue(renderer, g[0], state);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CallDebugInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = new ArrayList();
        this.f = new BackingField(null);
        View inflate = View.inflate(context, R.layout.call_debug_info_view, this);
        View findViewById = inflate.findViewById(R.id.call_debug_info_callid);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.call_debug_info_callid)");
        this.a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.call_debug_info_receiver);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…call_debug_info_receiver)");
        this.b = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.call_debug_info_state);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.call_debug_info_state)");
        this.c = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.call_debug_info_result);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.call_debug_info_result)");
        this.d = (TextView) findViewById4;
    }

    public void doRender(@NotNull Renderer<CallPresenter.State> renderer, @Nullable CallPresenter.State state, @NotNull CallPresenter.State state2) {
        String str;
        CallerInfo caller;
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        AppCallInfo call = state2.getCall();
        String callId = call != null ? call.getCallId() : null;
        String str2 = "";
        if (callId == null) {
            callId = str2;
        }
        AppCallInfo call2 = state2.getCall();
        String contact = (call2 == null || (caller = call2.getCaller()) == null) ? null : caller.getContact();
        if (contact != null) {
            str2 = contact;
        }
        String substringBefore$default = StringsKt__StringsKt.substringBefore$default(str2, "@", (String) null, 2, (Object) null);
        if (state2 instanceof CallPresenter.State.Connected) {
            str = ((CallPresenter.State.Connected) state2).isReconnecting() ? "Reconnecting" : "Connected";
        } else if (state2 instanceof CallPresenter.State.Finished) {
            str = "Finished";
        } else {
            str = state2.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "this.javaClass.simpleName");
        }
        this.e.add(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Render debug info, id=");
        sb.append(callId);
        sb.append(", receiver=");
        Logs.debug$default("CallDebugInfoView", a.u(sb, substringBefore$default, " state=", str), null, 4, null);
        TextView textView = this.a;
        textView.setText("CallId: " + callId);
        TextView textView2 = this.b;
        textView2.setText("Receiver: " + substringBefore$default);
        this.c.setText(CollectionsKt___CollectionsKt.joinToString$default(this.e, "->", null, null, 0, null, null, 62, null));
        if (state2 instanceof CallPresenter.State.Finished) {
            TextView textView3 = this.d;
            StringBuilder L = a.L("Result: ");
            L.append(((CallPresenter.State.Finished) state2).getResult().getClass().getSimpleName());
            textView3.setText(L.toString());
            Views.show(this.d);
            return;
        }
        Views.hide(this.d);
    }
}
