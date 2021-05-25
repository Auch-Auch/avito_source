package com.avito.android.advert_core.contactbar.anti_fraud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "s", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "getListener", "()Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AntiFraudDialog extends BottomSheetDialog {
    @NotNull
    public final AdvertContactsPresenter s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AntiFraudDialog a;

        public a(AntiFraudDialog antiFraudDialog) {
            this.a = antiFraudDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.close();
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AntiFraudDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AntiFraudDialog antiFraudDialog) {
            super(0);
            this.a = antiFraudDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getListener().onCloseAntiFraudRule();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AntiFraudDialog(@NotNull Context context, @NotNull AdvertContactsPresenter advertContactsPresenter) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = advertContactsPresenter;
        BottomSheetDialog.setHeaderParams$default(this, null, null, false, true, 7, null);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.anti_fraud_header, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.anti_fraud_header_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "customHeaderView.findVie….anti_fraud_header_close)");
        findViewById.setOnClickListener(new a(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "customHeaderView");
        setCustomHeader(inflate);
        forceShowHeaderThumb();
        setContentView(R.layout.anti_fraud_content, new Function1<View, Unit>(this) { // from class: com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudDialog.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                AntiFraudDialog.access$setupButtons((AntiFraudDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setFitContentPeekHeight(true);
        setOnCloseListener(new c(this));
    }

    public static final void access$setupButtons(AntiFraudDialog antiFraudDialog, View view) {
        Objects.requireNonNull(antiFraudDialog);
        ((Button) view.findViewById(R.id.ok_button)).setOnClickListener(new x(0, antiFraudDialog));
        ((Button) view.findViewById(R.id.more_button)).setOnClickListener(new x(1, antiFraudDialog));
    }

    @NotNull
    public final AdvertContactsPresenter getListener() {
        return this.s;
    }
}
