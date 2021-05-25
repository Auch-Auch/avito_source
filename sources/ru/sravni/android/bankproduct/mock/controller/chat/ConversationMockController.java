package ru.sravni.android.bankproduct.mock.controller.chat;

import a2.b.a.a.a;
import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.mock.webclient.IConversationRepoMockController;
import ru.sravni.android.bankproduct.network.chat.response.ConversationItemResponse;
import ru.sravni.android.bankproduct.network.chat.response.ConversationMessageResponseKt;
import ru.sravni.android.bankproduct.network.chat.response.SuggestResponse;
import ru.sravni.android.bankproduct.network.chat.response.SuggestResponseKt;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/mock/controller/chat/ConversationMockController;", "Lru/sravni/android/bankproduct/mock/webclient/IConversationRepoMockController;", "", "chatName", "", "pos", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "getMock", "(Ljava/lang/String;I)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "getSuggestion", "(I)Ljava/util/List;", "Lru/sravni/android/bankproduct/network/chat/response/ConversationItemResponse;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "conversationInsuranceMocksList", AuthSource.SEND_ABUSE, "conversationMocksList", "Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse;", "c", "Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse;", "suggestResponseMock", "Landroid/content/Context;", "context", "Lru/sravni/android/bankproduct/mock/controller/chat/ConversationWebClientStubInfo;", "conversationInfo", "<init>", "(Landroid/content/Context;Lru/sravni/android/bankproduct/mock/controller/chat/ConversationWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ConversationMockController implements IConversationRepoMockController {
    public final List<ConversationItemResponse> a;
    public final List<ConversationItemResponse> b;
    public final SuggestResponse c;

    public ConversationMockController(@NotNull Context context, @NotNull ConversationWebClientStubInfo conversationWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(conversationWebClientStubInfo, "conversationInfo");
        this.a = (List) new Gson().fromJson(UtilFunctionsKt.readStringFromAsset(context, conversationWebClientStubInfo.getQuickCreditChatPath()), new TypeToken<List<? extends ConversationItemResponse>>() { // from class: ru.sravni.android.bankproduct.mock.controller.chat.ConversationMockController$$special$$inlined$readListFromAsset$1
        }.getType());
        this.b = (List) new Gson().fromJson(UtilFunctionsKt.readStringFromAsset(context, conversationWebClientStubInfo.getQuickInsuranceChatPath()), new TypeToken<List<? extends ConversationItemResponse>>() { // from class: ru.sravni.android.bankproduct.mock.controller.chat.ConversationMockController$$special$$inlined$readListFromAsset$2
        }.getType());
        this.c = (SuggestResponse) a.i2(UtilFunctionsKt.readStringFromAsset(context, conversationWebClientStubInfo.getSuggestChatPath()), SuggestResponse.class);
    }

    @Override // ru.sravni.android.bankproduct.mock.webclient.IConversationRepoMockController
    @NotNull
    public ConversationRepo getMock(@NotNull String str, int i) {
        ConversationItemResponse conversationItemResponse;
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        int hashCode = str.hashCode();
        if (hashCode != -1352291591) {
            if (hashCode == 106033317 && str.equals("osago")) {
                List<ConversationItemResponse> list = this.b;
                conversationItemResponse = list.get(i % list.size());
                return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
            }
        } else if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT)) {
            List<ConversationItemResponse> list2 = this.a;
            conversationItemResponse = list2.get(i % list2.size());
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
        List<ConversationItemResponse> list3 = this.a;
        conversationItemResponse = list3.get(i % list3.size());
        return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
    }

    @Override // ru.sravni.android.bankproduct.mock.webclient.IConversationRepoMockController
    @NotNull
    public List<AnswerSuggestionRepo> getSuggestion(int i) {
        List<SuggestResponse.SuggestItem> list;
        List<SuggestResponse.SuggestItem> items = this.c.getItems();
        List mutableList = items != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) items) : null;
        if (Random.Default.nextInt(2) % 2 == 0 && mutableList != null) {
            SuggestResponse.SuggestItem suggestItem = (SuggestResponse.SuggestItem) mutableList.remove(mutableList.size() / 2);
        }
        if (mutableList == null || (list = CollectionsKt___CollectionsKt.toList(mutableList)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (SuggestResponse.SuggestItem suggestItem2 : list) {
            AnswerSuggestionRepo answerSuggestionRepo = SuggestResponseKt.toAnswerSuggestionRepo(suggestItem2);
            arrayList.add(AnswerSuggestionRepo.copy$default(answerSuggestionRepo, null, Random.Default.nextInt(2) % 2 == 0 ? null : answerSuggestionRepo.getExtraSuggestion(), null, false, 13, null));
        }
        return arrayList;
    }
}
