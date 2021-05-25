package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SliderAnswerItem;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "cardId", AnalyticFieldsName.conversationID, "fieldName", "label", "key", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SliderAnswerItem;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getFieldName", AuthSource.SEND_ABUSE, "I", "getCardId", AuthSource.BOOKING_ORDER, "getConversationId", "e", "getKey", "d", "getLabel", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SliderAnswerItem {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;

    public SliderAnswerItem(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(str2, "fieldName");
        Intrinsics.checkParameterIsNotNull(str3, "label");
        Intrinsics.checkParameterIsNotNull(str4, "key");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public static /* synthetic */ SliderAnswerItem copy$default(SliderAnswerItem sliderAnswerItem, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sliderAnswerItem.a;
        }
        if ((i2 & 2) != 0) {
            str = sliderAnswerItem.b;
        }
        if ((i2 & 4) != 0) {
            str2 = sliderAnswerItem.c;
        }
        if ((i2 & 8) != 0) {
            str3 = sliderAnswerItem.d;
        }
        if ((i2 & 16) != 0) {
            str4 = sliderAnswerItem.e;
        }
        return sliderAnswerItem.copy(i, str, str2, str3, str4);
    }

    public final int component1() {
        return this.a;
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

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final SliderAnswerItem copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(str2, "fieldName");
        Intrinsics.checkParameterIsNotNull(str3, "label");
        Intrinsics.checkParameterIsNotNull(str4, "key");
        return new SliderAnswerItem(i, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderAnswerItem)) {
            return false;
        }
        SliderAnswerItem sliderAnswerItem = (SliderAnswerItem) obj;
        return this.a == sliderAnswerItem.a && Intrinsics.areEqual(this.b, sliderAnswerItem.b) && Intrinsics.areEqual(this.c, sliderAnswerItem.c) && Intrinsics.areEqual(this.d, sliderAnswerItem.d) && Intrinsics.areEqual(this.e, sliderAnswerItem.e);
    }

    public final int getCardId() {
        return this.a;
    }

    @NotNull
    public final String getConversationId() {
        return this.b;
    }

    @NotNull
    public final String getFieldName() {
        return this.c;
    }

    @NotNull
    public final String getKey() {
        return this.e;
    }

    @NotNull
    public final String getLabel() {
        return this.d;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SliderAnswerItem(cardId=");
        L.append(this.a);
        L.append(", conversationId=");
        L.append(this.b);
        L.append(", fieldName=");
        L.append(this.c);
        L.append(", label=");
        L.append(this.d);
        L.append(", key=");
        return a.t(L, this.e, ")");
    }
}
