package me.lukas81298.jdecompile.bytecode.cp.item;

import me.lukas81298.jdecompile.DecompileException;
import me.lukas81298.jdecompile.bytecode.cp.ConstantPool;
import me.lukas81298.jdecompile.bytecode.cp.ConstantPoolItem;
import me.lukas81298.jdecompile.bytecode.io.ByteCodeReader;

import java.io.IOException;

/**
 * @author lukas
 * @since 02.03.2019
 */
public class ConstantString extends ConstantPoolItem {

    private int index;

    public ConstantString( ConstantPool constantPool ) {
        super( constantPool );
    }

    @Override
    public void read( ByteCodeReader reader ) throws DecompileException, IOException {
        this.index = reader.readUnsignedShort();
    }

    public String getValue() throws DecompileException {
        return this.constantPool.getUtf8( this.index );
    }

    @Override
    public String asString() throws DecompileException {
        return this.getValue();
    }
}
