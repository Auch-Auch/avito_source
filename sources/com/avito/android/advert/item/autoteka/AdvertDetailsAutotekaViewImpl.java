package com.avito.android.advert.item.autoteka;

import android.content.res.Resources;
import android.view.View;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView;
import com.avito.android.advert_details.R;
import com.avito.android.component.service_context_block.ServiceContextBlock;
import com.avito.android.component.service_context_block.ServiceContextBlockImpl;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;", "", "needToShow", "", "setNeedToShowTopDivider", "(Z)V", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAutotekaListener", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView$Listener;)V", "", "vin", "showData", "(Ljava/lang/String;)V", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Lcom/avito/android/component/service_context_block/ServiceContextBlock;", "t", "Lcom/avito/android/component/service_context_block/ServiceContextBlock;", "reportView", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "u", "Landroid/content/res/Resources;", "resources", "w", "Z", "needToShowTopDivider", "s", "divider", VKApiConst.VERSION, "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView$Listener;", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaViewImpl extends BaseViewHolder implements AdvertDetailsAutotekaView {
    public final View s;
    public ServiceContextBlock t;
    public final Resources u;
    public AdvertDetailsAutotekaView.Listener v;
    public boolean w = true;
    public final View x;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsAutotekaViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsAutotekaViewImpl advertDetailsAutotekaViewImpl, String str) {
            super(0);
            this.a = advertDetailsAutotekaViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AdvertDetailsAutotekaViewImpl.access$getListener$p(this.a).onClickGetAutotekaReport();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAutotekaViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        this.s = view.findViewById(R.id.divider_top);
        this.u = a2.b.a.a.a.u1(view, "view.context");
    }

    public static final /* synthetic */ AdvertDetailsAutotekaView.Listener access$getListener$p(AdvertDetailsAutotekaViewImpl advertDetailsAutotekaViewImpl) {
        AdvertDetailsAutotekaView.Listener listener = advertDetailsAutotekaViewImpl.v;
        if (listener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        return listener;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView
    public void setAutotekaListener(@NotNull AdvertDetailsAutotekaView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = listener;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView
    public void setNeedToShowTopDivider(boolean z) {
        this.w = z;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView
    public void showData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vin");
        View view = this.s;
        if (view != null) {
            Views.setVisible(view, this.w);
        }
        if (this.t == null) {
            View findViewById = this.x.findViewById(R.id.autoteka_report);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.autoteka_report)");
            this.t = new ServiceContextBlockImpl(findViewById);
        }
        ServiceContextBlock serviceContextBlock = this.t;
        if (serviceContextBlock != null) {
            serviceContextBlock.showAllContent();
            String string = this.u.getString(com.avito.android.advert_core.R.string.advert_autoteka_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(adve…ng.advert_autoteka_title)");
            serviceContextBlock.setTitle(string);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = this.u.getString(com.avito.android.advert_core.R.string.advert_autoteka_subtitle);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(adve…advert_autoteka_subtitle)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            serviceContextBlock.setSubTitle(format);
            String string3 = this.u.getString(com.avito.android.advert_core.R.string.advert_autoteka_button);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(adve…g.advert_autoteka_button)");
            serviceContextBlock.setButton(string3, new a(this, str));
        }
    }
}
