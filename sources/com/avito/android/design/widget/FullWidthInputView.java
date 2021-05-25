package com.avito.android.design.widget;

import a2.g.r.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.design.widget.SelectionAwareEditText;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.Parcels;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n³\u0001Y_´\u0001µ\u0001RUB.\b\u0017\u0012\b\u0010­\u0001\u001a\u00030¬\u0001\u0012\f\b\u0002\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001\u0012\t\b\u0002\u0010°\u0001\u001a\u00020\u000f¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0019\u001a\u00020\u00062\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J)\u0010 \u001a\u00020\u00062\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000f¢\u0006\u0004\b.\u0010\u0012J\u0015\u0010/\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b/\u0010\u0012J\u0015\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000f¢\u0006\u0004\b1\u0010\u0012J\r\u00102\u001a\u00020\u0006¢\u0006\u0004\b2\u0010(J\u0019\u00103\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b3\u0010\bJ\u0011\u00104\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b6\u0010\bJ\u0011\u00107\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b7\u00105J\u0019\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b9\u0010\bJ\u0011\u0010:\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b:\u00105J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u000fH\u0016¢\u0006\u0004\b<\u0010\u0012J\u0019\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b<\u0010\bJ\u000f\u0010>\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b>\u00105J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010(J\u0017\u0010B\u001a\u00020\"2\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\"2\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bD\u0010CJ\u0011\u0010F\u001a\u0004\u0018\u00010EH\u0014¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000f¢\u0006\u0004\bI\u0010\u0012J\u0015\u0010K\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u001c¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010EH\u0014¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020\"H\u0002¢\u0006\u0004\bR\u0010SJ\u001b\u0010U\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010T\u001a\u00020\"H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\"2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bW\u0010CJ\u000f\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0004\bX\u0010(J\u0017\u0010Y\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b[\u0010(J\u0017\u0010]\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\"H\u0002¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020\u00062\b\b\u0002\u0010\\\u001a\u00020\"H\u0002¢\u0006\u0004\b_\u0010^J\u000f\u0010`\u001a\u00020\u0006H\u0002¢\u0006\u0004\b`\u0010(R\u0016\u0010c\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010bR\u001a\u0010h\u001a\u00060eR\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR0\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006\u0018\u00010i8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010x\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010|\u001a\u00060yR\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R&\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0013\n\u0004\b}\u0010~\u001a\u0004\b\u00105\"\u0005\b\u0001\u0010\bR\u0019\u0010\u0001\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bR\u0010\u0001R\u0017\u0010\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010bR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b[\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bU\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bX\u0010\u0001R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u00108\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u0019\u0010\u0001\u001a\u00020\"8B@\u0002X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R,\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R,\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010bR\u0019\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b]\u0010 \u0001R\u0017\u0010¢\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010bR\u001a\u0010¦\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010~R(\u0010«\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010~\u001a\u0005\b©\u0001\u00105\"\u0005\bª\u0001\u0010\b¨\u0006¶\u0001"}, d2 = {"Lcom/avito/android/design/widget/FullWidthInputView;", "Landroid/widget/RelativeLayout;", "Lcom/avito/android/design/widget/PostingView;", "Lcom/avito/android/design/widget/FloatingLabelView;", "", "title", "", "setTitleInner", "(Ljava/lang/CharSequence;)V", "value", "setValueInner", "Lcom/avito/android/common/InputData;", "data", "setText", "(Lcom/avito/android/common/InputData;)V", "", "maxLines", "setMaxLinesInner", "(I)V", "verticalPadding", "setEditTextVerticalMargin", "mode", "setFloatingLabelMode", "Lcom/avito/android/design/widget/FullWidthInputView$ChangeListener;", "changeListener", "setChangeListener", "(Lcom/avito/android/design/widget/FullWidthInputView$ChangeListener;)V", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/design/widget/FullWidthInputView$FocusChangeListener;", "focusChangeListener", "setFocusChangeListener", "(Lcom/avito/android/design/widget/FullWidthInputView$FocusChangeListener;)V", "", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "()V", "Landroid/text/method/KeyListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setKeyListener", "(Landroid/text/method/KeyListener;)V", "inputType", "setInputType", "setMaxLines", "minLines", "setMinLines", "setFocused", "setValue", "getValue", "()Ljava/lang/CharSequence;", "setTitle", "getTitle", "info", "setInfo", "getInfo", "stringRes", "setError", "error", "getError", "clearError", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "padding", "setBottomPadding", "text", "insertInCursorPosition", "(Ljava/lang/String;)V", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "isPressed", "", "c", "(Z)[I", "condition", "d", "(IZ)I", "e", "i", AuthSource.SEND_ABUSE, "(Lcom/avito/android/common/InputData;)Lcom/avito/android/common/InputData;", g.a, "hasFocus", "h", "(Z)V", AuthSource.BOOKING_ORDER, "f", "k", "I", "floatingLabelMode", "errorTextColor", "Lcom/avito/android/design/widget/FullWidthInputView$d;", "u", "Lcom/avito/android/design/widget/FullWidthInputView$d;", "textChangedListener", "Lkotlin/Function1;", "z", "Lkotlin/jvm/functions/Function1;", "getRawValueChangeListener", "()Lkotlin/jvm/functions/Function1;", "setRawValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "rawValueChangeListener", "Lcom/avito/android/common/InputFormatter;", "s", "Lcom/avito/android/common/InputFormatter;", "getFormatter", "()Lcom/avito/android/common/InputFormatter;", "setFormatter", "(Lcom/avito/android/common/InputFormatter;)V", "formatter", "Lcom/avito/android/design/widget/FullWidthInputView$b;", "t", "Lcom/avito/android/design/widget/FullWidthInputView$b;", "editorActionListener", VKApiConst.Q, "Ljava/lang/CharSequence;", "getPostfix", "setPostfix", "postfix", VKApiConst.VERSION, "Z", "hasChangeListener", "Landroid/text/style/ForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "prefixTextColorSpan", "hintVisibleVerticalMargin", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "floatingLabel", "Landroid/content/res/ColorStateList;", "l", "Landroid/content/res/ColorStateList;", "hintTextColor", "postfixTextColorSpan", "infoLabel", "n", "o", "hint", "y", "Landroid/text/TextWatcher;", AuthSource.OPEN_CHANNEL_LIST, "getHasPrefixOrPostfix", "()Z", "hasPrefixOrPostfix", "x", "Lkotlin/jvm/functions/Function2;", "w", "hintHiddenVerticalMargin", "Lcom/avito/android/design/widget/SelectionAwareEditText;", "Lcom/avito/android/design/widget/SelectionAwareEditText;", "editText", "normalTextColor", "Landroid/view/View;", "j", "Landroid/view/View;", "infoLabelDivider", "p", "r", "getPrefix", "setPrefix", "prefix", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ChangeListener", "FocusChangeListener", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FullWidthInputView extends RelativeLayout implements PostingView, FloatingLabelView {
    public final int a;
    public final int b;
    public final ForegroundColorSpan c;
    public final ForegroundColorSpan d;
    public final int e;
    public final int f;
    public final TextView g;
    public final SelectionAwareEditText h;
    public final TextView i;
    public final View j;
    public int k;
    public final ColorStateList l;
    public CharSequence m;
    public CharSequence n;
    public CharSequence o;
    public CharSequence p;
    @Nullable
    public CharSequence q;
    @Nullable
    public CharSequence r;
    @Nullable
    public InputFormatter s;
    public final b t;
    public d u;
    public boolean v;
    public Function2<? super FullWidthInputView, ? super String, Unit> w;
    public Function2<? super FullWidthInputView, ? super Boolean, Unit> x;
    public TextWatcher y;
    @Nullable
    public Function1<? super String, Unit> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¨\u0006\u0005"}, d2 = {"Lcom/avito/android/design/widget/FullWidthInputView$ChangeListener;", "Lkotlin/Function2;", "Lcom/avito/android/design/widget/FullWidthInputView;", "", "", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface ChangeListener extends Function2<FullWidthInputView, String, Unit> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¨\u0006\u0005"}, d2 = {"Lcom/avito/android/design/widget/FullWidthInputView$FocusChangeListener;", "Lkotlin/Function2;", "Lcom/avito/android/design/widget/FullWidthInputView;", "", "", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface FocusChangeListener extends Function2<FullWidthInputView, Boolean, Unit> {
    }

    public final class a implements View.OnFocusChangeListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(@Nullable View view, boolean z) {
            FullWidthInputView.access$editTextFocusChanged(FullWidthInputView.this, z);
        }
    }

    public final class b implements TextView.OnEditorActionListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
            return FullWidthInputView.access$editTextOnEditorAction(FullWidthInputView.this, i, keyEvent);
        }
    }

    public final class c implements SelectionAwareEditText.SelectionListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.avito.android.design.widget.SelectionAwareEditText.SelectionListener
        public void onSelectionChanged(int i, int i2) {
            FullWidthInputView.access$editTextSelectionChanged(FullWidthInputView.this, i, i2);
        }
    }

    public final class d extends SimpleTextWatcher {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "s");
            TextWatcher textWatcher = FullWidthInputView.this.y;
            if (textWatcher != null) {
                textWatcher.afterTextChanged(editable);
            }
            FullWidthInputView.access$editTextTextChanged(FullWidthInputView.this, editable);
        }

        @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
            TextWatcher textWatcher = FullWidthInputView.this.y;
            if (textWatcher != null) {
                textWatcher.beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
            TextWatcher textWatcher = FullWidthInputView.this.y;
            if (textWatcher != null) {
                textWatcher.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    @Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input(context, attrs, defStyleRes)", imports = {"com.avito.android.lib.design.input.Input"}))
    @JvmOverloads
    public FullWidthInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input(context, attrs, defStyleRes)", imports = {"com.avito.android.lib.design.input.Input"}))
    @JvmOverloads
    public FullWidthInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input(context, attrs, defStyleRes)", imports = {"com.avito.android.lib.design.input.Input"}))
    @JvmOverloads
    public FullWidthInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        b bVar = new b();
        this.t = bVar;
        this.u = new d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FullWidthInputView);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FullWidthInputView_android_layout, R.layout.posting_full_width_input_view);
        this.e = getResources().getDimensionPixelSize(R.dimen.hint_visible_value_vertical_margin);
        this.f = getResources().getDimensionPixelSize(R.dimen.hint_hidden_value_vertical_margin);
        LayoutInflater.from(context).inflate(resourceId, this);
        this.g = (TextView) Views.findById(this, R.id.floating_label);
        SelectionAwareEditText selectionAwareEditText = (SelectionAwareEditText) Views.findById(this, R.id.input);
        this.h = selectionAwareEditText;
        this.i = (TextView) Views.findById(this, R.id.info_label);
        this.j = Views.findById(this, R.id.info_label_divider);
        this.k = obtainStyledAttributes.getInt(R.styleable.FullWidthInputView_floatingLabelMode, 0);
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, R.color.text_hint_states);
        Intrinsics.checkNotNull(colorStateListCompat);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.FullWidthInputView_floatingHintTextColor);
        this.l = colorStateList != null ? colorStateList : colorStateListCompat;
        int color = obtainStyledAttributes.getColor(R.styleable.FullWidthInputView_android_textColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black));
        this.b = color;
        this.a = obtainStyledAttributes.getColor(R.styleable.FullWidthInputView_errorTextColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
        this.c = new ForegroundColorSpan(obtainStyledAttributes.getColor(R.styleable.FullWidthInputView_prefixTextColor, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28)));
        this.d = new ForegroundColorSpan(obtainStyledAttributes.getColor(R.styleable.FullWidthInputView_postfixTextColor, color));
        setMaxLinesInner(obtainStyledAttributes.getInt(R.styleable.FullWidthInputView_android_maxLines, Integer.MAX_VALUE));
        selectionAwareEditText.setMinLines(obtainStyledAttributes.getInt(R.styleable.FullWidthInputView_android_minLines, 1));
        selectionAwareEditText.setInputType(obtainStyledAttributes.getInt(R.styleable.FullWidthInputView_android_inputType, 0));
        selectionAwareEditText.setImeOptions(obtainStyledAttributes.getInt(R.styleable.FullWidthInputView_android_imeOptions, 0));
        this.r = obtainStyledAttributes.getString(R.styleable.FullWidthInputView_prefix);
        this.q = obtainStyledAttributes.getString(R.styleable.FullWidthInputView_postfix);
        setTitleInner(obtainStyledAttributes.getString(R.styleable.FullWidthInputView_android_hint));
        setValueInner(obtainStyledAttributes.getString(R.styleable.FullWidthInputView_android_text));
        setInfo(obtainStyledAttributes.getString(R.styleable.FullWidthInputView_infoText));
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
        selectionAwareEditText.setOnEditorActionListener(bVar);
        selectionAwareEditText.setSelectionListener(new c());
        selectionAwareEditText.setOnFocusChangeListener(new a());
        obtainStyledAttributes.recycle();
        h(false);
    }

    public static final void access$editTextFocusChanged(FullWidthInputView fullWidthInputView, boolean z2) {
        fullWidthInputView.b(z2);
        if (z2) {
            fullWidthInputView.g();
        }
        fullWidthInputView.h(z2);
        Function2<? super FullWidthInputView, ? super Boolean, Unit> function2 = fullWidthInputView.x;
        if (function2 != null) {
            function2.invoke(fullWidthInputView, Boolean.valueOf(z2));
        }
    }

    public static final boolean access$editTextOnEditorAction(FullWidthInputView fullWidthInputView, int i2, KeyEvent keyEvent) {
        Objects.requireNonNull(fullWidthInputView);
        if (i2 == 6 || (fullWidthInputView.h.getImeOptions() == 6 && keyEvent != null && keyEvent.getKeyCode() == 66)) {
            Keyboards.hideKeyboard$default(fullWidthInputView, false, 1, null);
            if (!fullWidthInputView.v) {
                fullWidthInputView.h.clearFocus();
            } else {
                SelectionAwareEditText selectionAwareEditText = fullWidthInputView.h;
                fullWidthInputView.v = false;
                selectionAwareEditText.removeTextChangedListener(fullWidthInputView.u);
                fullWidthInputView.h.clearFocus();
                selectionAwareEditText.addTextChangedListener(fullWidthInputView.u);
                fullWidthInputView.v = true;
            }
        }
        return false;
    }

    public static final void access$editTextSelectionChanged(FullWidthInputView fullWidthInputView, int i2, int i3) {
        int length = fullWidthInputView.h.length();
        CharSequence charSequence = fullWidthInputView.q;
        int i4 = 0;
        int length2 = charSequence != null ? charSequence.length() : 0;
        CharSequence charSequence2 = fullWidthInputView.r;
        if (charSequence2 != null) {
            i4 = charSequence2.length();
        }
        if (!(length2 == 0 && i4 == 0) && i4 + length2 <= length) {
            int i5 = length - length2;
            int min = Math.min(Math.max(i4, i2), i5);
            int min2 = Math.min(Math.max(i4, i3), i5);
            if (i2 != min || i3 != min2) {
                fullWidthInputView.h.setSelection(min, min2);
            }
        }
    }

    public static final void access$editTextTextChanged(FullWidthInputView fullWidthInputView, Editable editable) {
        InputData inputData = new InputData(editable, fullWidthInputView.h.getSelectionStart(), fullWidthInputView.h.getSelectionEnd());
        CharSequence charSequence = fullWidthInputView.r;
        int length = charSequence != null ? charSequence.length() : 0;
        CharSequence charSequence2 = fullWidthInputView.q;
        int length2 = charSequence2 != null ? charSequence2.length() : 0;
        if (!(length == 0 && length2 == 0)) {
            if (length + length2 <= inputData.getValue().length()) {
                inputData = new InputData(inputData.getValue().subSequence(length, inputData.getValue().length() - length2).toString(), inputData.getSelectionStart() - length, inputData.getSelectionStart() - length);
            } else {
                inputData = new InputData("", 0, 0);
            }
        }
        InputFormatter inputFormatter = fullWidthInputView.s;
        CharSequence value = inputData.getValue();
        if (inputFormatter != null) {
            value = inputFormatter.raw(inputData);
            inputData = inputFormatter.format(inputData);
        }
        fullWidthInputView.n = inputData.getValue();
        InputData a3 = fullWidthInputView.a(inputData);
        if (!fullWidthInputView.v) {
            fullWidthInputView.setText(a3);
        } else {
            SelectionAwareEditText selectionAwareEditText = fullWidthInputView.h;
            fullWidthInputView.v = false;
            selectionAwareEditText.removeTextChangedListener(fullWidthInputView.u);
            fullWidthInputView.setText(a3);
            selectionAwareEditText.addTextChangedListener(fullWidthInputView.u);
            fullWidthInputView.v = true;
        }
        fullWidthInputView.b(fullWidthInputView.h.hasFocus());
        fullWidthInputView.g();
        Function2<? super FullWidthInputView, ? super String, Unit> function2 = fullWidthInputView.w;
        if (function2 != null) {
            function2.invoke(fullWidthInputView, String.valueOf(fullWidthInputView.n));
        }
        Function1<? super String, Unit> function1 = fullWidthInputView.z;
        if (function1 != null) {
            function1.invoke(value.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean getHasPrefixOrPostfix() {
        /*
            r3 = this;
            java.lang.CharSequence r0 = r3.q
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0013
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x002c
            java.lang.CharSequence r0 = r3.r
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.getHasPrefixOrPostfix():boolean");
    }

    private final void setEditTextVerticalMargin(int i2) {
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = i2;
        layoutParams2.topMargin = i2;
        requestLayout();
    }

    private final void setMaxLinesInner(int i2) {
        this.h.setMaxLines(i2);
        SelectionAwareEditText selectionAwareEditText = this.h;
        boolean z2 = true;
        if (i2 > 1) {
            z2 = false;
        }
        selectionAwareEditText.setSingleLine(z2);
    }

    private final void setText(InputData inputData) {
        boolean z2 = true;
        boolean z3 = !Intrinsics.areEqual(String.valueOf(this.h.getText()), inputData.getValue().toString());
        if (z3) {
            this.h.setText(inputData.getValue());
        }
        if (this.h.getSelectionStart() == inputData.getSelectionStart() || this.h.getSelectionEnd() == inputData.getSelectionEnd()) {
            z2 = false;
        }
        if (z3 || z2) {
            this.h.setSelection(inputData.getSelectionStart(), inputData.getSelectionEnd());
        }
    }

    private final void setTitleInner(CharSequence charSequence) {
        this.o = charSequence;
        this.g.setText(charSequence);
        if (!Views.isVisible(this.g)) {
            this.h.setHint(this.o);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if ((r4.length() > 0) != false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setValueInner(java.lang.CharSequence r4) {
        /*
            r3 = this;
            r3.n = r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0012
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x0034
            com.avito.android.common.InputData r0 = new com.avito.android.common.InputData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r1 = r4.length()
            int r2 = r4.length()
            r0.<init>(r4, r1, r2)
            com.avito.android.common.InputFormatter r4 = r3.s
            if (r4 == 0) goto L_0x002d
            com.avito.android.common.InputData r0 = r4.format(r0)
        L_0x002d:
            com.avito.android.common.InputData r4 = r3.a(r0)
            r3.setText(r4)
        L_0x0034:
            com.avito.android.design.widget.SelectionAwareEditText r4 = r3.h
            boolean r4 = r4.hasFocus()
            r3.b(r4)
            r3.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.setValueInner(java.lang.CharSequence):void");
    }

    public final InputData a(InputData inputData) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(inputData.getValue());
        CharSequence charSequence = this.r;
        int i2 = 0;
        if (charSequence != null) {
            spannableStringBuilder.insert(0, charSequence);
            spannableStringBuilder.setSpan(this.c, 0, charSequence.length(), 33);
        }
        CharSequence charSequence2 = this.q;
        if (charSequence2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(charSequence2);
            spannableStringBuilder.setSpan(this.d, length, spannableStringBuilder.length(), 33);
        }
        CharSequence charSequence3 = this.r;
        if (charSequence3 != null) {
            i2 = charSequence3.length();
        }
        return new InputData(spannableStringBuilder, inputData.getSelectionStart() + i2, inputData.getSelectionEnd() + i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(boolean r3) {
        /*
            r2 = this;
            int r0 = r2.k
            if (r0 == 0) goto L_0x0089
            r1 = 1
            if (r0 == r1) goto L_0x0011
            r3 = 2
            if (r0 == r3) goto L_0x000c
            goto L_0x008e
        L_0x000c:
            r2.f()
            goto L_0x008e
        L_0x0011:
            r0 = 0
            if (r3 != 0) goto L_0x002b
            java.lang.CharSequence r3 = r2.n
            if (r3 == 0) goto L_0x0025
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r3 == 0) goto L_0x0025
            r3 = 1
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r3 = 0
            goto L_0x002c
        L_0x002b:
            r3 = 1
        L_0x002c:
            if (r3 == 0) goto L_0x0032
            r2.f()
            goto L_0x008e
        L_0x0032:
            android.widget.TextView r3 = r2.g
            com.avito.android.util.Views.hide(r3)
            java.lang.CharSequence r3 = r2.p
            if (r3 == 0) goto L_0x0044
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r3 = 0
            goto L_0x0045
        L_0x0044:
            r3 = 1
        L_0x0045:
            if (r3 == 0) goto L_0x007c
            boolean r3 = access$getHasChangeListener$p(r2)
            if (r3 != 0) goto L_0x0059
            com.avito.android.design.widget.SelectionAwareEditText r3 = r2.h
            android.text.Editable r3 = r3.getText()
            if (r3 == 0) goto L_0x007c
            r3.clear()
            goto L_0x007c
        L_0x0059:
            com.avito.android.design.widget.SelectionAwareEditText r3 = access$getEditText$p(r2)
            access$setHasChangeListener$p(r2, r0)
            com.avito.android.design.widget.FullWidthInputView$d r0 = access$getTextChangedListener$p(r2)
            r3.removeTextChangedListener(r0)
            com.avito.android.design.widget.SelectionAwareEditText r0 = r2.h
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0072
            r0.clear()
        L_0x0072:
            com.avito.android.design.widget.FullWidthInputView$d r0 = access$getTextChangedListener$p(r2)
            r3.addTextChangedListener(r0)
            access$setHasChangeListener$p(r2, r1)
        L_0x007c:
            int r3 = r2.f
            r2.setEditTextVerticalMargin(r3)
            com.avito.android.design.widget.SelectionAwareEditText r3 = r2.h
            java.lang.CharSequence r0 = r2.o
            r3.setHint(r0)
            goto L_0x008e
        L_0x0089:
            android.widget.TextView r3 = r2.g
            com.avito.android.util.Views.hide(r3)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.b(boolean):void");
    }

    public final int[] c(boolean z2) {
        return new int[]{d(16842910, isEnabled()), d(16842908, isFocused()), d(16842919, z2)};
    }

    @Override // com.avito.android.design.widget.PostingView
    public void clearError() {
        setError((CharSequence) null);
    }

    public final int d(int i2, boolean z2) {
        return z2 ? i2 : -i2;
    }

    public final boolean e(MotionEvent motionEvent) {
        float coerceAtMost = e.coerceAtMost(motionEvent.getX() - ((float) this.h.getLeft()), (float) this.h.getWidth());
        float coerceAtMost2 = e.coerceAtMost(motionEvent.getY() - ((float) this.h.getTop()), (float) this.h.getHeight());
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(coerceAtMost - motionEvent.getX(), coerceAtMost2 - motionEvent.getY());
        return this.h.onTouchEvent(obtain);
    }

    public final void f() {
        CharSequence charSequence = this.n;
        if ((charSequence == null || charSequence.length() == 0) && getHasPrefixOrPostfix()) {
            if (!this.v) {
                setText(a(new InputData("", 0, 0)));
            } else {
                SelectionAwareEditText selectionAwareEditText = this.h;
                this.v = false;
                selectionAwareEditText.removeTextChangedListener(this.u);
                setText(a(new InputData("", 0, 0)));
                selectionAwareEditText.addTextChangedListener(this.u);
                this.v = true;
            }
        }
        setEditTextVerticalMargin(this.e);
        this.h.setHint((CharSequence) null);
        Views.show(this.g);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r3 = this;
            java.lang.CharSequence r0 = r3.p
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0013
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x002e
            java.lang.CharSequence r0 = r3.n
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r1 == 0) goto L_0x0028
            r3.clearError()
            goto L_0x002e
        L_0x0028:
            r0 = 0
            r3.p = r0
            r3.i()
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.g():void");
    }

    @Nullable
    public final CharSequence getError() {
        return this.p;
    }

    @Nullable
    public final InputFormatter getFormatter() {
        return this.s;
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getInfo() {
        return this.m;
    }

    @Nullable
    public final CharSequence getPostfix() {
        return this.q;
    }

    @Nullable
    public final CharSequence getPrefix() {
        return this.r;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> */
    @Nullable
    public final Function1<String, Unit> getRawValueChangeListener() {
        return this.z;
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getTitle() {
        return this.o;
    }

    @Override // com.avito.android.design.widget.PostingView
    @Nullable
    public CharSequence getValue() {
        return this.n;
    }

    public final void h(boolean z2) {
        int i2;
        if (z2) {
            ColorStateList colorStateList = this.l;
            i2 = colorStateList.getColorForState(new int[]{16842908}, colorStateList.getDefaultColor());
        } else {
            i2 = this.l.getDefaultColor();
        }
        this.g.setTextColor(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if ((r0.length() > 0) != false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r3 = this;
            java.lang.CharSequence r0 = r3.p
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0024
            com.avito.android.design.widget.SelectionAwareEditText r0 = r3.h
            int r1 = r3.a
            r0.setTextColor(r1)
            android.widget.TextView r0 = r3.g
            int r1 = r3.a
            r0.setTextColor(r1)
            goto L_0x0032
        L_0x0024:
            com.avito.android.design.widget.SelectionAwareEditText r0 = r3.h
            int r1 = r3.b
            r0.setTextColor(r1)
            android.widget.TextView r0 = r3.g
            android.content.res.ColorStateList r1 = r3.l
            r0.setTextColor(r1)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.i():void");
    }

    public final void insertInCursorPosition(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (!this.h.isFocused()) {
            SelectionAwareEditText selectionAwareEditText = this.h;
            Editable text = selectionAwareEditText.getText();
            selectionAwareEditText.setSelection(text != null ? text.length() : 0);
        }
        int selectionStart = this.h.getSelectionStart();
        int selectionEnd = this.h.getSelectionEnd();
        if (selectionEnd > selectionStart) {
            SelectionAwareEditText selectionAwareEditText2 = this.h;
            Editable text2 = selectionAwareEditText2.getText();
            selectionAwareEditText2.setText(text2 != null ? StringsKt__StringsKt.removeRange(text2, selectionStart, selectionEnd) : null);
            Editable text3 = this.h.getText();
            if (text3 != null) {
                text3.insert(selectionStart, str);
            }
            this.h.setSelection(str.length() + selectionStart);
            return;
        }
        Editable text4 = this.h.getText();
        if (text4 != null) {
            text4.insert(selectionStart, str);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if ((r0.length() > 0) != false) goto L_0x0060;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRestoreInstanceState(@org.jetbrains.annotations.Nullable android.os.Parcelable r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.avito.android.design.widget.FullWidthInputView.SavedState
            if (r0 != 0) goto L_0x0009
            super.onRestoreInstanceState(r6)
            goto L_0x00d9
        L_0x0009:
            boolean r0 = access$getHasChangeListener$p(r5)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x006a
            com.avito.android.design.widget.FullWidthInputView$SavedState r6 = (com.avito.android.design.widget.FullWidthInputView.SavedState) r6
            android.os.Parcelable r0 = r6.getSuperState()
            super.onRestoreInstanceState(r0)
            android.widget.TextView r0 = r5.g
            android.os.Parcelable r3 = r6.getFloatingLabelState()
            r0.onRestoreInstanceState(r3)
            com.avito.android.design.widget.SelectionAwareEditText r0 = r5.h
            android.os.Parcelable r3 = r6.getEditTextState()
            r0.onRestoreInstanceState(r3)
            java.lang.String r0 = r6.getPrefix()
            r5.r = r0
            java.lang.String r0 = r6.getPostfix()
            r5.q = r0
            java.lang.String r0 = r6.getInfo()
            r5.setInfo(r0)
            java.lang.String r0 = r6.getHint()
            r5.setTitle(r0)
            java.lang.String r0 = r6.getValue()
            r5.setValue(r0)
            java.lang.String r0 = r6.getError()
            if (r0 == 0) goto L_0x005f
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x005b
            r0 = 1
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            if (r0 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            if (r1 == 0) goto L_0x00d9
            java.lang.String r6 = r6.getError()
            r5.setError(r6)
            goto L_0x00d9
        L_0x006a:
            com.avito.android.design.widget.SelectionAwareEditText r0 = access$getEditText$p(r5)
            access$setHasChangeListener$p(r5, r2)
            com.avito.android.design.widget.FullWidthInputView$d r3 = access$getTextChangedListener$p(r5)
            r0.removeTextChangedListener(r3)
            com.avito.android.design.widget.FullWidthInputView$SavedState r6 = (com.avito.android.design.widget.FullWidthInputView.SavedState) r6
            android.os.Parcelable r3 = r6.getSuperState()
            super.onRestoreInstanceState(r3)
            android.widget.TextView r3 = r5.g
            android.os.Parcelable r4 = r6.getFloatingLabelState()
            r3.onRestoreInstanceState(r4)
            com.avito.android.design.widget.SelectionAwareEditText r3 = r5.h
            android.os.Parcelable r4 = r6.getEditTextState()
            r3.onRestoreInstanceState(r4)
            java.lang.String r3 = r6.getPrefix()
            r5.r = r3
            java.lang.String r3 = r6.getPostfix()
            r5.q = r3
            java.lang.String r3 = r6.getInfo()
            r5.setInfo(r3)
            java.lang.String r3 = r6.getHint()
            r5.setTitle(r3)
            java.lang.String r3 = r6.getValue()
            r5.setValue(r3)
            java.lang.String r3 = r6.getError()
            if (r3 == 0) goto L_0x00c6
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00c2
            r3 = 1
            goto L_0x00c3
        L_0x00c2:
            r3 = 0
        L_0x00c3:
            if (r3 == 0) goto L_0x00c6
            r2 = 1
        L_0x00c6:
            if (r2 == 0) goto L_0x00cf
            java.lang.String r6 = r6.getError()
            r5.setError(r6)
        L_0x00cf:
            com.avito.android.design.widget.FullWidthInputView$d r6 = access$getTextChangedListener$p(r5)
            r0.addTextChangedListener(r6)
            access$setHasChangeListener$p(r5, r1)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.onRestoreInstanceState(android.os.Parcelable):void");
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        Parcelable onSaveInstanceState2 = this.g.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState2);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState2, "floatingLabel.onSaveInstanceState()!!");
        Parcelable onSaveInstanceState3 = this.h.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState3);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState3, "editText.onSaveInstanceState()!!");
        return new SavedState(onSaveInstanceState2, onSaveInstanceState3, this.m, this.o, this.p, this.n, this.r, this.q, onSaveInstanceState);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        boolean z2 = false;
        if (action == 0) {
            getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
            Drawable background = getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "background");
            background.setState(c(true));
        } else if (action == 1 || action == 3) {
            Drawable background2 = getBackground();
            Intrinsics.checkNotNullExpressionValue(background2, "background");
            background2.setState(c(false));
        }
        try {
            z2 = e(motionEvent);
        } catch (IndexOutOfBoundsException e2) {
            Logs.error("FullWidthInputView", e2);
        }
        if (z2) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void removeTextWatcher() {
        this.y = null;
    }

    public final void setBottomPadding(int i2) {
        SelectionAwareEditText selectionAwareEditText = this.h;
        selectionAwareEditText.setPadding(selectionAwareEditText.getPaddingLeft(), this.h.getPaddingTop(), this.h.getPaddingRight(), i2);
    }

    public final void setChangeListener(@Nullable ChangeListener changeListener) {
        this.w = changeListener;
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setError(int i2) {
        setError(getResources().getString(i2));
    }

    @Override // com.avito.android.design.widget.FloatingLabelView
    public void setFloatingLabelMode(int i2) {
        if (this.k != i2) {
            this.k = i2;
            b(this.h.hasFocus());
        }
    }

    public final void setFocusChangeListener(@Nullable FocusChangeListener focusChangeListener) {
        this.x = focusChangeListener;
    }

    public final void setFocused() {
        Keyboards.showKeyboard$default(this.h, 0, 1, null);
    }

    public final void setFormatter(@Nullable InputFormatter inputFormatter) {
        this.s = inputFormatter;
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setInfo(@Nullable CharSequence charSequence) {
        this.m = charSequence;
        this.i.setText(charSequence);
        CharSequence charSequence2 = this.m;
        boolean z2 = false;
        if (charSequence2 != null) {
            if (charSequence2.length() > 0) {
                z2 = true;
            }
        }
        if (z2) {
            Views.show(this.i);
            Views.show(this.j);
            return;
        }
        Views.hide(this.i);
        Views.hide(this.j);
    }

    public final void setInputType(int i2) {
        int i3 = 0;
        if (!this.v) {
            int selectionStart = this.h.getSelectionStart();
            int selectionEnd = this.h.getSelectionEnd();
            this.h.setInputType(i2);
            Editable text = this.h.getText();
            if (text != null) {
                i3 = text.length();
            }
            this.h.setSelection(Math.min(selectionStart, i3), Math.min(selectionEnd, i3));
            return;
        }
        SelectionAwareEditText selectionAwareEditText = this.h;
        this.v = false;
        selectionAwareEditText.removeTextChangedListener(this.u);
        int selectionStart2 = this.h.getSelectionStart();
        int selectionEnd2 = this.h.getSelectionEnd();
        this.h.setInputType(i2);
        Editable text2 = this.h.getText();
        if (text2 != null) {
            i3 = text2.length();
        }
        this.h.setSelection(Math.min(selectionStart2, i3), Math.min(selectionEnd2, i3));
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
    }

    public final void setKeyListener(@NotNull KeyListener keyListener) {
        Intrinsics.checkNotNullParameter(keyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.h.setKeyListener(keyListener);
    }

    public final void setMaxLines(int i2) {
        if (!this.v) {
            setMaxLinesInner(i2);
            return;
        }
        SelectionAwareEditText selectionAwareEditText = this.h;
        this.v = false;
        selectionAwareEditText.removeTextChangedListener(this.u);
        setMaxLinesInner(i2);
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
    }

    public final void setMinLines(int i2) {
        if (!this.v) {
            this.h.setMinLines(i2);
            return;
        }
        SelectionAwareEditText selectionAwareEditText = this.h;
        this.v = false;
        selectionAwareEditText.removeTextChangedListener(this.u);
        this.h.setMinLines(i2);
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
    }

    public final void setPostfix(@Nullable CharSequence charSequence) {
        this.q = charSequence;
    }

    public final void setPrefix(@Nullable CharSequence charSequence) {
        this.r = charSequence;
    }

    public final void setRawValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        this.z = function1;
    }

    public final void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.y = textWatcher;
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setTitle(@Nullable CharSequence charSequence) {
        if (!this.v) {
            setTitleInner(charSequence);
            return;
        }
        SelectionAwareEditText selectionAwareEditText = this.h;
        this.v = false;
        selectionAwareEditText.removeTextChangedListener(this.u);
        setTitleInner(charSequence);
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
    }

    @Override // com.avito.android.design.widget.PostingView
    public void setValue(@Nullable CharSequence charSequence) {
        if (!this.v) {
            setValueInner(charSequence);
            return;
        }
        SelectionAwareEditText selectionAwareEditText = this.h;
        this.v = false;
        selectionAwareEditText.removeTextChangedListener(this.u);
        setValueInner(charSequence);
        selectionAwareEditText.addTextChangedListener(this.u);
        this.v = true;
    }

    public final void setChangeListener(@Nullable Function2<? super FullWidthInputView, ? super String, Unit> function2) {
        this.w = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if ((r6 == null || r6.length() == 0) != false) goto L_0x0022;
     */
    @Override // com.avito.android.design.widget.PostingView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setError(@org.jetbrains.annotations.Nullable java.lang.CharSequence r6) {
        /*
            r5 = this;
            r5.p = r6
            java.lang.CharSequence r0 = r5.n
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            if (r0 != 0) goto L_0x0022
            if (r6 == 0) goto L_0x001f
            int r0 = r6.length()
            if (r0 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r0 == 0) goto L_0x0079
        L_0x0022:
            boolean r0 = access$getHasChangeListener$p(r5)
            if (r0 != 0) goto L_0x0045
            com.avito.android.design.widget.SelectionAwareEditText r0 = r5.h
            if (r6 == 0) goto L_0x0032
            int r3 = r6.length()
            if (r3 != 0) goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            r0.setLongClickable(r1)
            com.avito.android.design.widget.SelectionAwareEditText r0 = r5.h
            r0.setText(r6)
            com.avito.android.design.widget.SelectionAwareEditText r6 = r5.h
            boolean r6 = r6.hasFocus()
            r5.b(r6)
            goto L_0x0079
        L_0x0045:
            com.avito.android.design.widget.SelectionAwareEditText r0 = access$getEditText$p(r5)
            access$setHasChangeListener$p(r5, r1)
            com.avito.android.design.widget.FullWidthInputView$d r3 = access$getTextChangedListener$p(r5)
            r0.removeTextChangedListener(r3)
            com.avito.android.design.widget.SelectionAwareEditText r3 = r5.h
            if (r6 == 0) goto L_0x005d
            int r4 = r6.length()
            if (r4 != 0) goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            r3.setLongClickable(r1)
            com.avito.android.design.widget.SelectionAwareEditText r1 = r5.h
            r1.setText(r6)
            com.avito.android.design.widget.SelectionAwareEditText r6 = r5.h
            boolean r6 = r6.hasFocus()
            r5.b(r6)
            com.avito.android.design.widget.FullWidthInputView$d r6 = access$getTextChangedListener$p(r5)
            r0.addTextChangedListener(r6)
            access$setHasChangeListener$p(r5, r2)
        L_0x0079:
            r5.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.design.widget.FullWidthInputView.setError(java.lang.CharSequence):void");
    }

    public final void setFocusChangeListener(@Nullable Function2<? super FullWidthInputView, ? super Boolean, Unit> function2) {
        this.x = function2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)B]\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\u0010&\u001a\u0004\u0018\u00010*\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010*\u0012\b\u0010 \u001a\u0004\u0018\u00010*\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010*\u0012\b\u0010#\u001a\u0004\u0018\u00010*\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010*\u0012\u0006\u0010+\u001a\u00020\t¢\u0006\u0004\b(\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013¨\u0006."}, d2 = {"Lcom/avito/android/design/widget/FullWidthInputView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Parcelable;", AuthSource.SEND_ABUSE, "Landroid/os/Parcelable;", "getFloatingLabelState", "()Landroid/os/Parcelable;", "floatingLabelState", "", "d", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "hint", AuthSource.BOOKING_ORDER, "getEditTextState", "editTextState", "h", "getPostfix", "postfix", "f", "getValue", "value", "e", "getError", "error", g.a, "getPrefix", "prefix", "c", "getInfo", "info", "source", "<init>", "(Landroid/os/Parcel;)V", "", "superState", "(Landroid/os/Parcelable;Landroid/os/Parcelable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final Parcelable a;
        @NotNull
        public final Parcelable b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @Nullable
        public final String f;
        @Nullable
        public final String g;
        @Nullable
        public final String h;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/FullWidthInputView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/FullWidthInputView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.a = a2.b.a.a.a.z1(Parcelable.class, parcel);
            this.b = a2.b.a.a.a.z1(Parcelable.class, parcel);
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readString();
            this.h = parcel.readString();
        }

        @NotNull
        public final Parcelable getEditTextState() {
            return this.b;
        }

        @Nullable
        public final String getError() {
            return this.e;
        }

        @NotNull
        public final Parcelable getFloatingLabelState() {
            return this.a;
        }

        @Nullable
        public final String getHint() {
            return this.d;
        }

        @Nullable
        public final String getInfo() {
            return this.c;
        }

        @Nullable
        public final String getPostfix() {
            return this.h;
        }

        @Nullable
        public final String getPrefix() {
            return this.g;
        }

        @Nullable
        public final String getValue() {
            return this.f;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable, @NotNull Parcelable parcelable2, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable CharSequence charSequence4, @Nullable CharSequence charSequence5, @Nullable CharSequence charSequence6, @NotNull Parcelable parcelable3) {
            super(parcelable3);
            Intrinsics.checkNotNullParameter(parcelable, "floatingLabelState");
            Intrinsics.checkNotNullParameter(parcelable2, "editTextState");
            Intrinsics.checkNotNullParameter(parcelable3, "superState");
            this.a = parcelable;
            this.b = parcelable2;
            String str = null;
            String obj = charSequence != null ? charSequence.toString() : null;
            String str2 = "";
            this.c = obj == null ? str2 : obj;
            String obj2 = charSequence2 != null ? charSequence2.toString() : null;
            this.d = obj2 == null ? str2 : obj2;
            String obj3 = charSequence3 != null ? charSequence3.toString() : null;
            this.e = obj3 == null ? str2 : obj3;
            String obj4 = charSequence4 != null ? charSequence4.toString() : null;
            this.f = obj4 == null ? str2 : obj4;
            String obj5 = charSequence5 != null ? charSequence5.toString() : null;
            this.g = obj5 == null ? str2 : obj5;
            str = charSequence6 != null ? charSequence6.toString() : str;
            this.h = str != null ? str : str2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FullWidthInputView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
