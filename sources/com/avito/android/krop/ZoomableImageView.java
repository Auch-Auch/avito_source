package com.avito.android.krop;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.krop.util.KLine;
import com.avito.android.krop.util.KPoint;
import com.avito.android.krop.util.KRect;
import com.avito.android.krop.util.ScaleAfterRotationStyle;
import com.avito.android.krop.util.SizeF;
import com.avito.android.krop.util.Transformation;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u000b\u0016\u0012(\u001bë\u0001ì\u0001*\u000f1B\u0012\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0005\bå\u0001\u0010\u000eB\u001d\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010ç\u0001\u001a\u00030æ\u0001¢\u0006\u0006\bå\u0001\u0010è\u0001B&\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010ç\u0001\u001a\u00030æ\u0001\u0012\u0007\u0010é\u0001\u001a\u00020\u001e¢\u0006\u0006\bå\u0001\u0010ê\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0013\u0010\u0014\u001a\u00020\u0006*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J'\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0010JG\u0010$\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u0010J/\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J'\u00107\u001a\u0002062\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020/H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001eH\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\f2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010B\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bB\u0010CJ\u0019\u0010F\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\f2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020HH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020NH\u0016¢\u0006\u0004\bR\u0010SJ\u001f\u0010V\u001a\u00020\f2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001eH\u0014¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0013H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\f2\u0006\u0010\\\u001a\u00020[H\u0014¢\u0006\u0004\b]\u0010^J\u0017\u0010a\u001a\u00020\f2\u0006\u0010`\u001a\u00020_H\u0016¢\u0006\u0004\ba\u0010bJ\r\u0010c\u001a\u00020\f¢\u0006\u0004\bc\u0010\u0010J5\u0010f\u001a\u00020\f2\u0006\u0010d\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00172\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010e\u001a\u00020HH\u0007¢\u0006\u0004\bf\u0010gJ\u001d\u0010k\u001a\u00020\f2\u0006\u0010h\u001a\u00020\u00172\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\u0015\u0010f\u001a\u00020\f2\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bf\u0010nJ\u001d\u0010o\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0017¢\u0006\u0004\bo\u0010pJ\r\u0010r\u001a\u00020q¢\u0006\u0004\br\u0010sJ\u0015\u0010u\u001a\u00020\f2\u0006\u0010t\u001a\u00020q¢\u0006\u0004\bu\u0010vJ\u0015\u0010x\u001a\u00020/2\u0006\u0010w\u001a\u00020\u001e¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020/2\u0006\u0010w\u001a\u00020\u001eH\u0016¢\u0006\u0004\bz\u0010yJ\u000f\u0010}\u001a\u00020\u0013H\u0000¢\u0006\u0004\b{\u0010|J\u001a\u0010\u0001\u001a\u00020/2\u0006\u0010\u001a\u00020~H\u0017¢\u0006\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00020\u00138F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010|R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0019\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0007\n\u0005\b4\u0010\u0001R,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\t\u0018\u00010\u0001R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\r\u0010\u0001R*\u0010¡\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u00178\u0006@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001R\u0018\u0010£\u0001\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u0016\u0010¢\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010¤\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010¬\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b*\u0010\u0001R\u0018\u0010®\u0001\u001a\u00020H8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b7\u0010­\u0001R\u001a\u0010°\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0001R*\u0010µ\u0001\u001a\u00020\u00172\u0007\u0010±\u0001\u001a\u00020\u00178F@FX\u000e¢\u0006\u0010\u001a\u0006\b²\u0001\u0010 \u0001\"\u0006\b³\u0001\u0010´\u0001R\u0018\u0010·\u0001\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0014\u0010¶\u0001R\u001a\u0010¹\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010\u0001R\u0018\u0010º\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b(\u0010\u0001R+\u0010Á\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b3\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R*\u0010Ä\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u00178\u0000@BX\u000e¢\u0006\u0010\n\u0006\bÂ\u0001\u0010\u0001\u001a\u0006\bÃ\u0001\u0010 \u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010Ê\u0001\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b$\u0010É\u0001R\u0018\u0010Ë\u0001\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u001d\u0010¢\u0001R\u0019\u0010Î\u0001\u001a\u00030Ì\u00018\u0002@\u0002X.¢\u0006\u0007\n\u0005\b1\u0010Í\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00178B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010 \u0001R\u0016\u0010Ñ\u0001\u001a\u00020/8F@\u0006¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010\"\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00178B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010 \u0001R*\u0010Ù\u0001\u001a\u00020\u00172\u0007\u0010Ö\u0001\u001a\u00020\u00178F@FX\u000e¢\u0006\u0010\u001a\u0006\b×\u0001\u0010 \u0001\"\u0006\bØ\u0001\u0010´\u0001R\u0018\u0010Ú\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001R\u001b\u0010Ý\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001a\u0010Q\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010ß\u0001R\u0018\u0010à\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0001R\u0018\u0010á\u0001\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010É\u0001R\u0018\u0010ä\u0001\u001a\u0004\u0018\u0001068F@\u0006¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001¨\u0006í\u0001"}, d2 = {"Lcom/avito/android/krop/ZoomableImageView;", "Landroid/widget/ImageView;", "Lcom/avito/android/krop/ViewportUpdateListener;", "Lcom/avito/android/krop/util/KPoint;", "getFocusOffset", "()Lcom/avito/android/krop/util/KPoint;", "Lcom/avito/android/krop/util/KRect;", "getDisplayedBounds", "()Lcom/avito/android/krop/util/KRect;", "getCurrentBounds", "Landroid/content/Context;", "context", "", "i", "(Landroid/content/Context;)V", a2.g.r.g.a, "()V", AuthSource.OPEN_CHANNEL_LIST, "c", "Landroid/graphics/RectF;", "j", "(Landroid/graphics/RectF;)Lcom/avito/android/krop/util/KRect;", AuthSource.BOOKING_ORDER, "", "trans", "viewSize", "contentSize", "e", "(FFF)F", AuthSource.SEND_ABUSE, "", "axis", "prevImageSize", "imageSize", "prevViewSize", "drawableSize", "l", "(IFFFFFI)V", "Landroid/graphics/Matrix;", "imageMatrix", "d", "(Landroid/graphics/Matrix;)Lcom/avito/android/krop/util/KRect;", "f", "", "deltaScale", "focusX", "focusY", "", "stretchImageToSuper", "h", "(DFFZ)V", "x", "y", "clipToBitmap", "Landroid/graphics/PointF;", "k", "(FFZ)Landroid/graphics/PointF;", "resId", "setImageResource", "(I)V", "Landroid/graphics/Bitmap;", "bm", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "setImageURI", "(Landroid/net/Uri;)V", "Landroid/widget/ImageView$ScaleType;", "type", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "newViewport", "onUpdateViewport", "(Landroid/graphics/RectF;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "resetZoom", "scale", "scaleType", "setZoom", "(FFFLandroid/widget/ImageView$ScaleType;)V", "angle", "Lcom/avito/android/krop/util/ScaleAfterRotationStyle;", "scaleAnimation", "rotateBy", "(FLcom/avito/android/krop/util/ScaleAfterRotationStyle;)V", "img", "(Lcom/avito/android/krop/ZoomableImageView;)V", "setScrollPosition", "(FF)V", "Lcom/avito/android/krop/util/Transformation;", "getTransformation", "()Lcom/avito/android/krop/util/Transformation;", "transformation", "setTransformation", "(Lcom/avito/android/krop/util/Transformation;)V", "direction", "canScrollHorizontallyFroyo", "(I)Z", "canScrollHorizontally", "getImageBounds$krop_release", "()Landroid/graphics/RectF;", "getImageBounds", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "getZoomedRect", "zoomedRect", "Landroid/view/ScaleGestureDetector;", "t", "Landroid/view/ScaleGestureDetector;", "scaleDetector", "Lcom/avito/android/krop/util/SizeF;", "p", "Lcom/avito/android/krop/util/SizeF;", "Landroid/graphics/RectF;", "viewport", "Landroid/view/View$OnTouchListener;", "w", "Landroid/view/View$OnTouchListener;", "getUserTouchListener", "()Landroid/view/View$OnTouchListener;", "setUserTouchListener", "(Landroid/view/View$OnTouchListener;)V", "userTouchListener", "Landroid/view/GestureDetector;", "u", "Landroid/view/GestureDetector;", "gestureDetector", "Lcom/avito/android/krop/ZoomableImageView$d;", "Lcom/avito/android/krop/ZoomableImageView$d;", "fling", "<set-?>", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "F", "getCurrentZoom", "()F", "currentZoom", "Landroid/graphics/Matrix;", "prevMatrix", "Landroid/view/GestureDetector$OnDoubleTapListener;", VKApiConst.VERSION, "Landroid/view/GestureDetector$OnDoubleTapListener;", "getDoubleTapListener", "()Landroid/view/GestureDetector$OnDoubleTapListener;", "setDoubleTapListener", "(Landroid/view/GestureDetector$OnDoubleTapListener;)V", "doubleTapListener", "superMinScale", "Landroid/widget/ImageView$ScaleType;", "imageScaleType", "r", "matchViewSize", "min", "getMinZoom", "setMinZoom", "(F)V", "minZoom", "Landroid/graphics/PointF;", "lastMovePoint", "s", "prevMatchViewSize", "minScale", "Lcom/avito/android/krop/ZoomableImageView$ImageMoveListener;", "Lcom/avito/android/krop/ZoomableImageView$ImageMoveListener;", "getImageMoveListener", "()Lcom/avito/android/krop/ZoomableImageView$ImageMoveListener;", "setImageMoveListener", "(Lcom/avito/android/krop/ZoomableImageView$ImageMoveListener;)V", "imageMoveListener", "z", "getRotationAngle$krop_release", "rotationAngle", "Lcom/avito/android/krop/ZoomableImageView$h;", "n", "Lcom/avito/android/krop/ZoomableImageView$h;", "delayedZoomVariables", "Z", "imageRenderedAtLeastOnce", "imgMatrix", "", "[F", "matrix", "getImageHeight", "imageHeight", "isZoomed", "()Z", VKApiConst.Q, "getImageWidth", "imageWidth", "max", "getMaxZoom", "setMaxZoom", "maxZoom", "superMaxScale", "o", "Lcom/avito/android/krop/util/Transformation;", "delayedTransformation", "Lcom/avito/android/krop/ZoomableImageView$g;", "Lcom/avito/android/krop/ZoomableImageView$g;", "maxScale", "onDrawReady", "getScrollPosition", "()Landroid/graphics/PointF;", "scrollPosition", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ImageMoveListener", "SavedState", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class ZoomableImageView extends ImageView implements ViewportUpdateListener {
    public float A;
    public Matrix a;
    public Matrix b;
    public g c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float[] h;
    public d i;
    public final PointF j = new PointF();
    public ImageView.ScaleType k;
    public boolean l;
    public boolean m;
    public h n;
    public Transformation o;
    public SizeF p = new SizeF(0.0f, 0.0f, 3, null);
    public SizeF q = new SizeF(0.0f, 0.0f, 3, null);
    public SizeF r = new SizeF(0.0f, 0.0f, 3, null);
    public SizeF s = new SizeF(0.0f, 0.0f, 3, null);
    public ScaleGestureDetector t;
    public GestureDetector u;
    @Nullable
    public GestureDetector.OnDoubleTapListener v;
    @Nullable
    public View.OnTouchListener w;
    @Nullable
    public ImageMoveListener x;
    public RectF y;
    public float z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/krop/ZoomableImageView$ImageMoveListener;", "", "", "onMove", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
    public interface ImageMoveListener {
        void onMove();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ScaleAfterRotationStyle.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[0] = 3;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ImageView.ScaleType.CENTER.ordinal()] = 1;
            iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            iArr2[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Float f) {
            int i = this.a;
            if (i == 0) {
                float floatValue = f.floatValue();
                ZoomableImageView zoomableImageView = (ZoomableImageView) this.b;
                float f2 = (float) 2;
                zoomableImageView.h((double) floatValue, zoomableImageView.p.getWidth() / f2, ((ZoomableImageView) this.b).p.getHeight() / f2, false);
                ((ZoomableImageView) this.b).c();
                ZoomableImageView zoomableImageView2 = (ZoomableImageView) this.b;
                zoomableImageView2.setMinZoom(zoomableImageView2.getCurrentZoom());
                return Unit.INSTANCE;
            } else if (i == 1) {
                float min = Math.min(((ZoomableImageView) this.b).e, ((ZoomableImageView) this.b).getCurrentZoom() * f.floatValue());
                ZoomableImageView zoomableImageView3 = (ZoomableImageView) this.b;
                float f3 = (float) 2;
                ZoomableImageView.access$compatPostOnAnimation(zoomableImageView3, new c(min, zoomableImageView3.p.getWidth() / f3, ((ZoomableImageView) this.b).p.getHeight() / f3, true, 200.0f, false));
                ((ZoomableImageView) this.b).setMinZoom(min);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @TargetApi(9)
    public final class b {
        @NotNull
        public OverScroller a;

        public b(@NotNull ZoomableImageView zoomableImageView, Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.a = new OverScroller(context);
        }
    }

    public final class d implements Runnable {
        @Nullable
        public b a;
        public int b;
        public int c;

        public d(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            ZoomableImageView.this = r24;
            r24.c = g.FLING;
            Context context = r24.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            this.a = new b(r24, context);
            ZoomableImageView.access$getImgMatrix$p(r24).getValues(ZoomableImageView.access$getMatrix$p(r24));
            int i8 = (int) ZoomableImageView.access$getMatrix$p(r24)[2];
            int i9 = (int) ZoomableImageView.access$getMatrix$p(r24)[5];
            double sin = Math.sin(Math.toRadians((double) r24.getRotationAngle$krop_release()));
            double cos = Math.cos(Math.toRadians((double) r24.getRotationAngle$krop_release()));
            if (r24.getImageWidth() > r24.p.getWidth()) {
                double d2 = ((double) (-r24.getImageWidth())) * cos;
                Double valueOf = Double.valueOf(d2);
                valueOf.doubleValue();
                double d3 = (double) 0;
                valueOf = !((cos > d3 ? 1 : (cos == d3 ? 0 : -1)) > 0) ? null : valueOf;
                double doubleValue = valueOf != null ? valueOf.doubleValue() : 0.0d;
                Double valueOf2 = Double.valueOf(d2);
                valueOf2.doubleValue();
                valueOf2 = !((cos > d3 ? 1 : (cos == d3 ? 0 : -1)) < 0) ? null : valueOf2;
                double doubleValue2 = valueOf2 != null ? valueOf2.doubleValue() : 0.0d;
                i3 = i9;
                double imageHeight = ((double) r24.getImageHeight()) * sin;
                Double valueOf3 = Double.valueOf(imageHeight);
                valueOf3.doubleValue();
                valueOf3 = !((sin > d3 ? 1 : (sin == d3 ? 0 : -1)) < 0) ? null : valueOf3;
                double doubleValue3 = valueOf3 != null ? valueOf3.doubleValue() : 0.0d;
                Double valueOf4 = Double.valueOf(imageHeight);
                valueOf4.doubleValue();
                valueOf4 = !((sin > d3 ? 1 : (sin == d3 ? 0 : -1)) > 0) ? null : valueOf4;
                i4 = (int) (((double) r24.getImageWidth()) + doubleValue2 + (valueOf4 != null ? valueOf4.doubleValue() : 0.0d));
                i5 = (int) (((double) r24.p.getWidth()) + doubleValue + doubleValue3);
            } else {
                i3 = i9;
                i5 = i8;
                i4 = i5;
            }
            if (r24.getImageHeight() > r24.p.getHeight()) {
                double d4 = ((double) (-r24.getImageHeight())) * cos;
                Double valueOf5 = Double.valueOf(d4);
                valueOf5.doubleValue();
                double d5 = (double) 0;
                valueOf5 = !((cos > d5 ? 1 : (cos == d5 ? 0 : -1)) > 0) ? null : valueOf5;
                double doubleValue4 = valueOf5 != null ? valueOf5.doubleValue() : 0.0d;
                Double valueOf6 = Double.valueOf(d4);
                valueOf6.doubleValue();
                valueOf6 = !((cos > d5 ? 1 : (cos == d5 ? 0 : -1)) < 0) ? null : valueOf6;
                double doubleValue5 = valueOf6 != null ? valueOf6.doubleValue() : 0.0d;
                double d6 = ((double) (-r24.getImageWidth())) * sin;
                Double valueOf7 = Double.valueOf(d6);
                valueOf7.doubleValue();
                valueOf7 = !((sin > d5 ? 1 : (sin == d5 ? 0 : -1)) > 0) ? null : valueOf7;
                double doubleValue6 = valueOf7 != null ? valueOf7.doubleValue() : 0.0d;
                Double valueOf8 = Double.valueOf(d6);
                valueOf8.doubleValue();
                Double d7 = (sin > d5 ? 1 : (sin == d5 ? 0 : -1)) < 0 ? valueOf8 : null;
                i6 = (int) (((double) r24.getImageHeight()) + (d7 != null ? d7.doubleValue() : 0.0d) + doubleValue5);
                i7 = (int) (((double) r24.p.getHeight()) + doubleValue6 + doubleValue4);
            } else {
                i7 = i3;
                i6 = i7;
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.a.fling(i8, i3, i, i2, i5, i4, i7, i6);
            }
            this.b = i8;
            this.c = i3;
        }

        public final void a() {
            if (this.a != null) {
                ZoomableImageView.this.c = g.NONE;
                b bVar = this.a;
                if (bVar != null) {
                    bVar.a.forceFinished(true);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageMoveListener imageMoveListener = ZoomableImageView.this.getImageMoveListener();
            if (imageMoveListener != null) {
                imageMoveListener.onMove();
            }
            b bVar = this.a;
            if (bVar == null || !bVar.a.isFinished()) {
                b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.a.computeScrollOffset();
                    if (bVar2.a.computeScrollOffset()) {
                        int currX = bVar2.a.getCurrX();
                        int currY = bVar2.a.getCurrY();
                        int i = currY - this.c;
                        this.b = currX;
                        this.c = currY;
                        ZoomableImageView.access$getImgMatrix$p(ZoomableImageView.this).postTranslate((float) (currX - this.b), (float) i);
                        ZoomableImageView.this.c();
                        ZoomableImageView.this.f();
                        ZoomableImageView.access$compatPostOnAnimation(ZoomableImageView.this, this);
                        return;
                    }
                    return;
                }
                return;
            }
            this.a = null;
        }
    }

    public final class e extends GestureDetector.SimpleOnGestureListener {
        public e() {
            ZoomableImageView.this = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "event");
            GestureDetector.OnDoubleTapListener doubleTapListener = ZoomableImageView.this.getDoubleTapListener();
            boolean onDoubleTap = doubleTapListener != null ? doubleTapListener.onDoubleTap(motionEvent) : false;
            if (ZoomableImageView.this.c != g.NONE) {
                return onDoubleTap;
            }
            ZoomableImageView.access$compatPostOnAnimation(ZoomableImageView.this, new c(ZoomableImageView.this, ZoomableImageView.this.getCurrentZoom() == ZoomableImageView.this.d ? ZoomableImageView.this.e : ZoomableImageView.this.d, motionEvent.getX(), motionEvent.getY(), false, 0.0f, false, 48));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "e");
            GestureDetector.OnDoubleTapListener doubleTapListener = ZoomableImageView.this.getDoubleTapListener();
            if (doubleTapListener != null) {
                return doubleTapListener.onDoubleTapEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f, float f2) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "e1");
            Intrinsics.checkParameterIsNotNull(motionEvent2, "e2");
            d dVar = ZoomableImageView.this.i;
            if (dVar != null) {
                dVar.a();
            }
            ZoomableImageView zoomableImageView = ZoomableImageView.this;
            zoomableImageView.i = new d((int) f, (int) f2);
            d dVar2 = ZoomableImageView.this.i;
            if (dVar2 != null) {
                ZoomableImageView.access$compatPostOnAnimation(ZoomableImageView.this, dVar2);
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "e");
            ZoomableImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "e");
            GestureDetector.OnDoubleTapListener doubleTapListener = ZoomableImageView.this.getDoubleTapListener();
            if (doubleTapListener != null) {
                return doubleTapListener.onSingleTapConfirmed(motionEvent);
            }
            return ZoomableImageView.this.performClick();
        }
    }

    public final class f extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public f() {
            ZoomableImageView.this = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkParameterIsNotNull(scaleGestureDetector, "detector");
            ZoomableImageView.this.h((double) scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            ZoomableImageView.this.m();
            ImageMoveListener imageMoveListener = ZoomableImageView.this.getImageMoveListener();
            if (imageMoveListener == null) {
                return true;
            }
            imageMoveListener.onMove();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(@NotNull ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkParameterIsNotNull(scaleGestureDetector, "detector");
            ZoomableImageView.this.c = g.ZOOM;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(@NotNull ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkParameterIsNotNull(scaleGestureDetector, "detector");
            super.onScaleEnd(scaleGestureDetector);
            ZoomableImageView.this.c = g.NONE;
            float currentZoom = ZoomableImageView.this.getCurrentZoom();
            boolean z = true;
            if (ZoomableImageView.this.getCurrentZoom() > ZoomableImageView.this.e) {
                currentZoom = ZoomableImageView.this.e;
            } else if (ZoomableImageView.this.getCurrentZoom() < ZoomableImageView.this.d) {
                currentZoom = ZoomableImageView.this.d;
            } else {
                z = false;
            }
            if (z) {
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                float f = (float) 2;
                ZoomableImageView.access$compatPostOnAnimation(ZoomableImageView.this, new c(zoomableImageView, currentZoom, zoomableImageView.p.getWidth() / f, ZoomableImageView.this.p.getHeight() / f, true, 0.0f, false, 48));
            }
        }
    }

    public enum g {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    public static final class h {
        public final float a;
        public final float b;
        public final float c;
        @NotNull
        public final ImageView.ScaleType d;

        public h(float f, float f2, float f3, @NotNull ImageView.ScaleType scaleType) {
            Intrinsics.checkParameterIsNotNull(scaleType, "scaleType");
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = scaleType;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Float.compare(this.a, hVar.a) == 0 && Float.compare(this.b, hVar.b) == 0 && Float.compare(this.c, hVar.c) == 0 && Intrinsics.areEqual(this.d, hVar.d);
        }

        public int hashCode() {
            int i1 = a2.b.a.a.a.i1(this.c, a2.b.a.a.a.i1(this.b, Float.floatToIntBits(this.a) * 31, 31), 31);
            ImageView.ScaleType scaleType = this.d;
            return i1 + (scaleType != null ? scaleType.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ZoomVariables(scale=");
            L.append(this.a);
            L.append(", focusX=");
            L.append(this.b);
            L.append(", focusY=");
            L.append(this.c);
            L.append(", scaleType=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    public static final class i extends Lambda implements Function2<KPoint, KLine, KPoint> {
        public static final i a = new i();

        public i() {
            super(2);
        }

        @NotNull
        /* renamed from: a */
        public final KPoint invoke(@NotNull KPoint kPoint, @NotNull KLine kLine) {
            Intrinsics.checkParameterIsNotNull(kPoint, "$this$followLine");
            Intrinsics.checkParameterIsNotNull(kLine, "vector");
            Pair<Float, Float> transition = kLine.getTransition();
            return kPoint.moveBy(transition.component1().floatValue(), transition.component2().floatValue());
        }
    }

    public static final class j extends Lambda implements Function1<KLine, KPoint> {
        public final /* synthetic */ ZoomableImageView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ZoomableImageView zoomableImageView) {
            super(1);
            this.a = zoomableImageView;
        }

        @NotNull
        /* renamed from: a */
        public final KPoint invoke(@NotNull KLine kLine) {
            Intrinsics.checkParameterIsNotNull(kLine, "$this$getVectorDistantPoint");
            float max = Math.max(this.a.getImageWidth(), this.a.getImageHeight());
            float x = kLine.getP2().getX() - kLine.getP1().getX();
            if (x == 0.0f) {
                return new KPoint(kLine.getP1().getX(), max);
            }
            float y = (kLine.getP2().getY() - kLine.getP1().getY()) / x;
            float signum = Math.signum(x) * max;
            return new KPoint(kLine.getP1().getX() + signum, kLine.getP1().getY() + (y * signum));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        i(context);
    }

    public static final void access$compatPostOnAnimation(ZoomableImageView zoomableImageView, Runnable runnable) {
        zoomableImageView.postOnAnimation(runnable);
    }

    public static final /* synthetic */ Matrix access$getImgMatrix$p(ZoomableImageView zoomableImageView) {
        Matrix matrix = zoomableImageView.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        return matrix;
    }

    public static final /* synthetic */ float[] access$getMatrix$p(ZoomableImageView zoomableImageView) {
        float[] fArr = zoomableImageView.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        return fArr;
    }

    public static final PointF access$transformCoordBitmapToTouch(ZoomableImageView zoomableImageView, float f2, float f3) {
        Matrix matrix = zoomableImageView.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr = zoomableImageView.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix.getValues(fArr);
        Drawable drawable = zoomableImageView.getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        Drawable drawable2 = zoomableImageView.getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable2, "drawable");
        float intrinsicWidth = f2 / ((float) drawable.getIntrinsicWidth());
        float intrinsicHeight = f3 / ((float) drawable2.getIntrinsicHeight());
        float[] fArr2 = zoomableImageView.h;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        float imageWidth = (zoomableImageView.getImageWidth() * intrinsicWidth) + fArr2[2];
        float[] fArr3 = zoomableImageView.h;
        if (fArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        return new PointF(imageWidth, (zoomableImageView.getImageHeight() * intrinsicHeight) + fArr3[5]);
    }

    private final KRect getCurrentBounds() {
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        return d(matrix);
    }

    private final KRect getDisplayedBounds() {
        Matrix imageMatrix = getImageMatrix();
        Intrinsics.checkExpressionValueIsNotNull(imageMatrix, "imageMatrix");
        return d(imageMatrix);
    }

    private final KPoint getFocusOffset() {
        KPoint kPoint;
        KRect currentBounds = getCurrentBounds();
        if (currentBounds == null || (kPoint = currentBounds.center()) == null) {
            RectF rectF = this.y;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            float centerX = rectF.centerX();
            RectF rectF2 = this.y;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            kPoint = new KPoint(centerX, rectF2.centerY());
        }
        float x2 = kPoint.getX();
        RectF rectF3 = this.y;
        if (rectF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        float centerX2 = x2 - rectF3.centerX();
        float y2 = kPoint.getY();
        RectF rectF4 = this.y;
        if (rectF4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        return new KPoint(centerX2, y2 - rectF4.centerY());
    }

    private final float getImageHeight() {
        return this.r.getHeight() * this.A;
    }

    private final float getImageWidth() {
        return this.r.getWidth() * this.A;
    }

    public static /* synthetic */ void setZoom$default(ZoomableImageView zoomableImageView, float f2, float f3, float f4, ImageView.ScaleType scaleType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = 0.5f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.5f;
        }
        if ((i2 & 8) != 0 && (scaleType = zoomableImageView.k) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageScaleType");
        }
        zoomableImageView.setZoom(f2, f3, f4, scaleType);
    }

    public final void a() {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f2 = (float) intrinsicWidth;
            float width = this.p.getWidth() / f2;
            float f3 = (float) intrinsicHeight;
            float height = this.p.getHeight() / f3;
            ImageView.ScaleType scaleType = this.k;
            if (scaleType == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageScaleType");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    width = Math.max(width, height);
                } else if (i2 == 3) {
                    float min = Math.min(1.0f, Math.min(width, height));
                    width = Math.min(min, min);
                } else if (i2 == 4) {
                    width = Math.min(width, height);
                } else if (i2 != 5) {
                    throw new UnsupportedOperationException("ZoomableImageView does not support FIT_START or FIT_END");
                }
                height = width;
            } else {
                width = 1.0f;
                height = 1.0f;
            }
            float width2 = this.p.getWidth() - (width * f2);
            float height2 = this.p.getHeight() - (height * f3);
            this.r.setWidth(this.p.getWidth() - width2);
            this.r.setHeight(this.p.getHeight() - height2);
            if ((isZoomed() || this.l) && !(this.s.getWidth() == 0.0f && this.s.getHeight() == 0.0f)) {
                Matrix matrix = this.b;
                if (matrix == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prevMatrix");
                }
                float[] fArr = this.h;
                if (fArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                matrix.getValues(fArr);
                float[] fArr2 = this.h;
                if (fArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                fArr2[0] = (this.r.getWidth() / f2) * this.A;
                float[] fArr3 = this.h;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                fArr3[4] = (this.r.getHeight() / f3) * this.A;
                float[] fArr4 = this.h;
                if (fArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                float f4 = fArr4[2];
                float[] fArr5 = this.h;
                if (fArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                float f5 = fArr5[5];
                l(2, f4, this.s.getWidth() * this.A, getImageWidth(), this.q.getWidth(), this.p.getWidth(), intrinsicWidth);
                l(5, f5, this.s.getHeight() * this.A, getImageHeight(), this.q.getHeight(), this.p.getHeight(), intrinsicHeight);
                Matrix matrix2 = this.a;
                if (matrix2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
                }
                float[] fArr6 = this.h;
                if (fArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                matrix2.setValues(fArr6);
            } else {
                Matrix matrix3 = this.a;
                if (matrix3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
                }
                matrix3.setScale(width, height);
                Matrix matrix4 = this.a;
                if (matrix4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
                }
                float f6 = (float) 2;
                matrix4.postTranslate(width2 / f6, height2 / f6);
                this.A = 1.0f;
                this.z = 0.0f;
            }
            c();
            f();
        }
    }

    public final void b() {
        c();
        if (this.z == 0.0f) {
            Matrix matrix = this.a;
            if (matrix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            float[] fArr = this.h;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix.getValues(fArr);
            if (getImageWidth() < this.p.getWidth()) {
                float[] fArr2 = this.h;
                if (fArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                fArr2[2] = (this.p.getWidth() - getImageWidth()) / ((float) 2);
            }
            if (getImageHeight() < this.p.getHeight()) {
                float[] fArr3 = this.h;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("matrix");
                }
                fArr3[5] = (this.p.getHeight() - getImageHeight()) / ((float) 2);
            }
            Matrix matrix2 = this.a;
            if (matrix2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            float[] fArr4 = this.h;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix2.setValues(fArr4);
        }
    }

    public final void c() {
        Object obj;
        if (this.z == 0.0f) {
            Matrix matrix = this.a;
            if (matrix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            float[] fArr = this.h;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix.getValues(fArr);
            float[] fArr2 = this.h;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            float f2 = fArr2[2];
            float[] fArr3 = this.h;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            float f3 = fArr3[5];
            float e2 = e(f2, this.p.getWidth(), getImageWidth());
            float e3 = e(f3, this.p.getHeight(), getImageHeight());
            if (!(e2 == 0.0f && e3 == 0.0f)) {
                Matrix matrix2 = this.a;
                if (matrix2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
                }
                matrix2.postTranslate(e2, e3);
                return;
            }
            return;
        }
        KRect currentBounds = getCurrentBounds();
        if (currentBounds != null) {
            RectF rectF = this.y;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            KRect j2 = j(rectF);
            if (!currentBounds.contains(j2)) {
                KPoint center = j2.center();
                KPoint center2 = currentBounds.center();
                KRect moveBy = j2.moveBy(center2.getX() - center.getX(), center2.getY() - center.getY());
                List<KLine> clockwiseBorders = currentBounds.clockwiseBorders();
                List<KPoint> clockwiseHeights = moveBy.clockwiseHeights();
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(clockwiseHeights, 10));
                Iterator<T> it = clockwiseHeights.iterator();
                while (it.hasNext()) {
                    arrayList.add(((KLine) CollectionsKt___CollectionsKt.last((List<? extends Object>) clockwiseBorders)).normalFrom(it.next()));
                }
                Iterator it2 = arrayList.iterator();
                Object obj2 = null;
                if (!it2.hasNext()) {
                    obj = null;
                } else {
                    obj = it2.next();
                    if (it2.hasNext()) {
                        float length = ((KLine) obj).length();
                        do {
                            Object next = it2.next();
                            float length2 = ((KLine) next).length();
                            if (Float.compare(length, length2) > 0) {
                                obj = next;
                                length = length2;
                            }
                        } while (it2.hasNext());
                    }
                }
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                KLine kLine = (KLine) obj;
                boolean z2 = true;
                int indexOf = clockwiseHeights.indexOf(kLine.getP1()) + 1;
                ArrayList<KPoint> arrayList2 = new ArrayList();
                if (indexOf != clockwiseHeights.size()) {
                    arrayList2.addAll(clockwiseHeights.subList(indexOf, clockwiseHeights.size()));
                }
                arrayList2.addAll(clockwiseHeights.subList(0, indexOf));
                if (arrayList2.size() != clockwiseBorders.size()) {
                    z2 = false;
                }
                if (z2) {
                    KPoint a3 = i.a.invoke(moveBy.center(), kLine);
                    ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
                    for (KPoint kPoint : arrayList2) {
                        arrayList3.add(i.a.invoke(kPoint, kLine));
                    }
                    List<KPoint> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
                    ArrayList<KLine> arrayList4 = new ArrayList();
                    Iterator<T> it3 = clockwiseBorders.iterator();
                    KPoint kPoint2 = null;
                    while (it3.hasNext()) {
                        KLine normalFrom = it3.next().normalFrom((KPoint) mutableList.remove(0));
                        a3 = i.a.invoke(a3, normalFrom);
                        ArrayList arrayList5 = new ArrayList(t6.n.e.collectionSizeOrDefault(mutableList, 10));
                        for (KPoint kPoint3 : mutableList) {
                            arrayList5.add(i.a.invoke(kPoint3, normalFrom));
                        }
                        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList5);
                        if (kPoint2 != null) {
                            arrayList4.add(new KLine(kPoint2, a3));
                        }
                        kPoint2 = a3;
                    }
                    if (kPoint2 != null) {
                        arrayList4.add(new KLine(kPoint2, ((KLine) CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList4)).getP1()));
                    }
                    ArrayList arrayList6 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList4, 10));
                    for (KLine kLine2 : arrayList4) {
                        arrayList6.add(kLine2.nearestPointFor(center));
                    }
                    Iterator it4 = arrayList6.iterator();
                    if (it4.hasNext()) {
                        obj2 = it4.next();
                        if (it4.hasNext()) {
                            float length3 = new KLine((KPoint) obj2, center).length();
                            do {
                                Object next2 = it4.next();
                                float length4 = new KLine((KPoint) next2, center).length();
                                if (Float.compare(length3, length4) > 0) {
                                    obj2 = next2;
                                    length3 = length4;
                                }
                            } while (it4.hasNext());
                        }
                    }
                    KPoint kPoint4 = (KPoint) obj2;
                    if (kPoint4 != null) {
                        float x2 = center.getX() - kPoint4.getX();
                        float y2 = center.getY() - kPoint4.getY();
                        Matrix matrix3 = this.a;
                        if (matrix3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
                        }
                        matrix3.postTranslate(x2, y2);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Expected borders and heights sets to be same size".toString());
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr = this.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix.getValues(fArr);
        float[] fArr2 = this.h;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        float f2 = fArr2[2];
        if (getImageWidth() < this.p.getWidth()) {
            return false;
        }
        if (f2 >= ((float) -1) && i2 < 0) {
            return false;
        }
        if (this.p.getWidth() + Math.abs(f2) + 1.0f < getImageWidth() || i2 <= 0) {
            return true;
        }
        return false;
    }

    public final boolean canScrollHorizontallyFroyo(int i2) {
        return canScrollHorizontally(i2);
    }

    public final KRect d(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return null;
        }
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        float intrinsicHeight = (float) drawable.getIntrinsicHeight();
        float[] fArr = {0.0f, 0.0f, intrinsicWidth, 0.0f, intrinsicWidth, intrinsicHeight, 0.0f, intrinsicHeight};
        matrix.mapPoints(fArr);
        return new KRect(new KPoint(fArr[0] + ((float) getPaddingLeft()), fArr[1] + ((float) getPaddingTop())), new KPoint(fArr[2] + ((float) getPaddingRight()), fArr[3] + ((float) getPaddingTop())), new KPoint(fArr[4] + ((float) getPaddingRight()), fArr[5] + ((float) getPaddingBottom())), new KPoint(fArr[6] + ((float) getPaddingLeft()), fArr[7] + ((float) getPaddingBottom())));
    }

    public final float e(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f5 = f3 - f4;
            f6 = 0.0f;
        } else {
            f6 = f3 - f4;
            f5 = 0.0f;
        }
        if (f2 < f6) {
            return (-f2) + f6;
        }
        if (f2 > f5) {
            return (-f2) + f5;
        }
        return 0.0f;
    }

    public final void f() {
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        setImageMatrix(matrix);
    }

    public final void g() {
        if (this.p.getHeight() != 0.0f && this.p.getWidth() != 0.0f) {
            Matrix matrix = this.a;
            if (matrix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            float[] fArr = this.h;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix.getValues(fArr);
            Matrix matrix2 = this.b;
            if (matrix2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prevMatrix");
            }
            float[] fArr2 = this.h;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix2.setValues(fArr2);
            this.s.setHeight(this.r.getHeight());
            this.s.setWidth(this.r.getWidth());
            this.q.setHeight(this.p.getHeight());
            this.q.setWidth(this.p.getWidth());
        }
    }

    public final float getCurrentZoom() {
        return this.A;
    }

    @Nullable
    public final GestureDetector.OnDoubleTapListener getDoubleTapListener() {
        return this.v;
    }

    @NotNull
    public final RectF getImageBounds$krop_release() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return new RectF();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        rectF.set(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
        getImageMatrix().mapRect(rectF2, rectF);
        return new RectF(rectF2);
    }

    @Nullable
    public final ImageMoveListener getImageMoveListener() {
        return this.x;
    }

    public final float getMaxZoom() {
        return this.e;
    }

    public final float getMinZoom() {
        return this.d;
    }

    public final float getRotationAngle$krop_release() {
        return this.z;
    }

    @Override // android.widget.ImageView
    @NotNull
    public ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = this.k;
        if (scaleType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageScaleType");
        }
        return scaleType;
    }

    @Nullable
    public final PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = (float) 2;
        PointF k2 = k(this.p.getWidth() / f2, this.p.getHeight() / f2, true);
        k2.x /= (float) intrinsicWidth;
        k2.y /= (float) intrinsicHeight;
        return k2;
    }

    @NotNull
    public final Transformation getTransformation() {
        KPoint focusOffset = getFocusOffset();
        return new Transformation(this.A, new PointF(focusOffset.getX(), focusOffset.getY()), this.z);
    }

    @Nullable
    public final View.OnTouchListener getUserTouchListener() {
        return this.w;
    }

    @NotNull
    public final RectF getZoomedRect() {
        ImageView.ScaleType scaleType = this.k;
        if (scaleType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageScaleType");
        }
        if (scaleType != ImageView.ScaleType.FIT_XY) {
            PointF k2 = k(0.0f, 0.0f, true);
            PointF k3 = k(this.p.getWidth(), this.p.getHeight(), true);
            Drawable drawable = getDrawable();
            Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            Drawable drawable2 = getDrawable();
            Intrinsics.checkExpressionValueIsNotNull(drawable2, "drawable");
            float intrinsicHeight = (float) drawable2.getIntrinsicHeight();
            return new RectF(k2.x / intrinsicWidth, k2.y / intrinsicHeight, k3.x / intrinsicWidth, k3.y / intrinsicHeight);
        }
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    public final void h(double d2, float f2, float f3, boolean z2) {
        float f4;
        float f5;
        if (z2) {
            f4 = this.f;
            f5 = this.g;
        } else {
            f4 = this.d;
            f5 = this.e;
        }
        float f6 = this.A;
        float f7 = ((float) d2) * f6;
        this.A = f7;
        if (f7 > f5) {
            this.A = f5;
            d2 = (double) (f5 / f6);
        } else if (f7 < f4) {
            this.A = f4;
            d2 = (double) (f4 / f6);
        }
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float f8 = (float) d2;
        matrix.postScale(f8, f8, f2, f3);
        b();
    }

    public final void i(Context context) {
        setClickable(true);
        this.t = new ScaleGestureDetector(context, new f());
        this.u = new GestureDetector(context, new e());
        this.a = new Matrix();
        this.b = new Matrix();
        this.h = new float[9];
        this.A = 1.0f;
        this.k = ImageView.ScaleType.CENTER_CROP;
        this.d = 1.0f;
        this.e = 5.0f;
        this.f = 1.0f * 0.75f;
        this.g = 5.0f * 1.25f;
        f();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.c = g.NONE;
        this.m = false;
    }

    public final boolean isZoomed() {
        return this.A != 1.0f;
    }

    public final KRect j(@NotNull RectF rectF) {
        return new KRect(new KPoint(rectF.left, rectF.top), new KPoint(rectF.right, rectF.top), new KPoint(rectF.right, rectF.bottom), new KPoint(rectF.left, rectF.bottom));
    }

    public final PointF k(float f2, float f3, boolean z2) {
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr = this.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix.getValues(fArr);
        Drawable drawable = getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        Drawable drawable2 = getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable2, "drawable");
        float intrinsicHeight = (float) drawable2.getIntrinsicHeight();
        float[] fArr2 = this.h;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        float f4 = fArr2[2];
        float[] fArr3 = this.h;
        if (fArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        float f5 = fArr3[5];
        float imageWidth = ((f2 - f4) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f3 - f5) * intrinsicHeight) / getImageHeight();
        if (z2) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    public final void l(int i2, float f2, float f3, float f4, float f5, float f6, int i3) {
        if (f4 < f6) {
            float[] fArr = this.h;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            float f7 = (float) i3;
            float[] fArr2 = this.h;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            fArr[i2] = (f6 - (f7 * fArr2[0])) * 0.5f;
        } else if (f2 > ((float) 0)) {
            float[] fArr3 = this.h;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            fArr3[i2] = -((f4 - f6) / ((float) 2));
        } else {
            float f8 = (float) 2;
            float abs = ((f5 / f8) + Math.abs(f2)) / f3;
            float[] fArr4 = this.h;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            fArr4[i2] = -((abs * f4) - (f6 / f8));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005a: APUT  (r4v3 com.avito.android.krop.util.KLine[]), (0 ??[int, short, byte, char]), (r5v2 com.avito.android.krop.util.KLine) */
    public final void m() {
        KRect currentBounds = getCurrentBounds();
        if (currentBounds != null) {
            RectF rectF = this.y;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            if (currentBounds.contains(j(rectF))) {
                j jVar = new j(this);
                RectF rectF2 = this.y;
                if (rectF2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                float centerX = rectF2.centerX();
                RectF rectF3 = this.y;
                if (rectF3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                KPoint kPoint = new KPoint(centerX, rectF3.centerY());
                KLine[] kLineArr = new KLine[4];
                RectF rectF4 = this.y;
                if (rectF4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                float f2 = rectF4.left;
                RectF rectF5 = this.y;
                if (rectF5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                boolean z2 = false;
                kLineArr[0] = new KLine(kPoint, new KPoint(f2, rectF5.top));
                RectF rectF6 = this.y;
                if (rectF6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                float f3 = rectF6.left;
                RectF rectF7 = this.y;
                if (rectF7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                kLineArr[1] = new KLine(kPoint, new KPoint(f3, rectF7.bottom));
                RectF rectF8 = this.y;
                if (rectF8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                float f4 = rectF8.right;
                RectF rectF9 = this.y;
                if (rectF9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                kLineArr[2] = new KLine(kPoint, new KPoint(f4, rectF9.top));
                RectF rectF10 = this.y;
                if (rectF10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                float f5 = rectF10.right;
                RectF rectF11 = this.y;
                if (rectF11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                kLineArr[3] = new KLine(kPoint, new KPoint(f5, rectF11.bottom));
                List<KLine> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) kLineArr);
                ArrayList<Pair> arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(listOf, 10));
                for (KLine kLine : listOf) {
                    arrayList.add(TuplesKt.to(kLine.getP2(), new KLine(kLine.getP1(), jVar.invoke(kLine))));
                }
                List<KLine> clockwiseBorders = currentBounds.clockwiseBorders();
                ArrayList<Pair> arrayList2 = new ArrayList();
                for (Pair pair : arrayList) {
                    KPoint kPoint2 = (KPoint) pair.component1();
                    KLine kLine2 = (KLine) pair.component2();
                    Iterator<T> it = clockwiseBorders.iterator();
                    while (it.hasNext()) {
                        KPoint findIntersection = kLine2.findIntersection(it.next());
                        if (findIntersection != null) {
                            arrayList2.add(TuplesKt.to(kPoint2, new KLine(kPoint, findIntersection)));
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
                for (Pair pair2 : arrayList2) {
                    arrayList3.add(Float.valueOf(((KLine) pair2.component2()).length() / new KLine(kPoint, (KPoint) pair2.component1()).length()));
                }
                Float min = CollectionsKt___CollectionsKt.m360min((Iterable<Float>) arrayList3);
                Float f6 = null;
                if (min != null) {
                    if (min.floatValue() > 1.0f) {
                        z2 = true;
                    }
                    if (!z2) {
                        min = null;
                    }
                    f6 = min;
                }
                if (f6 != null) {
                    f6.floatValue();
                    setMinZoom(Math.max(this.A / f6.floatValue(), 1.0f));
                }
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        g();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        this.m = true;
        this.l = true;
        h hVar = this.n;
        if (hVar != null) {
            setZoom(hVar.a, hVar.b, hVar.c, hVar.d);
            this.n = null;
        }
        Transformation transformation = this.o;
        if (transformation != null) {
            setTransformation(transformation);
            this.o = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            intrinsicWidth = Math.min(intrinsicWidth, size);
        } else if (mode != 0) {
            intrinsicWidth = size;
        }
        if (mode2 == Integer.MIN_VALUE) {
            intrinsicHeight = Math.min(intrinsicHeight, size2);
        } else if (mode2 != 0) {
            intrinsicHeight = size2;
        }
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkParameterIsNotNull(parcelable, "state");
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.A = savedState.getCurrentZoom();
            this.z = savedState.getRotationAngle();
            setMaxZoom(savedState.getMaxZoom());
            setMinZoom(savedState.getMinZoom());
            this.h = savedState.getMatrix();
            this.s = savedState.getPrevMatchViewSize();
            this.q = savedState.getPrevViewSize();
            this.l = savedState.getImageRenderedAtLeastOnce();
            Matrix matrix = this.b;
            if (matrix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prevMatrix");
            }
            float[] fArr = this.h;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matrix");
            }
            matrix.setValues(fArr);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr = this.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix.getValues(fArr);
        Intrinsics.checkExpressionValueIsNotNull(onSaveInstanceState, "superState");
        float f2 = this.A;
        float f3 = this.z;
        float maxZoom = getMaxZoom();
        float minZoom = getMinZoom();
        float[] fArr2 = this.h;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        return new SavedState(onSaveInstanceState, f2, f3, maxZoom, minZoom, fArr2, this.r, this.p, this.l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r2 != 6) goto L_0x00d6;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r8) {
        /*
        // Method dump skipped, instructions count: 232
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.krop.ZoomableImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.avito.android.krop.ViewportUpdateListener
    public void onUpdateViewport(@NotNull RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "newViewport");
        this.y = rectF;
        SizeF sizeF = this.p;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        sizeF.setWidth(rectF.width());
        SizeF sizeF2 = this.p;
        RectF rectF2 = this.y;
        if (rectF2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        sizeF2.setHeight(rectF2.height());
        RectF rectF3 = this.y;
        if (rectF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        int i2 = (int) rectF3.left;
        RectF rectF4 = this.y;
        if (rectF4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewport");
        }
        int i3 = (int) rectF4.top;
        setPadding(i2, i3, i2, i3);
        a();
    }

    public final void resetZoom() {
        this.A = 1.0f;
        a();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x011c: APUT  
      (r6v3 com.avito.android.krop.util.KLine[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.krop.util.KLine : 0x0119: CONSTRUCTOR  (r7v2 com.avito.android.krop.util.KLine) = 
      (r5v6 com.avito.android.krop.util.KPoint)
      (wrap: com.avito.android.krop.util.KPoint : 0x0116: CONSTRUCTOR  (r8v0 com.avito.android.krop.util.KPoint) = 
      (r9v1 float)
      (wrap: float : 0x0114: IGET  (r10v1 float) = (r10v0 android.graphics.RectF) android.graphics.RectF.top float)
     call: com.avito.android.krop.util.KPoint.<init>(float, float):void type: CONSTRUCTOR)
     call: com.avito.android.krop.util.KLine.<init>(com.avito.android.krop.util.KPoint, com.avito.android.krop.util.KPoint):void type: CONSTRUCTOR)
     */
    public final void rotateBy(float f2, @NotNull ScaleAfterRotationStyle scaleAfterRotationStyle) {
        KRect currentBounds;
        KPoint center;
        a aVar;
        KRect currentBounds2;
        Intrinsics.checkParameterIsNotNull(scaleAfterRotationStyle, "scaleAnimation");
        if (!(f2 == 0.0f || (currentBounds = getCurrentBounds()) == null || (center = currentBounds.center()) == null)) {
            Matrix matrix = this.a;
            if (matrix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            Matrix matrix2 = new Matrix(matrix);
            matrix2.postTranslate(-center.getX(), -center.getY());
            matrix2.postRotate(f2);
            KRect d2 = d(matrix2);
            if (d2 == null) {
                Intrinsics.throwNpe();
            }
            KPoint center2 = d2.center();
            Matrix matrix3 = this.a;
            if (matrix3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            RectF rectF = this.y;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            float f3 = -rectF.centerX();
            RectF rectF2 = this.y;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            matrix3.postTranslate(f3, -rectF2.centerY());
            Matrix matrix4 = this.a;
            if (matrix4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            matrix4.postRotate(f2);
            Matrix matrix5 = this.a;
            if (matrix5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
            }
            RectF rectF3 = this.y;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            float centerX = rectF3.centerX() - center2.getX();
            RectF rectF4 = this.y;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewport");
            }
            matrix5.postTranslate(centerX, rectF4.centerY() - center2.getY());
            this.z = (this.z + f2) % ((float) 360);
            int ordinal = scaleAfterRotationStyle.ordinal();
            Float f4 = null;
            boolean z2 = true;
            if (ordinal == 0) {
                aVar = null;
            } else if (ordinal == 1) {
                aVar = new a(0, this);
            } else if (ordinal == 2) {
                aVar = new a(1, this);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (!(aVar == null || (currentBounds2 = getCurrentBounds()) == null)) {
                RectF rectF5 = this.y;
                if (rectF5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewport");
                }
                if (currentBounds2.contains(j(rectF5))) {
                    m();
                } else {
                    RectF rectF6 = this.y;
                    if (rectF6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    float centerX2 = rectF6.centerX();
                    RectF rectF7 = this.y;
                    if (rectF7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    KPoint kPoint = new KPoint(centerX2, rectF7.centerY());
                    KLine[] kLineArr = new KLine[4];
                    RectF rectF8 = this.y;
                    if (rectF8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    float f5 = rectF8.left;
                    RectF rectF9 = this.y;
                    if (rectF9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    kLineArr[0] = new KLine(kPoint, new KPoint(f5, rectF9.top));
                    RectF rectF10 = this.y;
                    if (rectF10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    float f6 = rectF10.left;
                    RectF rectF11 = this.y;
                    if (rectF11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    kLineArr[1] = new KLine(kPoint, new KPoint(f6, rectF11.bottom));
                    RectF rectF12 = this.y;
                    if (rectF12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    float f7 = rectF12.right;
                    RectF rectF13 = this.y;
                    if (rectF13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    kLineArr[2] = new KLine(kPoint, new KPoint(f7, rectF13.top));
                    RectF rectF14 = this.y;
                    if (rectF14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    float f8 = rectF14.right;
                    RectF rectF15 = this.y;
                    if (rectF15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewport");
                    }
                    kLineArr[3] = new KLine(kPoint, new KPoint(f8, rectF15.bottom));
                    List<KLine> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) kLineArr);
                    List<KLine> clockwiseBorders = currentBounds2.clockwiseBorders();
                    ArrayList arrayList = new ArrayList();
                    for (KLine kLine : listOf) {
                        Iterator<T> it = clockwiseBorders.iterator();
                        while (it.hasNext()) {
                            KPoint findIntersection = kLine.findIntersection(it.next());
                            if (findIntersection != null) {
                                arrayList.add(TuplesKt.to(findIntersection, kLine));
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        arrayList2.add(Float.valueOf(((KLine) pair.component2()).length() / new KLine(kPoint, (KPoint) pair.component1()).length()));
                    }
                    Float max = CollectionsKt___CollectionsKt.m356max((Iterable<Float>) arrayList2);
                    if (max != null) {
                        if (max.floatValue() <= 1.0f) {
                            z2 = false;
                        }
                        if (z2) {
                            f4 = max;
                        }
                    }
                    if (f4 != null) {
                        aVar.invoke(Float.valueOf(f4.floatValue()));
                    }
                }
            }
            f();
            ImageMoveListener imageMoveListener = this.x;
            if (imageMoveListener != null) {
                imageMoveListener.onMove();
            }
        }
    }

    public final void setDoubleTapListener(@Nullable GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.v = onDoubleTapListener;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bm");
        super.setImageBitmap(bitmap);
        g();
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        g();
        a();
    }

    public final void setImageMoveListener(@Nullable ImageMoveListener imageMoveListener) {
        this.x = imageMoveListener;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        g();
        a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        g();
        a();
    }

    public final void setMaxZoom(float f2) {
        this.e = f2;
        this.g = f2 * 1.25f;
    }

    public final void setMinZoom(float f2) {
        this.d = f2;
        this.f = f2 * 0.75f;
    }

    @Override // android.widget.ImageView
    public void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkParameterIsNotNull(scaleType, "type");
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("ZoomableImageView does not support FIT_START or FIT_END");
        }
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
        if (scaleType == scaleType2) {
            super.setScaleType(scaleType2);
            return;
        }
        this.k = scaleType;
        if (this.m) {
            setZoom(this);
        }
    }

    public final void setScrollPosition(float f2, float f3) {
        setZoom$default(this, this.A, f2, f3, null, 8, null);
    }

    public final void setTransformation(@NotNull Transformation transformation) {
        Intrinsics.checkParameterIsNotNull(transformation, "transformation");
        if (!this.m) {
            this.o = transformation;
            return;
        }
        setZoom$default(this, transformation.getScale(), 0.0f, 0.0f, null, 14, null);
        rotateBy(transformation.getRotationAngle(), ScaleAfterRotationStyle.INSTANT);
        float f2 = transformation.getFocusOffset().x;
        float f3 = transformation.getFocusOffset().y;
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        matrix.postTranslate(f2, f3);
        f();
    }

    public final void setUserTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        this.w = onTouchListener;
    }

    @JvmOverloads
    public final void setZoom(float f2) {
        setZoom$default(this, f2, 0.0f, 0.0f, null, 14, null);
    }

    @JvmOverloads
    public final void setZoom(float f2, float f3) {
        setZoom$default(this, f2, f3, 0.0f, null, 12, null);
    }

    @JvmOverloads
    public final void setZoom(float f2, float f3, float f4) {
        setZoom$default(this, f2, f3, f4, null, 8, null);
    }

    @JvmOverloads
    public final void setZoom(float f2, float f3, float f4, @NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkParameterIsNotNull(scaleType, "scaleType");
        if (!this.m) {
            this.n = new h(f2, f3, f4, scaleType);
            return;
        }
        ImageView.ScaleType scaleType2 = this.k;
        if (scaleType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageScaleType");
        }
        if (scaleType != scaleType2) {
            setScaleType(scaleType);
        }
        resetZoom();
        float f5 = (float) 2;
        h((double) f2, this.p.getWidth() / f5, this.p.getHeight() / f5, true);
        Matrix matrix = this.a;
        if (matrix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr = this.h;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix.getValues(fArr);
        float[] fArr2 = this.h;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        fArr2[2] = -((f3 * getImageWidth()) - (this.p.getWidth() / f5));
        float[] fArr3 = this.h;
        if (fArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        fArr3[5] = -((f4 * getImageHeight()) - (this.p.getHeight() / f5));
        Matrix matrix2 = this.a;
        if (matrix2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgMatrix");
        }
        float[] fArr4 = this.h;
        if (fArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matrix");
        }
        matrix2.setValues(fArr4);
        c();
        f();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        i(context);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013BQ\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\u001e¢\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\b/\u00102J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001d\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010&\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u0019\u0010,\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00064"}, d2 = {"Lcom/avito/android/krop/ZoomableImageView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/krop/util/SizeF;", "f", "Lcom/avito/android/krop/util/SizeF;", "getPrevMatchViewSize", "()Lcom/avito/android/krop/util/SizeF;", "prevMatchViewSize", "", "d", "F", "getMinZoom", "()F", "minZoom", "c", "getMaxZoom", "maxZoom", AuthSource.BOOKING_ORDER, "getRotationAngle", "rotationAngle", a2.g.r.g.a, "getPrevViewSize", "prevViewSize", "", "h", "Z", "getImageRenderedAtLeastOnce", "()Z", "imageRenderedAtLeastOnce", AuthSource.SEND_ABUSE, "getCurrentZoom", "currentZoom", "", "e", "[F", "getMatrix", "()[F", "matrix", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;FFFF[FLcom/avito/android/krop/util/SizeF;Lcom/avito/android/krop/util/SizeF;Z)V", "source", "(Landroid/os/Parcel;)V", "Companion", "krop_release"}, k = 1, mv = {1, 4, 0})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new ZoomableImageView$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion(null);
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        @NotNull
        public final float[] e;
        @NotNull
        public final SizeF f;
        @NotNull
        public final SizeF g;
        public final boolean h;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/krop/ZoomableImageView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/krop/ZoomableImageView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "krop_release"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            public Companion(t6.r.a.j jVar) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable, float f2, float f3, float f4, float f5, @NotNull float[] fArr, @NotNull SizeF sizeF, @NotNull SizeF sizeF2, boolean z) {
            super(parcelable);
            Intrinsics.checkParameterIsNotNull(parcelable, "superState");
            Intrinsics.checkParameterIsNotNull(fArr, "matrix");
            Intrinsics.checkParameterIsNotNull(sizeF, "prevMatchViewSize");
            Intrinsics.checkParameterIsNotNull(sizeF2, "prevViewSize");
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = fArr;
            this.f = sizeF;
            this.g = sizeF2;
            this.h = z;
        }

        public final float getCurrentZoom() {
            return this.a;
        }

        public final boolean getImageRenderedAtLeastOnce() {
            return this.h;
        }

        @NotNull
        public final float[] getMatrix() {
            return this.e;
        }

        public final float getMaxZoom() {
            return this.c;
        }

        public final float getMinZoom() {
            return this.d;
        }

        @NotNull
        public final SizeF getPrevMatchViewSize() {
            return this.f;
        }

        @NotNull
        public final SizeF getPrevViewSize() {
            return this.g;
        }

        public final float getRotationAngle() {
            return this.b;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeFloat(this.c);
            parcel.writeFloat(this.d);
            parcel.writeFloatArray(this.e);
            parcel.writeParcelable(this.f, i);
            parcel.writeParcelable(this.g, i);
            parcel.writeInt(this.h ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkParameterIsNotNull(parcel, "source");
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.c = parcel.readFloat();
            this.d = parcel.readFloat();
            float[] createFloatArray = parcel.createFloatArray();
            Intrinsics.checkExpressionValueIsNotNull(createFloatArray, "source.createFloatArray()");
            this.e = createFloatArray;
            Parcelable readParcelable = parcel.readParcelable(SizeF.class.getClassLoader());
            Intrinsics.checkExpressionValueIsNotNull(readParcelable, "source.readParcelable(Si…::class.java.classLoader)");
            this.f = (SizeF) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(SizeF.class.getClassLoader());
            Intrinsics.checkExpressionValueIsNotNull(readParcelable2, "source.readParcelable(Si…::class.java.classLoader)");
            this.g = (SizeF) readParcelable2;
            this.h = parcel.readInt() != 1 ? false : true;
        }
    }

    public final class c implements Runnable {
        public final long a;
        public final float b;
        public final float c;
        public final float d;
        public final AccelerateDecelerateInterpolator e;
        public final PointF f;
        public final PointF g;
        public final float h;
        public final boolean i;
        public final float j;
        public final boolean k;

        public c(float f2, float f3, float f4, boolean z, float f5, boolean z2) {
            ZoomableImageView.this = r1;
            this.h = f2;
            this.i = z;
            this.j = f5;
            this.k = z2;
            this.e = new AccelerateDecelerateInterpolator();
            r1.c = g.ANIMATE_ZOOM;
            this.a = System.currentTimeMillis();
            this.b = r1.getCurrentZoom();
            PointF k2 = r1.k(f3, f4, false);
            float f6 = k2.x;
            this.c = f6;
            float f7 = k2.y;
            this.d = f7;
            this.f = ZoomableImageView.access$transformCoordBitmapToTouch(r1, f6, f7);
            float f8 = (float) 2;
            this.g = new PointF(r1.p.getWidth() / f8, r1.p.getHeight() / f8);
        }

        @Override // java.lang.Runnable
        public void run() {
            float f2 = 1.0f;
            float interpolation = this.e.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.a)) / this.j));
            float f3 = this.b;
            double b2 = ((double) a2.b.a.a.a.b(this.h, f3, interpolation, f3)) / ((double) ZoomableImageView.this.getCurrentZoom());
            ZoomableImageView.this.h(b2, this.c, this.d, this.i);
            boolean z = false;
            boolean z2 = !this.k && ((Math.abs(b2 - ((double) 1.0f)) > ((double) 0.001f) ? 1 : (Math.abs(b2 - ((double) 1.0f)) == ((double) 0.001f) ? 0 : -1)) < 0);
            if (z2) {
                f2 = ((float) 1) - interpolation;
            }
            PointF pointF = this.f;
            float f4 = pointF.x;
            PointF pointF2 = this.g;
            float b3 = a2.b.a.a.a.b(pointF2.x, f4, interpolation, f4);
            float f5 = pointF.y;
            float b4 = a2.b.a.a.a.b(pointF2.y, f5, interpolation, f5);
            PointF access$transformCoordBitmapToTouch = ZoomableImageView.access$transformCoordBitmapToTouch(ZoomableImageView.this, this.c, this.d);
            ZoomableImageView.access$getImgMatrix$p(ZoomableImageView.this).postTranslate((b3 - access$transformCoordBitmapToTouch.x) * f2, (b4 - access$transformCoordBitmapToTouch.y) * f2);
            if (interpolation >= ((float) 1)) {
                z = true;
            }
            if (this.k || (z2 && z)) {
                ZoomableImageView.this.b();
            }
            ZoomableImageView.this.f();
            ImageMoveListener imageMoveListener = ZoomableImageView.this.getImageMoveListener();
            if (imageMoveListener != null) {
                imageMoveListener.onMove();
            }
            if (z) {
                ZoomableImageView.this.c = g.NONE;
            } else {
                ZoomableImageView.access$compatPostOnAnimation(ZoomableImageView.this, this);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(ZoomableImageView zoomableImageView, float f2, float f3, float f4, boolean z, float f5, boolean z2, int i2) {
            this(f2, f3, f4, z, (i2 & 16) != 0 ? 300.0f : f5, (i2 & 32) != 0 ? true : z2);
        }
    }

    public final void setZoom(@NotNull ZoomableImageView zoomableImageView) {
        Intrinsics.checkParameterIsNotNull(zoomableImageView, "img");
        PointF scrollPosition = zoomableImageView.getScrollPosition();
        if (scrollPosition != null) {
            setZoom(zoomableImageView.A, scrollPosition.x, scrollPosition.y, zoomableImageView.getScaleType());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomableImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        i(context);
    }
}
