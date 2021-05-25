package com.avito.android.remote.model.adverts;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.PretendResult;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "", "<init>", "()V", "InputErrors", "NeedSupport", "Ok", "Lcom/avito/android/remote/model/adverts/EditAdvertResult$Ok;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult$InputErrors;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult$NeedSupport;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class EditAdvertResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/adverts/EditAdvertResult$InputErrors;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "Lcom/avito/android/remote/model/PretendResult;", "messages", "Lcom/avito/android/remote/model/PretendResult;", "getMessages", "()Lcom/avito/android/remote/model/PretendResult;", "<init>", "(Lcom/avito/android/remote/model/PretendResult;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InputErrors extends EditAdvertResult {
        @SerializedName("messages")
        @Nullable
        private final PretendResult messages;

        public InputErrors(@Nullable PretendResult pretendResult) {
            super(null);
            this.messages = pretendResult;
        }

        @Nullable
        public final PretendResult getMessages() {
            return this.messages;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/adverts/EditAdvertResult$NeedSupport;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Action;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NeedSupport extends EditAdvertResult {
        @SerializedName("action")
        @NotNull
        private final Action action;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NeedSupport(@NotNull Action action2) {
            super(null);
            Intrinsics.checkNotNullParameter(action2, "action");
            this.action = action2;
        }

        @NotNull
        public final Action getAction() {
            return this.action;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/adverts/EditAdvertResult$Ok;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "", "showFees", "Z", "getShowFees", "()Z", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends EditAdvertResult {
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("message")
        @NotNull
        private final String message;
        @SerializedName("fees")
        private final boolean showFees;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(String str, boolean z, DeepLink deepLink2, int i, j jVar) {
            this(str, (i & 2) != 0 ? false : z, deepLink2);
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public final boolean getShowFees() {
            return this.showFees;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull String str, boolean z, @Nullable DeepLink deepLink2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.showFees = z;
            this.deepLink = deepLink2;
        }
    }

    private EditAdvertResult() {
    }

    public /* synthetic */ EditAdvertResult(j jVar) {
        this();
    }
}
