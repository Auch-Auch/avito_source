package com.avito.android.user_advert.advert;

import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_advert/advert/ContractButtonViewImpl;", "Lcom/avito/android/user_advert/advert/ContractButtonView;", "", "isVisible", "", "setVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "onClick", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/button/Button;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "<init>", "(Landroid/view/View;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class ContractButtonViewImpl implements ContractButtonView {
    public final Button a;
    public final View b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public ContractButtonViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = view.findViewById(R.id.contract_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.a = (Button) findViewById;
    }

    @Override // com.avito.android.user_advert.advert.ContractButtonView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.a.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.user_advert.advert.ContractButtonView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }

    @Override // com.avito.android.user_advert.advert.ContractButtonView
    public void setVisible(boolean z) {
        Views.setVisible(this.b, z);
    }
}
