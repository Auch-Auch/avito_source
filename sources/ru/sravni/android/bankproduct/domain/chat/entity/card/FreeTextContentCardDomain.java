package ru.sravni.android.bankproduct.domain.chat.entity.card;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\nR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/FreeTextContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/card/ITextAnswerContentCardDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component4", "component5", "component6", "component7", AnalyticFieldsName.orderId, "title", "type", "fieldContentName", "hint", "suggestText", "keyboardType", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/chat/entity/card/FreeTextContentCardDomain;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getSuggestText", AuthSource.BOOKING_ORDER, "getTitle", "d", "getFieldContentName", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", "e", "getHint", AuthSource.SEND_ABUSE, "I", "getOrderId", g.a, "getKeyboardType", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FreeTextContentCardDomain implements ITextAnswerContentCardDomain {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final AnswerCardTypeDomain c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;

    public FreeTextContentCardDomain(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        this.a = i;
        this.b = str;
        this.c = answerCardTypeDomain;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    public static /* synthetic */ FreeTextContentCardDomain copy$default(FreeTextContentCardDomain freeTextContentCardDomain, int i, String str, AnswerCardTypeDomain answerCardTypeDomain, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = freeTextContentCardDomain.getOrderId();
        }
        if ((i2 & 2) != 0) {
            str = freeTextContentCardDomain.getTitle();
        }
        if ((i2 & 4) != 0) {
            answerCardTypeDomain = freeTextContentCardDomain.getType();
        }
        if ((i2 & 8) != 0) {
            str2 = freeTextContentCardDomain.getFieldContentName();
        }
        if ((i2 & 16) != 0) {
            str3 = freeTextContentCardDomain.getHint();
        }
        if ((i2 & 32) != 0) {
            str4 = freeTextContentCardDomain.getSuggestText();
        }
        if ((i2 & 64) != 0) {
            str5 = freeTextContentCardDomain.getKeyboardType();
        }
        return freeTextContentCardDomain.copy(i, str, answerCardTypeDomain, str2, str3, str4, str5);
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
        return getFieldContentName();
    }

    @Nullable
    public final String component5() {
        return getHint();
    }

    @Nullable
    public final String component6() {
        return getSuggestText();
    }

    @Nullable
    public final String component7() {
        return getKeyboardType();
    }

    @NotNull
    public final FreeTextContentCardDomain copy(int i, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        return new FreeTextContentCardDomain(i, str, answerCardTypeDomain, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeTextContentCardDomain)) {
            return false;
        }
        FreeTextContentCardDomain freeTextContentCardDomain = (FreeTextContentCardDomain) obj;
        return getOrderId() == freeTextContentCardDomain.getOrderId() && Intrinsics.areEqual(getTitle(), freeTextContentCardDomain.getTitle()) && Intrinsics.areEqual(getType(), freeTextContentCardDomain.getType()) && Intrinsics.areEqual(getFieldContentName(), freeTextContentCardDomain.getFieldContentName()) && Intrinsics.areEqual(getHint(), freeTextContentCardDomain.getHint()) && Intrinsics.areEqual(getSuggestText(), freeTextContentCardDomain.getSuggestText()) && Intrinsics.areEqual(getKeyboardType(), freeTextContentCardDomain.getKeyboardType());
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.card.ITextAnswerContentCardDomain
    @NotNull
    public String getFieldContentName() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.card.ITextAnswerContentCardDomain
    @Nullable
    public String getHint() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.card.ITextAnswerContentCardDomain
    @Nullable
    public String getKeyboardType() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain
    public int getOrderId() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.entity.card.ITextAnswerContentCardDomain
    @Nullable
    public String getSuggestText() {
        return this.f;
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
        String fieldContentName = getFieldContentName();
        int hashCode3 = (hashCode2 + (fieldContentName != null ? fieldContentName.hashCode() : 0)) * 31;
        String hint = getHint();
        int hashCode4 = (hashCode3 + (hint != null ? hint.hashCode() : 0)) * 31;
        String suggestText = getSuggestText();
        int hashCode5 = (hashCode4 + (suggestText != null ? suggestText.hashCode() : 0)) * 31;
        String keyboardType = getKeyboardType();
        if (keyboardType != null) {
            i = keyboardType.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FreeTextContentCardDomain(orderId=");
        L.append(getOrderId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", type=");
        L.append(getType());
        L.append(", fieldContentName=");
        L.append(getFieldContentName());
        L.append(", hint=");
        L.append(getHint());
        L.append(", suggestText=");
        L.append(getSuggestText());
        L.append(", keyboardType=");
        L.append(getKeyboardType());
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FreeTextContentCardDomain(int i, String str, AnswerCardTypeDomain answerCardTypeDomain, String str2, String str3, String str4, String str5, int i2, j jVar) {
        this(i, str, answerCardTypeDomain, str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5);
    }
}
