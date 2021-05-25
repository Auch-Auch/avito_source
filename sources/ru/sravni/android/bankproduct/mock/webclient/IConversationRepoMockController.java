package ru.sravni.android.bankproduct.mock.webclient;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/IConversationRepoMockController;", "", "", "chatName", "", "pos", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "getMock", "(Ljava/lang/String;I)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "getSuggestion", "(I)Ljava/util/List;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IConversationRepoMockController {
    @NotNull
    ConversationRepo getMock(@NotNull String str, int i);

    @NotNull
    List<AnswerSuggestionRepo> getSuggestion(int i);
}
