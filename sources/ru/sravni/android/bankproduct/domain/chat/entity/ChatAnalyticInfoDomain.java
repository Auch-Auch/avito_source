package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", AnalyticFieldsName.productName, AnalyticFieldsName.step, "isProlongation", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Boolean;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStep", AuthSource.SEND_ABUSE, "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatAnalyticInfoDomain {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Boolean c;

    public ChatAnalyticInfoDomain(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        this.a = str;
        this.b = str2;
        this.c = bool;
    }

    public static /* synthetic */ ChatAnalyticInfoDomain copy$default(ChatAnalyticInfoDomain chatAnalyticInfoDomain, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatAnalyticInfoDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = chatAnalyticInfoDomain.b;
        }
        if ((i & 4) != 0) {
            bool = chatAnalyticInfoDomain.c;
        }
        return chatAnalyticInfoDomain.copy(str, str2, bool);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Boolean component3() {
        return this.c;
    }

    @NotNull
    public final ChatAnalyticInfoDomain copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        return new ChatAnalyticInfoDomain(str, str2, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatAnalyticInfoDomain)) {
            return false;
        }
        ChatAnalyticInfoDomain chatAnalyticInfoDomain = (ChatAnalyticInfoDomain) obj;
        return Intrinsics.areEqual(this.a, chatAnalyticInfoDomain.a) && Intrinsics.areEqual(this.b, chatAnalyticInfoDomain.b) && Intrinsics.areEqual(this.c, chatAnalyticInfoDomain.c);
    }

    @Nullable
    public final String getProductName() {
        return this.a;
    }

    @Nullable
    public final String getStep() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.c;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @Nullable
    public final Boolean isProlongation() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatAnalyticInfoDomain(productName=");
        L.append(this.a);
        L.append(", step=");
        L.append(this.b);
        L.append(", isProlongation=");
        return a.o(L, this.c, ")");
    }
}
