package org.afpparser.afp.modca.triplets;

import static org.junit.Assert.assertEquals;

import org.afpparser.common.ByteUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case for {@link ObjectAreaSize}.
 */
public class ObjectAreaSizeTestCase extends TripletTestCase<ObjectAreaSize> {

    private ObjectAreaSize x;

    @Before
    @Override
    public void setUp() {
        byte[] data = ByteUtils.createByteArray(2, 1, 2, 3, 4, 5, 6);
        x = new ObjectAreaSize(data, 0);
        ObjectAreaSize y = new ObjectAreaSize(data, 0);
        ObjectAreaSize z = new ObjectAreaSize(data, 0);

        data[1] = 2;
        ObjectAreaSize notEqual = new ObjectAreaSize(data, 0);

        setXYZ(x, y, z, notEqual);
    }

    @Test
    public void testGetterMethods() {
        assertEquals(0x10203, x.getXoaSize());
        assertEquals(0x40506, x.getYoaSize());
    }
}