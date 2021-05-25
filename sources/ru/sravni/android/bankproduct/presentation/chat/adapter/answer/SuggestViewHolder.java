package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.SuggestItemSravniBinding;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/answer/SuggestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "suggestInfo", "", VKApiConst.POSITION, "", "bind", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;I)V", "Lru/sravni/android/bankproduct/databinding/SuggestItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/SuggestItemSravniBinding;", "binding", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "t", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "onItemSelected", "<init>", "(Lru/sravni/android/bankproduct/databinding/SuggestItemSravniBinding;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SuggestViewHolder extends RecyclerView.ViewHolder {
    public final SuggestItemSravniBinding s;
    public final ISetSuggestion t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SuggestViewHolder a;
        public final /* synthetic */ SuggestInfo b;

        public a(SuggestViewHolder suggestViewHolder, SuggestInfo suggestInfo) {
            this.a = suggestViewHolder;
            this.b = suggestInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.t.setSuggestInfo(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestViewHolder(@NotNull SuggestItemSravniBinding suggestItemSravniBinding, @NotNull ISetSuggestion iSetSuggestion) {
        super(suggestItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(suggestItemSravniBinding, "binding");
        Intrinsics.checkParameterIsNotNull(iSetSuggestion, "onItemSelected");
        this.s = suggestItemSravniBinding;
        this.t = iSetSuggestion;
    }

    public final void bind(@NotNull SuggestInfo suggestInfo, int i) {
        Intrinsics.checkParameterIsNotNull(suggestInfo, "suggestInfo");
        this.s.setSuggestInfo(suggestInfo);
        this.s.setFirstItem(Boolean.valueOf(i == 0));
        this.s.getRoot().setOnClickListener(new a(this, suggestInfo));
    }
}
