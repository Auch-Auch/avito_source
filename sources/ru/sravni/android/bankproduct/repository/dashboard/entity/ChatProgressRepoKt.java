package ru.sravni.android.bankproduct.repository.dashboard.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.dashboard.entity.ChatProgressDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.DraftDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "Lru/sravni/android/bankproduct/domain/dashboard/entity/ChatProgressDomain;", "toChatProgressDomain", "(Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;)Lru/sravni/android/bankproduct/domain/dashboard/entity/ChatProgressDomain;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/DraftRepo;", "Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", "toDraftDomain", "(Lru/sravni/android/bankproduct/repository/dashboard/entity/DraftRepo;)Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ChatProgressRepoKt {
    @NotNull
    public static final ChatProgressDomain toChatProgressDomain(@NotNull ChatProgressRepo chatProgressRepo) {
        Intrinsics.checkParameterIsNotNull(chatProgressRepo, "$this$toChatProgressDomain");
        List<DraftRepo> listFinanceDraft = chatProgressRepo.getListFinanceDraft();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(listFinanceDraft, 10));
        Iterator<T> it = listFinanceDraft.iterator();
        while (it.hasNext()) {
            arrayList.add(toDraftDomain(it.next()));
        }
        List<DraftRepo> listInsuranceDraft = chatProgressRepo.getListInsuranceDraft();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(listInsuranceDraft, 10));
        Iterator<T> it2 = listInsuranceDraft.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toDraftDomain(it2.next()));
        }
        return new ChatProgressDomain(arrayList, arrayList2);
    }

    @NotNull
    public static final DraftDomain toDraftDomain(@NotNull DraftRepo draftRepo) {
        Intrinsics.checkParameterIsNotNull(draftRepo, "$this$toDraftDomain");
        return new DraftDomain(draftRepo.getConversationID(), draftRepo.getProductName(), draftRepo.getProgress());
    }
}
