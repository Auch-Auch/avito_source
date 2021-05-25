package com.sumsub.sns.prooface;

import androidx.annotation.Keep;
import com.sumsub.sns.core.SNSModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/prooface/SNSProoface;", "Lcom/sumsub/sns/core/SNSModule;", "", "isDebug", "()Z", "", "feature", "I", "isShowSettingsDialog", "<init>", "(I)V", "Companion", "idensic-mobile-sdk-prooface_release"}, k = 1, mv = {1, 4, 2})
public final class SNSProoface extends SNSModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Keep
    public static final int FEATURE_FACE_DETECTION_DEBUG = 1;
    public static final int FEATURE_FACE_SHOW_SETTINGS = 2;
    private final int feature;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/prooface/SNSProoface$Companion;", "", "", "FEATURE_FACE_DETECTION_DEBUG", "I", "FEATURE_FACE_SHOW_SETTINGS", "<init>", "()V", "idensic-mobile-sdk-prooface_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SNSProoface() {
        this(0, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSProoface(int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final boolean isDebug() {
        return (this.feature & 1) != 0;
    }

    public final boolean isShowSettingsDialog() {
        return (this.feature & 2) != 0;
    }

    public SNSProoface(int i) {
        super("Advanced 3D Face Scanning");
        this.feature = i;
    }
}
