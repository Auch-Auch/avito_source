package ru.avito.messenger.internal.entity.messenger;

import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessageUpdate;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
import ru.avito.messenger.api.entity.event.OptionsUpdatedEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\r\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0001\r\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/api/entity/MessengerResponse;", "", "sequenceId", "Ljava/lang/String;", "<init>", "()V", "Batch", "Blacklist", "BlacklistRemove", "ChannelsUpdated", "ChatClear", "ChatReadEvent", "ChatTyping", "Message", "MessageReadEvent", "MessageUpdate", "OptionsUpdated", "Session", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lru/avito/messenger/internal/entity/messenger/SystemMessage$Session;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$Message;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$MessageUpdate;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatReadEvent;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatClear;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$MessageReadEvent;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatTyping;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChannelsUpdated;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$OptionsUpdated;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$Blacklist;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$BlacklistRemove;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$Batch;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class SystemMessage implements MessengerResponse {
    @SerializedName("seq")
    @JvmField
    @Nullable
    public String sequenceId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$Batch;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/internal/entity/messenger/BatchNotification;", "value", "Lru/avito/messenger/internal/entity/messenger/BatchNotification;", "getValue", "()Lru/avito/messenger/internal/entity/messenger/BatchNotification;", "", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/Long;Lru/avito/messenger/internal/entity/messenger/BatchNotification;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Batch extends SystemMessage implements SystemEvent<BatchNotification> {
        @SerializedName("id")
        @Nullable
        private final Long id;
        @SerializedName("value")
        @NotNull
        private final BatchNotification value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Batch(@Nullable Long l, @NotNull BatchNotification batchNotification) {
            super(null);
            Intrinsics.checkNotNullParameter(batchNotification, "value");
            this.id = l;
            this.value = batchNotification;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @Nullable
        public Long getId() {
            return this.id;
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public BatchNotification getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$Blacklist;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/BlacklistInfo;", "value", "Lru/avito/messenger/api/entity/event/BlacklistInfo;", "getValue", "()Lru/avito/messenger/api/entity/event/BlacklistInfo;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/event/BlacklistInfo;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Blacklist extends SystemMessage implements SystemEvent<BlacklistInfo> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final BlacklistInfo value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Blacklist(long j, @NotNull BlacklistInfo blacklistInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(blacklistInfo, "value");
            this.id = j;
            this.value = blacklistInfo;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public BlacklistInfo getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$BlacklistRemove;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "value", "Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "<init>", "(JLru/avito/messenger/api/entity/event/BlacklistRemoveEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class BlacklistRemove extends SystemMessage implements SystemEvent<BlacklistRemoveEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final BlacklistRemoveEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlacklistRemove(long j, @NotNull BlacklistRemoveEvent blacklistRemoveEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(blacklistRemoveEvent, "value");
            this.id = j;
            this.value = blacklistRemoveEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public BlacklistRemoveEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChannelsUpdated;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "value", "Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;", "<init>", "(JLru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelsUpdated extends SystemMessage implements SystemEvent<ChannelsUpdatedEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ChannelsUpdatedEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChannelsUpdated(long j, @NotNull ChannelsUpdatedEvent channelsUpdatedEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(channelsUpdatedEvent, "value");
            this.id = j;
            this.value = channelsUpdatedEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ChannelsUpdatedEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatClear;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/ChatClearEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "value", "Lru/avito/messenger/api/entity/event/ChatClearEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/ChatClearEvent;", "<init>", "(JLru/avito/messenger/api/entity/event/ChatClearEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChatClear extends SystemMessage implements SystemEvent<ChatClearEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ChatClearEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatClear(long j, @NotNull ChatClearEvent chatClearEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(chatClearEvent, "value");
            this.id = j;
            this.value = chatClearEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ChatClearEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatReadEvent;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/ReadChatEvent;", "value", "Lru/avito/messenger/api/entity/event/ReadChatEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/ReadChatEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/event/ReadChatEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChatReadEvent extends SystemMessage implements SystemEvent<ReadChatEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ReadChatEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatReadEvent(long j, @NotNull ReadChatEvent readChatEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(readChatEvent, "value");
            this.id = j;
            this.value = readChatEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ReadChatEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$ChatTyping;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "value", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "<init>", "(JLru/avito/messenger/api/entity/event/ChatTypingEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChatTyping extends SystemMessage implements SystemEvent<ChatTypingEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ChatTypingEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTyping(long j, @NotNull ChatTypingEvent chatTypingEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(chatTypingEvent, "value");
            this.id = j;
            this.value = chatTypingEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ChatTypingEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$Message;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/ChatMessage;", "value", "Lru/avito/messenger/api/entity/ChatMessage;", "getValue", "()Lru/avito/messenger/api/entity/ChatMessage;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/ChatMessage;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Message extends SystemMessage implements SystemEvent<ChatMessage> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ChatMessage value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Message(long j, @NotNull ChatMessage chatMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(chatMessage, "value");
            this.id = j;
            this.value = chatMessage;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ChatMessage getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$MessageReadEvent;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/ReadMessageEvent;", "value", "Lru/avito/messenger/api/entity/event/ReadMessageEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/ReadMessageEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/event/ReadMessageEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class MessageReadEvent extends SystemMessage implements SystemEvent<ReadMessageEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ReadMessageEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageReadEvent(long j, @NotNull ReadMessageEvent readMessageEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(readMessageEvent, "value");
            this.id = j;
            this.value = readMessageEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ReadMessageEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$MessageUpdate;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/ChatMessageUpdate;", "value", "Lru/avito/messenger/api/entity/ChatMessageUpdate;", "getValue", "()Lru/avito/messenger/api/entity/ChatMessageUpdate;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/ChatMessageUpdate;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class MessageUpdate extends SystemMessage implements SystemEvent<ChatMessageUpdate> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final ChatMessageUpdate value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageUpdate(long j, @NotNull ChatMessageUpdate chatMessageUpdate) {
            super(null);
            Intrinsics.checkNotNullParameter(chatMessageUpdate, "value");
            this.id = j;
            this.value = chatMessageUpdate;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public ChatMessageUpdate getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$OptionsUpdated;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/api/entity/event/OptionsUpdatedEvent;", "value", "Lru/avito/messenger/api/entity/event/OptionsUpdatedEvent;", "getValue", "()Lru/avito/messenger/api/entity/event/OptionsUpdatedEvent;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/api/entity/event/OptionsUpdatedEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class OptionsUpdated extends SystemMessage implements SystemEvent<OptionsUpdatedEvent> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final OptionsUpdatedEvent value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OptionsUpdated(long j, @NotNull OptionsUpdatedEvent optionsUpdatedEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(optionsUpdatedEvent, "value");
            this.id = j;
            this.value = optionsUpdatedEvent;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public OptionsUpdatedEvent getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$Session;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "Lru/avito/messenger/internal/entity/messenger/UserSession;", "value", "Lru/avito/messenger/internal/entity/messenger/UserSession;", "getValue", "()Lru/avito/messenger/internal/entity/messenger/UserSession;", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(JLru/avito/messenger/internal/entity/messenger/UserSession;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Session extends SystemMessage implements SystemEvent<UserSession> {
        @SerializedName("id")
        private final long id;
        @SerializedName("value")
        @NotNull
        private final UserSession value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Session(long j, @NotNull UserSession userSession) {
            super(null);
            Intrinsics.checkNotNullParameter(userSession, "value");
            this.id = j;
            this.value = userSession;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @Override // ru.avito.messenger.internal.entity.messenger.SystemEvent
        @NotNull
        public UserSession getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0017XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemMessage$Unknown;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "", "toString", "()Ljava/lang/String;", "subtype", "Ljava/lang/String;", "", "id", "J", "getId", "()Ljava/lang/Long;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends SystemMessage {
        @SerializedName("id")
        private final long id;
        @JvmField
        @Nullable
        public final String subtype;
        @JvmField
        @NotNull
        public final String type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unknown(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "type");
            this.type = str;
            this.subtype = str2;
        }

        @Override // ru.avito.messenger.api.entity.MessengerResponse
        @NotNull
        public Long getId() {
            return Long.valueOf(this.id);
        }

        @NotNull
        public String toString() {
            return super.toString() + " => type=" + this.type;
        }
    }

    public SystemMessage() {
    }

    public SystemMessage(j jVar) {
    }
}
