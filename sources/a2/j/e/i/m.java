package a2.j.e.i;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.iid.FirebaseInstanceId;
public final /* synthetic */ class m implements EventHandler {
    public final FirebaseInstanceId.a a;

    public m(FirebaseInstanceId.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.firebase.events.EventHandler
    public final void handle(Event event) {
        FirebaseInstanceId.a aVar = this.a;
        synchronized (aVar) {
            if (aVar.b()) {
                FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.this;
                i0 i0Var = FirebaseInstanceId.j;
                firebaseInstanceId.p();
            }
        }
    }
}
