package com.avito.android.epress_cv.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult;", "", "<init>", "()V", "NeedPhoneVerification", "Ok", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$NeedPhoneVerification;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public abstract class CreateExpressCvResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$NeedPhoneVerification;", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    public static final class NeedPhoneVerification extends CreateExpressCvResult {
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final DeepLink deepLink;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NeedPhoneVerification(@NotNull DeepLink deepLink2) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.deepLink = deepLink2;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends CreateExpressCvResult {
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final DeepLink deepLink;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull DeepLink deepLink2) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.deepLink = deepLink2;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }
    }

    public CreateExpressCvResult() {
    }

    public CreateExpressCvResult(j jVar) {
    }
}
