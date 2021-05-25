package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.ChatDocumentItemSravniBinding;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageDocumentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "listFields", "", "bindMessageFields", "(Ljava/util/List;)V", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/IMessageItemAdapter;", "s", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/IMessageItemAdapter;", "messageItemAdapter", "Lru/sravni/android/bankproduct/databinding/ChatDocumentItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/IMessageItemAdapter;Lru/sravni/android/bankproduct/databinding/ChatDocumentItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageDocumentViewHolder extends RecyclerView.ViewHolder {
    public final IMessageItemAdapter s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageDocumentViewHolder(@NotNull IMessageItemAdapter iMessageItemAdapter, @NotNull ChatDocumentItemSravniBinding chatDocumentItemSravniBinding) {
        super(chatDocumentItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(iMessageItemAdapter, "messageItemAdapter");
        Intrinsics.checkParameterIsNotNull(chatDocumentItemSravniBinding, "itemBinding");
        this.s = iMessageItemAdapter;
    }

    public final void bindMessageFields(@NotNull List<MessageDomain> list) {
        Intrinsics.checkParameterIsNotNull(list, "listFields");
        this.s.setFields(list);
    }
}
