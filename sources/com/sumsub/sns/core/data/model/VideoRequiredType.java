package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.webrtc.PeerConnectionFactory;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/data/model/VideoRequiredType;", "", "", "toString-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/String;)I", "hashCode", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "equals", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "constructor-impl", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
@JvmInline
public final class VideoRequiredType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String b = m223constructorimpl("liveness");
    @NotNull
    public static final String c = m223constructorimpl("enabled");
    @NotNull
    public static final String d = m223constructorimpl("disabled");
    @NotNull
    public static final String e = m223constructorimpl("photoRequired");
    @NotNull
    public static final String f = m223constructorimpl("passiveLiveness");
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/data/model/VideoRequiredType$Companion;", "", "Lcom/sumsub/sns/core/data/model/VideoRequiredType;", PeerConnectionFactory.TRIAL_ENABLED, "Ljava/lang/String;", "getEnabled-u2aduso", "()Ljava/lang/String;", "Liveness", "getLiveness-u2aduso", "PassiveLiveness", "getPassiveLiveness-u2aduso", "PhotoRequired", "getPhotoRequired-u2aduso", "Disabled", "getDisabled-u2aduso", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        /* renamed from: getDisabled-u2aduso */
        public final String m229getDisabledu2aduso() {
            return VideoRequiredType.d;
        }

        @NotNull
        /* renamed from: getEnabled-u2aduso */
        public final String m230getEnabledu2aduso() {
            return VideoRequiredType.c;
        }

        @NotNull
        /* renamed from: getLiveness-u2aduso */
        public final String m231getLivenessu2aduso() {
            return VideoRequiredType.b;
        }

        @NotNull
        /* renamed from: getPassiveLiveness-u2aduso */
        public final String m232getPassiveLivenessu2aduso() {
            return VideoRequiredType.f;
        }

        @NotNull
        /* renamed from: getPhotoRequired-u2aduso */
        public final String m233getPhotoRequiredu2aduso() {
            return VideoRequiredType.e;
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ VideoRequiredType(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = str;
    }

    @NotNull
    /* renamed from: constructor-impl */
    public static String m223constructorimpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return str;
    }

    /* renamed from: equals-impl */
    public static boolean m224equalsimpl(String str, Object obj) {
        return (obj instanceof VideoRequiredType) && Intrinsics.areEqual(str, ((VideoRequiredType) obj).m228unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m225equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl */
    public static int m226hashCodeimpl(String str) {
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl */
    public static String m227toStringimpl(String str) {
        return a.e3("VideoRequiredType(value=", str, ")");
    }

    public boolean equals(Object obj) {
        return m224equalsimpl(this.a, obj);
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        return m226hashCodeimpl(this.a);
    }

    public String toString() {
        return m227toStringimpl(this.a);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ String m228unboximpl() {
        return this.a;
    }
}
