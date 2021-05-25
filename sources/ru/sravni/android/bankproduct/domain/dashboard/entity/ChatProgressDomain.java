package ru.sravni.android.bankproduct.domain.dashboard.entity;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\f\u0010\rR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/entity/ChatProgressDomain;", "", "", "Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getListFinanceDraft", "()Ljava/util/List;", "listFinanceDraft", AuthSource.BOOKING_ORDER, "getListInsuranceDraft", "listInsuranceDraft", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatProgressDomain {
    @NotNull
    public final List<DraftDomain> a;
    @NotNull
    public final List<DraftDomain> b;

    public ChatProgressDomain(@NotNull List<DraftDomain> list, @NotNull List<DraftDomain> list2) {
        Intrinsics.checkParameterIsNotNull(list, "listFinanceDraft");
        Intrinsics.checkParameterIsNotNull(list2, "listInsuranceDraft");
        this.a = list;
        this.b = list2;
    }

    @NotNull
    public final List<DraftDomain> getListFinanceDraft() {
        return this.a;
    }

    @NotNull
    public final List<DraftDomain> getListInsuranceDraft() {
        return this.b;
    }
}
