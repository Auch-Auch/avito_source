package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IOsagoOffersAnswerViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "nextContentCard", "", "clickShowOsagoResult", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOsagoOffersAnswerViewModel extends IChatAnswerInitialize {
    void clickShowOsagoResult(@NotNull INextContentCard iNextContentCard);
}
