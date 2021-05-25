package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.MobileAds;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Random;
public final class uf {
    private static Random a;

    public static class a implements tb.a<Void> {
        private final Tracker.ErrorListener a;

        public a(Tracker.ErrorListener errorListener) {
            this.a = errorListener;
        }

        @Override // com.yandex.mobile.ads.impl.sa.a
        public final void a(@NonNull sl slVar) {
            VideoAdError videoAdError;
            Tracker.ErrorListener errorListener = this.a;
            if (errorListener == null) {
                return;
            }
            if (slVar == null) {
                errorListener.onTrackingError(VideoAdError.createInternalError("Tracking error"));
                return;
            }
            if (slVar.a == null) {
                videoAdError = VideoAdError.createConnectionError(slVar.getMessage());
            } else {
                videoAdError = VideoAdError.createInternalError("Tracking error");
            }
            this.a.onTrackingError(videoAdError);
        }

        @Override // com.yandex.mobile.ads.impl.sa.b
        public final /* bridge */ /* synthetic */ void a(Object obj) {
        }
    }

    public static Random a() {
        Random random = a;
        return random == null ? new Random() : random;
    }

    public static class b<T> implements tb.a<T> {
        private final RequestListener<T> a;

        public b(RequestListener<T> requestListener) {
            this.a = requestListener;
        }

        @Override // com.yandex.mobile.ads.impl.sa.b
        public final void a(T t) {
            RequestListener<T> requestListener = this.a;
            if (requestListener != null) {
                requestListener.onSuccess(t);
            }
        }

        @Override // com.yandex.mobile.ads.impl.sa.a
        public final void a(@NonNull sl slVar) {
            VideoAdError videoAdError;
            if (this.a != null) {
                if (slVar instanceof tw) {
                    videoAdError = VideoAdError.createNoAdError((tw) slVar);
                } else if (slVar instanceof tx) {
                    videoAdError = VideoAdError.createInternalError((tx) slVar);
                } else {
                    rx rxVar = slVar.a;
                    if (rxVar == null) {
                        videoAdError = VideoAdError.createConnectionError(slVar.getMessage());
                    } else if (rxVar.a >= 500) {
                        videoAdError = VideoAdError.createRetriableError("Server temporarily unavailable. Please, try again later.");
                    } else {
                        StringBuilder Q = a2.b.a.a.a.Q(a2.b.a.a.a.j(a2.b.a.a.a.Q("Network Error. ", " Code: "), rxVar.a, "."), " Data: \n");
                        Q.append(new String(rxVar.b));
                        videoAdError = VideoAdError.createInternalError(Q.toString());
                    }
                }
                this.a.onFailure(videoAdError);
            }
        }
    }

    public static class c {
        private static void a(Uri.Builder builder, String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(str, str2);
            }
        }

        public static /* synthetic */ up a(ub ubVar, fo foVar) {
            VideoAdRequest a = ubVar.a();
            BlocksInfo blocksInfo = a.getBlocksInfo();
            Uri.Builder buildUpon = Uri.parse(uf.a(foVar)).buildUpon();
            buildUpon.appendPath("v1").appendPath("getvideo").appendQueryParameter("page_id", blocksInfo.getPartnerId()).appendQueryParameter("imp-id", a.getBlockId()).appendQueryParameter("target-ref", a.getTargetRef()).appendQueryParameter("page-ref", a.getPageRef()).appendQueryParameter("rnd", Integer.toString(uf.a().nextInt(89999999) + 10000000)).appendQueryParameter("video-session-id", a.getBlocksInfo().getSessionId()).appendQueryParameter("charset", a.getCharset().getValue());
            a(buildUpon, "video-api-version", String.format("android-v%s", MobileAds.getLibraryVersion()));
            a(buildUpon, "video-width", a.getPlayerWidthPix());
            a(buildUpon, "video-height", a.getPlayerHeightPix());
            a(buildUpon, "video-content-id", a.getVideoContentId());
            a(buildUpon, "video-content-name", a.getVideoContentName());
            a(buildUpon, "video-publisher-id", a.getPublisherId());
            a(buildUpon, "video-publisher-name", a.getPublisherName());
            a(buildUpon, "video-maxbitrate", a.getMaxBitrate());
            a(buildUpon, "video-genre-id", a.getGenreId());
            a(buildUpon, "video-genre-name", a.getGenreName());
            a(buildUpon, "tags-list", a.getTagsList());
            a(buildUpon, "ext-param", a.getExtParams());
            buildUpon.appendQueryParameter("uuid", foVar.d());
            return new up(a, buildUpon.build().toString(), new b(ubVar), new vp());
        }
    }

    public static /* synthetic */ String a(fo foVar) {
        String f = foVar.f();
        return TextUtils.isEmpty(f) ? "https://mobile.yandexadexchange.net" : f;
    }
}
