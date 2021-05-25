package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.R;
import java.util.Objects;
public class ProfilePictureView extends FrameLayout {
    public static final int CUSTOM = -1;
    public static final int LARGE = -4;
    public static final int NORMAL = -3;
    public static final int SMALL = -2;
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    public String a;
    public int b = 0;
    public int c = 0;
    public boolean d = true;
    public ImageView e;
    public int f = -1;
    public ImageRequest g;
    public OnErrorListener h;
    public Bitmap i = null;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public class a implements ImageRequest.Callback {
        public a() {
        }

        @Override // com.facebook.internal.ImageRequest.Callback
        public void onCompleted(ImageResponse imageResponse) {
            ProfilePictureView.a(ProfilePictureView.this, imageResponse);
        }
    }

    public ProfilePictureView(Context context) {
        super(context);
        c(context);
    }

    public static void a(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        Objects.requireNonNull(profilePictureView);
        if (imageResponse.getRequest() == profilePictureView.g) {
            profilePictureView.g = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener = profilePictureView.h;
                if (onErrorListener != null) {
                    StringBuilder L = a2.b.a.a.a.L("Error in downloading profile picture for profileId: ");
                    L.append(profilePictureView.getProfileId());
                    onErrorListener.onError(new FacebookException(L.toString(), error));
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
            } else if (bitmap != null) {
                profilePictureView.setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    profilePictureView.f(false);
                }
            }
        }
    }

    @AutoHandleExceptions
    private void setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.e;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @AutoHandleExceptions
    public final int b(boolean z) {
        int i2;
        int i3 = this.f;
        if (i3 == -4) {
            i2 = R.dimen.com_facebook_profilepictureview_preset_size_large;
        } else if (i3 == -3) {
            i2 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        } else if (i3 == -2) {
            i2 = R.dimen.com_facebook_profilepictureview_preset_size_small;
        } else if (i3 != -1 || !z) {
            return 0;
        } else {
            i2 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        }
        return getResources().getDimensionPixelSize(i2);
    }

    @AutoHandleExceptions
    public final void c(Context context) {
        removeAllViews();
        this.e = new ImageView(context);
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.e);
    }

    @AutoHandleExceptions
    public final void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
        setPresetSize(obtainStyledAttributes.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        this.d = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
        obtainStyledAttributes.recycle();
    }

    @AutoHandleExceptions
    public final void e(boolean z) {
        boolean h2 = h();
        String str = this.a;
        if (str == null || str.length() == 0 || (this.c == 0 && this.b == 0)) {
            g();
        } else if (h2 || z) {
            f(true);
        }
    }

    @AutoHandleExceptions
    public final void f(boolean z) {
        ImageRequest build = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(this.a, this.c, this.b, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "")).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new a()).build();
        ImageRequest imageRequest = this.g;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        this.g = build;
        ImageDownloader.downloadAsync(build);
    }

    @AutoHandleExceptions
    public final void g() {
        ImageRequest imageRequest = this.g;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        if (this.i == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? R.drawable.com_facebook_profile_picture_blank_square : R.drawable.com_facebook_profile_picture_blank_portrait));
            return;
        }
        h();
        setImageBitmap(Bitmap.createScaledBitmap(this.i, this.c, this.b, false));
    }

    public final OnErrorListener getOnErrorListener() {
        return this.h;
    }

    public final int getPresetSize() {
        return this.f;
    }

    public final String getProfileId() {
        return this.a;
    }

    @AutoHandleExceptions
    public final boolean h() {
        int height = getHeight();
        int width = getWidth();
        boolean z = true;
        if (width < 1 || height < 1) {
            return false;
        }
        int b2 = b(false);
        if (b2 != 0) {
            height = b2;
            width = height;
        }
        if (width <= height) {
            height = isCropped() ? width : 0;
        } else {
            width = isCropped() ? height : 0;
        }
        if (width == this.c && height == this.b) {
            z = false;
        }
        this.c = width;
        this.b = height;
        return z;
    }

    public final boolean isCropped() {
        return this.d;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = null;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        e(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z2 = true;
        if (View.MeasureSpec.getMode(i3) == 1073741824 || layoutParams.height != -2) {
            z = false;
        } else {
            size = b(true);
            i3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824 || layoutParams.width != -2) {
            z2 = z;
        } else {
            size2 = b(true);
            i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z2) {
            setMeasuredDimension(size2, size);
            measureChildren(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
        this.a = bundle.getString("ProfilePictureView_profileId");
        this.f = bundle.getInt("ProfilePictureView_presetSize");
        this.d = bundle.getBoolean("ProfilePictureView_isCropped");
        this.c = bundle.getInt("ProfilePictureView_width");
        this.b = bundle.getInt("ProfilePictureView_height");
        e(true);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", onSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.a);
        bundle.putInt("ProfilePictureView_presetSize", this.f);
        bundle.putBoolean("ProfilePictureView_isCropped", this.d);
        bundle.putInt("ProfilePictureView_width", this.c);
        bundle.putInt("ProfilePictureView_height", this.b);
        bundle.putBoolean("ProfilePictureView_refresh", this.g != null);
        return bundle;
    }

    public final void setCropped(boolean z) {
        this.d = z;
        e(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.i = bitmap;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    public final void setPresetSize(int i2) {
        if (i2 == -4 || i2 == -3 || i2 == -2 || i2 == -1) {
            this.f = i2;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(@Nullable String str) {
        boolean z;
        if (Utility.isNullOrEmpty(this.a) || !this.a.equalsIgnoreCase(str)) {
            g();
            z = true;
        } else {
            z = false;
        }
        this.a = str;
        e(z);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
        d(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
        d(attributeSet);
    }
}
