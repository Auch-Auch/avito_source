package com.avito.android.publish.details;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006$"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "", "", "c", "Ljava/lang/String;", "getNetworkError", "()Ljava/lang/String;", "networkError", "f", "getNoCarDialogText", "noCarDialogText", "i", "getHelpCenterHost", "helpCenterHost", AuthSource.SEND_ABUSE, "getFixErrors", "fixErrors", g.a, "getWrite", "write", AuthSource.BOOKING_ORDER, "getCancel", "cancel", "e", "getWarningsOnFlowFinishNotification", "warningsOnFlowFinishNotification", "h", "getVideoLoadingError", "videoLoadingError", "d", "getImageUploadError", "imageUploadError", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public class PublishDetailsResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @NotNull
    public final String i = "support.avito.ru";

    public PublishDetailsResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.fix_errors);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.fix_errors)");
        this.a = string;
        String string2 = resources.getString(com.avito.android.ui_components.R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.cancel)");
        this.b = string2;
        String string3 = resources.getString(com.avito.android.remote.R.string.network_unavailable_snack);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(remo…etwork_unavailable_snack)");
        this.c = string3;
        String string4 = resources.getString(R.string.image_upload_is_not_finished);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…e_upload_is_not_finished)");
        this.d = string4;
        String string5 = resources.getString(R.string.has_finish_on_flow_warnings);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…_finish_on_flow_warnings)");
        this.e = string5;
        String string6 = resources.getString(R.string.write_no_car_text);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.string.write_no_car_text)");
        this.f = string6;
        String string7 = resources.getString(R.string.write_no_car_button_positive);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.st…e_no_car_button_positive)");
        this.g = string7;
        String string8 = resources.getString(R.string.video_loading_error);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.string.video_loading_error)");
        this.h = string8;
    }

    @NotNull
    public String getCancel() {
        return this.b;
    }

    @NotNull
    public String getFixErrors() {
        return this.a;
    }

    @NotNull
    public String getHelpCenterHost() {
        return this.i;
    }

    @NotNull
    public String getImageUploadError() {
        return this.d;
    }

    @NotNull
    public String getNetworkError() {
        return this.c;
    }

    @NotNull
    public String getNoCarDialogText() {
        return this.f;
    }

    @NotNull
    public String getVideoLoadingError() {
        return this.h;
    }

    @NotNull
    public String getWarningsOnFlowFinishNotification() {
        return this.e;
    }

    @NotNull
    public String getWrite() {
        return this.g;
    }
}
