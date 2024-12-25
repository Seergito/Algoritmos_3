import java.util.ArrayList;

public class a12 {

    public static int SeleccionRapida(int[] array, int k_menor, int i, int j) {
        int indicePivote = buscaPivote(array, i, j);
        if (indicePivote != -1) {
            int pivote = array[indicePivote];
            intercambiar(array, i, j);
            int k = particion(array, i, j, pivote);
            if (k_menor <= k) {
                SeleccionRapida(array, k_menor, i, k - 1);
            } else {
                if (k_menor == k + 1) {
                    return pivote;
                } else {
                      SeleccionRapida(array, k_menor, k, j);
              }
            }

        }
        return array[i];
    }

    public static int inversiones(int[] array, int inicio, int fin){
        if(inicio<fin){
            int medio = (inicio + fin)/2;
            return inversiones(array, inicio, medio)+ inversiones(array, medio+1, fin)+merge
        }
        return 0;
    }

    private static int mergeCount(int[] aux, int inicio1, int fin1, int inicio2, int fin2){
        int i = inicio1;
        int j= inicio2;
        int cont=0;
        int pos = inicio2 - inicio1; //Numero máximo de inversiones

        ArrayList<Integer> temp = new ArrayList<>();
        while(i <= fin1 && j <= fin2){
            if(aux[i] <= aux[j]){
                temp.add(aux[i++]);
                pos--;
            }else{
                temp.add(aux[j++]);
                cont +=pos;
            }
        }
        while(i<=fin1){
            temp.add(aux[i++]);
        }
        while(j<=fin2){
            temp.add(aux[j++]);
        }

        for (int t = inicio1; t <= fin2; t++) {
            aux[t]=temp.remove(0);
        }

        return cont;



    }

    public static int buscarPosK(int[] v, int inicio, int fin) {
        if (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (medio == 0 || medio == v.length - 1)
                return -1;

            if (v[medio] < v[medio - 1] && v[medio] < v[medio + 1]) {
                return medio;
            } else if (v[medio] < v[medio - 1] && v[medio + 1] < v[medio]) {
                return buscarPosK(v, medio + 1, fin);
            } else {
                return buscarPosK(v, inicio, medio - 1);
            }
        }
        return -1;
    }

    public static void moverDiscos(int numDiscos, String inicio, String intermedio, String fin) {
        if (numDiscos == 1) {
            System.out.println("Mover disco de " + inicio + " a " + fin);
        } else {
            moverDiscos(numDiscos - 1, inicio, fin, intermedio);
            System.out.println("Mover disco de " + inicio + " a " + fin);
            moverDiscos(numDiscos - 1, intermedio, inicio, fin);
        }
    }

    public static void intercambiar(int[] aux, int i, int j) {
        int temp = aux[i];
        aux[i] = aux[j];
        aux[j] = temp;
    }

    private static int particion(int[] aux, int inicio, int fin, int pivote) {
        int derecha = inicio;
        int izquierda = fin - 1;
        while (derecha <= izquierda) {
            while (aux[derecha] < pivote) {
                derecha++;
            }

            while (aux[izquierda] >= pivote) {
                izquierda--;
            }
            if (derecha < izquierda) {
                intercambiar(aux, derecha, izquierda);
            }

        }

        return derecha;
    }

    public static int buscaPivote(int[] aux, int inicio, int fin) {
        int primer = aux[inicio];
        int k = inicio + 1;
        while (k <= fin) {
            if (aux[k] > primer) {
                return k;
            } else if (aux[k] < primer) {
                return inicio;
            } else {
                k++;
            }
        }
        return -1;
    }

}
