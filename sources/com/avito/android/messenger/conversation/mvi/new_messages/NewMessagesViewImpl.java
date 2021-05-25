package com.avito.android.messenger.conversation.mvi.new_messages;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR9\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)V", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "listView", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;)V", "lastRenderedState", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "updatesProposalText", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "updatesProposalView", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NewMessagesViewImpl implements NewMessagesView {
    public static final /* synthetic */ KProperty[] f = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(NewMessagesViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", 0))};
    public final Resources a;
    public final View b;
    public final TextView c;
    @Nullable
    public final ReadWriteProperty d = new BackingField(null);
    public final MessageListView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NewMessagesViewImpl a;

        public a(NewMessagesViewImpl newMessagesViewImpl) {
            this.a = newMessagesViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.e.scrollToBottom();
        }
    }

    public NewMessagesViewImpl(@NotNull View view, @NotNull MessageListView messageListView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(messageListView, "listView");
        this.e = messageListView;
        this.a = view.getResources();
        View findViewById = view.findViewById(R.id.update_proposal);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.update_proposal)");
        this.b = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.messenger_updates_proposal_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "updatesProposalView.find…er_updates_proposal_text)");
        this.c = (TextView) findViewById2;
        findViewById.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public NewMessagesView.State getLastRenderedState(@NotNull Renderer<NewMessagesView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (NewMessagesView.State) this.d.getValue(renderer, f[0]);
    }

    public void render(@NotNull NewMessagesView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        NewMessagesView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<NewMessagesView.State> renderer, @Nullable NewMessagesView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.d.setValue(renderer, f[0], state);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0042: APUT  (r7v4 java.lang.Object[]), (0 ??[int, short, byte, char]), (r8v1 java.lang.String) */
    public void doRender(@NotNull Renderer<NewMessagesView.State> renderer, @Nullable NewMessagesView.State state, @NotNull NewMessagesView.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (state2 instanceof NewMessagesView.State.Loaded) {
            if (Intrinsics.areEqual(state2.isScrolledToBottom(), Boolean.FALSE) && state2.getUnreadMessageCount() > 0) {
                TextView textView = this.c;
                Resources resources = this.a;
                int i = R.string.messenger_new_messages_and_count;
                Object[] objArr = new Object[1];
                objArr[0] = state2.getUnreadMessageCount() > 99 ? "99+" : String.valueOf(state2.getUnreadMessageCount());
                textView.setText(resources.getString(i, objArr));
                Views.show(this.b);
                return;
            }
            Views.hide(this.b);
        } else if (state2 instanceof NewMessagesView.State.Empty) {
            Views.hide(this.b);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
