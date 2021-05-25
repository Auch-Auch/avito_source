package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JT\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R'\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\u0007¨\u0006,"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/Map;", "component4", "component5", "cardId", AnalyticFieldsName.conversationID, "fields", "actionCode", "text", "copy", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getCardId", "e", "Ljava/lang/String;", "getText", "c", "Ljava/util/Map;", "getFields", AuthSource.BOOKING_ORDER, "getConversationId", "d", "getActionCode", "<init>", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answerInfo", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NextConversationInfoRepo {
    public final int a;
    @NotNull
    public final String b;
    @Nullable
    public final Map<String, String> c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;

    public NextConversationInfoRepo(int i, @NotNull String str, @Nullable Map<String, String> map, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        this.a = i;
        this.b = str;
        this.c = map;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.repository.chat.entity.NextConversationInfoRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NextConversationInfoRepo copy$default(NextConversationInfoRepo nextConversationInfoRepo, int i, String str, Map map, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nextConversationInfoRepo.a;
        }
        if ((i2 & 2) != 0) {
            str = nextConversationInfoRepo.b;
        }
        if ((i2 & 4) != 0) {
            map = nextConversationInfoRepo.c;
        }
        if ((i2 & 8) != 0) {
            str2 = nextConversationInfoRepo.d;
        }
        if ((i2 & 16) != 0) {
            str3 = nextConversationInfoRepo.e;
        }
        return nextConversationInfoRepo.copy(i, str, map, str2, str3);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final NextConversationInfoRepo copy(int i, @NotNull String str, @Nullable Map<String, String> map, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        return new NextConversationInfoRepo(i, str, map, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextConversationInfoRepo)) {
            return false;
        }
        NextConversationInfoRepo nextConversationInfoRepo = (NextConversationInfoRepo) obj;
        return this.a == nextConversationInfoRepo.a && Intrinsics.areEqual(this.b, nextConversationInfoRepo.b) && Intrinsics.areEqual(this.c, nextConversationInfoRepo.c) && Intrinsics.areEqual(this.d, nextConversationInfoRepo.d) && Intrinsics.areEqual(this.e, nextConversationInfoRepo.e);
    }

    @Nullable
    public final String getActionCode() {
        return this.d;
    }

    public final int getCardId() {
        return this.a;
    }

    @NotNull
    public final String getConversationId() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> getFields() {
        return this.c;
    }

    @Nullable
    public final String getText() {
        return this.e;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.c;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NextConversationInfoRepo(cardId=");
        L.append(this.a);
        L.append(", conversationId=");
        L.append(this.b);
        L.append(", fields=");
        L.append(this.c);
        L.append(", actionCode=");
        L.append(this.d);
        L.append(", text=");
        return a.t(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NextConversationInfoRepo(int i, String str, Map map, String str2, String str3, int i2, j jVar) {
        this(i, str, (i2 & 4) != 0 ? null : map, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NextConversationInfoRepo(@NotNull AnswerInfoDomain answerInfoDomain) {
        this(answerInfoDomain.getCardOrderId(), answerInfoDomain.getConversationId(), answerInfoDomain.getFields() != null ? new HashMap(answerInfoDomain.getFields()) : null, answerInfoDomain.getActionCode(), answerInfoDomain.getAnswerText());
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answerInfo");
    }
}
