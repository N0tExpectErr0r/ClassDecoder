package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleInfo extends CpInfo {
    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        value = in.readDouble();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "\t"+value;
    }
}
