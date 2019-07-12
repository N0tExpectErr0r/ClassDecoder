package cp_info.bean;

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
}
