package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JT\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R'\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/util/Map;", "component5", "cardOrderId", AnalyticFieldsName.conversationID, "answerText", "fields", "actionCode", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/Map;", "getFields", AuthSource.SEND_ABUSE, "I", "getCardOrderId", "e", "Ljava/lang/String;", "getActionCode", "c", "getAnswerText", AuthSource.BOOKING_ORDER, "getConversationId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnswerInfoDomain {
    public final int a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Map<String, String> d;
    @Nullable
    public final String e;

    public AnswerInfoDomain(int i, @NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = map;
        this.e = str3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnswerInfoDomain copy$default(AnswerInfoDomain answerInfoDomain, int i, String str, String str2, Map map, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = answerInfoDomain.a;
        }
        if ((i2 & 2) != 0) {
            str = answerInfoDomain.b;
        }
        if ((i2 & 4) != 0) {
            str2 = answerInfoDomain.c;
        }
        if ((i2 & 8) != 0) {
            map = answerInfoDomain.d;
        }
        if ((i2 & 16) != 0) {
            str3 = answerInfoDomain.e;
        }
        return answerInfoDomain.copy(i, str, str2, map, str3);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final AnswerInfoDomain copy(int i, @NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        return new AnswerInfoDomain(i, str, str2, map, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerInfoDomain)) {
            return false;
        }
        AnswerInfoDomain answerInfoDomain = (AnswerInfoDomain) obj;
        return this.a == answerInfoDomain.a && Intrinsics.areEqual(this.b, answerInfoDomain.b) && Intrinsics.areEqual(this.c, answerInfoDomain.c) && Intrinsics.areEqual(this.d, answerInfoDomain.d) && Intrinsics.areEqual(this.e, answerInfoDomain.e);
    }

    @Nullable
    public final String getActionCode() {
        return this.e;
    }

    @Nullable
    public final String getAnswerText() {
        return this.c;
    }

    public final int getCardOrderId() {
        return this.a;
    }

    @NotNull
    public final String getConversationId() {
        return this.b;
    }

    @Nullable
    public final Map<String, String> getFields() {
        return this.d;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.d;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        String str3 = this.e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AnswerInfoDomain(cardOrderId=");
        L.append(this.a);
        L.append(", conversationId=");
        L.append(this.b);
        L.append(", answerText=");
        L.append(this.c);
        L.append(", fields=");
        L.append(this.d);
        L.append(", actionCode=");
        return a.t(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnswerInfoDomain(int i, String str, String str2, Map map, String str3, int i2, j jVar) {
        this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? null : str3);
    }
}
