package com.avito.android.tariff.edit_info.viewmodel;

import a2.g.r.g;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001By\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR!\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006¨\u0006,"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/BottomSheetParams;", "", "", "d", "Ljava/lang/String;", "getSecondaryButtonText", "()Ljava/lang/String;", "secondaryButtonText", "", g.a, "I", "getPrimaryButtonStyle", "()I", "primaryButtonStyle", "Lkotlin/Function1;", "", "f", "Lkotlin/jvm/functions/Function1;", "getSecondaryAction", "()Lkotlin/jvm/functions/Function1;", "secondaryAction", "c", "getPrimaryButtonText", "primaryButtonText", "h", "Ljava/lang/Integer;", "getPrimaryButtonDrawable", "()Ljava/lang/Integer;", "primaryButtonDrawable", "", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDescription", "()Ljava/util/List;", "description", "e", "getPrimaryAction", "primaryAction", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetParams {
    @NotNull
    public final String a;
    @Nullable
    public final List<AttributedText> b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Function1<Unit, Unit> e;
    @Nullable
    public final Function1<Unit, Unit> f;
    public final int g;
    @Nullable
    public final Integer h;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetParams(@NotNull String str, @Nullable List<AttributedText> list, @Nullable String str2, @Nullable String str3, @Nullable Function1<? super Unit, Unit> function1, @Nullable Function1<? super Unit, Unit> function12, int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = str3;
        this.e = function1;
        this.f = function12;
        this.g = i;
        this.h = num;
    }

    @Nullable
    public final List<AttributedText> getDescription() {
        return this.b;
    }

    @Nullable
    public final Function1<Unit, Unit> getPrimaryAction() {
        return this.e;
    }

    @Nullable
    public final Integer getPrimaryButtonDrawable() {
        return this.h;
    }

    public final int getPrimaryButtonStyle() {
        return this.g;
    }

    @Nullable
    public final String getPrimaryButtonText() {
        return this.c;
    }

    @Nullable
    public final Function1<Unit, Unit> getSecondaryAction() {
        return this.f;
    }

    @Nullable
    public final String getSecondaryButtonText() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetParams(String str, List list, String str2, String str3, Function1 function1, Function1 function12, int i, Integer num, int i2, j jVar) {
        this(str, list, str2, str3, (i2 & 16) != 0 ? null : function1, (i2 & 32) != 0 ? null : function12, (i2 & 64) != 0 ? R.attr.buttonPrimaryLarge : i, (i2 & 128) != 0 ? null : num);
    }
}
