package com.avito.android.job.cv_packages;

import a2.b.a.a.a;
import com.avito.android.job.cv_packages.item.PackageItem;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/job/cv_packages/State;", "", "<init>", "()V", "Content", "Error", "Loading", "Lcom/avito/android/job/cv_packages/State$Loading;", "Lcom/avito/android/job/cv_packages/State$Content;", "Lcom/avito/android/job/cv_packages/State$Error;", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public abstract class State {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/job/cv_packages/State$Content;", "Lcom/avito/android/job/cv_packages/State;", "", "Lcom/avito/android/job/cv_packages/item/PackageItem;", "c", "Ljava/util/List;", "getPackages", "()Ljava/util/List;", "packages", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends State {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final List<PackageItem> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull String str, @NotNull String str2, @NotNull List<PackageItem> list) {
            super(null);
            a.c1(str, "title", str2, MessengerShareContentUtility.SUBTITLE, list, "packages");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        @NotNull
        public final List<PackageItem> getPackages() {
            return this.c;
        }

        @NotNull
        public final String getSubtitle() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/cv_packages/State$Error;", "Lcom/avito/android/job/cv_packages/State;", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends State {
        @NotNull
        public static final Error INSTANCE = new Error();

        public Error() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/cv_packages/State$Loading;", "Lcom/avito/android/job/cv_packages/State;", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends State {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    public State() {
    }

    public State(j jVar) {
    }
}
