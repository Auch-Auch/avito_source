package com.avito.android.messenger.support;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import com.avito.android.messenger.support.SupportChatFormView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR9\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormViewImpl;", "Lcom/avito/android/messenger/support/SupportChatFormView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;)V", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;)V", "lastRenderedState", "Lcom/avito/android/lib/design/button/Button;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/button/Button;", "getSendButton", "()Lcom/avito/android/lib/design/button/Button;", "sendButton", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getSendStream", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "sendStream", "Lcom/avito/android/lib/design/input/Input;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/input/Input;", "getInput", "()Lcom/avito/android/lib/design/input/Input;", "input", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChatFormViewImpl implements SupportChatFormView {
    public static final /* synthetic */ KProperty[] e = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(SupportChatFormViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", 0))};
    @NotNull
    public final Input a;
    @NotNull
    public final Button b;
    @NotNull
    public final PublishRelay<CharSequence> c;
    @Nullable
    public final ReadWriteProperty d = new BackingField(null);

    public SupportChatFormViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.messenger_support_chat_form_input);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.m…_support_chat_form_input)");
        Input input = (Input) findViewById;
        this.a = input;
        View findViewById2 = view.findViewById(R.id.messenger_support_chat_form_send_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.m…rt_chat_form_send_button)");
        Button button = (Button) findViewById2;
        this.b = button;
        PublishRelay<CharSequence> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        input.addTextChangedListener(new TextWatcher(this) { // from class: com.avito.android.messenger.support.SupportChatFormViewImpl.1
            public final /* synthetic */ SupportChatFormViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "newText");
                this.a.getSendButton().setEnabled(!m.isBlank(editable));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        button.setOnClickListener(new View.OnClickListener(this) { // from class: com.avito.android.messenger.support.SupportChatFormViewImpl.2
            public long a;
            public final /* synthetic */ SupportChatFormViewImpl b;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.b = r1;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(@Nullable View view2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.a >= ((long) 1000)) {
                    this.a = elapsedRealtime;
                    Editable text = this.b.getInput().m90getText();
                    if (!(text == null || m.isBlank(text))) {
                        this.b.getSendButton().setEnabled(false);
                        this.b.getSendButton().setLoading(true);
                        this.b.getInput().setEnabled(false);
                        PublishRelay<CharSequence> sendStream = this.b.getSendStream();
                        Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
                        sendStream.accept(text);
                    }
                }
            }
        });
    }

    @NotNull
    public final Input getInput() {
        return this.a;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public SupportChatFormPresenter.State getLastRenderedState(@NotNull Renderer<SupportChatFormPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (SupportChatFormPresenter.State) this.d.getValue(renderer, e[0]);
    }

    @NotNull
    public final Button getSendButton() {
        return this.b;
    }

    public void render(@NotNull SupportChatFormPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SupportChatFormView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<SupportChatFormPresenter.State> renderer, @Nullable SupportChatFormPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.d.setValue(renderer, e[0], state);
    }

    public void doRender(@NotNull Renderer<SupportChatFormPresenter.State> renderer, @Nullable SupportChatFormPresenter.State state, @NotNull SupportChatFormPresenter.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        SupportChatFormPresenter.SendingState sendingState = state2.getSendingState();
        SupportChatFormPresenter.SendingState.Idle idle = SupportChatFormPresenter.SendingState.Idle.INSTANCE;
        if (Intrinsics.areEqual(sendingState, idle)) {
            if ((state != null ? state.getSendingState() : null) != idle) {
                Button button = this.b;
                Editable text = this.a.m90getText();
                button.setEnabled(!(text == null || m.isBlank(text)));
                this.b.setLoading(false);
                this.a.setEnabled(true);
            }
        } else if (!(sendingState instanceof SupportChatFormPresenter.SendingState.InProgress)) {
            boolean z = sendingState instanceof SupportChatFormPresenter.SendingState.Success;
        }
    }

    @Override // com.avito.android.messenger.support.SupportChatFormView
    @NotNull
    public PublishRelay<CharSequence> getSendStream() {
        return this.c;
    }
}
