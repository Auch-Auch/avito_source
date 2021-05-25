package com.redmadrobot.inputmask;

import a2.g.r.g;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.helper.RTLMask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.o.a;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0002z{Bw\u0012\u0006\u0010e\u001a\u00020\b\u0012\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020:09\u0012\b\b\u0002\u0010m\u001a\u00020f\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u00108\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010E\u001a\u00020\t¢\u0006\u0004\bn\u0010oB\u0019\b\u0016\u0012\u0006\u0010p\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bn\u0010qB#\b\u0016\u0012\u0006\u0010p\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010rB-\b\u0016\u0012\u0006\u0010p\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010sB5\b\u0016\u0012\u0006\u0010p\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010tB'\b\u0016\u0012\u0006\u0010e\u001a\u00020\b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bn\u0010uB1\b\u0016\u0012\u0006\u0010e\u001a\u00020\b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010vB;\b\u0016\u0012\u0006\u0010e\u001a\u00020\b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010wBC\b\u0016\u0012\u0006\u0010e\u001a\u00020\b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010xBK\b\u0016\u0012\u0006\u0010e\u001a\u00020\b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b09\u0012\u0006\u0010m\u001a\u00020f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010]\u001a\u0004\u0018\u00010V¢\u0006\u0004\bn\u0010yJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0015J\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010#\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010$J/\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010$J!\u0010+\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00058B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u00100R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R(\u0010A\u001a\b\u0012\u0004\u0012\u00020:098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u00103\u001a\u0004\bC\u00105\"\u0004\bD\u00107R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010IR(\u0010N\u001a\b\u0012\u0004\u0012\u00020\b098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bK\u0010<\u001a\u0004\bL\u0010>\"\u0004\bM\u0010@R$\u0010U\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010]\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b^\u00103\u001a\u0004\b_\u00105\"\u0004\b`\u00107R\"\u0010e\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\ba\u00100\u001a\u0004\bb\u0010\u0012\"\u0004\bc\u0010dR\"\u0010m\u001a\u00020f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l¨\u0006|"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "Landroid/text/TextWatcher;", "Landroid/view/View$OnFocusChangeListener;", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "Lcom/redmadrobot/inputmask/helper/Mask;", AuthSource.BOOKING_ORDER, "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/Mask;", "", "", "autocomplete", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "setText", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "Landroid/widget/EditText;", AnalyticFieldsName.field, "(Ljava/lang/String;Landroid/widget/EditText;Ljava/lang/Boolean;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", InternalConstsKt.PLACEHOLDER, "()Ljava/lang/String;", "", "acceptableTextLength", "()I", "totalTextLength", "acceptableValueLength", "totalValueLength", "Landroid/text/Editable;", "edit", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "s", Tracker.Events.CREATIVE_START, "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "cursorPosition", "before", "onTextChanged", "Landroid/view/View;", "view", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", AuthSource.SEND_ABUSE, "()Lcom/redmadrobot/inputmask/helper/Mask;", "primaryMask", "Ljava/lang/String;", "afterText", "i", "Z", "getAutoskip", "()Z", "setAutoskip", "(Z)V", "autoskip", "", "Lcom/redmadrobot/inputmask/model/Notation;", "f", "Ljava/util/List;", "getCustomNotations", "()Ljava/util/List;", "setCustomNotations", "(Ljava/util/List;)V", "customNotations", "l", "getRightToLeft", "setRightToLeft", "rightToLeft", "Ljava/lang/ref/WeakReference;", "c", "Ljava/lang/ref/WeakReference;", "I", "caretPosition", "e", "getAffineFormats", "setAffineFormats", "affineFormats", "j", "Landroid/text/TextWatcher;", "getListener", "()Landroid/text/TextWatcher;", "setListener", "(Landroid/text/TextWatcher;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "k", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "getValueListener", "()Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "setValueListener", "(Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "valueListener", "h", "getAutocomplete", "setAutocomplete", "d", "getPrimaryFormat", "setPrimaryFormat", "(Ljava/lang/String;)V", "primaryFormat", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", g.a, "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "getAffinityCalculationStrategy", "()Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "setAffinityCalculationStrategy", "(Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;)V", "affinityCalculationStrategy", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;Z)V", "format", "(Ljava/lang/String;Landroid/widget/EditText;)V", "(Ljava/lang/String;Landroid/widget/EditText;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Landroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;)V", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "Companion", "ValueListener", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public class MaskedTextChangedListener implements TextWatcher, View.OnFocusChangeListener {
    public static final Companion Companion = new Companion(null);
    public String a;
    public int b;
    public final WeakReference<EditText> c;
    @NotNull
    public String d;
    @NotNull
    public List<String> e;
    @NotNull
    public List<Notation> f;
    @NotNull
    public AffinityCalculationStrategy g;
    public boolean h;
    public boolean i;
    @Nullable
    public TextWatcher j;
    @Nullable
    public ValueListener k;
    public boolean l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJC\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\u000fJs\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$Companion;", "", "Landroid/widget/EditText;", "editText", "", "primaryFormat", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "valueListener", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "installOn", "(Landroid/widget/EditText;Ljava/lang/String;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "", "affineFormats", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "affinityCalculationStrategy", "(Landroid/widget/EditText;Ljava/lang/String;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "", "autocomplete", "autoskip", "Landroid/text/TextWatcher;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/widget/EditText;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZZLandroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, ValueListener valueListener, int i, Object obj) {
            if ((i & 4) != 0) {
                valueListener = null;
            }
            return companion.installOn(editText, str, valueListener);
        }

        @NotNull
        public final MaskedTextChangedListener installOn(@NotNull EditText editText, @NotNull String str, @Nullable ValueListener valueListener) {
            Intrinsics.checkParameterIsNotNull(editText, "editText");
            Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
            return installOn(editText, str, CollectionsKt__CollectionsKt.emptyList(), AffinityCalculationStrategy.WHOLE_STRING, valueListener);
        }

        public Companion(j jVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.redmadrobot.inputmask.MaskedTextChangedListener$Companion */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, List list, AffinityCalculationStrategy affinityCalculationStrategy, ValueListener valueListener, int i, Object obj) {
            if ((i & 4) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            if ((i & 8) != 0) {
                affinityCalculationStrategy = AffinityCalculationStrategy.WHOLE_STRING;
            }
            if ((i & 16) != 0) {
                valueListener = null;
            }
            return companion.installOn(editText, str, list, affinityCalculationStrategy, valueListener);
        }

        @NotNull
        public final MaskedTextChangedListener installOn(@NotNull EditText editText, @NotNull String str, @NotNull List<String> list, @NotNull AffinityCalculationStrategy affinityCalculationStrategy, @Nullable ValueListener valueListener) {
            Intrinsics.checkParameterIsNotNull(editText, "editText");
            Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
            Intrinsics.checkParameterIsNotNull(list, "affineFormats");
            Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "affinityCalculationStrategy");
            return installOn(editText, str, list, CollectionsKt__CollectionsKt.emptyList(), affinityCalculationStrategy, true, false, null, valueListener);
        }

        @NotNull
        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, List list, List list2, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, TextWatcher textWatcher, ValueListener valueListener, int i, Object obj) {
            return companion.installOn(editText, str, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 16) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : affinityCalculationStrategy, (i & 32) != 0 ? true : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : textWatcher, (i & 256) != 0 ? null : valueListener);
        }

        @NotNull
        public final MaskedTextChangedListener installOn(@NotNull EditText editText, @NotNull String str, @NotNull List<String> list, @NotNull List<Notation> list2, @NotNull AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
            Intrinsics.checkParameterIsNotNull(editText, "editText");
            Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
            Intrinsics.checkParameterIsNotNull(list, "affineFormats");
            Intrinsics.checkParameterIsNotNull(list2, "customNotations");
            Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "affinityCalculationStrategy");
            MaskedTextChangedListener maskedTextChangedListener = new MaskedTextChangedListener(str, list, list2, affinityCalculationStrategy, z, z2, editText, textWatcher, valueListener, false, 512, null);
            editText.addTextChangedListener(maskedTextChangedListener);
            editText.setOnFocusChangeListener(maskedTextChangedListener);
            return maskedTextChangedListener;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "", "", "maskFilled", "", "extractedValue", "formattedValue", "", "onTextChanged", "(ZLjava/lang/String;Ljava/lang/String;)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public interface ValueListener {
        void onTextChanged(boolean z, @NotNull String str, @NotNull String str2);
    }

    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, @NotNull List<Notation> list2, @NotNull AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(list2, "customNotations");
        Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "affinityCalculationStrategy");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
        this.d = str;
        this.e = list;
        this.f = list2;
        this.g = affinityCalculationStrategy;
        this.h = z;
        this.i = z2;
        this.j = textWatcher;
        this.k = valueListener;
        this.l = z3;
        this.a = "";
        this.c = new WeakReference<>(editText);
    }

    @Nullable
    public static /* synthetic */ Mask.Result setText$default(MaskedTextChangedListener maskedTextChangedListener, String str, Boolean bool, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bool = null;
            }
            return maskedTextChangedListener.setText(str, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
    }

    public final Mask a() {
        String str = this.d;
        List<Notation> list = this.f;
        if (this.l) {
            return RTLMask.Factory.getOrCreate(str, list);
        }
        return Mask.Factory.getOrCreate(str, list);
    }

    public final int acceptableTextLength() {
        return a().acceptableTextLength();
    }

    public final int acceptableValueLength() {
        return a().acceptableValueLength();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        EditText editText = this.c.get();
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
        if (editable != null) {
            editable.replace(0, editable.length(), this.a);
        }
        EditText editText2 = this.c.get();
        if (editText2 != null) {
            editText2.setSelection(this.b);
        }
        EditText editText3 = this.c.get();
        if (editText3 != null) {
            editText3.addTextChangedListener(this);
        }
        TextWatcher textWatcher = this.j;
        if (textWatcher != null) {
            textWatcher.afterTextChanged(editable);
        }
    }

    public final Mask b(CaretString caretString) {
        Mask mask;
        if (this.e.isEmpty()) {
            return a();
        }
        int calculateAffinityOfMask = this.g.calculateAffinityOfMask(a(), caretString);
        ArrayList arrayList = new ArrayList();
        for (String str : this.e) {
            List<Notation> list = this.f;
            if (this.l) {
                mask = RTLMask.Factory.getOrCreate(str, list);
            } else {
                mask = Mask.Factory.getOrCreate(str, list);
            }
            arrayList.add(new MaskedTextChangedListener$pickMask$MaskAffinity(mask, this.g.calculateAffinityOfMask(mask, caretString)));
        }
        if (arrayList.size() > 1) {
            t6.n.g.sortWith(arrayList, new Comparator<T>() { // from class: com.redmadrobot.inputmask.MaskedTextChangedListener$pickMask$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues(Integer.valueOf(t2.getAffinity()), Integer.valueOf(t.getAffinity()));
                }
            });
        }
        int i2 = -1;
        int i3 = 0;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (calculateAffinityOfMask >= ((MaskedTextChangedListener$pickMask$MaskAffinity) it.next()).getAffinity()) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 >= 0) {
            arrayList.add(i2, new MaskedTextChangedListener$pickMask$MaskAffinity(a(), calculateAffinityOfMask));
        } else {
            arrayList.add(new MaskedTextChangedListener$pickMask$MaskAffinity(a(), calculateAffinityOfMask));
        }
        return ((MaskedTextChangedListener$pickMask$MaskAffinity) CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList)).getMask();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
        TextWatcher textWatcher = this.j;
        if (textWatcher != null) {
            textWatcher.beforeTextChanged(charSequence, i2, i3, i4);
        }
    }

    @NotNull
    public final List<String> getAffineFormats() {
        return this.e;
    }

    @NotNull
    public final AffinityCalculationStrategy getAffinityCalculationStrategy() {
        return this.g;
    }

    public final boolean getAutocomplete() {
        return this.h;
    }

    public final boolean getAutoskip() {
        return this.i;
    }

    @NotNull
    public final List<Notation> getCustomNotations() {
        return this.f;
    }

    @Nullable
    public final TextWatcher getListener() {
        return this.j;
    }

    @NotNull
    public final String getPrimaryFormat() {
        return this.d;
    }

    public final boolean getRightToLeft() {
        return this.l;
    }

    @Nullable
    public final ValueListener getValueListener() {
        return this.k;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(@Nullable View view, boolean z) {
        String str;
        if (this.h && z) {
            EditText editText = this.c.get();
            Editable editable = null;
            Editable text = editText != null ? editText.getText() : null;
            if (text == null) {
                Intrinsics.throwNpe();
            }
            if (text.length() == 0) {
                str = "";
            } else {
                EditText editText2 = this.c.get();
                if (editText2 != null) {
                    editable = editText2.getText();
                }
                str = String.valueOf(editable);
            }
            CaretString caretString = new CaretString(str, str.length(), new CaretString.CaretGravity.FORWARD(this.h));
            Mask.Result apply = b(caretString).apply(caretString);
            this.a = apply.getFormattedText().getString();
            this.b = apply.getFormattedText().getCaretPosition();
            EditText editText3 = this.c.get();
            if (editText3 != null) {
                editText3.setText(this.a);
            }
            EditText editText4 = this.c.get();
            if (editText4 != null) {
                editText4.setSelection(apply.getFormattedText().getCaretPosition());
            }
            ValueListener valueListener = this.k;
            if (valueListener != null) {
                valueListener.onTextChanged(apply.getComplete(), apply.getExtractedValue(), this.a);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        boolean z = false;
        boolean z2 = i3 > 0 && i4 == 0;
        boolean z3 = z2 ? false : this.h;
        if (z2) {
            z = this.i;
        }
        CaretString.CaretGravity backward = z2 ? new CaretString.CaretGravity.BACKWARD(z) : new CaretString.CaretGravity.FORWARD(z3);
        if (!z2) {
            i2 += i4;
        }
        CaretString caretString = new CaretString(charSequence.toString(), i2, backward);
        Mask.Result apply = b(caretString).apply(caretString);
        this.a = apply.getFormattedText().getString();
        this.b = apply.getFormattedText().getCaretPosition();
        ValueListener valueListener = this.k;
        if (valueListener != null) {
            valueListener.onTextChanged(apply.getComplete(), apply.getExtractedValue(), this.a);
        }
    }

    @NotNull
    public final String placeholder() {
        return a().placeholder();
    }

    public final void setAffineFormats(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.e = list;
    }

    public final void setAffinityCalculationStrategy(@NotNull AffinityCalculationStrategy affinityCalculationStrategy) {
        Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "<set-?>");
        this.g = affinityCalculationStrategy;
    }

    public final void setAutocomplete(boolean z) {
        this.h = z;
    }

    public final void setAutoskip(boolean z) {
        this.i = z;
    }

    public final void setCustomNotations(@NotNull List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f = list;
    }

    public final void setListener(@Nullable TextWatcher textWatcher) {
        this.j = textWatcher;
    }

    public final void setPrimaryFormat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.d = str;
    }

    public final void setRightToLeft(boolean z) {
        this.l = z;
    }

    @Nullable
    public Mask.Result setText(@NotNull String str, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        EditText editText = this.c.get();
        if (editText == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(editText, "it");
        Mask.Result text = setText(str, editText, bool);
        this.a = text.getFormattedText().getString();
        this.b = text.getFormattedText().getCaretPosition();
        ValueListener valueListener = this.k;
        if (valueListener != null) {
            valueListener.onTextChanged(text.getComplete(), text.getExtractedValue(), this.a);
        }
        return text;
    }

    public final void setValueListener(@Nullable ValueListener valueListener) {
        this.k = valueListener;
    }

    public final int totalTextLength() {
        return a().totalTextLength();
    }

    public final int totalValueLength() {
        return a().totalValueLength();
    }

    @NotNull
    public static /* synthetic */ Mask.Result setText$default(MaskedTextChangedListener maskedTextChangedListener, String str, EditText editText, Boolean bool, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                bool = null;
            }
            return maskedTextChangedListener.setText(str, editText, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaskedTextChangedListener(String str, List list, List list2, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, EditText editText, TextWatcher textWatcher, ValueListener valueListener, boolean z3, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i2 & 8) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : affinityCalculationStrategy, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? false : z2, editText, (i2 & 128) != 0 ? null : textWatcher, (i2 & 256) != 0 ? null : valueListener, (i2 & 512) != 0 ? false : z3);
    }

    @NotNull
    public Mask.Result setText(@NotNull String str, @NotNull EditText editText, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
        CaretString caretString = new CaretString(str, str.length(), new CaretString.CaretGravity.FORWARD(bool != null ? bool.booleanValue() : this.h));
        Mask.Result apply = b(caretString).apply(caretString);
        editText.setText(apply.getFormattedText().getString());
        editText.setSelection(apply.getFormattedText().getCaretPosition());
        return apply;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull EditText editText) {
        this(str, editText, (ValueListener) null);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull EditText editText, @Nullable ValueListener valueListener) {
        this(str, editText, (TextWatcher) null, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
        this(str, true, editText, textWatcher, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, boolean z, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
        this(str, CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), AffinityCalculationStrategy.WHOLE_STRING, z, false, editText, textWatcher, valueListener, false, 512, null);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, @NotNull EditText editText) {
        this(str, list, editText, (ValueListener) null);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, @NotNull EditText editText, @Nullable ValueListener valueListener) {
        this(str, list, editText, (TextWatcher) null, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
        this(str, list, true, editText, textWatcher, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, boolean z, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
        this(str, list, AffinityCalculationStrategy.WHOLE_STRING, z, editText, textWatcher, valueListener);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(@NotNull String str, @NotNull List<String> list, @NotNull AffinityCalculationStrategy affinityCalculationStrategy, boolean z, @NotNull EditText editText, @Nullable TextWatcher textWatcher, @Nullable ValueListener valueListener) {
        this(str, list, CollectionsKt__CollectionsKt.emptyList(), affinityCalculationStrategy, z, false, editText, textWatcher, valueListener, false, 512, null);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "affinityCalculationStrategy");
        Intrinsics.checkParameterIsNotNull(editText, AnalyticFieldsName.field);
    }
}
