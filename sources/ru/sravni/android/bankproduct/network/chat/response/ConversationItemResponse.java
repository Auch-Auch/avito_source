package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/ConversationItemResponse;", "", "Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "component1", "()Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "item", "copy", "(Lru/sravni/android/bankproduct/network/chat/response/Conversation;)Lru/sravni/android/bankproduct/network/chat/response/ConversationItemResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/chat/response/Conversation;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationItemResponse {
    @SerializedName("item")
    @NotNull
    private final Conversation item;

    public ConversationItemResponse(@NotNull Conversation conversation) {
        Intrinsics.checkParameterIsNotNull(conversation, "item");
        this.item = conversation;
    }

    public static /* synthetic */ ConversationItemResponse copy$default(ConversationItemResponse conversationItemResponse, Conversation conversation, int i, Object obj) {
        if ((i & 1) != 0) {
            conversation = conversationItemResponse.item;
        }
        return conversationItemResponse.copy(conversation);
    }

    @NotNull
    public final Conversation component1() {
        return this.item;
    }

    @NotNull
    public final ConversationItemResponse copy(@NotNull Conversation conversation) {
        Intrinsics.checkParameterIsNotNull(conversation, "item");
        return new ConversationItemResponse(conversation);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ConversationItemResponse) && Intrinsics.areEqual(this.item, ((ConversationItemResponse) obj).item);
        }
        return true;
    }

    @NotNull
    public final Conversation getItem() {
        return this.item;
    }

    public int hashCode() {
        Conversation conversation = this.item;
        if (conversation != null) {
            return conversation.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationItemResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
