package com.avito.android.messenger.conversation.adapter.spam_actions;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessageSpamActionsShownEvent;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenterImpl;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView;", "view", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsView;Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;I)V", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "trackedMessageIds", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SpamActionsPresenterImpl implements SpamActionsPresenter {
    public final Set<String> a = new LinkedHashSet();
    public final Lazy<SpamActionsPresenter.Listener> b;
    public final Analytics c;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                if (((ChannelItem.SpamActions) this.c).getState() instanceof ChannelItem.SpamActions.State.Static) {
                    ((SpamActionsPresenter.Listener) ((SpamActionsPresenterImpl) this.b).b.get()).onSpamActionClicked((ChannelItem.SpamActions) this.c, true);
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                if (((ChannelItem.SpamActions) this.c).getState() instanceof ChannelItem.SpamActions.State.Static) {
                    ((SpamActionsPresenter.Listener) ((SpamActionsPresenterImpl) this.b).b.get()).onSpamActionClicked((ChannelItem.SpamActions) this.c, false);
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public SpamActionsPresenterImpl(@NotNull Lazy<SpamActionsPresenter.Listener> lazy, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = lazy;
        this.c = analytics;
    }

    public void bindView(@NotNull SpamActionsView spamActionsView, @NotNull ChannelItem.SpamActions spamActions, int i) {
        Intrinsics.checkNotNullParameter(spamActionsView, "view");
        Intrinsics.checkNotNullParameter(spamActions, "item");
        spamActionsView.showGroupDivider(true);
        spamActionsView.render(spamActions, new a(0, this, spamActions), new a(1, this, spamActions));
        if (!this.a.contains(spamActions.getMessageRemoteId())) {
            this.c.track(new MessageSpamActionsShownEvent(spamActions.getChannelId(), spamActions.getMessageRemoteId()));
            this.a.add(spamActions.getMessageRemoteId());
        }
    }
}
