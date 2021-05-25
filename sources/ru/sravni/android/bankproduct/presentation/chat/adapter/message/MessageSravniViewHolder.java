package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageSravniViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD, "", "lastMessageInGroup", "", "bind", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;Z)V", "Lru/sravni/android/bankproduct/databinding/ChatMessageSravniItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/ChatMessageSravniItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/ChatMessageSravniItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageSravniViewHolder extends RecyclerView.ViewHolder {
    public final ChatMessageSravniItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageSravniViewHolder(@NotNull ChatMessageSravniItemSravniBinding chatMessageSravniItemSravniBinding) {
        super(chatMessageSravniItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(chatMessageSravniItemSravniBinding, "itemBinding");
        this.s = chatMessageSravniItemSravniBinding;
    }

    public final void bind(@NotNull ChatViewCard chatViewCard, boolean z) {
        Intrinsics.checkParameterIsNotNull(chatViewCard, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD);
        this.s.setMessageDescription(new SravniMessageItemDescription(chatViewCard.getText(), chatViewCard.getStatus(), z, chatViewCard.getTimeString(), z && chatViewCard.getStatus() == ViewHolderMessageStatusEnum.SUCCESS));
    }
}
