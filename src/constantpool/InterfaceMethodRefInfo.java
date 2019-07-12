package constantpool;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfaceMethodRefInfo extends CpInfo {
    private short clazzIndex;
    private short nameAndTypeIndex;

    public short getClazzIndex() {
        return clazzIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        clazzIndex = in.readShort();
        nameAndTypeIndex = in.readShort();
    }

    @Override
    public String toString(CpInfo[] constantPool) {
        ClazzInfo clazzInfo = (ClazzInfo) constantPool[clazzIndex];
        short clazzNameIndex = clazzInfo.getNameIndex();
        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) constantPool[nameAndTypeIndex];
        short nameIndex = nameAndTypeInfo.getNameIndex();
        short descriptorIndex = nameAndTypeInfo.getDescriptorIndex();
        return "\t#"+clazzIndex+".#"+nameAndTypeIndex+"\t//"+constantPool[clazzNameIndex]+" "+constantPool[nameIndex]+" "+constantPool[descriptorIndex];
    }
}
