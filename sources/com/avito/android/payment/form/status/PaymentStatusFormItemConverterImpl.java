package com.avito.android.payment.form.status;

import com.avito.android.payment.form.status.ScreenState;
import com.avito.android.payment.items.TextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonItem;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverterImpl;", "Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "result", "Lcom/avito/android/payment/form/status/ScreenState$Content;", "convert", "(Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;)Lcom/avito/android/payment/form/status/ScreenState$Content;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormItemConverterImpl implements PaymentStatusFormItemConverter {
    public final AttributedTextFormatter a;

    public PaymentStatusFormItemConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = attributedTextFormatter;
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormItemConverter
    @NotNull
    public ScreenState.Content convert(@NotNull PaymentStatusFormResult.StatusForm statusForm) {
        String str;
        Intrinsics.checkNotNullParameter(statusForm, "result");
        ArrayList arrayList = new ArrayList();
        List<AttributedText> instructions = statusForm.getInstructions();
        ArrayList arrayList2 = new ArrayList();
        Iterator<AttributedText> it = instructions.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            CharSequence format = this.a.format(it.next());
            if (format != null) {
                str = format;
            }
            arrayList2.add(new TextItem.InfoTextItem("paragraph", str));
        }
        arrayList.addAll(arrayList2);
        AttributedText disclaimer = statusForm.getDisclaimer();
        ArrayList arrayList3 = new ArrayList();
        CharSequence format2 = this.a.format(disclaimer);
        if (format2 == null) {
            format2 = str;
        }
        arrayList3.add(new TextItem.DisclaimerTextItem("disclaimer", format2));
        arrayList.addAll(arrayList3);
        String title = statusForm.getAction().getTitle();
        if (title != null) {
            str = title;
        }
        arrayList.addAll(d.listOf(new ButtonItem("submit_button", true, str)));
        return new ScreenState.Content(statusForm.getTitle(), arrayList);
    }
}
