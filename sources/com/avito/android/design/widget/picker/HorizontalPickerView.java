package com.avito.android.design.widget.picker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.picker.PickerView;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002KLB\u0011\b\u0016\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EB\u001b\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010F¢\u0006\u0004\bD\u0010HB#\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010I\u001a\u00020\u0007¢\u0006\u0004\bD\u0010JJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\r\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00128\u0006@BX\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R3\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010-R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010%R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010-¨\u0006M"}, d2 = {"Lcom/avito/android/design/widget/picker/HorizontalPickerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/avito/android/design/widget/picker/PickerView;", "Landroid/view/View;", "getCenterView", "()Landroid/view/View;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", VKApiConst.POSITION, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lkotlin/jvm/functions/Function1;)V", "", "", ResidentialComplexModuleKt.VALUES, "", "allowEmpty", "setValues", "(Ljava/util/List;Z)V", "smoothScroll", "scrollToValue", "(IZ)V", "setHighlightedPosition", "(Ljava/lang/Integer;)V", "b0", "()V", "c0", "(I)V", "Landroid/content/res/ColorStateList;", "N0", "Landroid/content/res/ColorStateList;", "regularColor", "Ljava/util/ArrayList;", "I0", "Ljava/util/ArrayList;", "widths", "<set-?>", "E0", "Z", "getAllowEmpty", "()Z", "K0", "I", "scroll", "Landroid/graphics/Paint;", "F0", "Landroid/graphics/Paint;", "paint", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "L0", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollListener", "J0", "Lkotlin/jvm/functions/Function1;", "M0", "Ljava/lang/Integer;", "highlightedPosition", "O0", "highlightColor", "H0", "texts", "G0", "sizePadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class HorizontalPickerView extends RecyclerView implements PickerView {
    public boolean E0;
    public final Paint F0;
    public final int G0;
    public final ArrayList<String> H0;
    public final ArrayList<Integer> I0 = new ArrayList<>();
    public Function1<? super Integer, Unit> J0;
    public int K0;
    public RecyclerView.OnScrollListener L0;
    public Integer M0;
    public final ColorStateList N0;
    public final int O0;

    public static final class a extends RecyclerView.Adapter<b> {
        public final List<String> c;
        public final Function1<Integer, Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull List<String> list, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(list, "texts");
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.c = list;
            this.d = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(b bVar, int i) {
            b bVar2 = bVar;
            Intrinsics.checkNotNullParameter(bVar2, "holder");
            bVar2.s.setText(this.c.get(i));
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_picker, viewGroup, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            b bVar = new b(textView);
            textView.setOnClickListener(new a2.a.a.l0.a.a.c(this, bVar));
            return bVar;
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        @NotNull
        public final TextView s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull TextView textView) {
            super(textView);
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.s = textView;
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ HorizontalPickerView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HorizontalPickerView horizontalPickerView) {
            super(1);
            this.a = horizontalPickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            PickerView.DefaultImpls.scrollToValue$default(this.a, num.intValue(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ HorizontalPickerView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        public d(HorizontalPickerView horizontalPickerView, int i, boolean z) {
            this.a = horizontalPickerView;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int paddingLeft = (this.a.getPaddingLeft() - (this.a.getWidth() / 2)) - this.a.K0;
            int i2 = this.b;
            if (i2 >= 0) {
                int i3 = 0;
                while (true) {
                    if (i3 == this.b) {
                        i = ((Number) this.a.I0.get(i3)).intValue() / 2;
                    } else {
                        Object obj = this.a.I0.get(i3);
                        Intrinsics.checkNotNullExpressionValue(obj, "widths[index]");
                        i = ((Number) obj).intValue();
                    }
                    paddingLeft += i;
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            if (paddingLeft != 0) {
                if (this.c) {
                    this.a.smoothScrollBy(paddingLeft, 0);
                    return;
                }
                RecyclerView.OnScrollListener onScrollListener = this.a.L0;
                if (onScrollListener != null) {
                    this.a.removeOnScrollListener(onScrollListener);
                }
                this.a.scrollBy(paddingLeft, 0);
                View access$getViewForPosition = HorizontalPickerView.access$getViewForPosition(this.a, this.b);
                if (access$getViewForPosition != null) {
                    int width = ((access$getViewForPosition.getWidth() - this.a.getWidth()) / 2) + access$getViewForPosition.getLeft();
                    this.a.scrollBy(width, 0);
                    HorizontalPickerView horizontalPickerView = this.a;
                    horizontalPickerView.K0 = paddingLeft + width + horizontalPickerView.K0;
                    RecyclerView.OnScrollListener onScrollListener2 = this.a.L0;
                    if (onScrollListener2 != null) {
                        this.a.addOnScrollListener(onScrollListener2);
                    }
                    this.a.c0(this.b);
                    Function1 function1 = this.a.J0;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke(Integer.valueOf(this.b));
                    }
                }
            }
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ HorizontalPickerView a;

        public e(HorizontalPickerView horizontalPickerView) {
            this.a = horizontalPickerView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.OnScrollListener onScrollListener = this.a.L0;
            if (onScrollListener != null) {
                this.a.removeOnScrollListener(onScrollListener);
            }
            HorizontalPickerView horizontalPickerView = this.a;
            horizontalPickerView.setPadding((horizontalPickerView.getWidth() - ((Number) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.a.I0)).intValue()) / 2, 0, (this.a.getWidth() - ((Number) CollectionsKt___CollectionsKt.last((List<? extends Object>) this.a.I0)).intValue()) / 2, 0);
            HorizontalPickerView.d0(this.a, 0, 1);
            this.a.scrollBy(-this.a.computeHorizontalScrollOffset(), 0);
            this.a.K0 = 0;
            RecyclerView.OnScrollListener onScrollListener2 = this.a.L0;
            if (onScrollListener2 != null) {
                this.a.addOnScrollListener(onScrollListener2);
            }
            HorizontalPickerView.d0(this.a, 0, 1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalPickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        this.H0 = arrayList;
        setClipToPadding(false);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.horizontal_picker_padding);
        this.G0 = dimensionPixelSize;
        float dimension = getResources().getDimension(R.dimen.horizontal_picker_text);
        setMinimumHeight((int) Math.max(getResources().getDimension(R.dimen.horizontal_picker_size), ((float) dimensionPixelSize) + dimension + ((float) dimensionPixelSize)));
        Paint paint = new Paint();
        this.F0 = paint;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.O0 = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.red);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context3, R.color.txt_horizontal_picker);
        Intrinsics.checkNotNull(colorStateListCompat);
        this.N0 = colorStateListCompat;
        paint.setTextSize(dimension);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        Typeface typeface = Typefaces.getTypeface(context4, TypefaceType.Regular);
        paint.setTypeface(!(typeface instanceof Typeface) ? null : typeface);
        setAdapter(new a(arrayList, new c(this)));
        b0();
    }

    public static final View access$getViewForPosition(HorizontalPickerView horizontalPickerView, int i) {
        int childCount = horizontalPickerView.getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = horizontalPickerView.getChildAt(i2);
                if (i != horizontalPickerView.getChildAdapterPosition(childAt)) {
                    if (i2 == childCount) {
                        break;
                    }
                    i2++;
                } else {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void d0(HorizontalPickerView horizontalPickerView, int i, int i2) {
        if ((i2 & 1) != 0) {
            View centerView = horizontalPickerView.getCenterView();
            i = centerView != null ? horizontalPickerView.getChildAdapterPosition(centerView) : -1;
        }
        horizontalPickerView.c0(i);
    }

    /* access modifiers changed from: private */
    public final View getCenterView() {
        int width = getWidth() / 2;
        int childCount = getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
            if (childAt.getLeft() <= width && childAt.getRight() >= width) {
                return childAt;
            }
            if (i == childCount) {
                return null;
            }
            i++;
        }
    }

    public final void b0() {
        this.L0 = new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.design.widget.picker.HorizontalPickerView$initScrollListener$1
            public final /* synthetic */ HorizontalPickerView a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                View view;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0 && (view = this.a.getCenterView()) != null) {
                    this.a.smoothScrollBy(((view.getWidth() - this.a.getWidth()) / 2) + view.getLeft(), 0);
                    int childAdapterPosition = this.a.getChildAdapterPosition(view);
                    Function1 function1 = this.a.J0;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke(Integer.valueOf(childAdapterPosition));
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.a.K0 += i;
                HorizontalPickerView.d0(this.a, 0, 1);
            }
        };
    }

    public final void c0(int i) {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = getChildAt(i2);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) childAt;
                int childAdapterPosition = getChildAdapterPosition(textView);
                Integer num = this.M0;
                if (num != null && childAdapterPosition == num.intValue()) {
                    textView.setTextColor(this.O0);
                } else {
                    textView.setTextColor(this.N0);
                }
                if (childAdapterPosition == 0 && this.E0) {
                    textView.setEnabled(false);
                    textView.setSelected(false);
                } else if (i == childAdapterPosition) {
                    textView.setEnabled(true);
                    textView.setSelected(true);
                } else {
                    textView.setEnabled(true);
                    textView.setSelected(false);
                }
                if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean getAllowEmpty() {
        return this.E0;
    }

    @Override // com.avito.android.design.widget.picker.PickerView
    public void scrollToValue(int i, boolean z) {
        post(new d(this, i, z));
    }

    @Override // com.avito.android.design.widget.picker.PickerView
    public void setHighlightedPosition(@Nullable Integer num) {
        this.M0 = num;
        d0(this, 0, 1);
    }

    @Override // com.avito.android.design.widget.picker.PickerView
    public void setListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.J0 = function1;
    }

    @Override // com.avito.android.design.widget.picker.PickerView
    public void setValues(@NotNull List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        this.E0 = z;
        this.H0.clear();
        this.I0.clear();
        if (!list.isEmpty()) {
            this.H0.addAll(list);
            Iterator<String> it = this.H0.iterator();
            while (it.hasNext()) {
                Paint paint = this.F0;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.horizontal_picker_size);
                int i = this.G0;
                this.I0.add(Integer.valueOf(Math.max(dimensionPixelSize, ((int) paint.measureText(it.next())) + i + i)));
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            post(new e(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalPickerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        this.H0 = arrayList;
        setClipToPadding(false);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.horizontal_picker_padding);
        this.G0 = dimensionPixelSize;
        float dimension = getResources().getDimension(R.dimen.horizontal_picker_text);
        setMinimumHeight((int) Math.max(getResources().getDimension(R.dimen.horizontal_picker_size), ((float) dimensionPixelSize) + dimension + ((float) dimensionPixelSize)));
        Paint paint = new Paint();
        this.F0 = paint;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.O0 = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.red);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context3, R.color.txt_horizontal_picker);
        Intrinsics.checkNotNull(colorStateListCompat);
        this.N0 = colorStateListCompat;
        paint.setTextSize(dimension);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        Typeface typeface = Typefaces.getTypeface(context4, TypefaceType.Regular);
        paint.setTypeface(!(typeface instanceof Typeface) ? null : typeface);
        setAdapter(new a(arrayList, new c(this)));
        b0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalPickerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        this.H0 = arrayList;
        setClipToPadding(false);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.horizontal_picker_padding);
        this.G0 = dimensionPixelSize;
        float dimension = getResources().getDimension(R.dimen.horizontal_picker_text);
        setMinimumHeight((int) Math.max(getResources().getDimension(R.dimen.horizontal_picker_size), ((float) dimensionPixelSize) + dimension + ((float) dimensionPixelSize)));
        Paint paint = new Paint();
        this.F0 = paint;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.O0 = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.red);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context3, R.color.txt_horizontal_picker);
        Intrinsics.checkNotNull(colorStateListCompat);
        this.N0 = colorStateListCompat;
        paint.setTextSize(dimension);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        Typeface typeface = Typefaces.getTypeface(context4, TypefaceType.Regular);
        paint.setTypeface(!(typeface instanceof Typeface) ? null : typeface);
        setAdapter(new a(arrayList, new c(this)));
        b0();
    }
}
