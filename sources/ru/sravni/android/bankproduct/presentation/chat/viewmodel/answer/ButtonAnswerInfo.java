package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "", "component2", "()Ljava/lang/String;", "answerInfoDomain", "actionText", "copy", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getActionText", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "<init>", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ButtonAnswerInfo {
    @NotNull
    public final AnswerInfoDomain a;
    @NotNull
    public final String b;

    public ButtonAnswerInfo(@NotNull AnswerInfoDomain answerInfoDomain, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answerInfoDomain");
        Intrinsics.checkParameterIsNotNull(str, "actionText");
        this.a = answerInfoDomain;
        this.b = str;
    }

    public static /* synthetic */ ButtonAnswerInfo copy$default(ButtonAnswerInfo buttonAnswerInfo, AnswerInfoDomain answerInfoDomain, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            answerInfoDomain = buttonAnswerInfo.a;
        }
        if ((i & 2) != 0) {
            str = buttonAnswerInfo.b;
        }
        return buttonAnswerInfo.copy(answerInfoDomain, str);
    }

    @NotNull
    public final AnswerInfoDomain component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final ButtonAnswerInfo copy(@NotNull AnswerInfoDomain answerInfoDomain, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answerInfoDomain");
        Intrinsics.checkParameterIsNotNull(str, "actionText");
        return new ButtonAnswerInfo(answerInfoDomain, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonAnswerInfo)) {
            return false;
        }
        ButtonAnswerInfo buttonAnswerInfo = (ButtonAnswerInfo) obj;
        return Intrinsics.areEqual(this.a, buttonAnswerInfo.a) && Intrinsics.areEqual(this.b, buttonAnswerInfo.b);
    }

    @NotNull
    public final String getActionText() {
        return this.b;
    }

    @NotNull
    public final AnswerInfoDomain getAnswerInfoDomain() {
        return this.a;
    }

    public int hashCode() {
        AnswerInfoDomain answerInfoDomain = this.a;
        int i = 0;
        int hashCode = (answerInfoDomain != null ? answerInfoDomain.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ButtonAnswerInfo(answerInfoDomain=");
        L.append(this.a);
        L.append(", actionText=");
        return a.t(L, this.b, ")");
    }
}
