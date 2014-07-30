// This file was auto-generated by the veyron vdl tool.
// Source: types.vdl

package com.veyron2.storage;

/**
 * type ID [16]byte 
 * ID is the type of keys for the key/value store.  The key is a numeric
 * identifier that is globally unique, meaning that if two stores contain an
 * entry with the same ID, then the entries represent the same thing.  To
 * ensure uniqueness, stores create unique IDs that have never before been used
 * as identifier.  The ID is large enough that collisions are extremely
 * unlikely.
 **/
public final class ID implements java.util.List<java.lang.Byte> {
    private final static int length = 16;
    private com.veyron2.vdl.FixedLengthList<java.lang.Byte> impl;

    public ID(java.lang.Byte[] impl) {
        setValue(impl);
    }

    public java.lang.Byte[] getValue() {
        return impl.getBackingArray();
    }

    public void setValue(java.lang.Byte[] arr) {
        if (arr.length != length) {
            throw new IllegalArgumentException("Invalid length " + length + " expected "
                    + arr.length);
        }
        this.impl = new com.veyron2.vdl.FixedLengthList<java.lang.Byte>(arr);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final ID other = (ID) obj;
        if (!(this.impl.equals(other.impl)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (impl == null) ? 0 : impl.hashCode();
    }

    @Override
    public void add(int location, java.lang.Byte object) {
        impl.add(location, object);
    }

    @Override
    public boolean add(java.lang.Byte object) {
        return impl.add(object);
    }

    @Override
    public boolean addAll(int location, java.util.Collection<? extends java.lang.Byte> collection) {
        return impl.addAll(location, collection);
    }

    @Override
    public boolean addAll(java.util.Collection<? extends java.lang.Byte> collection) {
        return impl.addAll(collection);
    }

    @Override
    public void clear() {
        impl.clear();
    }

    @Override
    public boolean contains(java.lang.Object object) {
        return impl.contains(object);
    }

    @Override
    public boolean containsAll(java.util.Collection<?> collection) {
        return impl.containsAll(collection);
    }

    @Override
    public java.lang.Byte get(int location) {
        return impl.get(location);
    }

    @Override
    public int indexOf(java.lang.Object object) {
        return impl.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return impl.isEmpty();
    }

    @Override
    public java.util.Iterator<java.lang.Byte> iterator() {
        return impl.iterator();
    }

    @Override
    public int lastIndexOf(java.lang.Object object) {
        return impl.lastIndexOf(object);
    }

    @Override
    public java.util.ListIterator<java.lang.Byte> listIterator() {
        return impl.listIterator();
    }

    @Override
    public java.util.ListIterator<java.lang.Byte> listIterator(int location) {
        return impl.listIterator(location);
    }

    @Override
    public java.lang.Byte remove(int location) {
        return impl.remove(location);
    }

    @Override
    public boolean remove(java.lang.Object object) {
        return impl.remove(object);
    }

    @Override
    public boolean removeAll(java.util.Collection<?> collection) {
        return impl.removeAll(collection);
    }

    @Override
    public boolean retainAll(java.util.Collection<?> collection) {
        return impl.retainAll(collection);
    }

    @Override
    public java.lang.Byte set(int location, java.lang.Byte object) {
        return impl.set(location, object);
    }

    @Override
    public int size() {
        return impl.size();
    }

    @Override
    public java.util.List<java.lang.Byte> subList(int start, int end) {
        return impl.subList(start, end);
    }

    @Override
    public java.lang.Object[] toArray() {
        return impl.toArray();
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return impl.toArray(array);
    }
}
