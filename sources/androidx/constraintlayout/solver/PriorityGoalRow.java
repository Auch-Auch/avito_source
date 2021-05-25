package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;
public class PriorityGoalRow extends ArrayRow {
    public int e = 128;
    public SolverVariable[] f = new SolverVariable[128];
    public SolverVariable[] g = new SolverVariable[128];
    public int h = 0;
    public b i = new b(this);

    public class a implements Comparator<SolverVariable> {
        public a(PriorityGoalRow priorityGoalRow) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.id - solverVariable2.id;
        }
    }

    public class b implements Comparable {
        public SolverVariable a;

        public b(PriorityGoalRow priorityGoalRow) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.a.id - ((SolverVariable) obj).id;
        }

        @Override // java.lang.Object
        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder L = a2.b.a.a.a.L(str);
                    L.append(this.a.d[i]);
                    L.append(" ");
                    str = L.toString();
                }
            }
            StringBuilder Q = a2.b.a.a.a.Q(str, "] ");
            Q.append(this.a);
            return Q.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.a
    public void addError(SolverVariable solverVariable) {
        this.i.a = solverVariable;
        Arrays.fill(solverVariable.d, 0.0f);
        solverVariable.d[solverVariable.strength] = 1.0f;
        e(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.a
    public void clear() {
        this.h = 0;
        this.b = 0.0f;
    }

    public final void e(SolverVariable solverVariable) {
        int i2;
        int i3 = this.h + 1;
        SolverVariable[] solverVariableArr = this.f;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f = solverVariableArr2;
            this.g = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f;
        int i4 = this.h;
        solverVariableArr3[i4] = solverVariable;
        int i5 = i4 + 1;
        this.h = i5;
        if (i5 > 1 && solverVariableArr3[i5 - 1].id > solverVariable.id) {
            int i6 = 0;
            while (true) {
                i2 = this.h;
                if (i6 >= i2) {
                    break;
                }
                this.g[i6] = this.f[i6];
                i6++;
            }
            Arrays.sort(this.g, 0, i2, new a(this));
            for (int i7 = 0; i7 < this.h; i7++) {
                this.f[i7] = this.g[i7];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    public final void f(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.h) {
            if (this.f[i2] == solverVariable) {
                while (true) {
                    int i3 = this.h;
                    if (i2 < i3 - 1) {
                        SolverVariable[] solverVariableArr = this.f;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    } else {
                        this.h = i3 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r8 < r7) goto L_0x0057;
     */
    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.SolverVariable getPivotCandidate(androidx.constraintlayout.solver.LinearSystem r11, boolean[] r12) {
        /*
            r10 = this;
            r11 = 0
            r0 = -1
            r1 = 0
            r2 = -1
        L_0x0004:
            int r3 = r10.h
            if (r1 >= r3) goto L_0x005d
            androidx.constraintlayout.solver.SolverVariable[] r3 = r10.f
            r4 = r3[r1]
            int r5 = r4.id
            boolean r5 = r12[r5]
            if (r5 == 0) goto L_0x0013
            goto L_0x005a
        L_0x0013:
            androidx.constraintlayout.solver.PriorityGoalRow$b r5 = r10.i
            r5.a = r4
            r4 = 8
            r6 = 1
            if (r2 != r0) goto L_0x0039
            java.util.Objects.requireNonNull(r5)
        L_0x001f:
            if (r4 < 0) goto L_0x0035
            androidx.constraintlayout.solver.SolverVariable r3 = r5.a
            float[] r3 = r3.d
            r3 = r3[r4]
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            int r4 = r4 + -1
            goto L_0x001f
        L_0x0035:
            r6 = 0
        L_0x0036:
            if (r6 == 0) goto L_0x005a
            goto L_0x0059
        L_0x0039:
            r3 = r3[r2]
            java.util.Objects.requireNonNull(r5)
        L_0x003e:
            if (r4 < 0) goto L_0x0056
            float[] r7 = r3.d
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r8 = r5.a
            float[] r8 = r8.d
            r8 = r8[r4]
            int r9 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0051
            int r4 = r4 + -1
            goto L_0x003e
        L_0x0051:
            int r3 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r6 = 0
        L_0x0057:
            if (r6 == 0) goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x005d:
            if (r2 != r0) goto L_0x0061
            r11 = 0
            return r11
        L_0x0061:
            androidx.constraintlayout.solver.SolverVariable[] r11 = r10.f
            r11 = r11[r2]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.PriorityGoalRow.getPivotCandidate(androidx.constraintlayout.solver.LinearSystem, boolean[]):androidx.constraintlayout.solver.SolverVariable");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.a
    public boolean isEmpty() {
        return this.h == 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        StringBuilder Q = a2.b.a.a.a.Q("", " goal -> (");
        Q.append(this.b);
        Q.append(") : ");
        String sb = Q.toString();
        for (int i2 = 0; i2 < this.h; i2++) {
            this.i.a = this.f[i2];
            StringBuilder L = a2.b.a.a.a.L(sb);
            L.append(this.i);
            L.append(" ");
            sb = L.toString();
        }
        return sb;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.a;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                SolverVariable variable = arrayRowVariables.getVariable(i2);
                float variableValue = arrayRowVariables.getVariableValue(i2);
                b bVar = this.i;
                bVar.a = variable;
                boolean z2 = true;
                if (variable.inGoal) {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float[] fArr = bVar.a.d;
                        fArr[i3] = (solverVariable.d[i3] * variableValue) + fArr[i3];
                        if (Math.abs(fArr[i3]) < 1.0E-4f) {
                            bVar.a.d[i3] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        PriorityGoalRow.this.f(bVar.a);
                    }
                    z2 = false;
                } else {
                    for (int i4 = 0; i4 < 9; i4++) {
                        float f2 = solverVariable.d[i4];
                        if (f2 != 0.0f) {
                            float f3 = f2 * variableValue;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            bVar.a.d[i4] = f3;
                        } else {
                            bVar.a.d[i4] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    e(variable);
                }
                this.b = (arrayRow.b * variableValue) + this.b;
            }
            f(solverVariable);
        }
    }
}
