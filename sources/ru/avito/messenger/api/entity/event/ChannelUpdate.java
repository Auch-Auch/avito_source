package ru.avito.messenger.api.entity.event;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.messenger.api.entity.InputState;
import ru.avito.messenger.api.entity.ReadOnlyState;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"Bµ\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010!R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lru/avito/messenger/api/entity/event/ChannelUpdate;", "", "", "isSpam", "Ljava/lang/Boolean;", "Lru/avito/messenger/api/entity/event/ChannelUpdate$Suspect;", "suspect", "Lru/avito/messenger/api/entity/event/ChannelUpdate$Suspect;", "Lru/avito/messenger/api/entity/InputState;", "inputState", "Lru/avito/messenger/api/entity/InputState;", "isAnswered", "", "", "tags", "Ljava/util/List;", "", ChannelEntity.COLUMN_UPDATED, "Ljava/lang/Long;", "removedTags", "isRead", "addedTags", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "dealAction", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "Lru/avito/messenger/api/entity/context/ChannelContextActions;", MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, "Lru/avito/messenger/api/entity/context/ChannelContextActions;", "isDeleted", "Lru/avito/messenger/api/entity/ReadOnlyState;", "readOnlyState", "Lru/avito/messenger/api/entity/ReadOnlyState;", "<init>", "(Ljava/lang/Long;Lru/avito/messenger/api/entity/ReadOnlyState;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lru/avito/messenger/api/entity/context/ChannelDealAction;Lru/avito/messenger/api/entity/event/ChannelUpdate$Suspect;Lru/avito/messenger/api/entity/InputState;Lru/avito/messenger/api/entity/context/ChannelContextActions;)V", "Suspect", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelUpdate {
    @SerializedName("addedTags")
    @JvmField
    @Nullable
    public final List<String> addedTags;
    @SerializedName(MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS)
    @JvmField
    @Nullable
    public final ChannelContextActions contextActions;
    @SerializedName("dealAction")
    @JvmField
    @Nullable
    public final ChannelDealAction dealAction;
    @SerializedName("inputState")
    @JvmField
    @Nullable
    public final InputState inputState;
    @SerializedName("isAnswered")
    @JvmField
    @Nullable
    public final Boolean isAnswered;
    @SerializedName("isDeleted")
    @JvmField
    @Nullable
    public final Boolean isDeleted;
    @SerializedName("isRead")
    @JvmField
    @Nullable
    public final Boolean isRead;
    @SerializedName("isSpam")
    @JvmField
    @Nullable
    public final Boolean isSpam;
    @SerializedName("readOnly")
    @JvmField
    @Nullable
    public final ReadOnlyState readOnlyState;
    @SerializedName("removedTags")
    @JvmField
    @Nullable
    public final List<String> removedTags;
    @SerializedName("suspect")
    @JvmField
    @Nullable
    public final Suspect suspect;
    @SerializedName("tags")
    @JvmField
    @Nullable
    public final List<String> tags;
    @SerializedName(ChannelEntity.COLUMN_UPDATED)
    @JvmField
    @Nullable
    public final Long updated;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/avito/messenger/api/entity/event/ChannelUpdate$Suspect;", "", "", "messageId", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Suspect {
        @SerializedName("messageId")
        @JvmField
        @Nullable
        public final String messageId;

        public Suspect(@Nullable String str) {
            this.messageId = str;
        }
    }

    public ChannelUpdate() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public ChannelUpdate(@Nullable Long l, @Nullable ReadOnlyState readOnlyState2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable ChannelDealAction channelDealAction, @Nullable Suspect suspect2, @Nullable InputState inputState2, @Nullable ChannelContextActions channelContextActions) {
        this.updated = l;
        this.readOnlyState = readOnlyState2;
        this.isDeleted = bool;
        this.isRead = bool2;
        this.isSpam = bool3;
        this.isAnswered = bool4;
        this.tags = list;
        this.removedTags = list2;
        this.addedTags = list3;
        this.dealAction = channelDealAction;
        this.suspect = suspect2;
        this.inputState = inputState2;
        this.contextActions = channelContextActions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelUpdate(Long l, ReadOnlyState readOnlyState2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list, List list2, List list3, ChannelDealAction channelDealAction, Suspect suspect2, InputState inputState2, ChannelContextActions channelContextActions, int i, j jVar) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : readOnlyState2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : bool4, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? null : channelDealAction, (i & 1024) != 0 ? null : suspect2, (i & 2048) != 0 ? null : inputState2, (i & 4096) == 0 ? channelContextActions : null);
    }
}
