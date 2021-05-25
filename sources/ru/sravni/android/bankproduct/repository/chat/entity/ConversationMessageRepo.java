package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\n\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\u0007J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R!\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\rR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004R!\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u0010\rR\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00105\u001a\u0004\b8\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u00105\u001a\u0004\b<\u0010\u0007R!\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010-\u001a\u0004\b>\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0014R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0017¨\u0006I"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "component5", "()Ljava/util/List;", "component6", "component7", "Lru/sravni/android/bankproduct/repository/chat/entity/CardActionRepo;", "component8", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "component9", "()Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "component10", "()Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "component11", "messageOrderId", AnalyticFieldsName.conversationID, "sender", "text", "messageElements", "type", "modifiers", "actions", "contentCard", "messageParams", "createdTimeString", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "h", "Ljava/util/List;", "getActions", AuthSource.SEND_ABUSE, "I", "getMessageOrderId", "e", "getMessageElements", "f", "Ljava/lang/String;", "getType", "k", "getCreatedTimeString", AuthSource.BOOKING_ORDER, "getConversationId", "c", "getSender", g.a, "getModifiers", "d", "getText", "i", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "getContentCard", "j", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;", "getMessageParams", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageParamsRepo;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationMessageRepo {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final List<ContentCardElementRepo> e;
    @NotNull
    public final String f;
    @Nullable
    public final List<String> g;
    @Nullable
    public final List<CardActionRepo> h;
    @Nullable
    public final ContentCardRepo i;
    @Nullable
    public final ConversationMessageParamsRepo j;
    @Nullable
    public final String k;

    public ConversationMessageRepo(int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<ContentCardElementRepo> list, @NotNull String str4, @Nullable List<String> list2, @Nullable List<CardActionRepo> list3, @Nullable ContentCardRepo contentCardRepo, @Nullable ConversationMessageParamsRepo conversationMessageParamsRepo, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(str2, "sender");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = list;
        this.f = str4;
        this.g = list2;
        this.h = list3;
        this.i = contentCardRepo;
        this.j = conversationMessageParamsRepo;
        this.k = str5;
    }

    public static /* synthetic */ ConversationMessageRepo copy$default(ConversationMessageRepo conversationMessageRepo, int i2, String str, String str2, String str3, List list, String str4, List list2, List list3, ContentCardRepo contentCardRepo, ConversationMessageParamsRepo conversationMessageParamsRepo, String str5, int i3, Object obj) {
        return conversationMessageRepo.copy((i3 & 1) != 0 ? conversationMessageRepo.a : i2, (i3 & 2) != 0 ? conversationMessageRepo.b : str, (i3 & 4) != 0 ? conversationMessageRepo.c : str2, (i3 & 8) != 0 ? conversationMessageRepo.d : str3, (i3 & 16) != 0 ? conversationMessageRepo.e : list, (i3 & 32) != 0 ? conversationMessageRepo.f : str4, (i3 & 64) != 0 ? conversationMessageRepo.g : list2, (i3 & 128) != 0 ? conversationMessageRepo.h : list3, (i3 & 256) != 0 ? conversationMessageRepo.i : contentCardRepo, (i3 & 512) != 0 ? conversationMessageRepo.j : conversationMessageParamsRepo, (i3 & 1024) != 0 ? conversationMessageRepo.k : str5);
    }

    public final int component1() {
        return this.a;
    }

    @Nullable
    public final ConversationMessageParamsRepo component10() {
        return this.j;
    }

    @Nullable
    public final String component11() {
        return this.k;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final List<ContentCardElementRepo> component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final List<String> component7() {
        return this.g;
    }

    @Nullable
    public final List<CardActionRepo> component8() {
        return this.h;
    }

    @Nullable
    public final ContentCardRepo component9() {
        return this.i;
    }

    @NotNull
    public final ConversationMessageRepo copy(int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<ContentCardElementRepo> list, @NotNull String str4, @Nullable List<String> list2, @Nullable List<CardActionRepo> list3, @Nullable ContentCardRepo contentCardRepo, @Nullable ConversationMessageParamsRepo conversationMessageParamsRepo, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(str2, "sender");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        return new ConversationMessageRepo(i2, str, str2, str3, list, str4, list2, list3, contentCardRepo, conversationMessageParamsRepo, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationMessageRepo)) {
            return false;
        }
        ConversationMessageRepo conversationMessageRepo = (ConversationMessageRepo) obj;
        return this.a == conversationMessageRepo.a && Intrinsics.areEqual(this.b, conversationMessageRepo.b) && Intrinsics.areEqual(this.c, conversationMessageRepo.c) && Intrinsics.areEqual(this.d, conversationMessageRepo.d) && Intrinsics.areEqual(this.e, conversationMessageRepo.e) && Intrinsics.areEqual(this.f, conversationMessageRepo.f) && Intrinsics.areEqual(this.g, conversationMessageRepo.g) && Intrinsics.areEqual(this.h, conversationMessageRepo.h) && Intrinsics.areEqual(this.i, conversationMessageRepo.i) && Intrinsics.areEqual(this.j, conversationMessageRepo.j) && Intrinsics.areEqual(this.k, conversationMessageRepo.k);
    }

    @Nullable
    public final List<CardActionRepo> getActions() {
        return this.h;
    }

    @Nullable
    public final ContentCardRepo getContentCard() {
        return this.i;
    }

    @NotNull
    public final String getConversationId() {
        return this.b;
    }

    @Nullable
    public final String getCreatedTimeString() {
        return this.k;
    }

    @Nullable
    public final List<ContentCardElementRepo> getMessageElements() {
        return this.e;
    }

    public final int getMessageOrderId() {
        return this.a;
    }

    @Nullable
    public final ConversationMessageParamsRepo getMessageParams() {
        return this.j;
    }

    @Nullable
    public final List<String> getModifiers() {
        return this.g;
    }

    @NotNull
    public final String getSender() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.d;
    }

    @NotNull
    public final String getType() {
        return this.f;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ContentCardElementRepo> list = this.e;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<String> list2 = this.g;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<CardActionRepo> list3 = this.h;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        ContentCardRepo contentCardRepo = this.i;
        int hashCode8 = (hashCode7 + (contentCardRepo != null ? contentCardRepo.hashCode() : 0)) * 31;
        ConversationMessageParamsRepo conversationMessageParamsRepo = this.j;
        int hashCode9 = (hashCode8 + (conversationMessageParamsRepo != null ? conversationMessageParamsRepo.hashCode() : 0)) * 31;
        String str5 = this.k;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return hashCode9 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConversationMessageRepo(messageOrderId=");
        L.append(this.a);
        L.append(", conversationId=");
        L.append(this.b);
        L.append(", sender=");
        L.append(this.c);
        L.append(", text=");
        L.append(this.d);
        L.append(", messageElements=");
        L.append(this.e);
        L.append(", type=");
        L.append(this.f);
        L.append(", modifiers=");
        L.append(this.g);
        L.append(", actions=");
        L.append(this.h);
        L.append(", contentCard=");
        L.append(this.i);
        L.append(", messageParams=");
        L.append(this.j);
        L.append(", createdTimeString=");
        return a.t(L, this.k, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationMessageRepo(int i2, String str, String str2, String str3, List list, String str4, List list2, List list3, ContentCardRepo contentCardRepo, ConversationMessageParamsRepo conversationMessageParamsRepo, String str5, int i3, j jVar) {
        this(i2, str, str2, str3, (i3 & 16) != 0 ? null : list, str4, (i3 & 64) != 0 ? null : list2, (i3 & 128) != 0 ? null : list3, (i3 & 256) != 0 ? null : contentCardRepo, (i3 & 512) != 0 ? null : conversationMessageParamsRepo, str5);
    }
}
