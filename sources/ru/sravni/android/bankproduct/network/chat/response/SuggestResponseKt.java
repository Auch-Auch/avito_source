package ru.sravni.android.bankproduct.network.chat.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.network.chat.response.SuggestResponse;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse$SuggestItem;", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "toAnswerSuggestionRepo", "(Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse$SuggestItem;)Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class SuggestResponseKt {
    @NotNull
    public static final AnswerSuggestionRepo toAnswerSuggestionRepo(@NotNull SuggestResponse.SuggestItem suggestItem) {
        Intrinsics.checkParameterIsNotNull(suggestItem, "$this$toAnswerSuggestionRepo");
        return new AnswerSuggestionRepo(suggestItem.getText(), suggestItem.getSubText(), suggestItem.getOptionalFields(), suggestItem.isComplete());
    }
}
