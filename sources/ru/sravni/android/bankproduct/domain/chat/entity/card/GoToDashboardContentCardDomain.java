package ru.sravni.android.bankproduct.domain.chat.entity.card;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/GoToDashboardContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", AnalyticFieldsName.orderId, "title", "type", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;)Lru/sravni/android/bankproduct/domain/chat/entity/card/GoToDashboardContentCardDomain;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getOrderId", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class GoToDashboardContentCardDomain implements IContentCardDomain {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final AnswerCardTypeDomain c;

    public GoToDashboardContentCardDomain(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        this.a = i;
        this.b = str;
        this.c = answerCardTypeDomain;
    }

    public static /* synthetic */ GoToDashboardContentCardDomain copy$default(GoToDashboardContentCardDomain goToDashboardContentCardDomain, int i, String str, AnswerCardTypeDomain answerCardTypeDomain, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = goToDashboardContentCardDomain.getOrderId();
        }
        if ((i2 & 2) != 0) {
            str = goToDashboardContentCardDomain.getTitle();
        }
        if ((i2 & 4) != 0) {
            answerCardTypeDomain = goToDashboardContentCardDomain.getType();
        }
        return goToDashboardContentCardDomain.copy(i, str, answerCardTypeDomain);
    }

    public final int component1() {
        return getOrderId();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @NotNull
    public final AnswerCardTypeDomain component3() {
        return getType();
    }

    @NotNull
    public final GoToDashboardContentCardDomain copy(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        return new GoToDashboardContentCardDomain(i, str, answerCardTypeDomain);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoToDashboardContentCardDomain)) {
            return false;
        }
        GoToDashboardContentCardDomain goToDashboardContentCardDomain = (GoToDashboardContentCardDomain) obj;
        return getOrderId() == goToDashboardContentCardDomain.getOrderId() && Intrinsics.areEqual(getTitle(), goToDashboardContentCardDomain.getTitle()) && Intrinsics.areEqual(getType(), goToDashboardContentCardDomain.getType());
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain
    public int getOrderId() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain
    @NotNull
    public String getTitle() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain
    @NotNull
    public AnswerCardTypeDomain getType() {
        return this.c;
    }

    public int hashCode() {
        int orderId = getOrderId() * 31;
        String title = getTitle();
        int i = 0;
        int hashCode = (orderId + (title != null ? title.hashCode() : 0)) * 31;
        AnswerCardTypeDomain type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GoToDashboardContentCardDomain(orderId=");
        L.append(getOrderId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }
}
