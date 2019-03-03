package me.lukas81298.jdecompile.bytecode.instruction;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import lombok.Getter;
import me.lukas81298.jdecompile.bytecode.instruction.spec.*;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lukas
 * @since 03.03.2019
 */
public class InstructionTable {

    @Getter
    private final static InstructionTable instance = new InstructionTable();

    private final TIntObjectMap<InstructionSpec> instructions = new TIntObjectHashMap<>();

    public InstructionTable() {
        this.register( "nop", 0x00, 0, NopSpec.class );
        this.register( "aconst_null", 0x01, 0, ConstSpec.class, "null", OperandType.REFERENCE );

        this.register( "iconst_m1", 0x02, 0, ConstSpec.class, -1, OperandType.INT );
        // 0x03 to 0x08
        for ( int i = 0; i <= 5; i++ ) {
            this.register( "iconst_" + i, 0x03 + i, 0, ConstSpec.class, i, OperandType.INT );
        }
        for ( long l = 0L; l <= 1; l++ ) {
            this.register( "lconst_" + l, (int) (0x09 + l), 0, ConstSpec.class, l, OperandType.LONG );
        }
        for ( float f = 0L; f <= 2; f++ ) {
            this.register( "fconst_" + (int) f, (int) (0x11 + f), 0, ConstSpec.class, f, OperandType.FLOAT );
        }

        this.register( "iload", 0x15, 1, LoadSpec.class );
        this.register( "lload", 0x16, 1, LoadSpec.class );
        this.register( "fload", 0x17, 1, LoadSpec.class );
        this.register( "dload", 0x18, 1, LoadSpec.class );
        this.register( "aload", 0x19, 1, LoadSpec.class );

        this.register( "iload_0", 0x1a, 0, LoadSpec.LoadSpecShort.class, 0 );
        this.register( "iload_1", 0x1b, 0, LoadSpec.LoadSpecShort.class, 1 );
        this.register( "iload_2", 0x1c, 0, LoadSpec.LoadSpecShort.class, 2 );
        this.register( "iload_3", 0x1d, 0, LoadSpec.LoadSpecShort.class, 3 );

        this.register( "lload_0", 0x1e, 0, LoadSpec.LoadSpecShort.class, 0 );
        this.register( "lload_1", 0x1f, 0, LoadSpec.LoadSpecShort.class, 1 );
        this.register( "lload_2", 0x20, 0, LoadSpec.LoadSpecShort.class, 2 );
        this.register( "lload_3", 0x21, 0, LoadSpec.LoadSpecShort.class, 3 );

        this.register( "fload_0", 0x22, 0, LoadSpec.LoadSpecShort.class, 0 );
        this.register( "fload_1", 0x23, 0, LoadSpec.LoadSpecShort.class, 1 );
        this.register( "fload_2", 0x24, 0, LoadSpec.LoadSpecShort.class, 2 );
        this.register( "fload_3", 0x25, 0, LoadSpec.LoadSpecShort.class, 3 );

        this.register( "dload_0", 0x26, 0, LoadSpec.LoadSpecShort.class, 0 );
        this.register( "dload_1", 0x27, 0, LoadSpec.LoadSpecShort.class, 1 );
        this.register( "dload_2", 0x28, 0, LoadSpec.LoadSpecShort.class, 2 );
        this.register( "dload_3", 0x29, 0, LoadSpec.LoadSpecShort.class, 3 );

        this.register( "aload_0", 0x2a, 0, LoadSpec.LoadSpecShort.class, 0 );
        this.register( "aload_1", 0x2b, 0, LoadSpec.LoadSpecShort.class, 1 );
        this.register( "aload_2", 0x2c, 0, LoadSpec.LoadSpecShort.class, 2 );
        this.register( "aload_3", 0x2d, 0, LoadSpec.LoadSpecShort.class, 3 );

        this.register( "aaload", 0x32, 1, AaloadSpec.class );

        this.register( "istore", 0x36, 1, StoreSpec.class );
        this.register( "lstore", 0x37, 1, StoreSpec.class );
        this.register( "fstore", 0x38, 1, StoreSpec.class );
        this.register( "dstore", 0x39, 1, StoreSpec.class );
        this.register( "astore", 0x3a, 1, StoreSpec.class );

        this.register( "istore_0", 0x3b, 0, StoreSpec.StoreSpecShort.class, 0 );
        this.register( "istore_1", 0x3c, 0, StoreSpec.StoreSpecShort.class, 1 );
        this.register( "istore_2", 0x3d, 0, StoreSpec.StoreSpecShort.class, 2 );
        this.register( "istore_3", 0x3e, 0, StoreSpec.StoreSpecShort.class, 3 );

        this.register( "lstore_0", 0x3f, 0, StoreSpec.StoreSpecShort.class, 0 );
        this.register( "lstore_1", 0x40, 0, StoreSpec.StoreSpecShort.class, 1 );
        this.register( "lstore_2", 0x41, 0, StoreSpec.StoreSpecShort.class, 2 );
        this.register( "lstore_3", 0x42, 0, StoreSpec.StoreSpecShort.class, 3 );

        this.register( "fstore_0", 0x43, 0, StoreSpec.StoreSpecShort.class, 0 );
        this.register( "fstore_1", 0x44, 0, StoreSpec.StoreSpecShort.class, 1 );
        this.register( "fstore_2", 0x45, 0, StoreSpec.StoreSpecShort.class, 2 );
        this.register( "fstore_3", 0x46, 0, StoreSpec.StoreSpecShort.class, 3 );

        this.register( "dstore_0", 0x47, 0, StoreSpec.StoreSpecShort.class, 0 );
        this.register( "dstore_1", 0x48, 0, StoreSpec.StoreSpecShort.class, 1 );
        this.register( "dstore_2", 0x49, 0, StoreSpec.StoreSpecShort.class, 2 );
        this.register( "dstore_3", 0x4a, 0, StoreSpec.StoreSpecShort.class, 3 );

        this.register( "astore_0", 0x4b, 0, StoreSpec.StoreSpecShort.class, 0 );
        this.register( "astore_1", 0x4c, 0, StoreSpec.StoreSpecShort.class, 1 );
        this.register( "astore_2", 0x4d, 0, StoreSpec.StoreSpecShort.class, 2 );
        this.register( "astore_3", 0x4e, 0, StoreSpec.StoreSpecShort.class, 3 );


        this.register( "arraylength", 0xBE, 0, ArrayLengthSpec.class );


    }

    public void register( String mnemonic, int id, int len, Class<? extends InstructionSpec> clazz, Object... args ) {
        Class<?>[] types = new Class[3 + args.length];
        Object[] values = new Object[3 + args.length];
        types[0] = String.class;
        types[1] = int.class;
        types[2] = int.class;
        values[0] = mnemonic;
        values[1] = id;
        values[2] = len;
        for ( int i = 0; i < args.length; i++ ) {
            types[3 + i] = args[i].getClass();
            values[3 + i] = args[i];
        }
        try {
            this.instructions.put( id, clazz.getDeclaredConstructor( types ).newInstance( values ) );
        } catch ( InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e ) {
            e.printStackTrace();
        }

    }

    public InstructionSpec getSpec( int type ) {
        return this.instructions.get( type );
    }
}
