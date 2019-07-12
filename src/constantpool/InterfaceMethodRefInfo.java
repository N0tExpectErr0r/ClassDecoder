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
        ClazzInfo clazzInfo = (ClazzInfo) constantPool[clazzIndex-1];
        short clazzNameIndex = clazzInfo.getNameIndex();
        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) constantPool[nameAndTypeIndex-1];
        short nameIndex = nameAndTypeInfo.getNameIndex();
        short descriptorIndex = nameAndTypeInfo.getDescriptorIndex();
        return "InterfaceMethodRefInfo\t#"+clazzIndex+".#"+nameAndTypeIndex+"\t// "+constantPool[clazzNameIndex-1]+"."+constantPool[nameIndex-1]+":"+constantPool[descriptorIndex-1];
    }
}
