package com.avito.android.messenger.conversation.mvi.send;

import android.content.Context;
import android.net.Uri;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Files;
import com.avito.android.util.Logs;
import com.avito.android.util.Strings;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001b\u001a\u00020\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u001e\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010&\u001a\u0004\u0018\u00010\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorageImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "Landroid/net/Uri;", "sourceUri", "keep", "(Landroid/net/Uri;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", PhoneActionStrings.REMOVE, "(Landroid/net/Uri;)V", "", "exists", "(Landroid/net/Uri;)Z", "", "timestamp", "deleteFilesModifiedBefore", "(J)V", "Ljava/io/File;", "target", AuthSource.BOOKING_ORDER, "(Landroid/net/Uri;Ljava/io/File;)Z", AuthSource.SEND_ABUSE, "(Ljava/io/File;J)V", "d", "Lkotlin/Lazy;", "getPhotosInternalDir", "()Ljava/io/File;", "photosInternalDir", "Ljava/io/File;", "privateExternalDir", "kotlin.jvm.PlatformType", "privateInternalDir", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "c", "getPhotosExternalDir", "photosExternalDir", "<init>", "(Landroid/content/Context;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerPhotoStorageImpl implements MessengerPhotoStorage {
    public final File a;
    public final File b;
    public final Lazy c = c.lazy(new a(this));
    public final Lazy d = c.lazy(new b(this));
    public final Context e;

    public static final class a extends Lambda implements Function0<File> {
        public final /* synthetic */ MessengerPhotoStorageImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MessengerPhotoStorageImpl messengerPhotoStorageImpl) {
            super(0);
            this.a = messengerPhotoStorageImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            MessengerPhotoStorageImpl messengerPhotoStorageImpl = this.a;
            if (messengerPhotoStorageImpl.a == null) {
                return null;
            }
            File file = new File(messengerPhotoStorageImpl.a, "photos/messenger");
            Files.ensureDirectoryExists(file);
            return file;
        }
    }

    public static final class b extends Lambda implements Function0<File> {
        public final /* synthetic */ MessengerPhotoStorageImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MessengerPhotoStorageImpl messengerPhotoStorageImpl) {
            super(0);
            this.a = messengerPhotoStorageImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            File file = new File(this.a.b, "photos/messenger");
            Files.ensureDirectoryExists(file);
            return file;
        }
    }

    @Inject
    public MessengerPhotoStorageImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
        this.a = context.getExternalFilesDir(null);
        this.b = context.getFilesDir();
    }

    public static final File access$createExternalDir(MessengerPhotoStorageImpl messengerPhotoStorageImpl) {
        Objects.requireNonNull(messengerPhotoStorageImpl);
        if (messengerPhotoStorageImpl.a == null) {
            return null;
        }
        File file = new File(messengerPhotoStorageImpl.a, "photos/messenger");
        Files.ensureDirectoryExists(file);
        return file;
    }

    public static final File access$createInternalDir(MessengerPhotoStorageImpl messengerPhotoStorageImpl) {
        Objects.requireNonNull(messengerPhotoStorageImpl);
        File file = new File(messengerPhotoStorageImpl.b, "photos/messenger");
        Files.ensureDirectoryExists(file);
        return file;
    }

    public static final boolean access$isFile(MessengerPhotoStorageImpl messengerPhotoStorageImpl, Uri uri) {
        boolean z;
        Objects.requireNonNull(messengerPhotoStorageImpl);
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            return false;
        }
        String authority = uri.getAuthority();
        if (!(authority == null || authority.length() == 0)) {
            return false;
        }
        String path = uri.getPath();
        if (path != null) {
            if (path.length() > 0) {
                z = true;
                if (!z && uri.getQuery() == null && uri.getFragment() == null) {
                    return true;
                }
                return false;
            }
        }
        z = false;
        return !z ? false : false;
    }

    public static final boolean access$isFromCacheDir(MessengerPhotoStorageImpl messengerPhotoStorageImpl, Uri uri) {
        Objects.requireNonNull(messengerPhotoStorageImpl);
        String uri2 = Uri.fromFile(messengerPhotoStorageImpl.e.getCacheDir()).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "Uri.fromFile(context.cacheDir).toString()");
        String ensureEndsWith = Strings.ensureEndsWith(uri2, "/");
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "toString()");
        return m.startsWith$default(uri3, ensureEndsWith, false, 2, null);
    }

    public static final boolean access$isFromExternalPrivateDir(MessengerPhotoStorageImpl messengerPhotoStorageImpl, Uri uri) {
        Objects.requireNonNull(messengerPhotoStorageImpl);
        File externalFilesDir = messengerPhotoStorageImpl.e.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(externalFilesDir, "context.getExternalFilesDir(null) ?: return false");
        String uri2 = Uri.fromFile(externalFilesDir).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "Uri.fromFile(externalDir).toString()");
        String ensureEndsWith = Strings.ensureEndsWith(uri2, "/");
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "toString()");
        return m.startsWith$default(uri3, ensureEndsWith, false, 2, null);
    }

    public static final boolean access$isFromInternalPrivateDir(MessengerPhotoStorageImpl messengerPhotoStorageImpl, Uri uri) {
        Objects.requireNonNull(messengerPhotoStorageImpl);
        String uri2 = Uri.fromFile(messengerPhotoStorageImpl.e.getFilesDir()).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "Uri.fromFile(context.filesDir).toString()");
        String ensureEndsWith = Strings.ensureEndsWith(uri2, "/");
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "toString()");
        return m.startsWith$default(uri3, ensureEndsWith, false, 2, null);
    }

    public final void a(File file, long j) {
        StringBuilder L = a2.b.a.a.a.L("Deleting files in ");
        L.append(file.getAbsolutePath());
        L.append(" that modified before ");
        L.append(j);
        Logs.debug$default("MessengerPhotoStorage", L.toString(), null, 4, null);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file2 : listFiles) {
                if (file2.lastModified() < j) {
                    arrayList.add(file2);
                }
            }
            for (File file3 : arrayList) {
                file3.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Deleted an old file: ");
                Intrinsics.checkNotNullExpressionValue(file3, "file");
                sb.append(file3.getAbsolutePath());
                Logs.verbose$default("MessengerPhotoStorage", sb.toString(), null, 4, null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        if (t6.y.m.startsWith$default(r5, r1, false, 2, null) != false) goto L_0x00cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce A[SYNTHETIC, Splitter:B:38:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.net.Uri r10, java.io.File r11) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorageImpl.b(android.net.Uri, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r6.getFragment() == null) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    @Override // com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(@org.jetbrains.annotations.NotNull android.net.Uri r6) {
        /*
            r5 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r6.getScheme()
            java.lang.String r1 = "file"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r6.getAuthority()
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r6.getPath()
            if (r0 == 0) goto L_0x0038
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r6.getQuery()
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = r6.getFragment()
            if (r0 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            if (r1 == 0) goto L_0x0089
            java.lang.String r0 = r6.getPath()
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            java.lang.String r0 = ""
        L_0x0054:
            r1 = 2
            java.lang.String r3 = "/photos/messenger/"
            r4 = 0
            boolean r0 = kotlin.text.StringsKt__StringsKt.contains$default(r0, r3, r2, r1, r4)
            if (r0 == 0) goto L_0x0089
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.toString()
            java.net.URI r1 = java.net.URI.create(r1)
            r0.<init>(r1)
            boolean r0 = r0.delete()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r6 = " deleted = "
            r1.append(r6)
            r1.append(r0)
            java.lang.String r6 = r1.toString()
            r0 = 4
            java.lang.String r1 = "MessengerPhotoStorage"
            com.avito.android.util.Logs.verbose$default(r1, r6, r4, r0, r4)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorageImpl.delete(android.net.Uri):void");
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage
    public void deleteFilesModifiedBefore(long j) {
        File file = (File) this.c.getValue();
        if (file != null) {
            a(file, j);
        }
        a((File) this.d.getValue(), j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r5.getFragment() == null) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    @Override // com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean exists(@org.jetbrains.annotations.NotNull android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.getScheme()
            java.lang.String r1 = "file"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r5.getAuthority()
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r5.getPath()
            if (r0 == 0) goto L_0x0038
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = r5.getQuery()
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = r5.getFragment()
            if (r0 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            if (r1 == 0) goto L_0x0075
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005e }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x005e }
            java.net.URI r1 = java.net.URI.create(r1)     // Catch:{ Exception -> 0x005e }
            r0.<init>(r1)     // Catch:{ Exception -> 0x005e }
            boolean r5 = r0.exists()     // Catch:{ Exception -> 0x005e }
            r2 = r5
            goto L_0x0075
        L_0x005e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Couldn't resolve file by uri: "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "MessengerPhotoStorage"
            com.avito.android.util.Logs.debug(r1, r5, r0)
        L_0x0075:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorageImpl.exists(android.net.Uri):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[Catch:{ Exception -> 0x0063 }] */
    @Override // com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri keep(@org.jetbrains.annotations.NotNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MessengerPhotoStorage"
            java.lang.String r1 = "sourceUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            r1 = 4
            r2 = 0
            kotlin.Lazy r3 = r6.c     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0063 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ Exception -> 0x0063 }
            if (r3 == 0) goto L_0x001e
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0063 }
            if (r4 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r2
        L_0x001b:
            if (r3 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            kotlin.Lazy r3 = r6.d     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0063 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ Exception -> 0x0063 }
        L_0x0026:
            java.lang.String r4 = "msg-"
            java.lang.String r5 = ".jpg"
            java.io.File r3 = java.io.File.createTempFile(r4, r5, r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0063 }
            boolean r4 = r6.b(r7, r3)     // Catch:{ Exception -> 0x0063 }
            if (r4 != 0) goto L_0x005e
            android.content.Context r4 = r6.e     // Catch:{ Exception -> 0x0063 }
            com.avito.android.util.Uris.saveContentToFile(r7, r4, r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r4.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r5 = "Content of "
            r4.append(r5)     // Catch:{ Exception -> 0x0063 }
            r4.append(r7)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r5 = " copied to "
            r4.append(r5)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r5 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0063 }
            r4.append(r5)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0063 }
            com.avito.android.util.Logs.verbose$default(r0, r4, r2, r1, r2)     // Catch:{ Exception -> 0x0063 }
        L_0x005e:
            android.net.Uri r2 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x0063 }
            goto L_0x006c
        L_0x0063:
            java.lang.String r3 = "Failed to copy file: "
            java.lang.String r7 = a2.b.a.a.a.W2(r3, r7)
            com.avito.android.util.Logs.warning$default(r0, r7, r2, r1, r2)
        L_0x006c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorageImpl.keep(android.net.Uri):android.net.Uri");
    }
}
