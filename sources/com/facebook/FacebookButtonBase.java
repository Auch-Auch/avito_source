package com.facebook;

import a2.g.b;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public abstract class FacebookButtonBase extends Button {
    public static final /* synthetic */ int i = 0;
    public String a;
    public String b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public boolean e;
    public int f;
    public int g;
    public FragmentWrapper h;

    public FacebookButtonBase(Context context, AttributeSet attributeSet, int i2, int i3, String str, String str2) {
        super(context, attributeSet, 0);
        i3 = i3 == 0 ? getDefaultStyleResource() : i3;
        configureButton(context, attributeSet, i2, i3 == 0 ? R.style.com_facebook_button : i3);
        this.a = str;
        this.b = str2;
        setClickable(true);
        setFocusable(true);
    }

    public void callExternalOnClickListener(View view) {
        View.OnClickListener onClickListener = this.c;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: finally extract failed */
    public void configureButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i2, i3);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        setBackgroundResource(resourceId);
                    } else {
                        setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                    }
                } else {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.com_facebook_blue));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i2, i3);
        try {
            setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes2.getResourceId(0, 0), obtainStyledAttributes2.getResourceId(1, 0), obtainStyledAttributes2.getResourceId(2, 0), obtainStyledAttributes2.getResourceId(3, 0));
            setCompoundDrawablePadding(obtainStyledAttributes2.getDimensionPixelSize(4, 0));
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i2, i3);
            try {
                setPadding(obtainStyledAttributes3.getDimensionPixelSize(0, 0), obtainStyledAttributes3.getDimensionPixelSize(1, 0), obtainStyledAttributes3.getDimensionPixelSize(2, 0), obtainStyledAttributes3.getDimensionPixelSize(3, 0));
                obtainStyledAttributes3.recycle();
                TypedArray obtainStyledAttributes4 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i2, i3);
                try {
                    setTextColor(obtainStyledAttributes4.getColorStateList(0));
                    obtainStyledAttributes4.recycle();
                    TypedArray obtainStyledAttributes5 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i2, i3);
                    try {
                        setGravity(obtainStyledAttributes5.getInt(0, 17));
                        obtainStyledAttributes5.recycle();
                        TypedArray obtainStyledAttributes6 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i2, i3);
                        try {
                            setTextSize(0, (float) obtainStyledAttributes6.getDimensionPixelSize(0, 0));
                            setTypeface(Typeface.defaultFromStyle(obtainStyledAttributes6.getInt(1, 1)));
                            setText(obtainStyledAttributes6.getString(2));
                            obtainStyledAttributes6.recycle();
                            super.setOnClickListener(new b(this));
                        } catch (Throwable th) {
                            obtainStyledAttributes6.recycle();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        obtainStyledAttributes5.recycle();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    obtainStyledAttributes4.recycle();
                    throw th3;
                }
            } catch (Throwable th4) {
                obtainStyledAttributes3.recycle();
                throw th4;
            }
        } catch (Throwable th5) {
            obtainStyledAttributes2.recycle();
            throw th5;
        }
    }

    public Activity getActivity() {
        boolean z;
        Context context = getContext();
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (this.e) {
            return this.f;
        }
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        if (this.e) {
            return this.g;
        }
        return super.getCompoundPaddingRight();
    }

    public abstract int getDefaultRequestCode();

    public int getDefaultStyleResource() {
        return 0;
    }

    public Fragment getFragment() {
        FragmentWrapper fragmentWrapper = this.h;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getSupportFragment();
        }
        return null;
    }

    public android.app.Fragment getNativeFragment() {
        FragmentWrapper fragmentWrapper = this.h;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getNativeFragment();
        }
        return null;
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    public int measureTextWidth(String str) {
        return (int) Math.ceil((double) getPaint().measureText(str));
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            new InternalAppEventsLogger(getContext()).logEventImplicitly(this.a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if ((getGravity() & 1) != 0) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.f = compoundPaddingLeft - min;
            this.g = compoundPaddingRight + min;
            this.e = true;
        }
        super.onDraw(canvas);
        this.e = false;
    }

    public void setFragment(Fragment fragment) {
        this.h = new FragmentWrapper(fragment);
    }

    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void setFragment(android.app.Fragment fragment) {
        this.h = new FragmentWrapper(fragment);
    }
}
