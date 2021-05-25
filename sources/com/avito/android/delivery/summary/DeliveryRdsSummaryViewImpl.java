package com.avito.android.delivery.summary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.delivery.R;
import com.avito.android.delivery.summary.konveyor.button.ButtonState;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelGravity;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.lib.expected.stepper.Stepper;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u00109\u001a\u00020\u000b\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010F\u001a\u00020C\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020!8B@\u0002X\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00102\u001a\u00020.8B@\u0002X\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0002038B@\u0002X\u0002¢\u0006\f\n\u0004\b4\u0010\u0015\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\rR\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010B\u001a\u00020>8B@\u0002X\u0002¢\u0006\f\n\u0004\b?\u0010\u0015\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006N"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewImpl;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryView;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;)V", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "contentHolder", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Landroidx/recyclerview/widget/RecyclerView;", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/graphics/drawable/Drawable;", "k", "Lkotlin/Lazy;", "getToolbarShadow", "()Landroid/graphics/drawable/Drawable;", "toolbarShadow", "Lcom/avito/android/util/text/AttributedTextFormatter;", "o", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "i", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/lib/expected/stepper/Stepper;", "d", "getStepper", "()Lcom/avito/android/lib/expected/stepper/Stepper;", "stepper", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "f", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheetPicker", "", "l", "F", "disabledImageAlpha", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "getHeaderItemGroup", "()Landroid/view/ViewGroup;", "headerItemGroup", "Landroid/widget/TextView;", "e", "getPricePerPiece", "()Landroid/widget/TextView;", "pricePerPiece", AuthSource.OPEN_CHANNEL_LIST, "view", "Lcom/avito/android/lib/design/tooltip/Tooltip;", a2.g.r.g.a, "Lcom/avito/android/lib/design/tooltip/Tooltip;", "tooltip", "Lcom/avito/android/util/SimpleDraweeView;", "c", "getImage", "()Lcom/avito/android/util/SimpleDraweeView;", "image", "Landroidx/lifecycle/LifecycleOwner;", "n", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryViewImpl implements DeliveryRdsSummaryView {
    public final View a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public BottomSheetDialog f;
    public Tooltip g;
    public final FrameLayout h;
    public final ProgressOverlay i;
    public final RecyclerView j;
    public final Lazy k;
    public float l = 1.0f;
    public final View m;
    public final LifecycleOwner n;
    public final AttributedTextFormatter o;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Unit unit) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                } else if (unit != null) {
                    ((DeliveryRdsSummaryViewImpl) this.b).i.showLoading();
                }
            } else if (unit != null) {
                ((DeliveryRdsSummaryViewImpl) this.b).i.showContent();
            }
        }
    }

    public static final class b<T> implements Observer<Pair<? extends String, ? extends Boolean>> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        public b(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Pair<? extends String, ? extends Boolean> pair) {
            Pair<? extends String, ? extends Boolean> pair2 = pair;
            SnackbarExtensionsKt.showSnackbar$default(this.a.m, (String) pair2.component1(), 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, ((Boolean) pair2.component2()).booleanValue() ? SnackbarType.ERROR : SnackbarType.DEFAULT, 126, (Object) null);
        }
    }

    public static final class c<T> implements Observer<Boolean> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;
        public final /* synthetic */ DeliveryRdsSummaryViewModel b;

        public c(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
            this.a = deliveryRdsSummaryViewImpl;
            this.b = deliveryRdsSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            int i;
            Boolean bool2 = bool;
            if (this.b.getHeaderStepperVisible()) {
                Stepper access$getStepper$p = DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a);
                int i2 = 0;
                int childCount = access$getStepper$p.getChildCount() - 1;
                if (childCount >= 0) {
                    while (true) {
                        View childAt = access$getStepper$p.getChildAt(i2);
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                        childAt.setClickable(!bool2.booleanValue());
                        if (i2 == childCount) {
                            break;
                        }
                        i2++;
                    }
                }
            }
            View view = this.a.m;
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null) {
                Intrinsics.checkNotNullExpressionValue(bool2, "disabled");
                if (bool2.booleanValue()) {
                    this.a.m.requestFocus();
                    i = 393216;
                } else {
                    i = 262144;
                }
                viewGroup.setDescendantFocusability(i);
                return;
            }
            this.a.m.setEnabled(!bool2.booleanValue());
        }
    }

    public static final class d<T> implements Observer<DeliverySummaryRds.Header> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;
        public final /* synthetic */ DeliveryRdsSummaryViewModel b;

        public d(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
            this.a = deliveryRdsSummaryViewImpl;
            this.b = deliveryRdsSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeliverySummaryRds.Header header) {
            DeliverySummaryRds.Header header2 = header;
            ViewGroup access$getHeaderItemGroup$p = DeliveryRdsSummaryViewImpl.access$getHeaderItemGroup$p(this.a);
            SimpleDraweeView access$getImage$p = DeliveryRdsSummaryViewImpl.access$getImage$p(this.a);
            Uri width = Images.fit$default(header2.getImage(), access$getImage$p, 0.0f, 0.0f, 2, 6, null).width();
            if (width == null) {
                SimpleDraweeViewsKt.getRequestBuilder(access$getImage$p).clear();
            } else {
                SimpleDraweeViewsKt.getRequestBuilder(access$getImage$p).uri(width).listener(new DeliveryRdsSummaryViewImpl$bindTo$2$$special$$inlined$with$lambda$5(this, header2)).load();
            }
            View findViewById = access$getHeaderItemGroup$p.findViewById(R.id.title);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextViewsKt.setAttributedText((TextView) findViewById, header2.getText(), this.a.o);
            Integer availableQuantity = header2.getAvailableQuantity();
            int intValue = availableQuantity != null ? availableQuantity.intValue() : Integer.MAX_VALUE;
            Stepper access$getStepper$p = DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a);
            Views.setVisible(access$getStepper$p, this.b.getHeaderStepperVisible());
            if (this.b.getHeaderStepperVisible()) {
                access$getStepper$p.setOnValueChangeListener(new a2.a.a.k0.e.h(this.b.getItemQuantityConsumer()));
                DeliveryRdsSummaryViewImpl.access$setMaxValue(this.a, access$getStepper$p, intValue, this.b.getSubmitButtonStateConsumer());
                this.b.getItemQuantityConsumer().accept(Integer.valueOf(access$getStepper$p.getValue()));
                access$getStepper$p.setOnMinusClickListener(new h4(0, intValue, access$getStepper$p, this, header2));
                access$getStepper$p.setOnPlusClickListener(new h4(1, intValue, access$getStepper$p, this, header2));
                access$getStepper$p.setOnValueClickListener(new a2.a.a.k0.e.g(access$getStepper$p, intValue, this, header2));
            }
            AttributedText pricePerPiece = header2.getPricePerPiece();
            if (pricePerPiece != null) {
                TextViewsKt.setAttributedText(DeliveryRdsSummaryViewImpl.access$getPricePerPiece$p(this.a), pricePerPiece, this.a.o);
            }
        }
    }

    public static final class e<T> implements Observer<Integer> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;
        public final /* synthetic */ DeliveryRdsSummaryViewModel b;

        public e(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
            this.a = deliveryRdsSummaryViewImpl;
            this.b = deliveryRdsSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            Integer num2 = num;
            DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl = this.a;
            Stepper access$getStepper$p = DeliveryRdsSummaryViewImpl.access$getStepper$p(deliveryRdsSummaryViewImpl);
            Intrinsics.checkNotNullExpressionValue(num2, "maxQuantity");
            DeliveryRdsSummaryViewImpl.access$setMaxValue(deliveryRdsSummaryViewImpl, access$getStepper$p, num2.intValue(), this.b.getSubmitButtonStateConsumer());
        }
    }

    public static final class f<T> implements Observer<Boolean> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        public f(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            Boolean bool2 = bool;
            TextView access$getPricePerPiece$p = DeliveryRdsSummaryViewImpl.access$getPricePerPiece$p(this.a);
            Intrinsics.checkNotNullExpressionValue(bool2, "visible");
            if (bool2.booleanValue()) {
                Views.show(access$getPricePerPiece$p);
            } else {
                Views.conceal(access$getPricePerPiece$p);
            }
        }
    }

    public static final class g<T> implements Observer<String> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        public g(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(String str) {
            String str2 = str;
            Tooltip tooltip = this.a.g;
            if (tooltip != null) {
                tooltip.dismiss();
            }
            if (str2 == null || str2.length() == 0) {
                DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a).setState(Stepper.State.NORMAL);
                this.a.g = null;
                return;
            }
            DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a).setState(Stepper.State.ERROR);
            DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl = this.a;
            Context context = DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "stepper.context");
            deliveryRdsSummaryViewImpl.g = TooltipContentKt.content(new Tooltip(context, 0, R.style.Tooltip_Stepper, 2, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.End(new AnchorPositions.Center()))), new a2.a.a.k0.e.i(str2)).show(DeliveryRdsSummaryViewImpl.access$getStepper$p(this.a));
        }
    }

    public static final class h<T> implements Observer<Float> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        public h(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Float f) {
            Float f2 = f;
            DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(f2, "it");
            deliveryRdsSummaryViewImpl.l = f2.floatValue();
        }
    }

    public static final class i<T> implements Observer<Runnable> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        public i(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Runnable runnable) {
            Runnable runnable2 = runnable;
            if (runnable2 != null) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.i, null, 1, null);
                this.a.i.setOnRefreshListener(new a2.a.a.k0.e.j(runnable2));
            }
        }
    }

    public static final class j extends Lambda implements Function0<ViewGroup> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            super(0);
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewGroup invoke() {
            View findViewById = this.a.a.findViewById(R.id.header_item_group);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) findViewById;
            Views.show(viewGroup);
            return viewGroup;
        }
    }

    public static final class k extends Lambda implements Function0<SimpleDraweeView> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            super(0);
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleDraweeView invoke() {
            View findViewById = DeliveryRdsSummaryViewImpl.access$getHeaderItemGroup$p(this.a).findViewById(R.id.image);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
            return (SimpleDraweeView) findViewById;
        }
    }

    public static final class l extends Lambda implements Function0<TextView> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            super(0);
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View findViewById = DeliveryRdsSummaryViewImpl.access$getHeaderItemGroup$p(this.a).findViewById(R.id.price_per_piece);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    }

    public static final class m extends Lambda implements Function0<Stepper> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            super(0);
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Stepper invoke() {
            View findViewById = DeliveryRdsSummaryViewImpl.access$getHeaderItemGroup$p(this.a).findViewById(R.id.stepper);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.expected.stepper.Stepper");
            return (Stepper) findViewById;
        }
    }

    public static final class n extends Lambda implements Function0<Drawable> {
        public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
            super(0);
            this.a = deliveryRdsSummaryViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Drawable invoke() {
            return this.a.h.getContext().getDrawable(com.avito.android.deprecated_design.R.drawable.shadow_toolbar);
        }
    }

    public DeliveryRdsSummaryViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull LifecycleOwner lifecycleOwner, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.m = view;
        this.n = lifecycleOwner;
        this.o = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.header);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.b = t6.c.lazy(lazyThreadSafetyMode, (Function0) new j(this));
        this.c = t6.c.lazy(lazyThreadSafetyMode, (Function0) new k(this));
        this.d = t6.c.lazy(lazyThreadSafetyMode, (Function0) new m(this));
        this.e = t6.c.lazy(lazyThreadSafetyMode, (Function0) new l(this));
        View findViewById2 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.h = frameLayout;
        this.i = new ProgressOverlay(frameLayout, R.id.recycler_view, analytics, false, 0, 24, null);
        View findViewById3 = view.findViewById(R.id.summary_list);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.j = recyclerView;
        this.k = t6.c.lazy(lazyThreadSafetyMode, (Function0) new n(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this, adapter) { // from class: com.avito.android.delivery.summary.DeliveryRdsSummaryViewImpl$$special$$inlined$with$lambda$1
            public final /* synthetic */ DeliveryRdsSummaryViewImpl a;

            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                this.a.h.setForeground(recyclerView2.canScrollVertically(-1) ? DeliveryRdsSummaryViewImpl.access$getToolbarShadow$p(this.a) : null);
            }
        });
    }

    public static final ViewGroup access$getHeaderItemGroup$p(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
        return (ViewGroup) deliveryRdsSummaryViewImpl.b.getValue();
    }

    public static final SimpleDraweeView access$getImage$p(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
        return (SimpleDraweeView) deliveryRdsSummaryViewImpl.c.getValue();
    }

    public static final TextView access$getPricePerPiece$p(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
        return (TextView) deliveryRdsSummaryViewImpl.e.getValue();
    }

    public static final Stepper access$getStepper$p(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
        return (Stepper) deliveryRdsSummaryViewImpl.d.getValue();
    }

    public static final Drawable access$getToolbarShadow$p(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl) {
        return (Drawable) deliveryRdsSummaryViewImpl.k.getValue();
    }

    public static final void access$setMaxValue(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, Stepper stepper, int i2, Consumer consumer) {
        float f2;
        Objects.requireNonNull(deliveryRdsSummaryViewImpl);
        int i3 = 0;
        boolean z = i2 > 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        stepper.setMinValue(i4);
        stepper.setMaxValue(i2);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) deliveryRdsSummaryViewImpl.c.getValue();
        if (z) {
            f2 = 1.0f;
        } else {
            f2 = deliveryRdsSummaryViewImpl.l;
        }
        simpleDraweeView.setAlpha(f2);
        ViewGroup viewGroup = (ViewGroup) deliveryRdsSummaryViewImpl.b.getValue();
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            while (true) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                childAt.setEnabled(z);
                if (i3 == childCount) {
                    break;
                }
                i3++;
            }
        }
        if (consumer != null) {
            consumer.accept(new ButtonState(null, null, Boolean.valueOf(z), 3, null));
        }
    }

    public static final void access$showValuePicker(DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, int i2, int i3, int i4, Function1 function1) {
        boolean z;
        BottomSheetDialog bottomSheetDialog = deliveryRdsSummaryViewImpl.f;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.close();
        }
        Context context = deliveryRdsSummaryViewImpl.m.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Object obj = null;
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(context, 0, 2, null);
        bottomSheetDialog2.setContentView(com.avito.android.ui_components.R.layout.simple_picker_with_button, true);
        RightCrossHeaderKt.setRightCrossHeader$default(bottomSheetDialog2, "Выберите количество", false, false, 6, null);
        bottomSheetDialog2.setFitContentPeekHeight(true);
        View findViewById = bottomSheetDialog2.findViewById(com.avito.android.ui_components.R.id.picker);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        Picker picker = (Picker) findViewById;
        View findViewById2 = bottomSheetDialog2.findViewById(com.avito.android.ui_components.R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        Button button = (Button) findViewById2;
        IntRange intRange = new IntRange(i3, i4);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new WheelData(Integer.valueOf(nextInt), String.valueOf(nextInt)));
        }
        picker.addWheel(new ArrayList(arrayList), new WheelStyle(WheelGravity.CENTER, false, -1));
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Number) ((WheelData) next).getKey()).intValue() == i2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        picker.setFirstWheelValue((WheelData) obj);
        button.setOnClickListener(new a2.a.a.k0.e.k(bottomSheetDialog2, picker, deliveryRdsSummaryViewImpl, i3, i4, i2, function1));
        bottomSheetDialog2.show();
        deliveryRdsSummaryViewImpl.f = bottomSheetDialog2;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryView
    public void bindTo(@NotNull DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryViewModel, "viewModel");
        this.j.addItemDecoration(new PaddingListDecoration(deliveryRdsSummaryViewModel.getHeaderStepperVisible() ? 0 : ViewSizeKt.getDp(12), ViewSizeKt.getDp(22), 0, 0, 12, null));
        deliveryRdsSummaryViewModel.getDisableAllViews().observe(this.n, new c(this, deliveryRdsSummaryViewModel));
        deliveryRdsSummaryViewModel.getHeaderChanges().observe(this.n, new d(this, deliveryRdsSummaryViewModel));
        deliveryRdsSummaryViewModel.getItemMaxQuantityChanges().observe(this.n, new e(this, deliveryRdsSummaryViewModel));
        deliveryRdsSummaryViewModel.getPricePerPieceVisible().observe(this.n, new f(this));
        deliveryRdsSummaryViewModel.getStepperTooltipMessages().observe(this.n, new g(this));
        deliveryRdsSummaryViewModel.getDisabledImageAlphaChanges().observe(this.n, new h(this));
        deliveryRdsSummaryViewModel.getShowContentChanges().observe(this.n, new a(0, this));
        deliveryRdsSummaryViewModel.getProgressChanges().observe(this.n, new a(1, this));
        deliveryRdsSummaryViewModel.getErrorChanges().observe(this.n, new i(this));
        deliveryRdsSummaryViewModel.getSnackBarErrorChanges().observe(this.n, new b(this));
    }
}
