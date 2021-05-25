package com.avito.android.messenger.channels.mvi.common.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/AbstractMviEvent;", "", "", "toString", "()Ljava/lang/String;", "getName", "name", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getParamsString", "paramsString", "", "eventId", "J", "<init>", "(J)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractMviEvent {
    @NotNull
    public final String a = "";
    @JvmField
    public final long eventId;

    public AbstractMviEvent(long j) {
        this.eventId = j;
    }

    @NotNull
    public final String getName() {
        if (getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a.K0(this, sb, '#');
            sb.append(this.eventId);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        a.K0(this, sb2, '#');
        sb2.append(this.eventId);
        sb2.append(' ');
        sb2.append(getParamsString());
        return sb2.toString();
    }

    @NotNull
    public String getParamsString() {
        return this.a;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder L = a.L("Event.");
        if (getParamsString().length() == 0) {
            StringBuilder sb = new StringBuilder();
            a.K0(this, sb, '#');
            sb.append(this.eventId);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            a.K0(this, sb2, '#');
            sb2.append(this.eventId);
            sb2.append(' ');
            sb2.append(getParamsString());
            str = sb2.toString();
        }
        L.append(str);
        return L.toString();
    }
}
