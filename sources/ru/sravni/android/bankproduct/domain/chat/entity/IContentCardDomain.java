package ru.sravni.android.bankproduct.domain.chat.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "", "", "getTitle", "()Ljava/lang/String;", "title", "", "getOrderId", "()I", AnalyticFieldsName.orderId, "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getType", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "type", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IContentCardDomain {
    int getOrderId();

    @NotNull
    String getTitle();

    @NotNull
    AnswerCardTypeDomain getType();
}
