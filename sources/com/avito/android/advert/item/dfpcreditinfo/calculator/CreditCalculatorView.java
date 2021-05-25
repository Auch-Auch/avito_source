package com.avito.android.advert.item.dfpcreditinfo.calculator;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelGravity;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 ;2\u00020\u0001:\u0001;B/\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0006\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJg\u0010\u0012\u001a\u00020\u00112\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u001eH\u0004¢\u0006\u0004\b!\u0010\"R\u001c\u0010(\u001a\u00020#8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "", "", FirebaseAnalytics.Param.TERM, "", "isTitle", "", "formatTerm", "(IZ)Ljava/lang/String;", "Lkotlin/Pair;", "initialPayment", "", "terms", "inputHint", "loan", "monthlyPayment", "percent", "", "setData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", "text", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clearFocus", "()V", "hasFocus", "()Z", "selectedTerm", "Lkotlin/Function1;", "formatter", "onTermSelected", "showTermPicker", "(ILjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "c", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "getListener", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "d", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "termPickDialog", "infoContainerLayoutId", "inputContainerLayoutId", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;II)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class CreditCalculatorView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public BottomSheetDialog a;
    @NotNull
    public final View b;
    @NotNull
    public final DfpCreditButton.Listener c;
    public final CreditInfoResourcesProvider d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView$Companion;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;", "type", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "create", "(Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Type.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }

        public Companion() {
        }

        @NotNull
        public final CreditCalculatorView create(@NotNull Type type, @NotNull View view, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider, @NotNull DfpCreditButton.Listener listener) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
            Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            int ordinal = type.ordinal();
            if (ordinal == 0) {
                return new SravniCalculatorView(view, listener, creditInfoResourcesProvider);
            }
            if (ordinal == 1) {
                return new TinkoffCalculatorView(view, listener, creditInfoResourcesProvider);
            }
            throw new NoWhenBranchMatchedException();
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ List b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function1 d;

        /* renamed from: com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView$a$a  reason: collision with other inner class name */
        public static final class C0129a extends Lambda implements Function1<WheelData<?>, Unit> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0129a(a aVar) {
                super(1);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(WheelData<?> wheelData) {
                WheelData<?> wheelData2 = wheelData;
                Intrinsics.checkNotNullParameter(wheelData2, "data");
                List list = this.a.b;
                Object key = wheelData2.getKey();
                Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
                this.a.d.invoke(Integer.valueOf(((Number) list.get(((Integer) key).intValue())).intValue()));
                return Unit.INSTANCE;
            }
        }

        public a(Picker picker, List list, Function1 function1, int i, Function1 function12) {
            this.a = picker;
            this.b = list;
            this.c = function1;
            this.d = function12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.addOnSelected(new C0129a(this));
        }
    }

    public CreditCalculatorView(@NotNull View view, @NotNull DfpCreditButton.Listener listener, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
        this.b = view;
        this.c = listener;
        this.d = creditInfoResourcesProvider;
        View findViewById = view.findViewById(R.id.info_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        ((ViewStub) findViewById).setLayoutResource(i);
        View findViewById2 = view.findViewById(R.id.input_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewStub");
        ((ViewStub) findViewById2).setLayoutResource(i2);
    }

    public abstract void clearFocus();

    @NotNull
    public final String formatTerm(int i, boolean z) {
        int i2 = i / 12;
        if (z) {
            return this.d.getTermYears(i2);
        }
        return String.valueOf(i2);
    }

    @NotNull
    public final DfpCreditButton.Listener getListener() {
        return this.c;
    }

    @NotNull
    public final View getView() {
        return this.b;
    }

    public abstract boolean hasFocus();

    public abstract void setData(@NotNull Pair<Integer, String> pair, int i, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3);

    public abstract void showButton(@NotNull String str, @NotNull String str2, @NotNull String str3);

    public final void showTermPicker(int i, @NotNull List<Integer> list, @NotNull Function1<? super Integer, String> function1, @NotNull Function1<? super Integer, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(function1, "formatter");
        Intrinsics.checkNotNullParameter(function12, "onTermSelected");
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.close();
        }
        Context context = this.b.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        WheelData<?> wheelData = null;
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(context, 0, 2, null);
        bottomSheetDialog2.setContentView(R.layout.advert_details_credit_terms_picker, true);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog2, null, null, false, true, 7, null);
        bottomSheetDialog2.setFitContentPeekHeight(true);
        View findViewById = bottomSheetDialog2.findViewById(R.id.picker);
        Intrinsics.checkNotNull(findViewById);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<Picker>(R.id.picker)!!");
        Picker picker = (Picker) findViewById;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            WheelData<?> wheelData2 = new WheelData<>(Integer.valueOf(i2), function1.invoke(Integer.valueOf(t.intValue())));
            if (i == list.get(i2).intValue()) {
                wheelData = wheelData2;
            }
            arrayList.add(wheelData2);
            i2 = i3;
        }
        picker.addWheel(arrayList, new WheelStyle(WheelGravity.CENTER, false, -1));
        picker.setFirstWheelValue(wheelData);
        picker.postDelayed(new a(picker, list, function1, i, function12), 100);
        bottomSheetDialog2.show();
        Unit unit = Unit.INSTANCE;
        this.a = bottomSheetDialog2;
    }
}
