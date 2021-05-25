package com.avito.android.lib.design.deprecated.select;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.deprecated.select.SelectionAwareEditText;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Используй Input вместе с setComponentType(ComponentType.SELECT)", replaceWith = @ReplaceWith(expression = "Input", imports = {"Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u000e\u0001\u0001\u0001\u0001\u0001\u0001\u0001B\u0015\b\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001B!\b\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001B*\b\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u001a¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017JK\u0010 \u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010#\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b/\u0010\u000eJ\u0017\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b1\u0010\u000eJ\u0017\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b3\u0010\u000eJ\u0017\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b5\u0010\u000eJ\u0015\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000206¢\u0006\u0004\b;\u00109J\u0015\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u001a¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0004¢\u0006\u0004\bA\u0010@J\u000f\u0010B\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u001aH\u0016¢\u0006\u0004\bE\u0010>J\u0017\u0010F\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\bF\u0010GR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010NR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010\\R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010KR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010KR\u0018\u0010m\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010XR\u0016\u0010x\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010\\R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u001a\u0010~\u001a\u00060{R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0001\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010pR\u001b\u0010\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/avito/android/lib/design/deprecated/select/SelectState;", "state", "", "setState", "(Lcom/avito/android/lib/design/deprecated/select/SelectState;)V", "Lcom/avito/android/lib/design/deprecated/select/SelectMode;", "mode", "setMode", "(Lcom/avito/android/lib/design/deprecated/select/SelectMode;)V", "", "value", "setValueInner", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/common/InputData;", "data", "setText", "(Lcom/avito/android/common/InputData;)V", "title", MessengerShareContentUtility.SUBTITLE, "hint", "initField", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "Lcom/avito/android/common/InputFormatter;", "formatter", "", "inputType", "prefix", "prefixColor", "postfix", "postfixColor", "initInput", "(Lcom/avito/android/common/InputFormatter;ILjava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ValueClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueClickListener", "(Lcom/avito/android/lib/design/deprecated/select/SelectView$ValueClickListener;)V", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ClearClickListener;", "setOnClearClickListener", "(Lcom/avito/android/lib/design/deprecated/select/SelectView$ClearClickListener;)V", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ChangeListener;", "setOnChangeListener", "(Lcom/avito/android/lib/design/deprecated/select/SelectView$ChangeListener;)V", "Lcom/avito/android/lib/design/deprecated/select/SelectView$FocusChangeListener;", "setOnFocusChangeListener", "(Lcom/avito/android/lib/design/deprecated/select/SelectView$FocusChangeListener;)V", "setValue", "status", "setStatus", "warning", "setWarning", "error", "setError", "", "visible", "setClearVisible", "(Z)V", "singleLine", "setSingleLine", "gravity", "setEditTextGravity", "(I)V", "selectMode", "()V", "inputMode", "getValue", "()Ljava/lang/CharSequence;", "orientation", "setOrientation", "h", "(Lcom/avito/android/common/InputData;)Lcom/avito/android/common/InputData;", "y", "Lcom/avito/android/common/InputFormatter;", "x", "Ljava/lang/CharSequence;", "Landroid/view/View;", "u", "Landroid/view/View;", "clearView", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolderFactory;", "p", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolderFactory;", "drawableHolderFactory", "s", "valueContainer", "Landroid/text/style/ForegroundColorSpan;", "z", "Landroid/text/style/ForegroundColorSpan;", "prefixTextColorSpan", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "subtitleView", "Lcom/avito/android/lib/design/deprecated/select/SelectionAwareEditText;", "t", "Lcom/avito/android/lib/design/deprecated/select/SelectionAwareEditText;", "valueView", VKApiConst.VERSION, "statusView", "B", "Lcom/avito/android/lib/design/deprecated/select/SelectState;", "H", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ChangeListener;", "changeListener", "L", "w", "I", "Lcom/avito/android/lib/design/deprecated/select/SelectView$FocusChangeListener;", "focusChangeListener", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "D", "Lcom/avito/android/lib/design/deprecated/select/DrawableHolder;", "backgroundDrawableHolder", "F", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ValueClickListener;", "valueClickListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "postfixTextColorSpan", VKApiConst.Q, "titleView", "C", "Lcom/avito/android/lib/design/deprecated/select/SelectMode;", "Lcom/avito/android/lib/design/deprecated/select/SelectView$d;", "J", "Lcom/avito/android/lib/design/deprecated/select/SelectView$d;", "textChangedListener", ExifInterface.LONGITUDE_EAST, "clearDrawableHolder", "G", "Lcom/avito/android/lib/design/deprecated/select/SelectView$ClearClickListener;", "clearClickListener", "K", "Z", "hasChangeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ChangeListener", "ClearClickListener", AuthSource.BOOKING_ORDER, "FocusChangeListener", "c", "d", "ValueClickListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectView extends LinearLayoutCompat {
    public ForegroundColorSpan A;
    public SelectState B = SelectState.NORMAL;
    public SelectMode C = SelectMode.INPUT;
    public DrawableHolder D;
    public final DrawableHolder E;
    public ValueClickListener F;
    public ClearClickListener G;
    public ChangeListener H;
    public FocusChangeListener I;
    public d J = new d();
    public boolean K;
    public CharSequence L;
    public final DrawableHolderFactory p;
    public final TextView q;
    public final TextView r;
    public final View s;
    public final SelectionAwareEditText t;
    public final View u;
    public final TextView v;
    public CharSequence w;
    public CharSequence x;
    public InputFormatter y;
    public ForegroundColorSpan z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectView$ChangeListener;", "Lkotlin/Function1;", "", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface ChangeListener extends Function1<String, Unit> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectView$ClearClickListener;", "Lkotlin/Function0;", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface ClearClickListener extends Function0<Unit> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectView$FocusChangeListener;", "Lkotlin/Function1;", "", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface FocusChangeListener extends Function1<Boolean, Unit> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectView$ValueClickListener;", "Lkotlin/Function0;", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface ValueClickListener extends Function0<Unit> {
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
                ValueClickListener valueClickListener = ((SelectView) this.b).F;
                if (valueClickListener != null) {
                    Unit unit = (Unit) valueClickListener.invoke();
                }
            } else if (i == 1) {
                ClearClickListener clearClickListener = ((SelectView) this.b).G;
                if (clearClickListener != null) {
                    Unit unit2 = (Unit) clearClickListener.invoke();
                }
            } else {
                throw null;
            }
        }
    }

    public final class b implements View.OnFocusChangeListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(@Nullable View view, boolean z) {
            FocusChangeListener focusChangeListener = SelectView.this.I;
            if (focusChangeListener != null) {
                Unit unit = (Unit) focusChangeListener.invoke(Boolean.valueOf(z));
            }
        }
    }

    public final class c implements SelectionAwareEditText.SelectionListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.avito.android.lib.design.deprecated.select.SelectionAwareEditText.SelectionListener
        public void onSelectionChanged(int i, int i2) {
            SelectView.access$editTextSelectionChanged(SelectView.this, i, i2);
        }
    }

    public final class d extends SimpleTextWatcher {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "s");
            SelectView.access$editTextTextChanged(SelectView.this, editable);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Используй Input вместе с setComponentType(ComponentType.SELECT)", replaceWith = @ReplaceWith(expression = "Input(context)", imports = {"Input"}))
    public SelectView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        DrawableHolderFactory drawableHolderFactory = new DrawableHolderFactory();
        this.p = drawableHolderFactory;
        super.setOrientation(1);
        setDuplicateParentStateEnabled(true);
        LayoutInflater.from(getContext()).inflate(R.layout.deprecated_select, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.value_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.value_container)");
        this.s = findViewById3;
        View findViewById4 = findViewById3.findViewById(R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "valueContainer.findViewById(R.id.value)");
        SelectionAwareEditText selectionAwareEditText = (SelectionAwareEditText) findViewById4;
        this.t = selectionAwareEditText;
        View findViewById5 = findViewById3.findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "valueContainer.findViewById(R.id.clear)");
        this.u = findViewById5;
        View findViewById6 = findViewById(R.id.status);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.status)");
        this.v = (TextView) findViewById6;
        selectionAwareEditText.setOnClickListener(new a(0, this));
        findViewById5.setOnClickListener(new a(1, this));
        selectionAwareEditText.addTextChangedListener(this.J);
        this.K = true;
        selectionAwareEditText.setOnFocusChangeListener(new b());
        selectionAwareEditText.setSelectionListener(new c());
        SelectMode selectMode = this.C;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DrawableHolder createBackgroundHolder = drawableHolderFactory.createBackgroundHolder(selectMode, resources);
        this.D = createBackgroundHolder;
        SelectState selectState = this.B;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        createBackgroundHolder.setState(selectState, context2);
        Views.setBackgroundCompat(selectionAwareEditText, this.D.getDrawable());
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        DrawableHolder createClearDrawableHolder = drawableHolderFactory.createClearDrawableHolder(context3);
        this.E = createClearDrawableHolder;
        SelectState selectState2 = this.B;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        createClearDrawableHolder.setState(selectState2, context4);
        Views.setBackgroundCompat(findViewById5, createClearDrawableHolder.getDrawable());
    }

    public static final void access$editTextSelectionChanged(SelectView selectView, int i, int i2) {
        int length = selectView.t.length();
        CharSequence charSequence = selectView.x;
        int length2 = charSequence != null ? charSequence.length() : 0;
        CharSequence charSequence2 = selectView.w;
        int length3 = charSequence2 != null ? charSequence2.length() : 0;
        if (!(length2 == 0 && length3 == 0) && length3 + length2 <= length) {
            int i3 = length - length2;
            int min = Math.min(Math.max(length3, i), Math.max(i3, 0));
            int min2 = Math.min(Math.max(length3, i2), Math.max(i3, 0));
            if (i != min || i2 != min2) {
                selectView.t.setSelection(min, min2);
            }
        }
    }

    public static final void access$editTextTextChanged(SelectView selectView, Editable editable) {
        InputData inputData = new InputData(editable, selectView.t.getSelectionStart(), selectView.t.getSelectionEnd());
        CharSequence charSequence = selectView.w;
        int length = charSequence != null ? charSequence.length() : 0;
        CharSequence charSequence2 = selectView.x;
        int length2 = charSequence2 != null ? charSequence2.length() : 0;
        if (!(length == 0 && length2 == 0)) {
            if (length + length2 <= inputData.getValue().length()) {
                inputData = new InputData(inputData.getValue().subSequence(length, inputData.getValue().length() - length2).toString(), inputData.getSelectionStart() - length, inputData.getSelectionStart() - length);
            } else {
                inputData = new InputData("", 0, 0);
            }
        }
        InputFormatter inputFormatter = selectView.y;
        if (inputFormatter != null) {
            inputData = inputFormatter.format(inputData);
        }
        selectView.L = inputData.getValue();
        InputData h = selectView.h(inputData);
        if (!selectView.K) {
            selectView.setText(h);
        } else {
            selectView.K = false;
            selectView.t.removeTextChangedListener(selectView.J);
            selectView.setText(h);
            selectView.t.addTextChangedListener(selectView.J);
            selectView.K = true;
        }
        ChangeListener changeListener = selectView.H;
        if (changeListener != null) {
            Unit unit = (Unit) changeListener.invoke(String.valueOf(selectView.L));
        }
    }

    private final void setMode(SelectMode selectMode) {
        if (this.C != selectMode) {
            this.C = selectMode;
            SelectionAwareEditText selectionAwareEditText = this.t;
            SelectMode selectMode2 = SelectMode.INPUT;
            boolean z2 = true;
            selectionAwareEditText.setInputType(selectMode == selectMode2 ? 1 : 0);
            SelectionAwareEditText selectionAwareEditText2 = this.t;
            if (selectMode != selectMode2) {
                z2 = false;
            }
            selectionAwareEditText2.setFocusableInTouchMode(z2);
            DrawableHolderFactory drawableHolderFactory = this.p;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            DrawableHolder createBackgroundHolder = drawableHolderFactory.createBackgroundHolder(selectMode, resources);
            this.D = createBackgroundHolder;
            SelectState selectState = this.B;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            createBackgroundHolder.setState(selectState, context);
            Views.setBackgroundCompat(this.t, this.D.getDrawable());
        }
    }

    private final void setState(SelectState selectState) {
        if (this.B != selectState) {
            this.B = selectState;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.v.setTextColor(Contexts.getColorStateListByAttr(context, selectState.getStatusAttr()));
            DrawableHolder drawableHolder = this.D;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            drawableHolder.setState(selectState, context2);
            DrawableHolder drawableHolder2 = this.E;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            drawableHolder2.setState(selectState, context3);
        }
    }

    private final void setText(InputData inputData) {
        boolean z2 = true;
        boolean z3 = !Intrinsics.areEqual(String.valueOf(this.t.getText()), inputData.getValue().toString());
        if (z3) {
            this.t.setText(inputData.getValue());
        }
        if (this.t.getSelectionStart() == inputData.getSelectionStart() && this.t.getSelectionEnd() == inputData.getSelectionEnd()) {
            z2 = false;
        }
        if (z3 || z2) {
            this.t.setSelection(inputData.getSelectionStart(), inputData.getSelectionEnd());
        }
    }

    private final void setValueInner(CharSequence charSequence) {
        this.L = charSequence;
        String str = charSequence != null ? charSequence : "";
        boolean z2 = true;
        if (!(str.length() > 0)) {
            z2 = false;
        }
        if (z2 || this.t.hasFocus()) {
            InputData inputData = new InputData(str, str.length(), str.length());
            InputFormatter inputFormatter = this.y;
            if (inputFormatter != null) {
                inputData = inputFormatter.format(inputData);
            }
            setText(h(inputData));
            return;
        }
        this.t.setText(charSequence);
    }

    @Nullable
    public final CharSequence getValue() {
        return this.L;
    }

    public final InputData h(InputData inputData) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(inputData.getValue());
        CharSequence charSequence = this.w;
        int i = 0;
        if (charSequence != null) {
            spannableStringBuilder.insert(0, charSequence);
            ForegroundColorSpan foregroundColorSpan = this.z;
            if (foregroundColorSpan != null) {
                spannableStringBuilder.setSpan(foregroundColorSpan, 0, charSequence.length(), 33);
            }
        }
        CharSequence charSequence2 = this.x;
        if (charSequence2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(charSequence2);
            ForegroundColorSpan foregroundColorSpan2 = this.A;
            if (foregroundColorSpan2 != null) {
                spannableStringBuilder.setSpan(foregroundColorSpan2, length, spannableStringBuilder.length(), 33);
            }
        }
        CharSequence charSequence3 = this.w;
        if (charSequence3 != null) {
            i = charSequence3.length();
        }
        return new InputData(spannableStringBuilder, inputData.getSelectionStart() + i, inputData.getSelectionEnd() + i);
    }

    public final void initField(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextViews.bindText$default(this.q, charSequence, false, 2, null);
        TextViews.bindText$default(this.r, charSequence2, false, 2, null);
        setValue("");
        this.t.setHint(charSequence3);
        TextViews.bindText$default(this.v, "", false, 2, null);
        setState(SelectState.NORMAL);
    }

    public final void initInput(@Nullable InputFormatter inputFormatter, int i, @Nullable CharSequence charSequence, @ColorRes @Nullable Integer num, @Nullable CharSequence charSequence2, @ColorRes @Nullable Integer num2) {
        this.y = inputFormatter;
        if (inputFormatter != null) {
            this.t.setInputType(inputFormatter.getInputType());
        } else {
            this.t.setInputType(i);
        }
        this.w = charSequence;
        if (num == null) {
            this.z = null;
        } else {
            this.z = new ForegroundColorSpan(ContextCompat.getColor(getContext(), num.intValue()));
        }
        this.x = charSequence2;
        if (num2 == null) {
            this.A = null;
        } else {
            this.A = new ForegroundColorSpan(ContextCompat.getColor(getContext(), num2.intValue()));
        }
    }

    public final void inputMode() {
        setMode(SelectMode.INPUT);
    }

    public final void selectMode() {
        setMode(SelectMode.SELECT);
    }

    public final void setClearVisible(boolean z2) {
        Views.setVisible(this.u, z2);
    }

    public final void setEditTextGravity(int i) {
        this.t.setGravity(i);
    }

    public final void setError(@Nullable CharSequence charSequence) {
        SelectState selectState = SelectState.ERROR;
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        setState(selectState);
    }

    public final void setOnChangeListener(@NotNull ChangeListener changeListener) {
        Intrinsics.checkNotNullParameter(changeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.H = changeListener;
    }

    public final void setOnClearClickListener(@NotNull ClearClickListener clearClickListener) {
        Intrinsics.checkNotNullParameter(clearClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.G = clearClickListener;
    }

    public final void setOnFocusChangeListener(@NotNull FocusChangeListener focusChangeListener) {
        Intrinsics.checkNotNullParameter(focusChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.I = focusChangeListener;
    }

    public final void setOnValueClickListener(@Nullable ValueClickListener valueClickListener) {
        this.F = valueClickListener;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public void setOrientation(int i) {
    }

    public final void setSingleLine(boolean z2) {
        this.t.setSingleLine(z2);
    }

    public final void setStatus(@Nullable CharSequence charSequence) {
        SelectState selectState = SelectState.NORMAL;
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        setState(selectState);
    }

    public final void setValue(@Nullable CharSequence charSequence) {
        if (!this.K) {
            setValueInner(charSequence);
            return;
        }
        this.K = false;
        this.t.removeTextChangedListener(this.J);
        setValueInner(charSequence);
        this.t.addTextChangedListener(this.J);
        this.K = true;
    }

    public final void setWarning(@Nullable CharSequence charSequence) {
        SelectState selectState = SelectState.WARNING;
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        setState(selectState);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Используй Input вместе с setComponentType(ComponentType.SELECT)", replaceWith = @ReplaceWith(expression = "Input(context, attrs)", imports = {"Input"}))
    public SelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        DrawableHolderFactory drawableHolderFactory = new DrawableHolderFactory();
        this.p = drawableHolderFactory;
        super.setOrientation(1);
        setDuplicateParentStateEnabled(true);
        LayoutInflater.from(getContext()).inflate(R.layout.deprecated_select, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.value_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.value_container)");
        this.s = findViewById3;
        View findViewById4 = findViewById3.findViewById(R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "valueContainer.findViewById(R.id.value)");
        SelectionAwareEditText selectionAwareEditText = (SelectionAwareEditText) findViewById4;
        this.t = selectionAwareEditText;
        View findViewById5 = findViewById3.findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "valueContainer.findViewById(R.id.clear)");
        this.u = findViewById5;
        View findViewById6 = findViewById(R.id.status);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.status)");
        this.v = (TextView) findViewById6;
        selectionAwareEditText.setOnClickListener(new a(0, this));
        findViewById5.setOnClickListener(new a(1, this));
        selectionAwareEditText.addTextChangedListener(this.J);
        this.K = true;
        selectionAwareEditText.setOnFocusChangeListener(new b());
        selectionAwareEditText.setSelectionListener(new c());
        SelectMode selectMode = this.C;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DrawableHolder createBackgroundHolder = drawableHolderFactory.createBackgroundHolder(selectMode, resources);
        this.D = createBackgroundHolder;
        SelectState selectState = this.B;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        createBackgroundHolder.setState(selectState, context2);
        Views.setBackgroundCompat(selectionAwareEditText, this.D.getDrawable());
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        DrawableHolder createClearDrawableHolder = drawableHolderFactory.createClearDrawableHolder(context3);
        this.E = createClearDrawableHolder;
        SelectState selectState2 = this.B;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        createClearDrawableHolder.setState(selectState2, context4);
        Views.setBackgroundCompat(findViewById5, createClearDrawableHolder.getDrawable());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Используй Input вместе с setComponentType(ComponentType.SELECT)", replaceWith = @ReplaceWith(expression = "Input(context, attrs, defStyleAttr)", imports = {"Input"}))
    public SelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        DrawableHolderFactory drawableHolderFactory = new DrawableHolderFactory();
        this.p = drawableHolderFactory;
        super.setOrientation(1);
        setDuplicateParentStateEnabled(true);
        LayoutInflater.from(getContext()).inflate(R.layout.deprecated_select, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.value_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.value_container)");
        this.s = findViewById3;
        View findViewById4 = findViewById3.findViewById(R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "valueContainer.findViewById(R.id.value)");
        SelectionAwareEditText selectionAwareEditText = (SelectionAwareEditText) findViewById4;
        this.t = selectionAwareEditText;
        View findViewById5 = findViewById3.findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "valueContainer.findViewById(R.id.clear)");
        this.u = findViewById5;
        View findViewById6 = findViewById(R.id.status);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.status)");
        this.v = (TextView) findViewById6;
        selectionAwareEditText.setOnClickListener(new a(0, this));
        findViewById5.setOnClickListener(new a(1, this));
        selectionAwareEditText.addTextChangedListener(this.J);
        this.K = true;
        selectionAwareEditText.setOnFocusChangeListener(new b());
        selectionAwareEditText.setSelectionListener(new c());
        SelectMode selectMode = this.C;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DrawableHolder createBackgroundHolder = drawableHolderFactory.createBackgroundHolder(selectMode, resources);
        this.D = createBackgroundHolder;
        SelectState selectState = this.B;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        createBackgroundHolder.setState(selectState, context2);
        Views.setBackgroundCompat(selectionAwareEditText, this.D.getDrawable());
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        DrawableHolder createClearDrawableHolder = drawableHolderFactory.createClearDrawableHolder(context3);
        this.E = createClearDrawableHolder;
        SelectState selectState2 = this.B;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        createClearDrawableHolder.setState(selectState2, context4);
        Views.setBackgroundCompat(findViewById5, createClearDrawableHolder.getDrawable());
    }
}
