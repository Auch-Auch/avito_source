package ru.sravni.android.bankproduct.presentation.chat.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageContainer;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;", "", "restartChat", "()V", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageContainer;", "getMessagesContainer", "()Landroidx/lifecycle/LiveData;", "messagesContainer", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", "getTypeAnswer", "typeAnswer", "", "getRestartChatActive", "restartChatActive", "", "getTitleChat", "titleChat", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IChatViewModel extends INextContentCard, IChatMessageClickListener {
    @NotNull
    LiveData<MessageContainer> getMessagesContainer();

    @NotNull
    LiveData<Boolean> getRestartChatActive();

    @NotNull
    LiveData<String> getTitleChat();

    @NotNull
    LiveData<AnswerCardTypeDomain> getTypeAnswer();

    void restartChat();
}
