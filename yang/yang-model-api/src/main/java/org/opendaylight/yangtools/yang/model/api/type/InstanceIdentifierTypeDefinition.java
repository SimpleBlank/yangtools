/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.model.api.type;

import java.util.Objects;

/**
 * Contains methods for getting data from the <code>instance-identifier</code> YANG built-in type.
 */
public interface InstanceIdentifierTypeDefinition
        extends RequireInstanceRestrictedTypeDefinition<InstanceIdentifierTypeDefinition> {
    static int hashCode(final InstanceIdentifierTypeDefinition type) {
        return Objects.hash(type.getPath(), type.getUnknownSchemaNodes(), type.getBaseType(),
            type.getUnits().orElse(null), type.getDefaultValue().orElse(null), type.requireInstance());
    }

    static boolean equals(final InstanceIdentifierTypeDefinition type, final Object obj) {
        if (type == obj) {
            return true;
        }

        final InstanceIdentifierTypeDefinition other = TypeDefinitions.castIfEquals(
            InstanceIdentifierTypeDefinition.class, type, obj);
        return other != null && type.requireInstance() == other.requireInstance();
    }

    static String toString(final InstanceIdentifierTypeDefinition type) {
        return TypeDefinitions.toStringHelper(type).add("requireInstance", type.requireInstance()).toString();
    }
}
