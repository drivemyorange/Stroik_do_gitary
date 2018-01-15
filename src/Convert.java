import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;


// klasa convert w której znajdują się metody do zamieniania byte array na double array
public class Convert {

    public static double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE / Byte.SIZE;
        double[] doubles = new double[byteArray.length / times];
        for(int i=0;i<doubles.length;i++){
            doubles[i] = ByteBuffer.wrap(byteArray, i*times, times).getDouble();
        }
        return doubles;
    }

    public static double[] toDoubleA(byte[] byteArray){
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        double[] result = new double[doubleBuffer.remaining()];
        doubleBuffer.get(result);
        return result;
    }
}
