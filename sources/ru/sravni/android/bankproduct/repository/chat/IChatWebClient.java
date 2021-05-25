package ru.sravni.android.bankproduct.repository.chat;

import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.NextConversationInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H&¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;", "", "", "chatName", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "startChat", "(Ljava/lang/String;)Lio/reactivex/Observable;", "conversationID", "continueChat", AnalyticFieldsName.conversationID, "restartChat", "Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;", "nextInfoRepo", "next", "(Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;)Lio/reactivex/Observable;", "", "cardId", "elementName", "userText", "", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "currentOrder", "targetOrder", "rollBack", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IChatWebClient {
    @NotNull
    Observable<ConversationRepo> continueChat(@NotNull String str);

    @NotNull
    Observable<List<AnswerSuggestionRepo>> getSuggestion(@NotNull String str, int i, @NotNull String str2, @NotNull String str3);

    @NotNull
    Observable<ConversationRepo> next(@NotNull NextConversationInfoRepo nextConversationInfoRepo);

    @NotNull
    Observable<ConversationRepo> restartChat(@NotNull String str);

    @NotNull
    Observable<ConversationRepo> restoreChat(@NotNull String str, @NotNull Map<String, String> map);

    @NotNull
    Observable<ConversationRepo> rollBack(@NotNull String str, int i, int i2);

    @NotNull
    Observable<ConversationRepo> startChat(@NotNull String str);
}
