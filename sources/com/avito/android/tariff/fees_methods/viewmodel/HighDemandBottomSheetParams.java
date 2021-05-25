package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/HighDemandBottomSheetParams;", "", "", "c", "Ljava/lang/String;", "getPrimaryButtonText", "()Ljava/lang/String;", "primaryButtonText", AuthSource.SEND_ABUSE, "getTitle", "title", "d", "getSecondaryButtonText", "secondaryButtonText", "Lkotlin/Function1;", "", "e", "Lkotlin/jvm/functions/Function1;", "getPrimaryAction", "()Lkotlin/jvm/functions/Function1;", "primaryAction", "f", "getSecondaryAction", "secondaryAction", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class HighDemandBottomSheetParams {
    @Nullable
    public final String a;
    @Nullable
    public final AttributedText b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final Function1<Unit, Unit> e;
    @NotNull
    public final Function1<Unit, Unit> f;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public HighDemandBottomSheetParams(@Nullable String str, @Nullable AttributedText attributedText, @Nullable String str2, @Nullable String str3, @NotNull Function1<? super Unit, Unit> function1, @NotNull Function1<? super Unit, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "primaryAction");
        Intrinsics.checkNotNullParameter(function12, "secondaryAction");
        this.a = str;
        this.b = attributedText;
        this.c = str2;
        this.d = str3;
        this.e = function1;
        this.f = function12;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.b;
    }

    @NotNull
    public final Function1<Unit, Unit> getPrimaryAction() {
        return this.e;
    }

    @Nullable
    public final String getPrimaryButtonText() {
        return this.c;
    }

    @NotNull
    public final Function1<Unit, Unit> getSecondaryAction() {
        return this.f;
    }

    @Nullable
    public final String getSecondaryButtonText() {
        return this.d;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }
}
