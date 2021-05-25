package com.avito.android.autoteka_details;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "", "<init>", "()V", "Back", "ExampleReport", "GetReport", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$Back;", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$ExampleReport;", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$GetReport;", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class AutotekaDetailsNavigation {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$Back;", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "<init>", "()V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Back extends AutotekaDetailsNavigation {
        public Back() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$ExampleReport;", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "url", "<init>", "(Landroid/net/Uri;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExampleReport extends AutotekaDetailsNavigation {
        @NotNull
        public final Uri a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExampleReport(@NotNull Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "url");
            this.a = uri;
        }

        @NotNull
        public final Uri getUrl() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation$GetReport;", "Lcom/avito/android/autoteka_details/AutotekaDetailsNavigation;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "url", "<init>", "(Landroid/net/Uri;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class GetReport extends AutotekaDetailsNavigation {
        @NotNull
        public final Uri a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GetReport(@NotNull Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "url");
            this.a = uri;
        }

        @NotNull
        public final Uri getUrl() {
            return this.a;
        }
    }

    public AutotekaDetailsNavigation() {
    }

    public AutotekaDetailsNavigation(j jVar) {
    }
}
