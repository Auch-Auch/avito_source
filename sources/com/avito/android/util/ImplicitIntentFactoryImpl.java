package com.avito.android.util;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.RawPhoneNumber;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.ImplicitIntentFactory;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010D\u001a\u00020A\u0012\u000e\b\u0001\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020E¢\u0006\u0004\bI\u0010JJ-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\fJ)\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\u0018J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010\u0018J#\u00100\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u0006022\u0006\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0018J\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u0010 J\u001f\u00106\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00108J\u001f\u0010:\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u00109\u001a\u00020'H\u0016¢\u0006\u0004\b:\u0010*J-\u0010=\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000602H\u0016¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b@\u00108R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/avito/android/util/ImplicitIntentFactoryImpl;", "Lcom/avito/android/util/ImplicitIntentFactory;", "", "email", "subject", SDKConstants.PARAM_A2U_BODY, "Landroid/content/Intent;", "emailIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "url", "title", "shareItemIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "shareIntent", "Landroid/net/Uri;", "imageUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;", "intent", "pickActivityIntent", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "number", "dialIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "pickExternalMultipleImageIntent", "()Landroid/content/Intent;", "pickExternalSingleImageIntent", "", "mimeTypes", "pickExternalSingleFileOfSpecificFormatsIntent", "([Ljava/lang/String;)Landroid/content/Intent;", ShareConstants.MEDIA_URI, "frontCameraIntent", "(Landroid/net/Uri;)Landroid/content/Intent;", "locationSettingsIntent", "Lcom/avito/android/remote/model/Coordinates;", "targetCoordinates", "mapsApplicationsIntent", "(Lcom/avito/android/remote/model/Coordinates;)Landroid/content/Intent;", "createAppSettingsIntent", "", "withShareButton", "uriIntentCustomChromeTabs", "(Landroid/net/Uri;Z)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "queryParameters", "autotekaBuyReportCustomChromeTabsIntent", "marketIntent", "fallback", "externalUriIntent", "(Landroid/net/Uri;Landroid/net/Uri;)Landroid/content/Intent;", "", "getExternalIntentsForUrl", "(Landroid/net/Uri;)Ljava/util/List;", "notificationsSettingsIntent", "uriIntent", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;", "useCustomTab", "safeUriIntent", "targetIntent", "initialIntents", "chooserIntent", "(Ljava/lang/String;Landroid/content/Intent;Ljava/util/List;)Landroid/content/Intent;", MessageBody.File.MIME_TYPE, "openExternalFileOfSpecificType", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/util/Formatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/Formatter;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class ImplicitIntentFactoryImpl implements ImplicitIntentFactory {
    public final Context a;
    public final Formatter<String> b;

    @Inject
    public ImplicitIntentFactoryImpl(@NotNull Context context, @RawPhoneNumber @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        this.b = formatter;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent autotekaBuyReportCustomChromeTabsIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "queryParameters");
        Uri parse = Uri.parse("https://autoteka.ru/report_by_ad/" + str + str2);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(\"$AUTOTEKA_BUY…dvertId$queryParameters\")");
        return ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this, parse, false, 2, null);
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent chooserIntent(@NotNull String str, @NotNull Intent intent, @NotNull List<? extends Intent> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(intent, "targetIntent");
        Intrinsics.checkNotNullParameter(list, "initialIntents");
        Intent createChooser = Intent.createChooser(intent, str);
        Object[] array = list.toArray(new Intent[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Intent putExtra = createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent.createChooser(tar…alIntents.toTypedArray())");
        return putExtra;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent createAppSettingsIntent() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder L = a.L("package:");
        L.append(this.a.getPackageName());
        intent.setData(Uri.parse(L.toString()));
        Intent addFlags = intent.addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent dialIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "number");
        return new Intent("android.intent.action.DIAL", Uri.fromParts("tel", Uri.decode(this.b.format(str)), null));
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent emailIntent(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str, null));
        if (str2 != null) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (str3 != null) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        return intent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @Nullable
    public Intent externalUriIntent(@NotNull Uri uri, @Nullable Uri uri2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        PackageManager packageManager = this.a.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!packageManager.queryIntentActivities(intent, 0).isEmpty()) {
            return intent;
        }
        return uri2 != null ? new Intent("android.intent.action.VIEW", uri2) : null;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent frontCameraIntent(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri).putExtra("android.intent.extras.CAMERA_FACING", 1).putExtra("android.intent.extra.USE_FRONT_CAMERA", true).putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(MediaStore.ACTION…as.LENS_FACING_FRONT\", 1)");
        return putExtra;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public List<Intent> getExternalIntentsForUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Uri parse = Uri.parse("https://fake.avito.ru");
        Intrinsics.checkNotNullExpressionValue(parse, "fakeUri");
        List<ResolveInfo> queryIntentActivities = this.a.getPackageManager().queryIntentActivities(uriIntent(parse), 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager\n …tentActivities(intent, 0)");
        ArrayList<String> arrayList = new ArrayList(e.collectionSizeOrDefault(queryIntentActivities, 10));
        Iterator<T> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (String str : arrayList) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList2.add(uriIntent(uri, str));
        }
        return arrayList2;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent locationSettingsIntent() {
        return new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent mapsApplicationsIntent(@NotNull Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "targetCoordinates");
        return new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + coordinates.getLatitude() + ',' + coordinates.getLongitude()));
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent marketIntent() {
        PackageManager packageManager = this.a.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.avito.android"));
        return packageManager.queryIntentActivities(intent, 0).isEmpty() ? new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.avito.android")) : intent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent notificationsSettingsIntent() {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", this.a.getPackageName());
        intent.putExtra("app_uid", this.a.getApplicationInfo().uid);
        intent.putExtra("android.provider.extra.APP_PACKAGE", this.a.getPackageName());
        return intent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent openExternalFileOfSpecificType(@NotNull Uri uri, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent addFlags = new Intent("android.intent.action.VIEW").setDataAndType(uri, str).addFlags(1);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_VIE…RANT_READ_URI_PERMISSION)");
        return addFlags;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent pickActivityIntent(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent putExtra = new Intent("android.intent.action.PICK_ACTIVITY").putExtra("android.intent.extra.INTENT", intent).putExtra("android.intent.extra.TITLE", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_PIC…ntent.EXTRA_TITLE, title)");
        return putExtra;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent pickExternalMultipleImageIntent() {
        Intent pickExternalSingleImageIntent = pickExternalSingleImageIntent();
        pickExternalSingleImageIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        return pickExternalSingleImageIntent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent pickExternalSingleFileOfSpecificFormatsIntent(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "mimeTypes");
        Intent flags = new Intent("android.intent.action.OPEN_DOCUMENT").addCategory("android.intent.category.OPENABLE").setType("*/*").putExtra("android.intent.extra.MIME_TYPES", strArr).setFlags(1);
        Intrinsics.checkNotNullExpressionValue(flags, "Intent(Intent.ACTION_OPE…RANT_READ_URI_PERMISSION)");
        return flags;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent pickExternalSingleImageIntent() {
        Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").addCategory("android.intent.category.OPENABLE").setType("image/*");
        Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…      .setType(\"image/*\")");
        return type;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent safeUriIntent(@NotNull Uri uri, boolean z) {
        Intent intent;
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (z) {
            intent = uriIntentCustomChromeTabs(uri, true);
        } else {
            intent = uriIntent(uri);
        }
        if (SafeLinkKt.isSafeLink(uri)) {
            return intent;
        }
        boolean z2 = false;
        List<ResolveInfo> queryIntentActivities = this.a.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null) {
            queryIntentActivities = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(queryIntentActivities, 10));
        Iterator<T> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        if (arrayList.contains(this.a.getPackageName()) || arrayList.contains("com.avito.android")) {
            z2 = true;
        }
        if (z2) {
            return intent;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        Uri wrapIntoSafeLink = SafeLinkKt.wrapIntoSafeLink(uri2);
        if (z) {
            return uriIntentCustomChromeTabs(wrapIntoSafeLink, true);
        }
        return uriIntent(wrapIntoSafeLink);
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent shareIntent(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "url");
        if (str != null) {
            str2 = a.e3(str, "\n", str2);
        }
        Intent putExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_SEN…(Intent.EXTRA_TEXT, text)");
        return putExtra;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent shareItemIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        return intent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent uriIntent(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return new Intent("android.intent.action.VIEW", uri);
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent uriIntentCustomChromeTabs(@NotNull Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        CustomTabsIntent.Builder showTitle = new CustomTabsIntent.Builder().setToolbarColor(Contexts.getColorCompat(this.a, R.color.avito_white)).setShowTitle(true);
        if (z) {
            showTitle = showTitle.addDefaultShareMenuItem();
        }
        Intent data = showTitle.build().intent.setData(uri);
        Intrinsics.checkNotNullExpressionValue(data, "CustomTabsIntent.Builder…            .setData(uri)");
        return data;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent uriIntent(@NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        Intent intent = new Intent("android.intent.action.VIEW", uri).setPackage(str);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(Intent.ACTION_VIE… .setPackage(packageName)");
        return intent;
    }

    @Override // com.avito.android.util.ImplicitIntentFactory
    @NotNull
    public Intent shareIntent(@Nullable String str, @NotNull String str2, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        if (str != null) {
            str2 = a.e3(str, "\n", str2);
        }
        Intent putExtra = new Intent("android.intent.action.SEND").setType("image/*").putExtra("android.intent.extra.STREAM", uri).putExtra("android.intent.extra.TEXT", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_SEN…(Intent.EXTRA_TEXT, text)");
        return putExtra;
    }
}
