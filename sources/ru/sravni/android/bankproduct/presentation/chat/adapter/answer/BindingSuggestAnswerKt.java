package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
import ru.sravni.android.bankproduct.utils.animation.AnimationListenerAdapter;
import ru.sravni.android.bankproduct.utils.recycler.HeadDividerItemDecoration;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\f\u0010\u0011\u001a\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/widget/AutoCompleteTextView;", "view", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISuggestionAnswerViewModel;", "viewModel", "", "suggestText", "", "bindViewModelToAutoCompleteTextInit", "(Landroid/widget/AutoCompleteTextView;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISuggestionAnswerViewModel;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;", "suggestSetter", "bindSuggestItemsToAutoComplete", "(Landroidx/recyclerview/widget/RecyclerView;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ISetSuggestion;)V", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;", "items", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "target", "", "listSize", "bindSuggestVisibilityAnimation", "(Landroid/view/ViewGroup;I)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingSuggestAnswerKt {

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Animator, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Animator animator) {
            int i = this.a;
            if (i == 0) {
                ((ViewGroup) this.b).setVisibility(0);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((ViewGroup) this.b).setVisibility(8);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ ISuggestionAnswerViewModel b;

        public b(AutoCompleteTextView autoCompleteTextView, ISuggestionAnswerViewModel iSuggestionAnswerViewModel, String str) {
            this.a = autoCompleteTextView;
            this.b = iSuggestionAnswerViewModel;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Rect rect = new Rect(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
            Intrinsics.checkExpressionValueIsNotNull(motionEvent, "event");
            if (motionEvent.getAction() != 1 || !rect.contains(this.a.getLeft() + ((int) motionEvent.getX()), this.a.getTop() + ((int) motionEvent.getY()))) {
                return false;
            }
            this.b.needShowSuggestions();
            this.a.setOnTouchListener(null);
            return false;
        }
    }

    @BindingAdapter({"suggestSetter"})
    public static final void bindSuggestItemsToAutoComplete(@NotNull RecyclerView recyclerView, @NotNull ISetSuggestion iSetSuggestion) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iSetSuggestion, "suggestSetter");
        recyclerView.setAdapter(new SuggestListAdapter(iSetSuggestion));
        recyclerView.addItemDecoration(new HeadDividerItemDecoration(recyclerView, R.layout.suggest_divider_view_sravni, R.dimen.dim_1));
    }

    @BindingAdapter({"suggestListSizeForAnimation"})
    public static final void bindSuggestVisibilityAnimation(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "target");
        if (i > 0) {
            viewGroup.animate().alpha(1.0f).setDuration(300).setListener(new AnimationListenerAdapter(null, null, null, new a(0, viewGroup), 7, null)).start();
        } else {
            viewGroup.animate().alpha(0.0f).setDuration(200).setListener(new AnimationListenerAdapter(null, new a(1, viewGroup), null, null, 13, null)).start();
        }
    }

    @BindingAdapter({"suggestionAnswerViewModel", "suggestText"})
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void bindViewModelToAutoCompleteTextInit(@NotNull AutoCompleteTextView autoCompleteTextView, @Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(autoCompleteTextView, "view");
        if (iSuggestionAnswerViewModel != null) {
            autoCompleteTextView.removeTextChangedListener(iSuggestionAnswerViewModel.getTextWatcher());
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setSelection(str != null ? str.length() : 0);
            autoCompleteTextView.addTextChangedListener(iSuggestionAnswerViewModel.getTextWatcher());
            autoCompleteTextView.setOnTouchListener(new b(autoCompleteTextView, iSuggestionAnswerViewModel, str));
        }
    }

    @BindingAdapter({"suggestValues"})
    public static final void bindSuggestItemsToAutoComplete(@NotNull RecyclerView recyclerView, @Nullable List<SuggestInfo> list) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        if (list != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (!(adapter instanceof SuggestListAdapter)) {
                adapter = null;
            }
            SuggestListAdapter suggestListAdapter = (SuggestListAdapter) adapter;
            if (suggestListAdapter != null) {
                suggestListAdapter.setSuggestList(list);
            }
        }
    }
}
