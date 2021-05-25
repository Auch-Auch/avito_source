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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007Jp\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010\u0007R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b7\u0010\u0007¨\u0006:"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/MaskTextContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/card/ITextAnswerContentCardDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "component4", "component5", "component6", "component7", "component8", "component9", AnalyticFieldsName.orderId, "title", "type", "fieldContentName", "hint", "suggestText", "keyboardType", "mask", "maskPlaceHolder", "copy", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/chat/entity/card/MaskTextContentCardDomain;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getOrderId", "d", "Ljava/lang/String;", "getFieldContentName", g.a, "getKeyboardType", "h", "getMask", AuthSource.BOOKING_ORDER, "getTitle", "i", "getMaskPlaceHolder", "e", "getHint", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", "f", "getSuggestText", "<init>", "(ILjava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MaskTextContentCardDomain implements ITextAnswerContentCardDomain {
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
    @NotNull
    public final String h;
    @NotNull
    public final String i;

    public MaskTextContentCardDomain(int i2, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        Intrinsics.checkParameterIsNotNull(str6, "mask");
        Intrinsics.checkParameterIsNotNull(str7, "maskPlaceHolder");
        this.a = i2;
        this.b = str;
        this.c = answerCardTypeDomain;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
    }

    public static /* synthetic */ MaskTextContentCardDomain copy$default(MaskTextContentCardDomain maskTextContentCardDomain, int i2, String str, AnswerCardTypeDomain answerCardTypeDomain, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
        return maskTextContentCardDomain.copy((i3 & 1) != 0 ? maskTextContentCardDomain.getOrderId() : i2, (i3 & 2) != 0 ? maskTextContentCardDomain.getTitle() : str, (i3 & 4) != 0 ? maskTextContentCardDomain.getType() : answerCardTypeDomain, (i3 & 8) != 0 ? maskTextContentCardDomain.getFieldContentName() : str2, (i3 & 16) != 0 ? maskTextContentCardDomain.getHint() : str3, (i3 & 32) != 0 ? maskTextContentCardDomain.getSuggestText() : str4, (i3 & 64) != 0 ? maskTextContentCardDomain.getKeyboardType() : str5, (i3 & 128) != 0 ? maskTextContentCardDomain.h : str6, (i3 & 256) != 0 ? maskTextContentCardDomain.i : str7);
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
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final MaskTextContentCardDomain copy(int i2, @NotNull String str, @NotNull AnswerCardTypeDomain answerCardTypeDomain, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(answerCardTypeDomain, "type");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        Intrinsics.checkParameterIsNotNull(str6, "mask");
        Intrinsics.checkParameterIsNotNull(str7, "maskPlaceHolder");
        return new MaskTextContentCardDomain(i2, str, answerCardTypeDomain, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskTextContentCardDomain)) {
            return false;
        }
        MaskTextContentCardDomain maskTextContentCardDomain = (MaskTextContentCardDomain) obj;
        return getOrderId() == maskTextContentCardDomain.getOrderId() && Intrinsics.areEqual(getTitle(), maskTextContentCardDomain.getTitle()) && Intrinsics.areEqual(getType(), maskTextContentCardDomain.getType()) && Intrinsics.areEqual(getFieldContentName(), maskTextContentCardDomain.getFieldContentName()) && Intrinsics.areEqual(getHint(), maskTextContentCardDomain.getHint()) && Intrinsics.areEqual(getSuggestText(), maskTextContentCardDomain.getSuggestText()) && Intrinsics.areEqual(getKeyboardType(), maskTextContentCardDomain.getKeyboardType()) && Intrinsics.areEqual(this.h, maskTextContentCardDomain.h) && Intrinsics.areEqual(this.i, maskTextContentCardDomain.i);
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

    @NotNull
    public final String getMask() {
        return this.h;
    }

    @NotNull
    public final String getMaskPlaceHolder() {
        return this.i;
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
        int i2 = 0;
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
        int hashCode6 = (hashCode5 + (keyboardType != null ? keyboardType.hashCode() : 0)) * 31;
        String str = this.h;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.i;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode7 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MaskTextContentCardDomain(orderId=");
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
        L.append(", mask=");
        L.append(this.h);
        L.append(", maskPlaceHolder=");
        return a.t(L, this.i, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaskTextContentCardDomain(int i2, String str, AnswerCardTypeDomain answerCardTypeDomain, String str2, String str3, String str4, String str5, String str6, String str7, int i3, j jVar) {
        this(i2, str, answerCardTypeDomain, str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, str6, str7);
    }
}
