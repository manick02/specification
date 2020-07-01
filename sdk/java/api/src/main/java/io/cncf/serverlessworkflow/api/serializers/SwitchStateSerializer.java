/*
 * Copyright 2020-Present The Serverless Workflow Specification Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.cncf.serverlessworkflow.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.cncf.serverlessworkflow.api.states.DefaultState;
import io.cncf.serverlessworkflow.api.states.SwitchState;

import java.io.IOException;

public class SwitchStateSerializer extends StdSerializer<SwitchState> {

    public SwitchStateSerializer() {
        this(SwitchState.class);
    }

    protected SwitchStateSerializer(Class<SwitchState> t) {
        super(t);
    }

    @Override
    public void serialize(SwitchState switchState,
                          JsonGenerator gen,
                          SerializerProvider provider) throws IOException {

        // set defaults for end state
        switchState.setType(DefaultState.Type.SWITCH);

        // serialize after setting default bean values...
        BeanSerializerFactory.instance.createSerializer(provider,
                TypeFactory.defaultInstance().constructType(SwitchState.class)).serialize(switchState,
                gen,
                provider);
    }
}