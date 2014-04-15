/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.arquillian.spacelift.tool;

import java.util.List;

import org.arquillian.spacelift.process.Command;
import org.arquillian.spacelift.process.CommandBuilder;
import org.arquillian.spacelift.process.ProcessExecutor;
import org.arquillian.spacelift.process.ProcessInteraction;

/**
 * Representation of the tool that requires an external command to do the work.
 *
 * @see Command
 * @see CommandBuilder
 * @see ProcessExecutor
 *
 * @author <a href="kpiwko@redhat.com">Karel Piwko</a>
 *
 * @param <TOOLTYPE> Type of the tool
 */
public interface ExternalTool<TOOLTYPE extends ExternalTool<TOOLTYPE>> extends Tool<TOOLTYPE> {

    /**
     * Adds a list of parameters to the command under construction, ignoring null and empty parameters.
     *
     * @param parameters parameters we are adding to the already existing list
     * @return instance of this {@link CommandBuilder}
     */
    public TOOLTYPE parameters(List<? extends CharSequence> parameters);

    /**
     * Adds parameters to the command under construction, ignoring null and empty parameters.
     *
     * @param parameters
     * @return instance of this {@link CommandBuilder}
     */
    public TOOLTYPE parameters(CharSequence... parameters);

    /**
     * Adds a parameter to the command under construction, ignoring null and empty parameter.
     *
     * @param parameter parameter to add to the command list
     * @return instance of this {@link CommandBuilder}
     */
    public TOOLTYPE parameter(CharSequence parameter);

    /**
     * @param stringToBeParsed
     * @return instance of this {@link CommandBuilder}
     * @return instance of this {@link CommandBuilder}
     */
    public TOOLTYPE splitToParameters(CharSequence sequenceToBeParsed);

    /**
     * Builds so-far constructed command, any subsequent call of this method will build command starting from empty command
     * instance.
     *
     * @return built command
     */
    public Command build();

    /**
     * Returns a {@see ProcessInteraction} that defines how {@see ProcessExecution} is handled by default for a particular tool.
     *
     * @return
     */
    ProcessInteraction getInteraction();
}
