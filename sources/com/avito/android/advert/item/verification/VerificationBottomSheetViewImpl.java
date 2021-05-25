package com.avito.android.advert.item.verification;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/advert/item/verification/VerificationBottomSheetViewImpl;", "Lcom/avito/android/advert/item/verification/VerificationBottomSheetView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "setButtonTitle", "(I)V", "attrStyle", "setButtonStyle", "Lkotlin/Function0;", "onClick", "setOnButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "imageRes", "setImageRes", "(Ljava/lang/Integer;)V", "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "descriptionTv", AuthSource.BOOKING_ORDER, "titleTv", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "image", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationBottomSheetViewImpl implements VerificationBottomSheetView {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final Button d;

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

    public VerificationBottomSheetViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.description)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.button)");
        this.d = (Button) findViewById4;
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setButtonStyle(int i) {
        this.d.setAppearanceFromAttr(i);
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setButtonTitle(@StringRes int i) {
        this.d.setText(i);
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.c.setText(str);
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setImageRes(@Nullable Integer num) {
        if (num == null) {
            Views.setVisible(this.a, false);
            return;
        }
        this.a.setImageResource(num.intValue());
        Views.setVisible(this.a, true);
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setOnButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.d.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert.item.verification.VerificationBottomSheetView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }
}
