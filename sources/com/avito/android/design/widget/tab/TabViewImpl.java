package com.avito.android.design.widget.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.avito.android.design.widget.tab.TabView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020#¢\u0006\u0004\b-\u0010)J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001d¨\u0006."}, d2 = {"Lcom/avito/android/design/widget/tab/TabViewImpl;", "Lcom/avito/android/design/widget/tab/TabView;", "", "text", "label", "", "bind", "(Ljava/lang/String;Ljava/lang/String;)V", "", VKApiConst.POSITION, "count", "", "isSelected", "setSelected", "(IIZ)V", "startPadding", "targetPadding", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "padding", "changer", "Landroid/animation/Animator;", AuthSource.SEND_ABUSE, "(IILkotlin/jvm/functions/Function1;)Landroid/animation/Animator;", "d", "Z", "isInit", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "title", "", "c", "Ljava/util/Set;", "animators", "Landroid/view/View;", "e", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", AuthSource.BOOKING_ORDER, "counter", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TabViewImpl implements TabView {
    public final TextView a;
    public final TextView b;
    public final Set<Animator> c = new LinkedHashSet();
    public boolean d = true;
    @NotNull
    public View e;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Integer, Unit> {
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
        public final Unit invoke(Integer num) {
            int i = this.a;
            if (i == 0) {
                Views.changePadding$default(((TabViewImpl) this.b).getView(), num.intValue(), 0, 0, 0, 14, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                Views.changePadding$default(((TabViewImpl) this.b).getView(), 0, 0, num.intValue(), 0, 11, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 function1) {
            this.a = function1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invoke((Integer) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Int"));
        }
    }

    public TabViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        View findViewById = getView().findViewById(R.id.tab_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = getView().findViewById(R.id.tab_counter);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
    }

    public final Animator a(int i, int i2, Function1<? super Integer, Unit> function1) {
        if (this.d) {
            function1.invoke(Integer.valueOf(i2));
            return null;
        } else if (i == i2) {
            return null;
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setDuration(100L);
            ofInt.addUpdateListener(new b(function1));
            ofInt.start();
            return ofInt;
        }
    }

    @Override // com.avito.android.design.widget.tab.TabView
    public void bind(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.a, str, false, 2, null);
        TextViews.bindText$default(this.b, str2, false, 2, null);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    @NotNull
    public View getView() {
        return this.e;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(boolean z) {
        TabView.DefaultImpls.setSelected(this, z);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.e = view;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(int i, int i2, boolean z) {
        int i3;
        int i4;
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.c.clear();
        if (!z || i != 0) {
            i3 = 0;
        } else {
            Context context = getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            i3 = context.getResources().getDimensionPixelSize(R.dimen.standard_padding);
        }
        if (!z || i != i2 - 1) {
            i4 = 0;
        } else {
            Context context2 = getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            i4 = context2.getResources().getDimensionPixelSize(R.dimen.standard_padding);
        }
        Animator a3 = a(getView().getPaddingLeft(), i3, new a(0, this));
        if (a3 != null) {
            this.c.add(a3);
        }
        Animator a4 = a(getView().getPaddingRight(), i4, new a(1, this));
        if (a4 != null) {
            this.c.add(a4);
        }
        this.d = false;
    }
}
