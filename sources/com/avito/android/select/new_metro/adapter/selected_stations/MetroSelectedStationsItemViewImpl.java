package com.avito.android.select.new_metro.adapter.selected_stations;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.select.R;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView;
import com.avito.android.select.new_metro.view.FlowLayout;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010I\u001a\u00020)¢\u0006\u0004\bJ\u0010KJ2\u0010\n\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R1\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R*\u0010@\u001a\u0002092\u0006\u0010!\u001a\u0002098\u0016@VX\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemViewImpl;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSelectedStationClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setOnExpandedClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "items", "showStations", "(Ljava/util/List;)V", "t", "()V", "Lcom/avito/android/select/new_metro/view/FlowLayout;", "Lcom/avito/android/select/new_metro/view/FlowLayout;", "selectedItemsLayout", "s", "Lkotlin/jvm/functions/Function1;", "stationsListener", "Landroid/animation/ValueAnimator;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/animation/ValueAnimator;", "rootLayoutValueAnimator", "", "value", "C", "Z", "getShowAll", "()Z", "setShowAll", "(Z)V", "showAll", "Landroid/view/View;", "y", "Landroid/view/View;", "bottomDivider", "Landroid/widget/ImageView;", "w", "Landroid/widget/ImageView;", "bottomTextIcon", "Landroid/view/ViewGroup;", "x", "Landroid/view/ViewGroup;", "bottomTextLayout", "Landroid/view/LayoutInflater;", "z", "Landroid/view/LayoutInflater;", "inflater", "", "B", "I", "getMinLines", "()I", "setMinLines", "(I)V", "minLines", "Landroid/widget/LinearLayout;", "u", "Landroid/widget/LinearLayout;", "selectedItemsRootLayout", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "bottomText", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroSelectedStationsItemViewImpl extends BaseViewHolder implements MetroSelectedStationsItemView {
    public ValueAnimator A;
    public int B;
    public boolean C;
    public Function1<? super String, Unit> s = d.a;
    public final FlowLayout t;
    public final LinearLayout u;
    public final TextView v;
    public final ImageView w;
    public final ViewGroup x;
    public final View y;
    public final LayoutInflater z;

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MetroSelectedStationsItemViewImpl a;

        public c(MetroSelectedStationsItemViewImpl metroSelectedStationsItemViewImpl) {
            this.a = metroSelectedStationsItemViewImpl;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.u.setAlpha(((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue());
        }
    }

    public static final class d extends Lambda implements Function1<String, Unit> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetroSelectedStationsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.selected_items);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.select.new_metro.view.FlowLayout");
        FlowLayout flowLayout = (FlowLayout) findViewById;
        this.t = flowLayout;
        View findViewById2 = view.findViewById(R.id.selected_items_root);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.u = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.bottom_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.bottom_text_chevron);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        this.w = imageView;
        View findViewById5 = view.findViewById(R.id.bottom_text_layout);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        this.x = (ViewGroup) findViewById5;
        View findViewById6 = view.findViewById(R.id.divider);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.y = findViewById6;
        LayoutInflater from = LayoutInflater.from(view.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(view.context)");
        this.z = from;
        this.A = new ValueAnimator();
        this.B = 1;
        flowLayout.setDividerSize(a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(R.dimen.select_metro_selected_station_divider));
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        imageView.setColorFilter(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue));
        flowLayout.setOnMeasureChanged(new Function0<Unit>(this) { // from class: com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemViewImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                MetroSelectedStationsItemViewImpl.access$updateTextAndDivider((MetroSelectedStationsItemViewImpl) this.receiver);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$updateTextAndDivider(MetroSelectedStationsItemViewImpl metroSelectedStationsItemViewImpl) {
        CharSequence charSequence;
        int size = e.flatten(metroSelectedStationsItemViewImpl.t.getShowedLines()).size();
        int childCount = metroSelectedStationsItemViewImpl.t.getChildCount();
        boolean z2 = size < childCount || (metroSelectedStationsItemViewImpl.getShowAll() && metroSelectedStationsItemViewImpl.t.getShowedLines().size() > metroSelectedStationsItemViewImpl.getMinLines());
        int i = childCount - size;
        Views.setVisible(metroSelectedStationsItemViewImpl.x, z2);
        Views.setVisible(metroSelectedStationsItemViewImpl.y, size > 0);
        if (i == 0) {
            View view = metroSelectedStationsItemViewImpl.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            charSequence = view.getContext().getText(R.string.select_metro_selected_stations_hide_selected);
        } else {
            View view2 = metroSelectedStationsItemViewImpl.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            charSequence = context.getResources().getQuantityString(R.plurals.select_metro_selected_stations_show_selected, i, Integer.valueOf(i));
        }
        Intrinsics.checkNotNullExpressionValue(charSequence, "if (hideStationsCount ==…t\n            )\n        }");
        metroSelectedStationsItemViewImpl.v.setText(charSequence);
        metroSelectedStationsItemViewImpl.v.requestLayout();
        metroSelectedStationsItemViewImpl.w.setRotation(metroSelectedStationsItemViewImpl.getShowAll() ? -180.0f : 0.0f);
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public int getMinLines() {
        return this.B;
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public boolean getShowAll() {
        return this.C;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MetroSelectedStationsItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public void setMinLines(int i) {
        this.B = i;
        t();
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public void setOnExpandedClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public void setOnSelectedStationClickListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function1;
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public void setShowAll(boolean z2) {
        this.C = z2;
        t();
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemView
    public void showStations(@NotNull List<SelectedStationInfo> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.A.cancel();
        this.u.setAlpha(1.0f);
        if (this.t.getChildCount() == 0 && (!list.isEmpty())) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0f, 1f)");
            this.A = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.A.setDuration(150L);
            this.A.start();
        }
        int i = 0;
        while (i < this.t.getChildCount() && i < list.size()) {
            View childAt = this.t.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "buttonAtIndex");
            if (!Intrinsics.areEqual(childAt.getTag(), list.get(i).getId())) {
                break;
            }
            i++;
        }
        if (i < this.t.getChildCount()) {
            int childCount = this.t.getChildCount();
            for (int i2 = i; i2 < childCount; i2++) {
                this.t.removeViewAt(i);
            }
        }
        if (i < list.size()) {
            int size = list.size();
            while (i < size) {
                String id = list.get(i).getId();
                CharSequence name = list.get(i).getName();
                if (this.t.findViewWithTag(id) == null) {
                    FlowLayout flowLayout = this.t;
                    View inflate = this.z.inflate(R.layout.selected_station_button, (ViewGroup) flowLayout, false);
                    View findViewById = inflate.findViewById(R.id.text);
                    Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                    View findViewById2 = inflate.findViewById(R.id.icon);
                    Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
                    ((TextView) findViewById).setText(name);
                    inflate.setId(id.hashCode());
                    inflate.setTag(id);
                    ((ImageView) findViewById2).setOnClickListener(new a2.a.a.m2.m.a.b.a(this, id));
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…dView(id, text)\n        }");
                    flowLayout.addView(inflate);
                }
                i++;
            }
        }
    }

    public final void t() {
        if (getShowAll()) {
            this.t.setMaxLines(Integer.MAX_VALUE);
        } else {
            this.t.setMaxLines(getMinLines());
        }
    }
}
