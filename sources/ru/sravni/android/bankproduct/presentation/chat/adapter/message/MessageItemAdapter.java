package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.ChatDocumentInfoItemSravniBinding;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/IMessageItemAdapter;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "fields", "", "setFields", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "c", "Ljava/util/List;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IMessageItemAdapter {
    public List<MessageDomain> c = CollectionsKt__CollectionsKt.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.get(i).getHeader() != null ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        DocumentHeaderViewHolder documentHeaderViewHolder = (DocumentHeaderViewHolder) (!(viewHolder instanceof DocumentHeaderViewHolder) ? null : viewHolder);
        if (documentHeaderViewHolder != null) {
            documentHeaderViewHolder.bind(this.c.get(i));
        }
        if (!(viewHolder instanceof DocumentItemViewHolder)) {
            viewHolder = null;
        }
        DocumentItemViewHolder documentItemViewHolder = (DocumentItemViewHolder) viewHolder;
        if (documentItemViewHolder != null) {
            documentItemViewHolder.bind(this.c.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 1) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.chat_document_header_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…  false\n                )");
            return new DocumentHeaderViewHolder((ChatDocumentHeaderItemSravniBinding) inflate);
        } else if (i != 2) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…  false\n                )");
            return new EmptyViewHolder(inflate2);
        } else {
            ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.chat_document_info_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…  false\n                )");
            return new DocumentItemViewHolder((ChatDocumentInfoItemSravniBinding) inflate3);
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.adapter.message.IMessageItemAdapter
    public void setFields(@NotNull List<MessageDomain> list) {
        Intrinsics.checkParameterIsNotNull(list, "fields");
        this.c = list;
        notifyDataSetChanged();
    }
}
