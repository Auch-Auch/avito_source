package com.avito.android.publish.input_vin;

import android.content.res.Resources;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "", "", "c", "Ljava/lang/String;", "getConnectionError", "()Ljava/lang/String;", "connectionError", AuthSource.BOOKING_ORDER, "getWarningsOnFlowFinishNotification", "warningsOnFlowFinishNotification", AuthSource.SEND_ABUSE, "getFixErrors", "fixErrors", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InputVinResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    @Inject
    public InputVinResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.fix_errors);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.fix_errors)");
        this.a = string;
        String string2 = resources.getString(R.string.has_finish_on_flow_warnings);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_finish_on_flow_warnings)");
        this.b = string2;
        String string3 = resources.getString(com.avito.android.ui_components.R.string.connection_problem);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(ui_R…tring.connection_problem)");
        this.c = string3;
    }

    @NotNull
    public final String getConnectionError() {
        return this.c;
    }

    @NotNull
    public final String getFixErrors() {
        return this.a;
    }

    @NotNull
    public final String getWarningsOnFlowFinishNotification() {
        return this.b;
    }
}
