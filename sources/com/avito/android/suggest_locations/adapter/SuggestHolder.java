package com.avito.android.suggest_locations.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.suggest_locations.R;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", "bind", "(Ljava/lang/Object;)V", "Lio/reactivex/rxjava3/core/Observable;", "", "s", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "getTextLocation", "()Landroid/widget/TextView;", "textLocation", "u", "getTextParent", "textParent", "Landroid/widget/ImageView;", VKApiConst.VERSION, "Landroid/widget/ImageView;", "getImageSuggestType", "()Landroid/widget/ImageView;", "imageSuggestType", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public abstract class SuggestHolder<T> extends RecyclerView.ViewHolder {
    @NotNull
    public final Observable<Integer> s;
    @NotNull
    public final TextView t;
    @NotNull
    public final TextView u;
    @NotNull
    public final ImageView v;

    public static final class a<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ SuggestHolder a;

        public a(SuggestHolder suggestHolder) {
            this.a = suggestHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return Integer.valueOf(this.a.getAdapterPosition());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Observable<R> map = RxView.clicks(view).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "view.clicks().map { adapterPosition }");
        this.s = map;
        View findViewById = view.findViewById(R.id.text_location);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.text_parent);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.image_historical);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.v = (ImageView) findViewById3;
    }

    public abstract void bind(T t2);

    @NotNull
    public final Observable<Integer> getClicks() {
        return this.s;
    }

    @NotNull
    public final ImageView getImageSuggestType() {
        return this.v;
    }

    @NotNull
    public final TextView getTextLocation() {
        return this.t;
    }

    @NotNull
    public final TextView getTextParent() {
        return this.u;
    }
}
