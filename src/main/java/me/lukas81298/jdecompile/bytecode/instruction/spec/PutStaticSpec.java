package me.lukas81298.jdecompile.bytecode.instruction.spec;

import me.lukas81298.jdecompile.DecompileException;
import me.lukas81298.jdecompile.SourceCodeWriter;
import me.lukas81298.jdecompile.bytecode.cp.item.AbstractConstantRef;
import me.lukas81298.jdecompile.bytecode.instruction.Context;
import me.lukas81298.jdecompile.bytecode.instruction.Instruction;
import me.lukas81298.jdecompile.bytecode.instruction.InstructionSpec;
import me.lukas81298.jdecompile.bytecode.instruction.Operand;

import java.util.Objects;
import java.util.Stack;

/**
 * @author lukas
 * @since 06.03.2019
 */
public class PutStaticSpec extends InstructionSpec {

    public PutStaticSpec( String mnemonic, int typeId, int dataLen ) {
        super( mnemonic, typeId, dataLen );
    }

    @Override
    public void process( int level, Instruction instruction, Stack<Operand> stack, SourceCodeWriter writer, Context context ) throws DecompileException {
        AbstractConstantRef.ConstantFieldRef fieldRef = context.getConstantPool().getItem( instruction.getUnsignedShort( 0 ) );
        writer.writeln( level, context.getLineNumber( instruction ),writer.formatClassName( fieldRef.getClassInfo().getClassName() ) + "." + fieldRef.getNameAndType().getName() + " = " +
                writer.removeBrackets( Objects.toString( stack.pop().getValue() ) ) + ";" );
    }
}
