package com.avito.android.image_loader;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiCommunityFull;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bk\b\b\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001Bé\u0001\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00101\u001a\u00020\b\u0012\b\u00102\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0010\u0012\b\u00105\u001a\u0004\u0018\u00010\u0013\u0012\b\u00106\u001a\u0004\u0018\u00010\u0005\u0012\b\u00107\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u00109\u001a\u00020\b\u0012\b\b\u0002\u0010:\u001a\u00020\b\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010<\u001a\u00020\b\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\b\b\u0002\u0010>\u001a\u00020&\u0012\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\"\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010A\u001a\u00020\b\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0010¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0000HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\nJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\nJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\nJ\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\"HÆ\u0003¢\u0006\u0004\b)\u0010%J\u0012\u0010+\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b-\u0010\nJ\u0012\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b.\u0010\u0012Jú\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u00022\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00101\u001a\u00020\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00103\u001a\u00020\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010<\u001a\u00020\b2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\b\u0002\u0010>\u001a\u00020&2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\"2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010A\u001a\u00020\b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020*HÖ\u0001¢\u0006\u0004\bE\u0010,J\u0010\u0010F\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\bF\u0010\u000fJ\u001a\u0010H\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bH\u0010IR\u001b\u0010;\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010 R\u001b\u00105\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0015R\"\u0010>\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010(\"\u0004\bS\u0010TR\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010\u0004R$\u0010@\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010,\"\u0004\b[\u0010\\R\u001b\u00107\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010\u0019R\u0019\u0010:\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010\nR\u001b\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010\u0007R\u001b\u00108\u001a\u0004\u0018\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u001bR(\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\b?\u0010%\"\u0004\bk\u0010lR\u001b\u00104\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010\u0012R$\u0010B\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bp\u0010n\u001a\u0004\bq\u0010\u0012\"\u0004\br\u0010sR\"\u00101\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010a\u001a\u0004\bu\u0010\n\"\u0004\bv\u0010wR*\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bx\u0010j\u001a\u0004\by\u0010%\"\u0004\bz\u0010lR$\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b{\u0010d\u001a\u0004\b|\u0010\u0007\"\u0004\b}\u0010~R\u001a\u00109\u001a\u00020\b8\u0006@\u0006¢\u0006\r\n\u0004\b\u0010a\u001a\u0005\b\u0001\u0010\nR'\u00103\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u000f\"\u0006\b\u0001\u0010\u0001R)\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\r\"\u0006\b\u0001\u0010\u0001R%\u0010A\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010\n\"\u0005\b\u0001\u0010wR\u001b\u0010<\u001a\u00020\b8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010a\u001a\u0005\b\u0001\u0010\n¨\u0006\u0001"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest;", "", "Lcom/avito/android/image_loader/ImageRequest$Source;", "component1", "()Lcom/avito/android/image_loader/ImageRequest$Source;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Z", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "component4", "()Lcom/avito/android/image_loader/BackgroundColorReceiver;", "component5", "()I", "Landroid/graphics/drawable/Drawable;", "component6", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/util/Rotation;", "component7", "()Lcom/avito/android/util/Rotation;", "component8", "Lcom/avito/android/image_loader/ImageRequestListener;", "component9", "()Lcom/avito/android/image_loader/ImageRequestListener;", "component10", "()Lcom/avito/android/image_loader/ImageRequest;", "component11", "component12", "", "component13", "()Ljava/lang/Float;", "component14", "Lkotlin/Function0;", "", "component15", "()Lkotlin/jvm/functions/Function0;", "Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "component16", "()Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "component17", "", "component18", "()Ljava/lang/String;", "component19", "component20", "source", "failureImage", "centerCrop", "backgroundColorReceiver", "cornerRadius", InternalConstsKt.PLACEHOLDER, "rotation", "dominantColorEdgeFallbackColor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "lowResRequest", "autoPlayAnimations", "noFadeAnimation", "aspectRatio", "retain", "onLoadFinished", "sourcePlace", "isConnectionAvailable", BookingInfoActivity.EXTRA_ITEM_ID, "cancelOnDetach", DownloadService.KEY_FOREGROUND, "copy", "(Lcom/avito/android/image_loader/ImageRequest$Source;Ljava/lang/Integer;ZLcom/avito/android/image_loader/BackgroundColorReceiver;ILandroid/graphics/drawable/Drawable;Lcom/avito/android/util/Rotation;Ljava/lang/Integer;Lcom/avito/android/image_loader/ImageRequestListener;Lcom/avito/android/image_loader/ImageRequest;ZZLjava/lang/Float;ZLkotlin/jvm/functions/Function0;Lcom/avito/android/image_loader/ImageRequest$SourcePlace;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLandroid/graphics/drawable/Drawable;)Lcom/avito/android/image_loader/ImageRequest;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Float;", "getAspectRatio", g.a, "Lcom/avito/android/util/Rotation;", "getRotation", "p", "Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "getSourcePlace", "setSourcePlace", "(Lcom/avito/android/image_loader/ImageRequest$SourcePlace;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/ImageRequest$Source;", "getSource", "r", "Ljava/lang/String;", "getAdvertId", "setAdvertId", "(Ljava/lang/String;)V", "i", "Lcom/avito/android/image_loader/ImageRequestListener;", "getListener", "l", "Z", "getNoFadeAnimation", "h", "Ljava/lang/Integer;", "getDominantColorEdgeFallbackColor", "j", "Lcom/avito/android/image_loader/ImageRequest;", "getLowResRequest", VKApiConst.Q, "Lkotlin/jvm/functions/Function0;", "setConnectionAvailable", "(Lkotlin/jvm/functions/Function0;)V", "f", "Landroid/graphics/drawable/Drawable;", "getPlaceholder", "t", "getForeground", "setForeground", "(Landroid/graphics/drawable/Drawable;)V", "c", "getCenterCrop", "setCenterCrop", "(Z)V", "o", "getOnLoadFinished", "setOnLoadFinished", AuthSource.BOOKING_ORDER, "getFailureImage", "setFailureImage", "(Ljava/lang/Integer;)V", "k", "getAutoPlayAnimations", "e", "I", "getCornerRadius", "setCornerRadius", "(I)V", "d", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "getBackgroundColorReceiver", "setBackgroundColorReceiver", "(Lcom/avito/android/image_loader/BackgroundColorReceiver;)V", "s", "getCancelOnDetach", "setCancelOnDetach", "n", "getRetain", "<init>", "(Lcom/avito/android/image_loader/ImageRequest$Source;Ljava/lang/Integer;ZLcom/avito/android/image_loader/BackgroundColorReceiver;ILandroid/graphics/drawable/Drawable;Lcom/avito/android/util/Rotation;Ljava/lang/Integer;Lcom/avito/android/image_loader/ImageRequestListener;Lcom/avito/android/image_loader/ImageRequest;ZZLjava/lang/Float;ZLkotlin/jvm/functions/Function0;Lcom/avito/android/image_loader/ImageRequest$SourcePlace;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLandroid/graphics/drawable/Drawable;)V", "Builder", "Source", "SourcePlace", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class ImageRequest {
    @NotNull
    public final Source a;
    @Nullable
    public Integer b;
    public boolean c;
    @Nullable
    public BackgroundColorReceiver d;
    public int e;
    @Nullable
    public final Drawable f;
    @Nullable
    public final Rotation g;
    @Nullable
    public final Integer h;
    @Nullable
    public final ImageRequestListener i;
    @Nullable
    public final ImageRequest j;
    public final boolean k;
    public final boolean l;
    @Nullable
    public final Float m;
    public final boolean n;
    @Nullable
    public Function0<Unit> o;
    @NotNull
    public SourcePlace p;
    @NotNull
    public Function0<Boolean> q;
    @Nullable
    public String r;
    public boolean s;
    @Nullable
    public Drawable t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0015\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010o¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000b¢\u0006\u0004\b!\u0010\rJ\u0017\u0010#\u001a\u00020\u00002\b\b\u0001\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\rJ\u0015\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u001d¢\u0006\u0004\b(\u0010\u001fJ\u0017\u0010)\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b)\u0010\nJ\u0015\u0010*\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b*\u0010\u0013J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u001d¢\u0006\u0004\b+\u0010\u001fJ\u0015\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u001d¢\u0006\u0004\b,\u0010\u001fJ\u0015\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u001f\u00103\u001a\u00020\u00002\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u00020\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d00¢\u0006\u0004\b:\u00104J\u0017\u0010<\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001d¢\u0006\u0004\b>\u0010\u001fJ\u0017\u0010?\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b?\u0010\nJ\r\u0010@\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u000201¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u000201¢\u0006\u0004\bD\u0010CR(\u0010?\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\b8\u0006@BX\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR(\u0010.\u001a\u0004\u0018\u00010-2\b\u0010E\u001a\u0004\u0018\u00010-8\u0006@BX\u000e¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010E\u001a\u0004\u0018\u00010$8\u0006@BX\u000e¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR$\u0010'\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d8\u0006@BX\u000e¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0006\u0010V\u001a\u0004\bW\u0010XR(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00158\u0006@BX\u000e¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R(\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R(\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\b8\u0006@BX\u000e¢\u0006\f\n\u0004\ba\u0010G\u001a\u0004\bb\u0010IR0\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001d002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001d008\u0006@BX\u000e¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\b:\u0010eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010AR(\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010E\u001a\u0004\u0018\u00010\u00198\u0006@BX\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR4\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u000e\u0010E\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0006@BX\u000e¢\u0006\f\n\u0004\bm\u0010d\u001a\u0004\bn\u0010eR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR$\u0010 \u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010E\u001a\u0004\u0018\u00010;8\u0006@BX\u000e¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR(\u0010}\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b{\u0010^\u001a\u0004\b|\u0010`R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d8\u0006@BX\u000e¢\u0006\f\n\u0004\b~\u0010S\u001a\u0004\b\u0010UR&\u0010>\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010U\"\u0006\b\u0001\u0010\u0001R&\u0010,\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d8\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR&\u0010+\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d8\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR(\u00107\u001a\u0002052\u0006\u0010E\u001a\u0002058\u0006@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Builder;", "", "Lcom/avito/android/image_loader/ImageRequest$Source;", "source", "Lcom/avito/android/image_loader/ImageRequest;", "lowResRequest", AuthSource.SEND_ABUSE, "(Lcom/avito/android/image_loader/ImageRequest$Source;Lcom/avito/android/image_loader/ImageRequest;)Lcom/avito/android/image_loader/ImageRequest;", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "", "resourceId", "(I)Lcom/avito/android/image_loader/ImageRequest$Builder;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "Lcom/avito/android/image_loader/Picture;", "picture", "(Lcom/avito/android/image_loader/Picture;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "failureImage", "Lcom/avito/android/util/Rotation;", "rotation", "rotate", "(Lcom/avito/android/util/Rotation;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "backgroundReceiver", "backgroundColorReceiver", "(Lcom/avito/android/image_loader/BackgroundColorReceiver;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "", "centerCrop", "(Z)Lcom/avito/android/image_loader/ImageRequest$Builder;", "cornerRadius", "roundedCorners", "fallbackColor", "dominantColorEdge", "Lcom/avito/android/image_loader/ImageRequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/avito/android/image_loader/ImageRequestListener;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "retain", "retainImage", InternalConstsKt.PLACEHOLDER, "lowResPicture", "autoPlayAnimations", "noFadeAnimation", "", "aspectRatio", "(F)Lcom/avito/android/image_loader/ImageRequest$Builder;", "Lkotlin/Function0;", "", "onLoadFinished", "onLoadFinishedCallback", "(Lkotlin/jvm/functions/Function0;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", VKApiCommunityFull.PLACE, "sourcePlace", "(Lcom/avito/android/image_loader/ImageRequest$SourcePlace;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "value", "isConnectionAvailable", "", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "cancelOnDetach", DownloadService.KEY_FOREGROUND, "build", "()Lcom/avito/android/image_loader/ImageRequest;", "load", "()V", "clear", "<set-?>", "t", "Landroid/graphics/drawable/Drawable;", "getForeground", "()Landroid/graphics/drawable/Drawable;", "n", "Ljava/lang/Float;", "getAspectRatio", "()Ljava/lang/Float;", "i", "Lcom/avito/android/image_loader/ImageRequestListener;", "getListener", "()Lcom/avito/android/image_loader/ImageRequestListener;", "j", "Z", "getRetain", "()Z", "Lcom/avito/android/image_loader/ImageRequest$Source;", "getSource", "()Lcom/avito/android/image_loader/ImageRequest$Source;", g.a, "Lcom/avito/android/util/Rotation;", "getRotation", "()Lcom/avito/android/util/Rotation;", "c", "Ljava/lang/Integer;", "getFailureImage", "()Ljava/lang/Integer;", "k", "getPlaceholder", VKApiConst.Q, "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/image_loader/ImageRequest;", "getLowResRequest", "e", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "getBackgroundColorReceiver", "()Lcom/avito/android/image_loader/BackgroundColorReceiver;", "o", "getOnLoadFinished", "Lcom/avito/android/image_loader/ImageLoader;", "u", "Lcom/avito/android/image_loader/ImageLoader;", "imageLoader", "f", "I", "getCornerRadius", "()I", "r", "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", "h", "getDominantColorEdgeFallbackColor", "dominantColorEdgeFallbackColor", "d", "getCenterCrop", "s", "getCancelOnDetach", "setCancelOnDetach", "(Z)V", AuthSource.OPEN_CHANNEL_LIST, "getNoFadeAnimation", "l", "getAutoPlayAnimations", "p", "Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "getSourcePlace", "()Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "<init>", "(Lcom/avito/android/image_loader/ImageLoader;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        @Nullable
        public Source a;
        @Nullable
        public ImageRequest b;
        @DrawableRes
        @Nullable
        public Integer c;
        public boolean d;
        @Nullable
        public BackgroundColorReceiver e;
        public int f;
        @Nullable
        public Rotation g;
        @Nullable
        public Integer h;
        @Nullable
        public ImageRequestListener i;
        public boolean j;
        @Nullable
        public Drawable k;
        public boolean l;
        public boolean m;
        @Nullable
        public Float n;
        @Nullable
        public Function0<Unit> o;
        @NotNull
        public SourcePlace p;
        @NotNull
        public Function0<Boolean> q;
        @Nullable
        public String r;
        public boolean s;
        @Nullable
        public Drawable t;
        public final ImageLoader u;

        public static final class a extends Lambda implements Function0<Boolean> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.TRUE;
            }
        }

        public Builder() {
            this(null, 1, null);
        }

        public Builder(@Nullable ImageLoader imageLoader) {
            this.u = imageLoader;
            this.p = SourcePlace.UNKNOWN;
            this.q = a.a;
            this.s = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.image_loader.ImageRequest$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder onLoadFinishedCallback$default(Builder builder, Function0 function0, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                function0 = null;
            }
            return builder.onLoadFinishedCallback(function0);
        }

        public final ImageRequest a(Source source, ImageRequest imageRequest) {
            return new ImageRequest(source, this.c, this.d, this.e, this.f, this.k, this.g, this.h, this.i, imageRequest, this.l, this.m, this.n, this.j, this.o, this.p, this.q, this.r, this.s, this.t);
        }

        @NotNull
        public final Builder advertId(@Nullable String str) {
            this.r = str;
            return this;
        }

        @NotNull
        public final Builder aspectRatio(float f2) {
            this.n = Float.valueOf(f2);
            return this;
        }

        @NotNull
        public final Builder autoPlayAnimations(boolean z) {
            this.l = z;
            return this;
        }

        @NotNull
        public final Builder backgroundColorReceiver(@Nullable BackgroundColorReceiver backgroundColorReceiver) {
            this.e = backgroundColorReceiver;
            return this;
        }

        @NotNull
        public final ImageRequest build() {
            Source source = this.a;
            if (source != null) {
                ImageRequest imageRequest = this.b;
                if (imageRequest == null || !this.j) {
                    return a(source, imageRequest);
                }
                throw new IllegalAccessException("Can't retain image with low res request!");
            }
            throw new IllegalArgumentException("Image source required to build image request".toString());
        }

        @NotNull
        public final Builder cancelOnDetach(boolean z) {
            this.s = z;
            return this;
        }

        @NotNull
        public final Builder centerCrop(boolean z) {
            this.d = z;
            return this;
        }

        public final void clear() {
            ImageLoader imageLoader = this.u;
            if (imageLoader != null) {
                Uri uri = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                imageLoader.load(uri(uri).build());
                return;
            }
            throw new IllegalArgumentException("Image loader is required to load image".toString());
        }

        @NotNull
        public final Builder dominantColorEdge(@ColorInt int i2) {
            this.h = Integer.valueOf(i2);
            return this;
        }

        @NotNull
        public final Builder drawable(@NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.a = new Source.DrawableSource(drawable);
            return this;
        }

        @NotNull
        public final Builder failureImage(@DrawableRes int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @NotNull
        public final Builder foreground(@Nullable Drawable drawable) {
            this.t = drawable;
            return this;
        }

        @Nullable
        public final String getAdvertId() {
            return this.r;
        }

        @Nullable
        public final Float getAspectRatio() {
            return this.n;
        }

        public final boolean getAutoPlayAnimations() {
            return this.l;
        }

        @Nullable
        public final BackgroundColorReceiver getBackgroundColorReceiver() {
            return this.e;
        }

        public final boolean getCancelOnDetach() {
            return this.s;
        }

        public final boolean getCenterCrop() {
            return this.d;
        }

        public final int getCornerRadius() {
            return this.f;
        }

        @Nullable
        public final Integer getDominantColorEdgeFallbackColor() {
            return this.h;
        }

        @Nullable
        public final Integer getFailureImage() {
            return this.c;
        }

        @Nullable
        public final Drawable getForeground() {
            return this.t;
        }

        @Nullable
        public final ImageRequestListener getListener() {
            return this.i;
        }

        @Nullable
        public final ImageRequest getLowResRequest() {
            return this.b;
        }

        public final boolean getNoFadeAnimation() {
            return this.m;
        }

        @Nullable
        public final Function0<Unit> getOnLoadFinished() {
            return this.o;
        }

        @Nullable
        public final Drawable getPlaceholder() {
            return this.k;
        }

        public final boolean getRetain() {
            return this.j;
        }

        @Nullable
        public final Rotation getRotation() {
            return this.g;
        }

        @Nullable
        public final Source getSource() {
            return this.a;
        }

        @NotNull
        public final SourcePlace getSourcePlace() {
            return this.p;
        }

        @NotNull
        public final Function0<Boolean> isConnectionAvailable() {
            return this.q;
        }

        @NotNull
        public final Builder listener(@NotNull ImageRequestListener imageRequestListener) {
            Intrinsics.checkNotNullParameter(imageRequestListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.i = imageRequestListener;
            return this;
        }

        public final void load() {
            ImageLoader imageLoader = this.u;
            if (imageLoader != null) {
                imageLoader.load(build());
                return;
            }
            throw new IllegalArgumentException("Image loader is required to load image".toString());
        }

        @NotNull
        public final Builder lowResPicture(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            this.b = a(new Source.ImageSource(picture), null);
            return this;
        }

        @NotNull
        public final Builder noFadeAnimation(boolean z) {
            this.m = z;
            return this;
        }

        @NotNull
        public final Builder onLoadFinishedCallback(@Nullable Function0<Unit> function0) {
            this.o = function0;
            return this;
        }

        @NotNull
        public final Builder picture(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            this.a = new Source.ImageSource(picture);
            return this;
        }

        @NotNull
        public final Builder placeholder(@Nullable Drawable drawable) {
            this.k = drawable;
            return this;
        }

        @NotNull
        public final Builder retainImage(boolean z) {
            this.j = z;
            return this;
        }

        @NotNull
        public final Builder rotate(@NotNull Rotation rotation) {
            Intrinsics.checkNotNullParameter(rotation, "rotation");
            this.g = rotation;
            return this;
        }

        @NotNull
        public final Builder roundedCorners(int i2) {
            this.f = i2;
            return this;
        }

        public final void setCancelOnDetach(boolean z) {
            this.s = z;
        }

        @NotNull
        public final Builder sourcePlace(@NotNull SourcePlace sourcePlace) {
            Intrinsics.checkNotNullParameter(sourcePlace, VKApiCommunityFull.PLACE);
            this.p = sourcePlace;
            return this;
        }

        @NotNull
        public final Builder uri(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            this.a = new Source.UriSource(uri);
            return this;
        }

        @NotNull
        public final Builder drawable(@DrawableRes int i2) {
            this.a = new Source.ResourceDrawableSource(i2);
            return this;
        }

        @NotNull
        public final Builder isConnectionAvailable(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, "value");
            this.q = function0;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageLoader imageLoader, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : imageLoader);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Source;", "", "<init>", "()V", "DrawableSource", "ImageSource", "ResourceDrawableSource", "UriSource", "Lcom/avito/android/image_loader/ImageRequest$Source$DrawableSource;", "Lcom/avito/android/image_loader/ImageRequest$Source$ResourceDrawableSource;", "Lcom/avito/android/image_loader/ImageRequest$Source$UriSource;", "Lcom/avito/android/image_loader/ImageRequest$Source$ImageSource;", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Source {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Source$DrawableSource;", "Lcom/avito/android/image_loader/ImageRequest$Source;", "Landroid/graphics/drawable/Drawable;", "component1", "()Landroid/graphics/drawable/Drawable;", "drawable", "copy", "(Landroid/graphics/drawable/Drawable;)Lcom/avito/android/image_loader/ImageRequest$Source$DrawableSource;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable;", "getDrawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
        public static final class DrawableSource extends Source {
            @NotNull
            public final Drawable a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DrawableSource(@NotNull Drawable drawable) {
                super(null);
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                this.a = drawable;
            }

            public static /* synthetic */ DrawableSource copy$default(DrawableSource drawableSource, Drawable drawable, int i, Object obj) {
                if ((i & 1) != 0) {
                    drawable = drawableSource.a;
                }
                return drawableSource.copy(drawable);
            }

            @NotNull
            public final Drawable component1() {
                return this.a;
            }

            @NotNull
            public final DrawableSource copy(@NotNull Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                return new DrawableSource(drawable);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof DrawableSource) && Intrinsics.areEqual(this.a, ((DrawableSource) obj).a);
                }
                return true;
            }

            @NotNull
            public final Drawable getDrawable() {
                return this.a;
            }

            public int hashCode() {
                Drawable drawable = this.a;
                if (drawable != null) {
                    return drawable.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("DrawableSource(drawable=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Source$ImageSource;", "Lcom/avito/android/image_loader/ImageRequest$Source;", "Lcom/avito/android/image_loader/Picture;", "component1", "()Lcom/avito/android/image_loader/Picture;", "picture", "copy", "(Lcom/avito/android/image_loader/Picture;)Lcom/avito/android/image_loader/ImageRequest$Source$ImageSource;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/Picture;", "getPicture", "<init>", "(Lcom/avito/android/image_loader/Picture;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
        public static final class ImageSource extends Source {
            @NotNull
            public final Picture a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ImageSource(@NotNull Picture picture) {
                super(null);
                Intrinsics.checkNotNullParameter(picture, "picture");
                this.a = picture;
            }

            public static /* synthetic */ ImageSource copy$default(ImageSource imageSource, Picture picture, int i, Object obj) {
                if ((i & 1) != 0) {
                    picture = imageSource.a;
                }
                return imageSource.copy(picture);
            }

            @NotNull
            public final Picture component1() {
                return this.a;
            }

            @NotNull
            public final ImageSource copy(@NotNull Picture picture) {
                Intrinsics.checkNotNullParameter(picture, "picture");
                return new ImageSource(picture);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ImageSource) && Intrinsics.areEqual(this.a, ((ImageSource) obj).a);
                }
                return true;
            }

            @NotNull
            public final Picture getPicture() {
                return this.a;
            }

            public int hashCode() {
                Picture picture = this.a;
                if (picture != null) {
                    return picture.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ImageSource(picture=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Source$ResourceDrawableSource;", "Lcom/avito/android/image_loader/ImageRequest$Source;", "", "component1", "()I", "drawable", "copy", "(I)Lcom/avito/android/image_loader/ImageRequest$Source$ResourceDrawableSource;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getDrawable", "<init>", "(I)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
        public static final class ResourceDrawableSource extends Source {
            public final int a;

            public ResourceDrawableSource(@DrawableRes int i) {
                super(null);
                this.a = i;
            }

            public static /* synthetic */ ResourceDrawableSource copy$default(ResourceDrawableSource resourceDrawableSource, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = resourceDrawableSource.a;
                }
                return resourceDrawableSource.copy(i);
            }

            public final int component1() {
                return this.a;
            }

            @NotNull
            public final ResourceDrawableSource copy(@DrawableRes int i) {
                return new ResourceDrawableSource(i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ResourceDrawableSource) && this.a == ((ResourceDrawableSource) obj).a;
                }
                return true;
            }

            public final int getDrawable() {
                return this.a;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.j(a2.b.a.a.a.L("ResourceDrawableSource(drawable="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$Source$UriSource;", "Lcom/avito/android/image_loader/ImageRequest$Source;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "copy", "(Landroid/net/Uri;)Lcom/avito/android/image_loader/ImageRequest$Source$UriSource;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "<init>", "(Landroid/net/Uri;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
        public static final class UriSource extends Source {
            @NotNull
            public final Uri a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UriSource(@NotNull Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                this.a = uri;
            }

            public static /* synthetic */ UriSource copy$default(UriSource uriSource, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = uriSource.a;
                }
                return uriSource.copy(uri);
            }

            @NotNull
            public final Uri component1() {
                return this.a;
            }

            @NotNull
            public final UriSource copy(@NotNull Uri uri) {
                Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                return new UriSource(uri);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof UriSource) && Intrinsics.areEqual(this.a, ((UriSource) obj).a);
                }
                return true;
            }

            @NotNull
            public final Uri getUri() {
                return this.a;
            }

            public int hashCode() {
                Uri uri = this.a;
                if (uri != null) {
                    return uri.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("UriSource(uri=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        public Source() {
        }

        public Source(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/image_loader/ImageRequest$SourcePlace;", "", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SNIPPET", "ADVERT_DETAILS_GALLERY", "FULLSCREEN_GALLERY", "UNKNOWN", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public enum SourcePlace {
        SNIPPET,
        ADVERT_DETAILS_GALLERY,
        FULLSCREEN_GALLERY,
        UNKNOWN
    }

    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public ImageRequest(@NotNull Source source, @DrawableRes @Nullable Integer num, boolean z, @Nullable BackgroundColorReceiver backgroundColorReceiver, int i2, @Nullable Drawable drawable, @Nullable Rotation rotation, @Nullable Integer num2, @Nullable ImageRequestListener imageRequestListener, @Nullable ImageRequest imageRequest, boolean z2, boolean z3, @Nullable Float f2, boolean z4, @Nullable Function0<Unit> function0, @NotNull SourcePlace sourcePlace, @NotNull Function0<Boolean> function02, @Nullable String str, boolean z5, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sourcePlace, "sourcePlace");
        Intrinsics.checkNotNullParameter(function02, "isConnectionAvailable");
        this.a = source;
        this.b = num;
        this.c = z;
        this.d = backgroundColorReceiver;
        this.e = i2;
        this.f = drawable;
        this.g = rotation;
        this.h = num2;
        this.i = imageRequestListener;
        this.j = imageRequest;
        this.k = z2;
        this.l = z3;
        this.m = f2;
        this.n = z4;
        this.o = function0;
        this.p = sourcePlace;
        this.q = function02;
        this.r = str;
        this.s = z5;
        this.t = drawable2;
    }

    public static /* synthetic */ ImageRequest copy$default(ImageRequest imageRequest, Source source, Integer num, boolean z, BackgroundColorReceiver backgroundColorReceiver, int i2, Drawable drawable, Rotation rotation, Integer num2, ImageRequestListener imageRequestListener, ImageRequest imageRequest2, boolean z2, boolean z3, Float f2, boolean z4, Function0 function0, SourcePlace sourcePlace, Function0 function02, String str, boolean z5, Drawable drawable2, int i3, Object obj) {
        return imageRequest.copy((i3 & 1) != 0 ? imageRequest.a : source, (i3 & 2) != 0 ? imageRequest.b : num, (i3 & 4) != 0 ? imageRequest.c : z, (i3 & 8) != 0 ? imageRequest.d : backgroundColorReceiver, (i3 & 16) != 0 ? imageRequest.e : i2, (i3 & 32) != 0 ? imageRequest.f : drawable, (i3 & 64) != 0 ? imageRequest.g : rotation, (i3 & 128) != 0 ? imageRequest.h : num2, (i3 & 256) != 0 ? imageRequest.i : imageRequestListener, (i3 & 512) != 0 ? imageRequest.j : imageRequest2, (i3 & 1024) != 0 ? imageRequest.k : z2, (i3 & 2048) != 0 ? imageRequest.l : z3, (i3 & 4096) != 0 ? imageRequest.m : f2, (i3 & 8192) != 0 ? imageRequest.n : z4, (i3 & 16384) != 0 ? imageRequest.o : function0, (i3 & 32768) != 0 ? imageRequest.p : sourcePlace, (i3 & 65536) != 0 ? imageRequest.q : function02, (i3 & 131072) != 0 ? imageRequest.r : str, (i3 & 262144) != 0 ? imageRequest.s : z5, (i3 & 524288) != 0 ? imageRequest.t : drawable2);
    }

    @NotNull
    public final Source component1() {
        return this.a;
    }

    @Nullable
    public final ImageRequest component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    public final boolean component12() {
        return this.l;
    }

    @Nullable
    public final Float component13() {
        return this.m;
    }

    public final boolean component14() {
        return this.n;
    }

    @Nullable
    public final Function0<Unit> component15() {
        return this.o;
    }

    @NotNull
    public final SourcePlace component16() {
        return this.p;
    }

    @NotNull
    public final Function0<Boolean> component17() {
        return this.q;
    }

    @Nullable
    public final String component18() {
        return this.r;
    }

    public final boolean component19() {
        return this.s;
    }

    @Nullable
    public final Integer component2() {
        return this.b;
    }

    @Nullable
    public final Drawable component20() {
        return this.t;
    }

    public final boolean component3() {
        return this.c;
    }

    @Nullable
    public final BackgroundColorReceiver component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @Nullable
    public final Drawable component6() {
        return this.f;
    }

    @Nullable
    public final Rotation component7() {
        return this.g;
    }

    @Nullable
    public final Integer component8() {
        return this.h;
    }

    @Nullable
    public final ImageRequestListener component9() {
        return this.i;
    }

    @NotNull
    public final ImageRequest copy(@NotNull Source source, @DrawableRes @Nullable Integer num, boolean z, @Nullable BackgroundColorReceiver backgroundColorReceiver, int i2, @Nullable Drawable drawable, @Nullable Rotation rotation, @Nullable Integer num2, @Nullable ImageRequestListener imageRequestListener, @Nullable ImageRequest imageRequest, boolean z2, boolean z3, @Nullable Float f2, boolean z4, @Nullable Function0<Unit> function0, @NotNull SourcePlace sourcePlace, @NotNull Function0<Boolean> function02, @Nullable String str, boolean z5, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sourcePlace, "sourcePlace");
        Intrinsics.checkNotNullParameter(function02, "isConnectionAvailable");
        return new ImageRequest(source, num, z, backgroundColorReceiver, i2, drawable, rotation, num2, imageRequestListener, imageRequest, z2, z3, f2, z4, function0, sourcePlace, function02, str, z5, drawable2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual(this.a, imageRequest.a) && Intrinsics.areEqual(this.b, imageRequest.b) && this.c == imageRequest.c && Intrinsics.areEqual(this.d, imageRequest.d) && this.e == imageRequest.e && Intrinsics.areEqual(this.f, imageRequest.f) && Intrinsics.areEqual(this.g, imageRequest.g) && Intrinsics.areEqual(this.h, imageRequest.h) && Intrinsics.areEqual(this.i, imageRequest.i) && Intrinsics.areEqual(this.j, imageRequest.j) && this.k == imageRequest.k && this.l == imageRequest.l && Intrinsics.areEqual(this.m, imageRequest.m) && this.n == imageRequest.n && Intrinsics.areEqual(this.o, imageRequest.o) && Intrinsics.areEqual(this.p, imageRequest.p) && Intrinsics.areEqual(this.q, imageRequest.q) && Intrinsics.areEqual(this.r, imageRequest.r) && this.s == imageRequest.s && Intrinsics.areEqual(this.t, imageRequest.t);
    }

    @Nullable
    public final String getAdvertId() {
        return this.r;
    }

    @Nullable
    public final Float getAspectRatio() {
        return this.m;
    }

    public final boolean getAutoPlayAnimations() {
        return this.k;
    }

    @Nullable
    public final BackgroundColorReceiver getBackgroundColorReceiver() {
        return this.d;
    }

    public final boolean getCancelOnDetach() {
        return this.s;
    }

    public final boolean getCenterCrop() {
        return this.c;
    }

    public final int getCornerRadius() {
        return this.e;
    }

    @Nullable
    public final Integer getDominantColorEdgeFallbackColor() {
        return this.h;
    }

    @Nullable
    public final Integer getFailureImage() {
        return this.b;
    }

    @Nullable
    public final Drawable getForeground() {
        return this.t;
    }

    @Nullable
    public final ImageRequestListener getListener() {
        return this.i;
    }

    @Nullable
    public final ImageRequest getLowResRequest() {
        return this.j;
    }

    public final boolean getNoFadeAnimation() {
        return this.l;
    }

    @Nullable
    public final Function0<Unit> getOnLoadFinished() {
        return this.o;
    }

    @Nullable
    public final Drawable getPlaceholder() {
        return this.f;
    }

    public final boolean getRetain() {
        return this.n;
    }

    @Nullable
    public final Rotation getRotation() {
        return this.g;
    }

    @NotNull
    public final Source getSource() {
        return this.a;
    }

    @NotNull
    public final SourcePlace getSourcePlace() {
        return this.p;
    }

    public int hashCode() {
        Source source = this.a;
        int i2 = 0;
        int hashCode = (source != null ? source.hashCode() : 0) * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        boolean z = this.c;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode2 + i4) * 31;
        BackgroundColorReceiver backgroundColorReceiver = this.d;
        int hashCode3 = (((i7 + (backgroundColorReceiver != null ? backgroundColorReceiver.hashCode() : 0)) * 31) + this.e) * 31;
        Drawable drawable = this.f;
        int hashCode4 = (hashCode3 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Rotation rotation = this.g;
        int hashCode5 = (hashCode4 + (rotation != null ? rotation.hashCode() : 0)) * 31;
        Integer num2 = this.h;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ImageRequestListener imageRequestListener = this.i;
        int hashCode7 = (hashCode6 + (imageRequestListener != null ? imageRequestListener.hashCode() : 0)) * 31;
        ImageRequest imageRequest = this.j;
        int hashCode8 = (hashCode7 + (imageRequest != null ? imageRequest.hashCode() : 0)) * 31;
        boolean z2 = this.k;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (hashCode8 + i8) * 31;
        boolean z3 = this.l;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        Float f2 = this.m;
        int hashCode9 = (i15 + (f2 != null ? f2.hashCode() : 0)) * 31;
        boolean z4 = this.n;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (hashCode9 + i16) * 31;
        Function0<Unit> function0 = this.o;
        int hashCode10 = (i19 + (function0 != null ? function0.hashCode() : 0)) * 31;
        SourcePlace sourcePlace = this.p;
        int hashCode11 = (hashCode10 + (sourcePlace != null ? sourcePlace.hashCode() : 0)) * 31;
        Function0<Boolean> function02 = this.q;
        int hashCode12 = (hashCode11 + (function02 != null ? function02.hashCode() : 0)) * 31;
        String str = this.r;
        int hashCode13 = (hashCode12 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z5 = this.s;
        if (!z5) {
            i3 = z5 ? 1 : 0;
        }
        int i20 = (hashCode13 + i3) * 31;
        Drawable drawable2 = this.t;
        if (drawable2 != null) {
            i2 = drawable2.hashCode();
        }
        return i20 + i2;
    }

    @NotNull
    public final Function0<Boolean> isConnectionAvailable() {
        return this.q;
    }

    public final void setAdvertId(@Nullable String str) {
        this.r = str;
    }

    public final void setBackgroundColorReceiver(@Nullable BackgroundColorReceiver backgroundColorReceiver) {
        this.d = backgroundColorReceiver;
    }

    public final void setCancelOnDetach(boolean z) {
        this.s = z;
    }

    public final void setCenterCrop(boolean z) {
        this.c = z;
    }

    public final void setConnectionAvailable(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.q = function0;
    }

    public final void setCornerRadius(int i2) {
        this.e = i2;
    }

    public final void setFailureImage(@Nullable Integer num) {
        this.b = num;
    }

    public final void setForeground(@Nullable Drawable drawable) {
        this.t = drawable;
    }

    public final void setOnLoadFinished(@Nullable Function0<Unit> function0) {
        this.o = function0;
    }

    public final void setSourcePlace(@NotNull SourcePlace sourcePlace) {
        Intrinsics.checkNotNullParameter(sourcePlace, "<set-?>");
        this.p = sourcePlace;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ImageRequest(source=");
        L.append(this.a);
        L.append(", failureImage=");
        L.append(this.b);
        L.append(", centerCrop=");
        L.append(this.c);
        L.append(", backgroundColorReceiver=");
        L.append(this.d);
        L.append(", cornerRadius=");
        L.append(this.e);
        L.append(", placeholder=");
        L.append(this.f);
        L.append(", rotation=");
        L.append(this.g);
        L.append(", dominantColorEdgeFallbackColor=");
        L.append(this.h);
        L.append(", listener=");
        L.append(this.i);
        L.append(", lowResRequest=");
        L.append(this.j);
        L.append(", autoPlayAnimations=");
        L.append(this.k);
        L.append(", noFadeAnimation=");
        L.append(this.l);
        L.append(", aspectRatio=");
        L.append(this.m);
        L.append(", retain=");
        L.append(this.n);
        L.append(", onLoadFinished=");
        L.append(this.o);
        L.append(", sourcePlace=");
        L.append(this.p);
        L.append(", isConnectionAvailable=");
        L.append(this.q);
        L.append(", advertId=");
        L.append(this.r);
        L.append(", cancelOnDetach=");
        L.append(this.s);
        L.append(", foreground=");
        L.append(this.t);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageRequest(Source source, Integer num, boolean z, BackgroundColorReceiver backgroundColorReceiver, int i2, Drawable drawable, Rotation rotation, Integer num2, ImageRequestListener imageRequestListener, ImageRequest imageRequest, boolean z2, boolean z3, Float f2, boolean z4, Function0 function0, SourcePlace sourcePlace, Function0 function02, String str, boolean z5, Drawable drawable2, int i3, j jVar) {
        this(source, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z, backgroundColorReceiver, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? null : drawable, rotation, num2, imageRequestListener, (i3 & 512) != 0 ? null : imageRequest, (i3 & 1024) != 0 ? false : z2, (i3 & 2048) != 0 ? false : z3, (i3 & 4096) != 0 ? null : f2, (i3 & 8192) != 0 ? false : z4, (i3 & 16384) != 0 ? null : function0, (32768 & i3) != 0 ? SourcePlace.UNKNOWN : sourcePlace, (65536 & i3) != 0 ? a.a : function02, (131072 & i3) != 0 ? null : str, (262144 & i3) != 0 ? true : z5, (i3 & 524288) != 0 ? null : drawable2);
    }
}
