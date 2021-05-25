package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.messenger.api.entity.context.ChannelContext;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u00101\u001a\u00020\u000e\u0012\u0006\u00102\u001a\u00020\u000e\u0012\u0006\u00103\u001a\u00020\u0012\u0012\b\u00104\u001a\u0004\u0018\u00010\u0015\u0012\b\u00105\u001a\u0004\u0018\u00010\u0018\u0012\b\u00106\u001a\u0004\u0018\u00010\u0018\u0012\b\u00107\u001a\u0004\u0018\u00010\u0018\u0012\b\u00108\u001a\u0004\u0018\u00010\u0018\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010>\u001a\u00020'\u0012\b\u0010?\u001a\u0004\u0018\u00010*¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001e\u0010\rJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0010\u0010(\u001a\u00020'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0004\b+\u0010,Jò\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010>\u001a\u00020'2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010*HÆ\u0001¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BHÖ\u0001¢\u0006\u0004\bC\u0010DJ\u001a\u0010F\u001a\u00020\u00182\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bF\u0010GR\u001e\u00105\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u0010H\u001a\u0004\b5\u0010\u001aR\u001e\u00104\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010I\u001a\u0004\bJ\u0010\u0017R\u001e\u00107\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u0010H\u001a\u0004\b7\u0010\u001aR\u001e\u0010;\u001a\u0004\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b;\u0010K\u001a\u0004\bL\u0010$R\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010M\u001a\u0004\bN\u0010\rR\u001c\u0010.\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010O\u001a\u0004\bP\u0010\u0004R$\u00109\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010M\u001a\u0004\bQ\u0010\rR\u001c\u00102\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010R\u001a\u0004\bS\u0010\u0010R\u001c\u00103\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010T\u001a\u0004\bU\u0010\u0014R\u001e\u00106\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010H\u001a\u0004\b6\u0010\u001aR\u001e\u0010:\u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b:\u0010V\u001a\u0004\bW\u0010!R\u001c\u00101\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010R\u001a\u0004\bX\u0010\u0010R\u001e\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010O\u001a\u0004\bY\u0010\u0004R\u001e\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u0010O\u001a\u0004\bZ\u0010\u0004R\u001e\u00108\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u0010H\u001a\u0004\b8\u0010\u001aR\u001e\u0010?\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b?\u0010[\u001a\u0004\b\\\u0010,R\u001e\u0010/\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010]\u001a\u0004\b^\u0010\tR\u001c\u0010-\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010O\u001a\u0004\b_\u0010\u0004R\u001c\u0010>\u001a\u00020'8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010`\u001a\u0004\ba\u0010)¨\u0006d"}, d2 = {"Lru/avito/messenger/api/entity/Channel;", "", "", "toString", "()Ljava/lang/String;", "component1", "component2", "Lru/avito/messenger/api/entity/ChatMessage;", "component3", "()Lru/avito/messenger/api/entity/ChatMessage;", "", "Lru/avito/messenger/api/entity/ChannelUser;", "component4", "()Ljava/util/List;", "", "component5", "()J", "component6", "Lru/avito/messenger/api/entity/context/ChannelContext;", "component7", "()Lru/avito/messenger/api/entity/context/ChannelContext;", "Lru/avito/messenger/api/entity/ReadOnlyState;", "component8", "()Lru/avito/messenger/api/entity/ReadOnlyState;", "", "component9", "()Ljava/lang/Boolean;", "component10", "component11", "component12", "component13", "Lru/avito/messenger/api/entity/context/ChannelContextActions;", "component14", "()Lru/avito/messenger/api/entity/context/ChannelContextActions;", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "component15", "()Lru/avito/messenger/api/entity/context/ChannelDealAction;", "component16", "component17", "Lru/avito/messenger/api/entity/ChannelInfo;", "component18", "()Lru/avito/messenger/api/entity/ChannelInfo;", "Lru/avito/messenger/api/entity/InputState;", "component19", "()Lru/avito/messenger/api/entity/InputState;", "channelId", "type", "lastMessage", "users", "created", ChannelEntity.COLUMN_UPDATED, "context", "readOnlyState", "isDeleted", "isRead", "isSpam", "isAnswered", "tags", MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, "dealAction", "flow", "suspectMessageId", "info", "inputState", "copy", "(Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/ChatMessage;Ljava/util/List;JJLru/avito/messenger/api/entity/context/ChannelContext;Lru/avito/messenger/api/entity/ReadOnlyState;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lru/avito/messenger/api/entity/context/ChannelContextActions;Lru/avito/messenger/api/entity/context/ChannelDealAction;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/ChannelInfo;Lru/avito/messenger/api/entity/InputState;)Lru/avito/messenger/api/entity/Channel;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "Lru/avito/messenger/api/entity/ReadOnlyState;", "getReadOnlyState", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "getDealAction", "Ljava/util/List;", "getUsers", "Ljava/lang/String;", "getType", "getTags", "J", "getUpdated", "Lru/avito/messenger/api/entity/context/ChannelContext;", "getContext", "Lru/avito/messenger/api/entity/context/ChannelContextActions;", "getContextActions", "getCreated", "getFlow", "getSuspectMessageId", "Lru/avito/messenger/api/entity/InputState;", "getInputState", "Lru/avito/messenger/api/entity/ChatMessage;", "getLastMessage", "getChannelId", "Lru/avito/messenger/api/entity/ChannelInfo;", "getInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/ChatMessage;Ljava/util/List;JJLru/avito/messenger/api/entity/context/ChannelContext;Lru/avito/messenger/api/entity/ReadOnlyState;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lru/avito/messenger/api/entity/context/ChannelContextActions;Lru/avito/messenger/api/entity/context/ChannelDealAction;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/ChannelInfo;Lru/avito/messenger/api/entity/InputState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Channel {
    @SerializedName("channelId")
    @NotNull
    private final String channelId;
    @SerializedName("context")
    @NotNull
    private final ChannelContext context;
    @SerializedName(MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS)
    @Nullable
    private final ChannelContextActions contextActions;
    @SerializedName("created")
    private final long created;
    @SerializedName("dealAction")
    @Nullable
    private final ChannelDealAction dealAction;
    @SerializedName("flow")
    @Nullable
    private final String flow;
    @SerializedName("info")
    @NotNull
    private final ChannelInfo info;
    @SerializedName("inputState")
    @Nullable
    private final InputState inputState;
    @SerializedName("isAnswered")
    @Nullable
    private final Boolean isAnswered;
    @SerializedName("isDeleted")
    @Nullable
    private final Boolean isDeleted;
    @SerializedName("isRead")
    @Nullable
    private final Boolean isRead;
    @SerializedName("isSpam")
    @Nullable
    private final Boolean isSpam;
    @SerializedName("lastMessage")
    @Nullable
    private final ChatMessage lastMessage;
    @SerializedName("readOnly")
    @Nullable
    private final ReadOnlyState readOnlyState;
    @SerializedName("suspectMessageId")
    @Nullable
    private final String suspectMessageId;
    @SerializedName("tags")
    @Nullable
    private final List<String> tags;
    @SerializedName("type")
    @NotNull
    private final String type;
    @SerializedName(ChannelEntity.COLUMN_UPDATED)
    private final long updated;
    @SerializedName("users")
    @NotNull
    private final List<ChannelUser> users;

    public Channel(@NotNull String str, @NotNull String str2, @Nullable ChatMessage chatMessage, @NotNull List<ChannelUser> list, long j, long j2, @NotNull ChannelContext channelContext, @Nullable ReadOnlyState readOnlyState2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable List<String> list2, @Nullable ChannelContextActions channelContextActions, @Nullable ChannelDealAction channelDealAction, @Nullable String str3, @Nullable String str4, @NotNull ChannelInfo channelInfo, @Nullable InputState inputState2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "info");
        this.channelId = str;
        this.type = str2;
        this.lastMessage = chatMessage;
        this.users = list;
        this.created = j;
        this.updated = j2;
        this.context = channelContext;
        this.readOnlyState = readOnlyState2;
        this.isDeleted = bool;
        this.isRead = bool2;
        this.isSpam = bool3;
        this.isAnswered = bool4;
        this.tags = list2;
        this.contextActions = channelContextActions;
        this.dealAction = channelDealAction;
        this.flow = str3;
        this.suspectMessageId = str4;
        this.info = channelInfo;
        this.inputState = inputState2;
    }

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, ChatMessage chatMessage, List list, long j, long j2, ChannelContext channelContext, ReadOnlyState readOnlyState2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list2, ChannelContextActions channelContextActions, ChannelDealAction channelDealAction, String str3, String str4, ChannelInfo channelInfo, InputState inputState2, int i, Object obj) {
        return channel.copy((i & 1) != 0 ? channel.channelId : str, (i & 2) != 0 ? channel.type : str2, (i & 4) != 0 ? channel.lastMessage : chatMessage, (i & 8) != 0 ? channel.users : list, (i & 16) != 0 ? channel.created : j, (i & 32) != 0 ? channel.updated : j2, (i & 64) != 0 ? channel.context : channelContext, (i & 128) != 0 ? channel.readOnlyState : readOnlyState2, (i & 256) != 0 ? channel.isDeleted : bool, (i & 512) != 0 ? channel.isRead : bool2, (i & 1024) != 0 ? channel.isSpam : bool3, (i & 2048) != 0 ? channel.isAnswered : bool4, (i & 4096) != 0 ? channel.tags : list2, (i & 8192) != 0 ? channel.contextActions : channelContextActions, (i & 16384) != 0 ? channel.dealAction : channelDealAction, (i & 32768) != 0 ? channel.flow : str3, (i & 65536) != 0 ? channel.suspectMessageId : str4, (i & 131072) != 0 ? channel.info : channelInfo, (i & 262144) != 0 ? channel.inputState : inputState2);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    @Nullable
    public final Boolean component10() {
        return this.isRead;
    }

    @Nullable
    public final Boolean component11() {
        return this.isSpam;
    }

    @Nullable
    public final Boolean component12() {
        return this.isAnswered;
    }

    @Nullable
    public final List<String> component13() {
        return this.tags;
    }

    @Nullable
    public final ChannelContextActions component14() {
        return this.contextActions;
    }

    @Nullable
    public final ChannelDealAction component15() {
        return this.dealAction;
    }

    @Nullable
    public final String component16() {
        return this.flow;
    }

    @Nullable
    public final String component17() {
        return this.suspectMessageId;
    }

    @NotNull
    public final ChannelInfo component18() {
        return this.info;
    }

    @Nullable
    public final InputState component19() {
        return this.inputState;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final ChatMessage component3() {
        return this.lastMessage;
    }

    @NotNull
    public final List<ChannelUser> component4() {
        return this.users;
    }

    public final long component5() {
        return this.created;
    }

    public final long component6() {
        return this.updated;
    }

    @NotNull
    public final ChannelContext component7() {
        return this.context;
    }

    @Nullable
    public final ReadOnlyState component8() {
        return this.readOnlyState;
    }

    @Nullable
    public final Boolean component9() {
        return this.isDeleted;
    }

    @NotNull
    public final Channel copy(@NotNull String str, @NotNull String str2, @Nullable ChatMessage chatMessage, @NotNull List<ChannelUser> list, long j, long j2, @NotNull ChannelContext channelContext, @Nullable ReadOnlyState readOnlyState2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable List<String> list2, @Nullable ChannelContextActions channelContextActions, @Nullable ChannelDealAction channelDealAction, @Nullable String str3, @Nullable String str4, @NotNull ChannelInfo channelInfo, @Nullable InputState inputState2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "info");
        return new Channel(str, str2, chatMessage, list, j, j2, channelContext, readOnlyState2, bool, bool2, bool3, bool4, list2, channelContextActions, channelDealAction, str3, str4, channelInfo, inputState2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.areEqual(this.channelId, channel.channelId) && Intrinsics.areEqual(this.type, channel.type) && Intrinsics.areEqual(this.lastMessage, channel.lastMessage) && Intrinsics.areEqual(this.users, channel.users) && this.created == channel.created && this.updated == channel.updated && Intrinsics.areEqual(this.context, channel.context) && Intrinsics.areEqual(this.readOnlyState, channel.readOnlyState) && Intrinsics.areEqual(this.isDeleted, channel.isDeleted) && Intrinsics.areEqual(this.isRead, channel.isRead) && Intrinsics.areEqual(this.isSpam, channel.isSpam) && Intrinsics.areEqual(this.isAnswered, channel.isAnswered) && Intrinsics.areEqual(this.tags, channel.tags) && Intrinsics.areEqual(this.contextActions, channel.contextActions) && Intrinsics.areEqual(this.dealAction, channel.dealAction) && Intrinsics.areEqual(this.flow, channel.flow) && Intrinsics.areEqual(this.suspectMessageId, channel.suspectMessageId) && Intrinsics.areEqual(this.info, channel.info) && Intrinsics.areEqual(this.inputState, channel.inputState);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final ChannelContext getContext() {
        return this.context;
    }

    @Nullable
    public final ChannelContextActions getContextActions() {
        return this.contextActions;
    }

    public final long getCreated() {
        return this.created;
    }

    @Nullable
    public final ChannelDealAction getDealAction() {
        return this.dealAction;
    }

    @Nullable
    public final String getFlow() {
        return this.flow;
    }

    @NotNull
    public final ChannelInfo getInfo() {
        return this.info;
    }

    @Nullable
    public final InputState getInputState() {
        return this.inputState;
    }

    @Nullable
    public final ChatMessage getLastMessage() {
        return this.lastMessage;
    }

    @Nullable
    public final ReadOnlyState getReadOnlyState() {
        return this.readOnlyState;
    }

    @Nullable
    public final String getSuspectMessageId() {
        return this.suspectMessageId;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final long getUpdated() {
        return this.updated;
    }

    @NotNull
    public final List<ChannelUser> getUsers() {
        return this.users;
    }

    public int hashCode() {
        String str = this.channelId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChatMessage chatMessage = this.lastMessage;
        int hashCode3 = (hashCode2 + (chatMessage != null ? chatMessage.hashCode() : 0)) * 31;
        List<ChannelUser> list = this.users;
        int hashCode4 = (((((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + c.a(this.created)) * 31) + c.a(this.updated)) * 31;
        ChannelContext channelContext = this.context;
        int hashCode5 = (hashCode4 + (channelContext != null ? channelContext.hashCode() : 0)) * 31;
        ReadOnlyState readOnlyState2 = this.readOnlyState;
        int hashCode6 = (hashCode5 + (readOnlyState2 != null ? readOnlyState2.hashCode() : 0)) * 31;
        Boolean bool = this.isDeleted;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isRead;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isSpam;
        int hashCode9 = (hashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isAnswered;
        int hashCode10 = (hashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        List<String> list2 = this.tags;
        int hashCode11 = (hashCode10 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ChannelContextActions channelContextActions = this.contextActions;
        int hashCode12 = (hashCode11 + (channelContextActions != null ? channelContextActions.hashCode() : 0)) * 31;
        ChannelDealAction channelDealAction = this.dealAction;
        int hashCode13 = (hashCode12 + (channelDealAction != null ? channelDealAction.hashCode() : 0)) * 31;
        String str3 = this.flow;
        int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.suspectMessageId;
        int hashCode15 = (hashCode14 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ChannelInfo channelInfo = this.info;
        int hashCode16 = (hashCode15 + (channelInfo != null ? channelInfo.hashCode() : 0)) * 31;
        InputState inputState2 = this.inputState;
        if (inputState2 != null) {
            i = inputState2.hashCode();
        }
        return hashCode16 + i;
    }

    @Nullable
    public final Boolean isAnswered() {
        return this.isAnswered;
    }

    @Nullable
    public final Boolean isDeleted() {
        return this.isDeleted;
    }

    @Nullable
    public final Boolean isRead() {
        return this.isRead;
    }

    @Nullable
    public final Boolean isSpam() {
        return this.isSpam;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Channel { id = ");
        L.append(this.channelId);
        L.append(", updated = ");
        return a.l(L, this.updated, " }");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Channel(String str, String str2, ChatMessage chatMessage, List list, long j, long j2, ChannelContext channelContext, ReadOnlyState readOnlyState2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list2, ChannelContextActions channelContextActions, ChannelDealAction channelDealAction, String str3, String str4, ChannelInfo channelInfo, InputState inputState2, int i, j jVar) {
        this(str, str2, chatMessage, list, j, j2, channelContext, readOnlyState2, bool, bool2, bool3, bool4, list2, (i & 8192) != 0 ? null : channelContextActions, (i & 16384) != 0 ? null : channelDealAction, (32768 & i) != 0 ? null : str3, (i & 65536) != 0 ? null : str4, channelInfo, inputState2);
    }
}
