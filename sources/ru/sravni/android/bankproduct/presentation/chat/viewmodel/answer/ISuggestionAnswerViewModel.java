package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import android.text.TextWatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.editional.ISuggestAnswerParam;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISuggestionAnswerViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/editional/ISuggestAnswerParam;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "answerSender", "", "sendAnswer", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "needShowSuggestions", "()V", "Landroid/text/TextWatcher;", "getTextWatcher", "()Landroid/text/TextWatcher;", "textWatcher", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISuggestionAnswerViewModel extends ISetSuggestion, ISuggestAnswerParam, IChatAnswerInitialize {
    @NotNull
    TextWatcher getTextWatcher();

    void needShowSuggestions();

    void sendAnswer(@NotNull INextContentCard iNextContentCard);
}
