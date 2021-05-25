package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBinding;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/DocumentHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "messageDomain", "", "bind", "(Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;)V", "Lru/sravni/android/bankproduct/databinding/ChatDocumentHeaderItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/ChatDocumentHeaderItemSravniBinding;", "getItemBinding", "()Lru/sravni/android/bankproduct/databinding/ChatDocumentHeaderItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/ChatDocumentHeaderItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DocumentHeaderViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final ChatDocumentHeaderItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentHeaderViewHolder(@NotNull ChatDocumentHeaderItemSravniBinding chatDocumentHeaderItemSravniBinding) {
        super(chatDocumentHeaderItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(chatDocumentHeaderItemSravniBinding, "itemBinding");
        this.s = chatDocumentHeaderItemSravniBinding;
    }

    public final void bind(@NotNull MessageDomain messageDomain) {
        Intrinsics.checkParameterIsNotNull(messageDomain, "messageDomain");
        this.s.setTitle(messageDomain.getHeader());
        this.s.setHeaderInfoLogo(messageDomain.getHeaderInfoLogo());
    }

    @NotNull
    public final ChatDocumentHeaderItemSravniBinding getItemBinding() {
        return this.s;
    }
}
