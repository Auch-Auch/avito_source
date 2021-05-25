package com.avito.android.messenger.conversation;

import android.net.Uri;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J9\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0006J!\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelRouter;", "", "", "operationId", "", "openPhotoPicker", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "deepLink", "", "Lcom/avito/android/remote/model/Action;", "actions", "openAbuseReportScreen", "(Lcom/avito/android/deep_linking/links/AbuseReportLink;Ljava/util/List;)V", "phoneNumber", "onCallSellerConfirmed", AnalyticFieldsName.orderId, "showOrderCancelScreen", "title", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "", "lockBottomSheet", "showPlatformMap", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "openSharingMap", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)V", "openPlayStore", "()V", "text", "templates", "onReplySuggestClicked", "(Ljava/lang/String;Ljava/util/List;)V", "url", "openUrl", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, MessageBody.File.MIME_TYPE, "openFile", "(Landroid/net/Uri;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showPlatformMap$default(ChannelRouter channelRouter, String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = false;
                }
                channelRouter.showPlatformMap(str, geoMarkerArr, markersRequest, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPlatformMap");
        }
    }

    void onCallSellerConfirmed(@NotNull String str);

    void onReplySuggestClicked(@NotNull String str, @Nullable List<String> list);

    void openAbuseReportScreen(@NotNull AbuseReportLink abuseReportLink, @Nullable List<Action> list);

    void openFile(@NotNull Uri uri, @Nullable String str);

    void openPhotoPicker(@NotNull String str);

    void openPlayStore();

    void openSharingMap(@Nullable MessageBody.Location location);

    void openUrl(@NotNull String str);

    void showOrderCancelScreen(@NotNull String str);

    void showPlatformMap(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z);
}
