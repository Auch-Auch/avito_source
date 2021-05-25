package com.my.target.nativeads.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.io;
public class NativeAdCardView extends LinearLayout implements PromoCardView {
    public static final int j = io.fh();
    @NonNull
    public final MediaAdView a;
    @NonNull
    public final TextView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final Button d;
    @NonNull
    public final io e;
    @NonNull
    public final RelativeLayout f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final View.OnClickListener h = new a();
    @Nullable
    public View.OnClickListener i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeAdCardView nativeAdCardView = NativeAdCardView.this;
            View.OnClickListener onClickListener = nativeAdCardView.i;
            if (onClickListener != null) {
                onClickListener.onClick(nativeAdCardView);
            }
        }
    }

    public NativeAdCardView(@NonNull Context context) {
        super(context);
        MediaAdView mediaAdView = new MediaAdView(context);
        this.a = mediaAdView;
        TextView textView = new TextView(context);
        this.b = textView;
        TextView textView2 = new TextView(context);
        this.c = textView2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f = relativeLayout;
        Button button = new Button(context);
        this.d = button;
        io af = io.af(context);
        this.e = af;
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        io.a(this, "card_view");
        io.a(mediaAdView, "card_media_view");
        io.a(textView, "card_title_text");
        io.a(textView2, "card_description_text");
        io.a(button, "card_cta_text");
        setOrientation(1);
        setPadding(af.L(8), af.L(8), af.L(8), af.L(8));
        setClickable(true);
        io.a(this, 0, -3806472);
        io.a(relativeLayout, 0, -3806472, -3355444, af.L(1), 0);
        int i2 = j;
        button.setId(i2);
        button.setMaxEms(10);
        button.setLines(1);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setPadding(af.L(10), 0, af.L(10), 0);
        button.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, af.L(30));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(af.L(12), af.L(12), af.L(12), af.L(12));
        button.setLayoutParams(layoutParams);
        button.setTransformationMethod(null);
        button.setStateListAnimator(null);
        button.setTextColor(-16748844);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        gradientDrawable.setStroke(af.L(1), -16748844);
        gradientDrawable.setCornerRadius((float) af.L(1));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3806472, -3806472});
        gradientDrawable2.setStroke(af.L(1), -16748844);
        gradientDrawable2.setCornerRadius((float) af.L(1));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        button.setBackgroundDrawable(stateListDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(0, i2);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(null, 1);
        textView.setLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(af.L(12), af.L(6), af.L(1), af.L(1));
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setTextSize(2, 12.0f);
        textView2.setLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setPadding(af.L(12), af.L(1), af.L(1), af.L(12));
        addView(mediaAdView);
        addView(relativeLayout);
        relativeLayout.addView(button);
        relativeLayout.addView(linearLayout);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
    }

    @Override // com.my.target.nativeads.views.PromoCardView
    @NonNull
    public Button getCtaButtonView() {
        return this.d;
    }

    @Override // com.my.target.nativeads.views.PromoCardView
    @NonNull
    public TextView getDescriptionTextView() {
        return this.c;
    }

    @Override // com.my.target.nativeads.views.PromoCardView
    @NonNull
    public MediaAdView getMediaAdView() {
        return this.a;
    }

    @Override // com.my.target.nativeads.views.PromoCardView
    @NonNull
    public TextView getTitleTextView() {
        return this.b;
    }

    @Override // com.my.target.nativeads.views.PromoCardView
    @NonNull
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x > ((float) this.a.getLeft()) && x < ((float) this.a.getRight()) && y > ((float) this.a.getTop()) && y < ((float) this.a.getBottom());
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.i = onClickListener;
        super.setOnClickListener(onClickListener);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setOnClickListener(this.h);
        }
    }
}
