package net.gotev.uploadservice.placeholders;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/placeholders/Placeholder;", "", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ElapsedTime", "UploadRate", "Progress", "UploadedFiles", "RemainingFiles", "TotalFiles", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public enum Placeholder {
    ElapsedTime("[[ELAPSED_TIME]]"),
    UploadRate("[[UPLOAD_RATE]]"),
    Progress("[[PROGRESS]]"),
    UploadedFiles("[[UPLOADED_FILES]]"),
    RemainingFiles("[[REMAINING_FILES]]"),
    TotalFiles("[[TOTAL_FILES]]");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    Placeholder(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.a;
    }
}
