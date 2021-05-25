package com.avito.android.advert_core.discount;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.discount.di.AdvertDiscountDetailsModule;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogImpl;", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "Lcom/avito/android/remote/model/AdvertDiscounts;", "discounts", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "", "bindData", "(Lcom/avito/android/remote/model/AdvertDiscounts;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "Landroid/content/Context;", "context", "show", "(Landroid/content/Context;)V", "dismiss", "()V", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;", "c", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;", "presenter", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "shownDialog", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "<init>", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDiscountDetailsDialogImpl implements AdvertDiscountDetailsDialog {
    public BottomSheetDialog a;
    public final SimpleRecyclerAdapter b;
    public final AdvertDiscountDetailsDialogPresenter c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public a(BottomSheetDialog bottomSheetDialog) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = this.a;
            boolean z = true;
            if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
                z = false;
            }
            if (z && bottomSheetDialog != null) {
                bottomSheetDialog.dismiss();
            }
        }
    }

    @Inject
    public AdvertDiscountDetailsDialogImpl(@AdvertDiscountDetailsModule.AdvertDiscount @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdvertDiscountDetailsDialogPresenter advertDiscountDetailsDialogPresenter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(advertDiscountDetailsDialogPresenter, "presenter");
        this.b = simpleRecyclerAdapter;
        this.c = advertDiscountDetailsDialogPresenter;
    }

    @Override // com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog
    public void bindData(@NotNull AdvertDiscounts advertDiscounts, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(advertDiscounts, "discounts");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.c.bindData(advertDiscounts, list, contactBarData);
    }

    @Override // com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog
    public void dismiss() {
        BottomSheetDialog bottomSheetDialog = this.a;
        boolean z = true;
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            z = false;
        }
        if (z && bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    @Override // com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog
    public void show(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.discount_details_bottom_sheet, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setTitle((CharSequence) null);
        View findViewById = bottomSheetDialog.findViewById(R.id.close_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(new a(bottomSheetDialog));
        }
        View findViewById2 = bottomSheetDialog.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNull(findViewById2);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this.b);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        bottomSheetDialog.show();
        Unit unit = Unit.INSTANCE;
        this.a = bottomSheetDialog;
    }
}
