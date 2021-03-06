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

package org.cloudfoundry.operations.organizationadmin;

import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

/**
 * The request options for the create quota operation
 */
@Value.Immutable
abstract class _CreateQuotaRequest {

    /**
     * The allow paid service plans flag
     */
    @Nullable
    abstract Boolean getAllowPaidServicePlans();

    /**
     * The instance memory limit
     */
    @Nullable
    abstract Integer getInstanceMemoryLimit();

    /**
     * The memory limit
     */
    @Nullable
    abstract Integer getMemoryLimit();

    /**
     * The name
     */
    abstract String getName();

    /**
     * The total routes
     */
    @Nullable
    abstract Integer getTotalRoutes();

    /**
     * The total services
     */
    @Nullable
    abstract Integer getTotalServices();

}
