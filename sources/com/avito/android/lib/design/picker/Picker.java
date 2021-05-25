package com.avito.android.lib.design.picker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010f\u001a\u00020\u0016\u0012\b\b\u0002\u0010g\u001a\u00020\u0016¢\u0006\u0004\bh\u0010iJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015J\u0017\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0016¢\u0006\u0004\b\u000e\u0010\u0017J:\u0010\u001e\u001a\u00020\u00022+\u0010\u001d\u001a'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0002`\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010 \u001a\u00020\u00022+\u0010\u001d\u001a'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0002`\u001c¢\u0006\u0004\b \u0010\u001fJ:\u0010!\u001a\u00020\u00022+\u0010\u001d\u001a'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\u0002`\u001c¢\u0006\u0004\b!\u0010\u001fJ\u001d\u0010$\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b&\u0010%J\u001d\u0010'\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b'\u0010%J\u001d\u0010(\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b(\u0010%J\u001d\u0010)\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b)\u0010%J\u001d\u0010*\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"¢\u0006\u0004\b*\u0010%J#\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b,\u0010-JS\u00101\u001a\u00020\u00022D\u0010\u001d\u001a@\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0002\u0018\u00010.¢\u0006\u0004\b1\u00102Jt\u00101\u001a\u00020\u0002\"\u0004\b\u0000\u001032_\u0010\u001d\u001a[\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(0\u0012\u0019\u0012\u0017\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0002\u0018\u000104¢\u0006\u0004\b1\u00106J\r\u00107\u001a\u00020\u0002¢\u0006\u0004\b7\u0010\u0004J\r\u00109\u001a\u000208¢\u0006\u0004\b9\u0010:J5\u0010?\u001a\u00020\u00022\n\u0010;\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0016¢\u0006\u0004\b?\u0010@J5\u0010A\u001a\u00020\u00022\n\u0010;\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0016¢\u0006\u0004\bA\u0010@J#\u0010B\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER0\u0010L\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR0\u0010T\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\bR\u0010I\"\u0004\bS\u0010KR\u0016\u0010X\u001a\u00020U8\u0002@\u0002XD¢\u0006\u0006\n\u0004\bV\u0010WR0\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\bY\u0010I\"\u0004\bZ\u0010KR\u0016\u0010]\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010ER\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006j"}, d2 = {"Lcom/avito/android/lib/design/picker/Picker;", "Landroid/widget/FrameLayout;", "", "clearAllWheels", "()V", "", "Lcom/avito/android/lib/design/picker/WheelData;", "items", "Lcom/avito/android/lib/design/picker/WheelStyle;", "wheelStyle", "addWheel", "(Ljava/util/List;Lcom/avito/android/lib/design/picker/WheelStyle;)V", "", "text", "addDivider", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "", "(I)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wheelData", "Lcom/avito/android/lib/design/picker/WheelSelectionCallback;", "onSelected", "addOnSelected", "(Lkotlin/jvm/functions/Function1;)V", "addOnSecondWheelSelected", "addOnThirdWheelSelected", "Lkotlin/Function0;", "callback", "setOnScrollFinishedCallback", "(Lkotlin/jvm/functions/Function0;)V", "setOnSecondScrollFinishedCallback", "setOnThirdScrollFinishedCallback", "setOnScrollStartedCallback", "setOnSecondScrollStartedCallback", "setOnThirdScrollStartedCallback", "wheelIndex", "getWheelData", "(ILjava/lang/String;)Lcom/avito/android/lib/design/picker/WheelData;", "Lkotlin/Function2;", "firstWheelData", "secondWheelData", "setOnSelection", "(Lkotlin/jvm/functions/Function2;)V", "T", "Lkotlin/Function3;", "thirdWheelData", "(Lkotlin/jvm/functions/Function3;)V", "clearOnSelection", "", "checkIfScrollFinished", "()Z", "limitInnerWheelData", "limitOuterWheelData", "innerWheelIndex", "outerWheelIndex", "setUpperLimit", "(Lcom/avito/android/lib/design/picker/WheelData;Lcom/avito/android/lib/design/picker/WheelData;II)V", "setLowerLimit", "setValueForWheelByIndex", "(ILcom/avito/android/lib/design/picker/WheelData;)V", "d", "I", "wheelRightMargin", "value", "getFirstWheelValue", "()Lcom/avito/android/lib/design/picker/WheelData;", "setFirstWheelValue", "(Lcom/avito/android/lib/design/picker/WheelData;)V", "firstWheelValue", "", "Lcom/avito/android/lib/design/picker/Wheel;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "wheels", "getSecondWheelValue", "setSecondWheelValue", "secondWheelValue", "", "e", "J", "DELAY_MS", "getThirdWheelValue", "setThirdWheelValue", "thirdWheelValue", "c", "wheelLeftMargin", "Landroid/widget/LinearLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/LinearLayout;", "containerLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Picker extends FrameLayout {
    public final List<Wheel> a;
    public final LinearLayout b;
    public int c;
    public int d;
    public final long e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WheelGravity.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[0] = 2;
            iArr[1] = 3;
        }
    }

    public static final class a extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ WheelData e;
        public final /* synthetic */ int f;
        public final /* synthetic */ List g;
        public final /* synthetic */ int h;
        public final /* synthetic */ WheelData i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Picker picker, int i2, List list, int i3, WheelData wheelData, int i4, List list2, int i5, WheelData wheelData2) {
            super(2);
            this.a = picker;
            this.b = i2;
            this.c = list;
            this.d = i3;
            this.e = wheelData;
            this.f = i4;
            this.g = list2;
            this.h = i5;
            this.i = wheelData2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
            WheelData<?> wheelData3 = wheelData;
            WheelData<?> wheelData4 = wheelData2;
            if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.c, wheelData4) <= this.b) {
                if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.c, wheelData4) < this.b) {
                    this.a.setValueForWheelByIndex(this.d, this.e);
                }
                if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.g, wheelData3) < this.f) {
                    Picker picker = this.a;
                    picker.postDelayed(new a2.a.a.k1.a.f.b(this), picker.e);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<WheelData<?>, Unit> {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ Function2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Picker picker, Function2 function2) {
            super(1);
            this.a = picker;
            this.b = function2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WheelData<?> wheelData) {
            Intrinsics.checkNotNullParameter(wheelData, "wheelData");
            Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a.a, 0);
            Wheel wheel2 = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a.a, 1);
            WheelData<?> wheelData2 = null;
            WheelData<?> selectedResult = wheel != null ? wheel.getSelectedResult() : null;
            if (wheel2 != null) {
                wheelData2 = wheel2.getSelectedResult();
            }
            Function2 function2 = this.b;
            if (function2 != null) {
                Unit unit = (Unit) function2.invoke(selectedResult, wheelData2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<WheelData<?>, Unit> {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ Function3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Picker picker, Function3 function3) {
            super(1);
            this.a = picker;
            this.b = function3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WheelData<?> wheelData) {
            Intrinsics.checkNotNullParameter(wheelData, "wheelData");
            Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a.a, 0);
            Wheel wheel2 = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a.a, 1);
            Wheel wheel3 = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a.a, 2);
            WheelData<?> wheelData2 = null;
            WheelData<?> selectedResult = wheel != null ? wheel.getSelectedResult() : null;
            WheelData<?> selectedResult2 = wheel2 != null ? wheel2.getSelectedResult() : null;
            if (wheel3 != null) {
                wheelData2 = wheel3.getSelectedResult();
            }
            Function3 function3 = this.b;
            if (function3 != null) {
                Unit unit = (Unit) function3.invoke(selectedResult, selectedResult2, wheelData2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ WheelData e;
        public final /* synthetic */ int f;
        public final /* synthetic */ List g;
        public final /* synthetic */ int h;
        public final /* synthetic */ WheelData i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Picker picker, int i2, List list, int i3, WheelData wheelData, int i4, List list2, int i5, WheelData wheelData2) {
            super(2);
            this.a = picker;
            this.b = i2;
            this.c = list;
            this.d = i3;
            this.e = wheelData;
            this.f = i4;
            this.g = list2;
            this.h = i5;
            this.i = wheelData2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
            WheelData<?> wheelData3 = wheelData;
            WheelData<?> wheelData4 = wheelData2;
            if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.c, wheelData4) >= this.b) {
                if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.c, wheelData4) > this.b) {
                    this.a.setValueForWheelByIndex(this.d, this.e);
                }
                if (CollectionsKt___CollectionsKt.indexOf((List<? extends WheelData<?>>) this.g, wheelData3) > this.f) {
                    Picker picker = this.a;
                    picker.postDelayed(new a2.a.a.k1.a.f.c(this), picker.e);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public Picker(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public Picker(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public Picker(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Picker(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.picker : i, (i3 & 8) != 0 ? R.style.Design_Widget_Picker : i2);
    }

    public static /* synthetic */ void addWheel$default(Picker picker, List list, WheelStyle wheelStyle, int i, Object obj) {
        if ((i & 2) != 0) {
            wheelStyle = new WheelStyle(null, false, 0, 7, null);
        }
        picker.addWheel(list, wheelStyle);
    }

    public final void addDivider(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        LinearLayout linearLayout = this.b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WheelTextDivider wheelTextDivider = new WheelTextDivider(context, str);
        wheelTextDivider.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.addView(wheelTextDivider);
    }

    public final void addOnSecondWheelSelected(@Nullable Function1<? super WheelData<?>, Unit> function1) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 1);
        if (wheel != null) {
            wheel.addOnSelection(function1);
        }
    }

    public final void addOnSelected(@Nullable Function1<? super WheelData<?>, Unit> function1) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 0);
        if (wheel != null) {
            wheel.addOnSelection(function1);
        }
    }

    public final void addOnThirdWheelSelected(@Nullable Function1<? super WheelData<?>, Unit> function1) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 2);
        if (wheel != null) {
            wheel.addOnSelection(function1);
        }
    }

    public final void addWheel(@NotNull List<? extends WheelData<?>> list, @NotNull WheelStyle wheelStyle) {
        int i;
        Object obj;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(wheelStyle, "wheelStyle");
        LinearLayout linearLayout = this.b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Wheel wheel = new Wheel(context, wheelStyle, list);
        if (wheelStyle.getExplicitWidth() != 0) {
            i = wheelStyle.getExplicitWidth();
        } else {
            Iterator it = SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), a2.a.a.k1.a.f.a.a).iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int length = ((String) obj).length();
                    do {
                        Object next = it.next();
                        int length2 = ((String) next).length();
                        if (length < length2) {
                            obj = next;
                            length = length2;
                        }
                    } while (it.hasNext());
                }
            }
            Intrinsics.checkNotNull(obj);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.design_picker_wheel_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.text);
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            textView.setText((String) obj);
            inflate.measure(0, 0);
            i = textView.getMeasuredWidth();
            int ordinal = wheelStyle.getTextPositon().ordinal();
            if (ordinal == 0) {
                i2 = this.c * 2;
                i3 = this.d;
            } else if (ordinal == 1) {
                i = a2.b.a.a.a.c2(this.d, 2, this.c, i);
            } else if (ordinal == 2) {
                i2 = this.c;
                i3 = this.d;
            }
            i += i2 + i3;
        }
        wheel.setLayoutParams(new FrameLayout.LayoutParams(i, -1));
        this.a.add(wheel);
        linearLayout.addView(wheel);
    }

    public final boolean checkIfScrollFinished() {
        Iterator<T> it = this.a.iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                T next = it.next();
                if (!z || !next.checkIfScrollFinished()) {
                    z = false;
                }
            }
        }
    }

    public final void clearAllWheels() {
        this.b.removeAllViews();
        this.a.clear();
    }

    public final void clearOnSelection() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().clearOnSelection();
        }
    }

    @Nullable
    public final WheelData<?> getFirstWheelValue() {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 0);
        if (wheel != null) {
            return wheel.getSelectedResult();
        }
        return null;
    }

    @Nullable
    public final WheelData<?> getSecondWheelValue() {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 1);
        if (wheel != null) {
            return wheel.getSelectedResult();
        }
        return null;
    }

    @Nullable
    public final WheelData<?> getThirdWheelValue() {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 2);
        if (wheel != null) {
            return wheel.getSelectedResult();
        }
        return null;
    }

    @Nullable
    public final WheelData<?> getWheelData(int i, @NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "name");
        Iterator<T> it = this.a.get(i).getItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getName(), str)) {
                break;
            }
        }
        return t;
    }

    public final void setFirstWheelValue(@Nullable WheelData<?> wheelData) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 0);
        if (wheel != null) {
            wheel.setSelectedResult(wheelData);
        }
    }

    public final void setLowerLimit(@NotNull WheelData<?> wheelData, @NotNull WheelData<?> wheelData2, int i, int i2) {
        Intrinsics.checkNotNullParameter(wheelData, "limitInnerWheelData");
        Intrinsics.checkNotNullParameter(wheelData2, "limitOuterWheelData");
        List<WheelData<?>> items = this.a.get(i).getItems();
        List<WheelData<?>> items2 = this.a.get(i2).getItems();
        int indexOf = items.indexOf(wheelData);
        int indexOf2 = items2.indexOf(wheelData2);
        if (indexOf != 0 || indexOf2 != 0) {
            setOnSelection(new a(this, indexOf2, items2, i2, wheelData2, indexOf, items, i, wheelData));
        }
    }

    public final void setOnScrollFinishedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 0);
        if (wheel != null) {
            wheel.setOnScrollFinished(function0);
        }
    }

    public final void setOnScrollStartedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 0);
        if (wheel != null) {
            wheel.setOnScrollStarted(function0);
        }
    }

    public final void setOnSecondScrollFinishedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 1);
        if (wheel != null) {
            wheel.setOnScrollFinished(function0);
        }
    }

    public final void setOnSecondScrollStartedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 1);
        if (wheel != null) {
            wheel.setOnScrollStarted(function0);
        }
    }

    public final void setOnSelection(@Nullable Function2<? super WheelData<?>, ? super WheelData<?>, Unit> function2) {
        b bVar = new b(this, function2);
        addOnSelected(bVar);
        addOnSecondWheelSelected(bVar);
    }

    public final void setOnThirdScrollFinishedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 2);
        if (wheel != null) {
            wheel.setOnScrollFinished(function0);
        }
    }

    public final void setOnThirdScrollStartedCallback(@Nullable Function0<Unit> function0) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 2);
        if (wheel != null) {
            wheel.setOnScrollStarted(function0);
        }
    }

    public final void setSecondWheelValue(@Nullable WheelData<?> wheelData) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 1);
        if (wheel != null) {
            wheel.setSelectedResult(wheelData);
        }
    }

    public final void setThirdWheelValue(@Nullable WheelData<?> wheelData) {
        Wheel wheel = (Wheel) CollectionsKt___CollectionsKt.getOrNull(this.a, 2);
        if (wheel != null) {
            wheel.setSelectedResult(wheelData);
        }
    }

    public final void setUpperLimit(@NotNull WheelData<?> wheelData, @NotNull WheelData<?> wheelData2, int i, int i2) {
        Intrinsics.checkNotNullParameter(wheelData, "limitInnerWheelData");
        Intrinsics.checkNotNullParameter(wheelData2, "limitOuterWheelData");
        List<WheelData<?>> items = this.a.get(i).getItems();
        List<WheelData<?>> items2 = this.a.get(i2).getItems();
        int indexOf = items.indexOf(wheelData);
        int indexOf2 = items2.indexOf(wheelData2);
        if (indexOf != items.size() - 1 || indexOf2 != items2.size() - 1) {
            setOnSelection(new d(this, indexOf2, items2, i2, wheelData2, indexOf, items, i, wheelData));
        }
    }

    public final void setValueForWheelByIndex(int i, @Nullable WheelData<?> wheelData) {
        if (i == 0) {
            setFirstWheelValue(wheelData);
        } else if (i == 1) {
            setSecondWheelValue(wheelData);
        } else if (i == 2) {
            setThirdWheelValue(wheelData);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Picker(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new ArrayList();
        this.e = 200;
        TypedValue typedValue = new TypedValue();
        ContextWrapper contextWrapper = new ContextWrapper(context);
        if (context.getTheme().resolveAttribute(R.attr.picker, typedValue, true)) {
            i3 = typedValue.resourceId;
        } else {
            i3 = R.style.Design_Widget_Picker;
        }
        contextWrapper.setTheme(i3);
        LayoutInflater.from(contextWrapper).inflate(R.layout.design_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.container)");
        this.b = (LinearLayout) findViewById;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Picker, i, i2);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Picker_picker_wheelLeftMargin, this.c);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Picker_picker_wheelRightMargin, this.d);
        obtainStyledAttributes.recycle();
    }

    public final <T> void setOnSelection(@Nullable Function3<? super WheelData<?>, ? super WheelData<?>, ? super WheelData<?>, Unit> function3) {
        c cVar = new c(this, function3);
        addOnSelected(cVar);
        addOnSecondWheelSelected(cVar);
        addOnThirdWheelSelected(cVar);
    }

    public final void addDivider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = this.b;
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.addView(view);
    }

    public final void addDivider(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        LinearLayout linearLayout = this.b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WheelImageDivider wheelImageDivider = new WheelImageDivider(context, drawable, 0, 4, null);
        wheelImageDivider.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.addView(wheelImageDivider);
    }

    public final void addDivider(@DrawableRes int i) {
        LinearLayout linearLayout = this.b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WheelImageDivider wheelImageDivider = new WheelImageDivider(context, null, i, 2, null);
        wheelImageDivider.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.addView(wheelImageDivider);
    }
}
