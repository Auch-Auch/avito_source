package ru.avito.component.payments.method;

import a2.g.r.g;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)RD\u00100\u001a0\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00070\u0007 ,*\u0017\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00070\u0007\u0018\u00010+¢\u0006\u0002\b-0+¢\u0006\u0002\b-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010#¨\u00065"}, d2 = {"Lru/avito/component/payments/method/HorizontalPaymentMethodListCard;", "Lru/avito/component/payments/method/PaymentMethodCard;", "", "isEnabled", "", "setEnabled", "(Z)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "information", "setInformation", "Lru/avito/component/payments/method/PaymentLabel;", "label", "setLabel", "(Lru/avito/component/payments/method/PaymentLabel;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "paymentLabel", "setViewTag", "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "titleView", "d", "infoTooltipView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "subtitleRelay", "c", "subtitleView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class HorizontalPaymentMethodListCard implements PaymentMethodCard {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final PublishRelay<String> e;
    public final CompositeDisposable f;
    public final View g;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ HorizontalPaymentMethodListCard a;

        public a(HorizontalPaymentMethodListCard horizontalPaymentMethodListCard) {
            this.a = horizontalPaymentMethodListCard;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            TextViews.bindText$default(this.a.c, str2, false, 2, null);
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            if (str2.length() == 0) {
                this.a.b.setMaxLines(2);
                this.a.b.setSingleLine(false);
                Views.hide(this.a.c);
                return;
            }
            this.a.b.setMaxLines(1);
            this.a.b.setSingleLine(true);
            Views.show(this.a.c);
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ HorizontalPaymentMethodListCard a;
        public final /* synthetic */ String b;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = new a();

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LastClick.Updater.update();
                dialogInterface.dismiss();
            }
        }

        public c(HorizontalPaymentMethodListCard horizontalPaymentMethodListCard, String str) {
            this.a = horizontalPaymentMethodListCard;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new AlertDialog.Builder(this.a.g.getContext(), R.style.Theme_Avito_Dialog_Alert).setTitle(R.string.bonuses).setMessage(this.b).setPositiveButton(R.string.close, a.a).create().show();
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = new d();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public HorizontalPaymentMethodListCard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = view.findViewById(R.id.payment_method_icon);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.payment_method_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.payment_method_subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.information_tooltip_image_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.d = (ImageView) findViewById4;
        PublishRelay<String> create = PublishRelay.create();
        this.e = create;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        Disposable subscribe = create.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subtitleRelay.subscribe …)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
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
        if (!m.isBlank(str)) {
            Views.show(this.d);
            this.d.setOnClickListener(new c(this, str));
            return;
        }
        Views.hide(this.d);
        this.d.setOnClickListener(d.a);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setLabel(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "label");
        this.a.setImageResource(paymentLabel.getImageRes());
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.e.accept(str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setViewTag(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "paymentLabel");
        this.g.setTag(paymentLabel);
    }
}
