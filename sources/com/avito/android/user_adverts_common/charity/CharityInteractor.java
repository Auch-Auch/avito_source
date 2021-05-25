package com.avito.android.user_adverts_common.charity;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.Maybe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;", "source", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Dialog;", "requestDialog", "(Ljava/lang/String;Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;)Lio/reactivex/rxjava3/core/Maybe;", "Dialog", "Source", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public interface CharityInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Dialog;", "", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "component1", "()Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "component2", "()Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", SDKConstants.PARAM_A2U_BODY, "clickEvent", "copy", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Dialog;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "getBody", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "getClickEvent", "<init>", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dialog {
        @NotNull
        public final DetailsSheetLinkBody a;
        @Nullable
        public final ParametrizedClickStreamEvent b;

        public Dialog(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
            Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
            this.a = detailsSheetLinkBody;
            this.b = parametrizedClickStreamEvent;
        }

        public static /* synthetic */ Dialog copy$default(Dialog dialog, DetailsSheetLinkBody detailsSheetLinkBody, ParametrizedClickStreamEvent parametrizedClickStreamEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                detailsSheetLinkBody = dialog.a;
            }
            if ((i & 2) != 0) {
                parametrizedClickStreamEvent = dialog.b;
            }
            return dialog.copy(detailsSheetLinkBody, parametrizedClickStreamEvent);
        }

        @NotNull
        public final DetailsSheetLinkBody component1() {
            return this.a;
        }

        @Nullable
        public final ParametrizedClickStreamEvent component2() {
            return this.b;
        }

        @NotNull
        public final Dialog copy(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
            Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
            return new Dialog(detailsSheetLinkBody, parametrizedClickStreamEvent);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dialog)) {
                return false;
            }
            Dialog dialog = (Dialog) obj;
            return Intrinsics.areEqual(this.a, dialog.a) && Intrinsics.areEqual(this.b, dialog.b);
        }

        @NotNull
        public final DetailsSheetLinkBody getBody() {
            return this.a;
        }

        @Nullable
        public final ParametrizedClickStreamEvent getClickEvent() {
            return this.b;
        }

        public int hashCode() {
            DetailsSheetLinkBody detailsSheetLinkBody = this.a;
            int i = 0;
            int hashCode = (detailsSheetLinkBody != null ? detailsSheetLinkBody.hashCode() : 0) * 31;
            ParametrizedClickStreamEvent parametrizedClickStreamEvent = this.b;
            if (parametrizedClickStreamEvent != null) {
                i = parametrizedClickStreamEvent.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Dialog(body=");
            L.append(this.a);
            L.append(", clickEvent=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PUBLISH", "SOA", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
    public enum Source {
        PUBLISH(PhotoUploadKt.UPLOAD_TYPE_PUBLISH),
        SOA("soa");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        Source(String str) {
            this.a = str;
        }

        @NotNull
        public final String getTag() {
            return this.a;
        }
    }

    @NotNull
    Maybe<Dialog> requestDialog(@NotNull String str, @NotNull Source source);
}
