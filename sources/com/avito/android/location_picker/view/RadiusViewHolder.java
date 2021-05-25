package com.avito.android.location_picker.view;

import android.view.View;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.location_picker.R;
import com.avito.android.remote.model.SearchRadius;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/location_picker/view/RadiusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/remote/model/SearchRadius;", "item", "", "bind", "(Lcom/avito/android/remote/model/SearchRadius;)V", "Landroid/widget/CheckedTextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/CheckedTextView;", "txt", "Lio/reactivex/rxjava3/core/Observable;", "", "s", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class RadiusViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final Observable<Integer> s;
    public final CheckedTextView t;

    public static final class a<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ RadiusViewHolder a;

        public a(RadiusViewHolder radiusViewHolder) {
            this.a = radiusViewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return Integer.valueOf(this.a.getAdapterPosition());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadiusViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Observable<R> map = RxView.clicks(view).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "view.clicks().map { adapterPosition }");
        this.s = map;
        this.t = (CheckedTextView) view.findViewById(R.id.txtRadius);
    }

    public final void bind(@NotNull SearchRadius searchRadius) {
        Intrinsics.checkNotNullParameter(searchRadius, "item");
        String title = searchRadius.getTitle();
        CheckedTextView checkedTextView = this.t;
        Intrinsics.checkNotNullExpressionValue(checkedTextView, "txt");
        checkedTextView.setText(title);
        boolean isActive = searchRadius.isActive();
        CheckedTextView checkedTextView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(checkedTextView2, "txt");
        checkedTextView2.setChecked(isActive);
    }

    @NotNull
    public final Observable<Integer> getClicks() {
        return this.s;
    }
}
