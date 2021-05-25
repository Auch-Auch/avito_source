package ru.sravni.android.bankproduct.domain.chat;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/ISelectUserAnswer;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answer", "", "setAnswerInfo", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISelectUserAnswer {
    void setAnswerInfo(@NotNull AnswerInfoDomain answerInfoDomain);
}
