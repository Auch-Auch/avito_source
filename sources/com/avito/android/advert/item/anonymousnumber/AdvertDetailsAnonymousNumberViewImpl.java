package com.avito.android.advert.item.anonymousnumber;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberView;", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "", "showAnonymousNumber", "(Lcom/avito/android/remote/model/AnonymousNumber;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "title", "Landroid/view/View;", "s", "Landroid/view/View;", "viewAnonymousNumber", "u", MessengerShareContentUtility.SUBTITLE, "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAnonymousNumberViewImpl extends BaseViewHolder implements AdvertDetailsAnonymousNumberView {
    public View s;
    public TextView t;
    public TextView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAnonymousNumberViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.anonymous_number);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.anonymous_number_title) : null;
        View view2 = this.s;
        this.u = view2 != null ? (TextView) view2.findViewById(R.id.anonymous_number_subtitle) : textView;
    }

    @Override // com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberView
    public void showAnonymousNumber(@NotNull AnonymousNumber anonymousNumber) {
        Intrinsics.checkNotNullParameter(anonymousNumber, "anonymousNumber");
        TextView textView = this.t;
        if (textView != null) {
            TextViews.bindText$default(textView, anonymousNumber.getTitle(), false, 2, null);
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, anonymousNumber.getSubtitle(), false, 2, null);
        }
    }
}
