package ru.sravni.android.bankproduct.domain.chat.entity.card;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/card/ICreditOffersContentCardDomain;", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "getSavedSearchID", "()Ljava/lang/String;", "savedSearchID", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ICreditOffersContentCardDomain extends IContentCardDomain {
    @NotNull
    String getSavedSearchID();
}
