package com.avito.android.location_picker.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.location_picker.R;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/location_picker/view/SuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "t", "getSubtextView", "subtextView", "Lio/reactivex/rxjava3/core/Observable;", "", "u", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestionViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final TextView s;
    @NotNull
    public final TextView t;
    @NotNull
    public final Observable<Integer> u;

    public static final class a<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ SuggestionViewHolder a;

        public a(SuggestionViewHolder suggestionViewHolder) {
            this.a = suggestionViewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return Integer.valueOf(this.a.getAdapterPosition());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestionViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.text_view)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtext_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.subtext_view)");
        this.t = (TextView) findViewById2;
        Observable<Integer> map = InteropKt.toV3(RxView.clicks(view)).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "view.clicks().toV3().map { adapterPosition }");
        this.u = map;
    }

    @NotNull
    public final Observable<Integer> getClicks() {
        return this.u;
    }

    @NotNull
    public final TextView getSubtextView() {
        return this.t;
    }

    @NotNull
    public final TextView getTextView() {
        return this.s;
    }
}
