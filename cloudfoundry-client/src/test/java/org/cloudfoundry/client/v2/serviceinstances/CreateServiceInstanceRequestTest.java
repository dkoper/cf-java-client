/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.serviceinstances;


import org.junit.Test;

public final class CreateServiceInstanceRequestTest {

    @Test(expected = IllegalStateException.class)
    public void noName() {
        CreateServiceInstanceRequest.builder()
            .servicePlanId("service-plan-id")
            .spaceId("space-id")
            .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noServicePlanId() {
        CreateServiceInstanceRequest.builder()
            .name("name")
            .spaceId("space-id")
            .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noSpaceId() {
        CreateServiceInstanceRequest.builder()
            .name("name")
            .servicePlanId("service-plan-id")
            .build();
    }

    @Test
    public void valid() {
        CreateServiceInstanceRequest.builder()
            .name("name")
            .servicePlanId("service-plan-id")
            .spaceId("space-id")
            .build();
    }

}