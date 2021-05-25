package com.avito.android.payment;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import com.vk.sdk.api.model.VKApiUserFull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\u001a'\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onDynamicTabletPaddingChange", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", VKApiUserFull.RelativeType.CHILD, "setDynamicTabletPaddingsForChild", "(Landroid/view/View;Landroid/view/View;)V", "setDynamicTabletMarginsForChild", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentTabletViewsKt {

    public static final class a<T> implements Predicate<ViewLayoutChangeEvent> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
            return PaymentTabletViewsKt.access$oldWidth(viewLayoutChangeEvent2) != PaymentTabletViewsKt.access$newWidth(viewLayoutChangeEvent2);
        }
    }

    public static final class b<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
            return Integer.valueOf(PaymentTabletViewsKt.access$newWidth(viewLayoutChangeEvent2));
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function1 b;

        public c(View view, Function1 function1) {
            this.a = view;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            this.b.invoke(Integer.valueOf((num.intValue() - this.a.getResources().getDimensionPixelSize(R.dimen.vas_item_fixed_width)) / 2));
        }
    }

    public static final class d extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ View a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(1);
            this.a = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = intValue;
            marginLayoutParams.rightMargin = intValue;
            this.a.setLayoutParams(marginLayoutParams);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ View a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(1);
            this.a = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            this.a.setPadding(intValue, 0, intValue, 0);
            return Unit.INSTANCE;
        }
    }

    public static final int access$newWidth(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        return viewLayoutChangeEvent.getRight() - viewLayoutChangeEvent.getLeft();
    }

    public static final int access$oldWidth(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        return viewLayoutChangeEvent.getOldRight() - viewLayoutChangeEvent.getOldLeft();
    }

    public static final void onDynamicTabletPaddingChange(@NotNull View view, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$onDynamicTabletPaddingChange");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (view.getResources().getBoolean(R.bool.is_tablet)) {
            RxView.layoutChangeEvents(view).filter(a.a).map(b.a).subscribe(new c(view, function1));
        }
    }

    public static final void setDynamicTabletMarginsForChild(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "$this$setDynamicTabletMarginsForChild");
        Intrinsics.checkNotNullParameter(view2, VKApiUserFull.RelativeType.CHILD);
        onDynamicTabletPaddingChange(view, new d(view2));
    }

    public static final void setDynamicTabletPaddingsForChild(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "$this$setDynamicTabletPaddingsForChild");
        Intrinsics.checkNotNullParameter(view2, VKApiUserFull.RelativeType.CHILD);
        onDynamicTabletPaddingChange(view, new e(view2));
    }
}
