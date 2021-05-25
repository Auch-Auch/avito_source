package com.avito.android.autodeal_details;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/autodeal_details/WebViewAction;", "", "<init>", "()V", "CloseScreen", "ShowToast", "Lcom/avito/android/autodeal_details/WebViewAction$CloseScreen;", "Lcom/avito/android/autodeal_details/WebViewAction$ShowToast;", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class WebViewAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/autodeal_details/WebViewAction$CloseScreen;", "Lcom/avito/android/autodeal_details/WebViewAction;", "<init>", "()V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class CloseScreen extends WebViewAction {
        public CloseScreen() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/autodeal_details/WebViewAction$ShowToast;", "Lcom/avito/android/autodeal_details/WebViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowToast extends WebViewAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowToast(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = str;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }
    }

    public WebViewAction() {
    }

    public WebViewAction(j jVar) {
    }
}
