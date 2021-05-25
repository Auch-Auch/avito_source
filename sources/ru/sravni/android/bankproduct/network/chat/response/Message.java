package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u0007J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b1\u0010\u0007R$\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b3\u0010\u0012R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b4\u0010\u0012R\u001e\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\b5\u0010\u0007R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u000eR\u001c\u0010!\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b8\u0010\u0007R\u001e\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b:\u0010\u0018R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b;\u0010\u0007R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\b=\u0010\n¨\u0006@"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Message;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/network/chat/response/Content;", "component3", "()Lru/sravni/android/bankproduct/network/chat/response/Content;", "component4", "Lru/sravni/android/bankproduct/network/chat/response/MessageElements;", "component5", "()Lru/sravni/android/bankproduct/network/chat/response/MessageElements;", "", "Lru/sravni/android/bankproduct/network/chat/response/Action;", "component6", "()Ljava/util/List;", "component7", "component8", "component9", "Lru/sravni/android/bankproduct/network/chat/response/MessageParams;", "component10", "()Lru/sravni/android/bankproduct/network/chat/response/MessageParams;", "component11", AnalyticFieldsName.orderId, "type", "content", "message", "messageElements", "actions", "modifiers", "name", "sender", "messageParams", "createdTimeString", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/Content;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/MessageElements;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/MessageParams;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/chat/response/Message;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getOrderId", "Ljava/lang/String;", "getSender", "getMessage", "Ljava/util/List;", "getModifiers", "getActions", "getCreatedTimeString", "Lru/sravni/android/bankproduct/network/chat/response/MessageElements;", "getMessageElements", "getName", "Lru/sravni/android/bankproduct/network/chat/response/MessageParams;", "getMessageParams", "getType", "Lru/sravni/android/bankproduct/network/chat/response/Content;", "getContent", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/Content;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/MessageElements;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/MessageParams;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Message {
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("content")
    @Nullable
    private final Content content;
    @SerializedName("created")
    @Nullable
    private final String createdTimeString;
    @SerializedName("message")
    @NotNull
    private final String message;
    @SerializedName("messageElements")
    @Nullable
    private final MessageElements messageElements;
    @SerializedName("params")
    @Nullable
    private final MessageParams messageParams;
    @SerializedName("modifiers")
    @Nullable
    private final List<String> modifiers;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("order")
    private final int orderId;
    @SerializedName("sender")
    @NotNull
    private final String sender;
    @SerializedName("type")
    @Nullable
    private final String type;

    public Message(int i, @Nullable String str, @Nullable Content content2, @NotNull String str2, @Nullable MessageElements messageElements2, @Nullable List<Action> list, @Nullable List<String> list2, @NotNull String str3, @NotNull String str4, @Nullable MessageParams messageParams2, @Nullable String str5) {
        a.a1(str2, "message", str3, "name", str4, "sender");
        this.orderId = i;
        this.type = str;
        this.content = content2;
        this.message = str2;
        this.messageElements = messageElements2;
        this.actions = list;
        this.modifiers = list2;
        this.name = str3;
        this.sender = str4;
        this.messageParams = messageParams2;
        this.createdTimeString = str5;
    }

    public static /* synthetic */ Message copy$default(Message message2, int i, String str, Content content2, String str2, MessageElements messageElements2, List list, List list2, String str3, String str4, MessageParams messageParams2, String str5, int i2, Object obj) {
        return message2.copy((i2 & 1) != 0 ? message2.orderId : i, (i2 & 2) != 0 ? message2.type : str, (i2 & 4) != 0 ? message2.content : content2, (i2 & 8) != 0 ? message2.message : str2, (i2 & 16) != 0 ? message2.messageElements : messageElements2, (i2 & 32) != 0 ? message2.actions : list, (i2 & 64) != 0 ? message2.modifiers : list2, (i2 & 128) != 0 ? message2.name : str3, (i2 & 256) != 0 ? message2.sender : str4, (i2 & 512) != 0 ? message2.messageParams : messageParams2, (i2 & 1024) != 0 ? message2.createdTimeString : str5);
    }

    public final int component1() {
        return this.orderId;
    }

    @Nullable
    public final MessageParams component10() {
        return this.messageParams;
    }

    @Nullable
    public final String component11() {
        return this.createdTimeString;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final Content component3() {
        return this.content;
    }

    @NotNull
    public final String component4() {
        return this.message;
    }

    @Nullable
    public final MessageElements component5() {
        return this.messageElements;
    }

    @Nullable
    public final List<Action> component6() {
        return this.actions;
    }

    @Nullable
    public final List<String> component7() {
        return this.modifiers;
    }

    @NotNull
    public final String component8() {
        return this.name;
    }

    @NotNull
    public final String component9() {
        return this.sender;
    }

    @NotNull
    public final Message copy(int i, @Nullable String str, @Nullable Content content2, @NotNull String str2, @Nullable MessageElements messageElements2, @Nullable List<Action> list, @Nullable List<String> list2, @NotNull String str3, @NotNull String str4, @Nullable MessageParams messageParams2, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(str3, "name");
        Intrinsics.checkParameterIsNotNull(str4, "sender");
        return new Message(i, str, content2, str2, messageElements2, list, list2, str3, str4, messageParams2, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message2 = (Message) obj;
        return this.orderId == message2.orderId && Intrinsics.areEqual(this.type, message2.type) && Intrinsics.areEqual(this.content, message2.content) && Intrinsics.areEqual(this.message, message2.message) && Intrinsics.areEqual(this.messageElements, message2.messageElements) && Intrinsics.areEqual(this.actions, message2.actions) && Intrinsics.areEqual(this.modifiers, message2.modifiers) && Intrinsics.areEqual(this.name, message2.name) && Intrinsics.areEqual(this.sender, message2.sender) && Intrinsics.areEqual(this.messageParams, message2.messageParams) && Intrinsics.areEqual(this.createdTimeString, message2.createdTimeString);
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Content getContent() {
        return this.content;
    }

    @Nullable
    public final String getCreatedTimeString() {
        return this.createdTimeString;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final MessageElements getMessageElements() {
        return this.messageElements;
    }

    @Nullable
    public final MessageParams getMessageParams() {
        return this.messageParams;
    }

    @Nullable
    public final List<String> getModifiers() {
        return this.modifiers;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getSender() {
        return this.sender;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.orderId * 31;
        String str = this.type;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Content content2 = this.content;
        int hashCode2 = (hashCode + (content2 != null ? content2.hashCode() : 0)) * 31;
        String str2 = this.message;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageElements messageElements2 = this.messageElements;
        int hashCode4 = (hashCode3 + (messageElements2 != null ? messageElements2.hashCode() : 0)) * 31;
        List<Action> list = this.actions;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.modifiers;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.sender;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        MessageParams messageParams2 = this.messageParams;
        int hashCode9 = (hashCode8 + (messageParams2 != null ? messageParams2.hashCode() : 0)) * 31;
        String str5 = this.createdTimeString;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode9 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Message(orderId=");
        L.append(this.orderId);
        L.append(", type=");
        L.append(this.type);
        L.append(", content=");
        L.append(this.content);
        L.append(", message=");
        L.append(this.message);
        L.append(", messageElements=");
        L.append(this.messageElements);
        L.append(", actions=");
        L.append(this.actions);
        L.append(", modifiers=");
        L.append(this.modifiers);
        L.append(", name=");
        L.append(this.name);
        L.append(", sender=");
        L.append(this.sender);
        L.append(", messageParams=");
        L.append(this.messageParams);
        L.append(", createdTimeString=");
        return a.t(L, this.createdTimeString, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Message(int i, String str, Content content2, String str2, MessageElements messageElements2, List list, List list2, String str3, String str4, MessageParams messageParams2, String str5, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? null : str, content2, str2, (i2 & 16) != 0 ? null : messageElements2, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : list2, str3, str4, (i2 & 512) != 0 ? null : messageParams2, (i2 & 1024) != 0 ? null : str5);
    }
}
