package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;", "", "", AuthSource.SEND_ABUSE, "I", "getSmallIconResId", "()I", "smallIconResId", AuthSource.BOOKING_ORDER, "getLargeIconResId", "largeIconResId", "<init>", "(Ljava/lang/String;III)V", "TRANSPORT", "REALTY", "JOB", "SERVICES", "ALL", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public enum RubricatorCategory {
    TRANSPORT(R.drawable.rubricator_transport, R.drawable.rubricator_large_transport),
    REALTY(R.drawable.rubricator_realty, R.drawable.rubricator_large_realty),
    JOB(R.drawable.rubricator_job, R.drawable.rubricator_large_job),
    SERVICES(R.drawable.rubricator_services, R.drawable.rubricator_large_services),
    ALL(R.drawable.rubricator_all, 0);
    
    public final int a;
    public final int b;

    /* access modifiers changed from: public */
    RubricatorCategory(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int getLargeIconResId() {
        return this.b;
    }

    public final int getSmallIconResId() {
        return this.a;
    }
}
