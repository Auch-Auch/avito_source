package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
public class ImageRequest {
    public static final int UNSPECIFIED_DIMENSION = 0;
    public Context a;
    public Uri b;
    public Callback c;
    public boolean d;
    public Object e;

    public static class Builder {
        public Context a;
        public Uri b;
        public Callback c;
        public boolean d;
        public Object e;

        public Builder(Context context, Uri uri) {
            Validate.notNull(uri, "imageUri");
            this.a = context;
            this.b = uri;
        }

        public ImageRequest build() {
            return new ImageRequest(this, null);
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setCallback(Callback callback) {
            this.c = callback;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.e = obj;
            return this;
        }
    }

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public ImageRequest(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        Object obj = builder.e;
        this.e = obj == null ? new Object() : obj;
    }

    public static Uri getProfilePictureUri(String str, int i, int i2) {
        return getProfilePictureUri(str, i, i2, "");
    }

    public Callback getCallback() {
        return this.c;
    }

    public Object getCallerTag() {
        return this.e;
    }

    public Context getContext() {
        return this.a;
    }

    public Uri getImageUri() {
        return this.b;
    }

    public boolean isCachedRedirectAllowed() {
        return this.d;
    }

    public static Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        Validate.notNullOrEmpty(str, ChannelContext.Item.USER_ID);
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, "%s/%s/picture", FacebookSdk.getGraphApiVersion(), str));
        if (max2 != 0) {
            path.appendQueryParameter(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, String.valueOf(max));
        }
        path.appendQueryParameter("migration_overrides", "{october_2012:true}");
        if (!Utility.isNullOrEmpty(str2)) {
            path.appendQueryParameter("access_token", str2);
        } else if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken()) && !Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
            path.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + "|" + FacebookSdk.getClientToken());
        }
        return path.build();
    }
}
