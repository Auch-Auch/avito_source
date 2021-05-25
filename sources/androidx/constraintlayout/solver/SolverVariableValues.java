package androidx.constraintlayout.solver;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public int a = 16;
    public int[] b = new int[16];
    public int[] c = new int[16];
    public int[] d = new int[16];
    public float[] e = new float[16];
    public int[] f = new int[16];
    public int[] g = new int[16];
    public int h = 0;
    public int i = -1;
    public final ArrayRow j;
    public final Cache mCache;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.j = arrayRow;
        this.mCache = cache;
        clear();
    }

    public final void a(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.id % 16;
        int[] iArr2 = this.b;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.c;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.c[i2] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f2);
                return;
            }
            float[] fArr = this.e;
            fArr[indexOf] = fArr[indexOf] + f2;
            if (fArr[indexOf] > -0.001f && fArr[indexOf] < 0.001f) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z);
            }
        }
    }

    public final void b(int i2, SolverVariable solverVariable, float f2) {
        this.d[i2] = solverVariable.id;
        this.e[i2] = f2;
        this.f[i2] = -1;
        this.g[i2] = -1;
        solverVariable.addToRow(this.j);
        solverVariable.usageInRowCount++;
        this.h++;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                variable.removeFromRow(this.j);
            }
        }
        for (int i4 = 0; i4 < this.a; i4++) {
            this.d[i4] = -1;
            this.c[i4] = -1;
        }
        for (int i5 = 0; i5 < 16; i5++) {
            this.b[i5] = -1;
        }
        this.h = 0;
        this.i = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.h;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f2) {
        int i2 = this.h;
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.e;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.g[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.e[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.h;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.i;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.mCache.d[this.d[i4]];
            }
            i4 = this.g[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i3 = this.h;
        int i4 = this.i;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.e[i4];
            }
            i4 = this.g[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int[] iArr;
        if (!(this.h == 0 || solverVariable == null)) {
            int i2 = solverVariable.id;
            int i3 = this.b[i2 % 16];
            if (i3 == -1) {
                return -1;
            }
            if (this.d[i3] == i2) {
                return i3;
            }
            while (true) {
                iArr = this.c;
                if (iArr[i3] == -1 || this.d[iArr[i3]] == i2) {
                    break;
                }
                i3 = iArr[i3];
            }
            if (iArr[i3] != -1 && this.d[iArr[i3]] == i2) {
                return iArr[i3];
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.h;
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.e;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.g[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f2) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = 0;
            if (this.h == 0) {
                b(0, solverVariable, f2);
                a(solverVariable, 0);
                this.i = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.e[indexOf] = f2;
                return;
            }
            int i3 = this.h + 1;
            int i4 = this.a;
            if (i3 >= i4) {
                int i5 = i4 * 2;
                this.d = Arrays.copyOf(this.d, i5);
                this.e = Arrays.copyOf(this.e, i5);
                this.f = Arrays.copyOf(this.f, i5);
                this.g = Arrays.copyOf(this.g, i5);
                this.c = Arrays.copyOf(this.c, i5);
                for (int i6 = this.a; i6 < i5; i6++) {
                    this.d[i6] = -1;
                    this.c[i6] = -1;
                }
                this.a = i5;
            }
            int i7 = this.h;
            int i8 = this.i;
            int i9 = -1;
            for (int i10 = 0; i10 < i7; i10++) {
                int[] iArr = this.d;
                int i11 = iArr[i8];
                int i12 = solverVariable.id;
                if (i11 == i12) {
                    this.e[i8] = f2;
                    return;
                }
                if (iArr[i8] < i12) {
                    i9 = i8;
                }
                i8 = this.g[i8];
                if (i8 == -1) {
                    break;
                }
            }
            while (true) {
                if (i2 >= this.a) {
                    i2 = -1;
                    break;
                } else if (this.d[i2] == -1) {
                    break;
                } else {
                    i2++;
                }
            }
            b(i2, solverVariable, f2);
            if (i9 != -1) {
                this.f[i2] = i9;
                int[] iArr2 = this.g;
                iArr2[i2] = iArr2[i9];
                iArr2[i9] = i2;
            } else {
                this.f[i2] = -1;
                if (this.h > 0) {
                    this.g[i2] = this.i;
                    this.i = i2;
                } else {
                    this.g[i2] = -1;
                }
            }
            int[] iArr3 = this.g;
            if (iArr3[i2] != -1) {
                this.f[iArr3[i2]] = i2;
            }
            a(solverVariable, i2);
            return;
        }
        remove(solverVariable, true);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        int[] iArr;
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        int i2 = solverVariable.id;
        int i3 = i2 % 16;
        int[] iArr2 = this.b;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.d[i4] == i2) {
                int[] iArr3 = this.c;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
            } else {
                while (true) {
                    iArr = this.c;
                    if (iArr[i4] == -1 || this.d[iArr[i4]] == i2) {
                        break;
                    }
                    i4 = iArr[i4];
                }
                int i5 = iArr[i4];
                if (i5 != -1 && this.d[i5] == i2) {
                    iArr[i4] = iArr[i5];
                    iArr[i5] = -1;
                }
            }
        }
        float f2 = this.e[indexOf];
        if (this.i == indexOf) {
            this.i = this.g[indexOf];
        }
        this.d[indexOf] = -1;
        int[] iArr4 = this.f;
        if (iArr4[indexOf] != -1) {
            int[] iArr5 = this.g;
            iArr5[iArr4[indexOf]] = iArr5[indexOf];
        }
        int[] iArr6 = this.g;
        if (iArr6[indexOf] != -1) {
            iArr4[iArr6[indexOf]] = iArr4[indexOf];
        }
        this.h--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.j);
        }
        return f2;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i3) + " ";
                int indexOf = indexOf(variable);
                String c3 = a.c3(str4, "[p: ");
                if (this.f[indexOf] != -1) {
                    StringBuilder L = a.L(c3);
                    L.append(this.mCache.d[this.d[this.f[indexOf]]]);
                    str = L.toString();
                } else {
                    str = a.c3(c3, "none");
                }
                String c32 = a.c3(str, ", n: ");
                if (this.g[indexOf] != -1) {
                    StringBuilder L2 = a.L(c32);
                    L2.append(this.mCache.d[this.d[this.g[indexOf]]]);
                    str2 = L2.toString();
                } else {
                    str2 = a.c3(c32, "none");
                }
                str3 = a.c3(str2, "]");
            }
        }
        return a.c3(str3, " }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f2 = get(arrayRow.a);
        remove(arrayRow.a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i2 = 0;
        int i3 = 0;
        while (i2 < currentSize) {
            int[] iArr = solverVariableValues.d;
            if (iArr[i3] != -1) {
                add(this.mCache.d[iArr[i3]], solverVariableValues.e[i3] * f2, z);
                i2++;
            }
            i3++;
        }
        return f2;
    }
}
