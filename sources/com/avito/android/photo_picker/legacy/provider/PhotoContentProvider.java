package com.avito.android.photo_picker.legacy.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerPhotoContentProviderComponent;
import com.avito.android.di.component.PhotoContentProviderComponent;
import com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ContentProviderDelegate;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0017\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JM\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0007R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/avito/android/photo_picker/legacy/provider/PhotoContentProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "()Z", "", "provideDependencies", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", ResidentialComplexModuleKt.VALUES, "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "selection", "", "selectionArgs", "", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", PhoneActionStrings.REMOVE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "projection", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/ContentProviderDelegate;", "delegate", "Lcom/avito/android/util/ContentProviderDelegate;", "getDelegate", "()Lcom/avito/android/util/ContentProviderDelegate;", "setDelegate", "(Lcom/avito/android/util/ContentProviderDelegate;)V", "<init>", "Companion", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public class PhotoContentProvider extends ContentProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ContentProviderDelegate delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/provider/PhotoContentProvider$Companion;", "", "", "applicationPackageId", "getAuthority", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "getBaseUri", "(Ljava/lang/String;)Landroid/net/Uri;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final String getAuthority(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "applicationPackageId");
            return str + ".provider.photo";
        }

        @NotNull
        public final Uri getBaseUri(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "applicationPackageId");
            Uri parse = Uri.parse("content://" + getAuthority(str));
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(\n            \"…ionPackageId)}\"\n        )");
            return parse;
        }

        public Companion(j jVar) {
        }
    }

    public final void a() {
        if (this.delegate == null) {
            provideDependencies();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        a();
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate.delete(uri, str, strArr);
    }

    @NotNull
    public final ContentProviderDelegate getDelegate() {
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        a();
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate.getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        a();
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @VisibleForTesting
    public void provideDependencies() {
        PhotoContentProviderComponent.Builder photoContentProviderDependencies = DaggerPhotoContentProviderComponent.builder().photoContentProviderDependencies((PhotoContentProviderDependencies) ComponentDependenciesKt.getDependencies(PhotoContentProviderDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context!!.contentResolver");
        photoContentProviderDependencies.contentResolver(contentResolver).build().inject(this);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        a();
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate.query(uri, strArr, str, strArr2, str2);
    }

    public final void setDelegate(@NotNull ContentProviderDelegate contentProviderDelegate) {
        Intrinsics.checkNotNullParameter(contentProviderDelegate, "<set-?>");
        this.delegate = contentProviderDelegate;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        a();
        ContentProviderDelegate contentProviderDelegate = this.delegate;
        if (contentProviderDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return contentProviderDelegate.update(uri, contentValues, str, strArr);
    }
}
