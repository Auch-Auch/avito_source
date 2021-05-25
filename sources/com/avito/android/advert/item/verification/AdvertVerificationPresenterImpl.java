package com.avito.android.advert.item.verification;

import android.content.Context;
import android.view.View;
import com.avito.android.Features;
import com.avito.android.advert.item.verification.AdvertVerificationPresenter;
import com.avito.android.advert_details.R;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.component.badge_bar.badge.BadgeItemView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/verification/AdvertVerificationPresenterImpl;", "Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter;", "Lcom/avito/android/component/badge_bar/badge/BadgeItemView;", "view", "Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/badge_bar/badge/BadgeItemView;Lcom/avito/android/advert/item/verification/AdvertVerificationItem;I)V", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "<init>", "(Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertVerificationPresenterImpl implements AdvertVerificationPresenter {
    public BottomSheetDialog a;
    public final AdvertVerificationPresenter.OnHelpCenterClickedListener b;
    public final Features c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertVerificationPresenterImpl a;
        public final /* synthetic */ AdvertVerificationItem b;

        /* renamed from: com.avito.android.advert.item.verification.AdvertVerificationPresenterImpl$a$a  reason: collision with other inner class name */
        public static final class C0130a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0130a(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.a.b.onVerificationHelpCenterClicked("https://support.avito.ru/articles/1547");
                return Unit.INSTANCE;
            }
        }

        public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
            public b(AdvertVerificationPresenterImpl advertVerificationPresenterImpl) {
                super(0, advertVerificationPresenterImpl, AdvertVerificationPresenterImpl.class, "dismissDialog", "dismissDialog()V", 0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                AdvertVerificationPresenterImpl.access$dismissDialog((AdvertVerificationPresenterImpl) this.receiver);
                return Unit.INSTANCE;
            }
        }

        public a(AdvertVerificationPresenterImpl advertVerificationPresenterImpl, AdvertVerificationItem advertVerificationItem) {
            this.a = advertVerificationPresenterImpl;
            this.b = advertVerificationItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0;
            int i;
            int i2;
            Integer num;
            if (this.a.c.getHardcodedVerificationDialog().invoke().booleanValue()) {
                num = Integer.valueOf(R.drawable.verification_170);
                i2 = R.string.verification_bottomsheet_help_center_title;
                i = com.avito.android.lib.design.R.attr.buttonSecondaryLarge;
                function0 = new C0130a(this);
            } else {
                num = null;
                i2 = R.string.verification_bottomsheet_button_title;
                i = com.avito.android.lib.design.R.attr.buttonDefaultLarge;
                function0 = new b(this.a);
            }
            AdvertVerificationPresenterImpl advertVerificationPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "clickedView");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clickedView.context");
            AdvertVerificationPresenterImpl.access$showDialog(advertVerificationPresenterImpl, context, num, this.b.getDescriptionTitle(), this.b.getDescription(), i2, i, function0);
        }
    }

    @Inject
    public AdvertVerificationPresenterImpl(@NotNull AdvertVerificationPresenter.OnHelpCenterClickedListener onHelpCenterClickedListener, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(onHelpCenterClickedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = onHelpCenterClickedListener;
        this.c = features;
    }

    public static final void access$dismissDialog(AdvertVerificationPresenterImpl advertVerificationPresenterImpl) {
        BottomSheetDialog bottomSheetDialog = advertVerificationPresenterImpl.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        advertVerificationPresenterImpl.a = null;
    }

    public static final void access$showDialog(AdvertVerificationPresenterImpl advertVerificationPresenterImpl, Context context, Integer num, String str, String str2, int i, int i2, Function0 function0) {
        BottomSheetDialog bottomSheetDialog = advertVerificationPresenterImpl.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        advertVerificationPresenterImpl.a = null;
        View inflate = View.inflate(context, R.layout.advert_details_verification_bottomsheet_layout, null);
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(context, 0, 2, null);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog2, null, null, false, true, 7, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        bottomSheetDialog2.setContentView(inflate, true);
        VerificationBottomSheetViewImpl verificationBottomSheetViewImpl = new VerificationBottomSheetViewImpl(inflate);
        verificationBottomSheetViewImpl.setImageRes(num);
        verificationBottomSheetViewImpl.setTitle(str);
        verificationBottomSheetViewImpl.setDescription(str2);
        verificationBottomSheetViewImpl.setButtonTitle(i);
        verificationBottomSheetViewImpl.setButtonStyle(i2);
        verificationBottomSheetViewImpl.setOnButtonClickListener(function0);
        bottomSheetDialog2.show();
        advertVerificationPresenterImpl.a = bottomSheetDialog2;
    }

    public void bindView(@NotNull BadgeItemView badgeItemView, @NotNull AdvertVerificationItem advertVerificationItem, int i) {
        Intrinsics.checkNotNullParameter(badgeItemView, "view");
        Intrinsics.checkNotNullParameter(advertVerificationItem, "item");
        BadgeItem badgeItem = advertVerificationItem.getBadgeItem();
        badgeItemView.setTitle(badgeItem.getTitle());
        badgeItemView.setDescription(badgeItem.getDescription());
        badgeItemView.setBackground(badgeItem.getBackgroundColor(), badgeItem.getRippleColor());
        badgeItemView.setTextColor(badgeItem.getTextColor());
        badgeItemView.setTitleMaxLines(badgeItem.getTitleMaxLines());
        badgeItemView.setDescriptionMaxLines(badgeItem.getDescriptionMaxLines());
        badgeItemView.setLocalHardcodedImage(com.avito.android.advert_core.R.drawable.ic_steering_wheel);
        badgeItemView.setOnClickListener(new a(this, advertVerificationItem));
    }
}
