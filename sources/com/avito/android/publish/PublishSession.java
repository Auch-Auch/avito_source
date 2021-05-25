package com.avito.android.publish;

import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish/PublishSession;", "", "<init>", "()V", "StepType", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishSession {
    @NotNull
    public static final PublishSession INSTANCE = new PublishSession();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/PublishSession$StepType;", "", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "type", "", "c", "Z", "getSendToAnalytics", "()Z", "sendToAnalytics", AuthSource.BOOKING_ORDER, "getSubtype", "subtype", "PARAMS", "SELECT", "WIZARD", "VIN", "PREMODERATION", "CONTACTS", "SUGGEST_CATEGORY", "REQUEST_PRETEND", "REQUEST_STEPS", "REQUEST_PUBLISH", "REQUEST_EDIT", "UNKNOWN", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum StepType {
        PARAMS("params", null, true, 2),
        SELECT("select", null, true, 2),
        WIZARD("wizard", null, true, 2),
        VIN("vin", null, true, 2),
        PREMODERATION("premoderation", null, false, 6),
        CONTACTS("contacts", null, false, 6),
        SUGGEST_CATEGORY("suggestCategory", null, true, 2),
        REQUEST_PRETEND("request", "pretend", false, 4),
        REQUEST_STEPS("request", "steps", false, 4),
        REQUEST_PUBLISH("request", PhotoUploadKt.UPLOAD_TYPE_PUBLISH, false, 4),
        REQUEST_EDIT("request", "edit", false, 4),
        UNKNOWN("unknown", null, false, 6);
        
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        public final boolean c;

        /* access modifiers changed from: public */
        StepType(String str, String str2, boolean z, int i) {
            str2 = (i & 2) != 0 ? "" : str2;
            z = (i & 4) != 0 ? false : z;
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public final boolean getSendToAnalytics() {
            return this.c;
        }

        @NotNull
        public final String getSubtype() {
            return this.b;
        }

        @NotNull
        public final String getType() {
            return this.a;
        }

        @Override // java.lang.Enum, java.lang.Object
        @NotNull
        public String toString() {
            if (this.b.length() == 0) {
                return this.a;
            }
            return this.a + '-' + this.b;
        }
    }
}
