package com.avito.android.util;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.avito.android.CalledFrom;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\",\u0010\u0002\u001a\u0004\u0018\u00010\u0011*\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/content/Intent;", "", "calledFrom", "putCalledFromExtra", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "getCalledFromExtra", "(Landroid/content/Intent;)Ljava/lang/String;", "", "Landroid/net/Uri;", "extractClipDataUris", "(Landroid/content/Intent;)Ljava/util/List;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeClickStreamParent", "putTreeAnalyticsParent", "(Landroid/content/Intent;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "getTreeAnalyticsParent", "(Landroid/content/Intent;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/CalledFrom;", "value", "getCalledFrom", "(Landroid/content/Intent;)Lcom/avito/android/CalledFrom;", "setCalledFrom", "(Landroid/content/Intent;Lcom/avito/android/CalledFrom;)V", "core_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Intents")
public final class Intents {
    @NotNull
    public static final List<Uri> extractClipDataUris(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$extractClipDataUris");
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(clipData, "this.clipData ?: return emptyList()");
        ArrayList arrayList = new ArrayList(clipData.getItemCount());
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            Intrinsics.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(i)");
            arrayList.add(itemAt.getUri());
        }
        return arrayList;
    }

    @Nullable
    public static final CalledFrom getCalledFrom(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$calledFrom");
        return (CalledFrom) intent.getParcelableExtra("called_from");
    }

    @Nullable
    public static final String getCalledFromExtra(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getCalledFromExtra");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getString("from");
        }
        return null;
    }

    @Nullable
    public static final TreeClickStreamParent getTreeAnalyticsParent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getTreeAnalyticsParent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return (TreeClickStreamParent) extras.getParcelable("treeAnalyticsParent");
        }
        return null;
    }

    @NotNull
    public static final Intent putCalledFromExtra(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putCalledFromExtra");
        Intrinsics.checkNotNullParameter(str, "calledFrom");
        Intent putExtra = intent.putExtra("from", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(EXTRA_FROM, calledFrom)");
        return putExtra;
    }

    @NotNull
    public static final Intent putTreeAnalyticsParent(@NotNull Intent intent, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(intent, "$this$putTreeAnalyticsParent");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeClickStreamParent");
        Intent putExtra = intent.putExtra("treeAnalyticsParent", treeClickStreamParent);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(EXTRA_TREE_ANAL…T, treeClickStreamParent)");
        return putExtra;
    }

    public static final void setCalledFrom(@NotNull Intent intent, @Nullable CalledFrom calledFrom) {
        Intrinsics.checkNotNullParameter(intent, "$this$calledFrom");
        intent.putExtra("called_from", calledFrom);
    }
}
