package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.presentation.chat.entity.TextWithSelectionToEnd;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IFreeTextAnswerViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "getAnswerInfoDomain", "()Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "", "text", "Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "textChangedAction", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "Landroidx/lifecycle/LiveData;", "", "getCanAnswer", "()Landroidx/lifecycle/LiveData;", "canAnswer", "getSuggestText", "suggestText", "getHint", "hint", "", "getInputType", "inputType", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IFreeTextAnswerViewModel extends IChatAnswerInitialize {
    @NotNull
    AnswerInfoDomain getAnswerInfoDomain();

    @NotNull
    LiveData<Boolean> getCanAnswer();

    @NotNull
    LiveData<String> getHint();

    @NotNull
    LiveData<Integer> getInputType();

    @NotNull
    LiveData<String> getSuggestText();

    @NotNull
    TextWithSelectionToEnd textChangedAction(@NotNull String str);
}
