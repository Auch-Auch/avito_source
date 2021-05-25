package ru.avito.component.payments.method;

import a2.g.r.g;
import a7.a.a.e.a.c;
import a7.a.a.e.a.d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextsKt;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxbinding4.view.ViewLayoutChangeEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012RD\u0010\u000b\u001a0\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00070\u0007 \u001a*\u0017\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u0019¢\u0006\u0002\b\u001b0\u0019¢\u0006\u0002\b\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010 ¨\u00062"}, d2 = {"Lru/avito/component/payments/method/PaymentMethodListCard;", "Lru/avito/component/payments/method/PaymentMethodCard;", "", "isEnabled", "", "setEnabled", "(Z)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "information", "setInformation", "Lru/avito/component/payments/method/PaymentLabel;", "label", "setLabel", "(Lru/avito/component/payments/method/PaymentLabel;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "paymentLabel", "setViewTag", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/text/TextImpl;", "e", "Lru/avito/component/text/TextImpl;", "subtitleView", "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "c", "titleRawView", "f", "infoView", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "imageView", "d", "titleView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class PaymentMethodListCard implements PaymentMethodCard {
    public final PublishRelay<String> a;
    public final ImageView b;
    public final View c;
    public final TextImpl d;
    public final TextImpl e;
    public final TextImpl f;
    public final View g;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                TextsKt.bindText(((PaymentMethodListCard) this.b).e, str);
            } else if (i == 1) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                PaymentMethodListCard.access$handleTitleLayoutWithSubtitle((PaymentMethodListCard) this.b, str2);
                PaymentMethodListCard.access$handleImageLayoutWithSubtitle((PaymentMethodListCard) this.b, str2);
            } else {
                throw null;
            }
        }
    }

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

    public PaymentMethodListCard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        PublishRelay<String> create = PublishRelay.create();
        this.a = create;
        View findViewById = view.findViewById(R.id.payment_method_icon);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        this.b = imageView;
        View findViewById2 = view.findViewById(R.id.payment_method_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById2;
        this.d = new TextImpl(findViewById2);
        View findViewById3 = view.findViewById(R.id.payment_method_subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.e = new TextImpl(findViewById3);
        View findViewById4 = view.findViewById(R.id.payment_method_information);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.f = new TextImpl(findViewById4);
        create.subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(create, MessengerShareContentUtility.SUBTITLE);
        Observable<R> map = RxView.layoutChangeEvents(imageView).filter(new c(this)).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "this.layoutChangeEvents(…) }\n        .map { Unit }");
        Observable combineLatest = Observable.combineLatest(create, map, new BiFunction<T1, T2, R>() { // from class: ru.avito.component.payments.method.PaymentMethodListCard$$special$$inlined$combineLatest$1
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.String] */
            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                return t1;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        combineLatest.subscribe(new a(1, this));
    }

    public static final void access$handleImageLayoutWithSubtitle(PaymentMethodListCard paymentMethodListCard, String str) {
        ViewGroup.LayoutParams layoutParams = paymentMethodListCard.b.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (str.length() == 0) {
            Views.deleteRule(layoutParams2, 8);
            layoutParams2.addRule(15);
            layoutParams2.bottomMargin = 0;
        } else {
            Views.deleteRule(layoutParams2, 15);
            layoutParams2.addRule(8, R.id.payment_method_title);
            layoutParams2.bottomMargin = (paymentMethodListCard.b.getHeight() * -1) / 2;
        }
        paymentMethodListCard.b.post(new a7.a.a.e.a.a(paymentMethodListCard, layoutParams2));
    }

    public static final void access$handleTitleLayoutWithSubtitle(PaymentMethodListCard paymentMethodListCard, String str) {
        ViewGroup.LayoutParams layoutParams = paymentMethodListCard.c.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (str.length() == 0) {
            Views.deleteRule(layoutParams2, 10);
            layoutParams2.addRule(15);
        } else {
            layoutParams2.addRule(10);
            Views.deleteRule(layoutParams2, 15);
        }
        paymentMethodListCard.c.post(new a7.a.a.e.a.b(paymentMethodListCard, layoutParams2));
    }

    public static final int access$newHeight(PaymentMethodListCard paymentMethodListCard, ViewLayoutChangeEvent viewLayoutChangeEvent) {
        Objects.requireNonNull(paymentMethodListCard);
        return viewLayoutChangeEvent.getBottom() - viewLayoutChangeEvent.getTop();
    }

    public static final int access$oldHeight(PaymentMethodListCard paymentMethodListCard, ViewLayoutChangeEvent viewLayoutChangeEvent) {
        Objects.requireNonNull(paymentMethodListCard);
        return viewLayoutChangeEvent.getOldBottom() - viewLayoutChangeEvent.getOldTop();
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g.setOnClickListener(new b(function0));
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setEnabled(boolean z) {
        Views.setViewHierarchyEnabled(this.g, z);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setInformation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "information");
        TextsKt.bindText(this.f, str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setLabel(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "label");
        this.b.setImageResource(paymentLabel.getImageRes());
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.a.accept(str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextsKt.bindText(this.d, str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setViewTag(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "paymentLabel");
        this.g.setTag(paymentLabel);
    }
}
