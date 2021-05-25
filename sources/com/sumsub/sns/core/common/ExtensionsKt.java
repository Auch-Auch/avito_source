package com.sumsub.sns.core.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.transition.TransitionManager;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.share.internal.ShareConstants;
import com.sumsub.sns.core.R;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.text.span.URLSpanNoUnderline;
import com.transitionseverywhere.ChangeText;
import com.vk.sdk.api.VKApiConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.m;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001aG\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aA\u0010\u000b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0004\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0012\u001a\u00020\u0006*\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0017\u001a\u00020\u0006*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0006*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0019\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\"\u001a\u00020\u0006*\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u0006*\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b$\u0010#\u001aO\u0010-\u001a\u00020\u0006*\u00020\u001e2<\u0010,\u001a8\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110*¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b-\u0010.\u001a\u0011\u00100\u001a\u00020\u001a*\u00020/¢\u0006\u0004\b0\u00101\u001a\u000f\u00102\u001a\u00020\fH\u0007¢\u0006\u0004\b2\u00103\u001a\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106\u001a\u0011\u00107\u001a\u00020\f*\u00020\f¢\u0006\u0004\b7\u00108\u001a\u0019\u0010;\u001a\u00020 *\u00020/2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<\u001a\u0011\u0010=\u001a\u00020\f*\u00020/¢\u0006\u0004\b=\u0010>\u001a\u0011\u0010?\u001a\u00020\u001a*\u00020/¢\u0006\u0004\b?\u00101\u001a\u0019\u0010;\u001a\u00020 *\u00020@2\u0006\u0010A\u001a\u00020/¢\u0006\u0004\b;\u0010B\u001a!\u0010E\u001a\u00020\u001a*\u00020/2\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f¢\u0006\u0004\bE\u0010F\u001a\u0019\u0010G\u001a\u00020\u001a*\u00020/2\u0006\u0010C\u001a\u00020\f¢\u0006\u0004\bG\u0010H\u001a%\u0010L\u001a\u00020K*\u00020/2\b\b\u0001\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\f¢\u0006\u0004\bL\u0010M\u001a#\u0010L\u001a\u00020K*\u00020/2\u0006\u0010N\u001a\u00020\f2\b\b\u0002\u0010J\u001a\u00020\f¢\u0006\u0004\bL\u0010O\u001a%\u0010P\u001a\u00020\f*\u00020/2\b\b\u0001\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\f¢\u0006\u0004\bP\u0010Q\u001a#\u0010P\u001a\u00020\f*\u00020/2\u0006\u0010N\u001a\u00020\f2\b\b\u0002\u0010J\u001a\u00020\f¢\u0006\u0004\bP\u0010R\u001a\u001d\u0010S\u001a\u0004\u0018\u00010\f*\u0002092\b\u0010A\u001a\u0004\u0018\u00010/¢\u0006\u0004\bS\u0010T\u001a,\u0010X\u001a\u00020U*\u00020/2\u0019\b\u0002\u0010W\u001a\u0013\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bV¢\u0006\u0004\bX\u0010Y\u001a\u001b\u0010Z\u001a\u0004\u0018\u00010\f*\u0002092\u0006\u0010A\u001a\u00020/¢\u0006\u0004\bZ\u0010T\u001a%\u0010]\u001a\u0004\u0018\u000109*\u00020/2\u0006\u0010[\u001a\u00020\u001a2\b\u0010\\\u001a\u0004\u0018\u00010U¢\u0006\u0004\b]\u0010^\u001a#\u0010_\u001a\u0004\u0018\u000109*\u00020U2\u0006\u0010A\u001a\u00020/2\u0006\u0010[\u001a\u00020\u001a¢\u0006\u0004\b_\u0010`\u001a\u001b\u0010a\u001a\u0004\u0018\u000109*\u0002092\u0006\u0010A\u001a\u00020/¢\u0006\u0004\ba\u0010b\u001a\u0011\u0010d\u001a\u00020\u0006*\u00020c¢\u0006\u0004\bd\u0010e\u001a\u0019\u0010g\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010f\u001a\u00020 ¢\u0006\u0004\bg\u0010h\u001a\u0011\u0010i\u001a\u00020\u0006*\u00020\u001e¢\u0006\u0004\bi\u0010j\u001a\u0011\u0010k\u001a\u00020 *\u00020\u001e¢\u0006\u0004\bk\u0010l\u001a%\u0010p\u001a\u00020\u0006*\u00020m2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\f0nH\bø\u0001\u0000¢\u0006\u0004\bp\u0010q\u001a\u001c\u0010r\u001a\u00020\u0006*\u00020m2\u0006\u0010o\u001a\u00020\fH\b¢\u0006\u0004\br\u0010s\u001a\u0015\u0010u\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020\u001a¢\u0006\u0004\bu\u0010v\u001a<\u0010{\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020m0w2\u0006\u0010x\u001a\u00020\f2\b\b\u0002\u0010z\u001a\u00020yH\b¢\u0006\u0004\b{\u0010|\u001a8\u0010{\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020m0w2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\f0}H\b¢\u0006\u0004\b{\u0010\u001a\u0013\u0010\u0001\u001a\u00020\f*\u00020\f¢\u0006\u0005\b\u0001\u00108\"\u0019\u0010\u0001\u001a\u00020\u001a*\u00020\u001a8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010v\"\u0019\u0010\u0001\u001a\u00020\u001a*\u00020\u001a8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010v\"-\u0010\u0001\u001a\u00020K*\u00020\u00102\u0006\u0010C\u001a\u00020K8F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "Lkotlin/Function1;", "", "onEventUnhandledContent", "observeEvent", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "observer", "observe", "", "Landroid/text/Spanned;", "asHtml", "(Ljava/lang/String;)Landroid/text/Spanned;", "Landroid/widget/TextView;", "onClicked", "handleUrlClicks", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Bitmap;", "Ljava/io/File;", "file", "normalize", "(Landroid/graphics/Bitmap;Ljava/io/File;)V", "save", "", "orientation", "rotate", "(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;", "Landroid/view/View;", "targetView", "", "isConsumed", "addSystemTopPadding", "(Landroid/view/View;Landroid/view/View;Z)V", "addSystemBottomPadding", "Lkotlin/Function3;", "Landroidx/core/view/WindowInsetsCompat;", "Lkotlin/ParameterName;", "name", "insets", "Landroid/graphics/Rect;", "initialPadding", "block", "doOnApplyWindowInsets", "(Landroid/view/View;Lkotlin/jvm/functions/Function3;)V", "Landroid/content/Context;", "navigationBarHeight", "(Landroid/content/Context;)I", "getDeviceName", "()Ljava/lang/String;", "Ljava/util/Locale;", "getDeviceLocale", "()Ljava/util/Locale;", "toBase64", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "resolve", "(Landroid/content/Context;Landroid/net/Uri;)Z", "getVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "getVersionCode", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "context", "(Lcom/sumsub/sns/core/data/model/SNSSupportItem;Landroid/content/Context;)Z", "value", "defType", "getIdentifier", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I", "getStringIdentifier", "(Landroid/content/Context;Ljava/lang/String;)I", "id", "default", "", "getTextResource", "(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/CharSequence;", "key", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;", "getStringResource", "(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "copyTo", "(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;", "Landroid/content/Intent;", "Lkotlin/ExtensionFunctionType;", "invoke", "getImagePickerIntent", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Landroid/content/Intent;", "getFileType", "resultCode", "intent", "getFileUriFromResult", "(Landroid/content/Context;ILandroid/content/Intent;)Landroid/net/Uri;", "getImageUriFromResult", "(Landroid/content/Intent;Landroid/content/Context;I)Landroid/net/Uri;", "getFilePath", "(Landroid/net/Uri;Landroid/content/Context;)Landroid/net/Uri;", "Landroid/app/Activity;", "openAppSettings", "(Landroid/app/Activity;)V", "show", "visibleIf", "(Landroid/view/View;Z)V", PlatformActions.HIDE_KEYBOARD, "(Landroid/view/View;)V", "showKeyboard", "(Landroid/view/View;)Z", "", "Lkotlin/Function0;", "message", "logd", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "logInfo", "(Ljava/lang/Object;Ljava/lang/String;)V", "degrees", "resolveOrientation", "(I)I", "", MessageMetaInfo.COLUMN_PATH, "", "separator", "getMapValue", "(Ljava/util/Map;Ljava/lang/String;C)Ljava/lang/Object;", "", "pathSegments", "(Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "lowerCased", "getPx", "px", "getDp", "dp", "getTextWithAnimation", "(Landroid/widget/TextView;)Ljava/lang/CharSequence;", "setTextWithAnimation", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "textWithAnimation", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class ExtensionsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SNSSupportItem.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function3<View, WindowInsetsCompat, Rect, WindowInsetsCompat> {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, boolean z) {
            super(3);
            this.a = view;
            this.b = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public WindowInsetsCompat invoke(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            Rect rect2 = rect;
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(windowInsetsCompat2, "insets");
            Intrinsics.checkNotNullParameter(rect2, "initialPadding");
            View view2 = this.a;
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), windowInsetsCompat2.getSystemWindowInsetBottom() + rect2.bottom);
            if (!this.b) {
                return windowInsetsCompat2;
            }
            WindowInsetsCompat replaceSystemWindowInsets = windowInsetsCompat2.replaceSystemWindowInsets(new Rect(windowInsetsCompat2.getSystemWindowInsetLeft(), windowInsetsCompat2.getSystemWindowInsetTop(), windowInsetsCompat2.getSystemWindowInsetRight(), 0));
            Intrinsics.checkNotNullExpressionValue(replaceSystemWindowInsets, "insets.replaceSystemWind…      )\n                )");
            return replaceSystemWindowInsets;
        }
    }

    public static final class b extends Lambda implements Function3<View, WindowInsetsCompat, Rect, WindowInsetsCompat> {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, boolean z) {
            super(3);
            this.a = view;
            this.b = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public WindowInsetsCompat invoke(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            Rect rect2 = rect;
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(windowInsetsCompat2, "insets");
            Intrinsics.checkNotNullParameter(rect2, "initialPadding");
            View view2 = this.a;
            view2.setPadding(view2.getPaddingLeft(), windowInsetsCompat2.getSystemWindowInsetTop() + rect2.top, view2.getPaddingRight(), view2.getPaddingBottom());
            if (!this.b) {
                return windowInsetsCompat2;
            }
            WindowInsetsCompat replaceSystemWindowInsets = windowInsetsCompat2.replaceSystemWindowInsets(new Rect(windowInsetsCompat2.getSystemWindowInsetLeft(), 0, windowInsetsCompat2.getSystemWindowInsetRight(), windowInsetsCompat2.getSystemWindowInsetBottom()));
            Intrinsics.checkNotNullExpressionValue(replaceSystemWindowInsets, "insets.replaceSystemWind…          )\n            )");
            return replaceSystemWindowInsets;
        }
    }

    public static final class c implements OnApplyWindowInsetsListener {
        public final /* synthetic */ Function3 a;
        public final /* synthetic */ Rect b;

        public c(Function3 function3, Rect rect) {
            this.a = function3;
            this.b = rect;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Function3 function3 = this.a;
            Intrinsics.checkNotNullExpressionValue(view, VKApiConst.VERSION);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            return (WindowInsetsCompat) function3.invoke(view, windowInsetsCompat, this.b);
        }
    }

    public static final class d extends Lambda implements Function1<Intent, Unit> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "$receiver");
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ View a;

        public e(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.requestFocus()) {
                Object systemService = this.a.getContext().getSystemService("input_method");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).showSoftInput(this.a, 1);
            }
        }
    }

    public static final void addSystemBottomPadding(@NotNull View view, @NotNull View view2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$this$addSystemBottomPadding");
        Intrinsics.checkNotNullParameter(view2, "targetView");
        doOnApplyWindowInsets(view, new a(view2, z));
    }

    public static /* synthetic */ void addSystemBottomPadding$default(View view, View view2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            view2 = view;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        addSystemBottomPadding(view, view2, z);
    }

    public static final void addSystemTopPadding(@NotNull View view, @NotNull View view2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$this$addSystemTopPadding");
        Intrinsics.checkNotNullParameter(view2, "targetView");
        doOnApplyWindowInsets(view, new b(view2, z));
    }

    public static /* synthetic */ void addSystemTopPadding$default(View view, View view2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            view2 = view;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        addSystemTopPadding(view, view2, z);
    }

    @NotNull
    public static final Spanned asHtml(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$asHtml");
        String replace$default = m.replace$default(str, "\n", "<br/>", false, 4, (Object) null);
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(replace$default, 63);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "Html.fromHtml(replaceNL,…l.FROM_HTML_MODE_COMPACT)");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(replace$default);
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "Html.fromHtml(replaceNL)");
        return fromHtml2;
    }

    @Nullable
    public static final String copyTo(@NotNull Uri uri, @Nullable Context context) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "$this$copyTo");
        Cursor query = (context == null || (contentResolver = context.getContentResolver()) == null) ? null : contentResolver.query(uri, null, null, null, null);
        int columnIndex = query != null ? query.getColumnIndex("_display_name") : -1;
        if (query != null) {
            query.moveToFirst();
        }
        if (columnIndex == -1) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        String string = query != null ? query.getString(columnIndex) : null;
        if (query != null) {
            query.close();
        }
        if (string == null || string.length() == 0) {
            return null;
        }
        File file = new File(context.getCacheDir(), string);
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(openInputStream, "context.contentResolver.…ream(this) ?: return null");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[t6.v.e.coerceAtMost(openInputStream.available(), 1048576)];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            openInputStream.close();
            fileOutputStream.close();
            return file.getPath();
        } catch (Exception unused) {
        }
    }

    public static final void doOnApplyWindowInsets(@NotNull View view, @NotNull Function3<? super View, ? super WindowInsetsCompat, ? super Rect, ? extends WindowInsetsCompat> function3) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnApplyWindowInsets");
        Intrinsics.checkNotNullParameter(function3, "block");
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(function3, new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom())));
        if (view.isAttachedToWindow()) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.sumsub.sns.core.common.ExtensionsKt$requestApplyInsetsWhenAttached$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                    view2.removeOnAttachStateChangeListener(this);
                    ViewCompat.requestApplyInsets(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                }
            });
        }
    }

    @NotNull
    public static final Locale getDeviceLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = LocaleList.getDefault().get(0);
            Intrinsics.checkNotNullExpressionValue(locale, "LocaleList.getDefault().get(0)");
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
        return locale2;
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public static final String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        Intrinsics.checkNotNullExpressionValue(str, "manufacturer");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        if (m.startsWith$default(lowerCase, lowerCase2, false, 2, null)) {
            return m.capitalize(str2);
        }
        return m.capitalize(str) + " " + str2;
    }

    public static final int getDp(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) / system.getDisplayMetrics().density);
    }

    @Nullable
    public static final Uri getFilePath(@NotNull Uri uri, @NotNull Context context) {
        Uri uri2 = uri;
        Intrinsics.checkNotNullParameter(uri2, "$this$getFilePath");
        Intrinsics.checkNotNullParameter(context, "context");
        String[] strArr = {"_data"};
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "imageUri.toString()");
        String str = null;
        if (m.startsWith$default(uri3, "content://com.android.gallery3d.provider", false, 2, null)) {
            String uri4 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri4, "imageUri.toString()");
            uri2 = Uri.parse(m.replace$default(uri4, "com.android.gallery3d", "com.google.android.gallery3d", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(uri2, "Uri.parse(imageUri.toStr…ogle.android.gallery3d\"))");
        }
        Cursor query = context.getContentResolver().query(uri2, strArr, null, null, null);
        if (query == null || query.getCount() <= 0) {
            str = copyTo(uri2, context);
        } else {
            int columnIndex = query.getColumnIndex("_data");
            query.moveToFirst();
            String uri5 = uri2.toString();
            Intrinsics.checkNotNullExpressionValue(uri5, "imageUri.toString()");
            if (m.startsWith$default(uri5, "content://com.sec.android.gallery3d", false, 2, null)) {
                str = copyTo(uri2, context);
            } else if (columnIndex != -1) {
                str = query.getString(columnIndex);
            }
            query.close();
        }
        if (str == null) {
            str = copyTo(uri2, context);
        }
        return str != null ? Uri.fromFile(new File(str)) : uri2;
    }

    @Nullable
    public static final String getFileType(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$getFileType");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = uri.getPath();
        if (path == null || path.length() == 0) {
            return null;
        }
        String type = context.getContentResolver().getType(uri);
        if (type != null) {
            return type;
        }
        try {
            String path2 = uri.getPath();
            Intrinsics.checkNotNull(path2);
            return URLConnection.guessContentTypeFromName(new File(path2).getName());
        } catch (Exception unused) {
            return type;
        }
    }

    @Nullable
    public static final Uri getFileUriFromResult(@NotNull Context context, int i, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$this$getFileUriFromResult");
        Uri uri = null;
        if (i != -1 || intent == null) {
            return null;
        }
        String type = intent.getType();
        if (type == null && intent.getData() != null) {
            Uri data = intent.getData();
            type = data != null ? getFileType(data, context) : null;
        }
        if ((type == null || type.length() == 0) || m.startsWith$default(type, "image", false, 2, null) || m.endsWith$default(type, "/image", false, 2, null)) {
            return getImageUriFromResult(intent, context, i);
        }
        Uri data2 = intent.getData();
        if (data2 == null) {
            return data2;
        }
        String uri2 = data2.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "resultUri.toString()");
        if (!m.startsWith$default(uri2, "content://", false, 2, null)) {
            String uri3 = data2.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "resultUri.toString()");
            if (!m.startsWith$default(uri3, "file://", false, 2, null)) {
                return data2;
            }
        }
        String copyTo = copyTo(data2, context);
        if (copyTo != null) {
            uri = Uri.fromFile(new File(copyTo));
        }
        return uri;
    }

    public static final int getIdentifier(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "$this$getIdentifier");
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(str2, "defType");
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    @NotNull
    public static final Intent getImagePickerIntent(@NotNull Context context, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "$this$getImagePickerIntent");
        Intrinsics.checkNotNullParameter(function1, "invoke");
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        intent.setType(context.getResources().getString(R.string.sns_gallery_type));
        function1.invoke(intent);
        return intent;
    }

    public static /* synthetic */ Intent getImagePickerIntent$default(Context context, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = d.a;
        }
        return getImagePickerIntent(context, function1);
    }

    @Nullable
    public static final Uri getImageUriFromResult(@NotNull Intent intent, @NotNull Context context, int i) {
        Uri data;
        Intrinsics.checkNotNullParameter(intent, "$this$getImageUriFromResult");
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == -1 && (data = intent.getData()) != null) {
            return getFilePath(data, context);
        }
        return null;
    }

    public static final /* synthetic */ <T> T getMapValue(Map<String, ? extends Object> map, String str, char c2) {
        Intrinsics.checkNotNullParameter(map, "$this$getMapValue");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{c2}, false, 0, 6, (Object) null);
        Iterator<T> it = t6.v.e.until(0, split$default.size() - 1).iterator();
        while (it.hasNext()) {
            Object obj = map.get(split$default.get(((IntIterator) it).nextInt()));
            if (!(obj instanceof Map)) {
                obj = null;
            }
            map = (Map) obj;
            if (map == null) {
                return null;
            }
        }
        T t = (T) map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default));
        Intrinsics.reifiedOperationMarker(2, "T?");
        return t;
    }

    public static /* synthetic */ Object getMapValue$default(Map map, String str, char c2, int i, Object obj) {
        if ((i & 2) != 0) {
            c2 = '/';
        }
        Intrinsics.checkNotNullParameter(map, "$this$getMapValue");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{c2}, false, 0, 6, (Object) null);
        Iterator it = t6.v.e.until(0, split$default.size() - 1).iterator();
        while (it.hasNext()) {
            Object obj2 = map.get(split$default.get(((IntIterator) it).nextInt()));
            if (!(obj2 instanceof Map)) {
                obj2 = null;
            }
            map = (Map) obj2;
            if (map == null) {
                return null;
            }
        }
        Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default));
        Intrinsics.reifiedOperationMarker(2, "T?");
        return obj3;
    }

    public static final int getPx(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) * system.getDisplayMetrics().density);
    }

    public static final int getStringIdentifier(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$getStringIdentifier");
        Intrinsics.checkNotNullParameter(str, "value");
        return context.getResources().getIdentifier(str, Types.STRING, context.getPackageName());
    }

    @NotNull
    public static final String getStringResource(@NotNull Context context, @StringRes int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$getStringResource");
        Intrinsics.checkNotNullParameter(str, "default");
        return getTextResource(context, i, str).toString();
    }

    public static /* synthetic */ String getStringResource$default(Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return getStringResource(context, i, str);
    }

    @NotNull
    public static final CharSequence getTextResource(@NotNull Context context, @StringRes int i, @NotNull String str) {
        ServiceLocator serviceLocator;
        StringRepository stringRepository;
        Intrinsics.checkNotNullParameter(context, "$this$getTextResource");
        Intrinsics.checkNotNullParameter(str, "default");
        String resourceEntryName = context.getResources().getResourceEntryName(i);
        CharSequence charSequence = null;
        BaseActivity baseActivity = (BaseActivity) (!(context instanceof BaseActivity) ? null : context);
        if (!(baseActivity == null || (serviceLocator = baseActivity.getServiceLocator()) == null || (stringRepository = serviceLocator.getStringRepository()) == null)) {
            Intrinsics.checkNotNullExpressionValue(resourceEntryName, "resourceName");
            charSequence = stringRepository.getText(resourceEntryName);
        }
        if (charSequence != null) {
            return charSequence;
        }
        String string = context.getResources().getString(i, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, default)");
        return string;
    }

    public static /* synthetic */ CharSequence getTextResource$default(Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return getTextResource(context, i, str);
    }

    @NotNull
    public static final CharSequence getTextWithAnimation(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "$this$textWithAnimation");
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "this.text");
        return text;
    }

    public static final int getVersionCode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getVersionCode");
        try {
            return (int) PackageInfoCompat.getLongVersionCode(context.getPackageManager().getPackageInfo(context.getPackageName(), 0));
        } catch (Exception unused) {
            return -1;
        }
    }

    @NotNull
    public static final String getVersionName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getVersionName");
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "pInfo.versionName");
            return str;
        } catch (Exception unused) {
            return "<unknown>";
        }
    }

    public static final void handleUrlClicks(@NotNull TextView textView, @Nullable Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(textView, "$this$handleUrlClicks");
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(textView.getText());
        Object[] spans = valueOf.getSpans(0, valueOf.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, URLSpan::class.java)");
        for (Object obj : spans) {
            URLSpan uRLSpan = (URLSpan) obj;
            valueOf.setSpan(new URLSpanNoUnderline(uRLSpan, valueOf, function1) { // from class: com.sumsub.sns.core.common.ExtensionsKt$handleUrlClicks$$inlined$apply$lambda$1
                public final /* synthetic */ URLSpan a;
                public final /* synthetic */ Function1 b;

                {
                    this.a = r1;
                    this.b = r3;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "widget");
                    Function1 function12 = this.b;
                    if (function12 != null) {
                        URLSpan uRLSpan2 = this.a;
                        Intrinsics.checkNotNullExpressionValue(uRLSpan2, "it");
                        String url = uRLSpan2.getURL();
                        Intrinsics.checkNotNullExpressionValue(url, "it.url");
                        Unit unit = (Unit) function12.invoke(url);
                    }
                }
            }, valueOf.getSpanStart(uRLSpan), valueOf.getSpanEnd(uRLSpan), 17);
            valueOf.removeSpan(uRLSpan);
        }
        Unit unit = Unit.INSTANCE;
        textView.setText(valueOf);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static /* synthetic */ void handleUrlClicks$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        handleUrlClicks(textView, function1);
    }

    public static final void hideKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$hideKeyboard");
        Object systemService = view.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final void logInfo(@NotNull Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(obj, "$this$logInfo");
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.i(obj.getClass().getSimpleName() + ": " + str, new Object[0]);
    }

    public static final void logd(@NotNull Object obj, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(obj, "$this$logd");
        Intrinsics.checkNotNullParameter(function0, "message");
    }

    @NotNull
    public static final String lowerCased(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$lowerCased");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final int navigationBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$navigationBarHeight");
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final void normalize(@NotNull Bitmap bitmap, @NotNull File file) {
        Intrinsics.checkNotNullParameter(bitmap, "$this$normalize");
        Intrinsics.checkNotNullParameter(file, "file");
        save(rotate(bitmap, new ExifInterface(file).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0)), file);
    }

    public static final <T> void observe(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$observe");
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(function1, "observer");
        liveData.observe(lifecycleOwner, new Observer<T>(function1) { // from class: com.sumsub.sns.core.common.ExtensionsKt$observe$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    Unit unit = (Unit) this.a.invoke(t);
                }
            }
        });
    }

    public static final <T> void observeEvent(@NotNull LiveData<Event<T>> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$observeEvent");
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(function1, "onEventUnhandledContent");
        liveData.observe(lifecycleOwner, new Observer<Event<? extends T>>(function1) { // from class: com.sumsub.sns.core.common.ExtensionsKt$observeEvent$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    Unit unit = (Unit) this.a.invoke(contentIfNotHandled);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }

    public static final void openAppSettings(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$openAppSettings");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
    }

    public static final boolean resolve(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "$this$resolve");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }

    public static final int resolveOrientation(int i) {
        if (i == 90) {
            return 6;
        }
        if (i != 180) {
            return i != 270 ? 1 : 8;
        }
        return 3;
    }

    @NotNull
    public static final Bitmap rotate(@NotNull Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "$this$rotate");
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bmRotated");
            return createBitmap;
        } catch (Exception e2) {
            Timber.e(e2, "Rotate bitmap", new Object[0]);
            return bitmap;
        }
    }

    public static final void save(@NotNull Bitmap bitmap, @NotNull File file) {
        Intrinsics.checkNotNullParameter(bitmap, "$this$save");
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
        } catch (Exception e2) {
            Timber.e(e2, "An error while saving image...", new Object[0]);
        }
    }

    public static final void setTextWithAnimation(@NotNull TextView textView, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(textView, "$this$textWithAnimation");
        Intrinsics.checkNotNullParameter(charSequence, "value");
        if (!Intrinsics.areEqual(charSequence, textView.getText())) {
            ViewParent parent = textView.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                TransitionManager.beginDelayedTransition(viewGroup, new ChangeText().setChangeBehavior(3).setDuration((long) textView.getResources().getInteger(17694720)));
            }
            textView.setText(charSequence);
        }
    }

    public static final boolean showKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$showKeyboard");
        return view.postDelayed(new e(view), (long) view.getResources().getInteger(17694720));
    }

    @NotNull
    public static final String toBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toBase64");
        if (Build.VERSION.SDK_INT >= 26) {
            Base64.Encoder encoder = Base64.getEncoder();
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = encoder.encodeToString(bytes);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.getEncoder().enco…(StandardCharsets.UTF_8))");
            return encodeToString;
        }
        byte[] bytes2 = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
        String encodeToString2 = android.util.Base64.encodeToString(bytes2, 10);
        Intrinsics.checkNotNullExpressionValue(encodeToString2, "encodeToString(toByteArr…oid.util.Base64.URL_SAFE)");
        return encodeToString2;
    }

    public static final void visibleIf(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$this$visibleIf");
        view.setVisibility(z ? 0 : 4);
    }

    @NotNull
    public static final String getStringResource(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "$this$getStringResource");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "default");
        return getTextResource(context, str, str2).toString();
    }

    public static /* synthetic */ String getStringResource$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getStringResource(context, str, str2);
    }

    public static /* synthetic */ CharSequence getTextResource$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getTextResource(context, str, str2);
    }

    @NotNull
    public static final CharSequence getTextResource(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        ServiceLocator serviceLocator;
        StringRepository stringRepository;
        Intrinsics.checkNotNullParameter(context, "$this$getTextResource");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "default");
        CharSequence charSequence = null;
        if (!(context instanceof BaseActivity)) {
            context = null;
        }
        BaseActivity baseActivity = (BaseActivity) context;
        if (!(baseActivity == null || (serviceLocator = baseActivity.getServiceLocator()) == null || (stringRepository = serviceLocator.getStringRepository()) == null)) {
            charSequence = stringRepository.getText(str);
        }
        return charSequence != null ? charSequence : str2;
    }

    public static final boolean resolve(@NotNull SNSSupportItem sNSSupportItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(sNSSupportItem, "$this$resolve");
        Intrinsics.checkNotNullParameter(context, "context");
        if (sNSSupportItem.getOnClick() != null) {
            sNSSupportItem.getOnClick().invoke(sNSSupportItem);
            return true;
        }
        int ordinal = sNSSupportItem.getType().ordinal();
        if (ordinal == 0) {
            String value = sNSSupportItem.getValue();
            if (!m.startsWith$default(value, "https://", false, 2, null) && !m.startsWith$default(value, "http://", false, 2, null)) {
                value = a2.b.a.a.a.c3("http://", value);
            }
            Uri parse = Uri.parse(value);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
            return resolve(context, parse);
        } else if (ordinal != 1) {
            return false;
        } else {
            StringBuilder L = a2.b.a.a.a.L("mailto:");
            L.append(sNSSupportItem.getValue());
            Uri parse2 = Uri.parse(L.toString());
            Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(\"mailto:$value\")");
            return resolve(context, parse2);
        }
    }

    public static final /* synthetic */ <T> T getMapValue(Map<String, ? extends Object> map, List<String> list) {
        Intrinsics.checkNotNullParameter(map, "$this$getMapValue");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Iterator<T> it = t6.v.e.until(0, list.size() - 1).iterator();
        while (it.hasNext()) {
            Object obj = map.get(list.get(((IntIterator) it).nextInt()));
            if (!(obj instanceof Map)) {
                obj = null;
            }
            map = (Map) obj;
            if (map == null) {
                return null;
            }
        }
        T t = (T) map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list));
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
