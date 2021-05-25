package a2.g.k.z;

import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import java.io.File;
import java.util.List;
public final class d implements FileDownloadTask.Callback {
    public final /* synthetic */ List a;

    public class a implements FileDownloadTask.Callback {
        public final /* synthetic */ ModelManager.b a;
        public final /* synthetic */ Model b;

        public a(d dVar, ModelManager.b bVar, Model model) {
            this.a = bVar;
            this.b = model;
        }

        @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
        public void onComplete(File file) {
            ModelManager.b bVar = this.a;
            bVar.g = this.b;
            bVar.f = file;
            Runnable runnable = bVar.h;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(List list) {
        this.a = list;
    }

    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
    public void onComplete(File file) {
        Model build = Model.build(file);
        if (build != null) {
            for (ModelManager.b bVar : this.a) {
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.a);
                sb.append("_");
                ModelManager.b.b(bVar.c, a2.b.a.a.a.j(sb, bVar.d, "_rule"), new a(this, bVar, build));
            }
        }
    }
}
