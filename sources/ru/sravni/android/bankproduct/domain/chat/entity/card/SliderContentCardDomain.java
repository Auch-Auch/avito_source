package ru.sravni.android.bankproduct.domain.chat.entity.card;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJH\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0007R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\n¨\u0006."}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/SliderContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component4", "", "Lru/sravni/android/bankproduct/domain/chat/entity/card/SliderSnapPointDomain;", "component5", "()Ljava/util/List;", AnalyticFieldsName.orderId, "title", "type", "fieldContentName", "pointDomains", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/chat/entity/card/SliderContentCardDomain;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getOrderId", "d", "Ljava/lang/String;", "getFieldContentName", AuthSource.BOOKING_ORDER, "getTitle", "e", "Ljava/util/List;", "getPointDomains", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SliderContentCardDomain implements IContentCardDomain {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final AnswerCardTypeDomain c;
    @NotNull
    public final String d;
    @NotNull
    public final List<SliderSnapPointDomain> e;

    public SliderContentCardDomain(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @NotNull List<SliderSnapPointDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        Intrinsics.checkParameterIsNotNull(list, "pointDomains");
        this.a = i;
        this.b = str;
        this.c = answerCardTypeDomain;
        this.d = str2;
        this.e = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.domain.chat.entity.card.SliderContentCardDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SliderContentCardDomain copy$default(SliderContentCardDomain sliderContentCardDomain, int i, String str, AnswerCardTypeDomain answerCardTypeDomain, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sliderContentCardDomain.getOrderId();
        }
        if ((i2 & 2) != 0) {
            str = sliderContentCardDomain.getTitle();
        }
        if ((i2 & 4) != 0) {
            answerCardTypeDomain = sliderContentCardDomain.getType();
        }
        if ((i2 & 8) != 0) {
            str2 = sliderContentCardDomain.d;
        }
        if ((i2 & 16) != 0) {
            list = sliderContentCardDomain.e;
        }
        return sliderContentCardDomain.copy(i, str, answerCardTypeDomain, str2, list);
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
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final List<SliderSnapPointDomain> component5() {
        return this.e;
    }

    @NotNull
    public final SliderContentCardDomain copy(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @NotNull List<SliderSnapPointDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        Intrinsics.checkParameterIsNotNull(list, "pointDomains");
        return new SliderContentCardDomain(i, str, answerCardTypeDomain, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderContentCardDomain)) {
            return false;
        }
        SliderContentCardDomain sliderContentCardDomain = (SliderContentCardDomain) obj;
        return getOrderId() == sliderContentCardDomain.getOrderId() && Intrinsics.areEqual(getTitle(), sliderContentCardDomain.getTitle()) && Intrinsics.areEqual(getType(), sliderContentCardDomain.getType()) && Intrinsics.areEqual(this.d, sliderContentCardDomain.d) && Intrinsics.areEqual(this.e, sliderContentCardDomain.e);
    }

    @NotNull
    public final String getFieldContentName() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain
    public int getOrderId() {
        return this.a;
    }

    @NotNull
    public final List<SliderSnapPointDomain> getPointDomains() {
        return this.e;
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
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<SliderSnapPointDomain> list = this.e;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SliderContentCardDomain(orderId=");
        L.append(getOrderId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", type=");
        L.append(getType());
        L.append(", fieldContentName=");
        L.append(this.d);
        L.append(", pointDomains=");
        return a.w(L, this.e, ")");
    }
}
