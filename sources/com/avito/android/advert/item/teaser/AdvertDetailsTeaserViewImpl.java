package com.avito.android.advert.item.teaser;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserError;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.android.remote.model.teaser.TeaserStatus;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010W\u001a\u00020;\u0012\b\u0010R\u001a\u0004\u0018\u00010K¢\u0006\u0004\bX\u0010YJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b \u0010!J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b%\u0010&J\u001f\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b1\u0010\bR\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u00104R\u0016\u0010I\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010=R\u0018\u0010J\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010=R$\u0010R\u001a\u0004\u0018\u00010K8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010=R\u0016\u0010U\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u00104R\u0016\u0010W\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010=¨\u0006Z"}, d2 = {"Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserViewImpl;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "", "showLoading", "()V", "", "show", "showDivider", "(Z)V", "", "title", "showTitle", "(Ljava/lang/String;)V", "subTitle", "showSubtitle", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "showInsights", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/teaser/ReportLink;", "reportLink", "showReportLink", "(Lcom/avito/android/remote/model/teaser/ReportLink;)V", "showResult", "Lcom/avito/android/remote/model/teaser/TeaserError;", "error", "showError", "(Lcom/avito/android/remote/model/teaser/TeaserError;)V", "showDialog", "hide", "", "getInsightLayoutId", "()I", "Lcom/avito/android/remote/model/teaser/TeaserStatus;", "status", "Landroid/graphics/drawable/Drawable;", "getIconResource", "(Lcom/avito/android/remote/model/teaser/TeaserStatus;)Landroid/graphics/drawable/Drawable;", "Landroid/widget/LinearLayout;", "column", "insight", AuthSource.SEND_ABUSE, "(Landroid/widget/LinearLayout;Lcom/avito/android/remote/model/teaser/TeaserInsight;)V", "La2/a/a/f/x/d0/a;", "state", AuthSource.BOOKING_ORDER, "(La2/a/a/f/x/d0/a;)V", "visible", "c", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "errorTitle", g.a, "Landroid/widget/LinearLayout;", "resultInsightsColumn1", "f", "resultSubTitle", "Landroid/view/View;", "j", "Landroid/view/View;", "errorContainer", "divider", "h", "resultInsightsColumn2", "Lcom/avito/android/lib/design/button/Button;", "i", "Lcom/avito/android/lib/design/button/Button;", "resultButton", "l", "errorDescription", "d", "resultContainer", "bottomGap", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "n", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadingContainer", "e", "resultTitle", AuthSource.OPEN_CHANNEL_LIST, "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertDetailsTeaserViewImpl implements AdvertDetailsTeaserView {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final Button i;
    public final View j;
    public final TextView k;
    public final TextView l;
    public final View m;
    @Nullable
    public AdvertDetailsTeaserView.Listener n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            a2.a.a.f.x.d0.a.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            TeaserStatus.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            TeaserStatus teaserStatus = TeaserStatus.None;
            iArr2[0] = 1;
            TeaserStatus teaserStatus2 = TeaserStatus.Ok;
            iArr2[1] = 2;
            TeaserStatus teaserStatus3 = TeaserStatus.Caution;
            iArr2[2] = 3;
            TeaserStatus teaserStatus4 = TeaserStatus.Warning;
            iArr2[3] = 4;
            TeaserStatus teaserStatus5 = TeaserStatus.Locked;
            iArr2[4] = 5;
        }
    }

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsTeaserViewImpl a;

        public a(AdvertDetailsTeaserViewImpl advertDetailsTeaserViewImpl) {
            this.a = advertDetailsTeaserViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            AdvertDetailsTeaserView.Listener listener = this.a.getListener();
            if (listener != null) {
                listener.onClickGetReport();
            }
        }
    }

    public AdvertDetailsTeaserViewImpl(@NotNull View view, @Nullable AdvertDetailsTeaserView.Listener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.m = view;
        this.n = listener;
        this.a = view.findViewById(R.id.divider_top);
        this.b = view.findViewById(R.id.gap_bottom);
        View findViewById = view.findViewById(R.id.loading_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById;
        View findViewById2 = view.findViewById(R.id.result_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById2;
        int i2 = R.id.title;
        View findViewById3 = findViewById2.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById3;
        View findViewById4 = findViewById2.findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById4;
        View findViewById5 = findViewById2.findViewById(R.id.insights_column_1);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.g = (LinearLayout) findViewById5;
        this.h = (LinearLayout) findViewById2.findViewById(R.id.insights_column_2);
        View findViewById6 = findViewById2.findViewById(R.id.button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById6;
        this.i = button;
        View findViewById7 = view.findViewById(R.id.error_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById7;
        View findViewById8 = findViewById7.findViewById(i2);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById8;
        View findViewById9 = findViewById7.findViewById(R.id.description);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById9;
        RxView.clicks(button).throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    public final void a(LinearLayout linearLayout, TeaserInsight teaserInsight) {
        View inflate = LayoutInflater.from(this.m.getContext()).inflate(getInsightLayoutId(), (ViewGroup) linearLayout, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "insightView");
        View findViewById = inflate.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(teaserInsight.getText());
        View findViewById2 = inflate.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) findViewById2).setImageDrawable(getIconResource(teaserInsight.getStatus()));
        linearLayout.addView(inflate);
    }

    public final void b(a2.a.a.f.x.d0.a aVar) {
        c(true);
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            Views.show(this.c);
            Views.hide(this.d);
            Views.hide(this.j);
        } else if (ordinal == 1) {
            Views.hide(this.c);
            Views.show(this.d);
            Views.hide(this.j);
        } else if (ordinal == 2) {
            Views.hide(this.c);
            Views.hide(this.d);
            Views.show(this.j);
        }
    }

    public final void c(boolean z) {
        View view = this.a;
        boolean z2 = view != null && view.getVisibility() == 0;
        View view2 = this.m;
        if (view2 instanceof ViewGroup) {
            Iterator<View> children = ViewGroupsKt.getChildren((ViewGroup) view2);
            while (children.hasNext()) {
                Views.setVisible(children.next(), z);
            }
        }
        View view3 = this.a;
        if (view3 != null) {
            Views.setVisible(view3, z2);
        }
    }

    @Nullable
    public Drawable getIconResource(@NotNull TeaserStatus teaserStatus) {
        Intrinsics.checkNotNullParameter(teaserStatus, "status");
        int ordinal = teaserStatus.ordinal();
        if (ordinal == 0) {
            return null;
        }
        if (ordinal == 1) {
            return this.m.getContext().getDrawable(R.drawable.ic_status_ok);
        }
        if (ordinal == 2) {
            return this.m.getContext().getDrawable(R.drawable.ic_status_caution);
        }
        if (ordinal == 3) {
            return this.m.getContext().getDrawable(R.drawable.ic_status_warning);
        }
        if (ordinal == 4) {
            return this.m.getContext().getDrawable(com.avito.android.advert_core.R.drawable.ic_status_lock);
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getInsightLayoutId() {
        return R.layout.advert_details_autoteka_teaser_insight;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    @Nullable
    public AdvertDetailsTeaserView.Listener getListener() {
        return this.n;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void hide() {
        c(false);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertDetailsTeaserView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void setListener(@Nullable AdvertDetailsTeaserView.Listener listener) {
        this.n = listener;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDialog() {
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showDivider(boolean z) {
        View view = this.a;
        if (view != null) {
            Views.setVisible(view, z);
        }
        View view2 = this.b;
        if (view2 != null) {
            Views.setVisible(view2, !z);
        }
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showError(@NotNull TeaserError teaserError) {
        Intrinsics.checkNotNullParameter(teaserError, "error");
        this.k.setText(teaserError.getTitle());
        this.l.setText(teaserError.getDescription());
        b(a2.a.a.f.x.d0.a.Error);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showInsights(@NotNull List<TeaserInsight> list) {
        int i2;
        Intrinsics.checkNotNullParameter(list, "insights");
        this.g.removeAllViews();
        LinearLayout linearLayout = this.h;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (this.h == null) {
            i2 = list.size();
        } else {
            i2 = (int) Math.ceil(((double) list.size()) / 2.0d);
        }
        int i3 = 0;
        for (T t : list) {
            if (i3 < i2) {
                a(this.g, t);
            } else {
                LinearLayout linearLayout2 = this.h;
                Intrinsics.checkNotNull(linearLayout2);
                a(linearLayout2, t);
            }
            i3++;
        }
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showLoading() {
        b(a2.a.a.f.x.d0.a.Loading);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showReportLink(@NotNull ReportLink reportLink) {
        Intrinsics.checkNotNullParameter(reportLink, "reportLink");
        this.i.setText(reportLink.getTitle());
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showResult() {
        b(a2.a.a.f.x.d0.a.Result);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subTitle");
        TextViews.bindText$default(this.f, str, false, 2, null);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.e.setText(str);
    }
}
