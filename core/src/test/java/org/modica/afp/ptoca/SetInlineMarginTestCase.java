/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.modica.afp.ptoca;

import org.junit.Before;
import org.junit.Test;
import org.modica.afp.modca.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Test case for {@link SetInlineMargin}.
 */
public class SetInlineMarginTestCase extends ControlSequenceTestCase<SetInlineMargin> {

    private SetInlineMargin sut;

    @Before
    public void setUp() {
        Parameters params = new Parameters(new byte[] { 0x7F, 0x00 });
        ControlSequenceIdentifier expectedCsId = ControlSequenceIdentifier.SET_INLINE_MARGIN;
        int length = 4;
        boolean isChained = true;

        sut = new SetInlineMargin(expectedCsId, length, isChained, params);
        setMembers(sut, expectedCsId, isChained, length);
    }

    @Test
    public void testGetterMethods() {
        assertEquals(0x7F00, sut.getDisplacement());

        assertEquals("move 32512", sut.getValueAsString());
    }
}
