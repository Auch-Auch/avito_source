package com.avito.android.lib.design.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelTextDivider;", "Landroid/widget/FrameLayout;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class WheelTextDivider extends FrameLayout {
    @NotNull
    public final String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WheelTextDivider(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = str;
        LayoutInflater.from(context).inflate(R.layout.design_picker_wheel_text_divider, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wheelDividerText);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.wheelDividerText)");
        ((TextView) findViewById).setText(str);
    }

    @NotNull
    public final String getText() {
        return this.a;
    }
}
