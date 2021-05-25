package com.avito.android.short_term_rent.start_booking.items.guest_count;

import a2.a.a.v2.c.e.a.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.avito.android.short_term_rent.R;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010%\u001a\u00020 \u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b&\u0010'J2\u0010\n\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemView;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "count", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionClickListener", "(Lkotlin/jvm/functions/Function1;)V", "guestsCount", "setSelectedItem", "(I)V", "Landroid/widget/TextView;", "t", "(I)Landroid/widget/TextView;", "", "s", "Ljava/util/List;", "textViews", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "countsContainer", "u", "Ljava/lang/Integer;", "selectedCount", "", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCount;", "w", "counts", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class GuestsCountItemViewHolder extends BaseViewHolder implements GuestsCountItemView {
    public final List<TextView> s = new ArrayList();
    public final ConstraintLayout t;
    public Integer u;
    @NotNull
    public final View v;
    public final List<GuestsCount> w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ GuestsCountItemViewHolder b;
        public final /* synthetic */ Function1 c;

        /* renamed from: com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemViewHolder$a$a  reason: collision with other inner class name */
        public static final class C0161a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0161a(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                a aVar = this.a;
                aVar.c.invoke(Integer.valueOf(((GuestsCount) aVar.b.w.get(this.a.a)).getCount()));
                return Unit.INSTANCE;
            }
        }

        public a(int i, GuestsCountItemViewHolder guestsCountItemViewHolder, Function1 function1) {
            this.a = i;
            this.b = guestsCountItemViewHolder;
            this.c = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuestsCountItemViewHolder guestsCountItemViewHolder = this.b;
            GuestsCountItemViewHolder.access$switch(guestsCountItemViewHolder, ((GuestsCount) guestsCountItemViewHolder.w.get(this.a)).getCount(), new C0161a(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuestsCountItemViewHolder(@NotNull View view, @NotNull List<GuestsCount> list) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(list, "counts");
        this.v = view;
        this.w = list;
        View findViewById = view.findViewById(R.id.countsContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.countsContainer)");
        this.t = (ConstraintLayout) findViewById;
        LayoutInflater from = LayoutInflater.from(view.getContext());
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t2 : list) {
                arrayList2.add(Boolean.valueOf(arrayList.add(Integer.valueOf(View.generateViewId()))));
            }
            int i = 0;
            for (T t3 : this.w) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) arrayList.get(i)).intValue();
                String title = t3.getTitle();
                Intrinsics.checkNotNullExpressionValue(from, "layoutInflater");
                ViewGroup viewGroup = this.t;
                View inflate = from.inflate(R.layout.guest_count_text_view, viewGroup, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setId(intValue);
                textView.setText(title);
                viewGroup.addView(textView);
                this.s.add(textView);
                i = i2;
            }
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.t);
            constraintSet.createHorizontalChain(0, 1, 0, 2, CollectionsKt___CollectionsKt.toIntArray(arrayList), null, 1);
            constraintSet.applyTo(this.t);
            return;
        }
        throw new IllegalStateException("Guests count is empty");
    }

    public static final void access$switch(GuestsCountItemViewHolder guestsCountItemViewHolder, int i, Function0 function0) {
        Integer num = guestsCountItemViewHolder.u;
        if (num != null) {
            TextView t2 = guestsCountItemViewHolder.t(num.intValue());
            t2.postDelayed(new b(t2), 150);
        }
        TextView t3 = guestsCountItemViewHolder.t(i);
        t3.postDelayed(new a2.a.a.v2.c.e.a.a(t3, function0), 150);
        guestsCountItemViewHolder.u = Integer.valueOf(i);
    }

    @NotNull
    public final View getView() {
        return this.v;
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemView
    public void setActionClickListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        int i = 0;
        for (T t2 : this.s) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            t2.setOnClickListener(new a(i, this, function1));
            i = i2;
        }
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemView
    public void setSelectedItem(int i) {
        TextView t2 = t(i);
        t2.setBackgroundResource(R.drawable.selected_guest_count_background);
        Context context = t2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        t2.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite));
        this.u = Integer.valueOf(i);
    }

    public final TextView t(int i) {
        List<TextView> list = this.s;
        Iterator<GuestsCount> it = this.w.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (i == it.next().getCount()) {
                break;
            }
            i2++;
        }
        return list.get(i2);
    }
}
