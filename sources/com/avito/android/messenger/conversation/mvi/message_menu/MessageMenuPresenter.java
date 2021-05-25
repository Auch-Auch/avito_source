package com.avito.android.messenger.conversation.mvi.message_menu;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.config.MessengerConfig;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "", "showMenuForMessage", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "", "url", "showMenuForLink", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "dismissMenu", "()V", "actionId", "onActionClicked", "(Ljava/lang/String;)V", "onActionConfirmed", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageMenuPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "", "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "()Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "<init>", "()V", "Empty", "Hidden", "Shown", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "()Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State
            @Nullable
            public MessengerConfig getConfig() {
                return null;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "copy", "(Lru/avito/messenger/config/MessengerConfig;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Hidden;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "<init>", "(Lru/avito/messenger/config/MessengerConfig;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends State {
            @NotNull
            public final MessengerConfig a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Hidden(@NotNull MessengerConfig messengerConfig) {
                super(null);
                Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                this.a = messengerConfig;
            }

            public static /* synthetic */ Hidden copy$default(Hidden hidden, MessengerConfig messengerConfig, int i, Object obj) {
                if ((i & 1) != 0) {
                    messengerConfig = hidden.getConfig();
                }
                return hidden.copy(messengerConfig);
            }

            @NotNull
            public final MessengerConfig component1() {
                return getConfig();
            }

            @NotNull
            public final Hidden copy(@NotNull MessengerConfig messengerConfig) {
                Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                return new Hidden(messengerConfig);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Hidden) && Intrinsics.areEqual(getConfig(), ((Hidden) obj).getConfig());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State
            @NotNull
            public MessengerConfig getConfig() {
                return this.a;
            }

            public int hashCode() {
                MessengerConfig config = getConfig();
                if (config != null) {
                    return config.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Hidden(config=");
                L.append(getConfig());
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "()Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "getContextData", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "()V", "Confirmation", "Menu", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Menu;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Confirmation;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Shown extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\rR\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Confirmation;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "", "component3", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "component4", "()Lcom/avito/android/remote/model/messenger/ActionConfirmation;", Navigation.CONFIG, "contextData", "actionId", "confirmation", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ActionConfirmation;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Confirmation;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getActionId", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "d", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "getConfirmation", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "getContextData", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ActionConfirmation;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Confirmation extends Shown {
                @NotNull
                public final MessengerConfig a;
                @NotNull
                public final MessageContextData b;
                @NotNull
                public final String c;
                @NotNull
                public final ActionConfirmation d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Confirmation(@NotNull MessengerConfig messengerConfig, @NotNull MessageContextData messageContextData, @NotNull String str, @NotNull ActionConfirmation actionConfirmation) {
                    super(null);
                    Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                    Intrinsics.checkNotNullParameter(messageContextData, "contextData");
                    Intrinsics.checkNotNullParameter(str, "actionId");
                    Intrinsics.checkNotNullParameter(actionConfirmation, "confirmation");
                    this.a = messengerConfig;
                    this.b = messageContextData;
                    this.c = str;
                    this.d = actionConfirmation;
                }

                public static /* synthetic */ Confirmation copy$default(Confirmation confirmation, MessengerConfig messengerConfig, MessageContextData messageContextData, String str, ActionConfirmation actionConfirmation, int i, Object obj) {
                    if ((i & 1) != 0) {
                        messengerConfig = confirmation.getConfig();
                    }
                    if ((i & 2) != 0) {
                        messageContextData = confirmation.getContextData();
                    }
                    if ((i & 4) != 0) {
                        str = confirmation.c;
                    }
                    if ((i & 8) != 0) {
                        actionConfirmation = confirmation.d;
                    }
                    return confirmation.copy(messengerConfig, messageContextData, str, actionConfirmation);
                }

                @NotNull
                public final MessengerConfig component1() {
                    return getConfig();
                }

                @NotNull
                public final MessageContextData component2() {
                    return getContextData();
                }

                @NotNull
                public final String component3() {
                    return this.c;
                }

                @NotNull
                public final ActionConfirmation component4() {
                    return this.d;
                }

                @NotNull
                public final Confirmation copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageContextData messageContextData, @NotNull String str, @NotNull ActionConfirmation actionConfirmation) {
                    Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                    Intrinsics.checkNotNullParameter(messageContextData, "contextData");
                    Intrinsics.checkNotNullParameter(str, "actionId");
                    Intrinsics.checkNotNullParameter(actionConfirmation, "confirmation");
                    return new Confirmation(messengerConfig, messageContextData, str, actionConfirmation);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Confirmation)) {
                        return false;
                    }
                    Confirmation confirmation = (Confirmation) obj;
                    return Intrinsics.areEqual(getConfig(), confirmation.getConfig()) && Intrinsics.areEqual(getContextData(), confirmation.getContextData()) && Intrinsics.areEqual(this.c, confirmation.c) && Intrinsics.areEqual(this.d, confirmation.d);
                }

                @NotNull
                public final String getActionId() {
                    return this.c;
                }

                @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State.Shown, com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State
                @NotNull
                public MessengerConfig getConfig() {
                    return this.a;
                }

                @NotNull
                public final ActionConfirmation getConfirmation() {
                    return this.d;
                }

                @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State.Shown
                @NotNull
                public MessageContextData getContextData() {
                    return this.b;
                }

                public int hashCode() {
                    MessengerConfig config = getConfig();
                    int i = 0;
                    int hashCode = (config != null ? config.hashCode() : 0) * 31;
                    MessageContextData contextData = getContextData();
                    int hashCode2 = (hashCode + (contextData != null ? contextData.hashCode() : 0)) * 31;
                    String str = this.c;
                    int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                    ActionConfirmation actionConfirmation = this.d;
                    if (actionConfirmation != null) {
                        i = actionConfirmation.hashCode();
                    }
                    return hashCode3 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Confirmation(config=");
                    L.append(getConfig());
                    L.append(", contextData=");
                    L.append(getContextData());
                    L.append(", actionId=");
                    L.append(this.c);
                    L.append(", confirmation=");
                    L.append(this.d);
                    L.append(")");
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Menu;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "component3", "()Ljava/util/List;", Navigation.CONFIG, "contextData", "menuItems", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;Ljava/util/List;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State$Shown$Menu;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getMenuItems", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "getContextData", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Menu extends Shown {
                @NotNull
                public final MessengerConfig a;
                @NotNull
                public final MessageContextData b;
                @NotNull
                public final List<MenuElement> c;

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.messenger.conversation.mvi.message_menu.MenuElement> */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Menu(@NotNull MessengerConfig messengerConfig, @NotNull MessageContextData messageContextData, @NotNull List<? extends MenuElement> list) {
                    super(null);
                    Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                    Intrinsics.checkNotNullParameter(messageContextData, "contextData");
                    Intrinsics.checkNotNullParameter(list, "menuItems");
                    this.a = messengerConfig;
                    this.b = messageContextData;
                    this.c = list;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter$State$Shown$Menu */
                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Menu copy$default(Menu menu, MessengerConfig messengerConfig, MessageContextData messageContextData, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        messengerConfig = menu.getConfig();
                    }
                    if ((i & 2) != 0) {
                        messageContextData = menu.getContextData();
                    }
                    if ((i & 4) != 0) {
                        list = menu.c;
                    }
                    return menu.copy(messengerConfig, messageContextData, list);
                }

                @NotNull
                public final MessengerConfig component1() {
                    return getConfig();
                }

                @NotNull
                public final MessageContextData component2() {
                    return getContextData();
                }

                @NotNull
                public final List<MenuElement> component3() {
                    return this.c;
                }

                @NotNull
                public final Menu copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageContextData messageContextData, @NotNull List<? extends MenuElement> list) {
                    Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
                    Intrinsics.checkNotNullParameter(messageContextData, "contextData");
                    Intrinsics.checkNotNullParameter(list, "menuItems");
                    return new Menu(messengerConfig, messageContextData, list);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Menu)) {
                        return false;
                    }
                    Menu menu = (Menu) obj;
                    return Intrinsics.areEqual(getConfig(), menu.getConfig()) && Intrinsics.areEqual(getContextData(), menu.getContextData()) && Intrinsics.areEqual(this.c, menu.c);
                }

                @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State.Shown, com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State
                @NotNull
                public MessengerConfig getConfig() {
                    return this.a;
                }

                @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State.Shown
                @NotNull
                public MessageContextData getContextData() {
                    return this.b;
                }

                @NotNull
                public final List<MenuElement> getMenuItems() {
                    return this.c;
                }

                public int hashCode() {
                    MessengerConfig config = getConfig();
                    int i = 0;
                    int hashCode = (config != null ? config.hashCode() : 0) * 31;
                    MessageContextData contextData = getContextData();
                    int hashCode2 = (hashCode + (contextData != null ? contextData.hashCode() : 0)) * 31;
                    List<MenuElement> list = this.c;
                    if (list != null) {
                        i = list.hashCode();
                    }
                    return hashCode2 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Menu(config=");
                    L.append(getConfig());
                    L.append(", contextData=");
                    L.append(getContextData());
                    L.append(", menuItems=");
                    return a.w(L, this.c, ")");
                }
            }

            public Shown() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter.State
            @NotNull
            public abstract MessengerConfig getConfig();

            @NotNull
            public abstract MessageContextData getContextData();

            public Shown(j jVar) {
                super(null);
            }
        }

        public State() {
        }

        @Nullable
        public abstract MessengerConfig getConfig();

        public State(j jVar) {
        }
    }

    void dismissMenu();

    void onActionClicked(@NotNull String str);

    void onActionConfirmed();

    void showMenuForLink(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str);

    void showMenuForMessage(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage);
}
