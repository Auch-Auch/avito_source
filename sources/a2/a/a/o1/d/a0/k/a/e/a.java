package a2.a.a.o1.d.a0.k.a.e;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.ContextAction;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.n.e;
import t6.y.m;
public final class a extends Lambda implements Function1<ContextActionsPresenter.State, ContextActionsPresenter.State> {
    public final /* synthetic */ ContextActionsPresenterImpl a;
    public final /* synthetic */ LegacyPlatformActionsPresenter.ChannelData b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ContextActionsPresenterImpl contextActionsPresenterImpl, LegacyPlatformActionsPresenter.ChannelData channelData) {
        super(1);
        this.a = contextActionsPresenterImpl;
        this.b = channelData;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ContextActionsPresenter.State invoke(ContextActionsPresenter.State state) {
        ContextActionsPresenter.State.ConfirmationAlertState confirmationAlertState;
        ContextActionsPresenter.State.Confirmation confirmation;
        ContextActionsPresenter.State.ActionPayload actionPayload;
        List<String> platforms;
        ContextActionsPresenter.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "oldState");
        LegacyPlatformActionsPresenter.ChannelData channelData = this.b;
        if (channelData == null) {
            return ContextActionsPresenter.State.Empty.INSTANCE;
        }
        PlatformActions platformActions = channelData.actions;
        if (!(platformActions instanceof PlatformActions.Actions)) {
            return ContextActionsPresenter.State.Empty.INSTANCE;
        }
        PlatformSupport platformSupport = platformActions.getPlatformSupport();
        boolean z = true;
        if ((platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) ? true : platforms.contains("android")) {
            PlatformActions.Actions actions = (PlatformActions.Actions) this.b.actions;
            String title = actions.getTitle();
            if (!(title == null || m.isBlank(title)) || !actions.getActions().isEmpty()) {
                z = false;
            }
            if (!z) {
                if (!(state2 instanceof ContextActionsPresenter.State.Visible)) {
                    state2 = null;
                }
                ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state2;
                if (visible == null || (confirmationAlertState = visible.getConfirmationAlertState()) == null) {
                    confirmationAlertState = ContextActionsPresenter.State.ConfirmationAlertState.Hidden.INSTANCE;
                }
                LegacyPlatformActionsPresenter.ChannelData channelData2 = this.b;
                String str = channelData2.currentUserId;
                String str2 = channelData2.channelId;
                String title2 = ((PlatformActions.Actions) channelData2.actions).getTitle();
                LegacyPlatformActionsPresenter.ChannelData channelData3 = this.b;
                PlatformActions.Actions actions2 = (PlatformActions.Actions) channelData3.actions;
                String str3 = channelData3.channelId;
                String str4 = channelData3.flow;
                List<ContextAction> actions3 = actions2.getActions();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(actions3, 10));
                for (T t : actions3) {
                    String title3 = t.getTitle();
                    boolean areEqual = Intrinsics.areEqual(t.getType(), "primary");
                    ContextActionsPresenter.State.ActionPayload actionPayload2 = new ContextActionsPresenter.State.ActionPayload(t.getHandler(), str3, actions2.getMessageId(), str4, t.getAnalytics());
                    ActionConfirmation confirmation2 = t.getConfirmation();
                    if (confirmation2 != null) {
                        confirmation = new ContextActionsPresenter.State.Confirmation(confirmation2.getTitle(), confirmation2.getMessage(), confirmation2.getConfirmButtonText(), confirmation2.getCancelButtonText());
                        actionPayload = actionPayload2;
                    } else {
                        actionPayload = actionPayload2;
                        confirmation = null;
                    }
                    arrayList.add(new ContextActionsPresenter.State.Action(title3, areEqual, actionPayload, confirmation));
                    actions2 = actions2;
                    str3 = str3;
                }
                PlatformActions.ExpandableData expandableData = ((PlatformActions.Actions) this.b.actions).getExpandableData();
                return new ContextActionsPresenter.State.Visible(str, str2, title2, arrayList, expandableData != null ? expandableData.getCancelHandler() : null, false, confirmationAlertState);
            }
        }
        return ContextActionsPresenter.State.Empty.INSTANCE;
    }
}
