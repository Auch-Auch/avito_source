package com.avito.android.inline_filters.dialog.range;

import a2.g.r.g;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.MaskParameters;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleTextWatcher;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001lBC\u0012\u0006\u0010Y\u001a\u00020@\u0012\u0006\u0010W\u001a\u00020\u000b\u0012\u0006\u0010U\u001a\u00020\u000b\u0012\b\u0010N\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010E\u001a\u00020\u000b\u0012\u0006\u0010S\u001a\u00020\u001b\u0012\b\u0010i\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bj\u0010kJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\"\u0010\u001eJ\u001d\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0016¢\u0006\u0004\b(\u0010&J)\u0010,\u001a\u00020\u00042\u0018\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0*\u0012\u0004\u0012\u00020\u00040)H\u0016¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u0010\u0006J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b7\u0010\u0018J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b8\u0010\u001eJ\u001d\u0010;\u001a\u00020\u00042\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090*H\u0016¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u0002090=H\u0016¢\u0006\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010AR\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR(\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0*\u0012\u0004\u0012\u00020\u00040)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010IR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010DR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010GR\u0016\u0010S\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010DR\u0016\u0010W\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010DR\u0016\u0010Y\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010AR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010[R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010[R.\u0010_\u001a\u0004\u0018\u00010^2\b\u0010\n\u001a\u0004\u0018\u00010^8V@VX\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010AR\u0016\u0010h\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010K¨\u0006m"}, d2 = {"Lcom/avito/android/inline_filters/dialog/range/RangeFilterView;", "Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "", "padding", "", AuthSource.BOOKING_ORDER, "(I)V", "Lcom/avito/android/lib/design/input/Input;", "input", "", "value", "", InternalConstsKt.PLACEHOLDER, "c", "(Lcom/avito/android/lib/design/input/Input;Ljava/lang/Long;Ljava/lang/String;)V", "formatting", "Lcom/avito/android/lib/design/input/FormatterType;", "formatter", "d", "(Lcom/avito/android/lib/design/input/Input;Ljava/lang/String;Lcom/avito/android/lib/design/input/FormatterType;)V", AuthSource.SEND_ABUSE, "(Lcom/avito/android/lib/design/input/Input;)Ljava/lang/Long;", "titleText", "setTitle", "(Ljava/lang/String;)V", "resetActionHint", "setResetActionHint", "", "visible", "setResetActionVisibility", "(Z)V", "enabled", "setBackButtonEnabled", "clickable", "setResetActionClickable", "Lkotlin/Function0;", "resetAction", "setResetAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "setCloseAction", "Lkotlin/Function1;", "", "applyAction", "setApplyAction", "(Lkotlin/jvm/functions/Function1;)V", "fromValue", "toValue", "setInputValues", "(Ljava/lang/Long;Ljava/lang/Long;)V", "showKeyboard", "()V", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setSearchInputVisibility", "text", "setApplyBtnText", "setApplyBtnVisible", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "items", "setItemsView", "(Ljava/util/List;)V", "Lio/reactivex/Observable;", "selectAction", "()Lio/reactivex/Observable;", "Landroid/view/View;", "Landroid/view/View;", "closeButton", "n", "Ljava/lang/String;", "toFormatting", g.a, "I", "gray28Color", "Lkotlin/jvm/functions/Function1;", "i", "Lcom/avito/android/lib/design/input/Input;", "fromInput", AuthSource.OPEN_CHANNEL_LIST, "toPlaceholder", "f", "blueColor", "o", "Z", "resetButtonClickable", "l", "fromFormatting", "k", "fromPlaceholder", "j", "rootView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "title", "resetButton", "Landroid/os/Parcelable;", "state", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", "e", "applyButton", "h", "toInput", "thousandsSeparator", "<init>", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "State", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RangeFilterView implements InlineFiltersView {
    public Function1<? super List<String>, Unit> a = c.a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final View e;
    public final int f;
    public final int g;
    public final Input h;
    public final Input i;
    public final View j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final boolean o;

    @Parcelize
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new State(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(@Nullable String str, @Nullable String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements TextView.OnEditorActionListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw null;
                } else if (i != 6) {
                    return false;
                } else {
                    RangeFilterView.access$onApply((RangeFilterView) this.b);
                    return true;
                }
            } else if (i != 5) {
                return false;
            } else {
                ((RangeFilterView) this.b).h.showKeyboard();
                return true;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RangeFilterView a;

        public b(RangeFilterView rangeFilterView) {
            this.a = rangeFilterView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RangeFilterView.access$onApply(this.a);
        }
    }

    public static final class c extends Lambda implements Function1<List<? extends String>, Unit> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(List<? extends String> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
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

    public static final class f implements Runnable {
        public final /* synthetic */ RangeFilterView a;

        public f(RangeFilterView rangeFilterView) {
            this.a = rangeFilterView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i.showKeyboard();
        }
    }

    public RangeFilterView(@NotNull View view, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, boolean z, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(str, "fromPlaceholder");
        Intrinsics.checkNotNullParameter(str2, "fromFormatting");
        Intrinsics.checkNotNullParameter(str4, "toFormatting");
        this.j = view;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.o = z;
        View findViewById = view.findViewById(R.id.inline_filter_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…line_filter_dialog_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.reset_action_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.close_inline_filter_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(R.id.apply_btn);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.f = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        this.g = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28);
        View findViewById5 = view.findViewById(R.id.inline_filter_to_input);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById5;
        this.h = input;
        View findViewById6 = view.findViewById(R.id.inline_filter_from_input);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input2 = (Input) findViewById6;
        this.i = input2;
        StringBuilder W = a2.b.a.a.a.W("###", str5, "###", str5, "###");
        a2.b.a.a.a.n1(W, str5, "###", str5, "###");
        FormatterType formatterType = new FormatterType(1, "0123456789", 2, new MaskParameters("", false, "", null, false, a2.b.a.a.a.v(W, str5, "###", str5, "###"), true, false, null, "0", 0, 0, 3354, null));
        d(input2, str2, formatterType);
        d(input, str4, formatterType);
        findViewById4.setOnClickListener(new b(this));
        input2.setOnEditorActionListener(new a(0, this));
        input.setOnEditorActionListener(new a(1, this));
    }

    public static final void access$onApply(RangeFilterView rangeFilterView) {
        rangeFilterView.a.invoke(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(rangeFilterView.a(rangeFilterView.i)), String.valueOf(rangeFilterView.a(rangeFilterView.h))}));
    }

    public final Long a(Input input) {
        String deformattedText = input.getDeformattedText();
        StringBuilder sb = new StringBuilder();
        int length = deformattedText.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = deformattedText.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return l.toLongOrNull(sb2);
    }

    public final void b(int i2) {
        View view = this.j;
        view.setPadding(view.getPaddingLeft(), this.j.getPaddingTop(), this.j.getPaddingRight(), i2);
    }

    public final void c(Input input, Long l2, String str) {
        if (l2 == null) {
            input.setHint(str);
        } else {
            Input.setText$default(input, String.valueOf(l2.longValue()), false, 2, null);
        }
    }

    public final void d(Input input, String str, FormatterType formatterType) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "formatting");
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"%s"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            str3 = "";
            str2 = str3;
        } else {
            String str4 = (String) split$default.get(0);
            str2 = (String) split$default.get(1);
            str3 = str4;
        }
        input.setPrefix(str3);
        input.setPostfix(str2);
        Input.setFormatterType$default(input, formatterType, false, 2, null);
        input.addTextChangedListener(new SimpleTextWatcher(this, str, formatterType) { // from class: com.avito.android.inline_filters.dialog.range.RangeFilterView$setUpInput$$inlined$with$lambda$1
            public final /* synthetic */ RangeFilterView a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                if (!(this.a.o)) {
                    RangeFilterView rangeFilterView = this.a;
                    if (rangeFilterView.a(rangeFilterView.i) == null) {
                        RangeFilterView rangeFilterView2 = this.a;
                        if (rangeFilterView2.a(rangeFilterView2.h) == null) {
                            this.a.c.setClickable(false);
                            this.a.c.setTextColor(this.a.g);
                            return;
                        }
                    }
                    this.a.c.setClickable(true);
                    this.a.c.setTextColor(this.a.f);
                }
            }
        });
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    @Nullable
    public Parcelable getState() {
        b(0);
        Long a3 = a(this.i);
        String str = null;
        String valueOf = a3 != null ? String.valueOf(a3.longValue()) : null;
        Long a4 = a(this.h);
        if (a4 != null) {
            str = String.valueOf(a4.longValue());
        }
        return new State(valueOf, str);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    @NotNull
    public Observable<InlineFiltersDialogItem> selectAction() {
        Observable<InlineFiltersDialogItem> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyAction(@NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "applyAction");
        this.a = function1;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setApplyBtnVisible(boolean z) {
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setBackButtonEnabled(boolean z) {
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setCloseAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        this.d.setOnClickListener(new d(function0));
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setImageFilterExposeAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "exposeAction");
        InlineFiltersView.DefaultImpls.setImageFilterExposeAction(this, function0);
    }

    public final void setInputValues(@Nullable Long l2, @Nullable Long l3) {
        c(this.i, l2, this.k);
        c(this.h, l3, this.m);
        b(0);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setItemsView(@NotNull List<InlineFiltersDialogItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "resetAction");
        this.c.setOnClickListener(new e(function0));
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionClickable(boolean z) {
        this.c.setClickable(z);
        if (z) {
            this.c.setTextColor(this.f);
        } else {
            this.c.setTextColor(this.g);
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resetActionHint");
        this.c.setText(str);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setResetActionVisibility(boolean z) {
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setSearchInputVisibility(int i2) {
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof State) {
            State state = (State) parcelable;
            String str = state.a;
            Long l2 = null;
            Long longOrNull = str != null ? l.toLongOrNull(str) : null;
            String str2 = state.b;
            if (str2 != null) {
                l2 = l.toLongOrNull(str2);
            }
            setInputValues(longOrNull, l2);
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        this.b.setText(str);
    }

    public final void showKeyboard() {
        this.i.post(new f(this));
    }
}
