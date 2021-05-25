package com.bumptech.glide.load.resource.drawable;

import a2.b.a.a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.facebook.common.util.UriUtil;
import java.util.List;
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public final Context a;

    public ResourceDrawableDecoder(Context context) {
        this.a = context.getApplicationContext();
    }

    @Nullable
    public Resource<Drawable> decode(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Context context;
        int i3;
        String authority = uri.getAuthority();
        if (authority.equals(this.a.getPackageName())) {
            context = this.a;
        } else {
            try {
                context = this.a.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (authority.contains(this.a.getPackageName())) {
                    context = this.a;
                } else {
                    throw new IllegalArgumentException(a.W2("Failed to obtain context or unrecognized Uri format for: ", uri), e);
                }
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            i3 = context.getResources().getIdentifier(str2, str, authority2);
            if (i3 == 0) {
                i3 = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (i3 == 0) {
                throw new IllegalArgumentException(a.W2("Failed to find resource id for: ", uri));
            }
        } else if (pathSegments.size() == 1) {
            try {
                i3 = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException(a.W2("Unrecognized Uri format: ", uri), e2);
            }
        } else {
            throw new IllegalArgumentException(a.W2("Unrecognized Uri format: ", uri));
        }
        Drawable drawable = DrawableDecoderCompat.getDrawable(this.a, context, i3);
        if (drawable != null) {
            return new a2.d.a.d.d.b.a(drawable);
        }
        return null;
    }

    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }
}
