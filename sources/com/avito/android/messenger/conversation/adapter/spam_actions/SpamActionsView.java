package com.avito.android.messenger.conversation.adapter.spam_actions;

import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bJ3\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "actions", "Lkotlin/Function0;", "", "onYesClicked", "onNoClicked", "render", "(Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SpamActionsView extends ItemView, MessageViewGroupDivider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SpamActionsView spamActionsView) {
            ItemView.DefaultImpls.onUnbind(spamActionsView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b$\u0010%J3\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "actions", "Lkotlin/Function0;", "", "onYesClicked", "onNoClicked", "render", "(Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "", "show", "showGroupDivider", "(Z)V", "w", "Z", "disableClicks", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "noButton", "s", "yesButton", "Ljava/lang/Runnable;", VKApiConst.VERSION, "Ljava/lang/Runnable;", "showProgressRunnable", "Landroid/view/View;", "u", "Landroid/view/View;", "bottomDivider", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements SpamActionsView, MessageViewGroupDivider {
        public final Button s;
        public final Button t;
        public final View u;
        public Runnable v;
        public boolean w;
        public final /* synthetic */ MessageViewGroupDividerDelegate x;

        /* compiled from: java-style lambda group */
        public static final class a implements View.OnClickListener {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ Object c;

            public a(int i, Object obj, Object obj2) {
                this.a = i;
                this.b = obj;
                this.c = obj2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i = this.a;
                if (i != 0) {
                    if (i != 1) {
                        throw null;
                    } else if (!((Impl) this.b).w) {
                        ((Impl) this.b).w = true;
                        ((Function0) this.c).invoke();
                    }
                } else if (!((Impl) this.b).w) {
                    ((Impl) this.b).w = true;
                    ((Function0) this.c).invoke();
                }
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ ChannelItem.SpamActions b;

            public b(Impl impl, ChannelItem.SpamActions spamActions) {
                this.a = impl;
                this.b = spamActions;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (((ChannelItem.SpamActions.State.InProgress) this.b.getState()).isSpam()) {
                    this.a.s.setLoading(true);
                    this.a.s.setEnabled(true);
                    this.a.t.setEnabled(false);
                    return;
                }
                this.a.t.setLoading(true);
                this.a.t.setEnabled(true);
                this.a.s.setEnabled(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.x = new MessageViewGroupDividerDelegate(view);
            View findViewById = view.findViewById(R.id.spam_actions_yes_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.spam_actions_yes_button)");
            this.s = (Button) findViewById;
            View findViewById2 = view.findViewById(R.id.spam_actions_no_button);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.spam_actions_no_button)");
            this.t = (Button) findViewById2;
            View findViewById3 = view.findViewById(R.id.spam_actions_bottom_divider);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.s…m_actions_bottom_divider)");
            this.u = findViewById3;
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            Runnable runnable = this.v;
            if (runnable != null) {
                this.itemView.removeCallbacks(runnable);
            }
            this.v = null;
            this.w = false;
        }

        @Override // com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsView
        public void render(@NotNull ChannelItem.SpamActions spamActions, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(spamActions, "actions");
            Intrinsics.checkNotNullParameter(function0, "onYesClicked");
            Intrinsics.checkNotNullParameter(function02, "onNoClicked");
            Views.setVisible(this.u, spamActions.getSplitsUserGroup());
            ChannelItem.SpamActions.State state = spamActions.getState();
            if (Intrinsics.areEqual(state, ChannelItem.SpamActions.State.Static.INSTANCE)) {
                Runnable runnable = this.v;
                if (runnable != null) {
                    this.itemView.removeCallbacks(runnable);
                }
                this.v = null;
                this.w = false;
                this.s.setLoading(false);
                this.t.setLoading(false);
                this.s.setEnabled(true);
                this.t.setEnabled(true);
            } else if (state instanceof ChannelItem.SpamActions.State.InProgress) {
                b bVar = new b(this, spamActions);
                this.v = bVar;
                this.itemView.postDelayed(bVar, 300);
            }
            this.s.setOnClickListener(new a(0, this, function0));
            this.t.setOnClickListener(new a(1, this, function02));
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.x.showGroupDivider(z);
        }
    }

    void render(@NotNull ChannelItem.SpamActions spamActions, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
