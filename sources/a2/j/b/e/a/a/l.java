package a2.j.b.e.a.a;

import com.google.android.play.core.appupdate.AppUpdateOptions;
public final class l extends AppUpdateOptions.Builder {
    public Integer a;
    public Boolean b;

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final void a() {
        this.b = Boolean.FALSE;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions build() {
        String str = "";
        if (this.a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.b == null) {
            str = String.valueOf(str).concat(" allowClearStorage");
        }
        if (str.isEmpty()) {
            return new m(this.a.intValue(), this.b.booleanValue());
        }
        throw new IllegalStateException(str.length() == 0 ? new String("Missing required properties:") : "Missing required properties:".concat(str));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }
}
