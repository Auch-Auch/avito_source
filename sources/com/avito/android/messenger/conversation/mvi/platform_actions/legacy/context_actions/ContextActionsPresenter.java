package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\u00020\u0004:\u0001\u0016J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "action", "", "handleAction", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)V", "handleActionConfirmation", "handleCloseAction", "()V", "onConfirmationDialogDismissed", "Landroidx/lifecycle/LiveData;", "", "getErrorMessageStream", "()Landroidx/lifecycle/LiveData;", "errorMessageStream", "Landroid/net/Uri;", "getUrlNavigationStream", "urlNavigationStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ContextActionsPresenter extends LegacyPlatformActionsView.ContentPresenter<State>, MviEntity<State>, DeepLinkProcessingListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "<init>", "()V", "Action", "ActionPayload", "Confirmation", "ConfirmationAlertState", "Empty", "Visible", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Visible;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State implements LegacyPlatformActionsPresenter.ContentData {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0012\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\r¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "", "", "toString", "()Ljava/lang/String;", "", "component1", "()Ljava/lang/CharSequence;", "", "component2", "()Z", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "component3", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "component4", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "title", "isPrimary", "payload", "confirmation", "copy", "(Ljava/lang/CharSequence;ZLcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "getConfirmation", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getTitle", "c", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "getPayload", "<init>", "(Ljava/lang/CharSequence;ZLcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Action {
            @NotNull
            public final CharSequence a;
            public final boolean b;
            @NotNull
            public final ActionPayload c;
            @Nullable
            public final Confirmation d;

            public Action(@NotNull CharSequence charSequence, boolean z, @NotNull ActionPayload actionPayload, @Nullable Confirmation confirmation) {
                Intrinsics.checkNotNullParameter(charSequence, "title");
                Intrinsics.checkNotNullParameter(actionPayload, "payload");
                this.a = charSequence;
                this.b = z;
                this.c = actionPayload;
                this.d = confirmation;
            }

            public static /* synthetic */ Action copy$default(Action action, CharSequence charSequence, boolean z, ActionPayload actionPayload, Confirmation confirmation, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = action.a;
                }
                if ((i & 2) != 0) {
                    z = action.b;
                }
                if ((i & 4) != 0) {
                    actionPayload = action.c;
                }
                if ((i & 8) != 0) {
                    confirmation = action.d;
                }
                return action.copy(charSequence, z, actionPayload, confirmation);
            }

            @NotNull
            public final CharSequence component1() {
                return this.a;
            }

            public final boolean component2() {
                return this.b;
            }

            @NotNull
            public final ActionPayload component3() {
                return this.c;
            }

            @Nullable
            public final Confirmation component4() {
                return this.d;
            }

            @NotNull
            public final Action copy(@NotNull CharSequence charSequence, boolean z, @NotNull ActionPayload actionPayload, @Nullable Confirmation confirmation) {
                Intrinsics.checkNotNullParameter(charSequence, "title");
                Intrinsics.checkNotNullParameter(actionPayload, "payload");
                return new Action(charSequence, z, actionPayload, confirmation);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Action)) {
                    return false;
                }
                Action action = (Action) obj;
                return Intrinsics.areEqual(this.a, action.a) && this.b == action.b && Intrinsics.areEqual(this.c, action.c) && Intrinsics.areEqual(this.d, action.d);
            }

            @Nullable
            public final Confirmation getConfirmation() {
                return this.d;
            }

            @NotNull
            public final ActionPayload getPayload() {
                return this.c;
            }

            @NotNull
            public final CharSequence getTitle() {
                return this.a;
            }

            public int hashCode() {
                CharSequence charSequence = this.a;
                int i = 0;
                int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
                boolean z = this.b;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                ActionPayload actionPayload = this.c;
                int hashCode2 = (i5 + (actionPayload != null ? actionPayload.hashCode() : 0)) * 31;
                Confirmation confirmation = this.d;
                if (confirmation != null) {
                    i = confirmation.hashCode();
                }
                return hashCode2 + i;
            }

            public final boolean isPrimary() {
                return this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Action(title=");
                L.append(this.a);
                L.append(')');
                return L.toString();
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Action(CharSequence charSequence, boolean z, ActionPayload actionPayload, Confirmation confirmation, int i, j jVar) {
                this(charSequence, z, actionPayload, (i & 8) != 0 ? null : confirmation);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007JH\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "component1", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "handler", "channelId", "messageId", "flow", "data", "copy", "(Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ActionPayload;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getFlow", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "getHandler", "e", "getData", "c", "getMessageId", AuthSource.BOOKING_ORDER, "getChannelId", "<init>", "(Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ActionPayload {
            @NotNull
            public final ContextActionHandler a;
            @NotNull
            public final String b;
            @Nullable
            public final String c;
            @Nullable
            public final String d;
            @Nullable
            public final String e;

            public ActionPayload(@NotNull ContextActionHandler contextActionHandler, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
                Intrinsics.checkNotNullParameter(contextActionHandler, "handler");
                Intrinsics.checkNotNullParameter(str, "channelId");
                this.a = contextActionHandler;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = str4;
            }

            public static /* synthetic */ ActionPayload copy$default(ActionPayload actionPayload, ContextActionHandler contextActionHandler, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    contextActionHandler = actionPayload.a;
                }
                if ((i & 2) != 0) {
                    str = actionPayload.b;
                }
                if ((i & 4) != 0) {
                    str2 = actionPayload.c;
                }
                if ((i & 8) != 0) {
                    str3 = actionPayload.d;
                }
                if ((i & 16) != 0) {
                    str4 = actionPayload.e;
                }
                return actionPayload.copy(contextActionHandler, str, str2, str3, str4);
            }

            @NotNull
            public final ContextActionHandler component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @Nullable
            public final String component4() {
                return this.d;
            }

            @Nullable
            public final String component5() {
                return this.e;
            }

            @NotNull
            public final ActionPayload copy(@NotNull ContextActionHandler contextActionHandler, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
                Intrinsics.checkNotNullParameter(contextActionHandler, "handler");
                Intrinsics.checkNotNullParameter(str, "channelId");
                return new ActionPayload(contextActionHandler, str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ActionPayload)) {
                    return false;
                }
                ActionPayload actionPayload = (ActionPayload) obj;
                return Intrinsics.areEqual(this.a, actionPayload.a) && Intrinsics.areEqual(this.b, actionPayload.b) && Intrinsics.areEqual(this.c, actionPayload.c) && Intrinsics.areEqual(this.d, actionPayload.d) && Intrinsics.areEqual(this.e, actionPayload.e);
            }

            @NotNull
            public final String getChannelId() {
                return this.b;
            }

            @Nullable
            public final String getData() {
                return this.e;
            }

            @Nullable
            public final String getFlow() {
                return this.d;
            }

            @NotNull
            public final ContextActionHandler getHandler() {
                return this.a;
            }

            @Nullable
            public final String getMessageId() {
                return this.c;
            }

            public int hashCode() {
                ContextActionHandler contextActionHandler = this.a;
                int i = 0;
                int hashCode = (contextActionHandler != null ? contextActionHandler.hashCode() : 0) * 31;
                String str = this.b;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.c;
                int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.d;
                int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.e;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode4 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ActionPayload(handler=");
                L.append(this.a);
                L.append(", channelId=");
                L.append(this.b);
                L.append(", messageId=");
                L.append(this.c);
                L.append(", flow=");
                L.append(this.d);
                L.append(", data=");
                return a.t(L, this.e, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "title", "message", "okTitle", "cancelTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "c", "getOkTitle", AuthSource.SEND_ABUSE, "getTitle", "d", "getCancelTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Confirmation {
            @Nullable
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;
            @NotNull
            public final String d;

            public Confirmation(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                a.Z0(str2, "message", str3, "okTitle", str4, "cancelTitle");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
            }

            public static /* synthetic */ Confirmation copy$default(Confirmation confirmation, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirmation.a;
                }
                if ((i & 2) != 0) {
                    str2 = confirmation.b;
                }
                if ((i & 4) != 0) {
                    str3 = confirmation.c;
                }
                if ((i & 8) != 0) {
                    str4 = confirmation.d;
                }
                return confirmation.copy(str, str2, str3, str4);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final String component4() {
                return this.d;
            }

            @NotNull
            public final Confirmation copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                Intrinsics.checkNotNullParameter(str2, "message");
                Intrinsics.checkNotNullParameter(str3, "okTitle");
                Intrinsics.checkNotNullParameter(str4, "cancelTitle");
                return new Confirmation(str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Confirmation)) {
                    return false;
                }
                Confirmation confirmation = (Confirmation) obj;
                return Intrinsics.areEqual(this.a, confirmation.a) && Intrinsics.areEqual(this.b, confirmation.b) && Intrinsics.areEqual(this.c, confirmation.c) && Intrinsics.areEqual(this.d, confirmation.d);
            }

            @NotNull
            public final String getCancelTitle() {
                return this.d;
            }

            @NotNull
            public final String getMessage() {
                return this.b;
            }

            @NotNull
            public final String getOkTitle() {
                return this.c;
            }

            @Nullable
            public final String getTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.c;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.d;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Confirmation(title=");
                L.append(this.a);
                L.append(", message=");
                L.append(this.b);
                L.append(", okTitle=");
                L.append(this.c);
                L.append(", cancelTitle=");
                return a.t(L, this.d, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "", "<init>", "()V", "Companion", "Hidden", "Shown", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Shown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class ConfirmationAlertState {
            @NotNull
            public static final Companion Companion = new Companion(null);

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "action", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "createFromAction", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                @NotNull
                public final ConfirmationAlertState createFromAction(@NotNull Action action) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (action.getConfirmation() != null) {
                        return new Shown(action.getConfirmation(), action);
                    }
                    return Hidden.INSTANCE;
                }

                public Companion(j jVar) {
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Hidden extends ConfirmationAlertState {
                @NotNull
                public static final Hidden INSTANCE = new Hidden();

                public Hidden() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "Hidden";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Shown;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "confirmation", "action", "copy", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState$Shown;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;", "getConfirmation", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "getAction", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Confirmation;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Shown extends ConfirmationAlertState {
                @NotNull
                public final Confirmation a;
                @NotNull
                public final Action b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Shown(@NotNull Confirmation confirmation, @NotNull Action action) {
                    super(null);
                    Intrinsics.checkNotNullParameter(confirmation, "confirmation");
                    Intrinsics.checkNotNullParameter(action, "action");
                    this.a = confirmation;
                    this.b = action;
                }

                public static /* synthetic */ Shown copy$default(Shown shown, Confirmation confirmation, Action action, int i, Object obj) {
                    if ((i & 1) != 0) {
                        confirmation = shown.a;
                    }
                    if ((i & 2) != 0) {
                        action = shown.b;
                    }
                    return shown.copy(confirmation, action);
                }

                @NotNull
                public final Confirmation component1() {
                    return this.a;
                }

                @NotNull
                public final Action component2() {
                    return this.b;
                }

                @NotNull
                public final Shown copy(@NotNull Confirmation confirmation, @NotNull Action action) {
                    Intrinsics.checkNotNullParameter(confirmation, "confirmation");
                    Intrinsics.checkNotNullParameter(action, "action");
                    return new Shown(confirmation, action);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Shown)) {
                        return false;
                    }
                    Shown shown = (Shown) obj;
                    return Intrinsics.areEqual(this.a, shown.a) && Intrinsics.areEqual(this.b, shown.b);
                }

                @NotNull
                public final Action getAction() {
                    return this.b;
                }

                @NotNull
                public final Confirmation getConfirmation() {
                    return this.a;
                }

                public int hashCode() {
                    Confirmation confirmation = this.a;
                    int i = 0;
                    int hashCode = (confirmation != null ? confirmation.hashCode() : 0) * 31;
                    Action action = this.b;
                    if (action != null) {
                        i = action.hashCode();
                    }
                    return hashCode + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Shown(actionTitle='");
                    L.append(this.b.getTitle());
                    L.append("', confirmation=");
                    L.append(this.a);
                    L.append(')');
                    return L.toString();
                }
            }

            public ConfirmationAlertState() {
            }

            public ConfirmationAlertState(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData$Unsupported;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State implements LegacyPlatformActionsPresenter.ContentData.Unsupported {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J`\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\bR\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\fR\u0019\u0010\u001c\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u000f¨\u0006<"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Visible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/CharSequence;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "component4", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "component5", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "", "component6", "()Z", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "component7", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "currentUserId", "channelId", "title", "actions", "closeHandler", "isActionInProgress", "confirmationAlertState", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;ZLcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Visible;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannelId", "f", "Z", "c", "Ljava/lang/CharSequence;", "getTitle", "d", "Ljava/util/List;", "getActions", g.a, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;", "getConfirmationAlertState", AuthSource.SEND_ABUSE, "getCurrentUserId", "e", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "getCloseHandler", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;ZLcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$ConfirmationAlertState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Visible extends State {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @Nullable
            public final CharSequence c;
            @NotNull
            public final List<Action> d;
            @Nullable
            public final ContextActionHandler.MethodCall e;
            public final boolean f;
            @NotNull
            public final ConfirmationAlertState g;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Visible(String str, String str2, CharSequence charSequence, List list, ContextActionHandler.MethodCall methodCall, boolean z, ConfirmationAlertState confirmationAlertState, int i, j jVar) {
                this(str, str2, charSequence, list, (i & 16) != 0 ? null : methodCall, (i & 32) != 0 ? false : z, (i & 64) != 0 ? ConfirmationAlertState.Hidden.INSTANCE : confirmationAlertState);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter$State$Visible */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Visible copy$default(Visible visible, String str, String str2, CharSequence charSequence, List list, ContextActionHandler.MethodCall methodCall, boolean z, ConfirmationAlertState confirmationAlertState, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = visible.a;
                }
                if ((i & 2) != 0) {
                    str2 = visible.b;
                }
                if ((i & 4) != 0) {
                    charSequence = visible.c;
                }
                if ((i & 8) != 0) {
                    list = visible.d;
                }
                if ((i & 16) != 0) {
                    methodCall = visible.e;
                }
                if ((i & 32) != 0) {
                    z = visible.f;
                }
                if ((i & 64) != 0) {
                    confirmationAlertState = visible.g;
                }
                return visible.copy(str, str2, charSequence, list, methodCall, z, confirmationAlertState);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final CharSequence component3() {
                return this.c;
            }

            @NotNull
            public final List<Action> component4() {
                return this.d;
            }

            @Nullable
            public final ContextActionHandler.MethodCall component5() {
                return this.e;
            }

            public final boolean component6() {
                return this.f;
            }

            @NotNull
            public final ConfirmationAlertState component7() {
                return this.g;
            }

            @NotNull
            public final Visible copy(@NotNull String str, @NotNull String str2, @Nullable CharSequence charSequence, @NotNull List<Action> list, @Nullable ContextActionHandler.MethodCall methodCall, boolean z, @NotNull ConfirmationAlertState confirmationAlertState) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(str2, "channelId");
                Intrinsics.checkNotNullParameter(list, "actions");
                Intrinsics.checkNotNullParameter(confirmationAlertState, "confirmationAlertState");
                return new Visible(str, str2, charSequence, list, methodCall, z, confirmationAlertState);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Visible)) {
                    return false;
                }
                Visible visible = (Visible) obj;
                return Intrinsics.areEqual(this.a, visible.a) && Intrinsics.areEqual(this.b, visible.b) && Intrinsics.areEqual(this.c, visible.c) && Intrinsics.areEqual(this.d, visible.d) && Intrinsics.areEqual(this.e, visible.e) && this.f == visible.f && Intrinsics.areEqual(this.g, visible.g);
            }

            @NotNull
            public final List<Action> getActions() {
                return this.d;
            }

            @NotNull
            public final String getChannelId() {
                return this.b;
            }

            @Nullable
            public final ContextActionHandler.MethodCall getCloseHandler() {
                return this.e;
            }

            @NotNull
            public final ConfirmationAlertState getConfirmationAlertState() {
                return this.g;
            }

            @NotNull
            public final String getCurrentUserId() {
                return this.a;
            }

            @Nullable
            public final CharSequence getTitle() {
                return this.c;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                CharSequence charSequence = this.c;
                int hashCode3 = (hashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
                List<Action> list = this.d;
                int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                ContextActionHandler.MethodCall methodCall = this.e;
                int hashCode5 = (hashCode4 + (methodCall != null ? methodCall.hashCode() : 0)) * 31;
                boolean z = this.f;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode5 + i2) * 31;
                ConfirmationAlertState confirmationAlertState = this.g;
                if (confirmationAlertState != null) {
                    i = confirmationAlertState.hashCode();
                }
                return i5 + i;
            }

            public final boolean isActionInProgress() {
                return this.f;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Visible(currentUserId=");
                L.append(this.a);
                L.append(", channelId=");
                L.append(this.b);
                L.append(", title=");
                L.append(this.c);
                L.append(", actions=");
                L.append(this.d);
                L.append(", closeHandler=");
                L.append(this.e);
                L.append(", isActionInProgress=");
                L.append(this.f);
                L.append(", confirmationAlertState=");
                L.append(this.g);
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Visible(@NotNull String str, @NotNull String str2, @Nullable CharSequence charSequence, @NotNull List<Action> list, @Nullable ContextActionHandler.MethodCall methodCall, boolean z, @NotNull ConfirmationAlertState confirmationAlertState) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(str2, "channelId");
                Intrinsics.checkNotNullParameter(list, "actions");
                Intrinsics.checkNotNullParameter(confirmationAlertState, "confirmationAlertState");
                this.a = str;
                this.b = str2;
                this.c = charSequence;
                this.d = list;
                this.e = methodCall;
                this.f = z;
                this.g = confirmationAlertState;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    @NotNull
    LiveData<String> getErrorMessageStream();

    @NotNull
    LiveData<Uri> getUrlNavigationStream();

    void handleAction(@NotNull State.Action action);

    void handleActionConfirmation(@NotNull State.Action action);

    void handleCloseAction();

    void onConfirmationDialogDismissed();
}
