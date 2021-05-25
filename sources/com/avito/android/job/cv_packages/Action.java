package com.avito.android.job.cv_packages;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/job/cv_packages/Action;", "", "<init>", "()V", "Exit", "PackageClicked", HttpHeaders.REFRESH, "Lcom/avito/android/job/cv_packages/Action$Refresh;", "Lcom/avito/android/job/cv_packages/Action$Exit;", "Lcom/avito/android/job/cv_packages/Action$PackageClicked;", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public abstract class Action {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/cv_packages/Action$Exit;", "Lcom/avito/android/job/cv_packages/Action;", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Exit extends Action {
        @NotNull
        public static final Exit INSTANCE = new Exit();

        public Exit() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/cv_packages/Action$PackageClicked;", "Lcom/avito/android/job/cv_packages/Action;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class PackageClicked extends Action {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PackageClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "link");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/cv_packages/Action$Refresh;", "Lcom/avito/android/job/cv_packages/Action;", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
    public static final class Refresh extends Action {
        @NotNull
        public static final Refresh INSTANCE = new Refresh();

        public Refresh() {
            super(null);
        }
    }

    public Action() {
    }

    public Action(j jVar) {
    }
}
