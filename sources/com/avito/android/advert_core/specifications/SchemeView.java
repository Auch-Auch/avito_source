package com.avito.android.advert_core.specifications;

import a2.g.r.g;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.Size;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QB\u001d\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010S\u001a\u0004\u0018\u00010R¢\u0006\u0004\bP\u0010TB%\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\u0006\u0010U\u001a\u00020\u0004¢\u0006\u0004\bP\u0010VB-\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\u0006\u0010U\u001a\u00020\u0004\u0012\u0006\u0010W\u001a\u00020\u0004¢\u0006\u0004\bP\u0010XJ+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u0018\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b\u0018\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010*R\u0016\u00107\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u0010'R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010-R\u0016\u0010<\u001a\u00020/8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0018\u00101R\u0016\u0010>\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u00106R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\bA\u0010'R\u0016\u0010D\u001a\u00020/8\u0002@\u0002XD¢\u0006\u0006\n\u0004\bC\u00101R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010ER\u0016\u0010G\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bF\u00106R\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010I\u001a\u00020/8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001e\u00101R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006Y"}, d2 = {"Lcom/avito/android/advert_core/specifications/SchemeView;", "Landroid/view/ViewGroup;", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "scheme", "setScheme", "(Lcom/avito/android/remote/model/ModelSpecifications$Scheme;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", "view", "horizontalCenter", "verticalCenter", AuthSource.SEND_ABUSE, "(Landroid/view/View;II)V", "Landroid/widget/TextView;", "label", "line", "Lcom/avito/android/remote/model/ModelSpecifications$Line;", "schemeLine", "(Landroid/widget/TextView;Landroid/view/View;Lcom/avito/android/remote/model/ModelSpecifications$Line;)V", "h", "Landroid/view/View;", "topLine", "o", "I", "previewHeight", VKApiConst.Q, "Z", "setImage", "", "d", "F", "verticalLineOffsetPercent", "n", "previewWidth", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/TextView;", "bottomLabel", "f", "leftLine", "p", "invalidate", "horizontalLineOffsetPercent", "k", "rightLabel", g.a, "leftLabel", "j", "rightLine", "c", "verticalImageOffsetPercent", "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "i", "topLabel", "bottomLine", "horizontalImageOffsetPercent", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SchemeView extends ViewGroup {
    public final float a = 0.035f;
    public final float b = 0.015f;
    public final float c = 0.09f;
    public final float d = 0.045f;
    public SimpleDraweeView e;
    public View f;
    public TextView g;
    public View h;
    public TextView i;
    public View j;
    public TextView k;
    public View l;
    public TextView m;
    public int n;
    public int o;
    public boolean p = true;
    public boolean q;
    public ModelSpecifications.Scheme r;

    public SchemeView(@Nullable Context context) {
        super(context);
    }

    public final void a(View view, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int i4 = i2 - (measuredWidth / 2);
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 - (measuredHeight / 2);
        view.layout(i4, i5, measuredWidth + i4, measuredHeight + i5);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R.id.image;
        if (valueOf != null && valueOf.intValue() == i3) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
            this.e = (SimpleDraweeView) view;
            return;
        }
        int i4 = R.id.left_line;
        if (valueOf != null && valueOf.intValue() == i4) {
            this.f = view;
            return;
        }
        int i5 = R.id.left_label;
        if (valueOf != null && valueOf.intValue() == i5) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.g = (TextView) view;
            return;
        }
        int i6 = R.id.top_line;
        if (valueOf != null && valueOf.intValue() == i6) {
            this.h = view;
            return;
        }
        int i7 = R.id.top_label;
        if (valueOf != null && valueOf.intValue() == i7) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.i = (TextView) view;
            return;
        }
        int i8 = R.id.right_line;
        if (valueOf != null && valueOf.intValue() == i8) {
            this.j = view;
            return;
        }
        int i9 = R.id.right_label;
        if (valueOf != null && valueOf.intValue() == i9) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.k = (TextView) view;
            return;
        }
        int i10 = R.id.bottom_line;
        if (valueOf != null && valueOf.intValue() == i10) {
            this.l = view;
            return;
        }
        int i11 = R.id.bottom_label;
        if (valueOf != null && valueOf.intValue() == i11) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.m = (TextView) view;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if ((r0.length() > 0) != false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.widget.TextView r4, android.view.View r5, com.avito.android.remote.model.ModelSpecifications.Line r6) {
        /*
            r3 = this;
            if (r6 == 0) goto L_0x0027
            java.lang.String r0 = r6.getLabel()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0016
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x0027
            r5.setVisibility(r2)
            java.lang.String r5 = r6.getLabel()
            r4.setText(r5)
            r4.setVisibility(r2)
            goto L_0x0034
        L_0x0027:
            r6 = 8
            r5.setVisibility(r6)
            java.lang.String r5 = ""
            r4.setText(r5)
            r4.setVisibility(r6)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.specifications.SchemeView.b(android.widget.TextView, android.view.View, com.avito.android.remote.model.ModelSpecifications$Line):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        ModelSpecifications.Scheme scheme = this.r;
        if (scheme != null) {
            int i9 = i4 - i2;
            int i10 = i5 - i3;
            float f2 = (float) i9;
            int i11 = (int) (this.b * f2);
            int i12 = (int) (f2 * this.a);
            float f3 = (float) i10;
            int i13 = (int) (this.d * f3);
            int i14 = (int) (f3 * this.c);
            int i15 = 0;
            if (scheme.getLeft() != null) {
                TextView textView = this.g;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                i6 = textView.getMeasuredHeight() + i11 + i12;
            } else {
                i6 = 0;
            }
            if (scheme.getRight() != null) {
                TextView textView2 = this.k;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                i7 = textView2.getMeasuredHeight() + i11 + i12;
            } else {
                i7 = 0;
            }
            if (scheme.getTop() != null) {
                TextView textView3 = this.i;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                i8 = textView3.getMeasuredHeight() + i13 + i14;
            } else {
                i8 = 0;
            }
            if (scheme.getBottom() != null) {
                TextView textView4 = this.m;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                i15 = textView4.getMeasuredHeight() + i13 + i14;
            }
            int i16 = (i9 - i6) - i7;
            int i17 = (i10 - i8) - i15;
            SimpleDraweeView simpleDraweeView = this.e;
            if (simpleDraweeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            simpleDraweeView.layout(i6, i8, i9 - i7, i10 - i15);
            ModelSpecifications.Line left = scheme.getLeft();
            if (left != null) {
                int from = ((int) (((float) i17) * ((left.getFrom() + left.getTo()) / ((float) 2)))) + i8;
                TextView textView5 = this.g;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                int measuredHeight = textView5.getMeasuredHeight() / 2;
                TextView textView6 = this.g;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                a(textView6, measuredHeight, from);
                TextView textView7 = this.g;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                int measuredHeight2 = textView7.getMeasuredHeight() + i11;
                View view = this.f;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLine");
                }
                int measuredWidth = (view.getMeasuredWidth() / 2) + measuredHeight2;
                View view2 = this.f;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLine");
                }
                a(view2, measuredWidth, from);
            }
            ModelSpecifications.Line top = scheme.getTop();
            if (top != null) {
                float f4 = (float) i16;
                int from2 = ((int) (f4 * ((top.getFrom() + top.getTo()) / ((float) 2)))) + i6;
                TextView textView8 = this.i;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                int measuredHeight3 = textView8.getMeasuredHeight() / 2;
                TextView textView9 = this.i;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                a(textView9, from2, measuredHeight3);
                TextView textView10 = this.i;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                int measuredHeight4 = textView10.getMeasuredHeight() + i13;
                View view3 = this.h;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLine");
                }
                int measuredHeight5 = (view3.getMeasuredHeight() / 2) + measuredHeight4;
                View view4 = this.h;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLine");
                }
                a(view4, from2, measuredHeight5);
            }
            ModelSpecifications.Line right = scheme.getRight();
            if (right != null) {
                float f5 = (float) i17;
                int from3 = i8 + ((int) (f5 * ((right.getFrom() + right.getTo()) / ((float) 2))));
                TextView textView11 = this.k;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                int measuredHeight6 = textView11.getMeasuredHeight();
                TextView textView12 = this.k;
                if (textView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                int measuredHeight7 = i9 - (measuredHeight6 - (textView12.getMeasuredHeight() / 2));
                TextView textView13 = this.k;
                if (textView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                a(textView13, measuredHeight7, from3);
                TextView textView14 = this.k;
                if (textView14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                int measuredHeight8 = (i9 - textView14.getMeasuredHeight()) - i11;
                View view5 = this.j;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLine");
                }
                int measuredWidth2 = view5.getMeasuredWidth();
                View view6 = this.j;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLine");
                }
                int measuredWidth3 = measuredHeight8 - (measuredWidth2 - (view6.getMeasuredWidth() / 2));
                View view7 = this.j;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLine");
                }
                a(view7, measuredWidth3, from3);
            }
            ModelSpecifications.Line bottom = scheme.getBottom();
            if (bottom != null) {
                float f6 = (float) i16;
                int from4 = i6 + ((int) (f6 * ((bottom.getFrom() + bottom.getTo()) / ((float) 2))));
                TextView textView15 = this.m;
                if (textView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                int measuredHeight9 = textView15.getMeasuredHeight();
                TextView textView16 = this.m;
                if (textView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                int measuredHeight10 = i10 - (measuredHeight9 - (textView16.getMeasuredHeight() / 2));
                TextView textView17 = this.m;
                if (textView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                a(textView17, from4, measuredHeight10);
                TextView textView18 = this.m;
                if (textView18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                int measuredHeight11 = (i10 - textView18.getMeasuredHeight()) - i13;
                View view8 = this.l;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
                }
                int measuredHeight12 = view8.getMeasuredHeight();
                View view9 = this.l;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
                }
                int measuredHeight13 = measuredHeight11 - (measuredHeight12 - (view9.getMeasuredHeight() / 2));
                View view10 = this.l;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
                }
                a(view10, from4, measuredHeight13);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int size = View.MeasureSpec.getSize(i2);
        ModelSpecifications.Scheme scheme = this.r;
        Uri uri = null;
        uri = null;
        Size size2 = null;
        if ((this.n != size || this.p) && scheme != null) {
            this.n = size;
            this.p = false;
            int i7 = (int) ((this.b + this.a) * ((float) size));
            if (scheme.getLeft() != null) {
                TextView textView = this.g;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                TextView textView2 = this.g;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
                }
                i4 = textView2.getMeasuredHeight() + i7 + 0;
            } else {
                i4 = 0;
            }
            if (scheme.getRight() != null) {
                TextView textView3 = this.k;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                textView3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                TextView textView4 = this.k;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
                }
                i4 += textView4.getMeasuredHeight() + i7;
            }
            int i8 = size - i4;
            Size size3 = null;
            for (Size size4 : scheme.getImage().getVariants().keySet()) {
                if (i8 <= size4.getWidth() && (size2 == null || size4.getWidth() < size2.getWidth())) {
                    size2 = size4;
                }
                if (size4.getWidth() <= i8 && (size3 == null || size3.getWidth() < size4.getWidth())) {
                    size3 = size4;
                }
            }
            if (size2 == null) {
                if (size3 != null) {
                    size2 = size3;
                } else {
                    throw new IllegalArgumentException("Image not contains variants");
                }
            }
            Uri uri2 = scheme.getImage().getVariants().get(size2);
            int height = (int) ((((float) (size2.getHeight() * i8)) * 1.0f) / ((float) size2.getWidth()));
            SimpleDraweeView simpleDraweeView = this.e;
            if (simpleDraweeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            simpleDraweeView.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
            ModelSpecifications.Line left = scheme.getLeft();
            if (left != null) {
                float to = left.getTo() - left.getFrom();
                View view = this.f;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("leftLine");
                }
                measureChild(view, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec((int) (((float) height) * to), 1073741824));
            }
            ModelSpecifications.Line right = scheme.getRight();
            if (right != null) {
                float to2 = right.getTo() - right.getFrom();
                View view2 = this.j;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightLine");
                }
                measureChild(view2, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec((int) (((float) height) * to2), 1073741824));
            }
            ModelSpecifications.Line top = scheme.getTop();
            if (top != null) {
                TextView textView5 = this.i;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                textView5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                TextView textView6 = this.i;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLabel");
                }
                i5 = textView6.getMeasuredHeight() + 0;
                float to3 = top.getTo() - top.getFrom();
                View view3 = this.h;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLine");
                }
                measureChild(view3, View.MeasureSpec.makeMeasureSpec((int) (((float) i8) * to3), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                i6 = 1;
            } else {
                i6 = 0;
                i5 = 0;
            }
            ModelSpecifications.Line bottom = scheme.getBottom();
            if (bottom != null) {
                TextView textView7 = this.m;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                textView7.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                TextView textView8 = this.m;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
                }
                i5 += textView8.getMeasuredHeight();
                i6++;
                float to4 = bottom.getTo() - bottom.getFrom();
                View view4 = this.l;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
                }
                measureChild(view4, View.MeasureSpec.makeMeasureSpec((int) (((float) i8) * to4), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            this.o = (int) (((float) (height + i5)) / (((float) 1) - ((this.d + this.c) * ((float) i6))));
            uri = uri2;
        }
        setMeasuredDimension(this.n, this.o);
        if (!(uri == null || this.q)) {
            this.q = true;
            SimpleDraweeView simpleDraweeView2 = this.e;
            if (simpleDraweeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
            }
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2).picture(new SimplePicture(uri)).load();
        }
    }

    public final void setScheme(@NotNull ModelSpecifications.Scheme scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        this.r = scheme;
        this.p = true;
        this.q = false;
        TextView textView = this.g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLabel");
        }
        View view = this.f;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLine");
        }
        b(textView, view, scheme.getLeft());
        TextView textView2 = this.i;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLabel");
        }
        View view2 = this.h;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLine");
        }
        b(textView2, view2, scheme.getTop());
        TextView textView3 = this.k;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightLabel");
        }
        View view3 = this.j;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightLine");
        }
        b(textView3, view3, scheme.getRight());
        TextView textView4 = this.m;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLabel");
        }
        View view4 = this.l;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
        }
        b(textView4, view4, scheme.getBottom());
    }

    public SchemeView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SchemeView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SchemeView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
