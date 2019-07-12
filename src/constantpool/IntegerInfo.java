package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class IntegerInfo extends CpInfo {
    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        value = in.readInt();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "\t"+value;
    }
}