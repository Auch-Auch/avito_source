package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ButtonAnswerItemSravniBinding;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ButtonAnswerInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/ButtonAnswerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/ButtonAnswerViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/ButtonAnswerViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/ButtonAnswerViewHolder;I)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "d", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "sendAnswer", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;", "c", "Ljava/util/List;", "buttonAnswerVariantList", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ButtonAnswerAdapter extends RecyclerView.Adapter<ButtonAnswerViewHolder> {
    public final List<ButtonAnswerInfo> c;
    public final INextContentCard d;

    public ButtonAnswerAdapter(@NotNull List<ButtonAnswerInfo> list, @NotNull INextContentCard iNextContentCard) {
        Intrinsics.checkParameterIsNotNull(list, "buttonAnswerVariantList");
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "sendAnswer");
        this.c = list;
        this.d = iNextContentCard;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public void onBindViewHolder(@NotNull ButtonAnswerViewHolder buttonAnswerViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(buttonAnswerViewHolder, "holder");
        buttonAnswerViewHolder.getItemBinding().setButtonAnswerInfo(this.c.get(i));
        buttonAnswerViewHolder.getItemBinding().setClickSendAnswer(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ButtonAnswerViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.button_answer_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        return new ButtonAnswerViewHolder((ButtonAnswerItemSravniBinding) inflate);
    }
}
