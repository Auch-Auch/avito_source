package com.avito.android.short_term_rent.hotels.dialogs.guests;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.Adults;
import com.avito.android.remote.model.hotels.Age;
import com.avito.android.remote.model.hotels.Children;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.hotels.data.BookingPeople;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010C\u001a\u00020>\u0012\u0006\u0010F\u001a\u00020\n\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010a\u001a\u00020^¢\u0006\u0004\bb\u0010cJ\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J2\u0010\u000f\u001a\u00020\u00032!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001bR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001bR\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010@R\u0016\u0010I\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010\u001bR\u0016\u0010K\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u001bR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010$R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/guests/HotelsGuestsDialogViewImpl;", "Lcom/avito/android/short_term_rent/hotels/dialogs/guests/HotelsGuestsView;", "Lkotlin/Function0;", "", "resetAction", "setResetAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "setCloseAction", "Lkotlin/Function1;", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "Lkotlin/ParameterName;", "name", "result", "applyAction", "setApplyAction", "(Lkotlin/jvm/functions/Function1;)V", "d", "()V", "c", "Lcom/avito/android/remote/model/hotels/Age;", "age", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/hotels/Age;)V", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "adultsSubtitle", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "applyButton", "title", "Landroid/graphics/drawable/Drawable;", "r", "Landroid/graphics/drawable/Drawable;", "clearIcon", "p", "closeIcon", "k", "adultsIncrease", "l", "adultsDecrease", "Lcom/avito/android/remote/model/hotels/Adults;", "w", "Lcom/avito/android/remote/model/hotels/Adults;", "adults", "h", "adultsTitle", "Lcom/avito/android/lib/design/picker/Picker;", g.a, "Lcom/avito/android/lib/design/picker/Picker;", "picker", "Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", "state", "resetButton", "Landroid/view/View;", "f", "Landroid/view/View;", "container", "u", "rootView", VKApiConst.VERSION, "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "selectedValue", "closeButton", "n", "childrenIncrease", "j", "adultsValue", "", "o", "Ljava/lang/String;", "childText", "Landroid/widget/LinearLayout;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/LinearLayout;", "childrenContainer", VKApiConst.Q, "backIcon", "Landroid/view/LayoutInflater;", "t", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/short_term_rent/hotels/dialogs/guests/GuestsViewState;", "s", "Lcom/avito/android/short_term_rent/hotels/dialogs/guests/GuestsViewState;", "viewState", "Lcom/avito/android/remote/model/hotels/Children;", "x", "Lcom/avito/android/remote/model/hotels/Children;", "children", "<init>", "(Landroid/view/View;Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;Lcom/avito/android/remote/model/hotels/Adults;Lcom/avito/android/remote/model/hotels/Children;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsGuestsDialogViewImpl implements HotelsGuestsView {
    @Nullable
    public Parcelable a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final Button e;
    public final View f;
    public final Picker g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final LinearLayout m;
    public final TextView n;
    public final String o;
    public final Drawable p;
    public final Drawable q;
    public final Drawable r;
    public GuestsViewState s;
    public final LayoutInflater t;
    public final View u;
    public final BookingPeople v;
    public final Adults w;
    public final Children x;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GuestsViewState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            GuestsViewState.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            GuestsViewState.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                HotelsGuestsDialogViewImpl.access$increaseAdults((HotelsGuestsDialogViewImpl) this.b);
            } else if (i == 1) {
                HotelsGuestsDialogViewImpl.access$decreaseAdults((HotelsGuestsDialogViewImpl) this.b);
            } else if (i == 2) {
                HotelsGuestsDialogViewImpl.access$showChildrenAgePicker((HotelsGuestsDialogViewImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ HotelsGuestsDialogViewImpl a;
        public final /* synthetic */ ListItem b;
        public final /* synthetic */ Age c;

        public b(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl, ListItem listItem, Age age) {
            this.a = hotelsGuestsDialogViewImpl;
            this.b = listItem;
            this.c = age;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.m.removeView(this.b);
            this.a.v.getChildren().remove(this.c);
            this.a.b();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ HotelsGuestsDialogViewImpl a;
        public final /* synthetic */ Function1 b;

        public c(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl, Function1 function1) {
            this.a = hotelsGuestsDialogViewImpl;
            this.b = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int ordinal = this.a.s.ordinal();
            if (ordinal == 0) {
                this.b.invoke(this.a.v);
            } else if (ordinal == 1) {
                HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl = this.a;
                hotelsGuestsDialogViewImpl.a(HotelsGuestsDialogViewImpl.access$getPickerValue(hotelsGuestsDialogViewImpl));
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ HotelsGuestsDialogViewImpl a;
        public final /* synthetic */ Function0 b;

        public d(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl, Function0 function0) {
            this.a = hotelsGuestsDialogViewImpl;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int ordinal = this.a.s.ordinal();
            if (ordinal == 0) {
                this.b.invoke();
            } else if (ordinal == 1) {
                HotelsGuestsDialogViewImpl.access$hideChildAgePicker(this.a);
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public e(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public HotelsGuestsDialogViewImpl(@NotNull View view, @NotNull BookingPeople bookingPeople, @NotNull Adults adults, @NotNull Children children) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(bookingPeople, "selectedValue");
        Intrinsics.checkNotNullParameter(adults, "adults");
        Intrinsics.checkNotNullParameter(children, "children");
        this.u = view;
        this.v = bookingPeople;
        this.w = adults;
        this.x = children;
        View findViewById = view.findViewById(R.id.hotels_filter_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…tels_filter_dialog_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.hotels_filter_reset_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.hotels_filter_close_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(R.id.hotels_filter_dialog_apply_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.e = (Button) findViewById4;
        View findViewById5 = view.findViewById(R.id.hotels_guests_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = view.findViewById(R.id.hotels_guests_children_picker);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.picker.Picker");
        Picker picker = (Picker) findViewById6;
        this.g = picker;
        View findViewById7 = view.findViewById(R.id.hotels_guests_adults_title);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById7;
        this.h = textView;
        View findViewById8 = view.findViewById(R.id.hotels_guests_adults_subtitle);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById8;
        this.i = textView2;
        View findViewById9 = view.findViewById(R.id.hotels_guests_adults_value);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.hotels_guests_adults_increase);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById10;
        this.k = textView3;
        View findViewById11 = view.findViewById(R.id.hotels_guests_adults_decrease);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) findViewById11;
        this.l = textView4;
        View findViewById12 = view.findViewById(R.id.hotels_guests_children_container);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.m = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.hotels_guests_children_increase);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.…guests_children_increase)");
        TextView textView5 = (TextView) findViewById13;
        this.n = textView5;
        String string = view.getResources().getString(R.string.hotels_guests_dialog_child_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.resources.getSt…ests_dialog_child_prefix)");
        this.o = string;
        this.p = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_close_24_black);
        this.q = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_back_24_black);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.ic_close_24);
        if (drawable != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            drawable.setTint(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        } else {
            drawable = null;
        }
        this.r = drawable;
        this.s = GuestsViewState.GUESTS_LIST;
        Object systemService = view.getContext().getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.t = (LayoutInflater) systemService;
        textView.setText(adults.getTitle());
        textView2.setText(adults.getSubtitle());
        textView3.setOnClickListener(new a(0, this));
        textView4.setOnClickListener(new a(1, this));
        textView5.setText(children.getAddButtonTitle());
        textView5.setOnClickListener(new a(2, this));
        picker.addWheel(HotelsGuestsDialogViewImplKt.access$toWheelData(children.getAges()), new WheelStyle(null, false, -1, 1, null));
        c();
        ArrayList arrayList = new ArrayList(bookingPeople.getChildren());
        bookingPeople.getChildren().clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Age age = (Age) it.next();
            Intrinsics.checkNotNullExpressionValue(age, "age");
            a(age);
        }
        d();
    }

    public static final void access$decreaseAdults(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl) {
        BookingPeople bookingPeople = hotelsGuestsDialogViewImpl.v;
        bookingPeople.setAdults(bookingPeople.getAdults() - 1);
        hotelsGuestsDialogViewImpl.c();
    }

    public static final Age access$getPickerValue(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl) {
        if (hotelsGuestsDialogViewImpl.g.getFirstWheelValue() == null) {
            return new Age(hotelsGuestsDialogViewImpl.x.getPreselected().getText(), hotelsGuestsDialogViewImpl.x.getPreselected().getValue());
        }
        WheelData<?> firstWheelValue = hotelsGuestsDialogViewImpl.g.getFirstWheelValue();
        Intrinsics.checkNotNull(firstWheelValue);
        String name = firstWheelValue.getName();
        WheelData<?> firstWheelValue2 = hotelsGuestsDialogViewImpl.g.getFirstWheelValue();
        Intrinsics.checkNotNull(firstWheelValue2);
        Object key = firstWheelValue2.getKey();
        Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
        return new Age(name, ((Integer) key).intValue());
    }

    public static final void access$hideChildAgePicker(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl) {
        Views.show(hotelsGuestsDialogViewImpl.f);
        Views.hide(hotelsGuestsDialogViewImpl.g);
        hotelsGuestsDialogViewImpl.s = GuestsViewState.GUESTS_LIST;
        hotelsGuestsDialogViewImpl.d();
    }

    public static final void access$increaseAdults(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl) {
        BookingPeople bookingPeople = hotelsGuestsDialogViewImpl.v;
        bookingPeople.setAdults(bookingPeople.getAdults() + 1);
        hotelsGuestsDialogViewImpl.c();
    }

    public static final void access$showChildrenAgePicker(HotelsGuestsDialogViewImpl hotelsGuestsDialogViewImpl) {
        Views.hide(hotelsGuestsDialogViewImpl.f);
        Views.show(hotelsGuestsDialogViewImpl.g);
        Picker picker = hotelsGuestsDialogViewImpl.g;
        picker.setFirstWheelValue(picker.getWheelData(0, hotelsGuestsDialogViewImpl.x.getPreselected().getText()));
        hotelsGuestsDialogViewImpl.s = GuestsViewState.PICKER;
        hotelsGuestsDialogViewImpl.d();
    }

    public final void a(Age age) {
        View inflate = this.t.inflate(R.layout.hotels_guests_dialog_child_item, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.ListItem");
        ListItem listItem = (ListItem) inflate;
        String format = String.format(this.o, Arrays.copyOf(new Object[]{age.getText()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        listItem.setTitle(format);
        listItem.setImageDrawable(null, this.r);
        this.m.addView(listItem);
        this.v.getChildren().add(age);
        listItem.setRighIconClickedListener(new b(this, listItem, age));
        b();
        Views.show(this.f);
        Views.hide(this.g);
        this.s = GuestsViewState.GUESTS_LIST;
        d();
    }

    public final void b() {
        if (this.v.getChildren().size() == this.x.getMax()) {
            Views.hide(this.n);
        } else {
            Views.show(this.n);
        }
    }

    public final void c() {
        this.j.setText(String.valueOf(this.v.getAdults()));
        boolean z = true;
        this.l.setEnabled(this.v.getAdults() != this.w.getMin());
        TextView textView = this.k;
        if (this.v.getAdults() == this.w.getMax()) {
            z = false;
        }
        textView.setEnabled(z);
    }

    public final void d() {
        int ordinal = this.s.ordinal();
        if (ordinal == 0) {
            this.d.setBackground(this.p);
            this.b.setText(this.u.getResources().getString(R.string.hotels_guests_dialog_common_title));
            Button button = this.e;
            String string = this.u.getResources().getString(R.string.hotels_dialog_apply_button);
            Intrinsics.checkNotNullExpressionValue(string, "rootView.resources.getSt…tels_dialog_apply_button)");
            button.setText(string);
            Views.show(this.c);
        } else if (ordinal == 1) {
            this.d.setBackground(this.q);
            this.b.setText(this.u.getResources().getString(R.string.hotels_guests_dialog_picker_title));
            Button button2 = this.e;
            String string2 = this.u.getResources().getString(R.string.hotels_guests_dialog_picker_apply_button);
            Intrinsics.checkNotNullExpressionValue(string2, "rootView.resources.getSt…alog_picker_apply_button)");
            button2.setText(string2);
            Views.hide(this.c);
        }
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    @Nullable
    public Parcelable getState() {
        return this.a;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.guests.HotelsGuestsView
    public void setApplyAction(@NotNull Function1<? super BookingPeople, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "applyAction");
        this.e.setOnClickListener(new c(this, function1));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setCloseAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        this.d.setOnClickListener(new d(this, function0));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setResetAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "resetAction");
        this.c.setOnClickListener(new e(function0));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView
    public void setState(@Nullable Parcelable parcelable) {
        this.a = parcelable;
    }
}
