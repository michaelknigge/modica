package org.modica.afp.modca.triplets;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.modica.afp.modca.ParameterAsString;
import org.modica.afp.modca.Parameters;
import org.modica.afp.modca.triplets.ResourceLocalId;
import org.modica.afp.modca.triplets.ResourceLocalId.ResourceType;
import org.modica.common.ByteUtils;

/**
 * Test case for {@link ResourceLocalId}.
 */
public class ResourceLocalIdTestCase extends TripletTestCase<ResourceLocalId> {
    private ResourceLocalId x;

    @Before
    @Override
    public void setUp() {
        byte[] data = new byte[] { 0x00, 0x02, 0x03 };
        x = new ResourceLocalId(new Parameters(data, "Cp500"));
        ResourceLocalId y = new ResourceLocalId(new Parameters(data, "Cp500"));
        ResourceLocalId z = new ResourceLocalId(new Parameters(data, "Cp500"));
        Parameters params = new Parameters(data, "Cp500");
        params.skip(1);
        ResourceLocalId notEqual = new ResourceLocalId(params);

        setXYZ(x, y, z, notEqual);
    }

    @Test
    public void testGetterMethods() {
        testResourceType((byte) 0x00, ResourceType.USAGE_DEPENDENT);
        testResourceType((byte) 0x02, ResourceType.PAGE_OVERLAY);
        testResourceType((byte) 0x05, ResourceType.CODED_FONT);
        testResourceType((byte) 0x07, ResourceType.COLOR_ATTRIBUTE_TABLE);
    }

    private void testResourceType(byte typeId, ResourceType type) {
        byte[] data = new byte[] { typeId, 0x01 };
        ResourceLocalId testSubject = new ResourceLocalId(new Parameters(data, "Cp500"));
        assertEquals(type, testSubject.getResourceType());
    }

    @Test
    @Override
    public void testGetParameters() {
        List<ParameterAsString> expectedParams = new ArrayList<ParameterAsString>();
        expectedParams.add(new ParameterAsString("ResourceType", x.getResourceType()));
        expectedParams.add(new ParameterAsString("ResourceLocalId",
                ByteUtils.bytesToHex(x.getResourceLocalId())));
        parameterTester(expectedParams, x);
    }
}