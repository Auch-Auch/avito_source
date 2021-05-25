package ru.sravni.android.bankproduct.presentation.chat.viewmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;", "", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "chatViewCard", "", "itemClicked", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IChatMessageClickListener {
    void itemClicked(@NotNull ChatViewCard chatViewCard);
}
