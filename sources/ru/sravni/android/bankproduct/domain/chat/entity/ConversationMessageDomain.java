package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u000e¨\u00067"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageDomain;", "", "", "component1", "()I", "Lru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;", "component2", "()Lru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;", "", "component3", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "component4", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "component5", "()Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "Ljava/util/Date;", "component6", "()Ljava/util/Date;", "messageOrderId", "sender", "text", "message", "conversationMessageParamsDomain", "createdTime", "copy", "(ILru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;Ljava/util/Date;)Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;", "getConversationMessageParamsDomain", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;", "getSender", "c", "Ljava/lang/String;", "getText", "f", "Ljava/util/Date;", "getCreatedTime", AuthSource.SEND_ABUSE, "I", "getMessageOrderId", "d", "Ljava/util/List;", "getMessage", "<init>", "(ILru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageParamsDomain;Ljava/util/Date;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationMessageDomain {
    public final int a;
    @NotNull
    public final SenderTypeDomain b;
    @Nullable
    public final String c;
    @NotNull
    public final List<MessageDomain> d;
    @Nullable
    public final ConversationMessageParamsDomain e;
    @Nullable
    public final Date f;

    public ConversationMessageDomain(int i, @NotNull SenderTypeDomain senderTypeDomain, @Nullable String str, @NotNull List<MessageDomain> list, @Nullable ConversationMessageParamsDomain conversationMessageParamsDomain, @Nullable Date date) {
        Intrinsics.checkParameterIsNotNull(senderTypeDomain, "sender");
        Intrinsics.checkParameterIsNotNull(list, "message");
        this.a = i;
        this.b = senderTypeDomain;
        this.c = str;
        this.d = list;
        this.e = conversationMessageParamsDomain;
        this.f = date;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.domain.chat.entity.ConversationMessageDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationMessageDomain copy$default(ConversationMessageDomain conversationMessageDomain, int i, SenderTypeDomain senderTypeDomain, String str, List list, ConversationMessageParamsDomain conversationMessageParamsDomain, Date date, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = conversationMessageDomain.a;
        }
        if ((i2 & 2) != 0) {
            senderTypeDomain = conversationMessageDomain.b;
        }
        if ((i2 & 4) != 0) {
            str = conversationMessageDomain.c;
        }
        if ((i2 & 8) != 0) {
            list = conversationMessageDomain.d;
        }
        if ((i2 & 16) != 0) {
            conversationMessageParamsDomain = conversationMessageDomain.e;
        }
        if ((i2 & 32) != 0) {
            date = conversationMessageDomain.f;
        }
        return conversationMessageDomain.copy(i, senderTypeDomain, str, list, conversationMessageParamsDomain, date);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final SenderTypeDomain component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final List<MessageDomain> component4() {
        return this.d;
    }

    @Nullable
    public final ConversationMessageParamsDomain component5() {
        return this.e;
    }

    @Nullable
    public final Date component6() {
        return this.f;
    }

    @NotNull
    public final ConversationMessageDomain copy(int i, @NotNull SenderTypeDomain senderTypeDomain, @Nullable String str, @NotNull List<MessageDomain> list, @Nullable ConversationMessageParamsDomain conversationMessageParamsDomain, @Nullable Date date) {
        Intrinsics.checkParameterIsNotNull(senderTypeDomain, "sender");
        Intrinsics.checkParameterIsNotNull(list, "message");
        return new ConversationMessageDomain(i, senderTypeDomain, str, list, conversationMessageParamsDomain, date);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationMessageDomain)) {
            return false;
        }
        ConversationMessageDomain conversationMessageDomain = (ConversationMessageDomain) obj;
        return this.a == conversationMessageDomain.a && Intrinsics.areEqual(this.b, conversationMessageDomain.b) && Intrinsics.areEqual(this.c, conversationMessageDomain.c) && Intrinsics.areEqual(this.d, conversationMessageDomain.d) && Intrinsics.areEqual(this.e, conversationMessageDomain.e) && Intrinsics.areEqual(this.f, conversationMessageDomain.f);
    }

    @Nullable
    public final ConversationMessageParamsDomain getConversationMessageParamsDomain() {
        return this.e;
    }

    @Nullable
    public final Date getCreatedTime() {
        return this.f;
    }

    @NotNull
    public final List<MessageDomain> getMessage() {
        return this.d;
    }

    public final int getMessageOrderId() {
        return this.a;
    }

    @NotNull
    public final SenderTypeDomain getSender() {
        return this.b;
    }

    @Nullable
    public final String getText() {
        return this.c;
    }

    public int hashCode() {
        int i = this.a * 31;
        SenderTypeDomain senderTypeDomain = this.b;
        int i2 = 0;
        int hashCode = (i + (senderTypeDomain != null ? senderTypeDomain.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<MessageDomain> list = this.d;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        ConversationMessageParamsDomain conversationMessageParamsDomain = this.e;
        int hashCode4 = (hashCode3 + (conversationMessageParamsDomain != null ? conversationMessageParamsDomain.hashCode() : 0)) * 31;
        Date date = this.f;
        if (date != null) {
            i2 = date.hashCode();
        }
        return hashCode4 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationMessageDomain(messageOrderId=");
        L.append(this.a);
        L.append(", sender=");
        L.append(this.b);
        L.append(", text=");
        L.append(this.c);
        L.append(", message=");
        L.append(this.d);
        L.append(", conversationMessageParamsDomain=");
        L.append(this.e);
        L.append(", createdTime=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationMessageDomain(int i, SenderTypeDomain senderTypeDomain, String str, List list, ConversationMessageParamsDomain conversationMessageParamsDomain, Date date, int i2, j jVar) {
        this(i, senderTypeDomain, str, list, (i2 & 16) != 0 ? null : conversationMessageParamsDomain, (i2 & 32) != 0 ? null : date);
    }
}
