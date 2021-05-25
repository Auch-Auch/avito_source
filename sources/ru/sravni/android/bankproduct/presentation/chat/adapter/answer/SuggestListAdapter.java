package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.SuggestItemSravniBinding;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/SuggestListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "suggestList", "setSuggestList", "(Ljava/util/List;)V", "", "c", "Ljava/util/List;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "d", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "onItemSelected", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SuggestListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<SuggestInfo> c = new ArrayList();
    public final ISetSuggestion d;

    public SuggestListAdapter(@NotNull ISetSuggestion iSetSuggestion) {
        Intrinsics.checkParameterIsNotNull(iSetSuggestion, "onItemSelected");
        this.d = iSetSuggestion;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (!(viewHolder instanceof SuggestViewHolder)) {
            viewHolder = null;
        }
        SuggestViewHolder suggestViewHolder = (SuggestViewHolder) viewHolder;
        if (suggestViewHolder != null) {
            suggestViewHolder.bind(this.c.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.suggest_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…          false\n        )");
        return new SuggestViewHolder((SuggestItemSravniBinding) inflate, this.d);
    }

    public final void setSuggestList(@NotNull List<SuggestInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "suggestList");
        this.c.clear();
        this.c.addAll(list);
        notifyDataSetChanged();
    }
}
