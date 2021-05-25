package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.category_parameters.MultiselectParameterKt;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
@Deprecated
public class LikeView extends FrameLayout {
    public static final /* synthetic */ int s = 0;
    public String a;
    public ObjectType b;
    public LinearLayout c;
    public LikeButton d;
    public LikeBoxCountView e;
    public TextView f;
    public LikeActionController g;
    public OnErrorListener h;
    public BroadcastReceiver i;
    public a j;
    public Style k;
    public HorizontalAlignment l;
    public AuxiliaryViewPosition m;
    public int n;
    public int o;
    public int p;
    public FragmentWrapper q;
    public boolean r;

    @Deprecated
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE(MultiselectParameterKt.DISPLAY_TYPE_INLINE, 1),
        TOP("top", 2);
        
        public String a;
        public int b;

        /* access modifiers changed from: public */
        AuxiliaryViewPosition(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    @Deprecated
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT(ViewHierarchyConstants.DIMENSION_LEFT_KEY, 1),
        RIGHT("right", 2);
        
        public String a;
        public int b;

        /* access modifiers changed from: public */
        HorizontalAlignment(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    @Deprecated
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        public static ObjectType DEFAULT;
        public String a;
        public int b;

        /* access modifiers changed from: public */
        static {
            ObjectType objectType;
            DEFAULT = objectType;
        }

        /* access modifiers changed from: public */
        ObjectType(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public static ObjectType fromInt(int i) {
            ObjectType[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                ObjectType objectType = values[i2];
                if (objectType.getValue() == i) {
                    return objectType;
                }
            }
            return null;
        }

        public int getValue() {
            return this.b;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    @Deprecated
    public enum Style {
        STANDARD("standard", 0),
        BUTTON(PhonePageSourceKt.PHONE_SOURCE_BUTTON, 1),
        BOX_COUNT("box_count", 2);
        
        public String a;
        public int b;

        /* access modifiers changed from: public */
        Style(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    public class a implements LikeActionController.CreationCallback {
        public boolean a;

        public a(a2.g.v.m.b bVar) {
        }

        @Override // com.facebook.share.internal.LikeActionController.CreationCallback
        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            OnErrorListener onErrorListener;
            if (!this.a) {
                if (likeActionController != null) {
                    if (!likeActionController.shouldEnableView()) {
                        facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                    }
                    LikeView likeView = LikeView.this;
                    likeView.g = likeActionController;
                    likeView.i = new b(null);
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(likeView.getContext());
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
                    intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
                    intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
                    instance.registerReceiver(likeView.i, intentFilter);
                    LikeView.this.e();
                }
                if (!(facebookException == null || (onErrorListener = LikeView.this.h) == null)) {
                    onErrorListener.onError(facebookException);
                }
                LikeView.this.j = null;
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b(a2.g.v.m.b bVar) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[RETURN] */
        @Override // android.content.BroadcastReceiver
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r3, android.content.Intent r4) {
            /*
                r2 = this;
                java.lang.String r3 = r4.getAction()
                android.os.Bundle r4 = r4.getExtras()
                if (r4 == 0) goto L_0x0023
                java.lang.String r0 = "com.facebook.sdk.LikeActionController.OBJECT_ID"
                java.lang.String r0 = r4.getString(r0)
                boolean r1 = com.facebook.internal.Utility.isNullOrEmpty(r0)
                if (r1 != 0) goto L_0x0023
                com.facebook.share.widget.LikeView r1 = com.facebook.share.widget.LikeView.this
                java.lang.String r1 = r1.a
                boolean r0 = com.facebook.internal.Utility.areObjectsEqual(r1, r0)
                if (r0 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r0 = 0
                goto L_0x0024
            L_0x0023:
                r0 = 1
            L_0x0024:
                if (r0 != 0) goto L_0x0027
                return
            L_0x0027:
                java.lang.String r0 = "com.facebook.sdk.LikeActionController.UPDATED"
                boolean r0 = r0.equals(r3)
                if (r0 == 0) goto L_0x0037
                com.facebook.share.widget.LikeView r3 = com.facebook.share.widget.LikeView.this
                int r4 = com.facebook.share.widget.LikeView.s
                r3.e()
                goto L_0x0063
            L_0x0037:
                java.lang.String r0 = "com.facebook.sdk.LikeActionController.DID_ERROR"
                boolean r0 = r0.equals(r3)
                if (r0 == 0) goto L_0x004d
                com.facebook.share.widget.LikeView r3 = com.facebook.share.widget.LikeView.this
                com.facebook.share.widget.LikeView$OnErrorListener r3 = r3.h
                if (r3 == 0) goto L_0x0063
                com.facebook.FacebookException r4 = com.facebook.internal.NativeProtocol.getExceptionFromErrorData(r4)
                r3.onError(r4)
                goto L_0x0063
            L_0x004d:
                java.lang.String r4 = "com.facebook.sdk.LikeActionController.DID_RESET"
                boolean r3 = r4.equals(r3)
                if (r3 == 0) goto L_0x0063
                com.facebook.share.widget.LikeView r3 = com.facebook.share.widget.LikeView.this
                java.lang.String r4 = r3.a
                com.facebook.share.widget.LikeView$ObjectType r0 = r3.b
                r3.c(r4, r0)
                com.facebook.share.widget.LikeView r3 = com.facebook.share.widget.LikeView.this
                r3.e()
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        this.k = Style.STANDARD;
        this.l = HorizontalAlignment.CENTER;
        this.m = AuxiliaryViewPosition.BOTTOM;
        this.n = -1;
        this.r = true;
        b(context);
    }

    public static void a(LikeView likeView) {
        if (likeView.g != null) {
            Activity activity = null;
            if (likeView.q == null) {
                activity = likeView.getActivity();
            }
            likeView.g.toggleLike(activity, likeView.q, likeView.getAnalyticsParameters());
        }
    }

    private Activity getActivity() {
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

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.k.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_AUXILIARY_POSITION, this.m.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, this.l.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.a, ""));
        bundle.putString("object_type", this.b.toString());
        return bundle;
    }

    public final void b(Context context) {
        this.o = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.p = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.n == -1) {
            this.n = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.c = new LinearLayout(context);
        this.c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        LikeActionController likeActionController = this.g;
        LikeButton likeButton = new LikeButton(context, likeActionController != null && likeActionController.isObjectLiked());
        this.d = likeButton;
        likeButton.setOnClickListener(new a2.g.v.m.b(this));
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(context);
        this.f = textView;
        textView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.f.setMaxLines(2);
        this.f.setTextColor(this.n);
        this.f.setGravity(17);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.e = new LikeBoxCountView(context);
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c.addView(this.d);
        this.c.addView(this.f);
        this.c.addView(this.e);
        addView(this.c);
        c(this.a, this.b);
        e();
    }

    public final void c(String str, ObjectType objectType) {
        if (this.i != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.i);
            this.i = null;
        }
        a aVar = this.j;
        if (aVar != null) {
            aVar.a = true;
            this.j = null;
        }
        this.g = null;
        this.a = str;
        this.b = objectType;
        if (!Utility.isNullOrEmpty(str)) {
            this.j = new a(null);
            if (!isInEditMode()) {
                LikeActionController.getControllerForObjectId(str, objectType, this.j);
            }
        }
    }

    public final void d() {
        View view;
        LikeActionController likeActionController;
        LikeActionController likeActionController2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        HorizontalAlignment horizontalAlignment = this.l;
        int i2 = horizontalAlignment == HorizontalAlignment.LEFT ? 3 : horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i2 | 48;
        layoutParams2.gravity = i2;
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        if (this.k == Style.STANDARD && (likeActionController2 = this.g) != null && !Utility.isNullOrEmpty(likeActionController2.getSocialSentence())) {
            view = this.f;
        } else if (this.k == Style.BOX_COUNT && (likeActionController = this.g) != null && !Utility.isNullOrEmpty(likeActionController.getLikeCountString())) {
            int ordinal = this.m.ordinal();
            if (ordinal == 0) {
                this.e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
            } else if (ordinal == 1) {
                this.e.setCaretPosition(this.l == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT);
            } else if (ordinal == 2) {
                this.e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
            }
            view = this.e;
        } else {
            return;
        }
        int i3 = 0;
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i2;
        LinearLayout linearLayout = this.c;
        AuxiliaryViewPosition auxiliaryViewPosition = this.m;
        AuxiliaryViewPosition auxiliaryViewPosition2 = AuxiliaryViewPosition.INLINE;
        if (auxiliaryViewPosition != auxiliaryViewPosition2) {
            i3 = 1;
        }
        linearLayout.setOrientation(i3);
        AuxiliaryViewPosition auxiliaryViewPosition3 = this.m;
        if (auxiliaryViewPosition3 == AuxiliaryViewPosition.TOP || (auxiliaryViewPosition3 == auxiliaryViewPosition2 && this.l == HorizontalAlignment.RIGHT)) {
            this.c.removeView(this.d);
            this.c.addView(this.d);
        } else {
            this.c.removeView(view);
            this.c.addView(view);
        }
        int ordinal2 = this.m.ordinal();
        if (ordinal2 == 0) {
            int i4 = this.o;
            view.setPadding(i4, this.p, i4, i4);
        } else if (ordinal2 != 1) {
            if (ordinal2 == 2) {
                int i5 = this.o;
                view.setPadding(i5, i5, i5, this.p);
            }
        } else if (this.l == HorizontalAlignment.RIGHT) {
            int i6 = this.o;
            view.setPadding(i6, i6, this.p, i6);
        } else {
            int i7 = this.p;
            int i8 = this.o;
            view.setPadding(i7, i8, i8, i8);
        }
    }

    public final void e() {
        boolean z = !this.r;
        LikeActionController likeActionController = this.g;
        if (likeActionController == null) {
            this.d.setSelected(false);
            this.f.setText((CharSequence) null);
            this.e.setText(null);
        } else {
            this.d.setSelected(likeActionController.isObjectLiked());
            this.f.setText(this.g.getSocialSentence());
            this.e.setText(this.g.getLikeCountString());
            z &= this.g.shouldEnableView();
        }
        super.setEnabled(z);
        this.d.setEnabled(z);
        d();
    }

    @Deprecated
    public OnErrorListener getOnErrorListener() {
        return this.h;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.BOTTOM;
        }
        if (this.m != auxiliaryViewPosition) {
            this.m = auxiliaryViewPosition;
            d();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setEnabled(boolean z) {
        this.r = true;
        e();
    }

    @Deprecated
    public void setForegroundColor(int i2) {
        if (this.n != i2) {
            this.f.setTextColor(i2);
        }
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.q = new FragmentWrapper(fragment);
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.CENTER;
        }
        if (this.l != horizontalAlignment) {
            this.l = horizontalAlignment;
            d();
        }
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.STANDARD;
        }
        if (this.k != style) {
            this.k = style;
            d();
        }
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        if (objectType == null) {
            objectType = ObjectType.DEFAULT;
        }
        if (!Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.a) || objectType != this.b) {
            c(coerceValueIfNullOrEmpty, objectType);
            e();
        }
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.q = new FragmentWrapper(fragment);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes;
        Style style;
        AuxiliaryViewPosition auxiliaryViewPosition;
        Style style2 = Style.STANDARD;
        this.k = style2;
        this.l = HorizontalAlignment.CENTER;
        this.m = AuxiliaryViewPosition.BOTTOM;
        this.n = -1;
        this.r = true;
        if (!(attributeSet == null || getContext() == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_like_view)) == null)) {
            HorizontalAlignment horizontalAlignment = null;
            this.a = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), null);
            this.b = ObjectType.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
            int i2 = obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_style, style2.b);
            Style[] values = Style.values();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= 3) {
                    style = null;
                    break;
                }
                style = values[i4];
                if (style.b == i2) {
                    break;
                }
                i4++;
            }
            this.k = style;
            if (style != null) {
                int i5 = obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.BOTTOM.b);
                AuxiliaryViewPosition[] values2 = AuxiliaryViewPosition.values();
                int i6 = 0;
                while (true) {
                    if (i6 >= 3) {
                        auxiliaryViewPosition = null;
                        break;
                    }
                    auxiliaryViewPosition = values2[i6];
                    if (auxiliaryViewPosition.b == i5) {
                        break;
                    }
                    i6++;
                }
                this.m = auxiliaryViewPosition;
                if (auxiliaryViewPosition != null) {
                    int i7 = obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.CENTER.b);
                    HorizontalAlignment[] values3 = HorizontalAlignment.values();
                    while (true) {
                        if (i3 >= 3) {
                            break;
                        }
                        HorizontalAlignment horizontalAlignment2 = values3[i3];
                        if (horizontalAlignment2.b == i7) {
                            horizontalAlignment = horizontalAlignment2;
                            break;
                        }
                        i3++;
                    }
                    this.l = horizontalAlignment;
                    if (horizontalAlignment != null) {
                        this.n = obtainStyledAttributes.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
                }
            } else {
                throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
            }
        }
        b(context);
    }
}
