package ru.sravni.android.bankproduct.network.dashboard.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.DraftRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/ChatProgressResponse;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "toChatProgressRepo", "(Lru/sravni/android/bankproduct/network/dashboard/response/ChatProgressResponse;)Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "Lru/sravni/android/bankproduct/network/dashboard/response/Draft;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/DraftRepo;", "toDraftRepo", "(Lru/sravni/android/bankproduct/network/dashboard/response/Draft;)Lru/sravni/android/bankproduct/repository/dashboard/entity/DraftRepo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ChatProgressResponseKt {
    @NotNull
    public static final ChatProgressRepo toChatProgressRepo(@NotNull ChatProgressResponse chatProgressResponse) {
        Intrinsics.checkParameterIsNotNull(chatProgressResponse, "$this$toChatProgressRepo");
        List<Draft> finance = chatProgressResponse.getFinance();
        if (finance == null) {
            finance = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(finance, 10));
        Iterator<T> it = finance.iterator();
        while (it.hasNext()) {
            arrayList.add(toDraftRepo(it.next()));
        }
        List<Draft> insurance = chatProgressResponse.getInsurance();
        if (insurance == null) {
            insurance = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(insurance, 10));
        Iterator<T> it2 = insurance.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toDraftRepo(it2.next()));
        }
        return new ChatProgressRepo(arrayList, arrayList2);
    }

    @NotNull
    public static final DraftRepo toDraftRepo(@NotNull Draft draft) {
        Intrinsics.checkParameterIsNotNull(draft, "$this$toDraftRepo");
        return new DraftRepo(draft.getId(), draft.getName(), draft.getPercentsPassed());
    }
}
