package com.avito.android.advert.item.consultation;

import android.view.View;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView;", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addListener", "(Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "submitButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsConsultationViewImpl extends BaseViewHolder implements AdvertDetailsConsultationView {
    public final Button s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsConsultationView.Listener a;

        public a(AdvertDetailsConsultationView.Listener listener) {
            this.a = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onSubmitConsultationRequestClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsConsultationViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (Button) view.findViewById(R.id.consultation_button);
    }

    @Override // com.avito.android.advert.item.consultation.AdvertDetailsConsultationView
    public void addListener(@NotNull AdvertDetailsConsultationView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.s;
        if (button != null) {
            button.setOnClickListener(new a(listener));
        }
    }
}
