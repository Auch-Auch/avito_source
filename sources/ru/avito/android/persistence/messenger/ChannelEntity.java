package ru.avito.android.persistence.messenger;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Entity(indices = {@Index(name = "user_id_and_channel_id", unique = true, value = {"user_id", "channel_id"})}, primaryKeys = {"user_id", "channel_id"}, tableName = "channel")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b0\b\b\u0018\u0000 b2\u00020\u0001:\u0001bB·\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010&\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b`\u0010aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004Jè\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b2\u0010\u0004J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R\u001c\u0010\u001e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0004R\u001c\u0010!\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010:\u001a\u0004\b=\u0010\u0004R\u001c\u0010\u001f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\tR\u001e\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010\u0004R\u001e\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010\u0004R\u001e\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010\u0004R\u001c\u0010'\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\b'\u0010\u0010R\u001e\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010\u0004R\u001e\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bK\u0010:\u001a\u0004\bL\u0010\u0004R\u001e\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bM\u0010:\u001a\u0004\bN\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bO\u0010:\u001a\u0004\bP\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bQ\u0010:\u001a\u0004\bR\u0010\u0004R\u001c\u0010&\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bS\u0010H\u001a\u0004\b&\u0010\u0010R\u001c\u0010$\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bT\u0010H\u001a\u0004\b$\u0010\u0010R\u001c\u0010 \u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bU\u0010?\u001a\u0004\bV\u0010\tR\u001c\u0010%\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bW\u0010H\u001a\u0004\b%\u0010\u0010R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bX\u0010:\u001a\u0004\bY\u0010\u0004R\u001e\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bZ\u0010:\u001a\u0004\b[\u0010\u0004R\u001e\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\\\u0010:\u001a\u0004\b]\u0010\u0004R\u001c\u0010.\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b^\u0010:\u001a\u0004\b_\u0010\u0004¨\u0006c"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "", "component9", "()Z", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", ChannelContext.Item.USER_ID, "channelId", "type", "created", ChannelEntity.COLUMN_UPDATED, "contextType", "jsonContext", "jsonReadOnlyState", "isDeleted", "isRead", "isSpam", "isAnswered", "jsonContextActions", "jsonDealAction", "flow", "suspectMessageId", "itemId", "interlocutorId", "jsonDisplayInfo", "jsonInputState", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/avito/android/persistence/messenger/ChannelEntity;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getType", "f", "getContextType", "d", "J", "getCreated", "h", "getJsonReadOnlyState", "o", "getFlow", "t", "getJsonInputState", "l", "Z", AuthSource.OPEN_CHANNEL_LIST, "getJsonContextActions", "n", "getJsonDealAction", VKApiConst.Q, "getItemId", AuthSource.BOOKING_ORDER, "getChannelId", g.a, "getJsonContext", "k", "i", "e", "getUpdated", "j", AuthSource.SEND_ABUSE, "getUserId", "p", "getSuspectMessageId", "r", "getInterlocutorId", "s", "getJsonDisplayInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelEntity {
    @NotNull
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    @NotNull
    public static final String COLUMN_CONTEXT_TYPE = "context_type";
    @NotNull
    public static final String COLUMN_CREATED = "created";
    @NotNull
    public static final String COLUMN_FLOW = "flow";
    @NotNull
    public static final String COLUMN_INTERLOCUTOR_ID = "interlocutor_id";
    @NotNull
    public static final String COLUMN_IS_ANSWERED = "is_answered";
    @NotNull
    public static final String COLUMN_IS_DELETED = "is_deleted";
    @NotNull
    public static final String COLUMN_IS_READ = "is_read";
    @NotNull
    public static final String COLUMN_IS_SPAM = "is_spam";
    @NotNull
    public static final String COLUMN_ITEM_ID = "item_id";
    @NotNull
    public static final String COLUMN_JSON_CONTEXT = "json_context";
    @NotNull
    public static final String COLUMN_JSON_CONTEXT_ACTIONS = "json_context_actions";
    @NotNull
    public static final String COLUMN_JSON_DEAL_ACTION = "json_deal_action";
    @NotNull
    public static final String COLUMN_JSON_DISPLAY_INFO = "json_display_info";
    @NotNull
    public static final String COLUMN_JSON_INPUT_STATE = "json_input_state";
    @NotNull
    public static final String COLUMN_JSON_READ_ONLY_STATE = "json_read_only_state";
    @NotNull
    public static final String COLUMN_SUSPECT_MESSAGE_ID = "suspect_message_id";
    @NotNull
    public static final String COLUMN_TYPE = "type";
    @NotNull
    public static final String COLUMN_UPDATED = "updated";
    @NotNull
    public static final String COLUMN_USER_ID = "user_id";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @ColumnInfo(name = "user_id")
    @NotNull
    public final String a;
    @ColumnInfo(name = "channel_id")
    @NotNull
    public final String b;
    @ColumnInfo(name = "type")
    @NotNull
    public final String c;
    @ColumnInfo(name = "created")
    public final long d;
    @ColumnInfo(name = COLUMN_UPDATED)
    public final long e;
    @ColumnInfo(name = COLUMN_CONTEXT_TYPE)
    @NotNull
    public final String f;
    @ColumnInfo(name = COLUMN_JSON_CONTEXT)
    @NotNull
    public final String g;
    @ColumnInfo(name = COLUMN_JSON_READ_ONLY_STATE)
    @Nullable
    public final String h;
    @ColumnInfo(name = COLUMN_IS_DELETED)
    public final boolean i;
    @ColumnInfo(name = COLUMN_IS_READ)
    public final boolean j;
    @ColumnInfo(name = COLUMN_IS_SPAM)
    public final boolean k;
    @ColumnInfo(name = COLUMN_IS_ANSWERED)
    public final boolean l;
    @ColumnInfo(name = COLUMN_JSON_CONTEXT_ACTIONS)
    @Nullable
    public final String m;
    @ColumnInfo(name = COLUMN_JSON_DEAL_ACTION)
    @Nullable
    public final String n;
    @ColumnInfo(name = "flow")
    @Nullable
    public final String o;
    @ColumnInfo(name = COLUMN_SUSPECT_MESSAGE_ID)
    @Nullable
    public final String p;
    @ColumnInfo(name = "item_id")
    @Nullable
    public final String q;
    @ColumnInfo(name = "interlocutor_id")
    @Nullable
    public final String r;
    @ColumnInfo(name = COLUMN_JSON_DISPLAY_INFO)
    @NotNull
    public final String s;
    @ColumnInfo(name = COLUMN_JSON_INPUT_STATE)
    @Nullable
    public final String t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelEntity$Companion;", "", "", "COLUMN_CHANNEL_ID", "Ljava/lang/String;", "COLUMN_CONTEXT_TYPE", "COLUMN_CREATED", "COLUMN_FLOW", "COLUMN_INTERLOCUTOR_ID", "COLUMN_IS_ANSWERED", "COLUMN_IS_DELETED", "COLUMN_IS_READ", "COLUMN_IS_SPAM", "COLUMN_ITEM_ID", "COLUMN_JSON_CONTEXT", "COLUMN_JSON_CONTEXT_ACTIONS", "COLUMN_JSON_DEAL_ACTION", "COLUMN_JSON_DISPLAY_INFO", "COLUMN_JSON_INPUT_STATE", "COLUMN_JSON_READ_ONLY_STATE", "COLUMN_SUSPECT_MESSAGE_ID", "COLUMN_TYPE", "COLUMN_UPDATED", "COLUMN_USER_ID", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ChannelEntity(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2, long j3, @NotNull String str4, @NotNull String str5, @Nullable String str6, boolean z, boolean z2, boolean z3, boolean z4, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @NotNull String str13, @Nullable String str14) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "contextType");
        Intrinsics.checkNotNullParameter(str5, "jsonContext");
        Intrinsics.checkNotNullParameter(str13, "jsonDisplayInfo");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j2;
        this.e = j3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = str7;
        this.n = str8;
        this.o = str9;
        this.p = str10;
        this.q = str11;
        this.r = str12;
        this.s = str13;
        this.t = str14;
    }

    public static /* synthetic */ ChannelEntity copy$default(ChannelEntity channelEntity, String str, String str2, String str3, long j2, long j3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, boolean z4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object obj) {
        return channelEntity.copy((i2 & 1) != 0 ? channelEntity.a : str, (i2 & 2) != 0 ? channelEntity.b : str2, (i2 & 4) != 0 ? channelEntity.c : str3, (i2 & 8) != 0 ? channelEntity.d : j2, (i2 & 16) != 0 ? channelEntity.e : j3, (i2 & 32) != 0 ? channelEntity.f : str4, (i2 & 64) != 0 ? channelEntity.g : str5, (i2 & 128) != 0 ? channelEntity.h : str6, (i2 & 256) != 0 ? channelEntity.i : z, (i2 & 512) != 0 ? channelEntity.j : z2, (i2 & 1024) != 0 ? channelEntity.k : z3, (i2 & 2048) != 0 ? channelEntity.l : z4, (i2 & 4096) != 0 ? channelEntity.m : str7, (i2 & 8192) != 0 ? channelEntity.n : str8, (i2 & 16384) != 0 ? channelEntity.o : str9, (i2 & 32768) != 0 ? channelEntity.p : str10, (i2 & 65536) != 0 ? channelEntity.q : str11, (i2 & 131072) != 0 ? channelEntity.r : str12, (i2 & 262144) != 0 ? channelEntity.s : str13, (i2 & 524288) != 0 ? channelEntity.t : str14);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    public final boolean component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    @Nullable
    public final String component14() {
        return this.n;
    }

    @Nullable
    public final String component15() {
        return this.o;
    }

    @Nullable
    public final String component16() {
        return this.p;
    }

    @Nullable
    public final String component17() {
        return this.q;
    }

    @Nullable
    public final String component18() {
        return this.r;
    }

    @NotNull
    public final String component19() {
        return this.s;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component20() {
        return this.t;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    public final long component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final ChannelEntity copy(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2, long j3, @NotNull String str4, @NotNull String str5, @Nullable String str6, boolean z, boolean z2, boolean z3, boolean z4, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @NotNull String str13, @Nullable String str14) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "contextType");
        Intrinsics.checkNotNullParameter(str5, "jsonContext");
        Intrinsics.checkNotNullParameter(str13, "jsonDisplayInfo");
        return new ChannelEntity(str, str2, str3, j2, j3, str4, str5, str6, z, z2, z3, z4, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelEntity)) {
            return false;
        }
        ChannelEntity channelEntity = (ChannelEntity) obj;
        return Intrinsics.areEqual(this.a, channelEntity.a) && Intrinsics.areEqual(this.b, channelEntity.b) && Intrinsics.areEqual(this.c, channelEntity.c) && this.d == channelEntity.d && this.e == channelEntity.e && Intrinsics.areEqual(this.f, channelEntity.f) && Intrinsics.areEqual(this.g, channelEntity.g) && Intrinsics.areEqual(this.h, channelEntity.h) && this.i == channelEntity.i && this.j == channelEntity.j && this.k == channelEntity.k && this.l == channelEntity.l && Intrinsics.areEqual(this.m, channelEntity.m) && Intrinsics.areEqual(this.n, channelEntity.n) && Intrinsics.areEqual(this.o, channelEntity.o) && Intrinsics.areEqual(this.p, channelEntity.p) && Intrinsics.areEqual(this.q, channelEntity.q) && Intrinsics.areEqual(this.r, channelEntity.r) && Intrinsics.areEqual(this.s, channelEntity.s) && Intrinsics.areEqual(this.t, channelEntity.t);
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    @NotNull
    public final String getContextType() {
        return this.f;
    }

    public final long getCreated() {
        return this.d;
    }

    @Nullable
    public final String getFlow() {
        return this.o;
    }

    @Nullable
    public final String getInterlocutorId() {
        return this.r;
    }

    @Nullable
    public final String getItemId() {
        return this.q;
    }

    @NotNull
    public final String getJsonContext() {
        return this.g;
    }

    @Nullable
    public final String getJsonContextActions() {
        return this.m;
    }

    @Nullable
    public final String getJsonDealAction() {
        return this.n;
    }

    @NotNull
    public final String getJsonDisplayInfo() {
        return this.s;
    }

    @Nullable
    public final String getJsonInputState() {
        return this.t;
    }

    @Nullable
    public final String getJsonReadOnlyState() {
        return this.h;
    }

    @Nullable
    public final String getSuspectMessageId() {
        return this.p;
    }

    @NotNull
    public final String getType() {
        return this.c;
    }

    public final long getUpdated() {
        return this.e;
    }

    @NotNull
    public final String getUserId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.d)) * 31) + c.a(this.e)) * 31;
        String str4 = this.f;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.g;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.h;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.i;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode6 + i4) * 31;
        boolean z2 = this.j;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.k;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        boolean z4 = this.l;
        if (!z4) {
            i3 = z4 ? 1 : 0;
        }
        int i16 = (i15 + i3) * 31;
        String str7 = this.m;
        int hashCode7 = (i16 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.n;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.o;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.p;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.q;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.r;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.s;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.t;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        return hashCode13 + i2;
    }

    public final boolean isAnswered() {
        return this.l;
    }

    public final boolean isDeleted() {
        return this.i;
    }

    public final boolean isRead() {
        return this.j;
    }

    public final boolean isSpam() {
        return this.k;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelEntity(userId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", type=");
        L.append(this.c);
        L.append(", created=");
        L.append(this.d);
        L.append(", updated=");
        L.append(this.e);
        L.append(", contextType=");
        L.append(this.f);
        L.append(", jsonContext=");
        L.append(this.g);
        L.append(", jsonReadOnlyState=");
        L.append(this.h);
        L.append(", isDeleted=");
        L.append(this.i);
        L.append(", isRead=");
        L.append(this.j);
        L.append(", isSpam=");
        L.append(this.k);
        L.append(", isAnswered=");
        L.append(this.l);
        L.append(", jsonContextActions=");
        L.append(this.m);
        L.append(", jsonDealAction=");
        L.append(this.n);
        L.append(", flow=");
        L.append(this.o);
        L.append(", suspectMessageId=");
        L.append(this.p);
        L.append(", itemId=");
        L.append(this.q);
        L.append(", interlocutorId=");
        L.append(this.r);
        L.append(", jsonDisplayInfo=");
        L.append(this.s);
        L.append(", jsonInputState=");
        return a.t(L, this.t, ")");
    }
}
