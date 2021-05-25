package com.avito.android.safedeal.delivery_type;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_type.items.title.TitleItem;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.ParcelableItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeBottomSheetViewImpl;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeViewImpl;", "Lio/reactivex/rxjava3/core/Observable;", "", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "dismiss", "()V", "", "Lcom/avito/conveyor_item/ParcelableItem;", "items", "bindItems", "(Ljava/util/List;)V", "Landroid/widget/ImageView;", "l", "Landroid/widget/ImageView;", "closeButton", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "title", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/safedeal/delivery_type/RetryListener;", "retryListener", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/safedeal/delivery_type/RetryListener;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Companion", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeBottomSheetViewImpl extends DeliveryTypeViewImpl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final TextView k;
    public final ImageView l;
    public final BottomSheetDialog m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeBottomSheetViewImpl$Companion;", "", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheet", "Landroid/view/View;", "configureDialog", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;)Landroid/view/View;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final View configureDialog(@NotNull BottomSheetDialog bottomSheetDialog) {
            Intrinsics.checkNotNullParameter(bottomSheetDialog, "bottomSheet");
            bottomSheetDialog.setContentView(R.layout.fragment_delivery_type, true);
            BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 7, null);
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            bottomSheetDialog.setFitContentPeekHeight(true);
            View inflate = bottomSheetDialog.getLayoutInflater().inflate(R.layout.delivery_type_bottom_sheet_header, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ottom_sheet_header, null)");
            bottomSheetDialog.setCustomHeader(inflate);
            View findViewById = bottomSheetDialog.findViewById(R.id.container_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
            return findViewById;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryTypeBottomSheetViewImpl(@NotNull BottomSheetDialog bottomSheetDialog, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull RetryListener retryListener, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(Companion.configureDialog(bottomSheetDialog), adapterPresenter, safeRecyclerAdapter, retryListener, attributedTextFormatter);
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "dialog");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.m = bottomSheetDialog;
        View findViewById = bottomSheetDialog.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.k = (TextView) findViewById;
        View findViewById2 = bottomSheetDialog.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        this.l = (ImageView) findViewById2;
        getToolbar().setVisibility(8);
        bottomSheetDialog.show();
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeViewImpl, com.avito.android.safedeal.delivery_type.DeliveryTypeView
    public void bindItems(@NotNull List<? extends ParcelableItem> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "items");
        List<? extends ParcelableItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        Iterator<T> it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof TitleItem) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            AttributedTextFormatter attributedTextFormatter = getAttributedTextFormatter();
            Context context = this.m.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            this.k.setText(attributedTextFormatter.format(context, t2.getTitle()));
            mutableList.remove(t2);
        }
        super.bindItems(mutableList);
    }

    public final void dismiss() {
        this.m.dismiss();
    }

    public final void setOnDismissListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.m.setOnDismissListener(new a(function0));
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeViewImpl, com.avito.android.safedeal.delivery_type.DeliveryTypeView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return RxView.clicks(this.l);
    }
}
