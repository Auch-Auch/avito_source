package com.avito.android.stories;

import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/avito/android/stories/StoriesPresenter;", "", "", "getLastViewed", "()Ljava/lang/String;", "Lcom/avito/android/stories/StoriesView;", "view", "", "attachView", "(Lcom/avito/android/stories/StoriesView;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "handleUrl", "(Landroid/net/Uri;)Z", "", "id", "storyViewed", "(I)V", "viewReady", "()V", "closeView", "detachView", "Lcom/avito/android/stories/StoriesPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/stories/StoriesPresenter$Router;)V", "detachRouter", "Router", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface StoriesPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/stories/StoriesPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "", "message", "close", "(Ljava/lang/String;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void close$default(Router router, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    router.close(str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
        }

        void close(@Nullable String str);

        void openDeepLink(@NotNull DeepLink deepLink);

        void openUrl(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull StoriesView storiesView);

    void closeView();

    void detachRouter();

    void detachView();

    @Nullable
    String getLastViewed();

    boolean handleUrl(@NotNull Uri uri);

    void storyViewed(int i);

    void viewReady();
}
