package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b@\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0012\u0012\u0006\u0010\u001b\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\nJ\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0016\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/core/data/model/IdentityType;", "", "Landroid/content/Context;", "context", "", "getTitle-impl", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/CharSequence;", "getTitle", "", "toString-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/String;)I", "hashCode", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "equals", "getFrameId-impl", "frameId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "constructor-impl", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
@JvmInline
public final class IdentityType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String b = m202constructorimpl("PASSPORT");
    @NotNull
    public static final String c = m202constructorimpl("DRIVERS");
    @NotNull
    public static final String d = m202constructorimpl("ID_CARD");
    @NotNull
    public static final String e = m202constructorimpl("RESIDENCE_PERMIT");
    @NotNull
    public static final String f = m202constructorimpl("OTHER");
    @NotNull
    public static final String g = m202constructorimpl(DocumentType.TYPE_SELFIE);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/data/model/IdentityType$Companion;", "", "Lcom/sumsub/sns/core/data/model/IdentityType;", "Other", "Ljava/lang/String;", "getOther-Gm96dUI", "()Ljava/lang/String;", "Drivers", "getDrivers-Gm96dUI", "IDCard", "getIDCard-Gm96dUI", "Selfie", "getSelfie-Gm96dUI", "Passport", "getPassport-Gm96dUI", "ResidencePermit", "getResidencePermit-Gm96dUI", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        /* renamed from: getDrivers-Gm96dUI */
        public final String m210getDriversGm96dUI() {
            return IdentityType.c;
        }

        @NotNull
        /* renamed from: getIDCard-Gm96dUI */
        public final String m211getIDCardGm96dUI() {
            return IdentityType.d;
        }

        @NotNull
        /* renamed from: getOther-Gm96dUI */
        public final String m212getOtherGm96dUI() {
            return IdentityType.f;
        }

        @NotNull
        /* renamed from: getPassport-Gm96dUI */
        public final String m213getPassportGm96dUI() {
            return IdentityType.b;
        }

        @NotNull
        /* renamed from: getResidencePermit-Gm96dUI */
        public final String m214getResidencePermitGm96dUI() {
            return IdentityType.e;
        }

        @NotNull
        /* renamed from: getSelfie-Gm96dUI */
        public final String m215getSelfieGm96dUI() {
            return IdentityType.g;
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ IdentityType(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = str;
    }

    @NotNull
    /* renamed from: constructor-impl */
    public static String m202constructorimpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return str;
    }

    /* renamed from: equals-impl */
    public static boolean m203equalsimpl(String str, Object obj) {
        return (obj instanceof IdentityType) && Intrinsics.areEqual(str, ((IdentityType) obj).m209unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m204equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: getFrameId-impl */
    public static final int m205getFrameIdimpl(String str) {
        return R.drawable.sns_bg_utility_bill;
    }

    @NotNull
    /* renamed from: getTitle-impl */
    public static final CharSequence m206getTitleimpl(String str, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(SNSConstants.Resources.Key.IDENTITY_TITLE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return ExtensionsKt.asHtml(ExtensionsKt.getStringResource(context, format, str));
    }

    /* renamed from: hashCode-impl */
    public static int m207hashCodeimpl(String str) {
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl */
    public static String m208toStringimpl(String str) {
        return a.e3("IdentityType(value=", str, ")");
    }

    public boolean equals(Object obj) {
        return m203equalsimpl(this.a, obj);
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        return m207hashCodeimpl(this.a);
    }

    public String toString() {
        return m208toStringimpl(this.a);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ String m209unboximpl() {
        return this.a;
    }
}
