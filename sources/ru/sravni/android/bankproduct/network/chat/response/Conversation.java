package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJT\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\bR\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0004R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b#\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/network/chat/response/Message;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;", "component3", "()Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;", "component4", "", "component5", "id", "messages", "params", "status", "hiddenMessages", "copy", "(Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;", "getParams", "Ljava/util/List;", "getHiddenMessages", "Ljava/lang/String;", "getStatus", "getMessages", "getId", "<init>", "(Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Conversation {
    @SerializedName("hiddenMessages")
    @Nullable
    private final List<Integer> hiddenMessages;
    @SerializedName("_id")
    @NotNull
    private final String id;
    @SerializedName("messages")
    @Nullable
    private final List<Message> messages;
    @SerializedName("params")
    @Nullable
    private final ConversationParams params;
    @SerializedName("status")
    @NotNull
    private final String status;

    public Conversation(@NotNull String str, @Nullable List<Message> list, @Nullable ConversationParams conversationParams, @NotNull String str2, @Nullable List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        this.id = str;
        this.messages = list;
        this.params = conversationParams;
        this.status = str2;
        this.hiddenMessages = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.Conversation */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Conversation copy$default(Conversation conversation, String str, List list, ConversationParams conversationParams, String str2, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversation.id;
        }
        if ((i & 2) != 0) {
            list = conversation.messages;
        }
        if ((i & 4) != 0) {
            conversationParams = conversation.params;
        }
        if ((i & 8) != 0) {
            str2 = conversation.status;
        }
        if ((i & 16) != 0) {
            list2 = conversation.hiddenMessages;
        }
        return conversation.copy(str, list, conversationParams, str2, list2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final List<Message> component2() {
        return this.messages;
    }

    @Nullable
    public final ConversationParams component3() {
        return this.params;
    }

    @NotNull
    public final String component4() {
        return this.status;
    }

    @Nullable
    public final List<Integer> component5() {
        return this.hiddenMessages;
    }

    @NotNull
    public final Conversation copy(@NotNull String str, @Nullable List<Message> list, @Nullable ConversationParams conversationParams, @NotNull String str2, @Nullable List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "status");
        return new Conversation(str, list, conversationParams, str2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Conversation)) {
            return false;
        }
        Conversation conversation = (Conversation) obj;
        return Intrinsics.areEqual(this.id, conversation.id) && Intrinsics.areEqual(this.messages, conversation.messages) && Intrinsics.areEqual(this.params, conversation.params) && Intrinsics.areEqual(this.status, conversation.status) && Intrinsics.areEqual(this.hiddenMessages, conversation.hiddenMessages);
    }

    @Nullable
    public final List<Integer> getHiddenMessages() {
        return this.hiddenMessages;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<Message> getMessages() {
        return this.messages;
    }

    @Nullable
    public final ConversationParams getParams() {
        return this.params;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Message> list = this.messages;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        ConversationParams conversationParams = this.params;
        int hashCode3 = (hashCode2 + (conversationParams != null ? conversationParams.hashCode() : 0)) * 31;
        String str2 = this.status;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Integer> list2 = this.hiddenMessages;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Conversation(id=");
        L.append(this.id);
        L.append(", messages=");
        L.append(this.messages);
        L.append(", params=");
        L.append(this.params);
        L.append(", status=");
        L.append(this.status);
        L.append(", hiddenMessages=");
        return a.w(L, this.hiddenMessages, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Conversation(String str, List list, ConversationParams conversationParams, String str2, List list2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : conversationParams, str2, (i & 16) != 0 ? null : list2);
    }
}
