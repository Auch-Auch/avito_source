package com.avito.android.safedeal.delivery_type;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AlertBannerModel;
import com.avito.android.safedeal.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Toolbars;
import com.avito.android.util.ViewStubsKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.ParcelableItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\bE\u0010FJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00118\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8D@\u0004X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010(\u001a\u00020#8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0002038\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeViewImpl;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "Lio/reactivex/rxjava3/core/Observable;", "", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showError", "()V", "", "Lcom/avito/conveyor_item/ParcelableItem;", "items", "bindItems", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/AlertBannerModel;", "banner", "showAlertBanner", "(Lcom/avito/android/remote/model/AlertBannerModel;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/util/text/AttributedTextFormatter;", "j", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getAlertBanner", "()Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "alertBanner", "Landroid/view/ViewStub;", AuthSource.SEND_ABUSE, "Landroid/view/ViewStub;", "getStubAlertBanner", "()Landroid/view/ViewStub;", "stubAlertBanner", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "h", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/safedeal/delivery_type/RetryListener;", "i", "Lcom/avito/android/safedeal/delivery_type/RetryListener;", "retryListener", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/safedeal/delivery_type/RetryListener;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public class DeliveryTypeViewImpl implements DeliveryTypeView {
    @NotNull
    public final ViewStub a;
    @NotNull
    public final Lazy b = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(this));
    @NotNull
    public final RecyclerView c;
    @NotNull
    public final Toolbar d;
    @NotNull
    public final ProgressOverlay e;
    public final View f;
    public final AdapterPresenter g;
    public final SafeRecyclerAdapter h;
    public final RetryListener i;
    @NotNull
    public final AttributedTextFormatter j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AlertBannerModel.Style.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            AlertBannerModel.Style style = AlertBannerModel.Style.Info;
            iArr[4] = 1;
            AlertBannerModel.Style style2 = AlertBannerModel.Style.Danger;
            iArr[1] = 2;
            AlertBannerModel.Style style3 = AlertBannerModel.Style.Warning;
            iArr[3] = 3;
            AlertBannerModel.Style style4 = AlertBannerModel.Style.Default;
            iArr[0] = 4;
            AlertBannerModel.Style style5 = AlertBannerModel.Style.Success;
            iArr[2] = 5;
        }
    }

    public static final class a extends Lambda implements Function0<AlertBanner> {
        public final /* synthetic */ DeliveryTypeViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeliveryTypeViewImpl deliveryTypeViewImpl) {
            super(0);
            this.a = deliveryTypeViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public AlertBanner invoke() {
            View inflate = this.a.getStubAlertBanner().inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
            return (AlertBanner) inflate;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeliveryTypeViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DeliveryTypeViewImpl deliveryTypeViewImpl) {
            super(0);
            this.a = deliveryTypeViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.onRetry();
            return Unit.INSTANCE;
        }
    }

    public DeliveryTypeViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull RetryListener retryListener, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.f = view;
        this.g = adapterPresenter;
        this.h = safeRecyclerAdapter;
        this.i = retryListener;
        this.j = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.stub_alert_banner);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        this.a = (ViewStub) findViewById;
        int i2 = R.id.recycler_view;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        View findViewById3 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.d = (Toolbar) findViewById3;
        View findViewById4 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.e = new ProgressOverlay((ViewGroup) findViewById4, i2, null, true, 0, 20, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
        recyclerView.setItemAnimator(null);
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeView
    public void bindItems(@NotNull List<? extends ParcelableItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        a2.b.a.a.a.s1(list, this.g);
        if (this.c.getAdapter() == null) {
            this.c.setAdapter(this.h);
        } else {
            RecyclerView.Adapter adapter = this.c.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        this.e.showContent();
    }

    @NotNull
    public final AlertBanner getAlertBanner() {
        return (AlertBanner) this.b.getValue();
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        return this.j;
    }

    @NotNull
    public final ProgressOverlay getProgressOverlay() {
        return this.e;
    }

    @NotNull
    public final RecyclerView getRecycler() {
        return this.c;
    }

    @NotNull
    public final ViewStub getStubAlertBanner() {
        return this.a;
    }

    @NotNull
    public final Toolbar getToolbar() {
        return this.d;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeView
    public void showAlertBanner(@Nullable AlertBannerModel alertBannerModel) {
        int i2;
        if (alertBannerModel == null && ViewStubsKt.isInflated(this.a)) {
            Views.hide(getAlertBanner());
        } else if (alertBannerModel != null) {
            AlertBanner alertBanner = getAlertBanner();
            int ordinal = alertBannerModel.getStyle().ordinal();
            if (ordinal == 0) {
                i2 = com.avito.android.lib.design.R.attr.alertBannerDefault;
            } else if (ordinal == 1) {
                i2 = com.avito.android.lib.design.R.attr.alertBannerDanger;
            } else if (ordinal == 2) {
                i2 = com.avito.android.lib.design.R.attr.alertBannerSuccess;
            } else if (ordinal == 3) {
                i2 = com.avito.android.lib.design.R.attr.alertBannerWarning;
            } else if (ordinal == 4) {
                i2 = com.avito.android.lib.design.R.attr.alertBannerInfo;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            AlertBanner.setContentByAttr$default(alertBanner, 0, i2, 1, null);
            AlertBannerContent content = alertBanner.getContent();
            AttributedTextFormatter attributedTextFormatter = this.j;
            Context context = this.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            content.setTitle(attributedTextFormatter.format(context, alertBannerModel.getTitle()));
            AlertBannerContent content2 = alertBanner.getContent();
            AttributedTextFormatter attributedTextFormatter2 = this.j;
            Context context2 = this.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            content2.setBody(attributedTextFormatter2.format(context2, alertBannerModel.getBody()));
            AlertBannerContent content3 = alertBanner.getContent();
            Context context3 = this.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            content3.setImageDrawable(Contexts.getDrawableByAttr(context3, com.avito.android.lib.design.R.attr.ic_attentionRound20));
            Views.show(alertBanner);
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeView
    public void showError() {
        this.e.setOnRefreshListener(new b(this));
        ProgressOverlay progressOverlay = this.e;
        String string = this.f.getResources().getString(R.string.network_retry_message_safe_deal);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…_retry_message_safe_deal)");
        progressOverlay.showLoadingProblem(string);
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return Toolbars.upClicks(this.d);
    }
}
