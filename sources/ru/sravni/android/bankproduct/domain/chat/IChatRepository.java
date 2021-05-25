package ru.sravni.android.bankproduct.domain.chat;

import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerSuggestionDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ChatAnalyticInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00140\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH&¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00140\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/IChatRepository;", "", "", "chatName", "", "startChat", "(Ljava/lang/String;)V", "conversationID", "continueChat", AnalyticFieldsName.conversationID, "restartChat", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answer", "sendAnswer", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "", "cardId", "elementName", "userText", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerSuggestionDomain;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "currentOrder", "targetOrder", "rollBack", "(Ljava/lang/String;II)V", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)V", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationDomain;", "getConversationChannel", "()Lio/reactivex/Observable;", "conversationChannel", "Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "getAnalyticsInfoChannel", "analyticsInfoChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IChatRepository {
    void continueChat(@NotNull String str);

    @NotNull
    Observable<ChatAnalyticInfoDomain> getAnalyticsInfoChannel();

    @NotNull
    Observable<DataContainer<ConversationDomain>> getConversationChannel();

    @NotNull
    Observable<DataContainer<List<AnswerSuggestionDomain>>> getSuggestion(@NotNull String str, int i, @NotNull String str2, @NotNull String str3);

    void restartChat(@NotNull String str);

    void restoreChat(@NotNull String str, @NotNull Map<String, String> map);

    void rollBack(@NotNull String str, int i, int i2);

    void sendAnswer(@NotNull AnswerInfoDomain answerInfoDomain);

    void startChat(@NotNull String str);
}
