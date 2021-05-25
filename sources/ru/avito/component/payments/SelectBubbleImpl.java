package ru.avito.component.payments;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.CharSequencePositionFormatterTextWatcher;
import ru.avito.component.text_input.MoneyValueFormatter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lru/avito/component/payments/SelectBubbleImpl;", "Lru/avito/component/payments/SelectBubble;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/text_input/MoneyValueFormatter;", "c", "Lru/avito/component/text_input/MoneyValueFormatter;", "maskFormatter", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "postfix", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectBubbleImpl implements SelectBubble {
    public final TextView a;
    public final String b;
    public final MoneyValueFormatter c;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public static final a a = new a();

        public a() {
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

    public SelectBubbleImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = (TextView) view;
        this.a = textView;
        String string = view.getResources().getString(R.string.money_input_postfix);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ring.money_input_postfix)");
        this.b = string;
        MoneyValueFormatter moneyValueFormatter = new MoneyValueFormatter(string, 0, false, 6, null);
        this.c = moneyValueFormatter;
        textView.addTextChangedListener(new CharSequencePositionFormatterTextWatcher(moneyValueFormatter, a.a));
    }

    @Override // ru.avito.component.payments.SelectBubble
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnClickListener(new b(function0));
    }

    @Override // ru.avito.component.payments.SelectBubble
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a.setText(str);
    }
}
