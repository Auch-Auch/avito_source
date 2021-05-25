package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.util.Patterns;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001:\u00012BM\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JZ\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0012\u001a\u00020\u00052\b\b\u0003\u0010\u0013\u001a\u00020\u00052\b\b\u0003\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010\u0007R'\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0011¨\u00063"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "", "", "isValid", "()Ljava/lang/String;", "", "component1", "()I", "component2", "component3", "Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "component4", "()Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "component5", "Lkotlin/Function1;", "", "component6", "()Lkotlin/jvm/functions/Function1;", "titleResId", "subtitleResId", "iconResId", "type", "value", "onClick", "copy", "(IIILcom/sumsub/sns/core/data/model/SNSSupportItem$Type;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getSubtitleResId", AuthSource.SEND_ABUSE, "getTitleResId", "d", "Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "getType", "e", "Ljava/lang/String;", "getValue", "c", "getIconResId", "f", "Lkotlin/jvm/functions/Function1;", "getOnClick", "<init>", "(IIILcom/sumsub/sns/core/data/model/SNSSupportItem$Type;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Type", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSupportItem {
    public final int a;
    public final int b;
    public final int c;
    @NotNull
    public final Type d;
    @NotNull
    public final String e;
    @Nullable
    public final Function1<SNSSupportItem, Unit> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Url", "Email", "Custom", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        Url,
        Email,
        Custom
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super com.sumsub.sns.core.data.model.SNSSupportItem, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SNSSupportItem(@StringRes int i, @StringRes int i2, @DrawableRes int i3, @NotNull Type type, @NotNull String str, @Nullable Function1<? super SNSSupportItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = type;
        this.e = str;
        this.f = function1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.sumsub.sns.core.data.model.SNSSupportItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SNSSupportItem copy$default(SNSSupportItem sNSSupportItem, int i, int i2, int i3, Type type, String str, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sNSSupportItem.a;
        }
        if ((i4 & 2) != 0) {
            i2 = sNSSupportItem.b;
        }
        if ((i4 & 4) != 0) {
            i3 = sNSSupportItem.c;
        }
        if ((i4 & 8) != 0) {
            type = sNSSupportItem.d;
        }
        if ((i4 & 16) != 0) {
            str = sNSSupportItem.e;
        }
        if ((i4 & 32) != 0) {
            function1 = sNSSupportItem.f;
        }
        return sNSSupportItem.copy(i, i2, i3, type, str, function1);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final Type component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final Function1<SNSSupportItem, Unit> component6() {
        return this.f;
    }

    @NotNull
    public final SNSSupportItem copy(@StringRes int i, @StringRes int i2, @DrawableRes int i3, @NotNull Type type, @NotNull String str, @Nullable Function1<? super SNSSupportItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        return new SNSSupportItem(i, i2, i3, type, str, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSSupportItem)) {
            return false;
        }
        SNSSupportItem sNSSupportItem = (SNSSupportItem) obj;
        return this.a == sNSSupportItem.a && this.b == sNSSupportItem.b && this.c == sNSSupportItem.c && Intrinsics.areEqual(this.d, sNSSupportItem.d) && Intrinsics.areEqual(this.e, sNSSupportItem.e) && Intrinsics.areEqual(this.f, sNSSupportItem.f);
    }

    public final int getIconResId() {
        return this.c;
    }

    @Nullable
    public final Function1<SNSSupportItem, Unit> getOnClick() {
        return this.f;
    }

    public final int getSubtitleResId() {
        return this.b;
    }

    public final int getTitleResId() {
        return this.a;
    }

    @NotNull
    public final Type getType() {
        return this.d;
    }

    @NotNull
    public final String getValue() {
        return this.e;
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        Type type = this.d;
        int i2 = 0;
        int hashCode = (i + (type != null ? type.hashCode() : 0)) * 31;
        String str = this.e;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Function1<SNSSupportItem, Unit> function1 = this.f;
        if (function1 != null) {
            i2 = function1.hashCode();
        }
        return hashCode2 + i2;
    }

    @Nullable
    public final String isValid() {
        if (this.a <= 0) {
            return this + ". Invalid title";
        } else if (this.b <= 0) {
            return this + ". Invalid subtitle";
        } else if (this.c <= 0) {
            return this + ". Invalid icon";
        } else {
            if ((this.e.length() == 0) || m.isBlank(this.e)) {
                return this + ". Value must not be empty or blank.";
            }
            int ordinal = this.d.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    } else if (this.f != null) {
                        return null;
                    } else {
                        return this + ". You have to implement your own onClick callback if you want to use a Custom type.";
                    }
                } else if (Patterns.EMAIL_ADDRESS.matcher(this.e).matches()) {
                    return null;
                } else {
                    return this + ". Invalid email format";
                }
            } else if (Patterns.WEB_URL.matcher(this.e).matches()) {
                return null;
            } else {
                return this + ". Invalid url format";
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SNSSupportItem(titleResId=");
        L.append(this.a);
        L.append(", subtitleResId=");
        L.append(this.b);
        L.append(", iconResId=");
        L.append(this.c);
        L.append(", type=");
        L.append(this.d);
        L.append(", value=");
        L.append(this.e);
        L.append(", onClick=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSSupportItem(int i, int i2, int i3, Type type, String str, Function1 function1, int i4, j jVar) {
        this(i, i2, i3, type, str, (i4 & 32) != 0 ? null : function1);
    }
}
