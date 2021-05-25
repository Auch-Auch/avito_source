package ru.sravni.android.bankproduct.utils.components.wraprefreshlayout;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0006»\u0001Æ\u0001Ô\u0001\u0018\u0000 ¢\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0006¢\u0002£\u0002¤\u0002B%\b\u0007\u0012\n\b\u0001\u0010\u0002\u001a\u00030\u0002\u0012\f\b\u0003\u0010\u0002\u001a\u0005\u0018\u00010\u0002¢\u0006\u0006\b \u0002\u0010¡\u0002J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010\u0014J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0014¢\u0006\u0004\b(\u0010\u0014J%\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u0010\bJ\u001f\u00104\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0014¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00062\b\b\u0001\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0018H\u0000¢\u0006\u0004\b;\u0010\u001bJ\u0019\u0010@\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010=H\u0000¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0004H\u0007¢\u0006\u0004\bB\u0010\bJ\u0017\u0010C\u001a\u00020\u00062\b\b\u0001\u0010A\u001a\u00020\u0004¢\u0006\u0004\bC\u0010\bJ\u0017\u0010E\u001a\u00020\u00062\b\b\u0001\u0010D\u001a\u00020\u0004¢\u0006\u0004\bE\u0010\bJ\u001d\u0010H\u001a\u00020\u00062\f\b\u0001\u0010G\u001a\u00020F\"\u00020\u0004H\u0007¢\u0006\u0004\bH\u0010IJ\u001b\u0010K\u001a\u00020\u00062\f\b\u0001\u0010J\u001a\u00020F\"\u00020\u0004¢\u0006\u0004\bK\u0010IJ\u001b\u0010L\u001a\u00020\u00062\f\b\u0001\u0010G\u001a\u00020F\"\u00020\u0004¢\u0006\u0004\bL\u0010IJ\u0015\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0004¢\u0006\u0004\bN\u0010\bJ7\u0010T\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0014¢\u0006\u0004\bT\u0010UJ\u001f\u0010X\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0004H\u0014¢\u0006\u0004\bX\u0010YJ7\u0010`\u001a\u00020\u00062\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004H\u0014¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\t¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020\u00062\b\b\u0001\u0010e\u001a\u00020d¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\bj\u0010'J'\u0010m\u001a\u00020\t2\u0006\u0010[\u001a\u00020Z2\u0006\u0010k\u001a\u00020Z2\u0006\u0010l\u001a\u00020\u0004H\u0016¢\u0006\u0004\bm\u0010nJ'\u0010p\u001a\u00020\u00062\u0006\u0010[\u001a\u00020Z2\u0006\u0010k\u001a\u00020Z2\u0006\u0010o\u001a\u00020\u0004H\u0016¢\u0006\u0004\bp\u0010qJ/\u0010u\u001a\u00020\u00062\u0006\u0010k\u001a\u00020Z2\u0006\u0010r\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020FH\u0016¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\u0004H\u0016¢\u0006\u0004\bw\u0010xJ\u0017\u0010y\u001a\u00020\u00062\u0006\u0010k\u001a\u00020ZH\u0016¢\u0006\u0004\by\u0010zJ7\u0010\u001a\u00020\u00062\u0006\u0010k\u001a\u00020Z2\u0006\u0010{\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010aJ\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010'J\u0011\u0010\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010cJ\u001a\u0010\u0001\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u0004H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u0014J\u0011\u0010\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010cJ=\u0010\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J7\u0010\u0001\u001a\u00020\t2\u0006\u0010r\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u00042\b\u0010t\u001a\u0004\u0018\u00010F2\t\u0010\u0001\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00020\t2\u0006\u0010k\u001a\u00020Z2\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0018H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J4\u0010\u0001\u001a\u00020\t2\u0006\u0010k\u001a\u00020Z2\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0018H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0005\b\u0001\u0010iJ\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0005\b\u0001\u0010\u001bJ\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0005\b\u0001\u0010\bR\u0019\u0010\u0001\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R&\u0010¥\u0001\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0015\n\u0005\b!\u0010¢\u0001\u001a\u0005\b£\u0001\u0010c\"\u0005\b¤\u0001\u0010'R\u0019\u0010¨\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R0\u0010­\u0001\u001a\u00020\u00042\u0007\u0010©\u0001\u001a\u00020\u00048\u0006@@X\u000e¢\u0006\u0016\n\u0006\bª\u0001\u0010§\u0001\u001a\u0005\b«\u0001\u0010x\"\u0005\b¬\u0001\u0010\bR*\u0010¯\u0001\u001a\u00030®\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¶\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0016\u0010µ\u0001R'\u0010º\u0001\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0016\n\u0006\b·\u0001\u0010§\u0001\u001a\u0005\b¸\u0001\u0010x\"\u0005\b¹\u0001\u0010\bR\u001a\u0010¾\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R*\u0010À\u0001\u001a\u00030¿\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010É\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010\u0001R'\u0010Î\u0001\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0006\b\u0001\u0010¢\u0001\u001a\u0005\bÌ\u0001\u0010c\"\u0005\bÍ\u0001\u0010'R\u0018\u0010Ï\u0001\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\f\u0010§\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010¢\u0001R\u0019\u0010Ó\u0001\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010§\u0001R\u001a\u0010×\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001f\u0010Ú\u0001\u001a\t\u0012\u0004\u0012\u00020Z0Ø\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010Ù\u0001R\u0018\u0010Û\u0001\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010\u0001R/\u0010Þ\u0001\u001a\u00020\u00042\u0007\u0010©\u0001\u001a\u00020\u00048\u0006@DX\u000e¢\u0006\u0015\n\u0005\b\u001d\u0010§\u0001\u001a\u0005\bÜ\u0001\u0010x\"\u0005\bÝ\u0001\u0010\bR\u0019\u0010á\u0001\u001a\u00030ß\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b3\u0010à\u0001R\u0019\u0010ä\u0001\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R'\u0010è\u0001\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0006\bå\u0001\u0010¢\u0001\u001a\u0005\bæ\u0001\u0010c\"\u0005\bç\u0001\u0010'R\u001a\u0010ì\u0001\u001a\u00030é\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R'\u0010ð\u0001\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u0016\n\u0006\bí\u0001\u0010§\u0001\u001a\u0005\bî\u0001\u0010x\"\u0005\bï\u0001\u0010\bR\u0018\u0010ñ\u0001\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010\u0001R(\u0010ö\u0001\u001a\u00020\u00188\u0000@\u0000X\u000e¢\u0006\u0017\n\u0006\bò\u0001\u0010\u0001\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0005\bõ\u0001\u0010\u001bR\u001b\u0010ø\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010 \u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bù\u0001\u0010 \u0001R)\u0010ÿ\u0001\u001a\u0004\u0018\u0001068\u0000@\u0000X\u000e¢\u0006\u0016\n\u0005\b\u001a\u0010û\u0001\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0005\bþ\u0001\u00109R\u0019\u0010\u0002\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010ã\u0001R'\u0010\u0002\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0006\b\u0002\u0010¢\u0001\u001a\u0005\b\u0002\u0010c\"\u0005\b\u0002\u0010'R\u0019\u0010\u0002\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010§\u0001R\u001b\u0010\u0002\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0002R\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010 \u0001R&\u0010\u0002\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0015\n\u0005\b\u001c\u0010¢\u0001\u001a\u0005\b\u0002\u0010c\"\u0005\b\u0002\u0010'R\u0019\u0010\u0002\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010¢\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010 \u0001R)\u0010\u0002\u001a\u00020\u00042\u0007\u0010©\u0001\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\u000f\n\u0006\b\u0002\u0010§\u0001\u001a\u0005\b\u0002\u0010xR'\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0002\u0010c\"\u0005\b\u0002\u0010'¨\u0006¥\u0002"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent;", "Landroidx/core/view/NestedScrollingChild;", "", "targetAlpha", "", "setColorViewAlpha", "(I)V", "", "refreshing", "notify", "f", "(ZZ)V", "startingAlpha", "endingAlpha", "Landroid/view/animation/Animation;", g.a, "(II)Landroid/view/animation/Animation;", AuthSource.SEND_ABUSE, "()V", "animation", "c", "(Landroid/view/animation/Animation;)Z", "", "overscrollTop", "d", "(F)V", AuthSource.BOOKING_ORDER, "y", "h", "Landroid/view/MotionEvent;", "ev", "e", "(Landroid/view/MotionEvent;)V", "reset$sravnichat_release", "reset", "enabled", "setEnabled", "(Z)V", "onDetachedFromWindow", "scale", Tracker.Events.CREATIVE_START, "end", "setProgressViewOffset", "(ZII)V", "setProgressViewEndTarget", "(ZI)V", "size", "setSize", "childCount", "i", "getChildDrawingOrder", "(II)I", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRefreshListener", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V", "progress", "setAnimationProgress$sravnichat_release", "setAnimationProgress", "Landroid/view/animation/Animation$AnimationListener;", "startScaleDownAnimation$sravnichat_release", "(Landroid/view/animation/Animation$AnimationListener;)V", "startScaleDownAnimation", "colorRes", "setProgressBackgroundColor", "setProgressBackgroundColorSchemeResource", "color", "setProgressBackgroundColorSchemeColor", "", "colors", "setColorScheme", "([I)V", "colorResIds", "setColorSchemeResources", "setColorSchemeColors", Sort.DISTANCE, "setDistanceToTriggerSync", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "measureChildWithMargins", "(Landroid/view/View;IIII)V", "canChildScrollUp", "()Z", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$OnChildScrollUpCallback;", "callback", "setOnChildScrollUpCallback", "(Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$OnChildScrollUpCallback;)V", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "requestDisallowInterceptTouchEvent", "target", "nestedScrollAxes", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;I)Z", "axes", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;I)V", "dx", "dy", "consumed", "onNestedPreScroll", "(Landroid/view/View;II[I)V", "getNestedScrollAxes", "()I", "onStopNestedScroll", "(Landroid/view/View;)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "setNestedScrollingEnabled", "isNestedScrollingEnabled", "startNestedScroll", "(I)Z", "stopNestedScroll", "hasNestedScrollingParent", "offsetInWindow", "dispatchNestedScroll", "(IIII[I)Z", "dispatchNestedPreScroll", "(II[I[I)Z", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/view/View;FF)Z", "onNestedFling", "(Landroid/view/View;FFZ)Z", "dispatchNestedFling", "(FFZ)Z", "dispatchNestedPreFling", "(FF)Z", "onTouchEvent", "interpolatedTime", "moveToStart$sravnichat_release", "moveToStart", "offset", "setTargetOffsetTopAndBottom$sravnichat_release", "setTargetOffsetTopAndBottom", "p", "F", "mInitialMotionY", "D", "Landroid/view/animation/Animation;", "mAlphaMaxAnimation", "Z", "getMRefreshing$sravnichat_release", "setMRefreshing$sravnichat_release", "mRefreshing", VKApiConst.VERSION, "I", "mCircleViewIndex", "<set-?>", "z", "getProgressViewEndOffset", "setProgressViewEndOffset$sravnichat_release", "progressViewEndOffset", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView;", "mCircleView", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView;", "getMCircleView$sravnichat_release", "()Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView;", "setMCircleView$sravnichat_release", "(Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableCircleImageView;)V", "Landroid/view/View;", "mTarget", "o", "getMCurrentTargetOffsetTop$sravnichat_release", "setMCurrentTargetOffsetTop$sravnichat_release", "mCurrentTargetOffsetTop", "ru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mRefreshListener$1", "J", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mRefreshListener$1;", "mRefreshListener", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "mProgress", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "getMProgress$sravnichat_release", "()Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "setMProgress$sravnichat_release", "(Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;)V", "ru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mAnimateToStartPosition$1", "L", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mAnimateToStartPosition$1;", "mAnimateToStartPosition", VKApiConst.Q, "mInitialDownY", "getMNotify$sravnichat_release", "setMNotify$sravnichat_release", "mNotify", "mTouchSlop", AuthSource.OPEN_CHANNEL_LIST, "mNestedScrollInProgress", "n", "mMediumAnimationDuration", "ru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1", "K", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1;", "mAnimateToCorrectPosition", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "mMatchParentChildren", "mTotalDragDistance", "getProgressViewStartOffset", "setProgressViewStartOffset", "progressViewStartOffset", "Landroidx/core/view/NestedScrollingParentHelper;", "Landroidx/core/view/NestedScrollingParentHelper;", "mNestedScrollingParentHelper", "l", "[I", "mParentOffsetInWindow", "t", "getMScale$sravnichat_release", "setMScale$sravnichat_release", "mScale", "Landroid/view/animation/DecelerateInterpolator;", "u", "Landroid/view/animation/DecelerateInterpolator;", "mDecelerateInterpolator", "w", "getMFrom", "setMFrom", "mFrom", "mTotalUnconsumed", "x", "getMStartingScale$sravnichat_release", "()F", "setMStartingScale$sravnichat_release", "mStartingScale", "B", "mScaleDownAnimation", "C", "mAlphaStartAnimation", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getMListener$sravnichat_release", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "setMListener$sravnichat_release", "mListener", "k", "mParentScrollConsumed", "H", "getMUsingCustomStart$sravnichat_release", "setMUsingCustomStart$sravnichat_release", "mUsingCustomStart", "s", "mActivePointerId", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$OnChildScrollUpCallback;", "mChildScrollUpCallback", ExifInterface.LONGITUDE_EAST, "mScaleDownToStartAnimation", "getMMeasureAllChildren$sravnichat_release", "setMMeasureAllChildren$sravnichat_release", "mMeasureAllChildren", "r", "mIsBeingDragged", "Landroidx/core/view/NestedScrollingChildHelper;", "j", "Landroidx/core/view/NestedScrollingChildHelper;", "mNestedScrollingChildHelper", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mScaleAnimation", "G", "getProgressCircleDiameter", "progressCircleDiameter", "isRefreshing", "setRefreshing", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OnChildScrollUpCallback", "OnRefreshListener", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class WrapContentableSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final Companion Companion = new Companion(null);
    public static final int N = 1;
    public static final int O = 40;
    public static final int P = 56;
    public static final String Q;
    public static final int R = 255;
    public static final int S = ((int) (((float) 255) * 0.3f));
    public static final float T = 2.0f;
    public static final int U = -1;
    public static final float V = 0.5f;
    public static final float W = 0.8f;
    public static final int a0 = 150;
    public static final int b0 = 300;
    public static final int c0 = 200;
    public static final int d0 = 200;
    public static final int e0 = e0;
    public static final int f0 = 64;
    public static final int[] g0 = {16842766};
    public Animation A;
    public Animation B;
    public Animation C;
    public Animation D;
    public Animation E;
    public boolean F;
    public int G;
    public boolean H;
    public OnChildScrollUpCallback I;
    public final WrapContentableSwipeRefreshLayout$mRefreshListener$1 J;
    public final WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1 K;
    public final WrapContentableSwipeRefreshLayout$mAnimateToStartPosition$1 L;
    public HashMap M;
    public final ArrayList<View> a;
    @ViewDebug.ExportedProperty(category = "measurement")
    public boolean b;
    public View c;
    @Nullable
    public SwipeRefreshLayout.OnRefreshListener d;
    public boolean e;
    public final int f;
    public float g;
    public float h;
    public final NestedScrollingParentHelper i;
    public final NestedScrollingChildHelper j;
    public final int[] k;
    public final int[] l;
    public boolean m;
    @NotNull
    public WrapContentableCircleImageView mCircleView;
    @NotNull
    public CircularProgressDrawable mProgress;
    public final int n;
    public int o;
    public float p;
    public float q;
    public boolean r;
    public int s;
    public boolean t;
    public final DecelerateInterpolator u;
    public int v;
    public int w;
    public float x;
    public int y;
    public int z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0000@\u0001XD¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0001XD¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002XD¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b#\u0010\u0004¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$Companion;", "", "", "LARGE", "I", "getLARGE", "()I", "CIRCLE_DIAMETER_LARGE", "getCIRCLE_DIAMETER_LARGE$sravnichat_release", "CIRCLE_DIAMETER_LARGE$annotations", "()V", "CIRCLE_DIAMETER", "getCIRCLE_DIAMETER$sravnichat_release", "CIRCLE_DIAMETER$annotations", MessengerShareContentUtility.PREVIEW_DEFAULT, "getDEFAULT", "ALPHA_ANIMATION_DURATION", "ANIMATE_TO_START_DURATION", "ANIMATE_TO_TRIGGER_DURATION", "CIRCLE_BG_LIGHT", "", "DECELERATE_INTERPOLATION_FACTOR", "F", "DEFAULT_CIRCLE_TARGET", "DRAG_RATE", "INVALID_POINTER", "", "LAYOUT_ATTRS", "[I", "", "LOG_TAG", "Ljava/lang/String;", "MAX_ALPHA", "MAX_PROGRESS_ANGLE", "SCALE_DOWN_DURATION", "STARTING_PROGRESS_ALPHA", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void CIRCLE_DIAMETER$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void CIRCLE_DIAMETER_LARGE$annotations() {
        }

        public final int getCIRCLE_DIAMETER$sravnichat_release() {
            return WrapContentableSwipeRefreshLayout.O;
        }

        public final int getCIRCLE_DIAMETER_LARGE$sravnichat_release() {
            return WrapContentableSwipeRefreshLayout.P;
        }

        public final int getDEFAULT() {
            return WrapContentableSwipeRefreshLayout.N;
        }

        public final int getLARGE() {
            return WrapContentableSwipeRefreshLayout.access$getLARGE$cp();
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$OnChildScrollUpCallback;", "", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout;", "parent", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", "canChildScrollUp", "(Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout;Landroid/view/View;)Z", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull @NotNull WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout, @androidx.annotation.Nullable @Nullable View view);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout$OnRefreshListener;", "", "", "onRefresh", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        String simpleName = SwipeRefreshLayout.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "SwipeRefreshLayout::class.java.simpleName");
        Q = simpleName;
    }

    @JvmOverloads
    public WrapContentableSwipeRefreshLayout(@NonNull @NotNull Context context) {
        this(context, null, 2, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WrapContentableSwipeRefreshLayout(@NonNull @NotNull Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.a = new ArrayList<>(1);
        this.g = -1.0f;
        this.k = new int[2];
        this.l = new int[2];
        this.s = U;
        this.v = -1;
        this.J = new WrapContentableSwipeRefreshLayout$mRefreshListener$1(this);
        this.K = new WrapContentableSwipeRefreshLayout$mAnimateToCorrectPosition$1(this);
        this.L = new WrapContentableSwipeRefreshLayout$mAnimateToStartPosition$1(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
        this.f = viewConfiguration.getScaledTouchSlop();
        this.n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(T);
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.G = (int) (((float) O) * displayMetrics.density);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.mCircleView = new WrapContentableCircleImageView(context2, e0);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        if (circularProgressDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        wrapContentableCircleImageView.setImageDrawable(circularProgressDrawable2);
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView2.setVisibility(8);
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        addView(wrapContentableCircleImageView3);
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (((float) f0) * displayMetrics.density);
        this.z = i2;
        this.g = (float) i2;
        this.i = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.G;
        this.o = i3;
        this.y = i3;
        moveToStart$sravnichat_release(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public static final /* synthetic */ int access$getLARGE$cp() {
        return 0;
    }

    private final void setColorViewAlpha(int i2) {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.getBackground().setAlpha(i2);
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.setAlpha(i2);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.M;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.M == null) {
            this.M = new HashMap();
        }
        View view = (View) this.M.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.M.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        if (this.c == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
                if (wrapContentableCircleImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                if (!Intrinsics.areEqual(childAt, wrapContentableCircleImageView)) {
                    this.c = childAt;
                    return;
                }
            }
        }
    }

    public final void b(float f2) {
        if (f2 > this.g) {
            f(true, true);
            return;
        }
        this.e = false;
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.setStartEndTrim(0.0f, 0.0f);
        WrapContentableSwipeRefreshLayout$finishSpinner$1 wrapContentableSwipeRefreshLayout$finishSpinner$1 = null;
        boolean z2 = this.t;
        if (!z2) {
            wrapContentableSwipeRefreshLayout$finishSpinner$1 = new Animation.AnimationListener(this) { // from class: ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout$finishSpinner$1
                public final /* synthetic */ WrapContentableSwipeRefreshLayout a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@Nullable Animation animation) {
                    if (!this.a.getMScale$sravnichat_release()) {
                        this.a.startScaleDownAnimation$sravnichat_release(null);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@NotNull Animation animation) {
                    Intrinsics.checkParameterIsNotNull(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@Nullable Animation animation) {
                }
            };
        }
        int i2 = this.o;
        if (z2) {
            this.w = i2;
            WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
            if (wrapContentableCircleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            this.x = wrapContentableCircleImageView.getScaleX();
            WrapContentableSwipeRefreshLayout$startScaleDownReturnToStartAnimation$1 wrapContentableSwipeRefreshLayout$startScaleDownReturnToStartAnimation$1 = new Animation() { // from class: ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout$startScaleDownReturnToStartAnimation$1
                @Override // android.view.animation.Animation
                public void applyTransformation(float f3, @NotNull Transformation transformation) {
                    Intrinsics.checkParameterIsNotNull(transformation, "t");
                    WrapContentableSwipeRefreshLayout.this.setAnimationProgress$sravnichat_release(((-WrapContentableSwipeRefreshLayout.this.getMStartingScale$sravnichat_release()) * f3) + WrapContentableSwipeRefreshLayout.this.getMStartingScale$sravnichat_release());
                    WrapContentableSwipeRefreshLayout.this.moveToStart$sravnichat_release(f3);
                }
            };
            this.E = wrapContentableSwipeRefreshLayout$startScaleDownReturnToStartAnimation$1;
            wrapContentableSwipeRefreshLayout$startScaleDownReturnToStartAnimation$1.setDuration((long) a0);
            if (wrapContentableSwipeRefreshLayout$finishSpinner$1 != null) {
                WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
                if (wrapContentableCircleImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                wrapContentableCircleImageView2.setAnimationListener(wrapContentableSwipeRefreshLayout$finishSpinner$1);
            }
            WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
            if (wrapContentableCircleImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView3.clearAnimation();
            WrapContentableCircleImageView wrapContentableCircleImageView4 = this.mCircleView;
            if (wrapContentableCircleImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView4.startAnimation(this.E);
        } else {
            this.w = i2;
            this.L.reset();
            this.L.setDuration((long) d0);
            this.L.setInterpolator(this.u);
            if (wrapContentableSwipeRefreshLayout$finishSpinner$1 != null) {
                WrapContentableCircleImageView wrapContentableCircleImageView5 = this.mCircleView;
                if (wrapContentableCircleImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                wrapContentableCircleImageView5.setAnimationListener(wrapContentableSwipeRefreshLayout$finishSpinner$1);
            }
            WrapContentableCircleImageView wrapContentableCircleImageView6 = this.mCircleView;
            if (wrapContentableCircleImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView6.clearAnimation();
            WrapContentableCircleImageView wrapContentableCircleImageView7 = this.mCircleView;
            if (wrapContentableCircleImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView7.startAnimation(this.L);
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        if (circularProgressDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable2.setArrowEnabled(false);
    }

    public final boolean c(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public final boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.I;
        if (onChildScrollUpCallback != null) {
            if (onChildScrollUpCallback == null) {
                Intrinsics.throwNpe();
            }
            return onChildScrollUpCallback.canChildScrollUp(this, this.c);
        }
        View view = this.c;
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            if (listView == null) {
                Intrinsics.throwNpe();
            }
            return ListViewCompat.canScrollList(listView, -1);
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        return view.canScrollVertically(-1);
    }

    public final void d(float f2) {
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.g));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * ((float) 5)) / ((float) 3);
        float abs = Math.abs(f2) - this.g;
        float f3 = (float) (this.H ? this.z - this.y : this.z);
        float f4 = (float) 2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * f4) / f3) / ((float) 4));
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.y + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        if (wrapContentableCircleImageView.getVisibility() != 0) {
            WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
            if (wrapContentableCircleImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView2.setVisibility(0);
        }
        if (!this.t) {
            WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
            if (wrapContentableCircleImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView3.setScaleX(1.0f);
            WrapContentableCircleImageView wrapContentableCircleImageView4 = this.mCircleView;
            if (wrapContentableCircleImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView4.setScaleY(1.0f);
        }
        if (this.t) {
            setAnimationProgress$sravnichat_release(Math.min(1.0f, f2 / this.g));
        }
        if (f2 < this.g) {
            CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
            if (circularProgressDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            }
            int alpha = circularProgressDrawable2.getAlpha();
            int i3 = S;
            if (alpha > i3 && !c(this.C)) {
                CircularProgressDrawable circularProgressDrawable3 = this.mProgress;
                if (circularProgressDrawable3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mProgress");
                }
                this.C = g(circularProgressDrawable3.getAlpha(), i3);
            }
        } else {
            CircularProgressDrawable circularProgressDrawable4 = this.mProgress;
            if (circularProgressDrawable4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            }
            int alpha2 = circularProgressDrawable4.getAlpha();
            int i4 = R;
            if (alpha2 < i4 && !c(this.D)) {
                CircularProgressDrawable circularProgressDrawable5 = this.mProgress;
                if (circularProgressDrawable5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mProgress");
                }
                this.D = g(circularProgressDrawable5.getAlpha(), i4);
            }
        }
        float f5 = 0.8f * max;
        CircularProgressDrawable circularProgressDrawable6 = this.mProgress;
        if (circularProgressDrawable6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable6.setStartEndTrim(0.0f, Math.min(W, f5));
        CircularProgressDrawable circularProgressDrawable7 = this.mProgress;
        if (circularProgressDrawable7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable7.setArrowScale(Math.min(1.0f, max));
        float f6 = ((pow * f4) + ((max * 0.4f) - 16.0f)) * 0.5f;
        CircularProgressDrawable circularProgressDrawable8 = this.mProgress;
        if (circularProgressDrawable8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable8.setProgressRotation(f6);
        setTargetOffsetTopAndBottom$sravnichat_release(i2 - this.o);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.j.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.j.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable int[] iArr) {
        return this.j.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public final void e(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.s) {
            this.s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public final void f(boolean z2, boolean z3) {
        if (this.e != z2) {
            this.F = z3;
            a();
            this.e = z2;
            if (z2) {
                int i2 = this.o;
                WrapContentableSwipeRefreshLayout$mRefreshListener$1 wrapContentableSwipeRefreshLayout$mRefreshListener$1 = this.J;
                this.w = i2;
                this.K.reset();
                this.K.setDuration((long) c0);
                this.K.setInterpolator(this.u);
                if (wrapContentableSwipeRefreshLayout$mRefreshListener$1 != null) {
                    WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
                    if (wrapContentableCircleImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                    }
                    wrapContentableCircleImageView.setAnimationListener(wrapContentableSwipeRefreshLayout$mRefreshListener$1);
                }
                WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
                if (wrapContentableCircleImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                wrapContentableCircleImageView2.clearAnimation();
                WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
                if (wrapContentableCircleImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                wrapContentableCircleImageView3.startAnimation(this.K);
                return;
            }
            startScaleDownAnimation$sravnichat_release(this.J);
        }
    }

    public final Animation g(int i2, int i3) {
        WrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1 wrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1 = new Animation(this, i2, i3) { // from class: ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1
            public final /* synthetic */ WrapContentableSwipeRefreshLayout a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, @NotNull Transformation transformation) {
                Intrinsics.checkParameterIsNotNull(transformation, "t");
                CircularProgressDrawable mProgress$sravnichat_release = this.a.getMProgress$sravnichat_release();
                int i4 = this.b;
                mProgress$sravnichat_release.setAlpha((int) ((((float) (this.c - i4)) * f2) + ((float) i4)));
            }
        };
        wrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1.setDuration((long) b0);
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.setAnimationListener(null);
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView2.clearAnimation();
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView3.startAnimation(wrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1);
        return wrapContentableSwipeRefreshLayout$startAlphaAnimation$alpha$1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.v;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    @NotNull
    public final WrapContentableCircleImageView getMCircleView$sravnichat_release() {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        return wrapContentableCircleImageView;
    }

    public final int getMCurrentTargetOffsetTop$sravnichat_release() {
        return this.o;
    }

    public final int getMFrom() {
        return this.w;
    }

    @Nullable
    public final SwipeRefreshLayout.OnRefreshListener getMListener$sravnichat_release() {
        return this.d;
    }

    public final boolean getMMeasureAllChildren$sravnichat_release() {
        return this.b;
    }

    public final boolean getMNotify$sravnichat_release() {
        return this.F;
    }

    @NotNull
    public final CircularProgressDrawable getMProgress$sravnichat_release() {
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        return circularProgressDrawable;
    }

    public final boolean getMRefreshing$sravnichat_release() {
        return this.e;
    }

    public final boolean getMScale$sravnichat_release() {
        return this.t;
    }

    public final float getMStartingScale$sravnichat_release() {
        return this.x;
    }

    public final boolean getMUsingCustomStart$sravnichat_release() {
        return this.H;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.i.getNestedScrollAxes();
    }

    public final int getProgressCircleDiameter() {
        return this.G;
    }

    public final int getProgressViewEndOffset() {
        return this.z;
    }

    public final int getProgressViewStartOffset() {
        return this.y;
    }

    public final void h(float f2) {
        float f3 = this.q;
        int i2 = this.f;
        if (f2 - f3 > ((float) i2) && !this.r) {
            this.p = f3 + ((float) i2);
            this.r = true;
            CircularProgressDrawable circularProgressDrawable = this.mProgress;
            if (circularProgressDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            }
            circularProgressDrawable.setAlpha(S);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    public final boolean isRefreshing() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(@NotNull View view, int i2, int i3, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, i3, layoutParams.width), ViewGroup.getChildMeasureSpec(i4, i5, layoutParams.height));
    }

    public final void moveToStart$sravnichat_release(float f2) {
        int i2 = this.w;
        int i3 = i2 + ((int) (((float) (this.y - i2)) * f2));
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        setTargetOffsetTopAndBottom$sravnichat_release(i3 - wrapContentableCircleImageView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset$sravnichat_release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        int findPointerIndex;
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        a();
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || canChildScrollUp() || this.e || this.m) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.s;
                    if (i2 == U || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    h(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        e(motionEvent);
                    }
                }
            }
            this.r = false;
            this.s = U;
        } else {
            int i3 = this.y;
            WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
            if (wrapContentableCircleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            setTargetOffsetTopAndBottom$sravnichat_release(i3 - wrapContentableCircleImageView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.s = pointerId;
            this.r = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.q = motionEvent.getY(findPointerIndex2);
        }
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.c == null) {
                a();
            }
            View view = this.c;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
                int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
                if (view == null) {
                    Intrinsics.throwNpe();
                }
                view.layout(paddingLeft, paddingTop, paddingLeft2 + paddingLeft, paddingTop2 + paddingTop);
                WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
                if (wrapContentableCircleImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                int measuredWidth2 = wrapContentableCircleImageView.getMeasuredWidth();
                WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
                if (wrapContentableCircleImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                int measuredHeight2 = wrapContentableCircleImageView2.getMeasuredHeight();
                WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
                if (wrapContentableCircleImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.o;
                wrapContentableCircleImageView3.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.c == null) {
            a();
        }
        if (this.c != null) {
            int childCount = getChildCount();
            boolean z2 = (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) ? false : true;
            this.a.clear();
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!this.b) {
                    Intrinsics.checkExpressionValueIsNotNull(childAt, VKApiUserFull.RelativeType.CHILD);
                    if (childAt.getVisibility() == 8) {
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(childAt, VKApiUserFull.RelativeType.CHILD);
                measureChildWithMargins(childAt, i2, 0, i3, 0);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                i9 = Math.max(i9, childAt.getMeasuredWidth());
                i10 = Math.max(i10, childAt.getMeasuredHeight());
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
                if (z2 && (layoutParams.width == -1 || layoutParams.height == -1)) {
                    this.a.add(childAt);
                }
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(i9, getSuggestedMinimumWidth()), i2, i8), View.resolveSizeAndState(Math.max(i10, getSuggestedMinimumHeight()), i3, i8 << 16));
            int size = this.a.size();
            if (size > 1) {
                for (int i12 = 0; i12 < size; i12++) {
                    View view = this.a.get(i12);
                    Intrinsics.checkExpressionValueIsNotNull(view, "mMatchParentChildren[i]");
                    View view2 = view;
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    int i13 = layoutParams2.width;
                    if (i13 == -1) {
                        i5 = 0;
                        i4 = 1073741824;
                        i6 = View.MeasureSpec.makeMeasureSpec(Math.max(0, getMeasuredWidth()), 1073741824);
                    } else {
                        i5 = 0;
                        i4 = 1073741824;
                        i6 = ViewGroup.getChildMeasureSpec(i2, 0, i13);
                    }
                    int i14 = layoutParams2.height;
                    if (i14 == -1) {
                        i7 = View.MeasureSpec.makeMeasureSpec(Math.max(i5, getMeasuredHeight()), i4);
                    } else {
                        i7 = ViewGroup.getChildMeasureSpec(i3, i5, i14);
                    }
                    view2.measure(i6, i7);
                }
            }
            WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
            if (wrapContentableCircleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView.measure(View.MeasureSpec.makeMeasureSpec(this.G, 1073741824), View.MeasureSpec.makeMeasureSpec(this.G, 1073741824));
            this.v = -1;
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
                if (wrapContentableCircleImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
                }
                if (childAt2 == wrapContentableCircleImageView2) {
                    this.v = i15;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NotNull View view, float f2, float f3, boolean z2) {
        Intrinsics.checkParameterIsNotNull(view, "target");
        return dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View view, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(view, "target");
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NotNull View view, int i2, int i3, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(view, "target");
        Intrinsics.checkParameterIsNotNull(iArr, "consumed");
        if (i3 > 0) {
            float f2 = this.h;
            if (f2 > ((float) 0)) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.h = 0.0f;
                } else {
                    this.h = f2 - f3;
                    iArr[1] = i3;
                }
                d(this.h);
            }
        }
        if (this.H && i3 > 0 && this.h == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
            if (wrapContentableCircleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView.setVisibility(8);
        }
        int[] iArr2 = this.k;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NotNull View view, int i2, int i3, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(view, "target");
        dispatchNestedScroll(i2, i3, i4, i5, this.l);
        int i6 = i5 + this.l[1];
        if (i6 < 0 && !canChildScrollUp()) {
            float abs = this.h + ((float) Math.abs(i6));
            this.h = abs;
            d(abs);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NotNull View view, @NotNull View view2, int i2) {
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkParameterIsNotNull(view2, "target");
        this.i.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.h = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NotNull View view, @NotNull View view2, int i2) {
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        Intrinsics.checkParameterIsNotNull(view2, "target");
        return isEnabled() && !this.e && (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "target");
        this.i.onStopNestedScroll(view);
        this.m = false;
        float f2 = this.h;
        if (f2 > ((float) 0)) {
            b(f2);
            this.h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || canChildScrollUp() || this.e || this.m) {
            return false;
        }
        if (actionMasked == 0) {
            this.s = motionEvent.getPointerId(0);
            this.r = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.r) {
                this.r = false;
                b((motionEvent.getY(findPointerIndex) - this.p) * V);
            }
            this.s = U;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            h(y2);
            if (this.r) {
                float f2 = (y2 - this.p) * V;
                if (f2 <= ((float) 0)) {
                    return false;
                }
                d(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    return false;
                }
                this.s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                e(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        View view = this.c;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwNpe();
            }
            if (!ViewCompat.isNestedScrollingEnabled(view)) {
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public final void reset$sravnichat_release() {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.clearAnimation();
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.stop();
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView2.setVisibility(8);
        setColorViewAlpha(R);
        if (this.t) {
            setAnimationProgress$sravnichat_release(0.0f);
        } else {
            setTargetOffsetTopAndBottom$sravnichat_release(this.y - this.o);
        }
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        this.o = wrapContentableCircleImageView3.getTop();
    }

    public final void setAnimationProgress$sravnichat_release(float f2) {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.setScaleX(f2);
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView2.setScaleY(f2);
    }

    @Deprecated(message = "Use {@link #setColorSchemeResources(int...)}\n     \n      ")
    public final void setColorScheme(@ColorRes @NotNull int... iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "colors");
        setColorSchemeResources(Arrays.copyOf(iArr, iArr.length));
    }

    public final void setColorSchemeColors(@ColorInt @NotNull int... iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "colors");
        a();
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.setColorSchemeColors(Arrays.copyOf(iArr, iArr.length));
    }

    public final void setColorSchemeResources(@ColorRes @NotNull int... iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "colorResIds");
        Context context = getContext();
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr2[i2] = ContextCompat.getColor(context, iArr[i2]);
        }
        setColorSchemeColors(Arrays.copyOf(iArr2, length));
    }

    public final void setDistanceToTriggerSync(int i2) {
        this.g = (float) i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            reset$sravnichat_release();
        }
    }

    public final void setMCircleView$sravnichat_release(@NotNull WrapContentableCircleImageView wrapContentableCircleImageView) {
        Intrinsics.checkParameterIsNotNull(wrapContentableCircleImageView, "<set-?>");
        this.mCircleView = wrapContentableCircleImageView;
    }

    public final void setMCurrentTargetOffsetTop$sravnichat_release(int i2) {
        this.o = i2;
    }

    public final void setMFrom(int i2) {
        this.w = i2;
    }

    public final void setMListener$sravnichat_release(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        this.d = onRefreshListener;
    }

    public final void setMMeasureAllChildren$sravnichat_release(boolean z2) {
        this.b = z2;
    }

    public final void setMNotify$sravnichat_release(boolean z2) {
        this.F = z2;
    }

    public final void setMProgress$sravnichat_release(@NotNull CircularProgressDrawable circularProgressDrawable) {
        Intrinsics.checkParameterIsNotNull(circularProgressDrawable, "<set-?>");
        this.mProgress = circularProgressDrawable;
    }

    public final void setMRefreshing$sravnichat_release(boolean z2) {
        this.e = z2;
    }

    public final void setMScale$sravnichat_release(boolean z2) {
        this.t = z2;
    }

    public final void setMStartingScale$sravnichat_release(float f2) {
        this.x = f2;
    }

    public final void setMUsingCustomStart$sravnichat_release(boolean z2) {
        this.H = z2;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.j.setNestedScrollingEnabled(z2);
    }

    public final void setOnChildScrollUpCallback(@androidx.annotation.Nullable @NotNull OnChildScrollUpCallback onChildScrollUpCallback) {
        Intrinsics.checkParameterIsNotNull(onChildScrollUpCallback, "callback");
        this.I = onChildScrollUpCallback;
    }

    public final void setOnRefreshListener(@androidx.annotation.Nullable @NotNull SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        Intrinsics.checkParameterIsNotNull(onRefreshListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = onRefreshListener;
    }

    @Deprecated(message = "Use {@link #setProgressBackgroundColorSchemeResource(int)}\n     \n      ")
    public final void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public final void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.setBackgroundColor(i2);
    }

    public final void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i2));
    }

    public final void setProgressViewEndOffset$sravnichat_release(int i2) {
        this.z = i2;
    }

    public final void setProgressViewEndTarget(boolean z2, int i2) {
        this.z = i2;
        this.t = z2;
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.invalidate();
    }

    public final void setProgressViewOffset(boolean z2, int i2, int i3) {
        this.t = z2;
        this.y = i2;
        this.z = i3;
        this.H = true;
        reset$sravnichat_release();
        this.e = false;
    }

    public final void setProgressViewStartOffset(int i2) {
        this.y = i2;
    }

    public final void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.e == z2) {
            f(z2, false);
            return;
        }
        this.e = z2;
        if (!this.H) {
            i2 = this.z + this.y;
        } else {
            i2 = this.z;
        }
        setTargetOffsetTopAndBottom$sravnichat_release(i2 - this.o);
        this.F = false;
        WrapContentableSwipeRefreshLayout$mRefreshListener$1 wrapContentableSwipeRefreshLayout$mRefreshListener$1 = this.J;
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.setVisibility(0);
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        if (circularProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        }
        circularProgressDrawable.setAlpha(R);
        WrapContentableSwipeRefreshLayout$startScaleUpAnimation$1 wrapContentableSwipeRefreshLayout$startScaleUpAnimation$1 = new Animation() { // from class: ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout$startScaleUpAnimation$1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, @NotNull Transformation transformation) {
                Intrinsics.checkParameterIsNotNull(transformation, "t");
                WrapContentableSwipeRefreshLayout.this.setAnimationProgress$sravnichat_release(f2);
            }
        };
        this.A = wrapContentableSwipeRefreshLayout$startScaleUpAnimation$1;
        wrapContentableSwipeRefreshLayout$startScaleUpAnimation$1.setDuration((long) this.n);
        if (wrapContentableSwipeRefreshLayout$mRefreshListener$1 != null) {
            WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
            if (wrapContentableCircleImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView2.setAnimationListener(wrapContentableSwipeRefreshLayout$mRefreshListener$1);
        }
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView3.clearAnimation();
        WrapContentableCircleImageView wrapContentableCircleImageView4 = this.mCircleView;
        if (wrapContentableCircleImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView4.startAnimation(this.A);
    }

    public final void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            Resources resources = getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (i2 == 0) {
                this.G = (int) (((float) P) * displayMetrics.density);
            } else {
                this.G = (int) (((float) O) * displayMetrics.density);
            }
            WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
            if (wrapContentableCircleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            wrapContentableCircleImageView.setImageDrawable(null);
            CircularProgressDrawable circularProgressDrawable = this.mProgress;
            if (circularProgressDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            }
            circularProgressDrawable.setStyle(i2);
            WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
            if (wrapContentableCircleImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
            }
            CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
            if (circularProgressDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            }
            wrapContentableCircleImageView2.setImageDrawable(circularProgressDrawable2);
        }
    }

    public final void setTargetOffsetTopAndBottom$sravnichat_release(int i2) {
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.bringToFront();
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        ViewCompat.offsetTopAndBottom(wrapContentableCircleImageView2, i2);
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        this.o = wrapContentableCircleImageView3.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.j.startNestedScroll(i2);
    }

    public final void startScaleDownAnimation$sravnichat_release(@Nullable Animation.AnimationListener animationListener) {
        WrapContentableSwipeRefreshLayout$startScaleDownAnimation$1 wrapContentableSwipeRefreshLayout$startScaleDownAnimation$1 = new Animation(this) { // from class: ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout$startScaleDownAnimation$1
            public final /* synthetic */ WrapContentableSwipeRefreshLayout a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, @NotNull Transformation transformation) {
                Intrinsics.checkParameterIsNotNull(transformation, "t");
                this.a.setAnimationProgress$sravnichat_release(((float) 1) - f2);
            }
        };
        this.B = wrapContentableSwipeRefreshLayout$startScaleDownAnimation$1;
        if (wrapContentableSwipeRefreshLayout$startScaleDownAnimation$1 == null) {
            Intrinsics.throwNpe();
        }
        wrapContentableSwipeRefreshLayout$startScaleDownAnimation$1.setDuration((long) a0);
        WrapContentableCircleImageView wrapContentableCircleImageView = this.mCircleView;
        if (wrapContentableCircleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView.setAnimationListener(animationListener);
        WrapContentableCircleImageView wrapContentableCircleImageView2 = this.mCircleView;
        if (wrapContentableCircleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView2.clearAnimation();
        WrapContentableCircleImageView wrapContentableCircleImageView3 = this.mCircleView;
        if (wrapContentableCircleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleView");
        }
        wrapContentableCircleImageView3.startAnimation(this.B);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WrapContentableSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
