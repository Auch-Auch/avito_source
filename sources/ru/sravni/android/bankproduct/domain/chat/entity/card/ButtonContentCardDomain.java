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
import ru.sravni.android.bankproduct.domain.chat.entity.ContentCardActionInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\n¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/ButtonContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/ContentCardActionInfoDomain;", "component4", "()Ljava/util/List;", AnalyticFieldsName.orderId, "title", "type", "actions", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/chat/entity/card/ButtonContentCardDomain;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getOrderId", "d", "Ljava/util/List;", "getActions", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ButtonContentCardDomain implements IContentCardDomain {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final AnswerCardTypeDomain c;
    @NotNull
    public final List<ContentCardActionInfoDomain> d;

    public ButtonContentCardDomain(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull List<ContentCardActionInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(list, "actions");
        this.a = i;
        this.b = str;
        this.c = answerCardTypeDomain;
        this.d = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.chat.entity.card.ButtonContentCardDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonContentCardDomain copy$default(ButtonContentCardDomain buttonContentCardDomain, int i, String str, AnswerCardTypeDomain answerCardTypeDomain, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = buttonContentCardDomain.getOrderId();
        }
        if ((i2 & 2) != 0) {
            str = buttonContentCardDomain.getTitle();
        }
        if ((i2 & 4) != 0) {
            answerCardTypeDomain = buttonContentCardDomain.getType();
        }
        if ((i2 & 8) != 0) {
            list = buttonContentCardDomain.d;
        }
        return buttonContentCardDomain.copy(i, str, answerCardTypeDomain, list);
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
    public final List<ContentCardActionInfoDomain> component4() {
        return this.d;
    }

    @NotNull
    public final ButtonContentCardDomain copy(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull List<ContentCardActionInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(list, "actions");
        return new ButtonContentCardDomain(i, str, answerCardTypeDomain, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonContentCardDomain)) {
            return false;
        }
        ButtonContentCardDomain buttonContentCardDomain = (ButtonContentCardDomain) obj;
        return getOrderId() == buttonContentCardDomain.getOrderId() && Intrinsics.areEqual(getTitle(), buttonContentCardDomain.getTitle()) && Intrinsics.areEqual(getType(), buttonContentCardDomain.getType()) && Intrinsics.areEqual(this.d, buttonContentCardDomain.d);
    }

    @NotNull
    public final List<ContentCardActionInfoDomain> getActions() {
        return this.d;
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
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        List<ContentCardActionInfoDomain> list = this.d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ButtonContentCardDomain(orderId=");
        L.append(getOrderId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", type=");
        L.append(getType());
        L.append(", actions=");
        return a.w(L, this.d, ")");
    }
}
