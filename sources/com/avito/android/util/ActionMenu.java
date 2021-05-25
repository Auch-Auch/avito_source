package com.avito.android.util;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0018\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/util/ActionMenu;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "Ljava/lang/Integer;", "getDrawableId", "()Ljava/lang/Integer;", "drawableId", "d", "getTintColorAttr", "tintColorAttr", "e", "getContentDescriptionId", "contentDescriptionId", AuthSource.BOOKING_ORDER, "I", "getMode", "()I", "mode", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ActionMenu {
    @NotNull
    public final String a;
    public final int b;
    @Nullable
    public final Integer c;
    @Nullable
    public final Integer d;
    @Nullable
    public final Integer e;

    public ActionMenu(@NotNull String str, int i, @DrawableRes @Nullable Integer num, @AttrRes @Nullable Integer num2, @StringRes @Nullable Integer num3) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = i;
        this.c = num;
        this.d = num2;
        this.e = num3;
    }

    @Nullable
    public final Integer getContentDescriptionId() {
        return this.e;
    }

    @Nullable
    public final Integer getDrawableId() {
        return this.c;
    }

    public final int getMode() {
        return this.b;
    }

    @Nullable
    public final Integer getTintColorAttr() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionMenu(String str, int i, Integer num, Integer num2, Integer num3, int i2, j jVar) {
        this(str, i, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3);
    }
}
