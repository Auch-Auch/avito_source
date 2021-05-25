package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CharityDialogResponse;", "", "<init>", "()V", "NotRequired", "Ok", "Lcom/avito/android/remote/model/CharityDialogResponse$Ok;", "Lcom/avito/android/remote/model/CharityDialogResponse$NotRequired;", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public abstract class CharityDialogResponse {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/CharityDialogResponse$NotRequired;", "Lcom/avito/android/remote/model/CharityDialogResponse;", "<init>", "()V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotRequired extends CharityDialogResponse {
        @NotNull
        public static final NotRequired INSTANCE = new NotRequired();

        private NotRequired() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/CharityDialogResponse$Ok;", "Lcom/avito/android/remote/model/CharityDialogResponse;", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "component1", "()Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", SDKConstants.PARAM_A2U_BODY, "copy", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;)Lcom/avito/android/remote/model/CharityDialogResponse$Ok;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "getBody", "<init>", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends CharityDialogResponse {
        @SerializedName("dialog")
        @NotNull
        private final DetailsSheetLinkBody body;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull DetailsSheetLinkBody detailsSheetLinkBody) {
            super(null);
            Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
            this.body = detailsSheetLinkBody;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, DetailsSheetLinkBody detailsSheetLinkBody, int i, Object obj) {
            if ((i & 1) != 0) {
                detailsSheetLinkBody = ok.body;
            }
            return ok.copy(detailsSheetLinkBody);
        }

        @NotNull
        public final DetailsSheetLinkBody component1() {
            return this.body;
        }

        @NotNull
        public final Ok copy(@NotNull DetailsSheetLinkBody detailsSheetLinkBody) {
            Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
            return new Ok(detailsSheetLinkBody);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Ok) && Intrinsics.areEqual(this.body, ((Ok) obj).body);
            }
            return true;
        }

        @NotNull
        public final DetailsSheetLinkBody getBody() {
            return this.body;
        }

        public int hashCode() {
            DetailsSheetLinkBody detailsSheetLinkBody = this.body;
            if (detailsSheetLinkBody != null) {
                return detailsSheetLinkBody.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Ok(body=");
            L.append(this.body);
            L.append(")");
            return L.toString();
        }
    }

    private CharityDialogResponse() {
    }

    public /* synthetic */ CharityDialogResponse(j jVar) {
        this();
    }
}
