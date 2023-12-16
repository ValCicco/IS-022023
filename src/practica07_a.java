public class practica07_a {

    public static void main(String[] args) throws Exception {
        int num=7;
        int[] array = new int[num];
        array[0]=0;
        array[1]=2;
        array[2]=5;
        array[3]=7;
        array[4]=8;
        array[5]=3;
        array[6]=1;
        int z=3, i=0;

        while(i<num){
            if(array[i]==z){
                System.out.println("Se encontro "+z+" en la posicion "+i);
                return;
            }
            i++;
        }
    }

}