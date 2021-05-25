package com.avito.android.authorization.phone_proving.view;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@B\u001b\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\b?\u0010CJ7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0017J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010'R*\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020+8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010'¨\u0006D"}, d2 = {"Lcom/avito/android/authorization/phone_proving/view/HintEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/text/TextWatcher;", "", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "s", Tracker.Events.CREATIVE_START, "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "Landroid/text/Editable;", "editable", "afterTextChanged", "(Landroid/text/Editable;)V", "before", "onTextChanged", AuthSource.SEND_ABUSE, "()V", "j", "I", "actionPosition", "i", "characterAction", "", g.a, "F", "numberSize", "e", "textOffset", "", "value", "d", "Ljava/lang/String;", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "hintText", "Landroid/graphics/Paint;", "h", "Landroid/graphics/Paint;", "paint", "k", "Z", "ignoreOnPhoneChange", "f", "spaceSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class HintEditText extends AppCompatEditText implements TextWatcher {
    @NotNull
    public String d;
    public float e;
    public float f;
    public float g;
    public final Paint h;
    public int i;
    public int j;
    public boolean k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HintEditText(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.e = length() > 0 ? getPaint().measureText(getText(), 0, length()) : 0.0f;
        this.f = getPaint().measureText(" ");
        this.g = getPaint().measureText("0");
        invalidate();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(editable, "editable");
        if (!this.k) {
            int selectionStart = getSelectionStart();
            String obj = editable.toString();
            if (this.i == 3) {
                StringBuilder sb = new StringBuilder();
                int i4 = this.j;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring = obj.substring(0, i4);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                String substring2 = obj.substring(this.j + 1, obj.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                obj = sb.toString();
                selectionStart--;
            }
            StringBuilder sb2 = new StringBuilder(obj.length());
            StringBuilder sb3 = new StringBuilder();
            int length = obj.length();
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = obj.charAt(i5);
                if (Character.isDigit(charAt)) {
                    sb3.append(charAt);
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "filterTo(StringBuilder(), predicate).toString()");
            sb2.append(sb4);
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(str.length….filter { it.isDigit() })");
            this.k = true;
            String str = this.d;
            int i6 = 0;
            while (true) {
                if (i6 >= sb2.length()) {
                    break;
                } else if (i6 < str.length()) {
                    if (str.charAt(i6) == ' ') {
                        sb2.insert(i6, ' ');
                        i6++;
                        if (!(selectionStart != i6 || (i3 = this.i) == 2 || i3 == 3)) {
                            selectionStart++;
                        }
                    }
                    i6++;
                } else {
                    sb2.insert(i6, ' ');
                    if (selectionStart == i6 + 1 && (i2 = this.i) != 2 && i2 != 3) {
                        selectionStart++;
                    }
                }
            }
            setText(sb2);
            if (selectionStart >= 0) {
                if (selectionStart > length()) {
                    selectionStart = length();
                }
                setSelection(selectionStart);
            }
            a();
            this.k = false;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (i3 == 0 && i4 == 1) {
            this.i = 1;
        } else if (i3 != 1 || i4 != 0) {
            this.i = -1;
        } else if (charSequence.charAt(i2) != ' ' || i2 <= 0) {
            this.i = 2;
        } else {
            this.i = 3;
            this.j = i2 - 1;
        }
    }

    @NotNull
    public final String getHintText() {
        return this.d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        float f2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (length() < this.d.length()) {
            float f3 = this.e;
            int length = this.d.length();
            for (int length2 = length(); length2 < length; length2++) {
                if (this.d.charAt(length2) == ' ') {
                    f2 = this.f;
                } else {
                    canvas.drawCircle((this.g / ((float) 2)) + f3, ((float) getMeasuredHeight()) / 2.0f, this.g / ((float) 4), this.h);
                    f2 = this.g;
                }
                f3 += f2;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a();
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public final void setHintText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.d = str;
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HintEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = "";
        Paint paint = new Paint(1);
        this.h = paint;
        this.i = -1;
        addTextChangedListener(this);
        paint.setColor(getCurrentHintTextColor());
        CharSequence hint = getHint();
        setHintText((hint == null || (str = hint.toString()) == null) ? "" : str);
        setHint("");
    }
}
