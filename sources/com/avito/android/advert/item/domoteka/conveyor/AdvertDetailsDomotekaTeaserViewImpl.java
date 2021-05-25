package com.avito.android.advert.item.domoteka.conveyor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.teaser.TeaserStatus;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserViewImpl;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserViewImpl;", "", "getInsightLayoutId", "()I", "Lcom/avito/android/remote/model/teaser/TeaserStatus;", "status", "Landroid/graphics/drawable/Drawable;", "getIconResource", "(Lcom/avito/android/remote/model/teaser/TeaserStatus;)Landroid/graphics/drawable/Drawable;", "", "showDialog", "()V", "Landroid/view/View;", "o", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "p", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertDetailsDomotekaTeaserViewImpl extends AdvertDetailsTeaserViewImpl {
    public final View o;
    @Nullable
    public AdvertDetailsTeaserView.Listener p;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TeaserStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            TeaserStatus teaserStatus = TeaserStatus.Ok;
            iArr[1] = 1;
            TeaserStatus teaserStatus2 = TeaserStatus.Caution;
            iArr[2] = 2;
            TeaserStatus teaserStatus3 = TeaserStatus.Locked;
            iArr[4] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsDomotekaTeaserViewImpl a;
        public final /* synthetic */ BottomSheetDialog b;

        public a(AdvertDetailsDomotekaTeaserViewImpl advertDetailsDomotekaTeaserViewImpl, BottomSheetDialog bottomSheetDialog) {
            this.a = advertDetailsDomotekaTeaserViewImpl;
            this.b = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.dismiss();
            AdvertDetailsTeaserView.Listener listener = this.a.getListener();
            if (listener != null) {
                listener.onClickDialogButton();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDomotekaTeaserViewImpl(@NotNull View view, @Nullable AdvertDetailsTeaserView.Listener listener) {
        super(view, listener);
        Intrinsics.checkNotNullParameter(view, "view");
        this.o = view;
        this.p = listener;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl
    @Nullable
    public Drawable getIconResource(@NotNull TeaserStatus teaserStatus) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(teaserStatus, "status");
        int ordinal = teaserStatus.ordinal();
        if (ordinal == 1) {
            return ContextCompat.getDrawable(this.o.getContext(), R.drawable.ic_domoteka_status_ok);
        }
        if (ordinal == 2) {
            Drawable drawable2 = ContextCompat.getDrawable(this.o.getContext(), R.drawable.ic_domoteka_status_caution);
            if (drawable2 == null) {
                return null;
            }
            Context context = this.o.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            return DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.orange));
        } else if (ordinal != 4 || (drawable = ContextCompat.getDrawable(this.o.getContext(), R.drawable.ic_domoteka_status_lock)) == null) {
            return null;
        } else {
            Context context2 = this.o.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            return DrawablesKt.wrapForTinting(drawable, Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28));
        }
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl
    public int getInsightLayoutId() {
        return R.layout.advert_details_domoteka_teaser_insight;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl, com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    public AdvertDetailsTeaserView.Listener getListener() {
        return this.p;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl, com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void setListener(@Nullable AdvertDetailsTeaserView.Listener listener) {
        this.p = listener;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserViewImpl, com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDialog() {
        View inflate = View.inflate(this.o.getContext(), R.layout.domoteka_request_flat_number_bottom_sheet, null);
        Context context = this.o.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 7, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "dialogView");
        bottomSheetDialog.setContentView(inflate, true);
        bottomSheetDialog.setFitContentPeekHeight(true);
        ((Button) inflate.findViewById(R.id.button_send)).setOnClickListener(new a(this, bottomSheetDialog));
        bottomSheetDialog.show();
    }
}
