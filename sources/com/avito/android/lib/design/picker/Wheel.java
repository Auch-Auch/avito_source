package com.avito.android.lib.design.picker;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001mB)\u0012\u0006\u0010j\u001a\u00020i\u0012\u0006\u0010Q\u001a\u00020L\u0012\u0010\u0010d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020_¢\u0006\u0004\bk\u0010lJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ:\u0010\u0010\u001a\u00020\u00042+\u0010\u000f\u001a'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u0012\u001a\u00020\u00042+\u0010\u000f\u001a'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0002`\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0014R\u0016\u0010%\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00101R&\u00108\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107Rp\u0010=\u001a\\\u0012)\u0012'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0002`\u000e09j-\u0012)\u0012'\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0002`\u000e`:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u00101R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R\u0016\u0010D\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010$R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0019\u0010Q\u001a\u00020L8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u00101R(\u0010X\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b8\u0002@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010V\"\u0004\b\u0005\u0010WR\u0016\u0010Y\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u00101R\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010[R\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u00101R#\u0010d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020_8\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR0\u0010h\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\be\u0010f\"\u0004\bg\u0010\u0006¨\u0006n"}, d2 = {"Lcom/avito/android/lib/design/picker/Wheel;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/lib/design/picker/WheelData;", "value", "", "setCenterView", "(Lcom/avito/android/lib/design/picker/WheelData;)V", "", "getNewScroll", "()I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wheelData", "Lcom/avito/android/lib/design/picker/WheelSelectionCallback;", "wheelSelectionCallback", "addOnSelection", "(Lkotlin/jvm/functions/Function1;)V", "removeOnSelection", "clearOnSelection", "()V", "", "checkIfScrollFinished", "()Z", "f", "d", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "", "c", "(Landroid/view/View;)Ljava/lang/CharSequence;", "isFast", AuthSource.SEND_ABUSE, "(Z)V", "e", "p", "Z", "isStopped", "Lcom/avito/android/lib/design/picker/WheelAdapter;", "k", "Lcom/avito/android/lib/design/picker/WheelAdapter;", "adapter", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnScrollFinished", "()Lkotlin/jvm/functions/Function0;", "setOnScrollFinished", "(Lkotlin/jvm/functions/Function0;)V", "onScrollFinished", "I", "defaultWidth", "Ljava/util/HashSet;", "Lcom/avito/android/lib/design/picker/Wheel$ScrollPair;", "Lkotlin/collections/HashSet;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/HashSet;", "scrollValues", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "n", "Ljava/util/ArrayList;", "selectionCallbacks", g.a, "additionalScrollValue", "getOnScrollStarted", "setOnScrollStarted", "onScrollStarted", "j", "isScrollFinished", "", "i", "F", "additionalScrollTry", "o", "Lcom/avito/android/lib/design/picker/WheelData;", "selectedValue", "Lcom/avito/android/lib/design/picker/WheelStyle;", "r", "Lcom/avito/android/lib/design/picker/WheelStyle;", "getWheelStyle", "()Lcom/avito/android/lib/design/picker/WheelStyle;", "wheelStyle", VKApiConst.Q, "oldValue", "h", "additionalAbsoluteScrollValue", "Landroid/view/View;", "(Landroid/view/View;)V", "centerView", "defaultHeight", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "l", "currentScrollState", "", "s", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "getSelectedResult", "()Lcom/avito/android/lib/design/picker/WheelData;", "setSelectedResult", "selectedResult", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/lib/design/picker/WheelStyle;Ljava/util/List;)V", "ScrollPair", "components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ClickableViewAccessibility", "ViewConstructor"})
public final class Wheel extends FrameLayout {
    @Nullable
    public Function0<Unit> a;
    @Nullable
    public Function0<Unit> b;
    public View c;
    public final RecyclerView d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i = 1.0f;
    public boolean j;
    public WheelAdapter k;
    public int l;
    public HashSet<ScrollPair> m = new HashSet<>();
    public final ArrayList<Function1<WheelData<?>, Unit>> n = new ArrayList<>();
    public WheelData<?> o;
    public boolean p;
    public WheelData<?> q;
    @NotNull
    public final WheelStyle r;
    @NotNull
    public final List<WheelData<?>> s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/lib/design/picker/Wheel$ScrollPair;", "", "", "component1", "()I", "component2", "absolute", "scroll", "copy", "(II)Lcom/avito/android/lib/design/picker/Wheel$ScrollPair;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getScroll", AuthSource.SEND_ABUSE, "getAbsolute", "<init>", "(II)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ScrollPair {
        public final int a;
        public final int b;

        public ScrollPair(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ ScrollPair copy$default(ScrollPair scrollPair, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = scrollPair.a;
            }
            if ((i3 & 2) != 0) {
                i2 = scrollPair.b;
            }
            return scrollPair.copy(i, i2);
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final ScrollPair copy(int i, int i2) {
            return new ScrollPair(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScrollPair)) {
                return false;
            }
            ScrollPair scrollPair = (ScrollPair) obj;
            return this.a == scrollPair.a && this.b == scrollPair.b;
        }

        public final int getAbsolute() {
            return this.a;
        }

        public final int getScroll() {
            return this.b;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ScrollPair(absolute=");
            L.append(this.a);
            L.append(", scroll=");
            return a2.b.a.a.a.j(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WheelGravity.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            WheelGravity.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[0] = 2;
            iArr2[1] = 3;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ Wheel a;

        /* compiled from: java-style lambda group */
        /* renamed from: com.avito.android.lib.design.picker.Wheel$a$a  reason: collision with other inner class name */
        public static final class RunnableC0141a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ Object c;

            public RunnableC0141a(int i, Object obj, Object obj2) {
                this.a = i;
                this.b = obj;
                this.c = obj2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i = this.a;
                if (i == 0) {
                    ((a) this.c).a.setCenterView((WheelData) this.b);
                    Wheel.access$checkMiddlePositionOnly(((a) this.c).a);
                    ((a) this.c).a.a(true);
                } else if (i == 1) {
                    ((a) this.c).a.setCenterView((WheelData) this.b);
                    Wheel.access$checkMiddlePositionOnly(((a) this.c).a);
                    ((a) this.c).a.a(true);
                } else {
                    throw null;
                }
            }
        }

        public a(Wheel wheel) {
            this.a = wheel;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.getWheelStyle().isCycled()) {
                WheelData wheelData = this.a.o;
                if (wheelData != null) {
                    int itemCount = this.a.k.getItemCount() / 2;
                    this.a.d.scrollToPosition(this.a.getItems().indexOf(wheelData) + (itemCount - (itemCount % this.a.getItems().size())));
                    this.a.d.post(new RunnableC0141a(0, wheelData, this));
                }
            } else {
                WheelData wheelData2 = this.a.o;
                if (wheelData2 != null) {
                    this.a.d.scrollToPosition(this.a.getItems().indexOf(wheelData2) + 3);
                    this.a.d.post(new RunnableC0141a(1, wheelData2, this));
                }
            }
            this.a.p = false;
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ Wheel a;

        public b(Wheel wheel, Context context) {
            this.a = wheel;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
            if (motionEvent.getAction() != 1) {
                return false;
            }
            this.a.i = 1.0f;
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Wheel a;
        public final /* synthetic */ boolean b;

        public c(Wheel wheel, boolean z) {
            this.a = wheel;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Wheel.access$checkMiddlePositionOnly(this.a);
            this.a.a(this.b);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Wheel a;

        public d(Wheel wheel) {
            this.a = wheel;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.util.List<? extends com.avito.android.lib.design.picker.WheelData<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Wheel(@NotNull Context context, @NotNull WheelStyle wheelStyle, @NotNull List<? extends WheelData<?>> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wheelStyle, "wheelStyle");
        Intrinsics.checkNotNullParameter(list, "items");
        this.r = wheelStyle;
        this.s = list;
        LayoutInflater.from(context).inflate(R.layout.design_picker_wheel, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.recyclerWheel);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.d = recyclerView;
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int ordinal = wheelStyle.getTextPositon().ordinal();
        if (ordinal == 0) {
            Views.changeMargin$default(recyclerView, marginLayoutParams.leftMargin * 2, 0, 0, 0, 14, null);
        } else if (ordinal == 1) {
            Views.changeMargin$default(recyclerView, 0, 0, marginLayoutParams.rightMargin * 2, 0, 11, null);
        }
        WheelAdapter wheelAdapter = new WheelAdapter(list, wheelStyle);
        wheelAdapter.setCycled(wheelAdapter.getWheelStyle().isCycled());
        this.k = wheelAdapter;
        recyclerView.setAdapter(wheelAdapter);
        recyclerView.addItemDecoration(new MarginItemDecoration(0, 1, null));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(false);
        d();
        recyclerView.addOnScrollListener(new Wheel$$special$$inlined$apply$lambda$1(this, context));
        recyclerView.setOnTouchListener(new b(this, context));
        if (wheelStyle.isCycled()) {
            int itemCount = this.k.getItemCount() / 2;
            int size = itemCount - (itemCount % list.size());
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPosition(size);
            }
        }
        recyclerView.post(new a2.a.a.k1.a.f.d(this));
    }

    public static final void access$checkMiddlePositionOnly(Wheel wheel) {
        if (wheel.o == null) {
            wheel.b();
        } else {
            View view = wheel.c;
            View view2 = null;
            if (view != null) {
                Intrinsics.checkNotNull(view);
                CharSequence c2 = wheel.c(view);
                WheelData<?> wheelData = wheel.o;
                Intrinsics.checkNotNull(wheelData);
                if (!Intrinsics.areEqual(c2, wheelData.getName())) {
                    wheel.setCenterView((View) null);
                }
            }
            if (wheel.c == null && wheel.l == 0) {
                RecyclerView.LayoutManager layoutManager = wheel.d.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager);
                Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager!!");
                int itemCount = layoutManager.getItemCount();
                for (int i2 = 0; i2 < itemCount; i2++) {
                    View childAt = wheel.d.getChildAt(i2);
                    if (childAt != null) {
                        CharSequence c3 = wheel.c(childAt);
                        WheelData<?> wheelData2 = wheel.o;
                        Intrinsics.checkNotNull(wheelData2);
                        if (Intrinsics.areEqual(c3, wheelData2.getName())) {
                            view2 = childAt;
                        }
                    }
                }
                wheel.setCenterView(view2);
            }
        }
        float height = (((float) wheel.getHeight()) / 2.0f) + ((float) ViewSizeKt.getDp(4));
        View view3 = wheel.c;
        if (view3 != null) {
            float top = (((float) (view3.getTop() + view3.getBottom())) / 2.0f) - height;
            wheel.g = t6.s.c.roundToInt(top / wheel.i);
            int roundToInt = t6.s.c.roundToInt(top);
            wheel.h = roundToInt;
            if (wheel.g == 0) {
                wheel.g = (int) Math.signum((float) roundToInt);
            }
        }
    }

    private final int getNewScroll() {
        int signum = (int) Math.signum((float) this.h);
        for (int i2 = 1; i2 <= 5; i2++) {
            ScrollPair scrollPair = new ScrollPair(this.h, i2 * signum);
            if (!this.m.contains(scrollPair)) {
                this.m.add(scrollPair);
                return scrollPair.getScroll();
            }
        }
        return signum * -3;
    }

    /* access modifiers changed from: private */
    public final void setCenterView(View view) {
        WheelData<?> selectedResult;
        this.c = view;
        if (!(view == null || (selectedResult = getSelectedResult()) == null)) {
            Object[] array = this.n.toArray(new Function1[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (Object obj : array) {
                Function1 function1 = (Function1) obj;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(selectedResult);
                }
            }
        }
    }

    public final void a(boolean z) {
        T t;
        int i2 = 1;
        if (Math.abs(this.h) > 1) {
            this.j = false;
            if (Math.abs(this.g) % 2 == 1) {
                int i3 = this.g;
                if (i3 <= 0) {
                    i2 = -1;
                }
                this.g = i3 + i2;
            }
            int i4 = this.g / 2;
            this.g = i4;
            ScrollPair scrollPair = new ScrollPair(this.h, i4);
            if (this.m.contains(scrollPair)) {
                if (this.o != null) {
                    e();
                    return;
                }
                this.g = getNewScroll();
            }
            this.m.add(scrollPair);
            if (z) {
                this.d.scrollBy(0, this.g);
            } else {
                this.d.smoothScrollBy(0, this.g);
            }
            if (z) {
                this.d.post(new c(this, z));
            }
        } else if (this.o == null) {
            this.j = true;
            Iterator<T> it = this.s.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                String name = t.getName();
                View view = this.c;
                if (Intrinsics.areEqual(name, view != null ? c(view) : null)) {
                    break;
                }
            }
            this.q = t;
            Function0<Unit> function0 = this.a;
            if (function0 != null) {
                function0.invoke();
            }
            this.o = null;
            this.m.clear();
        } else {
            e();
        }
    }

    public final void addOnSelection(@Nullable Function1<? super WheelData<?>, Unit> function1) {
        this.n.add(function1);
    }

    public final void b() {
        if (this.c == null && this.l == 0) {
            RecyclerView.LayoutManager layoutManager = this.d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager!!");
            int itemCount = layoutManager.getItemCount();
            float height = (((float) getHeight()) / 2.0f) + ((float) ViewSizeKt.getDp(4));
            int i2 = Integer.MAX_VALUE;
            View view = null;
            for (int i3 = 0; i3 < itemCount; i3++) {
                View childAt = this.d.getChildAt(i3);
                if (childAt != null) {
                    int abs = (int) Math.abs(height - (((float) (childAt.getTop() + childAt.getBottom())) / 2.0f));
                    i2 = Math.min(abs, i2);
                    if (i2 == abs) {
                        view = childAt;
                    }
                }
            }
            setCenterView(view);
        }
    }

    public final CharSequence c(View view) {
        View findViewById = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.text)");
        return ((TextView) findViewById).getText();
    }

    public final boolean checkIfScrollFinished() {
        return this.j;
    }

    public final void clearOnSelection() {
        this.n.clear();
    }

    public final void d() {
        float f2;
        RecyclerView.LayoutManager layoutManager = this.d.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager);
        Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager!!");
        int itemCount = layoutManager.getItemCount();
        float height = (((float) getHeight()) / 2.0f) + ((float) ViewSizeKt.getDp(4));
        int dp = ViewSizeKt.getDp(26);
        for (int i2 = 0; i2 < itemCount; i2++) {
            View childAt = this.d.getChildAt(i2);
            if (childAt != null) {
                float top = ((float) (childAt.getTop() + childAt.getBottom())) / 2.0f;
                int i3 = this.e;
                if (i3 == 0) {
                    i3 = childAt.getMeasuredHeight();
                }
                this.e = i3;
                int i4 = this.f;
                if (i4 == 0) {
                    i4 = childAt.getMeasuredWidth();
                }
                this.f = i4;
                float abs = Math.abs(height - top);
                float f3 = (float) 1;
                float f4 = abs / height;
                float f5 = f3 - (0.5f * f4);
                float f6 = f3 - f4;
                int roundToInt = t6.s.c.roundToInt(((float) this.e) * f5);
                float f7 = (float) dp;
                if (abs < f7) {
                    roundToInt += t6.s.c.roundToInt((f3 - (abs / f7)) * f7);
                }
                childAt.getLayoutParams().height = roundToInt;
                TextView textView = (TextView) childAt.findViewById(R.id.text);
                int ordinal = this.r.getTextPositon().ordinal();
                if (ordinal == 0) {
                    f2 = 0.0f;
                } else if (ordinal == 1) {
                    f2 = (float) textView.getMeasuredWidth();
                } else if (ordinal == 2) {
                    f2 = ((float) textView.getMeasuredWidth()) / 2.0f;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                textView.setPivotX(f2);
                textView.setPivotY(((float) textView.getMeasuredHeight()) / 2.0f);
                textView.setScaleX(f5);
                textView.setScaleY(f5);
                textView.setAlpha(f6);
                childAt.requestLayout();
            }
        }
    }

    public final void e() {
        b();
        View view = this.c;
        if (view != null) {
            if (this.o != null) {
                Intrinsics.checkNotNull(view);
                CharSequence c2 = c(view);
                WheelData<?> wheelData = this.o;
                Intrinsics.checkNotNull(wheelData);
                if (!(!Intrinsics.areEqual(c2, wheelData.getName()))) {
                    return;
                }
            } else {
                return;
            }
        }
        this.d.post(new d(this));
    }

    public final void f() {
        if (this.o != null) {
            this.m.clear();
            this.p = true;
            this.d.stopScroll();
            post(new a(this));
        }
    }

    @NotNull
    public final List<WheelData<?>> getItems() {
        return this.s;
    }

    @Nullable
    public final Function0<Unit> getOnScrollFinished() {
        return this.a;
    }

    @Nullable
    public final Function0<Unit> getOnScrollStarted() {
        return this.b;
    }

    @Nullable
    public final WheelData<?> getSelectedResult() {
        CharSequence charSequence;
        Iterator<T> it = this.s.iterator();
        while (true) {
            charSequence = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            String name = next.getName();
            View view = this.c;
            if (view != null) {
                charSequence = c(view);
            }
            if (Intrinsics.areEqual(name, charSequence)) {
                charSequence = next;
                break;
            }
        }
        WheelData<?> wheelData = (WheelData) charSequence;
        return wheelData != null ? wheelData : this.q;
    }

    @NotNull
    public final WheelStyle getWheelStyle() {
        return this.r;
    }

    public final void removeOnSelection(@Nullable Function1<? super WheelData<?>, Unit> function1) {
        this.n.remove(function1);
    }

    public final void setOnScrollFinished(@Nullable Function0<Unit> function0) {
        this.a = function0;
    }

    public final void setOnScrollStarted(@Nullable Function0<Unit> function0) {
        this.b = function0;
    }

    public final void setSelectedResult(@Nullable WheelData<?> wheelData) {
        this.o = wheelData;
        f();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setCenterView(WheelData<?> wheelData) {
        RecyclerView.LayoutManager layoutManager = this.d.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager);
        Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager!!");
        int itemCount = layoutManager.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            View childAt = this.d.getChildAt(i2);
            if (childAt != null && Intrinsics.areEqual(c(childAt), wheelData.getName())) {
                setCenterView(childAt);
            }
        }
    }
}
