package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0007\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u00103\u001a\u00020\u000e\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u0012\u0012\b\u00106\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u00107\u001a\u00020\u0018\u0012\u0006\u00108\u001a\u00020\u0018\u0012\u0006\u00109\u001a\u00020\u0018\u0012\u0006\u0010:\u001a\u00020\u0018\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e\u0012\b\u0010<\u001a\u0004\u0018\u00010!\u0012\b\u0010=\u001a\u0004\u0018\u00010$\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010@\u001a\u00020)\u0012\b\u0010A\u001a\u0004\u0018\u00010,¢\u0006\u0004\bm\u0010nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010*\u001a\u00020)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\b-\u0010.Jè\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u00122\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020\u00182\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010@\u001a\u00020)2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010,HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010E\u001a\u00020DHÖ\u0001¢\u0006\u0004\bE\u0010FJ\u001a\u0010I\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010GHÖ\u0003¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020DHÖ\u0001¢\u0006\u0004\bK\u0010FJ \u0010P\u001a\u00020O2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020DHÖ\u0001¢\u0006\u0004\bP\u0010QR\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010R\u001a\u0004\bS\u0010\u0004R\u0019\u00107\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010T\u001a\u0004\b7\u0010\u001aR\u0019\u00105\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010U\u001a\u0004\bV\u0010\u0014R\u0019\u0010@\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010W\u001a\u0004\bX\u0010+R\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010Y\u001a\u0004\bZ\u0010 R\u0019\u00103\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010[\u001a\u0004\b\\\u0010\u0010R\u001b\u0010=\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010]\u001a\u0004\b^\u0010&R\u001b\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010R\u001a\u0004\b_\u0010\u0004R\u001b\u00101\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010`\u001a\u0004\ba\u0010\tR\u0019\u00108\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010T\u001a\u0004\b8\u0010\u001aR\u0019\u0010:\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010T\u001a\u0004\b:\u0010\u001aR\u001b\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010R\u001a\u0004\bb\u0010\u0004R\u0019\u00109\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010T\u001a\u0004\b9\u0010\u001aR\u001b\u0010<\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010c\u001a\u0004\bd\u0010#R\u001b\u0010A\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010e\u001a\u0004\bf\u0010.R\u0019\u00104\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010[\u001a\u0004\bg\u0010\u0010R\u001b\u00106\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010h\u001a\u0004\bi\u0010\u0017R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010j\u001a\u0004\bk\u0010\rR\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010R\u001a\u0004\bl\u0010\u0004¨\u0006o"}, d2 = {"Lcom/avito/android/remote/model/messenger/Channel;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component3", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "", "Lcom/avito/android/remote/model/User;", "component4", "()Ljava/util/List;", "", "component5", "()J", "component6", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "component7", "()Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "component8", "()Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "", "component9", "()Z", "component10", "component11", "component12", "Ljava/util/SortedSet;", "component13", "()Ljava/util/SortedSet;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component14", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "component15", "()Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "component16", "component17", "Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;", "component18", "()Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;", "Lcom/avito/android/remote/model/messenger/InputState;", "component19", "()Lcom/avito/android/remote/model/messenger/InputState;", "channelId", "type", "lastMessage", "users", "created", ChannelEntity.COLUMN_UPDATED, "context", "readOnlyState", "isDeleted", "isRead", "isSpam", "isAnswered", "tags", MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, "dealAction", "flow", "suspectMessageId", "displayInfo", "inputState", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/util/List;JJLcom/avito/android/remote/model/messenger/context/ChannelContext;Lcom/avito/android/remote/model/messenger/ReadOnlyState;ZZZZLjava/util/SortedSet;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Lcom/avito/android/remote/model/messenger/deal_action/DealAction;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;Lcom/avito/android/remote/model/messenger/InputState;)Lcom/avito/android/remote/model/messenger/Channel;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getChannelId", "Z", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "getContext", "Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;", "getDisplayInfo", "Ljava/util/SortedSet;", "getTags", "J", "getCreated", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "getDealAction", "getFlow", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getLastMessage", "getSuspectMessageId", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "getContextActions", "Lcom/avito/android/remote/model/messenger/InputState;", "getInputState", "getUpdated", "Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "getReadOnlyState", "Ljava/util/List;", "getUsers", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/util/List;JJLcom/avito/android/remote/model/messenger/context/ChannelContext;Lcom/avito/android/remote/model/messenger/ReadOnlyState;ZZZZLjava/util/SortedSet;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Lcom/avito/android/remote/model/messenger/deal_action/DealAction;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/ChannelDisplayInfo;Lcom/avito/android/remote/model/messenger/InputState;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Channel implements Parcelable {
    public static final Parcelable.Creator<Channel> CREATOR = new Creator();
    @NotNull
    private final String channelId;
    @NotNull
    private final ChannelContext context;
    @Nullable
    private final PlatformActions contextActions;
    private final long created;
    @Nullable
    private final DealAction dealAction;
    @NotNull
    private final ChannelDisplayInfo displayInfo;
    @Nullable
    private final String flow;
    @Nullable
    private final InputState inputState;
    private final boolean isAnswered;
    private final boolean isDeleted;
    private final boolean isRead;
    private final boolean isSpam;
    @Nullable
    private final LocalMessage lastMessage;
    @Nullable
    private final ReadOnlyState readOnlyState;
    @Nullable
    private final String suspectMessageId;
    @NotNull
    private final SortedSet<String> tags;
    @NotNull
    private final String type;
    private final long updated;
    @NotNull
    private final List<User> users;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Channel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Channel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            LocalMessage createFromParcel = parcel.readInt() != 0 ? LocalMessage.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(User.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            ChannelContext channelContext = (ChannelContext) parcel.readParcelable(Channel.class.getClassLoader());
            ReadOnlyState readOnlyState = (ReadOnlyState) parcel.readParcelable(Channel.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            TreeSet treeSet = new TreeSet();
            for (int readInt2 = parcel.readInt(); readInt2 != 0; readInt2--) {
                treeSet.add(parcel.readString());
            }
            return new Channel(readString, readString2, createFromParcel, arrayList, readLong, readLong2, channelContext, readOnlyState, z, z2, z3, z4, treeSet, (PlatformActions) parcel.readParcelable(Channel.class.getClassLoader()), (DealAction) parcel.readParcelable(Channel.class.getClassLoader()), parcel.readString(), parcel.readString(), ChannelDisplayInfo.CREATOR.createFromParcel(parcel), (InputState) parcel.readParcelable(Channel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Channel[] newArray(int i) {
            return new Channel[i];
        }
    }

    public Channel(@NotNull String str, @NotNull String str2, @Nullable LocalMessage localMessage, @NotNull List<User> list, long j, long j2, @NotNull ChannelContext channelContext, @Nullable ReadOnlyState readOnlyState2, boolean z, boolean z2, boolean z3, boolean z4, @NotNull SortedSet<String> sortedSet, @Nullable PlatformActions platformActions, @Nullable DealAction dealAction2, @Nullable String str3, @Nullable String str4, @NotNull ChannelDisplayInfo channelDisplayInfo, @Nullable InputState inputState2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        Intrinsics.checkNotNullParameter(sortedSet, "tags");
        Intrinsics.checkNotNullParameter(channelDisplayInfo, "displayInfo");
        this.channelId = str;
        this.type = str2;
        this.lastMessage = localMessage;
        this.users = list;
        this.created = j;
        this.updated = j2;
        this.context = channelContext;
        this.readOnlyState = readOnlyState2;
        this.isDeleted = z;
        this.isRead = z2;
        this.isSpam = z3;
        this.isAnswered = z4;
        this.tags = sortedSet;
        this.contextActions = platformActions;
        this.dealAction = dealAction2;
        this.flow = str3;
        this.suspectMessageId = str4;
        this.displayInfo = channelDisplayInfo;
        this.inputState = inputState2;
    }

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, LocalMessage localMessage, List list, long j, long j2, ChannelContext channelContext, ReadOnlyState readOnlyState2, boolean z, boolean z2, boolean z3, boolean z4, SortedSet sortedSet, PlatformActions platformActions, DealAction dealAction2, String str3, String str4, ChannelDisplayInfo channelDisplayInfo, InputState inputState2, int i, Object obj) {
        return channel.copy((i & 1) != 0 ? channel.channelId : str, (i & 2) != 0 ? channel.type : str2, (i & 4) != 0 ? channel.lastMessage : localMessage, (i & 8) != 0 ? channel.users : list, (i & 16) != 0 ? channel.created : j, (i & 32) != 0 ? channel.updated : j2, (i & 64) != 0 ? channel.context : channelContext, (i & 128) != 0 ? channel.readOnlyState : readOnlyState2, (i & 256) != 0 ? channel.isDeleted : z, (i & 512) != 0 ? channel.isRead : z2, (i & 1024) != 0 ? channel.isSpam : z3, (i & 2048) != 0 ? channel.isAnswered : z4, (i & 4096) != 0 ? channel.tags : sortedSet, (i & 8192) != 0 ? channel.contextActions : platformActions, (i & 16384) != 0 ? channel.dealAction : dealAction2, (i & 32768) != 0 ? channel.flow : str3, (i & 65536) != 0 ? channel.suspectMessageId : str4, (i & 131072) != 0 ? channel.displayInfo : channelDisplayInfo, (i & 262144) != 0 ? channel.inputState : inputState2);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    public final boolean component10() {
        return this.isRead;
    }

    public final boolean component11() {
        return this.isSpam;
    }

    public final boolean component12() {
        return this.isAnswered;
    }

    @NotNull
    public final SortedSet<String> component13() {
        return this.tags;
    }

    @Nullable
    public final PlatformActions component14() {
        return this.contextActions;
    }

    @Nullable
    public final DealAction component15() {
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
    public final ChannelDisplayInfo component18() {
        return this.displayInfo;
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
    public final LocalMessage component3() {
        return this.lastMessage;
    }

    @NotNull
    public final List<User> component4() {
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

    public final boolean component9() {
        return this.isDeleted;
    }

    @NotNull
    public final Channel copy(@NotNull String str, @NotNull String str2, @Nullable LocalMessage localMessage, @NotNull List<User> list, long j, long j2, @NotNull ChannelContext channelContext, @Nullable ReadOnlyState readOnlyState2, boolean z, boolean z2, boolean z3, boolean z4, @NotNull SortedSet<String> sortedSet, @Nullable PlatformActions platformActions, @Nullable DealAction dealAction2, @Nullable String str3, @Nullable String str4, @NotNull ChannelDisplayInfo channelDisplayInfo, @Nullable InputState inputState2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(channelContext, "context");
        Intrinsics.checkNotNullParameter(sortedSet, "tags");
        Intrinsics.checkNotNullParameter(channelDisplayInfo, "displayInfo");
        return new Channel(str, str2, localMessage, list, j, j2, channelContext, readOnlyState2, z, z2, z3, z4, sortedSet, platformActions, dealAction2, str3, str4, channelDisplayInfo, inputState2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.areEqual(this.channelId, channel.channelId) && Intrinsics.areEqual(this.type, channel.type) && Intrinsics.areEqual(this.lastMessage, channel.lastMessage) && Intrinsics.areEqual(this.users, channel.users) && this.created == channel.created && this.updated == channel.updated && Intrinsics.areEqual(this.context, channel.context) && Intrinsics.areEqual(this.readOnlyState, channel.readOnlyState) && this.isDeleted == channel.isDeleted && this.isRead == channel.isRead && this.isSpam == channel.isSpam && this.isAnswered == channel.isAnswered && Intrinsics.areEqual(this.tags, channel.tags) && Intrinsics.areEqual(this.contextActions, channel.contextActions) && Intrinsics.areEqual(this.dealAction, channel.dealAction) && Intrinsics.areEqual(this.flow, channel.flow) && Intrinsics.areEqual(this.suspectMessageId, channel.suspectMessageId) && Intrinsics.areEqual(this.displayInfo, channel.displayInfo) && Intrinsics.areEqual(this.inputState, channel.inputState);
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
    public final PlatformActions getContextActions() {
        return this.contextActions;
    }

    public final long getCreated() {
        return this.created;
    }

    @Nullable
    public final DealAction getDealAction() {
        return this.dealAction;
    }

    @NotNull
    public final ChannelDisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    @Nullable
    public final String getFlow() {
        return this.flow;
    }

    @Nullable
    public final InputState getInputState() {
        return this.inputState;
    }

    @Nullable
    public final LocalMessage getLastMessage() {
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

    @NotNull
    public final SortedSet<String> getTags() {
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
    public final List<User> getUsers() {
        return this.users;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.channelId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        LocalMessage localMessage = this.lastMessage;
        int hashCode3 = (hashCode2 + (localMessage != null ? localMessage.hashCode() : 0)) * 31;
        List<User> list = this.users;
        int hashCode4 = (((((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + c.a(this.created)) * 31) + c.a(this.updated)) * 31;
        ChannelContext channelContext = this.context;
        int hashCode5 = (hashCode4 + (channelContext != null ? channelContext.hashCode() : 0)) * 31;
        ReadOnlyState readOnlyState2 = this.readOnlyState;
        int hashCode6 = (hashCode5 + (readOnlyState2 != null ? readOnlyState2.hashCode() : 0)) * 31;
        boolean z = this.isDeleted;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode6 + i3) * 31;
        boolean z2 = this.isRead;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        boolean z3 = this.isSpam;
        if (z3) {
            z3 = true;
        }
        int i11 = z3 ? 1 : 0;
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = (i10 + i11) * 31;
        boolean z4 = this.isAnswered;
        if (!z4) {
            i2 = z4 ? 1 : 0;
        }
        int i15 = (i14 + i2) * 31;
        SortedSet<String> sortedSet = this.tags;
        int hashCode7 = (i15 + (sortedSet != null ? sortedSet.hashCode() : 0)) * 31;
        PlatformActions platformActions = this.contextActions;
        int hashCode8 = (hashCode7 + (platformActions != null ? platformActions.hashCode() : 0)) * 31;
        DealAction dealAction2 = this.dealAction;
        int hashCode9 = (hashCode8 + (dealAction2 != null ? dealAction2.hashCode() : 0)) * 31;
        String str3 = this.flow;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.suspectMessageId;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ChannelDisplayInfo channelDisplayInfo = this.displayInfo;
        int hashCode12 = (hashCode11 + (channelDisplayInfo != null ? channelDisplayInfo.hashCode() : 0)) * 31;
        InputState inputState2 = this.inputState;
        if (inputState2 != null) {
            i = inputState2.hashCode();
        }
        return hashCode12 + i;
    }

    public final boolean isAnswered() {
        return this.isAnswered;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final boolean isSpam() {
        return this.isSpam;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Channel{id=");
        L.append(this.channelId);
        L.append(", updated=");
        return a.k(L, this.updated, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.channelId);
        parcel.writeString(this.type);
        LocalMessage localMessage = this.lastMessage;
        if (localMessage != null) {
            parcel.writeInt(1);
            localMessage.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.users, parcel);
        while (n0.hasNext()) {
            ((User) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeLong(this.created);
        parcel.writeLong(this.updated);
        parcel.writeParcelable(this.context, i);
        parcel.writeParcelable(this.readOnlyState, i);
        parcel.writeInt(this.isDeleted ? 1 : 0);
        parcel.writeInt(this.isRead ? 1 : 0);
        parcel.writeInt(this.isSpam ? 1 : 0);
        parcel.writeInt(this.isAnswered ? 1 : 0);
        SortedSet<String> sortedSet = this.tags;
        parcel.writeInt(sortedSet.size());
        for (String str : sortedSet) {
            parcel.writeString(str);
        }
        parcel.writeParcelable(this.contextActions, i);
        parcel.writeParcelable(this.dealAction, i);
        parcel.writeString(this.flow);
        parcel.writeString(this.suspectMessageId);
        this.displayInfo.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.inputState, i);
    }
}
