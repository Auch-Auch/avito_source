package com.avito.android.safedeal.delivery_courier.time_interval_select;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001b¨\u0006+"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewImpl;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectView;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "dialogData", "", "bindData", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;)V", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "h", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "errorContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "errorTitle", AuthSource.BOOKING_ORDER, "bottomSheetTitle", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "bottomSheetHeader", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "bottomSheetCloseButton", "d", "infoContainer", g.a, "progressBar", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Lcom/avito/konveyor/ItemBinder;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectViewImpl implements DeliveryCourierTimeIntervalSelectView {
    public final View a;
    public final TextView b;
    public final ImageView c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final TextView f;
    public View g;
    public final AdapterPresenter h;
    public final RecyclerView i;

    public DeliveryCourierTimeIntervalSelectViewImpl(@NotNull BottomSheetDialog bottomSheetDialog, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "dialog");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        View findViewById = bottomSheetDialog.findViewById(R.id.bottom_sheet_header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.a = findViewById;
        View findViewById2 = bottomSheetDialog.findViewById(R.id.bottom_sheet_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        this.b = (TextView) findViewById2;
        View findViewById3 = bottomSheetDialog.findViewById(R.id.bottom_sheet_close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        this.c = (ImageView) findViewById3;
        View findViewById4 = bottomSheetDialog.findViewById(com.avito.android.safedeal.R.id.info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
        this.d = (ViewGroup) findViewById4;
        View findViewById5 = bottomSheetDialog.findViewById(com.avito.android.safedeal.R.id.error_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(id)");
        ViewGroup viewGroup = (ViewGroup) findViewById5;
        this.e = viewGroup;
        View findViewById6 = viewGroup.findViewById(com.avito.android.safedeal.R.id.error_title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = bottomSheetDialog.findViewById(com.avito.android.safedeal.R.id.progress);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(id)");
        this.g = findViewById7;
        SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(itemBinder, itemBinder);
        this.h = simpleAdapterPresenter;
        View findViewById8 = bottomSheetDialog.findViewById(com.avito.android.safedeal.R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(id)");
        RecyclerView recyclerView = (RecyclerView) findViewById8;
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(bottomSheetDialog.getContext()));
        recyclerView.setAdapter(new SimpleRecyclerAdapter(simpleAdapterPresenter, itemBinder));
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectView
    public void bindData(@NotNull DialogData dialogData) {
        Intrinsics.checkNotNullParameter(dialogData, "dialogData");
        if (dialogData instanceof DialogData.Loading) {
            Views.hide(this.d);
            Views.hide(this.e);
            Views.hide(this.a);
            Views.show(this.g);
        } else if (dialogData instanceof DialogData.Error) {
            String title = ((DialogData.Error) dialogData).getTitle();
            Views.hide(this.d);
            Views.hide(this.g);
            Views.hide(this.a);
            TextViews.bindText$default(this.f, title, false, 2, null);
            Views.show(this.e);
        } else if (dialogData instanceof DialogData.Normal) {
            DialogData.Normal normal = (DialogData.Normal) dialogData;
            this.b.setText(normal.getTitle());
            this.h.onDataSourceChanged(new ListDataSource(normal.getItems()));
            Integer iconRes = normal.getIconRes();
            if (iconRes != null) {
                this.c.setBackgroundResource(iconRes.intValue());
            }
            Views.hide(this.e);
            Views.hide(this.g);
            Views.show(this.a);
            Views.show(this.d);
        }
    }
}
