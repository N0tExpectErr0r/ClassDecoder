package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class FloatInfo extends CpInfo {
    private float value;

    public float getValue() {
        return value;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        value = in.readFloat();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        return "FloatInfo\t"+value;
    }
}
