package a7.c.a.a.o.c.c;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatDiff;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageContainer;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModel;
import t6.n.d;
public final class a<T> implements Consumer<Long> {
    public final /* synthetic */ ChatViewModel.b a;
    public final /* synthetic */ MessageContainer b;
    public final /* synthetic */ ChatViewCard c;
    public final /* synthetic */ ConversationDomain d;

    public a(ChatViewModel.b bVar, MessageContainer messageContainer, ChatViewCard chatViewCard, ConversationDomain conversationDomain) {
        this.a = bVar;
        this.b = messageContainer;
        this.c = chatViewCard;
        this.d = conversationDomain;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Long l) {
        this.a.a.getMessagesContainer().setValue(new MessageContainer(this.b.getResultMessages(), new ChatDiff(null, null, d.listOf(ChatViewCard.copy$default(this.c, null, 0, null, null, ViewHolderMessageStatusEnum.SUCCESS, null, false, null, 239, null)), 3, null)));
        MutableLiveData<AnswerCardTypeDomain> typeAnswer = this.a.a.getTypeAnswer();
        IContentCardDomain contentCard = this.d.getContentCard();
        typeAnswer.setValue(contentCard != null ? contentCard.getType() : null);
    }
}
