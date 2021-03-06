package me.lukas81298.jdecompile.bytecode.instruction.spec;

import me.lukas81298.jdecompile.DecompileException;
import me.lukas81298.jdecompile.SourceCodeWriter;
import me.lukas81298.jdecompile.bytecode.cp.item.ConstantClass;
import me.lukas81298.jdecompile.bytecode.instruction.*;

import java.util.Stack;

/**
 * @author lukas
 * @since 06.03.2019
 */
public class InstanceOfSpec extends InstructionSpec {

    public InstanceOfSpec( String mnemonic, int typeId, int dataLen ) {
        super( mnemonic, typeId, dataLen );
    }

    @Override
    public void process( int level, Instruction instruction, Stack<Operand> stack, SourceCodeWriter writer, Context context ) throws DecompileException {
        String className = (( ConstantClass)context.getConstantPool().getItem( instruction.getUnsignedShort( 0 ) ) ).getClassName();
        stack.push( new Operand( OperandType.BOOLEAN, stack.pop().getValue() + " instanceof " + className ) );
    }
}
