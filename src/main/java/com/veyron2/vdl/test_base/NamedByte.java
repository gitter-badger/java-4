
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;

/**
 * type NamedByte byte 
 **/
public final class NamedByte implements android.os.Parcelable, java.io.Serializable, com.google.gson.TypeAdapterFactory {
    private byte value;

    public NamedByte(byte value) {
        this.value = value;
    }
    public byte getValue() { return this.value; }

    public void setValue(byte value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final com.veyron2.vdl.test_base.NamedByte other = (com.veyron2.vdl.test_base.NamedByte)obj;
        
        
        return this.value == other.value;
         
         
    }
    @Override
    public int hashCode() {
        return (int)value;
    }
    @Override
    public int describeContents() {
    	return 0;
    }
    @Override
    public void writeToParcel(android.os.Parcel out, int flags) {
   		com.veyron2.vdl.ParcelUtil.writeValue(out, value);
    }
	public static final android.os.Parcelable.Creator<NamedByte> CREATOR
		= new android.os.Parcelable.Creator<NamedByte>() {
		@Override
		public NamedByte createFromParcel(android.os.Parcel in) {
			return new NamedByte(in);
		}
		@Override
		public NamedByte[] newArray(int size) {
			return new NamedByte[size];
		}
	};
	private NamedByte(android.os.Parcel in) {
		value = (byte) com.veyron2.vdl.ParcelUtil.readValue(in, getClass().getClassLoader(), value);
	}

	public NamedByte() {}  // Used for instantiating a TypeAdapterFactory.

	@Override
	public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> type) {
		if (!type.equals(new com.google.gson.reflect.TypeToken<NamedByte>(){})) {
			return null;
		}
		final com.google.gson.TypeAdapter<java.lang.Byte> delegate = gson.getAdapter(new com.google.gson.reflect.TypeToken<java.lang.Byte>() {});
		return new com.google.gson.TypeAdapter<T>() {
			@Override
			public void write(com.google.gson.stream.JsonWriter out, T value) throws java.io.IOException {
				delegate.write(out, ((NamedByte) value).getValue());
			}
			@Override
			public T read(com.google.gson.stream.JsonReader in) throws java.io.IOException {
				return (T) new NamedByte(delegate.read(in));
			}
		};
	}
}
