package Modelo;

public class Analizar {

    private int[][] jugada;
    public int a = 3, parar;

    public Analizar(int[][] jugada) {
        this.jugada = jugada;
        parar = 0;
    }

    private void lleno() {
        int r = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (jugada[i][j] != 0) {
                    r++;
                    if (r == 9) {
                        parar = 3;
                    }
                }
            }
        }

    }

    private void horizontal1() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[i][0] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[i][0] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void horizontal2() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[i][1] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[i][1] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void horizontal3() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[i][2] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[i][2] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void vertical1() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[0][i] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[0][i] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void vertical2() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[1][i] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[1][i] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void vertical3() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[2][i] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[2][i] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void diagonal1() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[i][i] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[i][i] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    private void diagonal2() {
        int j1 = 0, j2 = 0;
        for (int i = 0; i < 3; i++) {
            if (jugada[i][2 - i] == 1) {
                j1++;
                if (j1 == 3) {
                    parar = 1;
                }
            } else if (jugada[i][2 - i] == 2) {
                j2++;
                if (j2 == 3) {
                    parar = 2;
                }
            }
        }
    }

    public int analizar() {
        if (parar == 0) {
            horizontal1();
        }
        if (parar == 0) {
            horizontal2();
        }
        if (parar == 0) {
            horizontal3();
        }
        if (parar == 0) {
            vertical1();
        }
        if (parar == 0) {
            vertical2();
        }
        if (parar == 0) {
            vertical3();
        }
        if (parar == 0) {
            diagonal1();
        }
        if (parar == 0) {
            diagonal2();
        }
        if (parar == 0) {
            lleno();
        }
        return parar;
    }
}
