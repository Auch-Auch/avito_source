package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/CardActionRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "code", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/chat/entity/CardActionRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", AuthSource.BOOKING_ORDER, "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CardActionRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public CardActionRepo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ CardActionRepo copy$default(CardActionRepo cardActionRepo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardActionRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = cardActionRepo.b;
        }
        return cardActionRepo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final CardActionRepo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return new CardActionRepo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardActionRepo)) {
            return false;
        }
        CardActionRepo cardActionRepo = (CardActionRepo) obj;
        return Intrinsics.areEqual(this.a, cardActionRepo.a) && Intrinsics.areEqual(this.b, cardActionRepo.b);
    }

    @NotNull
    public final String getCode() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CardActionRepo(code=");
        L.append(this.a);
        L.append(", text=");
        return a.t(L, this.b, ")");
    }
}
