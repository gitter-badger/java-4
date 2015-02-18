package io.v.core.veyron2.vom;

import com.google.common.collect.ImmutableMap;

import io.v.core.veyron2.vdl.Types;
import io.v.core.veyron2.vdl.VdlType;

import java.util.Map;

/**
 * BootstrapType provides the set of known bootstrap type ids and their
 * corresponding VDL Type.
 */
public final class BootstrapType {
    private static final Map<VdlType, TypeID> typeToId;
    private static final Map<TypeID, VdlType> idToType;

    static {
        typeToId = ImmutableMap.<VdlType, TypeID>builder()
                // Primitive types.
                .put(Types.BOOL, Constants.WIRE_ID_BOOL)
                .put(Types.BYTE, Constants.WIRE_ID_BYTE)
                .put(Types.STRING, Constants.WIRE_ID_STRING)
                .put(Types.UINT16, Constants.WIRE_ID_UINT_16)
                .put(Types.UINT32, Constants.WIRE_ID_UINT_32)
                .put(Types.UINT64, Constants.WIRE_ID_UINT_64)
                .put(Types.INT16, Constants.WIRE_ID_INT_16)
                .put(Types.INT32, Constants.WIRE_ID_INT_32)
                .put(Types.INT64, Constants.WIRE_ID_INT_64)
                .put(Types.FLOAT32, Constants.WIRE_ID_FLOAT_32)
                .put(Types.FLOAT64, Constants.WIRE_ID_FLOAT_64)
                .put(Types.COMPLEX64, Constants.WIRE_ID_COMPLEX_64)
                .put(Types.COMPLEX128, Constants.WIRE_ID_COMPLEX_128)
                .put(Types.TYPEOBJECT, Constants.WIRE_ID_TYPE_OBJECT)
                .put(Types.ANY, Constants.WIRE_ID_ANY)

                // Other commonly used composites.
                .put(Types.listOf(Types.BYTE), Constants.WIRE_ID_BYTE_LIST)
                .put(Types.listOf(Types.STRING), Constants.WIRE_ID_STRING_LIST)
                .build();

        ImmutableMap.Builder<TypeID, VdlType> idToTypeBuilder =
                ImmutableMap.<TypeID, VdlType>builder();
        for (Map.Entry<VdlType, TypeID> typeToIdEntry : typeToId.entrySet()) {
            idToTypeBuilder.put(typeToIdEntry.getValue(), typeToIdEntry.getKey());
        }
        idToType = idToTypeBuilder.build();
    }

    /**
     * Returns type corresponding to provided bootstrap type id
     *
     * @param typeId the typeId whose type is to be returned
     * @return a {@code VdlType} object or null if provided type id has no associated bootstrap type
     */
    public static VdlType getBootstrapType(TypeID typeId) {
        return idToType.get(typeId);
    }

    /**
     * Returns type id corresponding to provided bootstrap type.
     *
     * @param type the type whose type id is to be returned
     * @return a {@code TypeID} object or null if provided type is not a bootstrap type
     */
    public static TypeID getBootstrapTypeId(VdlType type) {
        return typeToId.get(type);
    }
}
