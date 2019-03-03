package me.lukas81298.jdecompile.bytecode.cp.item;

import lombok.Getter;
import me.lukas81298.jdecompile.DecompileException;
import me.lukas81298.jdecompile.bytecode.cp.ConstantPool;
import me.lukas81298.jdecompile.bytecode.cp.ConstantPoolItem;
import me.lukas81298.jdecompile.bytecode.io.ByteCodeReader;

import java.io.IOException;

/**
 * @author lukas
 * @since 02.03.2019
 */
public class ConstantInteger extends ConstantPoolItem {

    @Getter
    private int value;

    public ConstantInteger( ConstantPool constantPool ) {
        super( constantPool );
    }

    @Override
    public void read( ByteCodeReader reader ) throws IOException {
        this.value = reader.readInt();
    }

    @Override
    public String asString() {
        return Integer.toString( this.value );
    }

    @Override
    public byte getSize() {
        return 2;
    }
}
