package ru.sravni.android.bankproduct.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a?\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\r\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\rH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0013*\u0004\u0018\u00018\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b \u0010\u001f\u001a\u001d\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\b'\u0010(\u001a(\u0010)\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\rH\b¢\u0006\u0004\b)\u0010*\u001a(\u0010+\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\rH\b¢\u0006\u0004\b+\u0010*\u001a0\u00104\u001a\u0002032!\u00102\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002010,¢\u0006\u0004\b4\u00105\u001a\u0011\u00106\u001a\u00020\r*\u00020\r¢\u0006\u0004\b6\u00107\u001a\u0019\u00109\u001a\n \u000e*\u0004\u0018\u00010808*\u00020\r¢\u0006\u0004\b9\u0010:\u001a\u0011\u0010;\u001a\u00020!*\u00020$¢\u0006\u0004\b;\u0010<¨\u0006="}, d2 = {"T", "", "Lio/reactivex/Observable;", "typeObservable", "(Ljava/lang/Throwable;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "Lio/reactivex/subjects/Subject;", "newChanel", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errWrapper", "Lio/reactivex/disposables/Disposable;", "makeSravniSubscription", "(Lio/reactivex/Observable;Lio/reactivex/subjects/Subject;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)Lio/reactivex/disposables/Disposable;", "", "kotlin.jvm.PlatformType", "toSravniJson", "(Ljava/lang/Object;)Ljava/lang/String;", "restoreObject", "(Ljava/lang/String;)Ljava/lang/Object;", "R", "Lkotlin/Function0;", "block", "onNull", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "color", "", "getTitleColor", "(Ljava/lang/String;)I", "mask", "text", "getFormattedText", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getExtractedText", "", "isCompleteMask", "(Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "assetPath", "readStringFromAsset", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "readListFromAsset", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "readItemFromAsset", "Lkotlin/Function1;", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "", "action", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "errorHandlerAction", "(Lkotlin/jvm/functions/Function1;)Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "firstSymbolOrEmptyString", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/text/Spanned;", "toSpannedText", "(Ljava/lang/String;)Landroid/text/Spanned;", "isSmallScreen", "(Landroid/content/Context;)Z", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class UtilFunctionsKt {

    public static final class a<T> implements Consumer<DataContainer<? extends T>> {
        public final /* synthetic */ Subject a;
        public final /* synthetic */ IThrowableWrapper b;

        public a(Subject subject, IThrowableWrapper iThrowableWrapper) {
            this.a = subject;
            this.b = iThrowableWrapper;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.subjects.Subject */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.subjects.Subject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            DataContainer dataContainer = (DataContainer) obj;
            if (dataContainer.getError() != null) {
                this.a.onNext(new DataContainer(dataContainer.getValue(), this.b.wrap(dataContainer.getError())));
            } else {
                this.a.onNext(dataContainer);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ Subject a;
        public final /* synthetic */ IThrowableWrapper b;

        public b(Subject subject, IThrowableWrapper iThrowableWrapper) {
            this.a = subject;
            this.b = iThrowableWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.subjects.Subject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.onNext(new DataContainer(null, this.b.wrap(th)));
        }
    }

    @NotNull
    public static final IErrorHandler errorHandlerAction(@NotNull Function1<? super SravniError, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        return new IErrorHandler(function1) { // from class: ru.sravni.android.bankproduct.utils.UtilFunctionsKt$errorHandlerAction$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler
            public void handleError(@NotNull SravniError sravniError) {
                Intrinsics.checkParameterIsNotNull(sravniError, "error");
                this.a.invoke(sravniError);
            }
        };
    }

    @NotNull
    public static final String firstSymbolOrEmptyString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$firstSymbolOrEmptyString");
        if (str.length() <= 0) {
            return "";
        }
        String substring = str.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String getExtractedText(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "mask");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        String extractedValue = new Mask(str).apply(new CaretString(str2, 0, new CaretString.CaretGravity.FORWARD(false))).getExtractedValue();
        return '7' + extractedValue;
    }

    @NotNull
    public static final String getFormattedText(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "text");
        String string = str != null ? new Mask(str).apply(new CaretString(str2, 0, new CaretString.CaretGravity.FORWARD(false))).getFormattedText().getString() : null;
        return string != null ? string : str2;
    }

    public static final int getTitleColor(@Nullable String str) {
        try {
            return Color.parseColor('#' + str);
        } catch (Exception unused) {
            return -7829368;
        }
    }

    public static final boolean isCompleteMask(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "mask");
        return new Mask(str2).apply(new CaretString(str, 0, new CaretString.CaretGravity.FORWARD(false))).getComplete();
    }

    public static final boolean isSmallScreen(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$isSmallScreen");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.y <= 800;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @NotNull
    public static final <T> Disposable makeSravniSubscription(@NotNull Observable<DataContainer<T>> observable, @NotNull Subject<DataContainer<T>> subject, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$makeSravniSubscription");
        Intrinsics.checkParameterIsNotNull(subject, "newChanel");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errWrapper");
        Disposable subscribe = observable.subscribe(new a(subject, iThrowableWrapper), new b(subject, iThrowableWrapper));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "this.subscribe({\n       …per.wrap(it)))\n        })");
        return subscribe;
    }

    public static final <R> R onNull(@Nullable R r, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        return r != null ? r : (R) function0.invoke();
    }

    public static final /* synthetic */ <T> T readItemFromAsset(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "assetPath");
        String readStringFromAsset = readStringFromAsset(context, str);
        Gson gson = new Gson();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) gson.fromJson(readStringFromAsset, (Class<Object>) Object.class);
    }

    public static final /* synthetic */ <T> T readListFromAsset(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "assetPath");
        String readStringFromAsset = readStringFromAsset(context, str);
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return (T) gson.fromJson(readStringFromAsset, new TypeToken<T>() { // from class: ru.sravni.android.bankproduct.utils.UtilFunctionsKt$readListFromAsset$1
        }.getType());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readStringFromAsset(@org.jetbrains.annotations.NotNull android.content.Context r1, @org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "assetPath"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            android.content.res.AssetManager r1 = r1.getAssets()
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "context.assets.open(assetPath)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0025
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x002d
        L_0x0025:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x002d:
            r1 = 0
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0036 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x0036:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.utils.UtilFunctionsKt.readStringFromAsset(android.content.Context, java.lang.String):java.lang.String");
    }

    @Nullable
    public static final /* synthetic */ <T> T restoreObject(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$restoreObject");
        Gson gson = new Gson();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) gson.fromJson(str, (Class<Object>) Object.class);
    }

    public static final Spanned toSpannedText(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toSpannedText");
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 63);
        }
        return Html.fromHtml(str);
    }

    public static final <T> String toSravniJson(T t) {
        return new Gson().toJson((Object) t);
    }

    @NotNull
    public static final <T> Observable<T> typeObservable(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "$this$typeObservable");
        Observable<T> error = Observable.error(th);
        Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error(this)");
        return error;
    }
}
