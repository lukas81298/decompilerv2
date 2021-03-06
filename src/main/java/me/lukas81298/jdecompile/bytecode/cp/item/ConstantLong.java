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
@Getter
public class ConstantLong extends ConstantPoolItem {

    private long value;

    public ConstantLong( ConstantPool constantPool ) {
        super( constantPool );
    }

    @Override
    public void read( ByteCodeReader reader ) throws IOException {
        this.value = reader.readLong();
    }

    @Override
    public String asString() {
        return Long.toString( this.value ) + "L";
    }

}
