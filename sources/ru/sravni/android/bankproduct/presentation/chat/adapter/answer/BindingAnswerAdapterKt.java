package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.chat.entity.TextWithSelectionToEnd;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ButtonAnswerInfo;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;", "buttonAnswerVariantList", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "clickSendAnswer", "", "bindListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "Landroid/widget/EditText;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IFreeTextAnswerViewModel;", "viewModel", "bindTextToEditText", "(Landroid/widget/EditText;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IFreeTextAnswerViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingAnswerAdapterKt {
    @BindingAdapter({"buttonAnswerVariantList", "clickSendAnswer"})
    public static final void bindListToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<ButtonAnswerInfo> list, @NotNull INextContentCard iNextContentCard) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "clickSendAnswer");
        if (list != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(list) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingAnswerAdapterKt$createGridLayoutManager$1
                public final /* synthetic */ List e;

                {
                    this.e = r1;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    return (i != this.e.size() - 1 || this.e.size() % 2 == 0) ? 1 : 2;
                }
            });
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(new ButtonAnswerAdapter(list, iNextContentCard));
        }
    }

    @BindingAdapter({"viewModel"})
    public static final void bindTextToEditText(@NotNull EditText editText, @NotNull IFreeTextAnswerViewModel iFreeTextAnswerViewModel) {
        Intrinsics.checkParameterIsNotNull(editText, "view");
        Intrinsics.checkParameterIsNotNull(iFreeTextAnswerViewModel, "viewModel");
        editText.addTextChangedListener(new TextWatcher(editText, iFreeTextAnswerViewModel) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingAnswerAdapterKt$bindTextToEditText$1
            public final /* synthetic */ EditText a;
            public final /* synthetic */ IFreeTextAnswerViewModel b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                this.a.removeTextChangedListener(this);
                TextWithSelectionToEnd textChangedAction = this.b.textChangedAction(String.valueOf(charSequence));
                if (!Intrinsics.areEqual(textChangedAction.getText(), this.a.getText().toString())) {
                    this.a.setText(textChangedAction.getText());
                }
                if (textChangedAction.getNeedMoveSelectionToEnd()) {
                    EditText editText2 = this.a;
                    editText2.setSelection(editText2.getText().length());
                }
                this.a.addTextChangedListener(this);
            }
        });
    }
}
