package com.avito.android.cart.summary.konveyor.product;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.cart.summary.ScaleOnHoldTouchListener;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelGravity;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.lib.expected.stepper.Stepper;
import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImageFitting;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rambler.libs.swipe_layout.SwipeLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001mB)\u0012\u0006\u0010g\u001a\u00020>\u0012\u0006\u0010G\u001a\u00020D\u0012\u0010\u0010j\u001a\f\u0012\u0004\u0012\u00020\u00030hj\u0002`i¢\u0006\u0004\bk\u0010lJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b#\u0010\u000bJ\u001d\u0010$\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b$\u0010\u000bJ\u001d\u0010%\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b%\u0010\u000bJ#\u0010'\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050&H\u0016¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050&H\u0016¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001d\u0010U\u001a\u00020P8B@\u0002X\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010BR\"\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010YR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010BR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010BR\u0016\u0010b\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u00106R\u0016\u0010d\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010?R\u0016\u0010f\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u00106¨\u0006n"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/product/ProductItemViewHolder;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "offset", "", "t", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnLongClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnDeleteClickListener", "Lru/rambler/libs/swipe_layout/SwipeLayout$OnSwipeListener;", "setSwipeListener", "(Lru/rambler/libs/swipe_layout/SwipeLayout$OnSwipeListener;)V", "Lcom/avito/android/remote/model/Image;", "img", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "setItemsLeft", "setPricePerPiece", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "stepper", "setStepper", "(Lcom/avito/android/remote/cart/model/Store$Item$Stepper;)V", "setOnStepperMinusClickListener", "setOnStepperPlusClickListener", "setOnStepperValueClickListener", "Lkotlin/Function1;", "setOnStepperValueChangesListener", "(Lkotlin/jvm/functions/Function1;)V", "setOnPickerValueSelectedListener", "onUnbind", "()V", "Landroid/animation/ObjectAnimator;", "I", "Landroid/animation/ObjectAnimator;", "animator", "Lcom/avito/android/util/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/avito/android/util/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "y", "Landroid/widget/TextView;", "stockView", "w", "titleView", "Lru/rambler/libs/swipe_layout/SwipeLayout;", "s", "Lru/rambler/libs/swipe_layout/SwipeLayout;", "swipeLayout", "Landroid/view/View;", "Landroid/view/View;", "productView", "D", "Lkotlin/jvm/functions/Function0;", "stepperValueClickListener", "Lcom/avito/android/util/text/AttributedTextFormatter;", "K", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/lib/expected/stepper/Stepper;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/lib/expected/stepper/Stepper;", "stepperView", "Lio/reactivex/rxjava3/disposables/Disposable;", "J", "Lio/reactivex/rxjava3/disposables/Disposable;", "hideSwipeLayoutDisposable", "Lcom/avito/android/cart/summary/konveyor/product/ProductItemViewHolder$h;", "B", "Lkotlin/Lazy;", "getPickerBottomSheet", "()Lcom/avito/android/cart/summary/konveyor/product/ProductItemViewHolder$h;", "pickerBottomSheet", ExifInterface.LONGITUDE_EAST, "onMinusClickListener", "G", "Lkotlin/jvm/functions/Function1;", "onPickerValueSelected", "C", "stepperValueChangesListener", "H", "onLongClickListener", "F", "onPlusClickListener", "z", "pricePerPieceView", "u", "deleteView", "x", "priceView", "view", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/cart/summary/HideSwipeLayoutObservable;", "hideSwipeLayoutObservable", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;Lio/reactivex/rxjava3/core/Observable;)V", "h", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ProductItemViewHolder extends BaseViewHolder implements ProductItemView {
    public final Stepper A;
    public final Lazy B = t6.c.lazy(new i(this));
    public Function1<? super Integer, Unit> C = b.c;
    public Function0<Unit> D = a.e;
    public Function0<Unit> E = a.c;
    public Function0<Unit> F = a.d;
    public Function1<? super Integer, Unit> G = b.b;
    public Function0<Unit> H = a.b;
    public ObjectAnimator I;
    public final Disposable J;
    public final AttributedTextFormatter K;
    public final SwipeLayout s;
    public final View t;
    public final View u;
    public final SimpleDraweeView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i == 1) {
                return Unit.INSTANCE;
            }
            if (i == 2) {
                return Unit.INSTANCE;
            }
            if (i == 3) {
                return Unit.INSTANCE;
            }
            throw null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int i = this.a;
            if (i == 0) {
                num.intValue();
                return Unit.INSTANCE;
            } else if (i == 1) {
                num.intValue();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int i = this.a;
            if (i == 0) {
                num.intValue();
                return Unit.INSTANCE;
            } else if (i == 1) {
                num.intValue();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class d extends Lambda implements Function0<Unit> {
        public static final d b = new d(0);
        public static final d c = new d(1);
        public static final d d = new d(2);
        public static final d e = new d(3);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i == 1) {
                return Unit.INSTANCE;
            }
            if (i == 2) {
                return Unit.INSTANCE;
            }
            if (i == 3) {
                return Unit.INSTANCE;
            }
            throw null;
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ProductItemViewHolder a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ProductItemViewHolder productItemViewHolder) {
            super(0);
            this.a = productItemViewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.H.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements Predicate<Integer> {
        public final /* synthetic */ ProductItemViewHolder a;

        public f(ProductItemViewHolder productItemViewHolder) {
            this.a = productItemViewHolder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Integer num) {
            Integer num2 = num;
            return num2 == null || num2.intValue() != this.a.s.hashCode();
        }
    }

    public static final class g<T> implements Consumer<Integer> {
        public final /* synthetic */ ProductItemViewHolder a;

        public g(ProductItemViewHolder productItemViewHolder) {
            this.a = productItemViewHolder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            ProductItemViewHolder.access$animateHideDeleteView(this.a);
        }
    }

    public static final class h extends BottomSheetDialog {
        @NotNull
        public final Picker s;
        @NotNull
        public final Button t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(@NotNull Context context) {
            super(context, 0, 2, null);
            Intrinsics.checkNotNullParameter(context, "context");
            setContentView(R.layout.simple_picker_with_button, true);
            RightCrossHeaderKt.setRightCrossHeader$default(this, "Выберите количество", false, false, 6, null);
            setFitContentPeekHeight(true);
            View findViewById = findViewById(R.id.picker);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
            this.s = (Picker) findViewById;
            View findViewById2 = findViewById(R.id.button);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
            this.t = (Button) findViewById2;
        }
    }

    public static final class i extends Lambda implements Function0<h> {
        public final /* synthetic */ ProductItemViewHolder a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ProductItemViewHolder productItemViewHolder) {
            super(0);
            this.a = productItemViewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public h invoke() {
            Context context = this.a.A.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "stepperView.context");
            h hVar = new h(context);
            hVar.t.setOnClickListener(new a2.a.a.a0.a.q.a.a(this, hVar));
            return hVar;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public j(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            view.performHapticFeedback(3);
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Observable<Integer> observable) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(observable, "hideSwipeLayoutObservable");
        this.K = attributedTextFormatter;
        View findViewById = view.findViewById(com.avito.android.cart.R.id.product_swipe_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type ru.rambler.libs.swipe_layout.SwipeLayout");
        SwipeLayout swipeLayout = (SwipeLayout) findViewById;
        this.s = swipeLayout;
        View findViewById2 = swipeLayout.findViewById(com.avito.android.cart.R.id.product);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        View findViewById3 = swipeLayout.findViewById(com.avito.android.cart.R.id.bin_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById3;
        View findViewById4 = findViewById2.findViewById(com.avito.android.cart.R.id.item_image);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById4;
        View findViewById5 = findViewById2.findViewById(com.avito.android.cart.R.id.item_title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
        View findViewById6 = findViewById2.findViewById(com.avito.android.cart.R.id.item_price);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = findViewById2.findViewById(com.avito.android.cart.R.id.item_stock);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = findViewById2.findViewById(com.avito.android.cart.R.id.item_price_per_piece);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById8;
        View findViewById9 = findViewById2.findViewById(com.avito.android.cart.R.id.item_stepper);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type com.avito.android.lib.expected.stepper.Stepper");
        this.A = (Stepper) findViewById9;
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        findViewById2.setOnTouchListener(new ScaleOnHoldTouchListener(context, 250, 0, new e(this), 4, null));
        Disposable subscribe = observable.filter(new f(this)).subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "hideSwipeLayoutObservabl…animateHideDeleteView() }");
        this.J = subscribe;
    }

    public static final void access$adjustPickerData(ProductItemViewHolder productItemViewHolder, h hVar) {
        Object obj;
        boolean z2;
        IntRange intRange = new IntRange(productItemViewHolder.A.getMinValue(), productItemViewHolder.A.getMaxValue());
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new WheelData(Integer.valueOf(nextInt), String.valueOf(nextInt)));
        }
        Picker picker = hVar.s;
        picker.clearAllWheels();
        picker.addWheel(new ArrayList(arrayList), new WheelStyle(WheelGravity.CENTER, false, -1));
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((Number) ((WheelData) obj).getKey()).intValue() == productItemViewHolder.A.getValue()) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        picker.setFirstWheelValue((WheelData) obj);
    }

    public static final void access$animateHideDeleteView(ProductItemViewHolder productItemViewHolder) {
        productItemViewHolder.t(0);
    }

    public static final void access$animateShowDeleteView(ProductItemViewHolder productItemViewHolder) {
        productItemViewHolder.t(-productItemViewHolder.u.getWidth());
    }

    public static final /* synthetic */ ObjectAnimator access$getAnimator$p(ProductItemViewHolder productItemViewHolder) {
        ObjectAnimator objectAnimator = productItemViewHolder.I;
        if (objectAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animator");
        }
        return objectAnimator;
    }

    public static final h access$getPickerBottomSheet$p(ProductItemViewHolder productItemViewHolder) {
        return (h) productItemViewHolder.B.getValue();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        super.onUnbind();
        this.D = d.b;
        this.C = c.b;
        this.E = d.c;
        this.F = d.d;
        this.H = d.e;
        this.G = c.c;
        this.s.setOnSwipeListener(null);
        this.s.reset();
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setImage(@Nullable Image image) {
        ImageFitting fit$default;
        Uri width = (image == null || (fit$default = Images.fit$default(image, this.v, 0.0f, 0.0f, 2, 6, null)) == null) ? null : fit$default.width();
        if (width == null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.v).clear();
        } else {
            SimpleDraweeViewsKt.getRequestBuilder(this.v).uri(width).load();
        }
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setItemsLeft(@Nullable AttributedText attributedText) {
        TextViewsKt.bindAttributedText(this.y, attributedText, this.K);
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnDeleteClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new j(function0));
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnLongClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.H = function0;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnPickerValueSelectedListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.G = function1;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnStepperMinusClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.E = function0;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnStepperPlusClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.F = function0;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnStepperValueChangesListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.C = function1;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setOnStepperValueClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.D = function0;
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setPrice(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "price");
        TextViewsKt.setAttributedText(this.x, attributedText, this.K);
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setPricePerPiece(@Nullable AttributedText attributedText) {
        TextView textView = this.z;
        boolean z2 = true;
        if (attributedText == null || this.A.getValue() <= 1) {
            z2 = false;
        }
        Views.setVisible(textView, z2);
        if (attributedText != null) {
            TextViewsKt.setAttributedText(this.z, attributedText, this.K);
        }
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setStepper(@NotNull Store.Item.Stepper stepper) {
        ColorDrawable colorDrawable;
        Intrinsics.checkNotNullParameter(stepper, "stepper");
        Stepper stepper2 = this.A;
        stepper2.setState(stepper.getAvailableQuantity() < stepper.getQuantity() ? Stepper.State.ERROR : Stepper.State.NORMAL);
        stepper2.setMaxValue(stepper.getAvailableQuantity());
        stepper2.setValue(stepper.getQuantity());
        boolean z2 = false;
        stepper2.setOnMinusClickListener(new u4(0, this));
        stepper2.setOnPlusClickListener(new u4(1, this));
        stepper2.setOnValueClickListener(new a2.a.a.a0.a.q.a.b(this));
        stepper2.setOnValueChangeListener(new a2.a.a.a0.a.q.a.c(this));
        if (stepper.getAvailableQuantity() > 0) {
            z2 = true;
        }
        if (!z2) {
            Context context = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            colorDrawable = new ColorDrawable(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.whiteAlpha64));
        } else {
            colorDrawable = null;
        }
        ((GenericDraweeHierarchy) this.v.getHierarchy()).setOverlayImage(colorDrawable);
        Views.setVisible(this.A, z2);
        this.w.setEnabled(z2);
        this.x.setEnabled(z2);
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setSwipeListener(@NotNull SwipeLayout.OnSwipeListener onSwipeListener) {
        Intrinsics.checkNotNullParameter(onSwipeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnSwipeListener(onSwipeListener);
    }

    @Override // com.avito.android.cart.summary.konveyor.product.ProductItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.w.setText(str);
    }

    public final void t(int i2) {
        ObjectAnimator objectAnimator = this.I;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            ObjectAnimator objectAnimator2 = this.I;
            if (objectAnimator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animator");
            }
            objectAnimator2.end();
        }
        if (this.s.getOffset() != i2) {
            ObjectAnimator objectAnimator3 = new ObjectAnimator();
            objectAnimator3.setTarget(this.s);
            objectAnimator3.setInterpolator(new AccelerateInterpolator());
            objectAnimator3.setDuration(250L);
            objectAnimator3.setPropertyName("offset");
            objectAnimator3.setIntValues(this.s.getOffset(), i2);
            objectAnimator3.start();
            this.I = objectAnimator3;
        }
    }
}
